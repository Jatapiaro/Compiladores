// Generated from Gramm.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GrammParser}.
 */
public interface GrammListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link GrammParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(GrammParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(GrammParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammParser#exprS}.
	 * @param ctx the parse tree
	 */
	void enterExprS(GrammParser.ExprSContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammParser#exprS}.
	 * @param ctx the parse tree
	 */
	void exitExprS(GrammParser.ExprSContext ctx);
}