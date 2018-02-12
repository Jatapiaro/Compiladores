grammar Gramm;


//Parser rules
prog: exprS;

exprS: zero exprR;
exprR: exprS one | one;
zero: ZERO;
one: ONE;

//Lexer rules
ZERO : '0';
ONE : '1';
NEWLINE : [\r\n]+ ;
