// $ANTLR 3.5.1 /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g 2015-09-21 16:10:18
package RuntimeDBProcessor.parser;
   


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class urSQLParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "AggregateFunctions", "CompareOperator", 
		"DIGIT", "Identifier", "LETTER", "Nullability", "Number", "Type", "WS", 
		"'('", "')'", "');'", "'*'", "','", "'.'", "'='", "'ADD'", "'ALTER TABLE'", 
		"'AS'", "'CONSTRAINT'", "'CREATE DATABASE'", "'CREATE INDEX'", "'CREATE TABLE'", 
		"'DELETE'", "'DISPLAY DATABASE'", "'DROP DATABASE'", "'DROP TABLE'", "'FOR JSON'", 
		"'FOR XML'", "'FOREIGN KEY'", "'FROM'", "'GROUP BY'", "'INSERT'", "'INTO'", 
		"'JOIN'", "'LIST DATABASES'", "'ON'", "'PRIMARY KEY('", "'REFERENCES'", 
		"'SELECT'", "'SET DATABASE'", "'SET'", "'START'", "'STOP'", "'UPDATE'", 
		"'VALUES'", "'WHERE'"
	};
	public static final int EOF=-1;
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
	public static final int AggregateFunctions=4;
	public static final int CompareOperator=5;
	public static final int DIGIT=6;
	public static final int Identifier=7;
	public static final int LETTER=8;
	public static final int Nullability=9;
	public static final int Number=10;
	public static final int Type=11;
	public static final int WS=12;

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


		public ArrayList<String> ColumnsSelect = new ArrayList<String>();
		public ArrayList<String> ColumnsInsertInto = new ArrayList<String>();

		
	    	public void displayRecognitionError(String[] tokenNames,
	                                        RecognitionException e) {
	        	String hdr = getErrorHeader(e);
	        	String msg = getErrorMessage(e, tokenNames);
	        	System.out.println("Query malo");
	    
	    }



	// $ANTLR start "query"
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:26:1: query : ( createDB | dropDB | listDB | startDB | stopDB | displayDB );
	public final void query() throws RecognitionException {
		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:26:7: ( createDB | dropDB | listDB | startDB | stopDB | displayDB )
			int alt1=6;
			switch ( input.LA(1) ) {
			case 24:
				{
				alt1=1;
				}
				break;
			case 29:
				{
				alt1=2;
				}
				break;
			case 39:
				{
				alt1=3;
				}
				break;
			case 46:
				{
				alt1=4;
				}
				break;
			case 47:
				{
				alt1=5;
				}
				break;
			case 28:
				{
				alt1=6;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 1, 0, input);
				throw nvae;
			}
			switch (alt1) {
				case 1 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:27:2: createDB
					{
					pushFollow(FOLLOW_createDB_in_query32);
					createDB();
					state._fsp--;

					}
					break;
				case 2 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:27:13: dropDB
					{
					pushFollow(FOLLOW_dropDB_in_query36);
					dropDB();
					state._fsp--;

					}
					break;
				case 3 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:27:22: listDB
					{
					pushFollow(FOLLOW_listDB_in_query40);
					listDB();
					state._fsp--;

					}
					break;
				case 4 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:27:31: startDB
					{
					pushFollow(FOLLOW_startDB_in_query44);
					startDB();
					state._fsp--;

					}
					break;
				case 5 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:27:41: stopDB
					{
					pushFollow(FOLLOW_stopDB_in_query48);
					stopDB();
					state._fsp--;

					}
					break;
				case 6 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:27:50: displayDB
					{
					pushFollow(FOLLOW_displayDB_in_query52);
					displayDB();
					state._fsp--;

					}
					break;

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
	// $ANTLR end "query"



	// $ANTLR start "createDB"
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:30:1: createDB : 'CREATE DATABASE' Identifier ;
	public final void createDB() throws RecognitionException {
		Token Identifier1=null;

		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:31:2: ( 'CREATE DATABASE' Identifier )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:31:4: 'CREATE DATABASE' Identifier
			{
			match(input,24,FOLLOW_24_in_createDB63); 
			Identifier1=(Token)match(input,Identifier,FOLLOW_Identifier_in_createDB65); 

				//System.out.println((Identifier1!=null?Identifier1.getText():null));
				
				//Make actions about db
				 
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
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:38:1: dropDB : 'DROP DATABASE' Identifier ;
	public final void dropDB() throws RecognitionException {
		Token Identifier2=null;

		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:39:2: ( 'DROP DATABASE' Identifier )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:39:4: 'DROP DATABASE' Identifier
			{
			match(input,29,FOLLOW_29_in_dropDB78); 
			Identifier2=(Token)match(input,Identifier,FOLLOW_Identifier_in_dropDB80); 

				//System.out.println((Identifier2!=null?Identifier2.getText():null));
				
				//Make actions about db
				 
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
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:46:1: listDB : 'LIST DATABASES' ;
	public final void listDB() throws RecognitionException {
		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:46:8: ( 'LIST DATABASES' )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:46:10: 'LIST DATABASES'
			{
			match(input,39,FOLLOW_39_in_listDB94); 
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
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:48:1: startDB : 'START' ;
	public final void startDB() throws RecognitionException {
		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:48:9: ( 'START' )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:48:11: 'START'
			{
			match(input,46,FOLLOW_46_in_startDB102); 
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
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:52:1: stopDB : 'STOP' ;
	public final void stopDB() throws RecognitionException {
		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:52:8: ( 'STOP' )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:52:10: 'STOP'
			{
			match(input,47,FOLLOW_47_in_stopDB112); 
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
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:54:1: displayDB : 'DISPLAY DATABASE' Identifier ;
	public final void displayDB() throws RecognitionException {
		Token Identifier3=null;

		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:55:2: ( 'DISPLAY DATABASE' Identifier )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:55:4: 'DISPLAY DATABASE' Identifier
			{
			match(input,28,FOLLOW_28_in_displayDB122); 
			Identifier3=(Token)match(input,Identifier,FOLLOW_Identifier_in_displayDB124); 

				//System.out.println((Identifier3!=null?Identifier3.getText():null));
				
				//Make actions about db
				 
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



	// $ANTLR start "setDB"
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:62:1: setDB : 'SET DATABASE' Identifier ;
	public final void setDB() throws RecognitionException {
		Token Identifier4=null;

		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:63:2: ( 'SET DATABASE' Identifier )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:63:4: 'SET DATABASE' Identifier
			{
			match(input,44,FOLLOW_44_in_setDB137); 
			Identifier4=(Token)match(input,Identifier,FOLLOW_Identifier_in_setDB139); 

				//System.out.println((Identifier4!=null?Identifier4.getText():null));
				
				//Make actions about db
				 
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
	// $ANTLR end "setDB"



	// $ANTLR start "createTable"
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:69:1: createTable : 'CREATE TABLE' Identifier 'AS' '(' columnDefinition ( ',' columnDefinition )* ',' primaryKey ');' ;
	public final void createTable() throws RecognitionException {
		Token Identifier5=null;

		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:70:2: ( 'CREATE TABLE' Identifier 'AS' '(' columnDefinition ( ',' columnDefinition )* ',' primaryKey ');' )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:70:4: 'CREATE TABLE' Identifier 'AS' '(' columnDefinition ( ',' columnDefinition )* ',' primaryKey ');'
			{
			match(input,26,FOLLOW_26_in_createTable151); 
			Identifier5=(Token)match(input,Identifier,FOLLOW_Identifier_in_createTable153); 
			match(input,22,FOLLOW_22_in_createTable154); 
			match(input,13,FOLLOW_13_in_createTable156); 
			pushFollow(FOLLOW_columnDefinition_in_createTable158);
			columnDefinition();
			state._fsp--;

			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:70:57: ( ',' columnDefinition )*
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( (LA2_0==17) ) {
					int LA2_1 = input.LA(2);
					if ( (LA2_1==Identifier) ) {
						alt2=1;
					}

				}

				switch (alt2) {
				case 1 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:70:58: ',' columnDefinition
					{
					match(input,17,FOLLOW_17_in_createTable163); 
					pushFollow(FOLLOW_columnDefinition_in_createTable166);
					columnDefinition();
					state._fsp--;

					}
					break;

				default :
					break loop2;
				}
			}

			match(input,17,FOLLOW_17_in_createTable171); 
			pushFollow(FOLLOW_primaryKey_in_createTable174);
			primaryKey();
			state._fsp--;

			match(input,15,FOLLOW_15_in_createTable176); 

				//System.out.println((Identifier5!=null?Identifier5.getText():null));
				
				
				 
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
	// $ANTLR end "createTable"



	// $ANTLR start "alterTable"
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:76:1: alterTable : 'ALTER TABLE' Identifier 'ADD' 'CONSTRAINT' constraintDefinition ;
	public final void alterTable() throws RecognitionException {
		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:77:2: ( 'ALTER TABLE' Identifier 'ADD' 'CONSTRAINT' constraintDefinition )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:77:4: 'ALTER TABLE' Identifier 'ADD' 'CONSTRAINT' constraintDefinition
			{
			match(input,21,FOLLOW_21_in_alterTable190); 
			match(input,Identifier,FOLLOW_Identifier_in_alterTable192); 
			match(input,20,FOLLOW_20_in_alterTable194); 
			match(input,23,FOLLOW_23_in_alterTable196); 
			pushFollow(FOLLOW_constraintDefinition_in_alterTable198);
			constraintDefinition();
			state._fsp--;


				
				
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
	// $ANTLR end "alterTable"



	// $ANTLR start "dropTable"
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:81:1: dropTable : 'DROP TABLE' Identifier ;
	public final void dropTable() throws RecognitionException {
		Token Identifier6=null;

		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:82:2: ( 'DROP TABLE' Identifier )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:82:4: 'DROP TABLE' Identifier
			{
			match(input,30,FOLLOW_30_in_dropTable208); 
			Identifier6=(Token)match(input,Identifier,FOLLOW_Identifier_in_dropTable210); 

					System.out.println("Identifier" +(Identifier6!=null?Identifier6.getText():null));
				
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
	// $ANTLR end "dropTable"



	// $ANTLR start "createIndex"
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:86:1: createIndex : 'CREATE INDEX' id1= Identifier 'ON' id2= Identifier '(' id3= Identifier ')' ;
	public final void createIndex() throws RecognitionException {
		Token id1=null;
		Token id2=null;
		Token id3=null;

		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:87:2: ( 'CREATE INDEX' id1= Identifier 'ON' id2= Identifier '(' id3= Identifier ')' )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:87:4: 'CREATE INDEX' id1= Identifier 'ON' id2= Identifier '(' id3= Identifier ')'
			{
			match(input,25,FOLLOW_25_in_createIndex220); 
			id1=(Token)match(input,Identifier,FOLLOW_Identifier_in_createIndex224); 
			match(input,40,FOLLOW_40_in_createIndex226); 
			id2=(Token)match(input,Identifier,FOLLOW_Identifier_in_createIndex230); 
			match(input,13,FOLLOW_13_in_createIndex232); 
			id3=(Token)match(input,Identifier,FOLLOW_Identifier_in_createIndex235); 
			match(input,14,FOLLOW_14_in_createIndex237); 

					
					//System.out.println("Identifier 1" +(id1!=null?id1.getText():null));
					//System.out.println("Identifier 2" +(id2!=null?id2.getText():null));
					//System.out.println("Identifier 3" +(id3!=null?id3.getText():null));
					//myArrayList.add((id1!=null?id1.getText():null));
					

							
				
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
	// $ANTLR end "createIndex"



	// $ANTLR start "selectStatement"
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:98:1: selectStatement : 'SELECT' ( '*' | ( (id1= Identifier '.' id2= Identifier ) ( ',' id3= Identifier '.' id4= Identifier )* ) ) ( ',' )* ( AggregateFunctions )* 'FROM' Identifier ( joinStatement )* ( whereStatement )* ( 'GROUP BY' Identifier )* ( 'FOR JSON' | 'FOR XML' )* ;
	public final void selectStatement() throws RecognitionException {
		Token id1=null;
		Token id2=null;
		Token id3=null;
		Token id4=null;

		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:98:17: ( 'SELECT' ( '*' | ( (id1= Identifier '.' id2= Identifier ) ( ',' id3= Identifier '.' id4= Identifier )* ) ) ( ',' )* ( AggregateFunctions )* 'FROM' Identifier ( joinStatement )* ( whereStatement )* ( 'GROUP BY' Identifier )* ( 'FOR JSON' | 'FOR XML' )* )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:99:3: 'SELECT' ( '*' | ( (id1= Identifier '.' id2= Identifier ) ( ',' id3= Identifier '.' id4= Identifier )* ) ) ( ',' )* ( AggregateFunctions )* 'FROM' Identifier ( joinStatement )* ( whereStatement )* ( 'GROUP BY' Identifier )* ( 'FOR JSON' | 'FOR XML' )*
			{
			match(input,43,FOLLOW_43_in_selectStatement249); 
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:99:12: ( '*' | ( (id1= Identifier '.' id2= Identifier ) ( ',' id3= Identifier '.' id4= Identifier )* ) )
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0==16) ) {
				alt4=1;
			}
			else if ( (LA4_0==Identifier) ) {
				alt4=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 4, 0, input);
				throw nvae;
			}

			switch (alt4) {
				case 1 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:99:13: '*'
					{
					match(input,16,FOLLOW_16_in_selectStatement252); 
					}
					break;
				case 2 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:99:18: ( (id1= Identifier '.' id2= Identifier ) ( ',' id3= Identifier '.' id4= Identifier )* )
					{
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:99:18: ( (id1= Identifier '.' id2= Identifier ) ( ',' id3= Identifier '.' id4= Identifier )* )
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:99:20: (id1= Identifier '.' id2= Identifier ) ( ',' id3= Identifier '.' id4= Identifier )*
					{
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:99:20: (id1= Identifier '.' id2= Identifier )
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:99:21: id1= Identifier '.' id2= Identifier
					{
					id1=(Token)match(input,Identifier,FOLLOW_Identifier_in_selectStatement260); 
					ColumnsSelect.add((id1!=null?id1.getText():null));
					match(input,18,FOLLOW_18_in_selectStatement263); 
					id2=(Token)match(input,Identifier,FOLLOW_Identifier_in_selectStatement267); 
					ColumnsSelect.add((id2!=null?id2.getText():null));
					}

					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:99:120: ( ',' id3= Identifier '.' id4= Identifier )*
					loop3:
					while (true) {
						int alt3=2;
						int LA3_0 = input.LA(1);
						if ( (LA3_0==17) ) {
							int LA3_1 = input.LA(2);
							if ( (LA3_1==Identifier) ) {
								alt3=1;
							}

						}

						switch (alt3) {
						case 1 :
							// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:99:121: ',' id3= Identifier '.' id4= Identifier
							{
							match(input,17,FOLLOW_17_in_selectStatement274); 
							id3=(Token)match(input,Identifier,FOLLOW_Identifier_in_selectStatement278); 
							ColumnsSelect.add((id3!=null?id3.getText():null));
							match(input,18,FOLLOW_18_in_selectStatement281); 
							id4=(Token)match(input,Identifier,FOLLOW_Identifier_in_selectStatement285); 
							ColumnsSelect.add((id4!=null?id4.getText():null));
							}
							break;

						default :
							break loop3;
						}
					}

					}

					}
					break;

			}

			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:99:232: ( ',' )*
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( (LA5_0==17) ) {
					alt5=1;
				}

				switch (alt5) {
				case 1 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:99:233: ','
					{
					match(input,17,FOLLOW_17_in_selectStatement300); 
					}
					break;

				default :
					break loop5;
				}
			}

			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:99:239: ( AggregateFunctions )*
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( (LA6_0==AggregateFunctions) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:99:240: AggregateFunctions
					{
					match(input,AggregateFunctions,FOLLOW_AggregateFunctions_in_selectStatement305); 
					}
					break;

				default :
					break loop6;
				}
			}

			match(input,34,FOLLOW_34_in_selectStatement310); 
			match(input,Identifier,FOLLOW_Identifier_in_selectStatement312); 
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:99:280: ( joinStatement )*
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( (LA7_0==38) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:99:281: joinStatement
					{
					pushFollow(FOLLOW_joinStatement_in_selectStatement315);
					joinStatement();
					state._fsp--;

					}
					break;

				default :
					break loop7;
				}
			}

			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:100:3: ( whereStatement )*
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( (LA8_0==50) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:100:4: whereStatement
					{
					pushFollow(FOLLOW_whereStatement_in_selectStatement323);
					whereStatement();
					state._fsp--;

					}
					break;

				default :
					break loop8;
				}
			}

			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:100:21: ( 'GROUP BY' Identifier )*
			loop9:
			while (true) {
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( (LA9_0==35) ) {
					alt9=1;
				}

				switch (alt9) {
				case 1 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:100:22: 'GROUP BY' Identifier
					{
					match(input,35,FOLLOW_35_in_selectStatement328); 
					match(input,Identifier,FOLLOW_Identifier_in_selectStatement330); 
					}
					break;

				default :
					break loop9;
				}
			}

			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:100:46: ( 'FOR JSON' | 'FOR XML' )*
			loop10:
			while (true) {
				int alt10=2;
				int LA10_0 = input.LA(1);
				if ( ((LA10_0 >= 31 && LA10_0 <= 32)) ) {
					alt10=1;
				}

				switch (alt10) {
				case 1 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:
					{
					if ( (input.LA(1) >= 31 && input.LA(1) <= 32) ) {
						input.consume();
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					}
					break;

				default :
					break loop10;
				}
			}


					
					
					
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
	// $ANTLR end "selectStatement"



	// $ANTLR start "updateStatement"
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:104:1: updateStatement : 'UPDATE' Identifier 'SET' Identifier '=' Identifier ( whereStatement )* ;
	public final void updateStatement() throws RecognitionException {
		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:105:2: ( 'UPDATE' Identifier 'SET' Identifier '=' Identifier ( whereStatement )* )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:105:4: 'UPDATE' Identifier 'SET' Identifier '=' Identifier ( whereStatement )*
			{
			match(input,48,FOLLOW_48_in_updateStatement350); 
			match(input,Identifier,FOLLOW_Identifier_in_updateStatement352); 
			match(input,45,FOLLOW_45_in_updateStatement354); 
			match(input,Identifier,FOLLOW_Identifier_in_updateStatement356); 
			match(input,19,FOLLOW_19_in_updateStatement358); 
			match(input,Identifier,FOLLOW_Identifier_in_updateStatement359); 
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:105:55: ( whereStatement )*
			loop11:
			while (true) {
				int alt11=2;
				int LA11_0 = input.LA(1);
				if ( (LA11_0==50) ) {
					alt11=1;
				}

				switch (alt11) {
				case 1 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:105:56: whereStatement
					{
					pushFollow(FOLLOW_whereStatement_in_updateStatement362);
					whereStatement();
					state._fsp--;

					}
					break;

				default :
					break loop11;
				}
			}


				
				
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
	// $ANTLR end "updateStatement"



	// $ANTLR start "delete"
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:110:1: delete : 'DELETE' 'FROM' Identifier ( whereStatement )* ;
	public final void delete() throws RecognitionException {
		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:110:8: ( 'DELETE' 'FROM' Identifier ( whereStatement )* )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:111:3: 'DELETE' 'FROM' Identifier ( whereStatement )*
			{
			match(input,27,FOLLOW_27_in_delete378); 
			match(input,34,FOLLOW_34_in_delete380); 
			match(input,Identifier,FOLLOW_Identifier_in_delete382); 
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:111:30: ( whereStatement )*
			loop12:
			while (true) {
				int alt12=2;
				int LA12_0 = input.LA(1);
				if ( (LA12_0==50) ) {
					alt12=1;
				}

				switch (alt12) {
				case 1 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:111:31: whereStatement
					{
					pushFollow(FOLLOW_whereStatement_in_delete385);
					whereStatement();
					state._fsp--;

					}
					break;

				default :
					break loop12;
				}
			}


					
					
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
	// $ANTLR end "delete"



	// $ANTLR start "insertInto"
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:117:1: insertInto : 'INSERT' 'INTO' id1= Identifier '(' id2= Identifier ( ',' id3= Identifier )* ')' 'VALUES' '(' id4= Identifier ( ',' id5= Identifier )* ')' ;
	public final void insertInto() throws RecognitionException {
		Token id1=null;
		Token id2=null;
		Token id3=null;
		Token id4=null;
		Token id5=null;

		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:118:2: ( 'INSERT' 'INTO' id1= Identifier '(' id2= Identifier ( ',' id3= Identifier )* ')' 'VALUES' '(' id4= Identifier ( ',' id5= Identifier )* ')' )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:118:4: 'INSERT' 'INTO' id1= Identifier '(' id2= Identifier ( ',' id3= Identifier )* ')' 'VALUES' '(' id4= Identifier ( ',' id5= Identifier )* ')'
			{
			match(input,36,FOLLOW_36_in_insertInto405); 
			match(input,37,FOLLOW_37_in_insertInto407); 
			id1=(Token)match(input,Identifier,FOLLOW_Identifier_in_insertInto411); 
			match(input,13,FOLLOW_13_in_insertInto413); 
			id2=(Token)match(input,Identifier,FOLLOW_Identifier_in_insertInto417); 
			ColumnsInsertInto.add((id2!=null?id2.getText():null));
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:118:89: ( ',' id3= Identifier )*
			loop13:
			while (true) {
				int alt13=2;
				int LA13_0 = input.LA(1);
				if ( (LA13_0==17) ) {
					alt13=1;
				}

				switch (alt13) {
				case 1 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:118:90: ',' id3= Identifier
					{
					match(input,17,FOLLOW_17_in_insertInto421); 
					id3=(Token)match(input,Identifier,FOLLOW_Identifier_in_insertInto425); 
					ColumnsInsertInto.add((id3!=null?id3.getText():null));
					}
					break;

				default :
					break loop13;
				}
			}

			match(input,14,FOLLOW_14_in_insertInto432); 
			match(input,49,FOLLOW_49_in_insertInto434); 
			match(input,13,FOLLOW_13_in_insertInto436); 
			id4=(Token)match(input,Identifier,FOLLOW_Identifier_in_insertInto440); 
			 ColumnsInsertInto.add("VALUES");  ColumnsInsertInto.add((id4!=null?id4.getText():null));
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:118:251: ( ',' id5= Identifier )*
			loop14:
			while (true) {
				int alt14=2;
				int LA14_0 = input.LA(1);
				if ( (LA14_0==17) ) {
					alt14=1;
				}

				switch (alt14) {
				case 1 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:118:252: ',' id5= Identifier
					{
					match(input,17,FOLLOW_17_in_insertInto445); 
					id5=(Token)match(input,Identifier,FOLLOW_Identifier_in_insertInto449); 
					ColumnsInsertInto.add((id5!=null?id5.getText():null)); 
					}
					break;

				default :
					break loop14;
				}
			}

			match(input,14,FOLLOW_14_in_insertInto455); 

					
				
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
	// $ANTLR end "insertInto"



	// $ANTLR start "whereStatement"
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:124:1: whereStatement : 'WHERE' Identifier CompareOperator Identifier ;
	public final void whereStatement() throws RecognitionException {
		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:125:2: ( 'WHERE' Identifier CompareOperator Identifier )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:125:4: 'WHERE' Identifier CompareOperator Identifier
			{
			match(input,50,FOLLOW_50_in_whereStatement471); 
			match(input,Identifier,FOLLOW_Identifier_in_whereStatement473); 
			match(input,CompareOperator,FOLLOW_CompareOperator_in_whereStatement475); 
			match(input,Identifier,FOLLOW_Identifier_in_whereStatement477); 
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
	// $ANTLR end "whereStatement"



	// $ANTLR start "joinStatement"
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:127:1: joinStatement : 'JOIN' Identifier 'ON' Identifier '.' Identifier '=' Identifier '.' Identifier ;
	public final void joinStatement() throws RecognitionException {
		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:128:2: ( 'JOIN' Identifier 'ON' Identifier '.' Identifier '=' Identifier '.' Identifier )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:128:4: 'JOIN' Identifier 'ON' Identifier '.' Identifier '=' Identifier '.' Identifier
			{
			match(input,38,FOLLOW_38_in_joinStatement486); 
			match(input,Identifier,FOLLOW_Identifier_in_joinStatement488); 
			match(input,40,FOLLOW_40_in_joinStatement490); 
			match(input,Identifier,FOLLOW_Identifier_in_joinStatement492); 
			match(input,18,FOLLOW_18_in_joinStatement494); 
			match(input,Identifier,FOLLOW_Identifier_in_joinStatement496); 
			match(input,19,FOLLOW_19_in_joinStatement498); 
			match(input,Identifier,FOLLOW_Identifier_in_joinStatement500); 
			match(input,18,FOLLOW_18_in_joinStatement502); 
			match(input,Identifier,FOLLOW_Identifier_in_joinStatement504); 
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
	// $ANTLR end "joinStatement"



	// $ANTLR start "constraintDefinition"
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:134:1: constraintDefinition : 'FOREIGN KEY' '(' id1= Identifier ')' 'REFERENCES' id2= Identifier '(' id3= Identifier ')' ;
	public final void constraintDefinition() throws RecognitionException {
		Token id1=null;
		Token id2=null;
		Token id3=null;

		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:135:2: ( 'FOREIGN KEY' '(' id1= Identifier ')' 'REFERENCES' id2= Identifier '(' id3= Identifier ')' )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:135:4: 'FOREIGN KEY' '(' id1= Identifier ')' 'REFERENCES' id2= Identifier '(' id3= Identifier ')'
			{
			match(input,33,FOLLOW_33_in_constraintDefinition564); 
			match(input,13,FOLLOW_13_in_constraintDefinition566); 
			id1=(Token)match(input,Identifier,FOLLOW_Identifier_in_constraintDefinition570); 
			match(input,14,FOLLOW_14_in_constraintDefinition572); 
			match(input,42,FOLLOW_42_in_constraintDefinition574); 
			id2=(Token)match(input,Identifier,FOLLOW_Identifier_in_constraintDefinition578); 
			match(input,13,FOLLOW_13_in_constraintDefinition580); 
			id3=(Token)match(input,Identifier,FOLLOW_Identifier_in_constraintDefinition584); 
			match(input,14,FOLLOW_14_in_constraintDefinition586); 

					//System.out.println("ID1" +(id1!=null?id1.getText():null));
					//System.out.println("ID2" +(id2!=null?id2.getText():null));
					//System.out.println("ID3" +(id3!=null?id3.getText():null));
					
				
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
	// $ANTLR end "constraintDefinition"



	// $ANTLR start "columnDefinition"
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:144:1: columnDefinition : Identifier Type Nullability ;
	public final void columnDefinition() throws RecognitionException {
		Token Nullability7=null;
		Token Type8=null;

		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:145:2: ( Identifier Type Nullability )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:145:4: Identifier Type Nullability
			{
			match(input,Identifier,FOLLOW_Identifier_in_columnDefinition599); 
			Type8=(Token)match(input,Type,FOLLOW_Type_in_columnDefinition601); 
			Nullability7=(Token)match(input,Nullability,FOLLOW_Nullability_in_columnDefinition603); 

				System.out.println("NULLABILITY"+(Nullability7!=null?Nullability7.getText():null));
				System.out.println("TYPE"+(Type8!=null?Type8.getText():null));
				//Hacer uso de este dato de la definición de la columna
				
				 
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
	// $ANTLR end "columnDefinition"



	// $ANTLR start "primaryKey"
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:165:1: primaryKey : 'PRIMARY KEY(' Identifier ')' ;
	public final void primaryKey() throws RecognitionException {
		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:166:2: ( 'PRIMARY KEY(' Identifier ')' )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:166:4: 'PRIMARY KEY(' Identifier ')'
			{
			match(input,41,FOLLOW_41_in_primaryKey673); 
			match(input,Identifier,FOLLOW_Identifier_in_primaryKey675); 
			match(input,14,FOLLOW_14_in_primaryKey677); 

					
				
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
	// $ANTLR end "primaryKey"

	// Delegated rules



	public static final BitSet FOLLOW_createDB_in_query32 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_dropDB_in_query36 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_listDB_in_query40 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_startDB_in_query44 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_stopDB_in_query48 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_displayDB_in_query52 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_24_in_createDB63 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_Identifier_in_createDB65 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_29_in_dropDB78 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_Identifier_in_dropDB80 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_39_in_listDB94 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_46_in_startDB102 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_47_in_stopDB112 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_28_in_displayDB122 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_Identifier_in_displayDB124 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_44_in_setDB137 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_Identifier_in_setDB139 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_26_in_createTable151 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_Identifier_in_createTable153 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_22_in_createTable154 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_createTable156 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_columnDefinition_in_createTable158 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_17_in_createTable163 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_columnDefinition_in_createTable166 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_17_in_createTable171 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_primaryKey_in_createTable174 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_15_in_createTable176 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_21_in_alterTable190 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_Identifier_in_alterTable192 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_20_in_alterTable194 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_23_in_alterTable196 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_constraintDefinition_in_alterTable198 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_30_in_dropTable208 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_Identifier_in_dropTable210 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_25_in_createIndex220 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_Identifier_in_createIndex224 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_40_in_createIndex226 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_Identifier_in_createIndex230 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_createIndex232 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_Identifier_in_createIndex235 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_14_in_createIndex237 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_43_in_selectStatement249 = new BitSet(new long[]{0x0000000000010080L});
	public static final BitSet FOLLOW_16_in_selectStatement252 = new BitSet(new long[]{0x0000000400020010L});
	public static final BitSet FOLLOW_Identifier_in_selectStatement260 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_18_in_selectStatement263 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_Identifier_in_selectStatement267 = new BitSet(new long[]{0x0000000400020010L});
	public static final BitSet FOLLOW_17_in_selectStatement274 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_Identifier_in_selectStatement278 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_18_in_selectStatement281 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_Identifier_in_selectStatement285 = new BitSet(new long[]{0x0000000400020010L});
	public static final BitSet FOLLOW_17_in_selectStatement300 = new BitSet(new long[]{0x0000000400020010L});
	public static final BitSet FOLLOW_AggregateFunctions_in_selectStatement305 = new BitSet(new long[]{0x0000000400000010L});
	public static final BitSet FOLLOW_34_in_selectStatement310 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_Identifier_in_selectStatement312 = new BitSet(new long[]{0x0004004980000002L});
	public static final BitSet FOLLOW_joinStatement_in_selectStatement315 = new BitSet(new long[]{0x0004004980000002L});
	public static final BitSet FOLLOW_whereStatement_in_selectStatement323 = new BitSet(new long[]{0x0004000980000002L});
	public static final BitSet FOLLOW_35_in_selectStatement328 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_Identifier_in_selectStatement330 = new BitSet(new long[]{0x0000000980000002L});
	public static final BitSet FOLLOW_48_in_updateStatement350 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_Identifier_in_updateStatement352 = new BitSet(new long[]{0x0000200000000000L});
	public static final BitSet FOLLOW_45_in_updateStatement354 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_Identifier_in_updateStatement356 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_19_in_updateStatement358 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_Identifier_in_updateStatement359 = new BitSet(new long[]{0x0004000000000002L});
	public static final BitSet FOLLOW_whereStatement_in_updateStatement362 = new BitSet(new long[]{0x0004000000000002L});
	public static final BitSet FOLLOW_27_in_delete378 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_34_in_delete380 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_Identifier_in_delete382 = new BitSet(new long[]{0x0004000000000002L});
	public static final BitSet FOLLOW_whereStatement_in_delete385 = new BitSet(new long[]{0x0004000000000002L});
	public static final BitSet FOLLOW_36_in_insertInto405 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_37_in_insertInto407 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_Identifier_in_insertInto411 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_insertInto413 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_Identifier_in_insertInto417 = new BitSet(new long[]{0x0000000000024000L});
	public static final BitSet FOLLOW_17_in_insertInto421 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_Identifier_in_insertInto425 = new BitSet(new long[]{0x0000000000024000L});
	public static final BitSet FOLLOW_14_in_insertInto432 = new BitSet(new long[]{0x0002000000000000L});
	public static final BitSet FOLLOW_49_in_insertInto434 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_insertInto436 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_Identifier_in_insertInto440 = new BitSet(new long[]{0x0000000000024000L});
	public static final BitSet FOLLOW_17_in_insertInto445 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_Identifier_in_insertInto449 = new BitSet(new long[]{0x0000000000024000L});
	public static final BitSet FOLLOW_14_in_insertInto455 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_50_in_whereStatement471 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_Identifier_in_whereStatement473 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_CompareOperator_in_whereStatement475 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_Identifier_in_whereStatement477 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_38_in_joinStatement486 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_Identifier_in_joinStatement488 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_40_in_joinStatement490 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_Identifier_in_joinStatement492 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_18_in_joinStatement494 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_Identifier_in_joinStatement496 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_19_in_joinStatement498 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_Identifier_in_joinStatement500 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_18_in_joinStatement502 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_Identifier_in_joinStatement504 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_33_in_constraintDefinition564 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_constraintDefinition566 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_Identifier_in_constraintDefinition570 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_14_in_constraintDefinition572 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_42_in_constraintDefinition574 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_Identifier_in_constraintDefinition578 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_constraintDefinition580 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_Identifier_in_constraintDefinition584 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_14_in_constraintDefinition586 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Identifier_in_columnDefinition599 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_Type_in_columnDefinition601 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_Nullability_in_columnDefinition603 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_41_in_primaryKey673 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_Identifier_in_primaryKey675 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_14_in_primaryKey677 = new BitSet(new long[]{0x0000000000000002L});
}
