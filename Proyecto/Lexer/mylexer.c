#include <stdio.h>
#include <stdlib.h>
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
    "Data",
    "Dot",
    "Coma",
    "Open parenthesis",
    "Predicate Name or Data",
    "Underscore",
    "Variable",
    "Rule"
};

void print_token_message( int type ) {
    printf("%d. %s => %s\n", type, names[type], yytext );
}

void print_error_message( char * expected ) {
    printf("Syntax error in line %d, expected a '%s' but found '%s'\n", yylineno, expected, yytext);
}

int main(int argc, char const *argv[]) {

    int number_token, open_parenthesis_token,
        data_token, close_parenthesis_token,
        coma_token, dot_token;
    int on_rule_enter = 0;
    //Read scanner and return first valid token
    number_token = yylex();

    while ( number_token ) {

        switch ( number_token ) {

            /*
            -----------------------------
            |                           |
            |    Predicate Case Start   |
            |                           |
            ----------------------------
            */
            case PREDICATE_NAME:

                print_token_message(number_token);

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
                */
                while( 1 ) {

                    if ( data_token == PREDICATE_NAME || data_token == VARIABLE || data_token == UNDERSCORE ) {
                        print_token_message(data_token);
                    } else {
                        print_error_message("data or variable");
                        exit(1);
                    }

                    coma_token = yylex();

                    if ( coma_token == COMA ) {
                        print_token_message(coma_token);
                        data_token = yylex();
                    } else {
                        close_parenthesis_token = coma_token;
                        if ( close_parenthesis_token != CLOSE_PARENTHESIS ) {
                            print_error_message(")");
                            exit(1);
                        }
                        print_token_message(close_parenthesis_token);
                        break;
                    }
                }

                dot_token = yylex();

                if ( on_rule_enter == 0 ) {

                    if( dot_token == DOT || dot_token == RULE ) {
                        on_rule_enter = ( dot_token == RULE )? 1 : 0;
                        print_token_message(dot_token);
                    } else {
                        print_error_message(". or :-");
                        exit(1);
                    }

                } else {
                    if ( dot_token == COMA || dot_token == DOT ) {
                        on_rule_enter = ( dot_token == DOT )? 0 : 1;
                        print_token_message(dot_token);
                    } else {
                        print_error_message(", or .");
                        exit(1);
                    }
                }

                break;
                /*
                -----------------------------
                |                           |
                |    Predicate Case End     |
                |                           |
                ----------------------------
                */
        }

        number_token = yylex();

    }

    if ( on_rule_enter ) {
        print_error_message("a predicate");
        exit(1);
    }

    return 0;
}
