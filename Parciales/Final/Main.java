import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception, ScriptException {
		//CharStream input = CharStreams.fromStream(System.in);
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			process(sc.nextLine());
		}
    }

	public static void process(String s) throws ScriptException {
		ExprLexer lexer = new ExprLexer(new ANTLRInputStream(s));
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		ExprParser parser = new ExprParser(tokens);
		ParseTree tree = parser.prog();
		MyVisitor eval = new MyVisitor();
		eval.visit(tree);
		Operation o = eval.op;
		ScriptEngineManager mgr = new ScriptEngineManager();
		ScriptEngine engine = mgr.getEngineByName("JavaScript");
		double evalu = (double)engine.eval(o.operation);
		//System.out.println(evalu);
		Rational r = new Rational(evalu);
		System.out.println(evalu + " --> " + r);
	}
}
