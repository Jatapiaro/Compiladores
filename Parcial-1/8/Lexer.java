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

		if( Character.isDigit(peek) ) {
			int v = 0;
			System.in.mark(2);
			if ( peek == '0' ) {
				peek = (char)System.in.read();
				if ( peek == 'x' ) {

					char peekAux = '0';
					int counter = 0;
					StringBuilder sb = new StringBuilder();
					do {
						peekAux = (char)System.in.read();
						String peekAux2 = ""+peekAux;
						peekAux2 = peekAux2.toUpperCase();
						peekAux = peekAux2.charAt(0);
						sb.append(peekAux);
						counter++;
					} while( counter <= 8 && ( Character.isDigit(peekAux) || peekAux == 'A' || peekAux == 'B' || peekAux == 'C' || peekAux == 'D' || peekAux == 'E' || peekAux == 'F' ) );
					System.out.println(
						"0x"+sb.toString()+" --> "+Integer.parseInt(sb.toString().trim(), 16)
					);
					sb = new StringBuilder();
				} else {
					System.in.reset();
				}
			}
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
