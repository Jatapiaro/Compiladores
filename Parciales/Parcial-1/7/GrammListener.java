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
	/**
	 * Enter a parse tree produced by {@link GrammParser#exprR}.
	 * @param ctx the parse tree
	 */
	void enterExprR(GrammParser.ExprRContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammParser#exprR}.
	 * @param ctx the parse tree
	 */
	void exitExprR(GrammParser.ExprRContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammParser#zero}.
	 * @param ctx the parse tree
	 */
	void enterZero(GrammParser.ZeroContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammParser#zero}.
	 * @param ctx the parse tree
	 */
	void exitZero(GrammParser.ZeroContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammParser#one}.
	 * @param ctx the parse tree
	 */
	void enterOne(GrammParser.OneContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammParser#one}.
	 * @param ctx the parse tree
	 */
	void exitOne(GrammParser.OneContext ctx);
}