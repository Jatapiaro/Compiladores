# Using lex
1. `lex file.l2`
2. `cc lex.yy.c -ll`
3. `./a.out`

#If you are using an external C file
1. Follow the steps above
2. `gcc your_c_file.c lex.yy.c -o output`

#Lex pattern examples
1. abc
2. [a-zA-Z]
3. `dog.*cat`
4. (ab)+
5. [^a-z]+ => don't accept lower case a-z
6. [+-]=[0-9]+ => One or more digits with optional prefix of + or -

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
