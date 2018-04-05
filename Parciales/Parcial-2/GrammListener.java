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
	 * Enter a parse tree produced by {@link GrammParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(GrammParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(GrammParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammParser#fraction}.
	 * @param ctx the parse tree
	 */
	void enterFraction(GrammParser.FractionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammParser#fraction}.
	 * @param ctx the parse tree
	 */
	void exitFraction(GrammParser.FractionContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammParser#operation}.
	 * @param ctx the parse tree
	 */
	void enterOperation(GrammParser.OperationContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammParser#operation}.
	 * @param ctx the parse tree
	 */
	void exitOperation(GrammParser.OperationContext ctx);
}