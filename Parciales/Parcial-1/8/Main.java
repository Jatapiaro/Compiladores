

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		System.out.println(Integer.MAX_VALUE);
		Lexer lexer = new Lexer();
		System.in.mark(2);
		while(System.in.read() != -1) {
			System.in.reset();
			Token t = lexer.scan();
			System.out.println(t);
			System.in.mark(2);
		}
	}

}
