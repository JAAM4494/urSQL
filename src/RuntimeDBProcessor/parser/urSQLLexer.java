// $ANTLR 3.5.1 /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g 2015-09-27 00:00:28

	package RuntimeDBProcessor.parser;
	import RuntimeDBProcessor.*;
   


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class urSQLLexer extends Lexer {
	public static final int EOF=-1;
	public static final int T__12=12;
	public static final int T__13=13;
	public static final int T__14=14;
	public static final int T__15=15;
	public static final int T__16=16;
	public static final int T__17=17;
	public static final int T__18=18;
	public static final int T__19=19;
	public static final int T__20=20;
	public static final int T__21=21;
	public static final int T__22=22;
	public static final int T__23=23;
	public static final int T__24=24;
	public static final int T__25=25;
	public static final int T__26=26;
	public static final int T__27=27;
	public static final int T__28=28;
	public static final int T__29=29;
	public static final int T__30=30;
	public static final int T__31=31;
	public static final int T__32=32;
	public static final int T__33=33;
	public static final int T__34=34;
	public static final int T__35=35;
	public static final int T__36=36;
	public static final int T__37=37;
	public static final int T__38=38;
	public static final int T__39=39;
	public static final int T__40=40;
	public static final int T__41=41;
	public static final int T__42=42;
	public static final int T__43=43;
	public static final int T__44=44;
	public static final int T__45=45;
	public static final int T__46=46;
	public static final int T__47=47;
	public static final int T__48=48;
	public static final int T__49=49;
	public static final int T__50=50;
	public static final int T__51=51;
	public static final int T__52=52;
	public static final int T__53=53;
	public static final int T__54=54;
	public static final int AggregateFunctions=4;
	public static final int DIGIT=5;
	public static final int Identifier=6;
	public static final int LETTER=7;
	public static final int LogicToken=8;
	public static final int Nullability=9;
	public static final int Types=10;
	public static final int WS=11;

		RuntimeDB mainRuntime= new RuntimeDB();
		
		@Override
		  public void reportError(RecognitionException e) {
			System.out.println("ERROR \n "+e.toString());
			
		  	//System.out.println("ERROR \n "+e.getMessage());
		  	mainRuntime.reportedError(e.toString(),"lexer");
		       	//InError=true;       
		}  
		
		



	// delegates
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public urSQLLexer() {} 
	public urSQLLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public urSQLLexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "/Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g"; }

	// $ANTLR start "T__12"
	public final void mT__12() throws RecognitionException {
		try {
			int _type = T__12;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:23:7: ( '(' )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:23:9: '('
			{
			match('('); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__12"

	// $ANTLR start "T__13"
	public final void mT__13() throws RecognitionException {
		try {
			int _type = T__13;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:24:7: ( ')' )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:24:9: ')'
			{
			match(')'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__13"

	// $ANTLR start "T__14"
	public final void mT__14() throws RecognitionException {
		try {
			int _type = T__14;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:25:7: ( '*' )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:25:9: '*'
			{
			match('*'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__14"

	// $ANTLR start "T__15"
	public final void mT__15() throws RecognitionException {
		try {
			int _type = T__15;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:26:7: ( ',' )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:26:9: ','
			{
			match(','); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__15"

	// $ANTLR start "T__16"
	public final void mT__16() throws RecognitionException {
		try {
			int _type = T__16;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:27:7: ( '.' )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:27:9: '.'
			{
			match('.'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__16"

	// $ANTLR start "T__17"
	public final void mT__17() throws RecognitionException {
		try {
			int _type = T__17;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:28:7: ( '<' )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:28:9: '<'
			{
			match('<'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__17"

	// $ANTLR start "T__18"
	public final void mT__18() throws RecognitionException {
		try {
			int _type = T__18;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:29:7: ( '=' )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:29:9: '='
			{
			match('='); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__18"

	// $ANTLR start "T__19"
	public final void mT__19() throws RecognitionException {
		try {
			int _type = T__19;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:30:7: ( '>' )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:30:9: '>'
			{
			match('>'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__19"

	// $ANTLR start "T__20"
	public final void mT__20() throws RecognitionException {
		try {
			int _type = T__20;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:31:7: ( 'ADD' )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:31:9: 'ADD'
			{
			match("ADD"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__20"

	// $ANTLR start "T__21"
	public final void mT__21() throws RecognitionException {
		try {
			int _type = T__21;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:32:7: ( 'ALTER TABLE' )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:32:9: 'ALTER TABLE'
			{
			match("ALTER TABLE"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__21"

	// $ANTLR start "T__22"
	public final void mT__22() throws RecognitionException {
		try {
			int _type = T__22;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:33:7: ( 'AS' )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:33:9: 'AS'
			{
			match("AS"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__22"

	// $ANTLR start "T__23"
	public final void mT__23() throws RecognitionException {
		try {
			int _type = T__23;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:34:7: ( 'CONSTRAINT' )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:34:9: 'CONSTRAINT'
			{
			match("CONSTRAINT"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__23"

	// $ANTLR start "T__24"
	public final void mT__24() throws RecognitionException {
		try {
			int _type = T__24;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:35:7: ( 'CREATE DATABASE' )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:35:9: 'CREATE DATABASE'
			{
			match("CREATE DATABASE"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__24"

	// $ANTLR start "T__25"
	public final void mT__25() throws RecognitionException {
		try {
			int _type = T__25;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:36:7: ( 'CREATE INDEX' )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:36:9: 'CREATE INDEX'
			{
			match("CREATE INDEX"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__25"

	// $ANTLR start "T__26"
	public final void mT__26() throws RecognitionException {
		try {
			int _type = T__26;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:37:7: ( 'CREATE TABLE' )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:37:9: 'CREATE TABLE'
			{
			match("CREATE TABLE"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__26"

	// $ANTLR start "T__27"
	public final void mT__27() throws RecognitionException {
		try {
			int _type = T__27;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:38:7: ( 'DELETE' )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:38:9: 'DELETE'
			{
			match("DELETE"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__27"

	// $ANTLR start "T__28"
	public final void mT__28() throws RecognitionException {
		try {
			int _type = T__28;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:39:7: ( 'DISPLAY DATABASE' )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:39:9: 'DISPLAY DATABASE'
			{
			match("DISPLAY DATABASE"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__28"

	// $ANTLR start "T__29"
	public final void mT__29() throws RecognitionException {
		try {
			int _type = T__29;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:40:7: ( 'DROP DATABASE' )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:40:9: 'DROP DATABASE'
			{
			match("DROP DATABASE"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__29"

	// $ANTLR start "T__30"
	public final void mT__30() throws RecognitionException {
		try {
			int _type = T__30;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:41:7: ( 'DROP TABLE' )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:41:9: 'DROP TABLE'
			{
			match("DROP TABLE"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__30"

	// $ANTLR start "T__31"
	public final void mT__31() throws RecognitionException {
		try {
			int _type = T__31;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:42:7: ( 'FOR JSON' )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:42:9: 'FOR JSON'
			{
			match("FOR JSON"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__31"

	// $ANTLR start "T__32"
	public final void mT__32() throws RecognitionException {
		try {
			int _type = T__32;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:43:7: ( 'FOR XML' )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:43:9: 'FOR XML'
			{
			match("FOR XML"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__32"

	// $ANTLR start "T__33"
	public final void mT__33() throws RecognitionException {
		try {
			int _type = T__33;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:44:7: ( 'FOREIGN KEY' )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:44:9: 'FOREIGN KEY'
			{
			match("FOREIGN KEY"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__33"

	// $ANTLR start "T__34"
	public final void mT__34() throws RecognitionException {
		try {
			int _type = T__34;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:45:7: ( 'FROM' )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:45:9: 'FROM'
			{
			match("FROM"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__34"

	// $ANTLR start "T__35"
	public final void mT__35() throws RecognitionException {
		try {
			int _type = T__35;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:46:7: ( 'GET STATUS' )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:46:9: 'GET STATUS'
			{
			match("GET STATUS"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__35"

	// $ANTLR start "T__36"
	public final void mT__36() throws RecognitionException {
		try {
			int _type = T__36;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:47:7: ( 'GROUP BY' )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:47:9: 'GROUP BY'
			{
			match("GROUP BY"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__36"

	// $ANTLR start "T__37"
	public final void mT__37() throws RecognitionException {
		try {
			int _type = T__37;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:48:7: ( 'INSERT INTO' )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:48:9: 'INSERT INTO'
			{
			match("INSERT INTO"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__37"

	// $ANTLR start "T__38"
	public final void mT__38() throws RecognitionException {
		try {
			int _type = T__38;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:49:7: ( 'JOIN' )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:49:9: 'JOIN'
			{
			match("JOIN"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__38"

	// $ANTLR start "T__39"
	public final void mT__39() throws RecognitionException {
		try {
			int _type = T__39;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:50:7: ( 'LIST DATABASES' )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:50:9: 'LIST DATABASES'
			{
			match("LIST DATABASES"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__39"

	// $ANTLR start "T__40"
	public final void mT__40() throws RecognitionException {
		try {
			int _type = T__40;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:51:7: ( 'ON' )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:51:9: 'ON'
			{
			match("ON"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__40"

	// $ANTLR start "T__41"
	public final void mT__41() throws RecognitionException {
		try {
			int _type = T__41;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:52:7: ( 'PRIMARY KEY(' )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:52:9: 'PRIMARY KEY('
			{
			match("PRIMARY KEY("); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__41"

	// $ANTLR start "T__42"
	public final void mT__42() throws RecognitionException {
		try {
			int _type = T__42;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:53:7: ( 'REFERENCES' )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:53:9: 'REFERENCES'
			{
			match("REFERENCES"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__42"

	// $ANTLR start "T__43"
	public final void mT__43() throws RecognitionException {
		try {
			int _type = T__43;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:54:7: ( 'SELECT' )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:54:9: 'SELECT'
			{
			match("SELECT"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__43"

	// $ANTLR start "T__44"
	public final void mT__44() throws RecognitionException {
		try {
			int _type = T__44;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:55:7: ( 'SET DATABASE' )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:55:9: 'SET DATABASE'
			{
			match("SET DATABASE"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__44"

	// $ANTLR start "T__45"
	public final void mT__45() throws RecognitionException {
		try {
			int _type = T__45;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:56:7: ( 'START' )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:56:9: 'START'
			{
			match("START"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__45"

	// $ANTLR start "T__46"
	public final void mT__46() throws RecognitionException {
		try {
			int _type = T__46;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:57:7: ( 'STOP' )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:57:9: 'STOP'
			{
			match("STOP"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__46"

	// $ANTLR start "T__47"
	public final void mT__47() throws RecognitionException {
		try {
			int _type = T__47;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:58:7: ( 'Set' )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:58:9: 'Set'
			{
			match("Set"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__47"

	// $ANTLR start "T__48"
	public final void mT__48() throws RecognitionException {
		try {
			int _type = T__48;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:59:7: ( 'UPDATE' )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:59:9: 'UPDATE'
			{
			match("UPDATE"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__48"

	// $ANTLR start "T__49"
	public final void mT__49() throws RecognitionException {
		try {
			int _type = T__49;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:60:7: ( 'VALUES' )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:60:9: 'VALUES'
			{
			match("VALUES"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__49"

	// $ANTLR start "T__50"
	public final void mT__50() throws RecognitionException {
		try {
			int _type = T__50;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:61:7: ( 'WHERE' )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:61:9: 'WHERE'
			{
			match("WHERE"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__50"

	// $ANTLR start "T__51"
	public final void mT__51() throws RecognitionException {
		try {
			int _type = T__51;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:62:7: ( 'is not null' )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:62:9: 'is not null'
			{
			match("is not null"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__51"

	// $ANTLR start "T__52"
	public final void mT__52() throws RecognitionException {
		try {
			int _type = T__52;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:63:7: ( 'is null' )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:63:9: 'is null'
			{
			match("is null"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__52"

	// $ANTLR start "T__53"
	public final void mT__53() throws RecognitionException {
		try {
			int _type = T__53;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:64:7: ( 'like' )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:64:9: 'like'
			{
			match("like"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__53"

	// $ANTLR start "T__54"
	public final void mT__54() throws RecognitionException {
		try {
			int _type = T__54;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:65:7: ( 'not' )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:65:9: 'not'
			{
			match("not"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__54"

	// $ANTLR start "AggregateFunctions"
	public final void mAggregateFunctions() throws RecognitionException {
		try {
			int _type = AggregateFunctions;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:370:2: ( ( 'COUNT' '(' Identifier ')' ) | 'AVERAGE' '(' Identifier ')' | 'MIN' '(' Identifier ')' | 'MAX' '(' Identifier ')' )
			int alt1=4;
			switch ( input.LA(1) ) {
			case 'C':
				{
				alt1=1;
				}
				break;
			case 'A':
				{
				alt1=2;
				}
				break;
			case 'M':
				{
				int LA1_3 = input.LA(2);
				if ( (LA1_3=='I') ) {
					alt1=3;
				}
				else if ( (LA1_3=='A') ) {
					alt1=4;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 1, 3, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 1, 0, input);
				throw nvae;
			}
			switch (alt1) {
				case 1 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:370:4: ( 'COUNT' '(' Identifier ')' )
					{
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:370:4: ( 'COUNT' '(' Identifier ')' )
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:370:5: 'COUNT' '(' Identifier ')'
					{
					match("COUNT"); 

					match('('); 
					mIdentifier(); 

					match(')'); 
					}

					}
					break;
				case 2 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:370:35: 'AVERAGE' '(' Identifier ')'
					{
					match("AVERAGE"); 

					match('('); 
					mIdentifier(); 

					match(')'); 
					}
					break;
				case 3 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:370:65: 'MIN' '(' Identifier ')'
					{
					match("MIN"); 

					match('('); 
					mIdentifier(); 

					match(')'); 
					}
					break;
				case 4 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:370:91: 'MAX' '(' Identifier ')'
					{
					match("MAX"); 

					match('('); 
					mIdentifier(); 

					match(')'); 
					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "AggregateFunctions"

	// $ANTLR start "Types"
	public final void mTypes() throws RecognitionException {
		try {
			int _type = Types;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			CommonToken id1=null;
			CommonToken id2=null;
			CommonToken id3=null;
			CommonToken id4=null;
			CommonToken id5=null;
			CommonToken id7=null;
			CommonToken id8=null;

			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:395:6: (id1= 'INTEGER' |id2= 'DECIMAL' '(' id3= Identifier ',' id4= Identifier ')' |id5= 'CHAR' '(' Identifier ')' |id7= 'VARCHAR' |id8= 'DATETIME' )
			int alt2=5;
			switch ( input.LA(1) ) {
			case 'I':
				{
				alt2=1;
				}
				break;
			case 'D':
				{
				int LA2_2 = input.LA(2);
				if ( (LA2_2=='E') ) {
					alt2=2;
				}
				else if ( (LA2_2=='A') ) {
					alt2=5;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 2, 2, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case 'C':
				{
				alt2=3;
				}
				break;
			case 'V':
				{
				alt2=4;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}
			switch (alt2) {
				case 1 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:396:2: id1= 'INTEGER'
					{
					int id1Start = getCharIndex();
					match("INTEGER"); 
					int id1StartLine418 = getLine();
					int id1StartCharPos418 = getCharPositionInLine();
					id1 = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, id1Start, getCharIndex()-1);
					id1.setLine(id1StartLine418);
					id1.setCharPositionInLine(id1StartCharPos418);

					}
					break;
				case 2 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:396:19: id2= 'DECIMAL' '(' id3= Identifier ',' id4= Identifier ')'
					{
					int id2Start = getCharIndex();
					match("DECIMAL"); 
					int id2StartLine425 = getLine();
					int id2StartCharPos425 = getCharPositionInLine();
					id2 = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, id2Start, getCharIndex()-1);
					id2.setLine(id2StartLine425);
					id2.setCharPositionInLine(id2StartCharPos425);

					match('('); 
					int id3Start430 = getCharIndex();
					int id3StartLine430 = getLine();
					int id3StartCharPos430 = getCharPositionInLine();
					mIdentifier(); 
					id3 = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, id3Start430, getCharIndex()-1);
					id3.setLine(id3StartLine430);
					id3.setCharPositionInLine(id3StartCharPos430);

					match(','); 
					int id4Start436 = getCharIndex();
					int id4StartLine436 = getLine();
					int id4StartCharPos436 = getCharPositionInLine();
					mIdentifier(); 
					id4 = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, id4Start436, getCharIndex()-1);
					id4.setLine(id4StartLine436);
					id4.setCharPositionInLine(id4StartCharPos436);

					match(')'); 
					}
					break;
				case 3 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:397:3: id5= 'CHAR' '(' Identifier ')'
					{
					int id5Start = getCharIndex();
					match("CHAR"); 
					int id5StartLine446 = getLine();
					int id5StartCharPos446 = getCharPositionInLine();
					id5 = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, id5Start, getCharIndex()-1);
					id5.setLine(id5StartLine446);
					id5.setCharPositionInLine(id5StartCharPos446);

					match('('); 
					mIdentifier(); 

					match(')'); 
					}
					break;
				case 4 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:397:35: id7= 'VARCHAR'
					{
					int id7Start = getCharIndex();
					match("VARCHAR"); 
					int id7StartLine458 = getLine();
					int id7StartCharPos458 = getCharPositionInLine();
					id7 = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, id7Start, getCharIndex()-1);
					id7.setLine(id7StartLine458);
					id7.setCharPositionInLine(id7StartCharPos458);

					}
					break;
				case 5 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:397:52: id8= 'DATETIME'
					{
					int id8Start = getCharIndex();
					match("DATETIME"); 
					int id8StartLine465 = getLine();
					int id8StartCharPos465 = getCharPositionInLine();
					id8 = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, id8Start, getCharIndex()-1);
					id8.setLine(id8StartLine465);
					id8.setCharPositionInLine(id8StartCharPos465);

					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Types"

	// $ANTLR start "Nullability"
	public final void mNullability() throws RecognitionException {
		try {
			int _type = Nullability;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:405:2: ( 'NULL' | 'NOT NULL' )
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0=='N') ) {
				int LA3_1 = input.LA(2);
				if ( (LA3_1=='U') ) {
					alt3=1;
				}
				else if ( (LA3_1=='O') ) {
					alt3=2;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 3, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 3, 0, input);
				throw nvae;
			}

			switch (alt3) {
				case 1 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:405:4: 'NULL'
					{
					match("NULL"); 

					}
					break;
				case 2 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:405:12: 'NOT NULL'
					{
					match("NOT NULL"); 

					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Nullability"

	// $ANTLR start "LogicToken"
	public final void mLogicToken() throws RecognitionException {
		try {
			int _type = LogicToken;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:417:2: ( 'AND' | 'OR' )
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0=='A') ) {
				alt4=1;
			}
			else if ( (LA4_0=='O') ) {
				alt4=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 4, 0, input);
				throw nvae;
			}

			switch (alt4) {
				case 1 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:417:4: 'AND'
					{
					match("AND"); 

					}
					break;
				case 2 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:417:12: 'OR'
					{
					match("OR"); 

					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LogicToken"

	// $ANTLR start "Identifier"
	public final void mIdentifier() throws RecognitionException {
		try {
			int _type = Identifier;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:420:3: ( LETTER ( LETTER | DIGIT )* | DIGIT ( DIGIT | LETTER )* | ( DIGIT )* )
			int alt8=3;
			switch ( input.LA(1) ) {
			case 'A':
			case 'B':
			case 'C':
			case 'D':
			case 'E':
			case 'F':
			case 'G':
			case 'H':
			case 'I':
			case 'J':
			case 'K':
			case 'L':
			case 'M':
			case 'N':
			case 'O':
			case 'P':
			case 'Q':
			case 'R':
			case 'S':
			case 'T':
			case 'U':
			case 'V':
			case 'W':
			case 'X':
			case 'Y':
			case 'Z':
			case 'a':
			case 'b':
			case 'c':
			case 'd':
			case 'e':
			case 'f':
			case 'g':
			case 'h':
			case 'i':
			case 'j':
			case 'k':
			case 'l':
			case 'm':
			case 'n':
			case 'o':
			case 'p':
			case 'q':
			case 'r':
			case 's':
			case 't':
			case 'u':
			case 'v':
			case 'w':
			case 'x':
			case 'y':
			case 'z':
				{
				alt8=1;
				}
				break;
			case '0':
			case '1':
			case '2':
			case '3':
			case '4':
			case '5':
			case '6':
			case '7':
			case '8':
			case '9':
				{
				alt8=2;
				}
				break;
			default:
				alt8=3;
			}
			switch (alt8) {
				case 1 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:420:6: LETTER ( LETTER | DIGIT )*
					{
					mLETTER(); 

					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:420:13: ( LETTER | DIGIT )*
					loop5:
					while (true) {
						int alt5=2;
						int LA5_0 = input.LA(1);
						if ( ((LA5_0 >= '0' && LA5_0 <= '9')||(LA5_0 >= 'A' && LA5_0 <= 'Z')||(LA5_0 >= 'a' && LA5_0 <= 'z')) ) {
							alt5=1;
						}

						switch (alt5) {
						case 1 :
							// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:
							{
							if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
								input.consume();
							}
							else {
								MismatchedSetException mse = new MismatchedSetException(null,input);
								recover(mse);
								throw mse;
							}
							}
							break;

						default :
							break loop5;
						}
					}

					}
					break;
				case 2 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:420:34: DIGIT ( DIGIT | LETTER )*
					{
					mDIGIT(); 

					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:420:40: ( DIGIT | LETTER )*
					loop6:
					while (true) {
						int alt6=2;
						int LA6_0 = input.LA(1);
						if ( ((LA6_0 >= '0' && LA6_0 <= '9')||(LA6_0 >= 'A' && LA6_0 <= 'Z')||(LA6_0 >= 'a' && LA6_0 <= 'z')) ) {
							alt6=1;
						}

						switch (alt6) {
						case 1 :
							// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:
							{
							if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
								input.consume();
							}
							else {
								MismatchedSetException mse = new MismatchedSetException(null,input);
								recover(mse);
								throw mse;
							}
							}
							break;

						default :
							break loop6;
						}
					}

					}
					break;
				case 3 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:420:58: ( DIGIT )*
					{
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:420:58: ( DIGIT )*
					loop7:
					while (true) {
						int alt7=2;
						int LA7_0 = input.LA(1);
						if ( ((LA7_0 >= '0' && LA7_0 <= '9')) ) {
							alt7=1;
						}

						switch (alt7) {
						case 1 :
							// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:
							{
							if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
								input.consume();
							}
							else {
								MismatchedSetException mse = new MismatchedSetException(null,input);
								recover(mse);
								throw mse;
							}
							}
							break;

						default :
							break loop7;
						}
					}

					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Identifier"

	// $ANTLR start "LETTER"
	public final void mLETTER() throws RecognitionException {
		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:423:17: ( ( 'a' .. 'z' | 'A' .. 'Z' ) )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:
			{
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LETTER"

	// $ANTLR start "DIGIT"
	public final void mDIGIT() throws RecognitionException {
		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:424:16: ( '0' .. '9' )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:
			{
			if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DIGIT"

	// $ANTLR start "WS"
	public final void mWS() throws RecognitionException {
		try {
			int _type = WS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:426:4: ( ( ' ' | '\\n' | '\\t' )+ )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:426:6: ( ' ' | '\\n' | '\\t' )+
			{
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:426:6: ( ' ' | '\\n' | '\\t' )+
			int cnt9=0;
			loop9:
			while (true) {
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( ((LA9_0 >= '\t' && LA9_0 <= '\n')||LA9_0==' ') ) {
					alt9=1;
				}

				switch (alt9) {
				case 1 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:
					{
					if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||input.LA(1)==' ' ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt9 >= 1 ) break loop9;
					EarlyExitException eee = new EarlyExitException(9, input);
					throw eee;
				}
				cnt9++;
			}

			_channel = HIDDEN;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WS"

	@Override
	public void mTokens() throws RecognitionException {
		// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:1:8: ( T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | AggregateFunctions | Types | Nullability | LogicToken | Identifier | WS )
		int alt10=49;
		alt10 = dfa10.predict(input);
		switch (alt10) {
			case 1 :
				// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:1:10: T__12
				{
				mT__12(); 

				}
				break;
			case 2 :
				// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:1:16: T__13
				{
				mT__13(); 

				}
				break;
			case 3 :
				// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:1:22: T__14
				{
				mT__14(); 

				}
				break;
			case 4 :
				// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:1:28: T__15
				{
				mT__15(); 

				}
				break;
			case 5 :
				// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:1:34: T__16
				{
				mT__16(); 

				}
				break;
			case 6 :
				// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:1:40: T__17
				{
				mT__17(); 

				}
				break;
			case 7 :
				// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:1:46: T__18
				{
				mT__18(); 

				}
				break;
			case 8 :
				// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:1:52: T__19
				{
				mT__19(); 

				}
				break;
			case 9 :
				// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:1:58: T__20
				{
				mT__20(); 

				}
				break;
			case 10 :
				// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:1:64: T__21
				{
				mT__21(); 

				}
				break;
			case 11 :
				// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:1:70: T__22
				{
				mT__22(); 

				}
				break;
			case 12 :
				// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:1:76: T__23
				{
				mT__23(); 

				}
				break;
			case 13 :
				// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:1:82: T__24
				{
				mT__24(); 

				}
				break;
			case 14 :
				// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:1:88: T__25
				{
				mT__25(); 

				}
				break;
			case 15 :
				// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:1:94: T__26
				{
				mT__26(); 

				}
				break;
			case 16 :
				// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:1:100: T__27
				{
				mT__27(); 

				}
				break;
			case 17 :
				// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:1:106: T__28
				{
				mT__28(); 

				}
				break;
			case 18 :
				// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:1:112: T__29
				{
				mT__29(); 

				}
				break;
			case 19 :
				// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:1:118: T__30
				{
				mT__30(); 

				}
				break;
			case 20 :
				// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:1:124: T__31
				{
				mT__31(); 

				}
				break;
			case 21 :
				// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:1:130: T__32
				{
				mT__32(); 

				}
				break;
			case 22 :
				// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:1:136: T__33
				{
				mT__33(); 

				}
				break;
			case 23 :
				// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:1:142: T__34
				{
				mT__34(); 

				}
				break;
			case 24 :
				// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:1:148: T__35
				{
				mT__35(); 

				}
				break;
			case 25 :
				// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:1:154: T__36
				{
				mT__36(); 

				}
				break;
			case 26 :
				// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:1:160: T__37
				{
				mT__37(); 

				}
				break;
			case 27 :
				// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:1:166: T__38
				{
				mT__38(); 

				}
				break;
			case 28 :
				// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:1:172: T__39
				{
				mT__39(); 

				}
				break;
			case 29 :
				// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:1:178: T__40
				{
				mT__40(); 

				}
				break;
			case 30 :
				// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:1:184: T__41
				{
				mT__41(); 

				}
				break;
			case 31 :
				// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:1:190: T__42
				{
				mT__42(); 

				}
				break;
			case 32 :
				// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:1:196: T__43
				{
				mT__43(); 

				}
				break;
			case 33 :
				// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:1:202: T__44
				{
				mT__44(); 

				}
				break;
			case 34 :
				// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:1:208: T__45
				{
				mT__45(); 

				}
				break;
			case 35 :
				// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:1:214: T__46
				{
				mT__46(); 

				}
				break;
			case 36 :
				// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:1:220: T__47
				{
				mT__47(); 

				}
				break;
			case 37 :
				// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:1:226: T__48
				{
				mT__48(); 

				}
				break;
			case 38 :
				// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:1:232: T__49
				{
				mT__49(); 

				}
				break;
			case 39 :
				// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:1:238: T__50
				{
				mT__50(); 

				}
				break;
			case 40 :
				// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:1:244: T__51
				{
				mT__51(); 

				}
				break;
			case 41 :
				// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:1:250: T__52
				{
				mT__52(); 

				}
				break;
			case 42 :
				// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:1:256: T__53
				{
				mT__53(); 

				}
				break;
			case 43 :
				// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:1:262: T__54
				{
				mT__54(); 

				}
				break;
			case 44 :
				// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:1:268: AggregateFunctions
				{
				mAggregateFunctions(); 

				}
				break;
			case 45 :
				// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:1:287: Types
				{
				mTypes(); 

				}
				break;
			case 46 :
				// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:1:293: Nullability
				{
				mNullability(); 

				}
				break;
			case 47 :
				// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:1:305: LogicToken
				{
				mLogicToken(); 

				}
				break;
			case 48 :
				// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:1:316: Identifier
				{
				mIdentifier(); 

				}
				break;
			case 49 :
				// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:1:327: WS
				{
				mWS(); 

				}
				break;

		}
	}


	protected DFA10 dfa10 = new DFA10(this);
	static final String DFA10_eotS =
		"\1\35\10\uffff\24\35\2\uffff\2\35\1\105\20\35\1\131\1\132\17\35\1\155"+
		"\1\35\1\uffff\1\35\1\132\21\35\2\uffff\6\35\1\u0088\4\35\1\uffff\1\35"+
		"\1\u008f\4\35\1\uffff\13\35\1\uffff\1\35\1\u00a1\1\uffff\3\35\1\u00a5"+
		"\4\35\1\uffff\1\35\1\u00ab\1\uffff\4\35\1\uffff\1\u00b2\2\uffff\1\u0092"+
		"\1\uffff\5\35\1\uffff\3\35\1\uffff\1\35\2\uffff\1\35\1\uffff\3\35\2\uffff"+
		"\3\35\1\u00c4\1\uffff\3\35\1\u00c8\4\uffff\3\35\1\u00cc\2\35\2\uffff\2"+
		"\35\1\uffff\4\35\1\u00d5\1\uffff\1\u00d6\1\u00d7\1\35\1\uffff\2\35\2\uffff"+
		"\4\35\1\uffff\1\u0098\2\35\3\uffff\1\u0098\1\35\4\uffff\1\u0098\2\uffff"+
		"\3\35\1\u00e6\1\u00e7\2\uffff";
	static final String DFA10_eofS =
		"\u00e8\uffff";
	static final String DFA10_minS =
		"\1\11\10\uffff\1\104\1\110\1\101\1\117\1\105\1\116\1\117\1\111\1\116\1"+
		"\122\2\105\1\120\1\101\1\110\1\163\1\151\1\157\1\101\1\117\2\uffff\1\104"+
		"\1\124\1\60\1\105\1\104\1\116\1\105\1\101\1\103\1\123\1\117\1\124\1\122"+
		"\1\117\1\124\1\117\1\123\1\111\1\123\2\60\1\111\1\106\1\114\1\101\1\164"+
		"\1\104\1\114\1\105\1\40\1\153\1\164\1\116\1\130\1\114\1\124\1\60\1\105"+
		"\1\uffff\1\122\1\60\1\123\1\116\1\101\1\122\1\105\1\111\2\120\1\105\1"+
		"\40\1\115\1\40\1\125\2\105\1\116\1\124\2\uffff\1\115\2\105\1\40\1\122"+
		"\1\120\1\60\1\101\1\125\1\103\1\122\1\156\1\145\1\60\2\50\1\114\1\40\1"+
		"\uffff\1\122\1\101\3\124\1\50\1\124\1\115\1\114\1\40\1\124\1\112\1\111"+
		"\1\60\1\uffff\1\120\1\122\1\107\1\60\1\40\1\101\1\122\1\103\1\uffff\1"+
		"\124\1\60\1\uffff\1\124\1\105\1\110\1\105\1\157\1\60\2\uffff\1\60\1\uffff"+
		"\1\40\1\107\1\122\1\50\1\105\1\uffff\1\105\2\101\1\104\1\111\2\uffff\1"+
		"\107\1\uffff\1\40\1\124\1\105\2\uffff\1\122\1\105\1\124\1\60\1\uffff\1"+
		"\105\1\123\1\101\1\60\4\uffff\1\105\1\101\1\40\1\60\1\114\1\131\2\uffff"+
		"\1\115\1\116\1\uffff\1\40\1\122\1\131\1\116\1\60\1\uffff\2\60\1\122\1"+
		"\uffff\1\50\1\111\1\104\1\uffff\1\50\1\40\1\105\1\40\1\uffff\1\60\1\40"+
		"\1\103\3\uffff\1\60\1\116\4\uffff\1\60\2\uffff\1\105\1\124\1\123\2\60"+
		"\2\uffff";
	static final String DFA10_maxS =
		"\1\156\10\uffff\1\126\4\122\1\116\1\117\1\111\2\122\1\105\1\145\1\120"+
		"\1\101\1\110\1\163\1\151\1\157\1\111\1\125\2\uffff\1\104\1\124\1\172\1"+
		"\105\1\104\1\125\1\105\1\101\1\114\1\123\1\117\1\124\1\122\1\117\1\124"+
		"\1\117\1\124\1\111\1\123\2\172\1\111\1\106\1\124\1\117\1\164\1\104\1\122"+
		"\1\105\1\40\1\153\1\164\1\116\1\130\1\114\1\124\1\172\1\105\1\uffff\1"+
		"\122\1\172\1\123\1\116\1\101\1\122\1\105\1\111\2\120\2\105\1\115\1\40"+
		"\1\125\2\105\1\116\1\124\2\uffff\1\115\2\105\1\40\1\122\1\120\1\172\1"+
		"\101\1\125\1\103\1\122\1\156\1\145\1\172\2\50\1\114\1\40\1\uffff\1\122"+
		"\1\101\3\124\1\50\1\124\1\115\1\114\1\40\1\124\1\130\1\111\1\172\1\uffff"+
		"\1\120\1\122\1\107\1\172\1\40\1\101\1\122\1\103\1\uffff\1\124\1\172\1"+
		"\uffff\1\124\1\105\1\110\1\105\1\165\1\172\2\uffff\1\172\1\uffff\1\40"+
		"\1\107\1\122\1\50\1\105\1\uffff\1\105\2\101\1\124\1\111\2\uffff\1\107"+
		"\1\uffff\1\40\1\124\1\105\2\uffff\1\122\1\105\1\124\1\172\1\uffff\1\105"+
		"\1\123\1\101\1\172\4\uffff\1\105\1\101\1\40\1\172\1\114\1\131\2\uffff"+
		"\1\115\1\116\1\uffff\1\40\1\122\1\131\1\116\1\172\1\uffff\2\172\1\122"+
		"\1\uffff\1\50\1\111\1\124\1\uffff\1\50\1\40\1\105\1\40\1\uffff\1\172\1"+
		"\40\1\103\3\uffff\1\172\1\116\4\uffff\1\172\2\uffff\1\105\1\124\1\123"+
		"\2\172\2\uffff";
	static final String DFA10_acceptS =
		"\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\24\uffff\1\60\1\61\46\uffff"+
		"\1\13\23\uffff\1\35\1\57\22\uffff\1\11\16\uffff\1\30\10\uffff\1\41\2\uffff"+
		"\1\44\6\uffff\1\53\1\54\1\uffff\1\56\5\uffff\1\55\5\uffff\1\24\1\25\1"+
		"\uffff\1\27\3\uffff\1\33\1\34\4\uffff\1\43\4\uffff\1\50\1\51\1\52\1\12"+
		"\6\uffff\1\22\1\23\2\uffff\1\31\5\uffff\1\42\3\uffff\1\47\3\uffff\1\20"+
		"\4\uffff\1\32\3\uffff\1\40\1\45\1\46\2\uffff\1\15\1\16\1\17\1\21\1\uffff"+
		"\1\26\1\36\5\uffff\1\14\1\37";
	static final String DFA10_specialS =
		"\u00e8\uffff}>";
	static final String[] DFA10_transitionS = {
			"\2\36\25\uffff\1\36\7\uffff\1\1\1\2\1\3\1\uffff\1\4\1\uffff\1\5\15\uffff"+
			"\1\6\1\7\1\10\2\uffff\1\11\1\uffff\1\12\1\13\1\uffff\1\14\1\15\1\uffff"+
			"\1\16\1\17\1\uffff\1\20\1\33\1\34\1\21\1\22\1\uffff\1\23\1\24\1\uffff"+
			"\1\25\1\26\1\27\21\uffff\1\30\2\uffff\1\31\1\uffff\1\32",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\37\7\uffff\1\40\1\uffff\1\43\4\uffff\1\41\2\uffff\1\42",
			"\1\46\6\uffff\1\44\2\uffff\1\45",
			"\1\52\3\uffff\1\47\3\uffff\1\50\10\uffff\1\51",
			"\1\53\2\uffff\1\54",
			"\1\55\14\uffff\1\56",
			"\1\57",
			"\1\60",
			"\1\61",
			"\1\62\3\uffff\1\63",
			"\1\64",
			"\1\65",
			"\1\66\16\uffff\1\67\20\uffff\1\70",
			"\1\71",
			"\1\72",
			"\1\73",
			"\1\74",
			"\1\75",
			"\1\76",
			"\1\100\7\uffff\1\77",
			"\1\102\5\uffff\1\101",
			"",
			"",
			"\1\103",
			"\1\104",
			"\12\35\7\uffff\32\35\6\uffff\32\35",
			"\1\106",
			"\1\107",
			"\1\110\6\uffff\1\111",
			"\1\112",
			"\1\113",
			"\1\115\10\uffff\1\114",
			"\1\116",
			"\1\117",
			"\1\120",
			"\1\121",
			"\1\122",
			"\1\123",
			"\1\124",
			"\1\125\1\126",
			"\1\127",
			"\1\130",
			"\12\35\7\uffff\32\35\6\uffff\32\35",
			"\12\35\7\uffff\32\35\6\uffff\32\35",
			"\1\133",
			"\1\134",
			"\1\135\7\uffff\1\136",
			"\1\137\15\uffff\1\140",
			"\1\141",
			"\1\142",
			"\1\143\5\uffff\1\144",
			"\1\145",
			"\1\146",
			"\1\147",
			"\1\150",
			"\1\151",
			"\1\152",
			"\1\153",
			"\1\154",
			"\12\35\7\uffff\32\35\6\uffff\32\35",
			"\1\156",
			"",
			"\1\157",
			"\12\35\7\uffff\32\35\6\uffff\32\35",
			"\1\160",
			"\1\161",
			"\1\162",
			"\1\163",
			"\1\164",
			"\1\165",
			"\1\166",
			"\1\167",
			"\1\170",
			"\1\171\44\uffff\1\172",
			"\1\173",
			"\1\174",
			"\1\175",
			"\1\176",
			"\1\177",
			"\1\u0080",
			"\1\u0081",
			"",
			"",
			"\1\u0082",
			"\1\u0083",
			"\1\u0084",
			"\1\u0085",
			"\1\u0086",
			"\1\u0087",
			"\12\35\7\uffff\32\35\6\uffff\32\35",
			"\1\u0089",
			"\1\u008a",
			"\1\u008b",
			"\1\u008c",
			"\1\u008d",
			"\1\u008e",
			"\12\35\7\uffff\32\35\6\uffff\32\35",
			"\1\u0090",
			"\1\u0090",
			"\1\u0091",
			"\1\u0092",
			"",
			"\1\u0093",
			"\1\u0094",
			"\1\u0095",
			"\1\u0096",
			"\1\u0097",
			"\1\u0098",
			"\1\u0099",
			"\1\u009a",
			"\1\u009b",
			"\1\u009c",
			"\1\u009d",
			"\1\u009e\15\uffff\1\u009f",
			"\1\u00a0",
			"\12\35\7\uffff\32\35\6\uffff\32\35",
			"",
			"\1\u00a2",
			"\1\u00a3",
			"\1\u00a4",
			"\12\35\7\uffff\32\35\6\uffff\32\35",
			"\1\u00a6",
			"\1\u00a7",
			"\1\u00a8",
			"\1\u00a9",
			"",
			"\1\u00aa",
			"\12\35\7\uffff\32\35\6\uffff\32\35",
			"",
			"\1\u00ac",
			"\1\u00ad",
			"\1\u00ae",
			"\1\u00af",
			"\1\u00b0\5\uffff\1\u00b1",
			"\12\35\7\uffff\32\35\6\uffff\32\35",
			"",
			"",
			"\12\35\7\uffff\32\35\6\uffff\32\35",
			"",
			"\1\u00b3",
			"\1\u00b4",
			"\1\u00b5",
			"\1\u0090",
			"\1\u00b6",
			"",
			"\1\u00b7",
			"\1\u00b8",
			"\1\u00b9",
			"\1\u00ba\17\uffff\1\u00bb",
			"\1\u00bc",
			"",
			"",
			"\1\u00bd",
			"",
			"\1\u00be",
			"\1\u00bf",
			"\1\u00c0",
			"",
			"",
			"\1\u00c1",
			"\1\u00c2",
			"\1\u00c3",
			"\12\35\7\uffff\32\35\6\uffff\32\35",
			"",
			"\1\u00c5",
			"\1\u00c6",
			"\1\u00c7",
			"\12\35\7\uffff\32\35\6\uffff\32\35",
			"",
			"",
			"",
			"",
			"\1\u00c9",
			"\1\u00ca",
			"\1\u00cb",
			"\12\35\7\uffff\32\35\6\uffff\32\35",
			"\1\u00cd",
			"\1\u00ce",
			"",
			"",
			"\1\u00cf",
			"\1\u00d0",
			"",
			"\1\u00d1",
			"\1\u00d2",
			"\1\u00d3",
			"\1\u00d4",
			"\12\35\7\uffff\32\35\6\uffff\32\35",
			"",
			"\12\35\7\uffff\32\35\6\uffff\32\35",
			"\12\35\7\uffff\32\35\6\uffff\32\35",
			"\1\u00d8",
			"",
			"\1\u0090",
			"\1\u00d9",
			"\1\u00da\4\uffff\1\u00db\12\uffff\1\u00dc",
			"",
			"\1\u0098",
			"\1\u00dd",
			"\1\u00de",
			"\1\u00df",
			"",
			"\12\35\7\uffff\32\35\6\uffff\32\35",
			"\1\u00e0",
			"\1\u00e1",
			"",
			"",
			"",
			"\12\35\7\uffff\32\35\6\uffff\32\35",
			"\1\u00e2",
			"",
			"",
			"",
			"",
			"\12\35\7\uffff\32\35\6\uffff\32\35",
			"",
			"",
			"\1\u00e3",
			"\1\u00e4",
			"\1\u00e5",
			"\12\35\7\uffff\32\35\6\uffff\32\35",
			"\12\35\7\uffff\32\35\6\uffff\32\35",
			"",
			""
	};

	static final short[] DFA10_eot = DFA.unpackEncodedString(DFA10_eotS);
	static final short[] DFA10_eof = DFA.unpackEncodedString(DFA10_eofS);
	static final char[] DFA10_min = DFA.unpackEncodedStringToUnsignedChars(DFA10_minS);
	static final char[] DFA10_max = DFA.unpackEncodedStringToUnsignedChars(DFA10_maxS);
	static final short[] DFA10_accept = DFA.unpackEncodedString(DFA10_acceptS);
	static final short[] DFA10_special = DFA.unpackEncodedString(DFA10_specialS);
	static final short[][] DFA10_transition;

	static {
		int numStates = DFA10_transitionS.length;
		DFA10_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA10_transition[i] = DFA.unpackEncodedString(DFA10_transitionS[i]);
		}
	}

	protected class DFA10 extends DFA {

		public DFA10(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 10;
			this.eot = DFA10_eot;
			this.eof = DFA10_eof;
			this.min = DFA10_min;
			this.max = DFA10_max;
			this.accept = DFA10_accept;
			this.special = DFA10_special;
			this.transition = DFA10_transition;
		}
		@Override
		public String getDescription() {
			return "1:1: Tokens : ( T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | AggregateFunctions | Types | Nullability | LogicToken | Identifier | WS );";
		}
	}

}
