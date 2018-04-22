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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, SPACE=6, NEWLINE=7, PREDICATE=8, 
		STRING_LITERAL=9, INTEGER=10, VALUE=11;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "SPACE", "NEWLINE", "PREDICATE", 
		"STRING_LITERAL", "INTEGER", "VALUE"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\rm\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3"+
		"\7\3\7\3\b\6\b+\n\b\r\b\16\b,\3\t\6\t\60\n\t\r\t\16\t\61\3\t\7\t\65\n"+
		"\t\f\t\16\t8\13\t\3\t\7\t;\n\t\f\t\16\t>\13\t\3\t\5\tA\n\t\3\t\6\tD\n"+
		"\t\r\t\16\tE\3\t\7\tI\n\t\f\t\16\tL\13\t\3\t\5\tO\n\t\7\tQ\n\t\f\t\16"+
		"\tT\13\t\3\n\5\nW\n\n\3\13\3\13\3\f\6\f\\\n\f\r\f\16\f]\3\f\7\fa\n\f\f"+
		"\f\16\fd\13\f\3\f\6\fg\n\f\r\f\16\fh\3\f\5\fl\n\f\2\2\r\3\3\5\4\7\5\t"+
		"\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\3\2\5\4\2\f\f\17\17\4\2C\\c|\3\2"+
		"\62;\2z\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2"+
		"\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3"+
		"\2\2\2\3\31\3\2\2\2\5\33\3\2\2\2\7\36\3\2\2\2\t\"\3\2\2\2\13%\3\2\2\2"+
		"\r\'\3\2\2\2\17*\3\2\2\2\21/\3\2\2\2\23V\3\2\2\2\25X\3\2\2\2\27k\3\2\2"+
		"\2\31\32\7*\2\2\32\4\3\2\2\2\33\34\7+\2\2\34\35\7\60\2\2\35\6\3\2\2\2"+
		"\36\37\7+\2\2\37 \7<\2\2 !\7/\2\2!\b\3\2\2\2\"#\7+\2\2#$\7.\2\2$\n\3\2"+
		"\2\2%&\7.\2\2&\f\3\2\2\2\'(\7\"\2\2(\16\3\2\2\2)+\t\2\2\2*)\3\2\2\2+,"+
		"\3\2\2\2,*\3\2\2\2,-\3\2\2\2-\20\3\2\2\2.\60\4c|\2/.\3\2\2\2\60\61\3\2"+
		"\2\2\61/\3\2\2\2\61\62\3\2\2\2\62\66\3\2\2\2\63\65\5\23\n\2\64\63\3\2"+
		"\2\2\658\3\2\2\2\66\64\3\2\2\2\66\67\3\2\2\2\67<\3\2\2\28\66\3\2\2\29"+
		";\5\25\13\2:9\3\2\2\2;>\3\2\2\2<:\3\2\2\2<=\3\2\2\2=@\3\2\2\2><\3\2\2"+
		"\2?A\7a\2\2@?\3\2\2\2@A\3\2\2\2AR\3\2\2\2BD\5\23\n\2CB\3\2\2\2DE\3\2\2"+
		"\2EC\3\2\2\2EF\3\2\2\2FJ\3\2\2\2GI\5\25\13\2HG\3\2\2\2IL\3\2\2\2JH\3\2"+
		"\2\2JK\3\2\2\2KN\3\2\2\2LJ\3\2\2\2MO\7a\2\2NM\3\2\2\2NO\3\2\2\2OQ\3\2"+
		"\2\2PC\3\2\2\2QT\3\2\2\2RP\3\2\2\2RS\3\2\2\2S\22\3\2\2\2TR\3\2\2\2UW\t"+
		"\3\2\2VU\3\2\2\2W\24\3\2\2\2XY\t\4\2\2Y\26\3\2\2\2Z\\\5\23\n\2[Z\3\2\2"+
		"\2\\]\3\2\2\2][\3\2\2\2]^\3\2\2\2^b\3\2\2\2_a\t\4\2\2`_\3\2\2\2ad\3\2"+
		"\2\2b`\3\2\2\2bc\3\2\2\2cl\3\2\2\2db\3\2\2\2eg\5\25\13\2fe\3\2\2\2gh\3"+
		"\2\2\2hf\3\2\2\2hi\3\2\2\2il\3\2\2\2jl\7a\2\2k[\3\2\2\2kf\3\2\2\2kj\3"+
		"\2\2\2l\30\3\2\2\2\21\2,\61\66<@EJNRV]bhk\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}