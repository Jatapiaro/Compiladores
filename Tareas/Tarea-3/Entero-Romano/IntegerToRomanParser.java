// Generated from IntegerToRoman.g4 by ANTLR 4.5.3
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class IntegerToRomanParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		NUMBER=1, THOUSAND=2;
	public static final int
		RULE_roman = 0, RULE_thousand = 1, RULE_hundred = 2, RULE_ten = 3, RULE_unit = 4;
	public static final String[] ruleNames = {
		"roman", "thousand", "hundred", "ten", "unit"
	};

	private static final String[] _LITERAL_NAMES = {
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "NUMBER", "THOUSAND"
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
	public String getGrammarFileName() { return "IntegerToRoman.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public IntegerToRomanParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class RomanContext extends ParserRuleContext {
		public UnitContext unit() {
			return getRuleContext(UnitContext.class,0);
		}
		public TenContext ten() {
			return getRuleContext(TenContext.class,0);
		}
		public HundredContext hundred() {
			return getRuleContext(HundredContext.class,0);
		}
		public ThousandContext thousand() {
			return getRuleContext(ThousandContext.class,0);
		}
		public RomanContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_roman; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IntegerToRomanListener ) ((IntegerToRomanListener)listener).enterRoman(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IntegerToRomanListener ) ((IntegerToRomanListener)listener).exitRoman(this);
		}
	}

	public final RomanContext roman() throws RecognitionException {
		RomanContext _localctx = new RomanContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_roman);
		try {
			setState(23);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(10);
				unit();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(11);
				ten();
				setState(12);
				unit();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(14);
				hundred();
				setState(15);
				ten();
				setState(16);
				unit();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(18);
				thousand();
				setState(19);
				hundred();
				setState(20);
				ten();
				setState(21);
				unit();
				}
				break;
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

	public static class ThousandContext extends ParserRuleContext {
		public TerminalNode THOUSAND() { return getToken(IntegerToRomanParser.THOUSAND, 0); }
		public ThousandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_thousand; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IntegerToRomanListener ) ((IntegerToRomanListener)listener).enterThousand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IntegerToRomanListener ) ((IntegerToRomanListener)listener).exitThousand(this);
		}
	}

	public final ThousandContext thousand() throws RecognitionException {
		ThousandContext _localctx = new ThousandContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_thousand);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(25);
			match(THOUSAND);
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

	public static class HundredContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(IntegerToRomanParser.NUMBER, 0); }
		public HundredContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_hundred; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IntegerToRomanListener ) ((IntegerToRomanListener)listener).enterHundred(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IntegerToRomanListener ) ((IntegerToRomanListener)listener).exitHundred(this);
		}
	}

	public final HundredContext hundred() throws RecognitionException {
		HundredContext _localctx = new HundredContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_hundred);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(27);
			match(NUMBER);
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

	public static class TenContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(IntegerToRomanParser.NUMBER, 0); }
		public TenContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ten; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IntegerToRomanListener ) ((IntegerToRomanListener)listener).enterTen(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IntegerToRomanListener ) ((IntegerToRomanListener)listener).exitTen(this);
		}
	}

	public final TenContext ten() throws RecognitionException {
		TenContext _localctx = new TenContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_ten);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(29);
			match(NUMBER);
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

	public static class UnitContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(IntegerToRomanParser.NUMBER, 0); }
		public UnitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IntegerToRomanListener ) ((IntegerToRomanListener)listener).enterUnit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IntegerToRomanListener ) ((IntegerToRomanListener)listener).exitUnit(this);
		}
	}

	public final UnitContext unit() throws RecognitionException {
		UnitContext _localctx = new UnitContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_unit);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(31);
			match(NUMBER);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\4$\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\5\2\32\n\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\6\2\2\7\2\4\6\b"+
		"\n\2\2!\2\31\3\2\2\2\4\33\3\2\2\2\6\35\3\2\2\2\b\37\3\2\2\2\n!\3\2\2\2"+
		"\f\32\5\n\6\2\r\16\5\b\5\2\16\17\5\n\6\2\17\32\3\2\2\2\20\21\5\6\4\2\21"+
		"\22\5\b\5\2\22\23\5\n\6\2\23\32\3\2\2\2\24\25\5\4\3\2\25\26\5\6\4\2\26"+
		"\27\5\b\5\2\27\30\5\n\6\2\30\32\3\2\2\2\31\f\3\2\2\2\31\r\3\2\2\2\31\20"+
		"\3\2\2\2\31\24\3\2\2\2\32\3\3\2\2\2\33\34\7\4\2\2\34\5\3\2\2\2\35\36\7"+
		"\3\2\2\36\7\3\2\2\2\37 \7\3\2\2 \t\3\2\2\2!\"\7\3\2\2\"\13\3\2\2\2\3\31";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}