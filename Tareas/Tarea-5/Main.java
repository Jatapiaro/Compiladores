import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		Lexer lexer = new Lexer();
		System.in.mark(2);
		while(System.in.read() != -1) {
			System.in.reset();
			Token t = lexer.scan();
			System.out.println(t);
			/*
			* 2 because char is the number of bytes 
			* in a java char
			*/
			System.in.mark(2);
		}
	}

}