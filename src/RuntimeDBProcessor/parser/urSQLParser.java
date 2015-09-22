// $ANTLR 3.5.1 /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g 2015-09-22 16:46:12

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
		"'('", "')'", "');'", "'*'", "','", "'.'", "';'", "'='", "'ADD'", "'ALTER TABLE'", 
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
	public static final int T__51=51;
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
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:24:1: query : ( script )* ;
	public final void query() throws RecognitionException {
		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:24:7: ( ( script )* )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:25:2: ( script )*
			{
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:25:2: ( script )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( ((LA1_0 >= 25 && LA1_0 <= 31)||LA1_0==37||LA1_0==40||(LA1_0 >= 44 && LA1_0 <= 45)||(LA1_0 >= 47 && LA1_0 <= 49)) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:25:2: script
					{
					pushFollow(FOLLOW_script_in_query25);
					script();
					state._fsp--;

					}
					break;

				default :
					break loop1;
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
	// $ANTLR end "query"



	// $ANTLR start "script"
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:27:1: script : ( createDB | dropDB | listDB | startDB | stopDB | displayDB | setDB | createTable alterTable | dropTable | createIndex | selectStatement | updateStatement | delete | insertInto );
	public final void script() throws RecognitionException {
		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:27:8: ( createDB | dropDB | listDB | startDB | stopDB | displayDB | setDB | createTable alterTable | dropTable | createIndex | selectStatement | updateStatement | delete | insertInto )
			int alt2=14;
			switch ( input.LA(1) ) {
			case 25:
				{
				alt2=1;
				}
				break;
			case 30:
				{
				alt2=2;
				}
				break;
			case 40:
				{
				alt2=3;
				}
				break;
			case 47:
				{
				alt2=4;
				}
				break;
			case 48:
				{
				alt2=5;
				}
				break;
			case 29:
				{
				alt2=6;
				}
				break;
			case 45:
				{
				alt2=7;
				}
				break;
			case 27:
				{
				alt2=8;
				}
				break;
			case 31:
				{
				alt2=9;
				}
				break;
			case 26:
				{
				alt2=10;
				}
				break;
			case 44:
				{
				alt2=11;
				}
				break;
			case 49:
				{
				alt2=12;
				}
				break;
			case 28:
				{
				alt2=13;
				}
				break;
			case 37:
				{
				alt2=14;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}
			switch (alt2) {
				case 1 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:28:2: createDB
					{
					pushFollow(FOLLOW_createDB_in_script36);
					createDB();
					state._fsp--;

					}
					break;
				case 2 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:28:13: dropDB
					{
					pushFollow(FOLLOW_dropDB_in_script40);
					dropDB();
					state._fsp--;

					}
					break;
				case 3 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:28:22: listDB
					{
					pushFollow(FOLLOW_listDB_in_script44);
					listDB();
					state._fsp--;

					}
					break;
				case 4 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:28:30: startDB
					{
					pushFollow(FOLLOW_startDB_in_script47);
					startDB();
					state._fsp--;

					}
					break;
				case 5 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:28:42: stopDB
					{
					pushFollow(FOLLOW_stopDB_in_script53);
					stopDB();
					state._fsp--;

					}
					break;
				case 6 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:28:51: displayDB
					{
					pushFollow(FOLLOW_displayDB_in_script57);
					displayDB();
					state._fsp--;

					}
					break;
				case 7 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:28:63: setDB
					{
					pushFollow(FOLLOW_setDB_in_script61);
					setDB();
					state._fsp--;

					}
					break;
				case 8 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:28:71: createTable alterTable
					{
					pushFollow(FOLLOW_createTable_in_script65);
					createTable();
					state._fsp--;

					pushFollow(FOLLOW_alterTable_in_script69);
					alterTable();
					state._fsp--;

					}
					break;
				case 9 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:29:16: dropTable
					{
					pushFollow(FOLLOW_dropTable_in_script73);
					dropTable();
					state._fsp--;

					}
					break;
				case 10 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:29:27: createIndex
					{
					pushFollow(FOLLOW_createIndex_in_script76);
					createIndex();
					state._fsp--;

					}
					break;
				case 11 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:29:40: selectStatement
					{
					pushFollow(FOLLOW_selectStatement_in_script79);
					selectStatement();
					state._fsp--;

					}
					break;
				case 12 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:29:58: updateStatement
					{
					pushFollow(FOLLOW_updateStatement_in_script83);
					updateStatement();
					state._fsp--;

					}
					break;
				case 13 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:29:76: delete
					{
					pushFollow(FOLLOW_delete_in_script87);
					delete();
					state._fsp--;

					}
					break;
				case 14 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:29:85: insertInto
					{
					pushFollow(FOLLOW_insertInto_in_script91);
					insertInto();
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
	// $ANTLR end "script"



	// $ANTLR start "createDB"
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:34:1: createDB : 'CREATE DATABASE' Identifier ;
	public final void createDB() throws RecognitionException {
		Token Identifier1=null;

		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:35:2: ( 'CREATE DATABASE' Identifier )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:35:4: 'CREATE DATABASE' Identifier
			{
			match(input,25,FOLLOW_25_in_createDB104); 
			Identifier1=(Token)match(input,Identifier,FOLLOW_Identifier_in_createDB106); 

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
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:42:1: dropDB : 'DROP DATABASE' Identifier ;
	public final void dropDB() throws RecognitionException {
		Token Identifier2=null;

		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:43:2: ( 'DROP DATABASE' Identifier )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:43:4: 'DROP DATABASE' Identifier
			{
			match(input,30,FOLLOW_30_in_dropDB120); 
			Identifier2=(Token)match(input,Identifier,FOLLOW_Identifier_in_dropDB122); 

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
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:50:1: listDB : 'LIST DATABASES' ;
	public final void listDB() throws RecognitionException {
		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:50:8: ( 'LIST DATABASES' )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:50:10: 'LIST DATABASES'
			{
			match(input,40,FOLLOW_40_in_listDB137); 
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
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:52:1: startDB : 'START' ;
	public final void startDB() throws RecognitionException {
		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:52:9: ( 'START' )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:52:11: 'START'
			{
			match(input,47,FOLLOW_47_in_startDB147); 
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
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:56:1: stopDB : 'STOP' ;
	public final void stopDB() throws RecognitionException {
		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:56:8: ( 'STOP' )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:56:10: 'STOP'
			{
			match(input,48,FOLLOW_48_in_stopDB158); 
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
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:58:1: displayDB : 'DISPLAY DATABASE' Identifier ;
	public final void displayDB() throws RecognitionException {
		Token Identifier3=null;

		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:59:2: ( 'DISPLAY DATABASE' Identifier )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:59:4: 'DISPLAY DATABASE' Identifier
			{
			match(input,29,FOLLOW_29_in_displayDB169); 
			Identifier3=(Token)match(input,Identifier,FOLLOW_Identifier_in_displayDB171); 

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
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:66:1: setDB : 'SET DATABASE' Identifier ';' ;
	public final void setDB() throws RecognitionException {
		Token Identifier4=null;

		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:67:2: ( 'SET DATABASE' Identifier ';' )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:67:4: 'SET DATABASE' Identifier ';'
			{
			match(input,45,FOLLOW_45_in_setDB185); 
			Identifier4=(Token)match(input,Identifier,FOLLOW_Identifier_in_setDB187); 
			match(input,19,FOLLOW_19_in_setDB189); 

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
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:73:1: createTable : 'CREATE TABLE' Identifier 'AS' '(' columnDefinition ( ',' columnDefinition )* ',' primaryKey ')' ;
	public final void createTable() throws RecognitionException {
		Token Identifier5=null;

		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:74:2: ( 'CREATE TABLE' Identifier 'AS' '(' columnDefinition ( ',' columnDefinition )* ',' primaryKey ')' )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:74:4: 'CREATE TABLE' Identifier 'AS' '(' columnDefinition ( ',' columnDefinition )* ',' primaryKey ')'
			{
			match(input,27,FOLLOW_27_in_createTable201); 
			Identifier5=(Token)match(input,Identifier,FOLLOW_Identifier_in_createTable203); 
			match(input,23,FOLLOW_23_in_createTable204); 
			match(input,13,FOLLOW_13_in_createTable206); 
			pushFollow(FOLLOW_columnDefinition_in_createTable208);
			columnDefinition();
			state._fsp--;

			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:74:57: ( ',' columnDefinition )*
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
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:74:58: ',' columnDefinition
					{
					match(input,17,FOLLOW_17_in_createTable213); 
					pushFollow(FOLLOW_columnDefinition_in_createTable216);
					columnDefinition();
					state._fsp--;

					}
					break;

				default :
					break loop3;
				}
			}

			match(input,17,FOLLOW_17_in_createTable221); 
			pushFollow(FOLLOW_primaryKey_in_createTable224);
			primaryKey();
			state._fsp--;

			match(input,14,FOLLOW_14_in_createTable226); 

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
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:80:1: alterTable : 'ALTER TABLE' Identifier 'ADD' 'CONSTRAINT' constraintDefinition ;
	public final void alterTable() throws RecognitionException {
		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:81:2: ( 'ALTER TABLE' Identifier 'ADD' 'CONSTRAINT' constraintDefinition )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:81:4: 'ALTER TABLE' Identifier 'ADD' 'CONSTRAINT' constraintDefinition
			{
			match(input,22,FOLLOW_22_in_alterTable240); 
			match(input,Identifier,FOLLOW_Identifier_in_alterTable242); 
			match(input,21,FOLLOW_21_in_alterTable244); 
			match(input,24,FOLLOW_24_in_alterTable246); 
			pushFollow(FOLLOW_constraintDefinition_in_alterTable248);
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
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:85:1: dropTable : 'DROP TABLE' Identifier ';' ;
	public final void dropTable() throws RecognitionException {
		Token Identifier6=null;

		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:86:2: ( 'DROP TABLE' Identifier ';' )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:86:4: 'DROP TABLE' Identifier ';'
			{
			match(input,31,FOLLOW_31_in_dropTable259); 
			Identifier6=(Token)match(input,Identifier,FOLLOW_Identifier_in_dropTable261); 
			match(input,19,FOLLOW_19_in_dropTable263); 

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
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:90:1: createIndex : 'CREATE INDEX' id1= Identifier 'ON' id2= Identifier '(' id3= Identifier ')' ;
	public final void createIndex() throws RecognitionException {
		Token id1=null;
		Token id2=null;
		Token id3=null;

		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:91:2: ( 'CREATE INDEX' id1= Identifier 'ON' id2= Identifier '(' id3= Identifier ')' )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:91:4: 'CREATE INDEX' id1= Identifier 'ON' id2= Identifier '(' id3= Identifier ')'
			{
			match(input,26,FOLLOW_26_in_createIndex273); 
			id1=(Token)match(input,Identifier,FOLLOW_Identifier_in_createIndex277); 
			match(input,41,FOLLOW_41_in_createIndex279); 
			id2=(Token)match(input,Identifier,FOLLOW_Identifier_in_createIndex283); 
			match(input,13,FOLLOW_13_in_createIndex285); 
			id3=(Token)match(input,Identifier,FOLLOW_Identifier_in_createIndex288); 
			match(input,14,FOLLOW_14_in_createIndex290); 

					
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
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:102:1: selectStatement : 'SELECT' ( '*' | ( (id1= Identifier '.' id2= Identifier ) ( ',' id3= Identifier '.' id4= Identifier )* ) ) ( ',' )* ( AggregateFunctions )* 'FROM' Identifier ( joinStatement )* ( whereStatement )* ( 'GROUP BY' Identifier )* ( 'FOR JSON' | 'FOR XML' )* ;
	public final void selectStatement() throws RecognitionException {
		Token id1=null;
		Token id2=null;
		Token id3=null;
		Token id4=null;

		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:102:17: ( 'SELECT' ( '*' | ( (id1= Identifier '.' id2= Identifier ) ( ',' id3= Identifier '.' id4= Identifier )* ) ) ( ',' )* ( AggregateFunctions )* 'FROM' Identifier ( joinStatement )* ( whereStatement )* ( 'GROUP BY' Identifier )* ( 'FOR JSON' | 'FOR XML' )* )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:103:3: 'SELECT' ( '*' | ( (id1= Identifier '.' id2= Identifier ) ( ',' id3= Identifier '.' id4= Identifier )* ) ) ( ',' )* ( AggregateFunctions )* 'FROM' Identifier ( joinStatement )* ( whereStatement )* ( 'GROUP BY' Identifier )* ( 'FOR JSON' | 'FOR XML' )*
			{
			match(input,44,FOLLOW_44_in_selectStatement303); 
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:103:12: ( '*' | ( (id1= Identifier '.' id2= Identifier ) ( ',' id3= Identifier '.' id4= Identifier )* ) )
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( (LA5_0==16) ) {
				alt5=1;
			}
			else if ( (LA5_0==Identifier) ) {
				alt5=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 5, 0, input);
				throw nvae;
			}

			switch (alt5) {
				case 1 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:103:13: '*'
					{
					match(input,16,FOLLOW_16_in_selectStatement306); 
					}
					break;
				case 2 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:103:18: ( (id1= Identifier '.' id2= Identifier ) ( ',' id3= Identifier '.' id4= Identifier )* )
					{
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:103:18: ( (id1= Identifier '.' id2= Identifier ) ( ',' id3= Identifier '.' id4= Identifier )* )
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:103:20: (id1= Identifier '.' id2= Identifier ) ( ',' id3= Identifier '.' id4= Identifier )*
					{
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:103:20: (id1= Identifier '.' id2= Identifier )
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:103:21: id1= Identifier '.' id2= Identifier
					{
					id1=(Token)match(input,Identifier,FOLLOW_Identifier_in_selectStatement314); 
					ColumnsSelect.add((id1!=null?id1.getText():null));
					match(input,18,FOLLOW_18_in_selectStatement317); 
					id2=(Token)match(input,Identifier,FOLLOW_Identifier_in_selectStatement321); 
					ColumnsSelect.add((id2!=null?id2.getText():null));
					}

					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:103:120: ( ',' id3= Identifier '.' id4= Identifier )*
					loop4:
					while (true) {
						int alt4=2;
						int LA4_0 = input.LA(1);
						if ( (LA4_0==17) ) {
							int LA4_1 = input.LA(2);
							if ( (LA4_1==Identifier) ) {
								alt4=1;
							}

						}

						switch (alt4) {
						case 1 :
							// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:103:121: ',' id3= Identifier '.' id4= Identifier
							{
							match(input,17,FOLLOW_17_in_selectStatement328); 
							id3=(Token)match(input,Identifier,FOLLOW_Identifier_in_selectStatement332); 
							ColumnsSelect.add((id3!=null?id3.getText():null));
							match(input,18,FOLLOW_18_in_selectStatement335); 
							id4=(Token)match(input,Identifier,FOLLOW_Identifier_in_selectStatement339); 
							ColumnsSelect.add((id4!=null?id4.getText():null));
							}
							break;

						default :
							break loop4;
						}
					}

					}

					}
					break;

			}

			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:103:232: ( ',' )*
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( (LA6_0==17) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:103:233: ','
					{
					match(input,17,FOLLOW_17_in_selectStatement354); 
					}
					break;

				default :
					break loop6;
				}
			}

			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:103:239: ( AggregateFunctions )*
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( (LA7_0==AggregateFunctions) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:103:240: AggregateFunctions
					{
					match(input,AggregateFunctions,FOLLOW_AggregateFunctions_in_selectStatement359); 
					}
					break;

				default :
					break loop7;
				}
			}

			match(input,35,FOLLOW_35_in_selectStatement364); 
			match(input,Identifier,FOLLOW_Identifier_in_selectStatement366); 
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:103:280: ( joinStatement )*
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( (LA8_0==39) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:103:281: joinStatement
					{
					pushFollow(FOLLOW_joinStatement_in_selectStatement369);
					joinStatement();
					state._fsp--;

					}
					break;

				default :
					break loop8;
				}
			}

			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:104:3: ( whereStatement )*
			loop9:
			while (true) {
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( (LA9_0==51) ) {
					alt9=1;
				}

				switch (alt9) {
				case 1 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:104:4: whereStatement
					{
					pushFollow(FOLLOW_whereStatement_in_selectStatement377);
					whereStatement();
					state._fsp--;

					}
					break;

				default :
					break loop9;
				}
			}

			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:104:21: ( 'GROUP BY' Identifier )*
			loop10:
			while (true) {
				int alt10=2;
				int LA10_0 = input.LA(1);
				if ( (LA10_0==36) ) {
					alt10=1;
				}

				switch (alt10) {
				case 1 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:104:22: 'GROUP BY' Identifier
					{
					match(input,36,FOLLOW_36_in_selectStatement382); 
					match(input,Identifier,FOLLOW_Identifier_in_selectStatement384); 
					}
					break;

				default :
					break loop10;
				}
			}

			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:104:46: ( 'FOR JSON' | 'FOR XML' )*
			loop11:
			while (true) {
				int alt11=2;
				int LA11_0 = input.LA(1);
				if ( ((LA11_0 >= 32 && LA11_0 <= 33)) ) {
					alt11=1;
				}

				switch (alt11) {
				case 1 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:
					{
					if ( (input.LA(1) >= 32 && input.LA(1) <= 33) ) {
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
	// $ANTLR end "selectStatement"



	// $ANTLR start "updateStatement"
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:108:1: updateStatement : 'UPDATE' Identifier 'SET' Identifier '=' Identifier ( whereStatement )* ;
	public final void updateStatement() throws RecognitionException {
		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:109:2: ( 'UPDATE' Identifier 'SET' Identifier '=' Identifier ( whereStatement )* )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:109:4: 'UPDATE' Identifier 'SET' Identifier '=' Identifier ( whereStatement )*
			{
			match(input,49,FOLLOW_49_in_updateStatement406); 
			match(input,Identifier,FOLLOW_Identifier_in_updateStatement408); 
			match(input,46,FOLLOW_46_in_updateStatement410); 
			match(input,Identifier,FOLLOW_Identifier_in_updateStatement412); 
			match(input,20,FOLLOW_20_in_updateStatement414); 
			match(input,Identifier,FOLLOW_Identifier_in_updateStatement415); 
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:109:55: ( whereStatement )*
			loop12:
			while (true) {
				int alt12=2;
				int LA12_0 = input.LA(1);
				if ( (LA12_0==51) ) {
					alt12=1;
				}

				switch (alt12) {
				case 1 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:109:56: whereStatement
					{
					pushFollow(FOLLOW_whereStatement_in_updateStatement418);
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
	// $ANTLR end "updateStatement"



	// $ANTLR start "delete"
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:114:1: delete : 'DELETE' 'FROM' Identifier ( whereStatement )* ;
	public final void delete() throws RecognitionException {
		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:114:8: ( 'DELETE' 'FROM' Identifier ( whereStatement )* )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:115:3: 'DELETE' 'FROM' Identifier ( whereStatement )*
			{
			match(input,28,FOLLOW_28_in_delete435); 
			match(input,35,FOLLOW_35_in_delete437); 
			match(input,Identifier,FOLLOW_Identifier_in_delete439); 
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:115:30: ( whereStatement )*
			loop13:
			while (true) {
				int alt13=2;
				int LA13_0 = input.LA(1);
				if ( (LA13_0==51) ) {
					alt13=1;
				}

				switch (alt13) {
				case 1 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:115:31: whereStatement
					{
					pushFollow(FOLLOW_whereStatement_in_delete442);
					whereStatement();
					state._fsp--;

					}
					break;

				default :
					break loop13;
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
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:121:1: insertInto : 'INSERT' 'INTO' id1= Identifier '(' id2= Identifier ( ',' id3= Identifier )* ')' 'VALUES' '(' id4= Identifier ( ',' id5= Identifier )* ');' ;
	public final void insertInto() throws RecognitionException {
		Token id1=null;
		Token id2=null;
		Token id3=null;
		Token id4=null;
		Token id5=null;

		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:122:2: ( 'INSERT' 'INTO' id1= Identifier '(' id2= Identifier ( ',' id3= Identifier )* ')' 'VALUES' '(' id4= Identifier ( ',' id5= Identifier )* ');' )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:122:4: 'INSERT' 'INTO' id1= Identifier '(' id2= Identifier ( ',' id3= Identifier )* ')' 'VALUES' '(' id4= Identifier ( ',' id5= Identifier )* ');'
			{
			match(input,37,FOLLOW_37_in_insertInto463); 
			match(input,38,FOLLOW_38_in_insertInto465); 
			id1=(Token)match(input,Identifier,FOLLOW_Identifier_in_insertInto469); 
			match(input,13,FOLLOW_13_in_insertInto471); 
			id2=(Token)match(input,Identifier,FOLLOW_Identifier_in_insertInto475); 
			ColumnsInsertInto.add((id2!=null?id2.getText():null));
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:122:89: ( ',' id3= Identifier )*
			loop14:
			while (true) {
				int alt14=2;
				int LA14_0 = input.LA(1);
				if ( (LA14_0==17) ) {
					alt14=1;
				}

				switch (alt14) {
				case 1 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:122:90: ',' id3= Identifier
					{
					match(input,17,FOLLOW_17_in_insertInto479); 
					id3=(Token)match(input,Identifier,FOLLOW_Identifier_in_insertInto483); 
					ColumnsInsertInto.add((id3!=null?id3.getText():null));
					}
					break;

				default :
					break loop14;
				}
			}

			match(input,14,FOLLOW_14_in_insertInto490); 
			match(input,50,FOLLOW_50_in_insertInto492); 
			match(input,13,FOLLOW_13_in_insertInto494); 
			id4=(Token)match(input,Identifier,FOLLOW_Identifier_in_insertInto498); 
			 ColumnsInsertInto.add("VALUES");  ColumnsInsertInto.add((id4!=null?id4.getText():null));
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:123:2: ( ',' id5= Identifier )*
			loop15:
			while (true) {
				int alt15=2;
				int LA15_0 = input.LA(1);
				if ( (LA15_0==17) ) {
					alt15=1;
				}

				switch (alt15) {
				case 1 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:123:3: ',' id5= Identifier
					{
					match(input,17,FOLLOW_17_in_insertInto505); 
					id5=(Token)match(input,Identifier,FOLLOW_Identifier_in_insertInto509); 
					ColumnsInsertInto.add((id5!=null?id5.getText():null)); 
					}
					break;

				default :
					break loop15;
				}
			}

			match(input,15,FOLLOW_15_in_insertInto515); 

					
				
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
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:129:1: whereStatement : 'WHERE' Identifier CompareOperator Identifier ;
	public final void whereStatement() throws RecognitionException {
		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:130:2: ( 'WHERE' Identifier CompareOperator Identifier )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:130:4: 'WHERE' Identifier CompareOperator Identifier
			{
			match(input,51,FOLLOW_51_in_whereStatement537); 
			match(input,Identifier,FOLLOW_Identifier_in_whereStatement539); 
			match(input,CompareOperator,FOLLOW_CompareOperator_in_whereStatement541); 
			match(input,Identifier,FOLLOW_Identifier_in_whereStatement543); 
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
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:132:1: joinStatement : 'JOIN' Identifier 'ON' Identifier '.' Identifier '=' Identifier '.' Identifier ;
	public final void joinStatement() throws RecognitionException {
		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:133:2: ( 'JOIN' Identifier 'ON' Identifier '.' Identifier '=' Identifier '.' Identifier )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:133:4: 'JOIN' Identifier 'ON' Identifier '.' Identifier '=' Identifier '.' Identifier
			{
			match(input,39,FOLLOW_39_in_joinStatement553); 
			match(input,Identifier,FOLLOW_Identifier_in_joinStatement555); 
			match(input,41,FOLLOW_41_in_joinStatement557); 
			match(input,Identifier,FOLLOW_Identifier_in_joinStatement559); 
			match(input,18,FOLLOW_18_in_joinStatement561); 
			match(input,Identifier,FOLLOW_Identifier_in_joinStatement563); 
			match(input,20,FOLLOW_20_in_joinStatement565); 
			match(input,Identifier,FOLLOW_Identifier_in_joinStatement567); 
			match(input,18,FOLLOW_18_in_joinStatement569); 
			match(input,Identifier,FOLLOW_Identifier_in_joinStatement571); 
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
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:139:1: constraintDefinition : 'FOREIGN KEY' '(' id1= Identifier ')' 'REFERENCES' id2= Identifier '(' id3= Identifier ')' ;
	public final void constraintDefinition() throws RecognitionException {
		Token id1=null;
		Token id2=null;
		Token id3=null;

		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:140:2: ( 'FOREIGN KEY' '(' id1= Identifier ')' 'REFERENCES' id2= Identifier '(' id3= Identifier ')' )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:140:4: 'FOREIGN KEY' '(' id1= Identifier ')' 'REFERENCES' id2= Identifier '(' id3= Identifier ')'
			{
			match(input,34,FOLLOW_34_in_constraintDefinition632); 
			match(input,13,FOLLOW_13_in_constraintDefinition634); 
			id1=(Token)match(input,Identifier,FOLLOW_Identifier_in_constraintDefinition638); 
			match(input,14,FOLLOW_14_in_constraintDefinition640); 
			match(input,43,FOLLOW_43_in_constraintDefinition642); 
			id2=(Token)match(input,Identifier,FOLLOW_Identifier_in_constraintDefinition646); 
			match(input,13,FOLLOW_13_in_constraintDefinition648); 
			id3=(Token)match(input,Identifier,FOLLOW_Identifier_in_constraintDefinition652); 
			match(input,14,FOLLOW_14_in_constraintDefinition654); 

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
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:148:1: columnDefinition : Identifier Type Nullability ;
	public final void columnDefinition() throws RecognitionException {
		Token Nullability7=null;
		Token Type8=null;

		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:149:2: ( Identifier Type Nullability )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:149:4: Identifier Type Nullability
			{
			match(input,Identifier,FOLLOW_Identifier_in_columnDefinition668); 
			Type8=(Token)match(input,Type,FOLLOW_Type_in_columnDefinition670); 
			Nullability7=(Token)match(input,Nullability,FOLLOW_Nullability_in_columnDefinition672); 

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
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:169:1: primaryKey : 'PRIMARY KEY(' Identifier ')' ;
	public final void primaryKey() throws RecognitionException {
		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:170:2: ( 'PRIMARY KEY(' Identifier ')' )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:170:4: 'PRIMARY KEY(' Identifier ')'
			{
			match(input,42,FOLLOW_42_in_primaryKey743); 
			match(input,Identifier,FOLLOW_Identifier_in_primaryKey745); 
			match(input,14,FOLLOW_14_in_primaryKey747); 

					
				
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



	public static final BitSet FOLLOW_script_in_query25 = new BitSet(new long[]{0x0003B120FE000002L});
	public static final BitSet FOLLOW_createDB_in_script36 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_dropDB_in_script40 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_listDB_in_script44 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_startDB_in_script47 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_stopDB_in_script53 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_displayDB_in_script57 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_setDB_in_script61 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_createTable_in_script65 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_alterTable_in_script69 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_dropTable_in_script73 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_createIndex_in_script76 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_selectStatement_in_script79 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_updateStatement_in_script83 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_delete_in_script87 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_insertInto_in_script91 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_25_in_createDB104 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_Identifier_in_createDB106 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_30_in_dropDB120 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_Identifier_in_dropDB122 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_40_in_listDB137 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_47_in_startDB147 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_48_in_stopDB158 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_29_in_displayDB169 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_Identifier_in_displayDB171 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_45_in_setDB185 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_Identifier_in_setDB187 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_19_in_setDB189 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_27_in_createTable201 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_Identifier_in_createTable203 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_23_in_createTable204 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_createTable206 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_columnDefinition_in_createTable208 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_17_in_createTable213 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_columnDefinition_in_createTable216 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_17_in_createTable221 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_primaryKey_in_createTable224 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_14_in_createTable226 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_22_in_alterTable240 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_Identifier_in_alterTable242 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_21_in_alterTable244 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_24_in_alterTable246 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_constraintDefinition_in_alterTable248 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_31_in_dropTable259 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_Identifier_in_dropTable261 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_19_in_dropTable263 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_26_in_createIndex273 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_Identifier_in_createIndex277 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_41_in_createIndex279 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_Identifier_in_createIndex283 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_createIndex285 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_Identifier_in_createIndex288 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_14_in_createIndex290 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_44_in_selectStatement303 = new BitSet(new long[]{0x0000000000010080L});
	public static final BitSet FOLLOW_16_in_selectStatement306 = new BitSet(new long[]{0x0000000800020010L});
	public static final BitSet FOLLOW_Identifier_in_selectStatement314 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_18_in_selectStatement317 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_Identifier_in_selectStatement321 = new BitSet(new long[]{0x0000000800020010L});
	public static final BitSet FOLLOW_17_in_selectStatement328 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_Identifier_in_selectStatement332 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_18_in_selectStatement335 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_Identifier_in_selectStatement339 = new BitSet(new long[]{0x0000000800020010L});
	public static final BitSet FOLLOW_17_in_selectStatement354 = new BitSet(new long[]{0x0000000800020010L});
	public static final BitSet FOLLOW_AggregateFunctions_in_selectStatement359 = new BitSet(new long[]{0x0000000800000010L});
	public static final BitSet FOLLOW_35_in_selectStatement364 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_Identifier_in_selectStatement366 = new BitSet(new long[]{0x0008009300000002L});
	public static final BitSet FOLLOW_joinStatement_in_selectStatement369 = new BitSet(new long[]{0x0008009300000002L});
	public static final BitSet FOLLOW_whereStatement_in_selectStatement377 = new BitSet(new long[]{0x0008001300000002L});
	public static final BitSet FOLLOW_36_in_selectStatement382 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_Identifier_in_selectStatement384 = new BitSet(new long[]{0x0000001300000002L});
	public static final BitSet FOLLOW_49_in_updateStatement406 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_Identifier_in_updateStatement408 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_46_in_updateStatement410 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_Identifier_in_updateStatement412 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_20_in_updateStatement414 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_Identifier_in_updateStatement415 = new BitSet(new long[]{0x0008000000000002L});
	public static final BitSet FOLLOW_whereStatement_in_updateStatement418 = new BitSet(new long[]{0x0008000000000002L});
	public static final BitSet FOLLOW_28_in_delete435 = new BitSet(new long[]{0x0000000800000000L});
	public static final BitSet FOLLOW_35_in_delete437 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_Identifier_in_delete439 = new BitSet(new long[]{0x0008000000000002L});
	public static final BitSet FOLLOW_whereStatement_in_delete442 = new BitSet(new long[]{0x0008000000000002L});
	public static final BitSet FOLLOW_37_in_insertInto463 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_38_in_insertInto465 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_Identifier_in_insertInto469 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_insertInto471 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_Identifier_in_insertInto475 = new BitSet(new long[]{0x0000000000024000L});
	public static final BitSet FOLLOW_17_in_insertInto479 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_Identifier_in_insertInto483 = new BitSet(new long[]{0x0000000000024000L});
	public static final BitSet FOLLOW_14_in_insertInto490 = new BitSet(new long[]{0x0004000000000000L});
	public static final BitSet FOLLOW_50_in_insertInto492 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_insertInto494 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_Identifier_in_insertInto498 = new BitSet(new long[]{0x0000000000028000L});
	public static final BitSet FOLLOW_17_in_insertInto505 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_Identifier_in_insertInto509 = new BitSet(new long[]{0x0000000000028000L});
	public static final BitSet FOLLOW_15_in_insertInto515 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_51_in_whereStatement537 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_Identifier_in_whereStatement539 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_CompareOperator_in_whereStatement541 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_Identifier_in_whereStatement543 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_39_in_joinStatement553 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_Identifier_in_joinStatement555 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_41_in_joinStatement557 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_Identifier_in_joinStatement559 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_18_in_joinStatement561 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_Identifier_in_joinStatement563 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_20_in_joinStatement565 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_Identifier_in_joinStatement567 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_18_in_joinStatement569 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_Identifier_in_joinStatement571 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_34_in_constraintDefinition632 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_constraintDefinition634 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_Identifier_in_constraintDefinition638 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_14_in_constraintDefinition640 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_43_in_constraintDefinition642 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_Identifier_in_constraintDefinition646 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_constraintDefinition648 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_Identifier_in_constraintDefinition652 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_14_in_constraintDefinition654 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Identifier_in_columnDefinition668 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_Type_in_columnDefinition670 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_Nullability_in_columnDefinition672 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_42_in_primaryKey743 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_Identifier_in_primaryKey745 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_14_in_primaryKey747 = new BitSet(new long[]{0x0000000000000002L});
}
