// Generated from ProSQL.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ProSQLParser}.
 */
public interface ProSQLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ProSQLParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(ProSQLParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProSQLParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(ProSQLParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProSQLParser#predicate}.
	 * @param ctx the parse tree
	 */
	void enterPredicate(ProSQLParser.PredicateContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProSQLParser#predicate}.
	 * @param ctx the parse tree
	 */
	void exitPredicate(ProSQLParser.PredicateContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProSQLParser#query}.
	 * @param ctx the parse tree
	 */
	void enterQuery(ProSQLParser.QueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProSQLParser#query}.
	 * @param ctx the parse tree
	 */
	void exitQuery(ProSQLParser.QueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProSQLParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(ProSQLParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProSQLParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(ProSQLParser.ValueContext ctx);
}