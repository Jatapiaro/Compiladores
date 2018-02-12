import java.util.*;
import java.io.IOException;
/*
* S -> +SS | -SS | a
*/

public class A {

	char current;

	public void readChar() throws IOException{
		this.current = (char)System.in.read();
	}

	public void s() throws IOException{

		switch( current ) {

			case 'a':
				break;

			case '+':
				readChar();
				s();
				s();
				break;

			case '-':
				readChar();
				s();
				s();
				break;

			default: 
				System.out.println("Cadena no válida");
				current = (char)-1;
				break;
		}

	}


	public static void main(String[] args) throws IOException {
	
		A a = new A();
		a.readChar();
		a.s();

	}

}