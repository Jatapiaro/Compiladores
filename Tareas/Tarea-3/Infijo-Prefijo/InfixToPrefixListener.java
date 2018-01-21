// Generated from InfixToPrefix.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link InfixToPrefixParser}.
 */
public interface InfixToPrefixListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link InfixToPrefixParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(InfixToPrefixParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link InfixToPrefixParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(InfixToPrefixParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link InfixToPrefixParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(InfixToPrefixParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link InfixToPrefixParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(InfixToPrefixParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link InfixToPrefixParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(InfixToPrefixParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link InfixToPrefixParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(InfixToPrefixParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link InfixToPrefixParser#operation}.
	 * @param ctx the parse tree
	 */
	void enterOperation(InfixToPrefixParser.OperationContext ctx);
	/**
	 * Exit a parse tree produced by {@link InfixToPrefixParser#operation}.
	 * @param ctx the parse tree
	 */
	void exitOperation(InfixToPrefixParser.OperationContext ctx);

}
