grammar Expr;
prog:	expr;
expr:	factor op=('+'|'-'|'*'|'/') expr
    	|  factor;
//term: term oper=('*'|'/') factor
//	| factor;

factor: FRAC
    | '('expr')';

SUMA : '+';
RESTA: '-';
MULTIPLICACION : '*';
DIVISION: '/';
NEWLINE : [\r\n]+ ;
INT     : [0-9]+ ;
FRAC	: INT'%'[1-9][0-9]*;
