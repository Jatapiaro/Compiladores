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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, SPACE=6, NEWLINE=7, PREDICATE=8, 
		STRING_LITERAL=9, INTEGER=10, VALUE=11;
	public static final int
		RULE_prog = 0, RULE_query = 1, RULE_chain_query = 2, RULE_value = 3;
	public static final String[] ruleNames = {
		"prog", "query", "chain_query", "value"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "').'", "'):-'", "'),'", "','", "' '"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, "SPACE", "NEWLINE", "PREDICATE", "STRING_LITERAL", 
		"INTEGER", "VALUE"
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
		public List<QueryContext> query() {
			return getRuleContexts(QueryContext.class);
		}
		public QueryContext query(int i) {
			return getRuleContext(QueryContext.class,i);
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
			while (_la==PREDICATE) {
				{
				{
				setState(8);
				query();
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

	public static class QueryContext extends ParserRuleContext {
		public TerminalNode PREDICATE() { return getToken(ProSQLParser.PREDICATE, 0); }
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public Chain_queryContext chain_query() {
			return getRuleContext(Chain_queryContext.class,0);
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
		enterRule(_localctx, 2, RULE_query);
		int _la;
		try {
			setState(33);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(14);
				match(PREDICATE);
				setState(15);
				match(T__0);
				setState(17); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(16);
					value();
					}
					}
					setState(19); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==VALUE );
				setState(21);
				match(T__1);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(23);
				match(PREDICATE);
				setState(24);
				match(T__0);
				setState(26); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(25);
					value();
					}
					}
					setState(28); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==VALUE );
				setState(30);
				match(T__2);
				setState(31);
				chain_query();
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

	public static class Chain_queryContext extends ParserRuleContext {
		public TerminalNode PREDICATE() { return getToken(ProSQLParser.PREDICATE, 0); }
		public Chain_queryContext chain_query() {
			return getRuleContext(Chain_queryContext.class,0);
		}
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public Chain_queryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_chain_query; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProSQLListener ) ((ProSQLListener)listener).enterChain_query(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProSQLListener ) ((ProSQLListener)listener).exitChain_query(this);
		}
	}

	public final Chain_queryContext chain_query() throws RecognitionException {
		Chain_queryContext _localctx = new Chain_queryContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_chain_query);
		int _la;
		try {
			setState(54);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(35);
				match(PREDICATE);
				setState(36);
				match(T__0);
				setState(38); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(37);
					value();
					}
					}
					setState(40); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==VALUE );
				setState(42);
				match(T__3);
				setState(43);
				chain_query();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(45);
				match(PREDICATE);
				setState(46);
				match(T__0);
				setState(48); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(47);
					value();
					}
					}
					setState(50); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==VALUE );
				setState(52);
				match(T__1);
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
			setState(59);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(56);
				match(VALUE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(57);
				match(VALUE);
				setState(58);
				match(T__4);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\r@\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\3\2\7\2\f\n\2\f\2\16\2\17\13\2\3\3\3\3\3\3\6\3\24\n"+
		"\3\r\3\16\3\25\3\3\3\3\3\3\3\3\3\3\6\3\35\n\3\r\3\16\3\36\3\3\3\3\3\3"+
		"\5\3$\n\3\3\4\3\4\3\4\6\4)\n\4\r\4\16\4*\3\4\3\4\3\4\3\4\3\4\3\4\6\4\63"+
		"\n\4\r\4\16\4\64\3\4\3\4\5\49\n\4\3\5\3\5\3\5\5\5>\n\5\3\5\2\2\6\2\4\6"+
		"\b\2\2\2C\2\r\3\2\2\2\4#\3\2\2\2\68\3\2\2\2\b=\3\2\2\2\n\f\5\4\3\2\13"+
		"\n\3\2\2\2\f\17\3\2\2\2\r\13\3\2\2\2\r\16\3\2\2\2\16\3\3\2\2\2\17\r\3"+
		"\2\2\2\20\21\7\n\2\2\21\23\7\3\2\2\22\24\5\b\5\2\23\22\3\2\2\2\24\25\3"+
		"\2\2\2\25\23\3\2\2\2\25\26\3\2\2\2\26\27\3\2\2\2\27\30\7\4\2\2\30$\3\2"+
		"\2\2\31\32\7\n\2\2\32\34\7\3\2\2\33\35\5\b\5\2\34\33\3\2\2\2\35\36\3\2"+
		"\2\2\36\34\3\2\2\2\36\37\3\2\2\2\37 \3\2\2\2 !\7\5\2\2!\"\5\6\4\2\"$\3"+
		"\2\2\2#\20\3\2\2\2#\31\3\2\2\2$\5\3\2\2\2%&\7\n\2\2&(\7\3\2\2\')\5\b\5"+
		"\2(\'\3\2\2\2)*\3\2\2\2*(\3\2\2\2*+\3\2\2\2+,\3\2\2\2,-\7\6\2\2-.\5\6"+
		"\4\2.9\3\2\2\2/\60\7\n\2\2\60\62\7\3\2\2\61\63\5\b\5\2\62\61\3\2\2\2\63"+
		"\64\3\2\2\2\64\62\3\2\2\2\64\65\3\2\2\2\65\66\3\2\2\2\66\67\7\4\2\2\67"+
		"9\3\2\2\28%\3\2\2\28/\3\2\2\29\7\3\2\2\2:>\7\r\2\2;<\7\r\2\2<>\7\7\2\2"+
		"=:\3\2\2\2=;\3\2\2\2>\t\3\2\2\2\n\r\25\36#*\648=";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}