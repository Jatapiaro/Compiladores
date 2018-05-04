grammar ProSQL;

/*
* Parser rules
* Las reglas del parser, son aquellas que encontramos en camelCase,
* es decir cuando pasamos un string a nuestra gramática, y especificamos
* una regla de parser, esta actúa como punto de entrada (podemos definirla
* después cuál es la primera usando código). En este caso nuestra regla de
* entrada es drinkSentence. ‘a pint of beer’, por lo tanto todos los tokens
* son matcheados en la regla de drinkSentence y antlr puede reconocerlos.
*/
prog:	(predicate)* ;
predicate: query '.' | query ':-' (query ',')* query '.';
query: STATEMENT '(' (value)+ ')' | 'retract('STATEMENT '(' (value)+ '))';
value: VALUE | VALUE ',';

/*
* Lexer rules
*/
SPACE: ' ';
NEWLINE: [\r\n]+ ;
STATEMENT: (('a'..'z')+(STRING_LITERAL)*INTEGER*('_')?)((STRING_LITERAL)+INTEGER*('_')?)*;
STRING_LITERAL: ('a'..'z')(' ')? | ('_')?('A'..'Z')(' ')? | ('0'..'9')(' ')?;
INTEGER: [0-9];
VALUE: STRING_LITERAL+ | INTEGER+ | '_';
