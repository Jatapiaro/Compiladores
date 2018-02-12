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
        GrammLexer lexer = new GrammLexer(new ANTLRInputStream(sentence));

        // Get a list of matched tokens
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // Pass the tokens to the parser
        GrammParser parser = new GrammParser(tokens);

        // Specify our entry point
        GrammParser.ProgContext context = parser.prog();

        // Walk it and attach our listener
        ParseTreeWalker walker = new ParseTreeWalker();
        MyBaseListener listener = new MyBaseListener();
        walker.walk(listener, context);

        System.out.println(listener);
    }
}
