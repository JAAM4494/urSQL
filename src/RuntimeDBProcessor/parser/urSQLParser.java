// $ANTLR 3.5.1 /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g 2015-09-03 20:05:20
package RuntimeDBProcessor.parser;

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class urSQLParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "DIGIT", "Identifier", "LETTER", 
		"WS", "'CREATE'", "'DATABASE'", "'DATABASES'", "'DISPLAY'", "'DROP'", 
		"'LIST'", "'START'", "'STOP'"
	};
        
	public static final int EOF=-1;
	public static final int T__8=8;
	public static final int T__9=9;
	public static final int T__10=10;
	public static final int T__11=11;
	public static final int T__12=12;
	public static final int T__13=13;
	public static final int T__14=14;
	public static final int T__15=15;
	public static final int DIGIT=4;
	public static final int Identifier=5;
	public static final int LETTER=6;
	public static final int WS=7;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public urSQLParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public urSQLParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return urSQLParser.tokenNames; }
	@Override public String getGrammarFileName() { return "/Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g"; }



	// $ANTLR start "createDB"
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:3:1: createDB : 'CREATE' 'DATABASE' Identifier ;
	public final void createDB() throws RecognitionException {
		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:4:2: ( 'CREATE' 'DATABASE' Identifier )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:4:4: 'CREATE' 'DATABASE' Identifier
			{
			match(input,8,FOLLOW_8_in_createDB11); 
			match(input,9,FOLLOW_9_in_createDB13); 
			match(input,Identifier,FOLLOW_Identifier_in_createDB15); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "createDB"



	// $ANTLR start "dropDB"
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:6:1: dropDB : 'DROP' 'DATABASE' Identifier ;
	public final void dropDB() throws RecognitionException {
		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:7:2: ( 'DROP' 'DATABASE' Identifier )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:7:4: 'DROP' 'DATABASE' Identifier
			{
			match(input,12,FOLLOW_12_in_dropDB24); 
			match(input,9,FOLLOW_9_in_dropDB26); 
			match(input,Identifier,FOLLOW_Identifier_in_dropDB28); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "dropDB"



	// $ANTLR start "listDB"
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:9:1: listDB : 'LIST' 'DATABASES' ;
	public final void listDB() throws RecognitionException {
		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:9:8: ( 'LIST' 'DATABASES' )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:9:10: 'LIST' 'DATABASES'
			{
			match(input,13,FOLLOW_13_in_listDB38); 
			match(input,10,FOLLOW_10_in_listDB40); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "listDB"



	// $ANTLR start "startDB"
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:11:1: startDB : 'START' ;
	public final void startDB() throws RecognitionException {
		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:11:9: ( 'START' )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:11:11: 'START'
			{
			match(input,14,FOLLOW_14_in_startDB48); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "startDB"



	// $ANTLR start "stopDB"
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:14:1: stopDB : 'STOP' ;
	public final void stopDB() throws RecognitionException {
		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:14:8: ( 'STOP' )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:14:10: 'STOP'
			{
			match(input,15,FOLLOW_15_in_stopDB57); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "stopDB"



	// $ANTLR start "displayDB"
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:16:1: displayDB : 'DISPLAY' 'DATABASE' Identifier ;
	public final void displayDB() throws RecognitionException {
		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:17:2: ( 'DISPLAY' 'DATABASE' Identifier )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:17:4: 'DISPLAY' 'DATABASE' Identifier
			{
			match(input,11,FOLLOW_11_in_displayDB67); 
			match(input,9,FOLLOW_9_in_displayDB69); 
			match(input,Identifier,FOLLOW_Identifier_in_displayDB71); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "displayDB"

	// Delegated rules



	public static final BitSet FOLLOW_8_in_createDB11 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_9_in_createDB13 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_Identifier_in_createDB15 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_12_in_dropDB24 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_9_in_dropDB26 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_Identifier_in_dropDB28 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_13_in_listDB38 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_10_in_listDB40 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_14_in_startDB48 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_15_in_stopDB57 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_11_in_displayDB67 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_9_in_displayDB69 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_Identifier_in_displayDB71 = new BitSet(new long[]{0x0000000000000002L});
}
