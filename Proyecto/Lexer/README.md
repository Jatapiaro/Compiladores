# To compile
1. `lex mylexer.l2`
2. `gcc mylexer.c lex.yy.c -o mylexer`
3. Para correr el programa `./mylexer < sample.txt`

# About
1. En mytokens.h definimos todos los tokens que actualmente soportamos.
2. En el archivo mylexer.c hacemos el proceso de las entradas
