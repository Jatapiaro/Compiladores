import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import java.util.*;


public class Test {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        while( sc.hasNext() ) {
            printOperation(sc.nextLine());
        }

    }

    public static void printOperation(String sentence) {
        // Get our lexer
        IntegerToRomanLexer lexer = new IntegerToRomanLexer(new ANTLRInputStream(sentence));

        // Get a list of matched tokens
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // Pass the tokens to the parser
        IntegerToRomanParser parser = new IntegerToRomanParser(tokens);

        // Specify our entry point
        IntegerToRomanParser.RomanContext integerToRomanSentenceContext = parser.roman();

        // Walk it and attach our listener
        ParseTreeWalker walker = new ParseTreeWalker();
        IntegerToRomanBaseListener listener = new IntegerToRomanBaseListener();
        walker.walk(listener, integerToRomanSentenceContext);

        System.out.println(sentence + " --> " +listener.converter);

    }
}
