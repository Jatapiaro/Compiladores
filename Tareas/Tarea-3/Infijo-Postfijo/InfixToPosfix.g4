grammar InfixToPosfix;

//Parser rules
prog: (expr NEWLINE)*;
expr: expr operation term
    | expr operation term
    | term;
term: NUMBER;
operation: OPERATION;

//Lexer rules
NUMBER : [0-9]+;
OPERATION : '+' | '-' | '*' | '/';
NEWLINE : [\r\n]+ ;
