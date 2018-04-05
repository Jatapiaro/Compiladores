grammar Gramm;


//Parser rules
prog: expr NEWLINE;
expr: fraction operation expr | '(' fraction operation expr ')' (operation expr | ' ') | fraction;
fraction: FRACTION;
operation: OPERATION;

//Lexer rules
NUMBER : [0-9]+;
OPERATION: '+' | '-' | '*' | '/';
FRACTION: [0-9]+'%'[1-9]+;
NEWLINE : [\r\n]+ ;
