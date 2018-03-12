#include <stdio.h>
#include "myscanner.h"

extern int yylex();
// Line number
extern int yylineno;
extern char* yytext;

/*
* Names
*/
char * names[] = {
    NULL,
    "db_type",
    "db_name",
    "db_table_prefix",
    "db_port"
};

int main(int argc, char const *argv[]) {

    int number_token, value_token;
    //Read scanner and return first valid token
    number_token = yylex();
    while ( number_token ) {

        printf("%d\n", number_token);

        if ( yylex() != COLON ) {
            printf("Syntax error in line %d, expected a ':' but found %s\n", yylineno, yytext);
            return 1; //Exit right away
        }

        value_token = yylex();
        switch ( number_token ) {
            case TYPE:
            case NAME:
            case TABLE_PREFIX:
                if ( value_token != IDENTIFIER ) {
                    printf("Syntax error in line %d, expected an identifier but found %s\n", yylineno, yytext);
                    return 1; //Exit right away
                }
                printf("%s is set to %s\n", names[number_token], yytext);
                break;
            case PORT:
                if ( value_token != INTEGER ) {
                    printf("Syntax error in line %d, expected an integer but found %s\n", yylineno, yytext);
                    return 1; //Exit right away
                }
                printf("%s is set to %s\n", names[number_token], yytext);
                break;
            default:
                printf("Syntax error in line %d\n", yylineno);
        }
        number_token = yylex();
    }
    return 0;
}
