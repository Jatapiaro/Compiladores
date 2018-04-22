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
prog:	(query)* ;
query: PREDICATE '(' (value)+ ').' | PREDICATE '(' (value)+ '):-' chain_query;
chain_query: PREDICATE '(' (value)+ '),' chain_query | PREDICATE '(' (value)+ ').';
value: VALUE | VALUE ',';

/*
* Lexer rules
* Palabras en mayúsculas que al darles un string
* ‘a pint of beer’, va a hacer match de ‘a’ a la
* regla de ARTICLE, ‘pint’ a DRINKING VESSEL,
* ‘of’ a OF y finalmente ‘beer’ a un texto,
* que puede tener cualquier letra en minúscula una o más veces.
*/
SPACE: ' ';
NEWLINE: [\r\n]+ ;
PREDICATE: (('a'..'z')+(STRING_LITERAL)*INTEGER*('_')?)((STRING_LITERAL)+INTEGER*('_')?)*;
STRING_LITERAL: ('a'..'z') | ('A'..'Z');
INTEGER: [0-9];
VALUE: (STRING_LITERAL)+[0-9]* | INTEGER+ | '_';
