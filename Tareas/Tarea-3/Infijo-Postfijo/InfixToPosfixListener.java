// Generated from InfixToPosfix.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link InfixToPosfixParser}.
 */
public interface InfixToPosfixListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link InfixToPosfixParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(InfixToPosfixParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link InfixToPosfixParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(InfixToPosfixParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link InfixToPosfixParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(InfixToPosfixParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link InfixToPosfixParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(InfixToPosfixParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link InfixToPosfixParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(InfixToPosfixParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link InfixToPosfixParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(InfixToPosfixParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link InfixToPosfixParser#operation}.
	 * @param ctx the parse tree
	 */
	void enterOperation(InfixToPosfixParser.OperationContext ctx);
	/**
	 * Exit a parse tree produced by {@link InfixToPosfixParser#operation}.
	 * @param ctx the parse tree
	 */
	void exitOperation(InfixToPosfixParser.OperationContext ctx);
}