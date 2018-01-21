// Generated from IntegerToRoman.g4 by ANTLR 4.5.3
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link IntegerToRomanParser}.
 */
public interface IntegerToRomanListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link IntegerToRomanParser#roman}.
	 * @param ctx the parse tree
	 */
	void enterRoman(IntegerToRomanParser.RomanContext ctx);
	/**
	 * Exit a parse tree produced by {@link IntegerToRomanParser#roman}.
	 * @param ctx the parse tree
	 */
	void exitRoman(IntegerToRomanParser.RomanContext ctx);
	/**
	 * Enter a parse tree produced by {@link IntegerToRomanParser#thousand}.
	 * @param ctx the parse tree
	 */
	void enterThousand(IntegerToRomanParser.ThousandContext ctx);
	/**
	 * Exit a parse tree produced by {@link IntegerToRomanParser#thousand}.
	 * @param ctx the parse tree
	 */
	void exitThousand(IntegerToRomanParser.ThousandContext ctx);
	/**
	 * Enter a parse tree produced by {@link IntegerToRomanParser#hundred}.
	 * @param ctx the parse tree
	 */
	void enterHundred(IntegerToRomanParser.HundredContext ctx);
	/**
	 * Exit a parse tree produced by {@link IntegerToRomanParser#hundred}.
	 * @param ctx the parse tree
	 */
	void exitHundred(IntegerToRomanParser.HundredContext ctx);
	/**
	 * Enter a parse tree produced by {@link IntegerToRomanParser#ten}.
	 * @param ctx the parse tree
	 */
	void enterTen(IntegerToRomanParser.TenContext ctx);
	/**
	 * Exit a parse tree produced by {@link IntegerToRomanParser#ten}.
	 * @param ctx the parse tree
	 */
	void exitTen(IntegerToRomanParser.TenContext ctx);
	/**
	 * Enter a parse tree produced by {@link IntegerToRomanParser#unit}.
	 * @param ctx the parse tree
	 */
	void enterUnit(IntegerToRomanParser.UnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link IntegerToRomanParser#unit}.
	 * @param ctx the parse tree
	 */
	void exitUnit(IntegerToRomanParser.UnitContext ctx);
}