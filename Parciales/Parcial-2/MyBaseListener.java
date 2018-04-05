// Generated from Gramm.g4 by ANTLR 4.7.1

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

/**
 * This class provides an empty implementation of {@link GrammListener},
 * which can be extended to create a listener which only needs to handle a subset
 * of the available methods.
 */
public class MyBaseListener implements GrammListener {

	int counter = 0;
	Fraction f = new Fraction(0, 1);
	char operand = '_';
	AllFractions af = new AllFractions();
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterProg(GrammParser.ProgContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitProg(GrammParser.ProgContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterExpr(GrammParser.ExprContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitExpr(GrammParser.ExprContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterFraction(GrammParser.FractionContext ctx) {
		String[] val = ctx.getText().split("%");
		af.addFraction(new Fraction(Integer.parseInt(val[0]), Integer.parseInt(val[1])));
		/*counter++;
		if ( counter == 2 ) {
			counter = 0;
			System.out.println(f.operation(this.operand, new Fraction(Integer.parseInt(val[0]), Integer.parseInt(val[1]))));
		} else {
			f = new Fraction(Integer.parseInt(val[0]), Integer.parseInt(val[1]));
		}*/
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitFraction(GrammParser.FractionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterOperation(GrammParser.OperationContext ctx) {
		this.operand = ctx.getText().charAt(0);
		this.af.addOperand(ctx.getText().charAt(0));
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitOperation(GrammParser.OperationContext ctx) { }

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterEveryRule(ParserRuleContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitEveryRule(ParserRuleContext ctx) {
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void visitTerminal(TerminalNode node) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void visitErrorNode(ErrorNode node) { }
}
