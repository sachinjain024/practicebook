// Generated from Selector.g4 by ANTLR 4.5.3

package selector;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SelectorParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, LBRACKET=2, RBRACKET=3, PERIOD=4, FIELDNAME=5, INDEX=6, WS=7;
	public static final int
		RULE_entry = 0, RULE_selector = 1, RULE_pathComponent = 2, RULE_field = 3, 
		RULE_fieldWithIndex = 4;
	public static final String[] ruleNames = {
		"entry", "selector", "pathComponent", "field", "fieldWithIndex"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'\n'", "'['", "']'", "'.'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, "LBRACKET", "RBRACKET", "PERIOD", "FIELDNAME", "INDEX", "WS"
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
	public String getGrammarFileName() { return "Selector.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SelectorParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class EntryContext extends ParserRuleContext {
		public SelectorContext selector() {
			return getRuleContext(SelectorContext.class,0);
		}
		public TerminalNode EOF() { return getToken(SelectorParser.EOF, 0); }
		public EntryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_entry; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SelectorListener ) ((SelectorListener)listener).enterEntry(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SelectorListener ) ((SelectorListener)listener).exitEntry(this);
		}
	}

	public final EntryContext entry() throws RecognitionException {
		EntryContext _localctx = new EntryContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_entry);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(10);
			selector();
			setState(11);
			match(EOF);
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

	public static class SelectorContext extends ParserRuleContext {
		public PathComponentContext pathComponent() {
			return getRuleContext(PathComponentContext.class,0);
		}
		public TerminalNode PERIOD() { return getToken(SelectorParser.PERIOD, 0); }
		public SelectorContext selector() {
			return getRuleContext(SelectorContext.class,0);
		}
		public SelectorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selector; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SelectorListener ) ((SelectorListener)listener).enterSelector(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SelectorListener ) ((SelectorListener)listener).exitSelector(this);
		}
	}

	public final SelectorContext selector() throws RecognitionException {
		SelectorContext _localctx = new SelectorContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_selector);
		try {
			setState(19);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(13);
				pathComponent();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(14);
				pathComponent();
				setState(15);
				match(PERIOD);
				setState(16);
				selector();
				setState(17);
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

	public static class PathComponentContext extends ParserRuleContext {
		public FieldWithIndexContext fieldWithIndex() {
			return getRuleContext(FieldWithIndexContext.class,0);
		}
		public FieldContext field() {
			return getRuleContext(FieldContext.class,0);
		}
		public PathComponentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pathComponent; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SelectorListener ) ((SelectorListener)listener).enterPathComponent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SelectorListener ) ((SelectorListener)listener).exitPathComponent(this);
		}
	}

	public final PathComponentContext pathComponent() throws RecognitionException {
		PathComponentContext _localctx = new PathComponentContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_pathComponent);
		try {
			setState(23);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(21);
				fieldWithIndex();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(22);
				field();
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

	public static class FieldContext extends ParserRuleContext {
		public TerminalNode FIELDNAME() { return getToken(SelectorParser.FIELDNAME, 0); }
		public FieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_field; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SelectorListener ) ((SelectorListener)listener).enterField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SelectorListener ) ((SelectorListener)listener).exitField(this);
		}
	}

	public final FieldContext field() throws RecognitionException {
		FieldContext _localctx = new FieldContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_field);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(25);
			match(FIELDNAME);
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

	public static class FieldWithIndexContext extends ParserRuleContext {
		public TerminalNode FIELDNAME() { return getToken(SelectorParser.FIELDNAME, 0); }
		public TerminalNode LBRACKET() { return getToken(SelectorParser.LBRACKET, 0); }
		public TerminalNode INDEX() { return getToken(SelectorParser.INDEX, 0); }
		public TerminalNode RBRACKET() { return getToken(SelectorParser.RBRACKET, 0); }
		public FieldWithIndexContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldWithIndex; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SelectorListener ) ((SelectorListener)listener).enterFieldWithIndex(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SelectorListener ) ((SelectorListener)listener).exitFieldWithIndex(this);
		}
	}

	public final FieldWithIndexContext fieldWithIndex() throws RecognitionException {
		FieldWithIndexContext _localctx = new FieldWithIndexContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_fieldWithIndex);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(27);
			match(FIELDNAME);
			setState(28);
			match(LBRACKET);
			setState(29);
			match(INDEX);
			setState(30);
			match(RBRACKET);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\t#\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\5\3\26"+
		"\n\3\3\4\3\4\5\4\32\n\4\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\2\2\7\2\4\6\b"+
		"\n\2\2\37\2\f\3\2\2\2\4\25\3\2\2\2\6\31\3\2\2\2\b\33\3\2\2\2\n\35\3\2"+
		"\2\2\f\r\5\4\3\2\r\16\7\2\2\3\16\3\3\2\2\2\17\26\5\6\4\2\20\21\5\6\4\2"+
		"\21\22\7\6\2\2\22\23\5\4\3\2\23\24\7\3\2\2\24\26\3\2\2\2\25\17\3\2\2\2"+
		"\25\20\3\2\2\2\26\5\3\2\2\2\27\32\5\n\6\2\30\32\5\b\5\2\31\27\3\2\2\2"+
		"\31\30\3\2\2\2\32\7\3\2\2\2\33\34\7\7\2\2\34\t\3\2\2\2\35\36\7\7\2\2\36"+
		"\37\7\4\2\2\37 \7\b\2\2 !\7\5\2\2!\13\3\2\2\2\4\25\31";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}