# ProSQL

Es un compilador que traduce sintaxis de Prolog a MSSQL.

### Como correrlo

  1. Desde la carpeta root del proyecto `cd Parser`
  2. Una vez en la carpeta `Parser` ejecutar `antlr4 ProSQL.g4`
  3. Posteriormente `javac *.java`
  4. Una vez que esto se haya hecho podemos empezar a probarlo
  5. Importante (pues no usamos algún IDE), para usar el jar `mssql-jdbc-6.2.2.jre8.jar`, nos vamos a la carpeta `/Library/Java/Extensions/`, dicha carpeta `Library` no es la que se encuentra en tu `/users/usuario/Library`, debes irte al root de tu computadora y usar ese `Library` para meter el jar.  

### Hacer pruebas

  1. Hay un archivo de muestra dentro de la carpeta parser
  2. El archivo se llama `sample.txt`
  3. Para ejecutar el resultado `java ProSql sample.txt`
  4. En dado caso que quieras usar tu propio archivo `java ProSql path/to/your/file`
  5. Si tu archivo tiene un error sintáctico, se desplegará en consola un mensaje similar a este: `Syntax error in line 1, expected a 'data, integer, variable or underscore[ _ ]' but found ')'`
  5. Importante, al ejecutar el comando, en caso de que el lexer no este compilado, el programa lo compilara para obtener los tokens y ejecutarse, por lo que no es necesario que compiles `mylexer.c` de la carpeta `Lexer` del proyecto.

### Funciones soportadas

  1. Insertar un nuevo elemento, o en dado caso de que este ya este insertado (utilizando las PK como referencia), se actualizará su información.
  2. Eliminar un registro utilizando `retract()`, por ejemplo `retract(estudiante(1336590, Jacobo Tapia, LSCA)).` En este punto se pretende actualizar para que no necesite todos los datos y se puede hacer eliminaciones como `retract(estudiante(1336590, _, _)).` Donde solo se necesita un parametro o dos para eliminar un registro.
  3. Consultas, por ejemplo `estudiante(_,_,LSCA)`, en donde cada `_` significa que es la columna que queremos seleccionar, y los elementos explicitos son aquellos con los que haremos el `WHERE column = element`.
  4. Encadenamiento de expresiones, es decir, si hay varias expresiones encadenadas, se ejecutará primero la última, y asi sucesivamente, y por lo tanto si una de ellas falla, las que siguen no se ejecutan, como en prolog.


### Equipo
  1. Jacobo Misael Tapia de la Rosa - A01336590
  2. Pablo Enríquez Escamilla - A01336386
  3. Carlos Rogger Barcena - A01335167
  4. Ricardo Raúl Salcedo Trejo - A01337828
  5. José Ivander Shvartz Nógez - A01331933