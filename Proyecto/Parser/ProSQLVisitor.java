// Generated from ProSQL.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ProSQLParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ProSQLVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ProSQLParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(ProSQLParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProSQLParser#predicate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPredicate(ProSQLParser.PredicateContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProSQLParser#query}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuery(ProSQLParser.QueryContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProSQLParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(ProSQLParser.ValueContext ctx);
}