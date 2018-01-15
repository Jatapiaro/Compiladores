// Generated from Drink.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link DrinkParser}.
 */
public interface DrinkListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link DrinkParser#drinkSentence}.
	 * @param ctx the parse tree
	 */
	void enterDrinkSentence(DrinkParser.DrinkSentenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link DrinkParser#drinkSentence}.
	 * @param ctx the parse tree
	 */
	void exitDrinkSentence(DrinkParser.DrinkSentenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link DrinkParser#drink}.
	 * @param ctx the parse tree
	 */
	void enterDrink(DrinkParser.DrinkContext ctx);
	/**
	 * Exit a parse tree produced by {@link DrinkParser#drink}.
	 * @param ctx the parse tree
	 */
	void exitDrink(DrinkParser.DrinkContext ctx);
}