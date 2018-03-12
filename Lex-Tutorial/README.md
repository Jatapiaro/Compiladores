# Using lex
1. `lex file.l2`
2. `cc lex.yy.c -ll`
3. `./a.out`


# Lenguage processing
1. Scanner (lexical analysis) => Token Stream
2. Parser (syntax analysis) => Parse tree
3. Semantic analysis and code generation => Abstract Syntax tree or other intermediate form
4. Machine-independent code (optional) => Modified intermediate form
5. Target code generation => Target Lenguage
6. Machine specific code => Modified target lenguage


# Lexical analysis
1. Take source code and produce a stream of tokens
2. This feed the Parser


# What is lex/flex?
1. Lex is a scanner generator
2. input a set of regex associated to actions
3. Output is a table-driven Scanner
4. Lex input
```
FIRST PART
%% <= this indicate start
patteern action
...
%% <= this indicate end
THIRD PART
```  
