grammar IntegerToRoman;

//Parser rule
roman: unit | ten unit | hundred ten unit | thousand hundred ten unit;

thousand: THOUSAND;
hundred: NUMBER;
ten: NUMBER;
unit: NUMBER;

//Lexer rules
NUMBER : '0' | '1' | '2' | '3' | '4' | '5' | '6' | '7' | '8' | '9';
THOUSAND: '0' | '1' | '2' | '3';
