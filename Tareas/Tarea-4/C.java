import java.util.*;
import java.io.IOException;

/*
* S -> 0S1 | 01
* No podemos utilizar está gramática, pues tiene algunos inconvenientes
* El primero es que sería díficl hacer el look ahead, tendriamos que ver la posición actual, 
* y dos hacía adelante para detectar el cambio de 0's a 1's. 
* También tiene el problema de que debemos mantener un registro de cuantos 0's aparecieron 
* pues deben ser igual al número de 1's.
* Por lo tanto, sugerimos cambiar la gramática, de forma que siempre agregemos todos los 0's que necesitemos al
* principio, pero que al agregarlo podamos poner el 1 al final que lo complemente. Sin embargo antes del 1, vamos 
* a poner la recursión, para que siempre antes de cualqueir 1, se agrege un cero y sepamos como movernos.
* Por lo tanto la gramática quedaria como: 
* S -> 0R
* R -> S1 | 1
*/

public class C {

	char current;
	
	public void readChar() throws IOException, Exception {
		current = (char)System.in.read();
	}

	public void s() throws IOException, Exception {

		/*
		* Predecimos que todas deben empezar con 0,
		* si al inicio no hay un 0, la cadena está mal
		*/
		if ( current != '0' ) {
			throw new Exception("Cadena no válida, se esperaba 0");
		} else {
			readChar();
			r();
		}
		

	}

	public void r() throws IOException, Exception {

		/*
		* Tratamos de predecir que se tuvo que haber leido un 0
		* si se leyo, entonces quiere decir que tenemos que ejecutar S
		*/
		if ( current == '0' ) {

			s();
			/*
			* Una vez que terminan todas las llamadas recursivas
			* estámos esperando puros unos, pero si entre esos unos
			* que ya estabamos recibiendo, meten un 0, la cadena está mal
			*/
			if ( current != '1' ) {
				throw new Exception("Cadena no válida, se esperaba 1");
			}
			readChar();

		} else if ( current == '1' ) {

			/*
			* Si es un 1
			* continua leyendo
			*/
			readChar();

		} else {
			throw new Exception("Cadena no válida");
		}

	}


	public static void main(String[] args) throws IOException, Exception {
		C c = new C();
		c.readChar();
		c.s();
	}

}