// Generated from Gramm.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GrammParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ZERO=1, ONE=2, NEWLINE=3;
	public static final int
		RULE_prog = 0, RULE_exprS = 1, RULE_exprR = 2, RULE_zero = 3, RULE_one = 4;
	public static final String[] ruleNames = {
		"prog", "exprS", "exprR", "zero", "one"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'0'", "'1'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "ZERO", "ONE", "NEWLINE"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Gramm.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public GrammParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgContext extends ParserRuleContext {
		public ExprSContext exprS() {
			return getRuleContext(ExprSContext.class,0);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammListener ) ((GrammListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammListener ) ((GrammListener)listener).exitProg(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(10);
			exprS();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprSContext extends ParserRuleContext {
		public ZeroContext zero() {
			return getRuleContext(ZeroContext.class,0);
		}
		public ExprRContext exprR() {
			return getRuleContext(ExprRContext.class,0);
		}
		public ExprSContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprS; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammListener ) ((GrammListener)listener).enterExprS(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammListener ) ((GrammListener)listener).exitExprS(this);
		}
	}

	public final ExprSContext exprS() throws RecognitionException {
		ExprSContext _localctx = new ExprSContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_exprS);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(12);
			zero();
			setState(13);
			exprR();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprRContext extends ParserRuleContext {
		public ExprSContext exprS() {
			return getRuleContext(ExprSContext.class,0);
		}
		public OneContext one() {
			return getRuleContext(OneContext.class,0);
		}
		public ExprRContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprR; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammListener ) ((GrammListener)listener).enterExprR(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammListener ) ((GrammListener)listener).exitExprR(this);
		}
	}

	public final ExprRContext exprR() throws RecognitionException {
		ExprRContext _localctx = new ExprRContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_exprR);
		try {
			setState(19);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ZERO:
				enterOuterAlt(_localctx, 1);
				{
				setState(15);
				exprS();
				setState(16);
				one();
				}
				break;
			case ONE:
				enterOuterAlt(_localctx, 2);
				{
				setState(18);
				one();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ZeroContext extends ParserRuleContext {
		public TerminalNode ZERO() { return getToken(GrammParser.ZERO, 0); }
		public ZeroContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_zero; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammListener ) ((GrammListener)listener).enterZero(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammListener ) ((GrammListener)listener).exitZero(this);
		}
	}

	public final ZeroContext zero() throws RecognitionException {
		ZeroContext _localctx = new ZeroContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_zero);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(21);
			match(ZERO);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OneContext extends ParserRuleContext {
		public TerminalNode ONE() { return getToken(GrammParser.ONE, 0); }
		public OneContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_one; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammListener ) ((GrammListener)listener).enterOne(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammListener ) ((GrammListener)listener).exitOne(this);
		}
	}

	public final OneContext one() throws RecognitionException {
		OneContext _localctx = new OneContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_one);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(23);
			match(ONE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\5\34\4\2\t\2\4\3"+
		"\t\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\4\3\4\5\4\26"+
		"\n\4\3\5\3\5\3\6\3\6\3\6\2\2\7\2\4\6\b\n\2\2\2\27\2\f\3\2\2\2\4\16\3\2"+
		"\2\2\6\25\3\2\2\2\b\27\3\2\2\2\n\31\3\2\2\2\f\r\5\4\3\2\r\3\3\2\2\2\16"+
		"\17\5\b\5\2\17\20\5\6\4\2\20\5\3\2\2\2\21\22\5\4\3\2\22\23\5\n\6\2\23"+
		"\26\3\2\2\2\24\26\5\n\6\2\25\21\3\2\2\2\25\24\3\2\2\2\26\7\3\2\2\2\27"+
		"\30\7\3\2\2\30\t\3\2\2\2\31\32\7\4\2\2\32\13\3\2\2\2\3\25";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}