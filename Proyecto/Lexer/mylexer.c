#include <stdio.h>
#include <stdlib.h>
#include <errno.h>
#include "mytokens.h"

extern int yylex();
// Line number
extern int yylineno;
extern char * yytext;

/*
* Names
*/
char * names[] = {
    "Close parenthesis",
    "Integer",
    "Dot",
    "Coma",
    "Open parenthesis",
    "Predicate Name or Data",
    "Underscore",
    "Variable",
    "Rule",
    "Greather than",
    "Less than",
    "Equal",
    "Equal or greather than",
    "Equal or less than",
    "Data",
    "Comment",
    "Retracct"
};

void print_token_message( int type ) {
    //printf("[%d, %s] => %s\n", type, names[type], yytext );
    printf("%s\n", yytext);
}

void print_error_message( char * expected ) {
    printf("Syntax error in line %d, expected a '%s' but found '%s'\n", yylineno, expected, yytext);
    fprintf(stderr, "Syntax error in line %d, expected a '%s' but found '%s'\n", yylineno, expected, yytext);
}

/*
* Validates if a predicate is correct
* @param int * on_rule_enter_pointer => This will help us to change a value
*   that told us if we need to check for a ':-' or '.' when this method ends.
* @param int first, if this is the first predicate.
    * Example some(a,b) could be followed by some(a,b). or some(a,b) :-
*/
void validate_predicate(int * on_rule_enter_pointer, int first) {

    /*
    * Include variables to use during this process
    */
    int number_token, open_parenthesis_token,
        data_token, close_parenthesis_token,
        coma_token, dot_token;

    int on_variable_enter = 0;

    /*
    * As this method enters when a predicate name is found
    * the next thing we should look is a '('
    */
    open_parenthesis_token = yylex();
    if ( open_parenthesis_token != OPEN_PARENTHESIS ) {
        print_error_message("(");
        exit(1);
    }
    print_token_message(open_parenthesis_token);

    /*
    * In this step we are looking for data or variable
    * inside a predicate
    */
    data_token = yylex();
    /*
    * As the data inside a predicate could be one or more
    * things, we need to validate that
    * example predicate( a, b, c, d )
    * that why we need to put everything that is inside the parenthesis
    * on a while loop
    */
    while( 1 ) {

        /*
        * We check if the next thing we read is
        * a 'predicatename' in case the input is some camelcase text
        * a 'variable', in which for practical reason in our lang will only accept _?UPPERCASE text
        * an 'underscore' to ignore that column at the query moment
        * an 'integer' if the input is an integer
        * a 'data' which will accept text that starts with Uppercase (complement to the predicate name case)
        */
        if ( data_token == PREDICATE_NAME || data_token == VARIABLE ||
                data_token == UNDERSCORE || data_token == INTEGER ||
                data_token == DATA ) {

            /*
            * In all these cases maybe we want to have some
            * logical validation so we in the next steps we are going to
            * check this cases
            */
            if ( data_token != UNDERSCORE ) {
                on_variable_enter = 1;
            }

            print_token_message(data_token);
        } else {
            print_error_message("data, integer, variable or underscore[ _ ]");
            exit(1);
        }


        /*
        * So after we found some data inside the predicate
        * we are looking for either a ',' or a ')'
        * The ',' will tell us to read more
        * The ')' mean the end of the data inside the predicate
        */
        coma_token = yylex();

        /*
        * but if we have a variable, maybe we want to check if there is some
        * logical validation
        */
        if ( on_variable_enter == 1 ) {

            if ( coma_token != COMA) {

                /*
                * If we found that after a variable is another thing
                * that is not a ',' but is a logical symbol
                */
                if ( coma_token == GREATER_THAN || coma_token == LESS_THAN ||
                    coma_token == EQUAL || coma_token == EQUAL_OR_GREATHER_THAN ||
                    coma_token == EQUAL_OR_LESS_THAN) {

                        print_token_message(coma_token);
                        coma_token = yylex();
                        /*
                        * We need to check that the following is an
                        * accepted comparsion element
                        */
                        if ( coma_token == PREDICATE_NAME || coma_token == VARIABLE ||
                            coma_token == INTEGER || coma_token == DATA ) {

                                print_token_message(coma_token);
                                coma_token = yylex();

                        } else {
                            print_error_message("data, integer or variable");
                            exit(1);
                        }

                }

            }
        }


        if ( coma_token == COMA ) {
            /*
            * If a ',' is found we just read the next value
            * to keep the while
            */
            print_token_message(coma_token);
            data_token = yylex();
        } else {
            /*
            * If we found something different from a ','
            * it is know that we are looking for a '('
            */
            close_parenthesis_token = coma_token;
            if ( close_parenthesis_token != CLOSE_PARENTHESIS ) {
                print_error_message(")");
                exit(1);
            }

            /*
            * So if it was a '(' we break the cycle
            */
            print_token_message(close_parenthesis_token);
            break;
        }
    }
    /*
    * If its the first predicate
    * then, we should look for ':-' or '.'
    */
    if ( first == 1 ) {
        //We change the value
        *on_rule_enter_pointer = 1;
    }

}

