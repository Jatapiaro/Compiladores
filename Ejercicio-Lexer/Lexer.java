import java.io.*; 
import java.util.*; 

public class Lexer { 

	public int line = 1; 
	private char peek = ' '; 
	private Hashtable words = new Hashtable();
	private boolean waitinForCommentaryEnd = false; 

	public Lexer() { 
		reserve( new Word(Tag.TRUE, "true") ); 
		reserve( new Word(Tag.FALSE, "false") ); 
	} 

	void reserve(Word t) { 
		words.put(t.lexeme, t); 
	} 

	public Token scan() throws IOException { 
		for( ; ; peek = (char)System.in.read() ) {
			if ( peek == ' ' || peek == '\t' ) {
				continue;
			} 
			else if ( peek == '\n' ) {
				line = line + 1; 
			} else {
				break;
			} 
		}


		if ( peek == '/' ) {
			StringBuilder mySb = new StringBuilder();
			System.in.mark(2);
			char peek2 = (char)System.in.read();
			if ( peek2 == '*') {
				//peek = (char)System.in.read();
				while ( true ) {
					peek = (char)System.in.read();
					if ( peek == '*' ) {
						peek = (char)System.in.read();
						if ( peek == '/' ) {
						    System.out.println("Tu comment fue: "+mySb.toString());
						    break;
						} else {
							mySb.append(peek);
						}
					} else {
						mySb.append(peek);
					} 
				}
			} else {
				System.in.reset();
				System.in.mark(2);
			}
		} 

		if( Character.isDigit(peek) ) { 
			int v = 0; 
			do { 
				v = 10*v + Character.digit(peek, 10); 
				peek = (char)System.in.read(); 
			} while( Character.isDigit(peek) ); 
			return new Num(v);
		} 

		if( Character.isLetter(peek) ) { 

			StringBuffer b = new StringBuffer(); 
			do { 
				b.append(peek); 
				peek = (char)System.in.read(); 
			} while( Character.isLetterOrDigit(peek) ); 

			String s = b.toString(); 
			Word w = (Word)words.get(s); 

			if( w != null ) {
				return w; 
			}
			w = new Word(Tag.ID, s); 
			words.put(s, w); 
			return w; 

		} 
		Token t = new Token(peek);
		peek = ' ';
		return t;
	}
}
		

		