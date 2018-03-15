# Para compilar y correr
1. `lex mylexer.l2`
2. `gcc mylexer.c lex.yy.c -o mylexer`
3. Para correr el programa `./mylexer < sample.txt`
4. En caso de que quieras la salida en otro archivo `./mylexer < sample.txt > output.txt`

# Equipo
1. Jacobo Misael Tapia de la Rosa - A01336590
2. Pablo Enríquez Escamilla - A01336386
3. Carlos Rogger Barcena - A01335167
4. Ricardo Raúl Salcedo Trejo - A01337828
5. José Ivander Shvartz Nógez - A01331933

# ¿Cómo funciona?
1. En mytokens.h definimos todos los tokens que actualmente soportamos.
2. En el archivo mylexer.c hacemos el proceso de las entradas
3. En nuestro lexer las variables solo pueden ser mayúsculas, permitiendo tener dentro
de los preicados cosas como predicado(Jaime, Duende).

# ¿Qué funciones soporta?
1. Actualmente soportamos predicados
    * Los
