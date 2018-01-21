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
        InfixToPosfixLexer lexer = new InfixToPosfixLexer(new ANTLRInputStream(sentence));

        // Get a list of matched tokens
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // Pass the tokens to the parser
        InfixToPosfixParser parser = new InfixToPosfixParser(tokens);

        // Specify our entry point
        InfixToPosfixParser.ExprContext infixToPosfixSentenceContext = parser.expr();

        // Walk it and attach our listener
        ParseTreeWalker walker = new ParseTreeWalker();
        InfixToPosfixBaseListener listener = new InfixToPosfixBaseListener();
        walker.walk(listener, infixToPosfixSentenceContext);

        String[] result = listener.getPrefixString();

        System.out.println( result[0] + " --> " + result[1] );
    }
}