/*
* Validate the retract function
* @param int * on_rule_enter_pointer that indicates that (single)?
*   we must look for a '.' or ':-' at the end of the this method
* @param int single if this is a single retract or is inside a rule
*/
void validate_retract(int * on_rule_enter_pointer, int single) {

    /*
    * Include variables to use during this process
    */
    int number_token, open_parenthesis_token,
        data_token, close_parenthesis_token,
        coma_token, dot_token;

    /*
    * First we must look for '('
    * ex: retract(xxxx())
    */
    open_parenthesis_token = yylex();
    if ( open_parenthesis_token != OPEN_PARENTHESIS ) {
        print_error_message("(");
        exit(1);
    } else {
        print_token_message(open_parenthesis_token);
    }

    /*
    * We validate that inside is a valid predicate
    */
    number_token = yylex();
    if ( number_token == PREDICATE_NAME ) {
        print_token_message(number_token);
        validate_predicate(on_rule_enter_pointer, 0);
    } else {
        print_error_message("predicate");
    }

    close_parenthesis_token = yylex();
    if ( close_parenthesis_token != CLOSE_PARENTHESIS ) {
        print_error_message(")");
        exit(1);
    } else {
        print_token_message(close_parenthesis_token);
    }

    if ( single == 1 ) {
        *on_rule_enter_pointer = 1;
    }

}

int main(int argc, char const *argv[]) {

    int number_token, open_parenthesis_token,
        data_token, close_parenthesis_token,
        coma_token, dot_token;
    int on_rule_enter = 0;
    int on_variable_enter = 0;
    //Read scanner and return first valid token
    number_token = yylex();

    while ( number_token ) {

        switch ( number_token ) {

            case PREDICATE_NAME:
                /*
                * If we found a predicate and we are not looking for
                * a '.' or ':-'
                */
                if ( on_rule_enter == 0 ) {
                    print_token_message(number_token);
                    validate_predicate(&on_rule_enter, 1);
                } else {
                    print_error_message(". or :-");
                    exit(1);
                }

                break;

            case DOT:
                /*
                * If we found a '.' we need to verify that we are currently
                * expecting a dot.
                */
                if ( on_rule_enter == 1 ) {
                    on_rule_enter = 0;
                    print_token_message(number_token);
                } else {
                    print_error_message(".");
                    exit(1);
                }
                break;

            case COMMENT:
                print_token_message(number_token);
                break;

            case RETRACT:
                print_token_message(number_token);
                validate_retract(&on_rule_enter, 1);
                break;

            case RULE:

                if ( on_rule_enter == 0 ) {
                    print_error_message("a predicate");
                    exit(1);
                } else {
                    print_token_message(number_token);
                }
                /*
                * If we found a ':-' we need to start checking in a while
                * if the following elements are predicates
                */
                while( 1 ) {
                    number_token = yylex();
                    if ( number_token == PREDICATE_NAME ) {
                        print_token_message(number_token);
                        validate_predicate(&on_rule_enter, 0);
                    } else if ( number_token == RETRACT ) {
                        print_token_message(number_token);
                        validate_retract(&on_rule_enter, 0);
                    }else {
                        print_error_message("a predicate or retract");
                        exit(1);
                    }
                    /*
                    * If the execution of the function above is complete
                    * then we check the next element.
                    * If its a ',' there are more predicates to come
                    * else if we found somehing else probably its a '.'
                    */
                    coma_token = yylex();
                    if ( coma_token != COMA ) {
                        break;
                    } else {
                        print_token_message(coma_token);
                    }
                }

                if ( coma_token != DOT ) {
                    print_error_message(", or .");
                    exit(1);
                } else {
                    print_token_message(coma_token);
                }
                on_rule_enter = 0;
                break;

            default:
                /*
                * If a '.' or ':-' is expected
                * send error right away
                */
                if ( on_rule_enter == 1 ) {
                    on_rule_enter = 0;
                    print_error_message(". or :-");
                    exit(1);
                }
                break;

        }

        number_token = yylex();

    }

    if ( on_rule_enter ) {
        print_error_message("a predicate");
        exit(1);
    }

    return 0;
}
