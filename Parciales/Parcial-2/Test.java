import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import java.util.*;
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;


public class Test {
    public static void main(String[] args) throws ScriptException {

        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        while( sc.hasNext() ) {
            printOperation(sc.nextLine());
        }

    }

    public static void printOperation(String sentence) throws ScriptException {
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

        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");
        double evalu = (double)engine.eval(listener.af.toString());
        System.out.print(new Rational(evalu));

    }
}
