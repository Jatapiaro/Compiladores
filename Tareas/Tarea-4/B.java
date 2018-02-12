import java.util.*;
import java.io.IOException;
/*
* S ->  S ( S ) S
* La anterior gramática no puede ser usada pues podría generar una recursión
* infinita hacía la izquierda. 
* Pero podemos modificarla con las reglas  
	A -> Aa | B es equivalente a: 
  		A -> BR
  		R -> aR | epsilon
* De está forma, nuestra nueva gramática es la siguiente
* S -> R
* R -> ( S ) R | epsilon
*/

public class B {

	StringBuilder sb = new StringBuilder();
	char current;

	public void readChar() throws IOException, Exception {
		this.current = (char)System.in.read();
		if ( Character.isLetter( current ) ) {
			throw new Exception("Solo se acepta '(' y ')' "); 
		}
	}

	public void s() throws IOException, Exception {
		r();
	}

	public void r() throws IOException, Exception {

		/*
		* En este caso utilizaremos if,
		* pues será más fácil manejar el caso
		* en el que aparezca ( pero que la siguiente
		* S sea un epsilon
		*/

		/*
		* Tratamos de predecir que siempre estarán los (
		* primero, si es que uno no aparece, significa que
		* es epsilon
		*/
		if ( current != '(' ) {
			return;
		}

		readChar();

		/*
		* Si tras la llamada recursiva a s
		* llegamos al caso de arriba donde no hacemos nada
		* significa que ahora deberíamos esperar )
		* si no tenemos ese cáracter, la cadena está mal
		*/
		s();
		if ( current != ')' ) {
			System.out.println("La cadena no es válida");
			return;
		}

		/*
		* Resto de la gramática
		*/
		readChar();
		s();

	}



	public static void main(String[] args) throws IOException, Exception {
		B b = new B();
		b.readChar();
		b.s();
	}
}