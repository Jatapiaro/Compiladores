// Generated from ProSQL.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ProSQLLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, SPACE=8, NEWLINE=9, 
		STATEMENT=10, STRING_LITERAL=11, INTEGER=12, VALUE=13;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "SPACE", "NEWLINE", 
		"STATEMENT", "STRING_LITERAL", "INTEGER", "VALUE"
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


	public ProSQLLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "ProSQL.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\17}\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\5\3\5\3\6"+
		"\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\n\6\n8"+
		"\n\n\r\n\16\n9\3\13\6\13=\n\13\r\13\16\13>\3\13\7\13B\n\13\f\13\16\13"+
		"E\13\13\3\13\7\13H\n\13\f\13\16\13K\13\13\3\13\5\13N\n\13\3\13\6\13Q\n"+
		"\13\r\13\16\13R\3\13\7\13V\n\13\f\13\16\13Y\13\13\3\13\5\13\\\n\13\7\13"+
		"^\n\13\f\13\16\13a\13\13\3\f\5\fd\n\f\3\r\3\r\3\16\6\16i\n\16\r\16\16"+
		"\16j\3\16\5\16n\n\16\3\16\7\16q\n\16\f\16\16\16t\13\16\3\16\6\16w\n\16"+
		"\r\16\16\16x\3\16\5\16|\n\16\2\2\17\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n"+
		"\23\13\25\f\27\r\31\16\33\17\3\2\5\4\2\f\f\17\17\5\2\62;C\\c|\3\2\62;"+
		"\2\u008b\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2"+
		"\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27"+
		"\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\3\35\3\2\2\2\5\37\3\2\2\2\7\"\3\2\2"+
		"\2\t$\3\2\2\2\13&\3\2\2\2\r(\3\2\2\2\17\61\3\2\2\2\21\64\3\2\2\2\23\67"+
		"\3\2\2\2\25<\3\2\2\2\27c\3\2\2\2\31e\3\2\2\2\33{\3\2\2\2\35\36\7\60\2"+
		"\2\36\4\3\2\2\2\37 \7<\2\2 !\7/\2\2!\6\3\2\2\2\"#\7.\2\2#\b\3\2\2\2$%"+
		"\7*\2\2%\n\3\2\2\2&\'\7+\2\2\'\f\3\2\2\2()\7t\2\2)*\7g\2\2*+\7v\2\2+,"+
		"\7t\2\2,-\7c\2\2-.\7e\2\2./\7v\2\2/\60\7*\2\2\60\16\3\2\2\2\61\62\7+\2"+
		"\2\62\63\7+\2\2\63\20\3\2\2\2\64\65\7\"\2\2\65\22\3\2\2\2\668\t\2\2\2"+
		"\67\66\3\2\2\289\3\2\2\29\67\3\2\2\29:\3\2\2\2:\24\3\2\2\2;=\4c|\2<;\3"+
		"\2\2\2=>\3\2\2\2><\3\2\2\2>?\3\2\2\2?C\3\2\2\2@B\5\27\f\2A@\3\2\2\2BE"+
		"\3\2\2\2CA\3\2\2\2CD\3\2\2\2DI\3\2\2\2EC\3\2\2\2FH\5\31\r\2GF\3\2\2\2"+
		"HK\3\2\2\2IG\3\2\2\2IJ\3\2\2\2JM\3\2\2\2KI\3\2\2\2LN\7a\2\2ML\3\2\2\2"+
		"MN\3\2\2\2N_\3\2\2\2OQ\5\27\f\2PO\3\2\2\2QR\3\2\2\2RP\3\2\2\2RS\3\2\2"+
		"\2SW\3\2\2\2TV\5\31\r\2UT\3\2\2\2VY\3\2\2\2WU\3\2\2\2WX\3\2\2\2X[\3\2"+
		"\2\2YW\3\2\2\2Z\\\7a\2\2[Z\3\2\2\2[\\\3\2\2\2\\^\3\2\2\2]P\3\2\2\2^a\3"+
		"\2\2\2_]\3\2\2\2_`\3\2\2\2`\26\3\2\2\2a_\3\2\2\2bd\t\3\2\2cb\3\2\2\2d"+
		"\30\3\2\2\2ef\t\4\2\2f\32\3\2\2\2gi\5\27\f\2hg\3\2\2\2ij\3\2\2\2jh\3\2"+
		"\2\2jk\3\2\2\2kr\3\2\2\2ln\7\"\2\2ml\3\2\2\2mn\3\2\2\2no\3\2\2\2oq\5\27"+
		"\f\2pm\3\2\2\2qt\3\2\2\2rp\3\2\2\2rs\3\2\2\2s|\3\2\2\2tr\3\2\2\2uw\5\31"+
		"\r\2vu\3\2\2\2wx\3\2\2\2xv\3\2\2\2xy\3\2\2\2y|\3\2\2\2z|\7a\2\2{h\3\2"+
		"\2\2{v\3\2\2\2{z\3\2\2\2|\34\3\2\2\2\22\29>CIMRW[_cjmrx{\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}