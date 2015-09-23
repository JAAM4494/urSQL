// $ANTLR 3.5.1 /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g 2015-09-22 23:00:40

	package RuntimeDBProcessor.parser;
	import RuntimeDBProcessor.*;
   


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class urSQLParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "AggregateFunctions", "DIGIT", 
		"Identifier", "LETTER", "Nullability", "Number", "Type", "WS", "'('", 
		"')'", "'*'", "','", "'.'", "';'", "'<'", "'='", "'>'", "'ADD'", "'ALTER TABLE'", 
		"'AS'", "'CONSTRAINT'", "'CREATE DATABASE'", "'CREATE INDEX'", "'CREATE TABLE'", 
		"'DELETE'", "'DISPLAY DATABASE'", "'DROP DATABASE'", "'DROP TABLE'", "'FOR JSON'", 
		"'FOR XML'", "'FOREIGN KEY'", "'FROM'", "'GROUP BY'", "'INSERT'", "'INTO'", 
		"'JOIN'", "'LIST DATABASES'", "'ON'", "'PRIMARY KEY('", "'REFERENCES'", 
		"'SELECT'", "'SET DATABASE'", "'START'", "'STOP'", "'Set'", "'UPDATE'", 
		"'VALUES'", "'WHERE'", "'is not null'", "'is null'", "'like'", "'not'"
	};
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
	public static final int T__55=55;
	public static final int AggregateFunctions=4;
	public static final int DIGIT=5;
	public static final int Identifier=6;
	public static final int LETTER=7;
	public static final int Nullability=8;
	public static final int Number=9;
	public static final int Type=10;
	public static final int WS=11;

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
		public ArrayList<String> ColumnsCreateTable = new ArrayList<String>();
		public ArrayList<String> ColumnsAlterTable = new ArrayList<String>();
		
		public ArrayList<String> ColumnsCreateIndex = new ArrayList<String>();
		
		public ArrayList<String> ColumnsUpdate = new ArrayList<String>();
		
		public ArrayList<String> ColumnsDelete = new ArrayList<String>();



		


		RuntimeDB mainRuntime= new RuntimeDB();
		
	    	public void displayRecognitionError(String[] tokenNames,
	                                        RecognitionException e) {
	        	String hdr = getErrorHeader(e);
	        	String msg = getErrorMessage(e, tokenNames);
	        	System.out.println("Query malo"+e);
	        	
	        	
	 
	    }



	// $ANTLR start "query"
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:41:1: query : ( script )* ;
	public final void query() throws RecognitionException {
		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:41:7: ( ( script )* )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:42:2: ( script )*
			{
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:42:2: ( script )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==22||(LA1_0 >= 25 && LA1_0 <= 31)||LA1_0==37||LA1_0==40||(LA1_0 >= 44 && LA1_0 <= 47)||LA1_0==49) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:42:2: script
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
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:44:1: script : ( createDB | dropDB | listDB | startDB | stopDB | displayDB | setDB | createTable | alterTable | dropTable | createIndex | selectStatement | updateStatement | delete | insertInto );
	public final void script() throws RecognitionException {
		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:44:8: ( createDB | dropDB | listDB | startDB | stopDB | displayDB | setDB | createTable | alterTable | dropTable | createIndex | selectStatement | updateStatement | delete | insertInto )
			int alt2=15;
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
			case 46:
				{
				alt2=4;
				}
				break;
			case 47:
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
			case 22:
				{
				alt2=9;
				}
				break;
			case 31:
				{
				alt2=10;
				}
				break;
			case 26:
				{
				alt2=11;
				}
				break;
			case 44:
				{
				alt2=12;
				}
				break;
			case 49:
				{
				alt2=13;
				}
				break;
			case 28:
				{
				alt2=14;
				}
				break;
			case 37:
				{
				alt2=15;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}
			switch (alt2) {
				case 1 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:45:2: createDB
					{
					pushFollow(FOLLOW_createDB_in_script36);
					createDB();
					state._fsp--;

					}
					break;
				case 2 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:45:13: dropDB
					{
					pushFollow(FOLLOW_dropDB_in_script40);
					dropDB();
					state._fsp--;

					}
					break;
				case 3 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:45:22: listDB
					{
					pushFollow(FOLLOW_listDB_in_script44);
					listDB();
					state._fsp--;

					}
					break;
				case 4 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:45:30: startDB
					{
					pushFollow(FOLLOW_startDB_in_script47);
					startDB();
					state._fsp--;

					}
					break;
				case 5 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:45:42: stopDB
					{
					pushFollow(FOLLOW_stopDB_in_script53);
					stopDB();
					state._fsp--;

					}
					break;
				case 6 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:45:51: displayDB
					{
					pushFollow(FOLLOW_displayDB_in_script57);
					displayDB();
					state._fsp--;

					}
					break;
				case 7 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:45:63: setDB
					{
					pushFollow(FOLLOW_setDB_in_script61);
					setDB();
					state._fsp--;

					}
					break;
				case 8 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:45:71: createTable
					{
					pushFollow(FOLLOW_createTable_in_script65);
					createTable();
					state._fsp--;

					}
					break;
				case 9 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:46:3: alterTable
					{
					pushFollow(FOLLOW_alterTable_in_script70);
					alterTable();
					state._fsp--;

					}
					break;
				case 10 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:46:16: dropTable
					{
					pushFollow(FOLLOW_dropTable_in_script74);
					dropTable();
					state._fsp--;

					}
					break;
				case 11 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:46:27: createIndex
					{
					pushFollow(FOLLOW_createIndex_in_script77);
					createIndex();
					state._fsp--;

					}
					break;
				case 12 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:46:40: selectStatement
					{
					pushFollow(FOLLOW_selectStatement_in_script80);
					selectStatement();
					state._fsp--;

					}
					break;
				case 13 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:46:58: updateStatement
					{
					pushFollow(FOLLOW_updateStatement_in_script84);
					updateStatement();
					state._fsp--;

					}
					break;
				case 14 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:46:77: delete
					{
					pushFollow(FOLLOW_delete_in_script89);
					delete();
					state._fsp--;

					}
					break;
				case 15 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:46:86: insertInto
					{
					pushFollow(FOLLOW_insertInto_in_script93);
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
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:51:1: createDB : 'CREATE DATABASE' Identifier ;
	public final void createDB() throws RecognitionException {
		Token Identifier1=null;

		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:52:2: ( 'CREATE DATABASE' Identifier )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:52:4: 'CREATE DATABASE' Identifier
			{
			match(input,25,FOLLOW_25_in_createDB106); 
			Identifier1=(Token)match(input,Identifier,FOLLOW_Identifier_in_createDB108); 

				mainRuntime.CreateDB((Identifier1!=null?Identifier1.getText():null));
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
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:59:1: dropDB : 'DROP DATABASE' Identifier ;
	public final void dropDB() throws RecognitionException {
		Token Identifier2=null;

		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:60:2: ( 'DROP DATABASE' Identifier )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:60:4: 'DROP DATABASE' Identifier
			{
			match(input,30,FOLLOW_30_in_dropDB122); 
			Identifier2=(Token)match(input,Identifier,FOLLOW_Identifier_in_dropDB124); 

				mainRuntime.DropDB((Identifier2!=null?Identifier2.getText():null));
				
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
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:67:1: listDB : 'LIST DATABASES' ;
	public final void listDB() throws RecognitionException {
		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:67:8: ( 'LIST DATABASES' )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:67:10: 'LIST DATABASES'
			{
			match(input,40,FOLLOW_40_in_listDB139); 

					mainRuntime.ListDB();

				
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
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:72:1: startDB : 'START' ;
	public final void startDB() throws RecognitionException {
		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:72:9: ( 'START' )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:72:11: 'START'
			{
			match(input,46,FOLLOW_46_in_startDB149); 
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
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:76:1: stopDB : 'STOP' ;
	public final void stopDB() throws RecognitionException {
		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:76:8: ( 'STOP' )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:76:10: 'STOP'
			{
			match(input,47,FOLLOW_47_in_stopDB160); 
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
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:78:1: displayDB : 'DISPLAY DATABASE' Identifier ;
	public final void displayDB() throws RecognitionException {
		Token Identifier3=null;

		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:79:2: ( 'DISPLAY DATABASE' Identifier )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:79:4: 'DISPLAY DATABASE' Identifier
			{
			match(input,29,FOLLOW_29_in_displayDB171); 
			Identifier3=(Token)match(input,Identifier,FOLLOW_Identifier_in_displayDB173); 

						mainRuntime.DisplayDB((Identifier3!=null?Identifier3.getText():null));

						
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
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:87:1: setDB : 'SET DATABASE' id1= Identifier ;
	public final void setDB() throws RecognitionException {
		Token id1=null;

		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:88:2: ( 'SET DATABASE' id1= Identifier )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:88:4: 'SET DATABASE' id1= Identifier
			{
			match(input,45,FOLLOW_45_in_setDB187); 
			id1=(Token)match(input,Identifier,FOLLOW_Identifier_in_setDB191); 

					mainRuntime.setDB((id1!=null?id1.getText():null));

						
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
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:95:1: createTable : 'CREATE TABLE' Identifier 'AS' '(' columnDefinition ( ',' columnDefinition )* ',' primaryKey ')' ;
	public final void createTable() throws RecognitionException {
		Token Identifier4=null;

		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:96:2: ( 'CREATE TABLE' Identifier 'AS' '(' columnDefinition ( ',' columnDefinition )* ',' primaryKey ')' )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:96:4: 'CREATE TABLE' Identifier 'AS' '(' columnDefinition ( ',' columnDefinition )* ',' primaryKey ')'
			{
			match(input,27,FOLLOW_27_in_createTable203); 
			Identifier4=(Token)match(input,Identifier,FOLLOW_Identifier_in_createTable205); 
			ColumnsCreateTable.add((Identifier4!=null?Identifier4.getText():null));
			match(input,23,FOLLOW_23_in_createTable207); 
			match(input,12,FOLLOW_12_in_createTable209); 
			pushFollow(FOLLOW_columnDefinition_in_createTable211);
			columnDefinition();
			state._fsp--;

			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:96:100: ( ',' columnDefinition )*
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( (LA3_0==15) ) {
					int LA3_1 = input.LA(2);
					if ( (LA3_1==Identifier) ) {
						alt3=1;
					}

				}

				switch (alt3) {
				case 1 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:96:101: ',' columnDefinition
					{
					match(input,15,FOLLOW_15_in_createTable216); 
					pushFollow(FOLLOW_columnDefinition_in_createTable219);
					columnDefinition();
					state._fsp--;

					}
					break;

				default :
					break loop3;
				}
			}

			match(input,15,FOLLOW_15_in_createTable224); 
			pushFollow(FOLLOW_primaryKey_in_createTable227);
			primaryKey();
			state._fsp--;

			match(input,13,FOLLOW_13_in_createTable229); 

					mainRuntime.createTable(ColumnsCreateTable);
					
				
				
				
				 
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
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:104:1: alterTable : 'ALTER TABLE' Identifier 'ADD' 'CONSTRAINT' constraintDefinition ;
	public final void alterTable() throws RecognitionException {
		Token Identifier5=null;

		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:105:2: ( 'ALTER TABLE' Identifier 'ADD' 'CONSTRAINT' constraintDefinition )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:105:4: 'ALTER TABLE' Identifier 'ADD' 'CONSTRAINT' constraintDefinition
			{
			match(input,22,FOLLOW_22_in_alterTable243); 
			Identifier5=(Token)match(input,Identifier,FOLLOW_Identifier_in_alterTable245); 
			ColumnsAlterTable.add((Identifier5!=null?Identifier5.getText():null));
			match(input,21,FOLLOW_21_in_alterTable248); 
			match(input,24,FOLLOW_24_in_alterTable250); 
			pushFollow(FOLLOW_constraintDefinition_in_alterTable252);
			constraintDefinition();
			state._fsp--;


					mainRuntime.alterTable(ColumnsAlterTable);
				
				
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
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:110:1: dropTable : 'DROP TABLE' Identifier ';' ;
	public final void dropTable() throws RecognitionException {
		Token Identifier6=null;

		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:111:2: ( 'DROP TABLE' Identifier ';' )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:111:4: 'DROP TABLE' Identifier ';'
			{
			match(input,31,FOLLOW_31_in_dropTable263); 
			Identifier6=(Token)match(input,Identifier,FOLLOW_Identifier_in_dropTable265); 
			match(input,17,FOLLOW_17_in_dropTable267); 

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
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:115:1: createIndex : 'CREATE INDEX' id1= Identifier 'ON' id2= Identifier '(' id3= Identifier ')' ;
	public final void createIndex() throws RecognitionException {
		Token id1=null;
		Token id2=null;
		Token id3=null;

		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:116:2: ( 'CREATE INDEX' id1= Identifier 'ON' id2= Identifier '(' id3= Identifier ')' )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:116:4: 'CREATE INDEX' id1= Identifier 'ON' id2= Identifier '(' id3= Identifier ')'
			{
			match(input,26,FOLLOW_26_in_createIndex277); 
			id1=(Token)match(input,Identifier,FOLLOW_Identifier_in_createIndex281); 
			match(input,41,FOLLOW_41_in_createIndex283); 
			id2=(Token)match(input,Identifier,FOLLOW_Identifier_in_createIndex287); 
			match(input,12,FOLLOW_12_in_createIndex289); 
			id3=(Token)match(input,Identifier,FOLLOW_Identifier_in_createIndex292); 
			match(input,13,FOLLOW_13_in_createIndex294); 

					
					ColumnsCreateIndex.add((id1!=null?id1.getText():null));
					ColumnsCreateIndex.add((id2!=null?id2.getText():null));
					
					ColumnsCreateIndex.add((id3!=null?id3.getText():null));

					mainRuntime.createIndex(ColumnsCreateIndex);
					
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
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:138:1: selectStatement : 'SELECT' id1= ( '*' )* id2= Identifier ( '.' id3= Identifier )* ( ',' id4= Identifier ( '.' id5= Identifier )* )* ( ',' )* (Ag= AggregateFunctions )* 'FROM' fromId= Identifier ( joinStatement )* ( whereStatement )* ( 'GROUP BY' id6= Identifier )* ( 'FOR JSON' | 'FOR XML' )* ;
	public final void selectStatement() throws RecognitionException {
		Token id1=null;
		Token id2=null;
		Token id3=null;
		Token id4=null;
		Token id5=null;
		Token Ag=null;
		Token fromId=null;
		Token id6=null;

		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:138:17: ( 'SELECT' id1= ( '*' )* id2= Identifier ( '.' id3= Identifier )* ( ',' id4= Identifier ( '.' id5= Identifier )* )* ( ',' )* (Ag= AggregateFunctions )* 'FROM' fromId= Identifier ( joinStatement )* ( whereStatement )* ( 'GROUP BY' id6= Identifier )* ( 'FOR JSON' | 'FOR XML' )* )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:139:3: 'SELECT' id1= ( '*' )* id2= Identifier ( '.' id3= Identifier )* ( ',' id4= Identifier ( '.' id5= Identifier )* )* ( ',' )* (Ag= AggregateFunctions )* 'FROM' fromId= Identifier ( joinStatement )* ( whereStatement )* ( 'GROUP BY' id6= Identifier )* ( 'FOR JSON' | 'FOR XML' )*
			{
			match(input,44,FOLLOW_44_in_selectStatement311); 
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:139:16: ( '*' )*
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( (LA4_0==14) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:139:17: '*'
					{
					id1=(Token)match(input,14,FOLLOW_14_in_selectStatement316); 
					}
					break;

				default :
					break loop4;
				}
			}

			id2=(Token)match(input,Identifier,FOLLOW_Identifier_in_selectStatement323); 
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:139:39: ( '.' id3= Identifier )*
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( (LA5_0==16) ) {
					alt5=1;
				}

				switch (alt5) {
				case 1 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:139:40: '.' id3= Identifier
					{
					match(input,16,FOLLOW_16_in_selectStatement326); 
					id3=(Token)match(input,Identifier,FOLLOW_Identifier_in_selectStatement330); 
					}
					break;

				default :
					break loop5;
				}
			}

			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:139:64: ( ',' id4= Identifier ( '.' id5= Identifier )* )*
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( (LA7_0==15) ) {
					int LA7_1 = input.LA(2);
					if ( (LA7_1==Identifier) ) {
						alt7=1;
					}

				}

				switch (alt7) {
				case 1 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:139:65: ',' id4= Identifier ( '.' id5= Identifier )*
					{
					match(input,15,FOLLOW_15_in_selectStatement338); 
					id4=(Token)match(input,Identifier,FOLLOW_Identifier_in_selectStatement342); 
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:139:84: ( '.' id5= Identifier )*
					loop6:
					while (true) {
						int alt6=2;
						int LA6_0 = input.LA(1);
						if ( (LA6_0==16) ) {
							alt6=1;
						}

						switch (alt6) {
						case 1 :
							// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:139:85: '.' id5= Identifier
							{
							match(input,16,FOLLOW_16_in_selectStatement345); 
							id5=(Token)match(input,Identifier,FOLLOW_Identifier_in_selectStatement349); 
							}
							break;

						default :
							break loop6;
						}
					}

					}
					break;

				default :
					break loop7;
				}
			}

			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:139:114: ( ',' )*
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( (LA8_0==15) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:139:115: ','
					{
					match(input,15,FOLLOW_15_in_selectStatement362); 
					}
					break;

				default :
					break loop8;
				}
			}

			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:139:122: (Ag= AggregateFunctions )*
			loop9:
			while (true) {
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( (LA9_0==AggregateFunctions) ) {
					alt9=1;
				}

				switch (alt9) {
				case 1 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:139:123: Ag= AggregateFunctions
					{
					Ag=(Token)match(input,AggregateFunctions,FOLLOW_AggregateFunctions_in_selectStatement370); 
					}
					break;

				default :
					break loop9;
				}
			}

			match(input,35,FOLLOW_35_in_selectStatement375); 
			fromId=(Token)match(input,Identifier,FOLLOW_Identifier_in_selectStatement379); 
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:139:173: ( joinStatement )*
			loop10:
			while (true) {
				int alt10=2;
				int LA10_0 = input.LA(1);
				if ( (LA10_0==39) ) {
					alt10=1;
				}

				switch (alt10) {
				case 1 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:139:174: joinStatement
					{
					pushFollow(FOLLOW_joinStatement_in_selectStatement382);
					joinStatement();
					state._fsp--;

					}
					break;

				default :
					break loop10;
				}
			}

			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:140:3: ( whereStatement )*
			loop11:
			while (true) {
				int alt11=2;
				int LA11_0 = input.LA(1);
				if ( (LA11_0==51) ) {
					alt11=1;
				}

				switch (alt11) {
				case 1 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:140:4: whereStatement
					{
					pushFollow(FOLLOW_whereStatement_in_selectStatement389);
					whereStatement();
					state._fsp--;

					}
					break;

				default :
					break loop11;
				}
			}

			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:140:21: ( 'GROUP BY' id6= Identifier )*
			loop12:
			while (true) {
				int alt12=2;
				int LA12_0 = input.LA(1);
				if ( (LA12_0==36) ) {
					alt12=1;
				}

				switch (alt12) {
				case 1 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:140:22: 'GROUP BY' id6= Identifier
					{
					match(input,36,FOLLOW_36_in_selectStatement394); 
					id6=(Token)match(input,Identifier,FOLLOW_Identifier_in_selectStatement398); 
					}
					break;

				default :
					break loop12;
				}
			}

			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:140:50: ( 'FOR JSON' | 'FOR XML' )*
			loop13:
			while (true) {
				int alt13=2;
				int LA13_0 = input.LA(1);
				if ( ((LA13_0 >= 32 && LA13_0 <= 33)) ) {
					alt13=1;
				}

				switch (alt13) {
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
					break loop13;
				}
			}

				
					
						if((id1!=null?id1.getText():null)!=null){
							ColumnsSelect.add((id1!=null?id1.getText():null));

						}
						if((id2!=null?id2.getText():null)!=null){
							ColumnsSelect.add((id2!=null?id2.getText():null));
						}
						
						if((id3!=null?id3.getText():null)!=null){
							ColumnsSelect.add(".");
							ColumnsSelect.add((id3!=null?id3.getText():null));
						}
						
						if((id4!=null?id4.getText():null)!=null){
							ColumnsSelect.add((id4!=null?id4.getText():null));
						}
						if((id5!=null?id5.getText():null)!=null){
							ColumnsSelect.add(".");
							ColumnsSelect.add((id5!=null?id5.getText():null));
						}
						if((Ag!=null?Ag.getText():null)!=null){
							ColumnsSelect.add("Aggregate Function");
							ColumnsSelect.add((Ag!=null?Ag.getText():null));
						}
						ColumnsSelect.add("FROM");
						ColumnsSelect.add((fromId!=null?fromId.getText():null));
						
						if((id6!=null?id6.getText():null)!=null){
							ColumnsSelect.add("GROUP BY");
							ColumnsSelect.add((Ag!=null?Ag.getText():null));
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
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:183:1: updateStatement : 'UPDATE' id1= Identifier 'Set' id2= Identifier '=' id3= Identifier ( whereStatementUpdate )* ;
	public final void updateStatement() throws RecognitionException {
		Token id1=null;
		Token id2=null;
		Token id3=null;

		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:184:2: ( 'UPDATE' id1= Identifier 'Set' id2= Identifier '=' id3= Identifier ( whereStatementUpdate )* )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:184:4: 'UPDATE' id1= Identifier 'Set' id2= Identifier '=' id3= Identifier ( whereStatementUpdate )*
			{
			match(input,49,FOLLOW_49_in_updateStatement439); 
			id1=(Token)match(input,Identifier,FOLLOW_Identifier_in_updateStatement443); 
			ColumnsUpdate.add((id1!=null?id1.getText():null));
			match(input,48,FOLLOW_48_in_updateStatement446); 
			id2=(Token)match(input,Identifier,FOLLOW_Identifier_in_updateStatement450); 
			ColumnsUpdate.add((id2!=null?id2.getText():null));
			match(input,19,FOLLOW_19_in_updateStatement453); 
			id3=(Token)match(input,Identifier,FOLLOW_Identifier_in_updateStatement459); 
			ColumnsUpdate.add((id3!=null?id3.getText():null));
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:186:5: ( whereStatementUpdate )*
			loop14:
			while (true) {
				int alt14=2;
				int LA14_0 = input.LA(1);
				if ( (LA14_0==51) ) {
					alt14=1;
				}

				switch (alt14) {
				case 1 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:186:6: whereStatementUpdate
					{
					pushFollow(FOLLOW_whereStatementUpdate_in_updateStatement468);
					whereStatementUpdate();
					state._fsp--;

					}
					break;

				default :
					break loop14;
				}
			}


					mainRuntime.update(ColumnsUpdate);
					
				
				
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
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:193:1: delete : 'DELETE' 'FROM' Identifier ( whereStatementDelete )* ;
	public final void delete() throws RecognitionException {
		Token Identifier7=null;

		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:193:8: ( 'DELETE' 'FROM' Identifier ( whereStatementDelete )* )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:194:3: 'DELETE' 'FROM' Identifier ( whereStatementDelete )*
			{
			match(input,28,FOLLOW_28_in_delete485); 
			match(input,35,FOLLOW_35_in_delete487); 
			Identifier7=(Token)match(input,Identifier,FOLLOW_Identifier_in_delete489); 
			ColumnsDelete.add((Identifier7!=null?Identifier7.getText():null));
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:194:68: ( whereStatementDelete )*
			loop15:
			while (true) {
				int alt15=2;
				int LA15_0 = input.LA(1);
				if ( (LA15_0==51) ) {
					alt15=1;
				}

				switch (alt15) {
				case 1 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:194:69: whereStatementDelete
					{
					pushFollow(FOLLOW_whereStatementDelete_in_delete493);
					whereStatementDelete();
					state._fsp--;

					}
					break;

				default :
					break loop15;
				}
			}


						mainRuntime.delete(ColumnsDelete);
					
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
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:198:1: insertInto : 'INSERT' 'INTO' id1= Identifier '(' id2= Identifier ( ',' id3= Identifier )* ')' 'VALUES' '(' id4= Identifier ( ',' id5= Identifier )* ')' ;
	public final void insertInto() throws RecognitionException {
		Token id1=null;
		Token id2=null;
		Token id3=null;
		Token id4=null;
		Token id5=null;

		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:199:2: ( 'INSERT' 'INTO' id1= Identifier '(' id2= Identifier ( ',' id3= Identifier )* ')' 'VALUES' '(' id4= Identifier ( ',' id5= Identifier )* ')' )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:199:4: 'INSERT' 'INTO' id1= Identifier '(' id2= Identifier ( ',' id3= Identifier )* ')' 'VALUES' '(' id4= Identifier ( ',' id5= Identifier )* ')'
			{
			match(input,37,FOLLOW_37_in_insertInto508); 
			match(input,38,FOLLOW_38_in_insertInto510); 
			id1=(Token)match(input,Identifier,FOLLOW_Identifier_in_insertInto514); 
			ColumnsInsertInto.add((id1!=null?id1.getText():null)); 
			match(input,12,FOLLOW_12_in_insertInto517); 
			id2=(Token)match(input,Identifier,FOLLOW_Identifier_in_insertInto521); 
			ColumnsInsertInto.add((id2!=null?id2.getText():null));
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:199:126: ( ',' id3= Identifier )*
			loop16:
			while (true) {
				int alt16=2;
				int LA16_0 = input.LA(1);
				if ( (LA16_0==15) ) {
					alt16=1;
				}

				switch (alt16) {
				case 1 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:199:127: ',' id3= Identifier
					{
					match(input,15,FOLLOW_15_in_insertInto526); 
					id3=(Token)match(input,Identifier,FOLLOW_Identifier_in_insertInto530); 
					ColumnsInsertInto.add((id3!=null?id3.getText():null));
					}
					break;

				default :
					break loop16;
				}
			}

			match(input,13,FOLLOW_13_in_insertInto537); 
			match(input,50,FOLLOW_50_in_insertInto539); 
			match(input,12,FOLLOW_12_in_insertInto541); 
			id4=(Token)match(input,Identifier,FOLLOW_Identifier_in_insertInto545); 
			 ColumnsInsertInto.add("VALUES");  ColumnsInsertInto.add((id4!=null?id4.getText():null));
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:200:2: ( ',' id5= Identifier )*
			loop17:
			while (true) {
				int alt17=2;
				int LA17_0 = input.LA(1);
				if ( (LA17_0==15) ) {
					alt17=1;
				}

				switch (alt17) {
				case 1 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:200:3: ',' id5= Identifier
					{
					match(input,15,FOLLOW_15_in_insertInto552); 
					id5=(Token)match(input,Identifier,FOLLOW_Identifier_in_insertInto556); 
					ColumnsInsertInto.add((id5!=null?id5.getText():null)); 
					}
					break;

				default :
					break loop17;
				}
			}

			match(input,13,FOLLOW_13_in_insertInto562); 

					mainRuntime.delete(ColumnsInsertInto);

				
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
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:207:1: whereStatement : 'WHERE' Identifier id2= ( '>' | '<' | '=' | 'like' | 'not' | 'is null' | 'is not null' ) ( Identifier | Number ) ;
	public final void whereStatement() throws RecognitionException {
		Token id2=null;

		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:208:2: ( 'WHERE' Identifier id2= ( '>' | '<' | '=' | 'like' | 'not' | 'is null' | 'is not null' ) ( Identifier | Number ) )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:208:4: 'WHERE' Identifier id2= ( '>' | '<' | '=' | 'like' | 'not' | 'is null' | 'is not null' ) ( Identifier | Number )
			{
			match(input,51,FOLLOW_51_in_whereStatement584); 
			match(input,Identifier,FOLLOW_Identifier_in_whereStatement586); 
			id2=input.LT(1);
			if ( (input.LA(1) >= 18 && input.LA(1) <= 20)||(input.LA(1) >= 52 && input.LA(1) <= 55) ) {
				input.consume();
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			if ( input.LA(1)==Identifier||input.LA(1)==Number ) {
				input.consume();
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
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
	// $ANTLR end "whereStatement"



	// $ANTLR start "whereStatementUpdate"
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:210:1: whereStatementUpdate : 'WHERE' id1= Identifier id2= ( '>' | '<' | '=' | 'like' | 'not' | 'is null' | 'is not null' ) id3= ( Identifier | Number ) ;
	public final void whereStatementUpdate() throws RecognitionException {
		Token id1=null;
		Token id2=null;
		Token id3=null;

		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:211:2: ( 'WHERE' id1= Identifier id2= ( '>' | '<' | '=' | 'like' | 'not' | 'is null' | 'is not null' ) id3= ( Identifier | Number ) )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:211:4: 'WHERE' id1= Identifier id2= ( '>' | '<' | '=' | 'like' | 'not' | 'is null' | 'is not null' ) id3= ( Identifier | Number )
			{
			match(input,51,FOLLOW_51_in_whereStatementUpdate632); 
			id1=(Token)match(input,Identifier,FOLLOW_Identifier_in_whereStatementUpdate636); 
			id2=input.LT(1);
			if ( (input.LA(1) >= 18 && input.LA(1) <= 20)||(input.LA(1) >= 52 && input.LA(1) <= 55) ) {
				input.consume();
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			id3=input.LT(1);
			if ( input.LA(1)==Identifier||input.LA(1)==Number ) {
				input.consume();
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}

				ColumnsUpdate.add((id1!=null?id1.getText():null));
				ColumnsUpdate.add((id2!=null?id2.getText():null));
				ColumnsUpdate.add((id3!=null?id3.getText():null));
				
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
	// $ANTLR end "whereStatementUpdate"



	// $ANTLR start "whereStatementDelete"
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:218:1: whereStatementDelete : 'WHERE' id1= Identifier id2= ( '>' | '<' | '=' | 'like' | 'not' | 'is null' | 'is not null' ) id3= ( Identifier | Number ) ;
	public final void whereStatementDelete() throws RecognitionException {
		Token id1=null;
		Token id2=null;
		Token id3=null;

		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:219:2: ( 'WHERE' id1= Identifier id2= ( '>' | '<' | '=' | 'like' | 'not' | 'is null' | 'is not null' ) id3= ( Identifier | Number ) )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:219:4: 'WHERE' id1= Identifier id2= ( '>' | '<' | '=' | 'like' | 'not' | 'is null' | 'is not null' ) id3= ( Identifier | Number )
			{
			match(input,51,FOLLOW_51_in_whereStatementDelete688); 
			id1=(Token)match(input,Identifier,FOLLOW_Identifier_in_whereStatementDelete692); 
			id2=input.LT(1);
			if ( (input.LA(1) >= 18 && input.LA(1) <= 20)||(input.LA(1) >= 52 && input.LA(1) <= 55) ) {
				input.consume();
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			id3=input.LT(1);
			if ( input.LA(1)==Identifier||input.LA(1)==Number ) {
				input.consume();
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}

				ColumnsDelete.add((id1!=null?id1.getText():null));
				ColumnsDelete.add((id2!=null?id2.getText():null));
				ColumnsDelete.add((id3!=null?id3.getText():null));
				
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
	// $ANTLR end "whereStatementDelete"



	// $ANTLR start "joinStatement"
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:226:1: joinStatement : 'JOIN' id1= Identifier 'ON' id2= Identifier '.' id3= Identifier '=' id4= Identifier '.' id5= Identifier ;
	public final void joinStatement() throws RecognitionException {
		Token id1=null;
		Token id2=null;
		Token id3=null;
		Token id4=null;
		Token id5=null;

		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:227:2: ( 'JOIN' id1= Identifier 'ON' id2= Identifier '.' id3= Identifier '=' id4= Identifier '.' id5= Identifier )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:227:4: 'JOIN' id1= Identifier 'ON' id2= Identifier '.' id3= Identifier '=' id4= Identifier '.' id5= Identifier
			{
			match(input,39,FOLLOW_39_in_joinStatement743); 
			id1=(Token)match(input,Identifier,FOLLOW_Identifier_in_joinStatement747); 
			match(input,41,FOLLOW_41_in_joinStatement749); 
			id2=(Token)match(input,Identifier,FOLLOW_Identifier_in_joinStatement753); 
			match(input,16,FOLLOW_16_in_joinStatement755); 
			id3=(Token)match(input,Identifier,FOLLOW_Identifier_in_joinStatement759); 
			match(input,19,FOLLOW_19_in_joinStatement761); 
			id4=(Token)match(input,Identifier,FOLLOW_Identifier_in_joinStatement765); 
			match(input,16,FOLLOW_16_in_joinStatement767); 
			id5=(Token)match(input,Identifier,FOLLOW_Identifier_in_joinStatement771); 

					
					ColumnsSelect.add("Join");
					ColumnsSelect.add((id1!=null?id1.getText():null));
					ColumnsSelect.add((id2!=null?id2.getText():null));
					ColumnsSelect.add((id3!=null?id3.getText():null));
					ColumnsSelect.add((id4!=null?id4.getText():null));
					ColumnsSelect.add((id5!=null?id5.getText():null));
					ColumnsSelect.add("Join Finish");



					
					
				
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
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:249:1: constraintDefinition : 'FOREIGN KEY' '(' id1= Identifier ')' 'REFERENCES' id2= Identifier '(' id3= Identifier ')' ;
	public final void constraintDefinition() throws RecognitionException {
		Token id1=null;
		Token id2=null;
		Token id3=null;

		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:250:2: ( 'FOREIGN KEY' '(' id1= Identifier ')' 'REFERENCES' id2= Identifier '(' id3= Identifier ')' )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:250:4: 'FOREIGN KEY' '(' id1= Identifier ')' 'REFERENCES' id2= Identifier '(' id3= Identifier ')'
			{
			match(input,34,FOLLOW_34_in_constraintDefinition837); 
			match(input,12,FOLLOW_12_in_constraintDefinition839); 
			id1=(Token)match(input,Identifier,FOLLOW_Identifier_in_constraintDefinition843); 
			match(input,13,FOLLOW_13_in_constraintDefinition845); 
			match(input,43,FOLLOW_43_in_constraintDefinition847); 
			id2=(Token)match(input,Identifier,FOLLOW_Identifier_in_constraintDefinition851); 
			match(input,12,FOLLOW_12_in_constraintDefinition853); 
			id3=(Token)match(input,Identifier,FOLLOW_Identifier_in_constraintDefinition857); 
			match(input,13,FOLLOW_13_in_constraintDefinition859); 

					ColumnsAlterTable.add((id1!=null?id1.getText():null));
					ColumnsAlterTable.add((id2!=null?id2.getText():null));
					ColumnsAlterTable.add((id3!=null?id3.getText():null));


					
				
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
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:260:1: columnDefinition : Identifier Type Nullability ;
	public final void columnDefinition() throws RecognitionException {
		Token Identifier8=null;
		Token Type9=null;
		Token Nullability10=null;

		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:261:2: ( Identifier Type Nullability )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:261:4: Identifier Type Nullability
			{
			Identifier8=(Token)match(input,Identifier,FOLLOW_Identifier_in_columnDefinition873); 
			Type9=(Token)match(input,Type,FOLLOW_Type_in_columnDefinition875); 
			Nullability10=(Token)match(input,Nullability,FOLLOW_Nullability_in_columnDefinition877); 

				ColumnsCreateTable.add("Column Definition");
				ColumnsCreateTable.add((Identifier8!=null?Identifier8.getText():null));
				ColumnsCreateTable.add((Type9!=null?Type9.getText():null));
				ColumnsCreateTable.add((Nullability10!=null?Nullability10.getText():null));

				
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
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:285:1: primaryKey : 'PRIMARY KEY(' Identifier ')' ;
	public final void primaryKey() throws RecognitionException {
		Token Identifier11=null;

		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:286:2: ( 'PRIMARY KEY(' Identifier ')' )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:286:4: 'PRIMARY KEY(' Identifier ')'
			{
			match(input,42,FOLLOW_42_in_primaryKey948); 
			Identifier11=(Token)match(input,Identifier,FOLLOW_Identifier_in_primaryKey950); 
			match(input,13,FOLLOW_13_in_primaryKey952); 

					ColumnsCreateTable.add((Identifier11!=null?Identifier11.getText():null));
					
				
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



	public static final BitSet FOLLOW_script_in_query25 = new BitSet(new long[]{0x0002F120FE400002L});
	public static final BitSet FOLLOW_createDB_in_script36 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_dropDB_in_script40 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_listDB_in_script44 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_startDB_in_script47 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_stopDB_in_script53 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_displayDB_in_script57 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_setDB_in_script61 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_createTable_in_script65 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_alterTable_in_script70 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_dropTable_in_script74 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_createIndex_in_script77 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_selectStatement_in_script80 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_updateStatement_in_script84 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_delete_in_script89 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_insertInto_in_script93 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_25_in_createDB106 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_createDB108 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_30_in_dropDB122 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_dropDB124 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_40_in_listDB139 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_46_in_startDB149 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_47_in_stopDB160 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_29_in_displayDB171 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_displayDB173 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_45_in_setDB187 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_setDB191 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_27_in_createTable203 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_createTable205 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_23_in_createTable207 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_12_in_createTable209 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_columnDefinition_in_createTable211 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_15_in_createTable216 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_columnDefinition_in_createTable219 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_15_in_createTable224 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_primaryKey_in_createTable227 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_createTable229 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_22_in_alterTable243 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_alterTable245 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_21_in_alterTable248 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_24_in_alterTable250 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_constraintDefinition_in_alterTable252 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_31_in_dropTable263 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_dropTable265 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_17_in_dropTable267 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_26_in_createIndex277 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_createIndex281 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_41_in_createIndex283 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_createIndex287 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_12_in_createIndex289 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_createIndex292 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_createIndex294 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_44_in_selectStatement311 = new BitSet(new long[]{0x0000000000004040L});
	public static final BitSet FOLLOW_14_in_selectStatement316 = new BitSet(new long[]{0x0000000000004040L});
	public static final BitSet FOLLOW_Identifier_in_selectStatement323 = new BitSet(new long[]{0x0000000800018010L});
	public static final BitSet FOLLOW_16_in_selectStatement326 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_selectStatement330 = new BitSet(new long[]{0x0000000800018010L});
	public static final BitSet FOLLOW_15_in_selectStatement338 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_selectStatement342 = new BitSet(new long[]{0x0000000800018010L});
	public static final BitSet FOLLOW_16_in_selectStatement345 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_selectStatement349 = new BitSet(new long[]{0x0000000800018010L});
	public static final BitSet FOLLOW_15_in_selectStatement362 = new BitSet(new long[]{0x0000000800008010L});
	public static final BitSet FOLLOW_AggregateFunctions_in_selectStatement370 = new BitSet(new long[]{0x0000000800000010L});
	public static final BitSet FOLLOW_35_in_selectStatement375 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_selectStatement379 = new BitSet(new long[]{0x0008009300000002L});
	public static final BitSet FOLLOW_joinStatement_in_selectStatement382 = new BitSet(new long[]{0x0008009300000002L});
	public static final BitSet FOLLOW_whereStatement_in_selectStatement389 = new BitSet(new long[]{0x0008001300000002L});
	public static final BitSet FOLLOW_36_in_selectStatement394 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_selectStatement398 = new BitSet(new long[]{0x0000001300000002L});
	public static final BitSet FOLLOW_49_in_updateStatement439 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_updateStatement443 = new BitSet(new long[]{0x0001000000000000L});
	public static final BitSet FOLLOW_48_in_updateStatement446 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_updateStatement450 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_19_in_updateStatement453 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_updateStatement459 = new BitSet(new long[]{0x0008000000000002L});
	public static final BitSet FOLLOW_whereStatementUpdate_in_updateStatement468 = new BitSet(new long[]{0x0008000000000002L});
	public static final BitSet FOLLOW_28_in_delete485 = new BitSet(new long[]{0x0000000800000000L});
	public static final BitSet FOLLOW_35_in_delete487 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_delete489 = new BitSet(new long[]{0x0008000000000002L});
	public static final BitSet FOLLOW_whereStatementDelete_in_delete493 = new BitSet(new long[]{0x0008000000000002L});
	public static final BitSet FOLLOW_37_in_insertInto508 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_38_in_insertInto510 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_insertInto514 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_12_in_insertInto517 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_insertInto521 = new BitSet(new long[]{0x000000000000A000L});
	public static final BitSet FOLLOW_15_in_insertInto526 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_insertInto530 = new BitSet(new long[]{0x000000000000A000L});
	public static final BitSet FOLLOW_13_in_insertInto537 = new BitSet(new long[]{0x0004000000000000L});
	public static final BitSet FOLLOW_50_in_insertInto539 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_12_in_insertInto541 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_insertInto545 = new BitSet(new long[]{0x000000000000A000L});
	public static final BitSet FOLLOW_15_in_insertInto552 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_insertInto556 = new BitSet(new long[]{0x000000000000A000L});
	public static final BitSet FOLLOW_13_in_insertInto562 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_51_in_whereStatement584 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_whereStatement586 = new BitSet(new long[]{0x00F00000001C0000L});
	public static final BitSet FOLLOW_set_in_whereStatement590 = new BitSet(new long[]{0x0000000000000240L});
	public static final BitSet FOLLOW_set_in_whereStatement616 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_51_in_whereStatementUpdate632 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_whereStatementUpdate636 = new BitSet(new long[]{0x00F00000001C0000L});
	public static final BitSet FOLLOW_set_in_whereStatementUpdate640 = new BitSet(new long[]{0x0000000000000240L});
	public static final BitSet FOLLOW_set_in_whereStatementUpdate668 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_51_in_whereStatementDelete688 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_whereStatementDelete692 = new BitSet(new long[]{0x00F00000001C0000L});
	public static final BitSet FOLLOW_set_in_whereStatementDelete696 = new BitSet(new long[]{0x0000000000000240L});
	public static final BitSet FOLLOW_set_in_whereStatementDelete724 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_39_in_joinStatement743 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_joinStatement747 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_41_in_joinStatement749 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_joinStatement753 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_joinStatement755 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_joinStatement759 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_19_in_joinStatement761 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_joinStatement765 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_joinStatement767 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_joinStatement771 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_34_in_constraintDefinition837 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_12_in_constraintDefinition839 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_constraintDefinition843 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_constraintDefinition845 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_43_in_constraintDefinition847 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_constraintDefinition851 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_12_in_constraintDefinition853 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_constraintDefinition857 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_constraintDefinition859 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Identifier_in_columnDefinition873 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_Type_in_columnDefinition875 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_Nullability_in_columnDefinition877 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_42_in_primaryKey948 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_primaryKey950 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_primaryKey952 = new BitSet(new long[]{0x0000000000000002L});
}
