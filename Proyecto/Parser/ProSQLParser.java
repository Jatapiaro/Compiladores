// Generated from ProSQL.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ProSQLParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, SPACE=8, NEWLINE=9, 
		STATEMENT=10, STRING_LITERAL=11, INTEGER=12, VALUE=13;
	public static final int
		RULE_prog = 0, RULE_predicate = 1, RULE_query = 2, RULE_value = 3;
	public static final String[] ruleNames = {
		"prog", "predicate", "query", "value"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'.'", "':-'", "','", "'('", "')'", "'retract('", "'))'", "' '"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, "SPACE", "NEWLINE", "STATEMENT", 
		"STRING_LITERAL", "INTEGER", "VALUE"
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
	public String getGrammarFileName() { return "ProSQL.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ProSQLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgContext extends ParserRuleContext {
		public List<PredicateContext> predicate() {
			return getRuleContexts(PredicateContext.class);
		}
		public PredicateContext predicate(int i) {
			return getRuleContext(PredicateContext.class,i);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProSQLListener ) ((ProSQLListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProSQLListener ) ((ProSQLListener)listener).exitProg(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(11);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__5 || _la==STATEMENT) {
				{
				{
				setState(8);
				predicate();
				}
				}
				setState(13);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
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

	public static class PredicateContext extends ParserRuleContext {
		public List<QueryContext> query() {
			return getRuleContexts(QueryContext.class);
		}
		public QueryContext query(int i) {
			return getRuleContext(QueryContext.class,i);
		}
		public PredicateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProSQLListener ) ((ProSQLListener)listener).enterPredicate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProSQLListener ) ((ProSQLListener)listener).exitPredicate(this);
		}
	}

	public final PredicateContext predicate() throws RecognitionException {
		PredicateContext _localctx = new PredicateContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_predicate);
		try {
			int _alt;
			setState(30);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(14);
				query();
				setState(15);
				match(T__0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(17);
				query();
				setState(18);
				match(T__1);
				setState(24);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(19);
						query();
						setState(20);
						match(T__2);
						}
						} 
					}
					setState(26);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
				}
				setState(27);
				query();
				setState(28);
				match(T__0);
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

	public static class QueryContext extends ParserRuleContext {
		public TerminalNode STATEMENT() { return getToken(ProSQLParser.STATEMENT, 0); }
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public QueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_query; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProSQLListener ) ((ProSQLListener)listener).enterQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProSQLListener ) ((ProSQLListener)listener).exitQuery(this);
		}
	}

	public final QueryContext query() throws RecognitionException {
		QueryContext _localctx = new QueryContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_query);
		int _la;
		try {
			setState(51);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STATEMENT:
				enterOuterAlt(_localctx, 1);
				{
				setState(32);
				match(STATEMENT);
				setState(33);
				match(T__3);
				setState(35); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(34);
					value();
					}
					}
					setState(37); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==VALUE );
				setState(39);
				match(T__4);
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 2);
				{
				setState(41);
				match(T__5);
				setState(42);
				match(STATEMENT);
				setState(43);
				match(T__3);
				setState(45); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(44);
					value();
					}
					}
					setState(47); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==VALUE );
				setState(49);
				match(T__6);
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

	public static class ValueContext extends ParserRuleContext {
		public TerminalNode VALUE() { return getToken(ProSQLParser.VALUE, 0); }
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProSQLListener ) ((ProSQLListener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProSQLListener ) ((ProSQLListener)listener).exitValue(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_value);
		try {
			setState(56);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(53);
				match(VALUE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(54);
				match(VALUE);
				setState(55);
				match(T__2);
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\17=\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\3\2\7\2\f\n\2\f\2\16\2\17\13\2\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\7\3\31\n\3\f\3\16\3\34\13\3\3\3\3\3\3\3\5\3!\n\3\3\4\3\4"+
		"\3\4\6\4&\n\4\r\4\16\4\'\3\4\3\4\3\4\3\4\3\4\3\4\6\4\60\n\4\r\4\16\4\61"+
		"\3\4\3\4\5\4\66\n\4\3\5\3\5\3\5\5\5;\n\5\3\5\2\2\6\2\4\6\b\2\2\2?\2\r"+
		"\3\2\2\2\4 \3\2\2\2\6\65\3\2\2\2\b:\3\2\2\2\n\f\5\4\3\2\13\n\3\2\2\2\f"+
		"\17\3\2\2\2\r\13\3\2\2\2\r\16\3\2\2\2\16\3\3\2\2\2\17\r\3\2\2\2\20\21"+
		"\5\6\4\2\21\22\7\3\2\2\22!\3\2\2\2\23\24\5\6\4\2\24\32\7\4\2\2\25\26\5"+
		"\6\4\2\26\27\7\5\2\2\27\31\3\2\2\2\30\25\3\2\2\2\31\34\3\2\2\2\32\30\3"+
		"\2\2\2\32\33\3\2\2\2\33\35\3\2\2\2\34\32\3\2\2\2\35\36\5\6\4\2\36\37\7"+
		"\3\2\2\37!\3\2\2\2 \20\3\2\2\2 \23\3\2\2\2!\5\3\2\2\2\"#\7\f\2\2#%\7\6"+
		"\2\2$&\5\b\5\2%$\3\2\2\2&\'\3\2\2\2\'%\3\2\2\2\'(\3\2\2\2()\3\2\2\2)*"+
		"\7\7\2\2*\66\3\2\2\2+,\7\b\2\2,-\7\f\2\2-/\7\6\2\2.\60\5\b\5\2/.\3\2\2"+
		"\2\60\61\3\2\2\2\61/\3\2\2\2\61\62\3\2\2\2\62\63\3\2\2\2\63\64\7\t\2\2"+
		"\64\66\3\2\2\2\65\"\3\2\2\2\65+\3\2\2\2\66\7\3\2\2\2\67;\7\17\2\289\7"+
		"\17\2\29;\7\5\2\2:\67\3\2\2\2:8\3\2\2\2;\t\3\2\2\2\t\r\32 \'\61\65:";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}