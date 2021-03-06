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
            sb.append( sc.nextLine() + "--");
        }

        String input = sb.toString();
        System.out.println(input);

        String[] sentences = input.split("--");
        for ( String s : sentences ) {
            printDrink( s );
        }
    }

    public static void printDrink(String drinkSentence) {
        // Get our lexer
        DrinkLexer lexer = new DrinkLexer(new ANTLRInputStream(drinkSentence));

        // Get a list of matched tokens
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // Pass the tokens to the parser
        DrinkParser parser = new DrinkParser(tokens);

        // Specify our entry point
        DrinkParser.DrinkSentenceContext drinkSentenceContext = parser.drinkSentence();

        // Walk it and attach our listener
        ParseTreeWalker walker = new ParseTreeWalker();
        DrinkListener listener = new DrinkBaseListener();
        walker.walk(listener, drinkSentenceContext);
    }
}
