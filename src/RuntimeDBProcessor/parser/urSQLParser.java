// $ANTLR 3.5.1 /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g 2015-09-24 19:53:31

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
		"Identifier", "LETTER", "LogicToken", "Nullability", "Number", "Type", 
		"WS", "'('", "')'", "'*'", "','", "'.'", "'<'", "'='", "'>'", "'ADD'", 
		"'ALTER TABLE'", "'AS'", "'CONSTRAINT'", "'CREATE DATABASE'", "'CREATE INDEX'", 
		"'CREATE TABLE'", "'DELETE'", "'DISPLAY DATABASE'", "'DROP DATABASE'", 
		"'DROP TABLE'", "'FOR JSON'", "'FOR XML'", "'FOREIGN KEY'", "'FROM'", 
		"'GROUP BY'", "'INSERT'", "'INTO'", "'JOIN'", "'LIST DATABASES'", "'ON'", 
		"'PRIMARY KEY('", "'REFERENCES'", "'SELECT'", "'SET DATABASE'", "'START'", 
		"'STOP'", "'Set'", "'UPDATE'", "'VALUES'", "'WHERE'", "'is not null'", 
		"'is null'", "'like'", "'not'"
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
	public static final int T__52=52;
	public static final int T__53=53;
	public static final int T__54=54;
	public static final int T__55=55;
	public static final int AggregateFunctions=4;
	public static final int DIGIT=5;
	public static final int Identifier=6;
	public static final int LETTER=7;
	public static final int LogicToken=8;
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
		public ArrayList<String> ColumnsCreateTable = new ArrayList<String>();
		public ArrayList<String> ColumnsAlterTable = new ArrayList<String>();
		
		public ArrayList<String> ColumnsCreateIndex = new ArrayList<String>();
		
		public ArrayList<String> ColumnsUpdate = new ArrayList<String>();
		
		public ArrayList<String> ColumnsDelete = new ArrayList<String>();
		
		Boolean InError=false;
		
		

		RuntimeDB mainRuntime= new RuntimeDB();
		
		
	    	public void displayRecognitionError(String[] tokenNames,
	                                        RecognitionException e) {
	        	String hdr = getErrorHeader(e);
	        	String msg = getErrorMessage(e, tokenNames);
	        	//System.out.println("Query malo"+msg);
	        	mainRuntime.reportedError(msg);
	        	InError=true; 
	        	//900 PARA LEXICO
	        	//901 PARA SINTACTICO
	        	
	    }
	    
	    



	// $ANTLR start "query"
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:45:1: query : ( script )* ;
	public final void query() throws RecognitionException {
		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:45:7: ( ( script )* )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:46:2: ( script )*
			{
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:46:2: ( script )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==22||(LA1_0 >= 25 && LA1_0 <= 31)||LA1_0==37||LA1_0==40||(LA1_0 >= 44 && LA1_0 <= 47)||LA1_0==49) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:46:2: script
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
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:48:1: script : ( createDB | dropDB | listDB | startDB | stopDB | displayDB | setDB | createTable | alterTable | dropTable | createIndex | selectStatement | updateStatement | delete | insertInto );
	public final void script() throws RecognitionException {
		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:48:8: ( createDB | dropDB | listDB | startDB | stopDB | displayDB | setDB | createTable | alterTable | dropTable | createIndex | selectStatement | updateStatement | delete | insertInto )
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
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:49:2: createDB
					{
					pushFollow(FOLLOW_createDB_in_script36);
					createDB();
					state._fsp--;

					}
					break;
				case 2 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:49:13: dropDB
					{
					pushFollow(FOLLOW_dropDB_in_script40);
					dropDB();
					state._fsp--;

					}
					break;
				case 3 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:49:22: listDB
					{
					pushFollow(FOLLOW_listDB_in_script44);
					listDB();
					state._fsp--;

					}
					break;
				case 4 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:49:30: startDB
					{
					pushFollow(FOLLOW_startDB_in_script47);
					startDB();
					state._fsp--;

					}
					break;
				case 5 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:49:42: stopDB
					{
					pushFollow(FOLLOW_stopDB_in_script53);
					stopDB();
					state._fsp--;

					}
					break;
				case 6 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:49:51: displayDB
					{
					pushFollow(FOLLOW_displayDB_in_script57);
					displayDB();
					state._fsp--;

					}
					break;
				case 7 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:49:63: setDB
					{
					pushFollow(FOLLOW_setDB_in_script61);
					setDB();
					state._fsp--;

					}
					break;
				case 8 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:49:71: createTable
					{
					pushFollow(FOLLOW_createTable_in_script65);
					createTable();
					state._fsp--;

					}
					break;
				case 9 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:50:3: alterTable
					{
					pushFollow(FOLLOW_alterTable_in_script70);
					alterTable();
					state._fsp--;

					}
					break;
				case 10 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:50:16: dropTable
					{
					pushFollow(FOLLOW_dropTable_in_script74);
					dropTable();
					state._fsp--;

					}
					break;
				case 11 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:50:27: createIndex
					{
					pushFollow(FOLLOW_createIndex_in_script77);
					createIndex();
					state._fsp--;

					}
					break;
				case 12 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:50:40: selectStatement
					{
					pushFollow(FOLLOW_selectStatement_in_script80);
					selectStatement();
					state._fsp--;

					}
					break;
				case 13 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:50:58: updateStatement
					{
					pushFollow(FOLLOW_updateStatement_in_script84);
					updateStatement();
					state._fsp--;

					}
					break;
				case 14 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:50:77: delete
					{
					pushFollow(FOLLOW_delete_in_script89);
					delete();
					state._fsp--;

					}
					break;
				case 15 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:50:86: insertInto
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
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:55:1: createDB : 'CREATE DATABASE' Identifier ;
	public final void createDB() throws RecognitionException {
		Token Identifier1=null;

		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:56:2: ( 'CREATE DATABASE' Identifier )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:56:4: 'CREATE DATABASE' Identifier
			{
			match(input,25,FOLLOW_25_in_createDB106); 
			Identifier1=(Token)match(input,Identifier,FOLLOW_Identifier_in_createDB108); 

				if(InError==false){
					mainRuntime.CreateDB((Identifier1!=null?Identifier1.getText():null));	
				}
				
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
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:66:1: dropDB : 'DROP DATABASE' Identifier ;
	public final void dropDB() throws RecognitionException {
		Token Identifier2=null;

		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:67:2: ( 'DROP DATABASE' Identifier )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:67:4: 'DROP DATABASE' Identifier
			{
			match(input,30,FOLLOW_30_in_dropDB122); 
			Identifier2=(Token)match(input,Identifier,FOLLOW_Identifier_in_dropDB124); 
				
				
					if(InError==false){
						mainRuntime.DropDB((Identifier2!=null?Identifier2.getText():null));
					}
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
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:78:1: listDB : 'LIST DATABASES' ;
	public final void listDB() throws RecognitionException {
		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:78:8: ( 'LIST DATABASES' )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:78:10: 'LIST DATABASES'
			{
			match(input,40,FOLLOW_40_in_listDB143); 

					if(InError==false){
						mainRuntime.ListDB();

						
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
	// $ANTLR end "listDB"



	// $ANTLR start "startDB"
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:87:1: startDB : 'START' ;
	public final void startDB() throws RecognitionException {
		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:87:9: ( 'START' )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:87:11: 'START'
			{
			match(input,46,FOLLOW_46_in_startDB153); 
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
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:91:1: stopDB : 'STOP' ;
	public final void stopDB() throws RecognitionException {
		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:91:8: ( 'STOP' )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:91:10: 'STOP'
			{
			match(input,47,FOLLOW_47_in_stopDB164); 
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
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:93:1: displayDB : 'DISPLAY DATABASE' Identifier ;
	public final void displayDB() throws RecognitionException {
		Token Identifier3=null;

		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:94:2: ( 'DISPLAY DATABASE' Identifier )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:94:4: 'DISPLAY DATABASE' Identifier
			{
			match(input,29,FOLLOW_29_in_displayDB175); 
			Identifier3=(Token)match(input,Identifier,FOLLOW_Identifier_in_displayDB177); 

						if(InError==false){
							mainRuntime.DisplayDB((Identifier3!=null?Identifier3.getText():null));
							
						}
						
						

						
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
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:107:1: setDB : 'SET DATABASE' id1= Identifier ;
	public final void setDB() throws RecognitionException {
		Token id1=null;

		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:108:2: ( 'SET DATABASE' id1= Identifier )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:108:4: 'SET DATABASE' id1= Identifier
			{
			match(input,45,FOLLOW_45_in_setDB191); 
			id1=(Token)match(input,Identifier,FOLLOW_Identifier_in_setDB195); 

					if(InError==false){
						mainRuntime.setDB((id1!=null?id1.getText():null));		
					}
					

						
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
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:118:1: createTable : 'CREATE TABLE' Identifier 'AS' '(' columnDefinition ( ',' columnDefinition )* ',' primaryKey ')' ;
	public final void createTable() throws RecognitionException {
		Token Identifier4=null;

		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:119:2: ( 'CREATE TABLE' Identifier 'AS' '(' columnDefinition ( ',' columnDefinition )* ',' primaryKey ')' )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:119:4: 'CREATE TABLE' Identifier 'AS' '(' columnDefinition ( ',' columnDefinition )* ',' primaryKey ')'
			{
			match(input,27,FOLLOW_27_in_createTable207); 
			Identifier4=(Token)match(input,Identifier,FOLLOW_Identifier_in_createTable209); 
			ColumnsCreateTable.add((Identifier4!=null?Identifier4.getText():null));
			match(input,23,FOLLOW_23_in_createTable211); 
			match(input,13,FOLLOW_13_in_createTable213); 
			pushFollow(FOLLOW_columnDefinition_in_createTable215);
			columnDefinition();
			state._fsp--;

			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:119:100: ( ',' columnDefinition )*
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( (LA3_0==16) ) {
					int LA3_1 = input.LA(2);
					if ( (LA3_1==Identifier) ) {
						alt3=1;
					}

				}

				switch (alt3) {
				case 1 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:119:101: ',' columnDefinition
					{
					match(input,16,FOLLOW_16_in_createTable220); 
					pushFollow(FOLLOW_columnDefinition_in_createTable223);
					columnDefinition();
					state._fsp--;

					}
					break;

				default :
					break loop3;
				}
			}

			match(input,16,FOLLOW_16_in_createTable228); 
			pushFollow(FOLLOW_primaryKey_in_createTable231);
			primaryKey();
			state._fsp--;

			match(input,14,FOLLOW_14_in_createTable233); 

					if(InError==false){
						mainRuntime.createTable(ColumnsCreateTable);
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
	// $ANTLR end "createTable"



	// $ANTLR start "alterTable"
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:130:1: alterTable : 'ALTER TABLE' Identifier 'ADD' 'CONSTRAINT' constraintDefinition ;
	public final void alterTable() throws RecognitionException {
		Token Identifier5=null;

		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:131:2: ( 'ALTER TABLE' Identifier 'ADD' 'CONSTRAINT' constraintDefinition )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:131:4: 'ALTER TABLE' Identifier 'ADD' 'CONSTRAINT' constraintDefinition
			{
			match(input,22,FOLLOW_22_in_alterTable247); 
			Identifier5=(Token)match(input,Identifier,FOLLOW_Identifier_in_alterTable249); 
			ColumnsAlterTable.add((Identifier5!=null?Identifier5.getText():null));
			match(input,21,FOLLOW_21_in_alterTable252); 
			match(input,24,FOLLOW_24_in_alterTable254); 
			pushFollow(FOLLOW_constraintDefinition_in_alterTable256);
			constraintDefinition();
			state._fsp--;


					if(InError==false){
						mainRuntime.alterTable(ColumnsAlterTable);
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
	// $ANTLR end "alterTable"



	// $ANTLR start "dropTable"
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:139:1: dropTable : 'DROP TABLE' Identifier ;
	public final void dropTable() throws RecognitionException {
		Token Identifier6=null;

		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:140:2: ( 'DROP TABLE' Identifier )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:140:4: 'DROP TABLE' Identifier
			{
			match(input,31,FOLLOW_31_in_dropTable267); 
			Identifier6=(Token)match(input,Identifier,FOLLOW_Identifier_in_dropTable269); 

					if(InError==false){
						mainRuntime.dropTable((Identifier6!=null?Identifier6.getText():null));
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
	// $ANTLR end "dropTable"



	// $ANTLR start "createIndex"
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:151:1: createIndex : 'CREATE INDEX' id1= Identifier 'ON' id2= Identifier '(' id3= Identifier ')' ;
	public final void createIndex() throws RecognitionException {
		Token id1=null;
		Token id2=null;
		Token id3=null;

		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:152:2: ( 'CREATE INDEX' id1= Identifier 'ON' id2= Identifier '(' id3= Identifier ')' )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:152:4: 'CREATE INDEX' id1= Identifier 'ON' id2= Identifier '(' id3= Identifier ')'
			{
			match(input,26,FOLLOW_26_in_createIndex286); 
			id1=(Token)match(input,Identifier,FOLLOW_Identifier_in_createIndex290); 
			match(input,41,FOLLOW_41_in_createIndex292); 
			id2=(Token)match(input,Identifier,FOLLOW_Identifier_in_createIndex296); 
			match(input,13,FOLLOW_13_in_createIndex298); 
			id3=(Token)match(input,Identifier,FOLLOW_Identifier_in_createIndex301); 
			match(input,14,FOLLOW_14_in_createIndex303); 

					
					ColumnsCreateIndex.add((id1!=null?id1.getText():null));
					ColumnsCreateIndex.add((id2!=null?id2.getText():null));
					
					ColumnsCreateIndex.add((id3!=null?id3.getText():null));

					
					if(InError==false){
						mainRuntime.createIndex(ColumnsCreateIndex);
					}
					
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
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:177:1: selectStatement : 'SELECT' id1= ( '*' )* (id2= Identifier ( '.' id3= Identifier )* )* ( ',' id4= Identifier ( '.' id5= Identifier )* )* ( ',' )* (Ag= AggregateFunctions )* 'FROM' fromId= Identifier ( joinStatement )* ( ( whereStatement ) (logic= LogicToken whereStatementAUX )* )* ( 'GROUP BY' id6= Identifier )* ( 'FOR JSON' | 'FOR XML' )* ;
	public final void selectStatement() throws RecognitionException {
		Token id1=null;
		Token id2=null;
		Token id3=null;
		Token id4=null;
		Token id5=null;
		Token Ag=null;
		Token fromId=null;
		Token logic=null;
		Token id6=null;

		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:177:17: ( 'SELECT' id1= ( '*' )* (id2= Identifier ( '.' id3= Identifier )* )* ( ',' id4= Identifier ( '.' id5= Identifier )* )* ( ',' )* (Ag= AggregateFunctions )* 'FROM' fromId= Identifier ( joinStatement )* ( ( whereStatement ) (logic= LogicToken whereStatementAUX )* )* ( 'GROUP BY' id6= Identifier )* ( 'FOR JSON' | 'FOR XML' )* )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:178:3: 'SELECT' id1= ( '*' )* (id2= Identifier ( '.' id3= Identifier )* )* ( ',' id4= Identifier ( '.' id5= Identifier )* )* ( ',' )* (Ag= AggregateFunctions )* 'FROM' fromId= Identifier ( joinStatement )* ( ( whereStatement ) (logic= LogicToken whereStatementAUX )* )* ( 'GROUP BY' id6= Identifier )* ( 'FOR JSON' | 'FOR XML' )*
			{
			match(input,44,FOLLOW_44_in_selectStatement320); 
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:178:16: ( '*' )*
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( (LA4_0==15) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:178:17: '*'
					{
					id1=(Token)match(input,15,FOLLOW_15_in_selectStatement325); 
					}
					break;

				default :
					break loop4;
				}
			}

			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:178:24: (id2= Identifier ( '.' id3= Identifier )* )*
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( (LA6_0==Identifier) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:178:26: id2= Identifier ( '.' id3= Identifier )*
					{
					id2=(Token)match(input,Identifier,FOLLOW_Identifier_in_selectStatement334); 
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:178:41: ( '.' id3= Identifier )*
					loop5:
					while (true) {
						int alt5=2;
						int LA5_0 = input.LA(1);
						if ( (LA5_0==17) ) {
							alt5=1;
						}

						switch (alt5) {
						case 1 :
							// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:178:42: '.' id3= Identifier
							{
							match(input,17,FOLLOW_17_in_selectStatement337); 
							id3=(Token)match(input,Identifier,FOLLOW_Identifier_in_selectStatement341); 
							}
							break;

						default :
							break loop5;
						}
					}

					}
					break;

				default :
					break loop6;
				}
			}

			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:178:68: ( ',' id4= Identifier ( '.' id5= Identifier )* )*
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( (LA8_0==16) ) {
					int LA8_1 = input.LA(2);
					if ( (LA8_1==Identifier) ) {
						alt8=1;
					}

				}

				switch (alt8) {
				case 1 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:178:69: ',' id4= Identifier ( '.' id5= Identifier )*
					{
					match(input,16,FOLLOW_16_in_selectStatement351); 
					id4=(Token)match(input,Identifier,FOLLOW_Identifier_in_selectStatement355); 
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:178:88: ( '.' id5= Identifier )*
					loop7:
					while (true) {
						int alt7=2;
						int LA7_0 = input.LA(1);
						if ( (LA7_0==17) ) {
							alt7=1;
						}

						switch (alt7) {
						case 1 :
							// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:178:89: '.' id5= Identifier
							{
							match(input,17,FOLLOW_17_in_selectStatement358); 
							id5=(Token)match(input,Identifier,FOLLOW_Identifier_in_selectStatement362); 
							}
							break;

						default :
							break loop7;
						}
					}

					}
					break;

				default :
					break loop8;
				}
			}

			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:178:118: ( ',' )*
			loop9:
			while (true) {
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( (LA9_0==16) ) {
					alt9=1;
				}

				switch (alt9) {
				case 1 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:178:119: ','
					{
					match(input,16,FOLLOW_16_in_selectStatement375); 
					}
					break;

				default :
					break loop9;
				}
			}

			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:178:126: (Ag= AggregateFunctions )*
			loop10:
			while (true) {
				int alt10=2;
				int LA10_0 = input.LA(1);
				if ( (LA10_0==AggregateFunctions) ) {
					alt10=1;
				}

				switch (alt10) {
				case 1 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:178:127: Ag= AggregateFunctions
					{
					Ag=(Token)match(input,AggregateFunctions,FOLLOW_AggregateFunctions_in_selectStatement383); 
					}
					break;

				default :
					break loop10;
				}
			}

			match(input,35,FOLLOW_35_in_selectStatement388); 
			fromId=(Token)match(input,Identifier,FOLLOW_Identifier_in_selectStatement392); 
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:178:177: ( joinStatement )*
			loop11:
			while (true) {
				int alt11=2;
				int LA11_0 = input.LA(1);
				if ( (LA11_0==39) ) {
					alt11=1;
				}

				switch (alt11) {
				case 1 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:178:178: joinStatement
					{
					pushFollow(FOLLOW_joinStatement_in_selectStatement395);
					joinStatement();
					state._fsp--;

					}
					break;

				default :
					break loop11;
				}
			}

			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:179:3: ( ( whereStatement ) (logic= LogicToken whereStatementAUX )* )*
			loop13:
			while (true) {
				int alt13=2;
				int LA13_0 = input.LA(1);
				if ( (LA13_0==51) ) {
					alt13=1;
				}

				switch (alt13) {
				case 1 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:179:5: ( whereStatement ) (logic= LogicToken whereStatementAUX )*
					{
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:179:5: ( whereStatement )
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:179:6: whereStatement
					{
					pushFollow(FOLLOW_whereStatement_in_selectStatement404);
					whereStatement();
					state._fsp--;

					}

					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:179:23: (logic= LogicToken whereStatementAUX )*
					loop12:
					while (true) {
						int alt12=2;
						int LA12_0 = input.LA(1);
						if ( (LA12_0==LogicToken) ) {
							alt12=1;
						}

						switch (alt12) {
						case 1 :
							// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:179:25: logic= LogicToken whereStatementAUX
							{
							logic=(Token)match(input,LogicToken,FOLLOW_LogicToken_in_selectStatement412); 
							 ColumnsSelect.add((logic!=null?logic.getText():null));   
							pushFollow(FOLLOW_whereStatementAUX_in_selectStatement416);
							whereStatementAUX();
							state._fsp--;

							}
							break;

						default :
							break loop12;
						}
					}

					}
					break;

				default :
					break loop13;
				}
			}

			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:179:107: ( 'GROUP BY' id6= Identifier )*
			loop14:
			while (true) {
				int alt14=2;
				int LA14_0 = input.LA(1);
				if ( (LA14_0==36) ) {
					alt14=1;
				}

				switch (alt14) {
				case 1 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:179:108: 'GROUP BY' id6= Identifier
					{
					match(input,36,FOLLOW_36_in_selectStatement428); 
					id6=(Token)match(input,Identifier,FOLLOW_Identifier_in_selectStatement432); 
					}
					break;

				default :
					break loop14;
				}
			}

			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:179:136: ( 'FOR JSON' | 'FOR XML' )*
			loop15:
			while (true) {
				int alt15=2;
				int LA15_0 = input.LA(1);
				if ( ((LA15_0 >= 32 && LA15_0 <= 33)) ) {
					alt15=1;
				}

				switch (alt15) {
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
					break loop15;
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
						if(InError==false){
						mainRuntime.select(ColumnsSelect);
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
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:224:1: updateStatement : 'UPDATE' id1= Identifier 'Set' id2= Identifier '=' id3= Identifier ( whereStatementUpdate )* (id4= ( LogicToken ) ( whereStatementUpdateDuplicate ) )* ;
	public final void updateStatement() throws RecognitionException {
		Token id1=null;
		Token id2=null;
		Token id3=null;
		Token id4=null;

		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:225:2: ( 'UPDATE' id1= Identifier 'Set' id2= Identifier '=' id3= Identifier ( whereStatementUpdate )* (id4= ( LogicToken ) ( whereStatementUpdateDuplicate ) )* )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:225:4: 'UPDATE' id1= Identifier 'Set' id2= Identifier '=' id3= Identifier ( whereStatementUpdate )* (id4= ( LogicToken ) ( whereStatementUpdateDuplicate ) )*
			{
			match(input,49,FOLLOW_49_in_updateStatement473); 
			id1=(Token)match(input,Identifier,FOLLOW_Identifier_in_updateStatement477); 
			ColumnsUpdate.add((id1!=null?id1.getText():null));
			match(input,48,FOLLOW_48_in_updateStatement480); 
			id2=(Token)match(input,Identifier,FOLLOW_Identifier_in_updateStatement484); 
			ColumnsUpdate.add((id2!=null?id2.getText():null));
			match(input,19,FOLLOW_19_in_updateStatement487); 
			id3=(Token)match(input,Identifier,FOLLOW_Identifier_in_updateStatement493); 
			ColumnsUpdate.add((id3!=null?id3.getText():null));
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:227:5: ( whereStatementUpdate )*
			loop16:
			while (true) {
				int alt16=2;
				int LA16_0 = input.LA(1);
				if ( (LA16_0==51) ) {
					alt16=1;
				}

				switch (alt16) {
				case 1 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:227:6: whereStatementUpdate
					{
					pushFollow(FOLLOW_whereStatementUpdate_in_updateStatement502);
					whereStatementUpdate();
					state._fsp--;

					}
					break;

				default :
					break loop16;
				}
			}

			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:227:29: (id4= ( LogicToken ) ( whereStatementUpdateDuplicate ) )*
			loop17:
			while (true) {
				int alt17=2;
				int LA17_0 = input.LA(1);
				if ( (LA17_0==LogicToken) ) {
					alt17=1;
				}

				switch (alt17) {
				case 1 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:227:31: id4= ( LogicToken ) ( whereStatementUpdateDuplicate )
					{
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:227:35: ( LogicToken )
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:227:36: LogicToken
					{
					id4=(Token)match(input,LogicToken,FOLLOW_LogicToken_in_updateStatement511); 
					}

					  ColumnsUpdate.add((id4!=null?id4.getText():null)); 
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:227:82: ( whereStatementUpdateDuplicate )
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:227:83: whereStatementUpdateDuplicate
					{
					pushFollow(FOLLOW_whereStatementUpdateDuplicate_in_updateStatement516);
					whereStatementUpdateDuplicate();
					state._fsp--;

					}

					}
					break;

				default :
					break loop17;
				}
			}


					
					if(InError==false){
						mainRuntime.update(ColumnsUpdate);	
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
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:237:1: delete : 'DELETE' 'FROM' Identifier ( whereStatementDelete )* (id1= ( LogicToken ) ( whereStatementDeleteDuplicate ) )* ;
	public final void delete() throws RecognitionException {
		Token id1=null;
		Token Identifier7=null;

		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:237:8: ( 'DELETE' 'FROM' Identifier ( whereStatementDelete )* (id1= ( LogicToken ) ( whereStatementDeleteDuplicate ) )* )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:238:3: 'DELETE' 'FROM' Identifier ( whereStatementDelete )* (id1= ( LogicToken ) ( whereStatementDeleteDuplicate ) )*
			{
			match(input,28,FOLLOW_28_in_delete543); 
			match(input,35,FOLLOW_35_in_delete545); 
			Identifier7=(Token)match(input,Identifier,FOLLOW_Identifier_in_delete547); 
			ColumnsDelete.add((Identifier7!=null?Identifier7.getText():null));
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:238:68: ( whereStatementDelete )*
			loop18:
			while (true) {
				int alt18=2;
				int LA18_0 = input.LA(1);
				if ( (LA18_0==51) ) {
					alt18=1;
				}

				switch (alt18) {
				case 1 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:238:69: whereStatementDelete
					{
					pushFollow(FOLLOW_whereStatementDelete_in_delete551);
					whereStatementDelete();
					state._fsp--;

					}
					break;

				default :
					break loop18;
				}
			}

			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:238:93: (id1= ( LogicToken ) ( whereStatementDeleteDuplicate ) )*
			loop19:
			while (true) {
				int alt19=2;
				int LA19_0 = input.LA(1);
				if ( (LA19_0==LogicToken) ) {
					alt19=1;
				}

				switch (alt19) {
				case 1 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:238:95: id1= ( LogicToken ) ( whereStatementDeleteDuplicate )
					{
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:238:99: ( LogicToken )
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:238:100: LogicToken
					{
					id1=(Token)match(input,LogicToken,FOLLOW_LogicToken_in_delete561); 
					}

					  ColumnsDelete.add((id1!=null?id1.getText():null)); 
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:238:146: ( whereStatementDeleteDuplicate )
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:238:147: whereStatementDeleteDuplicate
					{
					pushFollow(FOLLOW_whereStatementDeleteDuplicate_in_delete566);
					whereStatementDeleteDuplicate();
					state._fsp--;

					}

					}
					break;

				default :
					break loop19;
				}
			}


						if(InError==false){
						mainRuntime.delete(ColumnsDelete);
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
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:245:1: insertInto : 'INSERT' 'INTO' id1= Identifier '(' id2= Identifier ( ',' id3= Identifier )* ')' 'VALUES' '(' id4= Identifier ( ',' id5= Identifier )* ')' ;
	public final void insertInto() throws RecognitionException {
		Token id1=null;
		Token id2=null;
		Token id3=null;
		Token id4=null;
		Token id5=null;

		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:246:2: ( 'INSERT' 'INTO' id1= Identifier '(' id2= Identifier ( ',' id3= Identifier )* ')' 'VALUES' '(' id4= Identifier ( ',' id5= Identifier )* ')' )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:246:4: 'INSERT' 'INTO' id1= Identifier '(' id2= Identifier ( ',' id3= Identifier )* ')' 'VALUES' '(' id4= Identifier ( ',' id5= Identifier )* ')'
			{
			match(input,37,FOLLOW_37_in_insertInto583); 
			match(input,38,FOLLOW_38_in_insertInto585); 
			id1=(Token)match(input,Identifier,FOLLOW_Identifier_in_insertInto589); 
			ColumnsInsertInto.add((id1!=null?id1.getText():null)); 
			match(input,13,FOLLOW_13_in_insertInto592); 
			id2=(Token)match(input,Identifier,FOLLOW_Identifier_in_insertInto596); 
			ColumnsInsertInto.add((id2!=null?id2.getText():null));
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:246:126: ( ',' id3= Identifier )*
			loop20:
			while (true) {
				int alt20=2;
				int LA20_0 = input.LA(1);
				if ( (LA20_0==16) ) {
					alt20=1;
				}

				switch (alt20) {
				case 1 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:246:127: ',' id3= Identifier
					{
					match(input,16,FOLLOW_16_in_insertInto601); 
					id3=(Token)match(input,Identifier,FOLLOW_Identifier_in_insertInto605); 
					ColumnsInsertInto.add((id3!=null?id3.getText():null));
					}
					break;

				default :
					break loop20;
				}
			}

			match(input,14,FOLLOW_14_in_insertInto612); 
			match(input,50,FOLLOW_50_in_insertInto614); 
			match(input,13,FOLLOW_13_in_insertInto616); 
			id4=(Token)match(input,Identifier,FOLLOW_Identifier_in_insertInto620); 
			 ColumnsInsertInto.add("VALUES");  ColumnsInsertInto.add((id4!=null?id4.getText():null));
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:247:2: ( ',' id5= Identifier )*
			loop21:
			while (true) {
				int alt21=2;
				int LA21_0 = input.LA(1);
				if ( (LA21_0==16) ) {
					alt21=1;
				}

				switch (alt21) {
				case 1 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:247:3: ',' id5= Identifier
					{
					match(input,16,FOLLOW_16_in_insertInto627); 
					id5=(Token)match(input,Identifier,FOLLOW_Identifier_in_insertInto631); 
					ColumnsInsertInto.add((id5!=null?id5.getText():null)); 
					}
					break;

				default :
					break loop21;
				}
			}

			match(input,14,FOLLOW_14_in_insertInto637); 
				
					if(InError==false){
						mainRuntime.insertInto(ColumnsInsertInto);
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
	// $ANTLR end "insertInto"



	// $ANTLR start "whereStatement"
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:257:1: whereStatement : 'WHERE' id1= Identifier id2= ( '>' | '<' | '=' | 'like' | 'not' | 'is null' | 'is not null' ) id3= ( Identifier | Number )* ;
	public final void whereStatement() throws RecognitionException {
		Token id1=null;
		Token id2=null;
		Token id3=null;

		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:258:2: ( 'WHERE' id1= Identifier id2= ( '>' | '<' | '=' | 'like' | 'not' | 'is null' | 'is not null' ) id3= ( Identifier | Number )* )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:258:4: 'WHERE' id1= Identifier id2= ( '>' | '<' | '=' | 'like' | 'not' | 'is null' | 'is not null' ) id3= ( Identifier | Number )*
			{
			match(input,51,FOLLOW_51_in_whereStatement659); 
			id1=(Token)match(input,Identifier,FOLLOW_Identifier_in_whereStatement663); 
			id2=input.LT(1);
			if ( (input.LA(1) >= 18 && input.LA(1) <= 20)||(input.LA(1) >= 52 && input.LA(1) <= 55) ) {
				input.consume();
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:258:96: ( Identifier | Number )*
			loop22:
			while (true) {
				int alt22=2;
				int LA22_0 = input.LA(1);
				if ( (LA22_0==Identifier||LA22_0==Number) ) {
					alt22=1;
				}

				switch (alt22) {
				case 1 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:
					{
					if ( input.LA(1)==Identifier||input.LA(1)==Number ) {
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
					break loop22;
				}
			}


					ColumnsSelect.add("WHERE");
					ColumnsSelect.add((id1!=null?id1.getText():null));
					ColumnsSelect.add((id2!=null?id2.getText():null));
					if((id3!=null?id3.getText():null)==null){
						ColumnsSelect.add("NULL");
					}
					else{
						ColumnsSelect.add((id3!=null?id3.getText():null));
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



	// $ANTLR start "whereStatementAUX"
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:275:1: whereStatementAUX : id1= Identifier id2= ( '>' | '<' | '=' | 'like' | 'not' | 'is null' | 'is not null' ) id3= ( Identifier | Number ) ;
	public final void whereStatementAUX() throws RecognitionException {
		Token id1=null;
		Token id2=null;
		Token id3=null;

		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:276:2: (id1= Identifier id2= ( '>' | '<' | '=' | 'like' | 'not' | 'is null' | 'is not null' ) id3= ( Identifier | Number ) )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:276:5: id1= Identifier id2= ( '>' | '<' | '=' | 'like' | 'not' | 'is null' | 'is not null' ) id3= ( Identifier | Number )
			{
			id1=(Token)match(input,Identifier,FOLLOW_Identifier_in_whereStatementAUX715); 
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

					ColumnsSelect.add("WHERE AUX");
					ColumnsSelect.add((id1!=null?id1.getText():null));
					ColumnsSelect.add((id2!=null?id2.getText():null));
					ColumnsSelect.add((id3!=null?id3.getText():null));
				
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
	// $ANTLR end "whereStatementAUX"



	// $ANTLR start "whereStatementDuplicate"
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:284:1: whereStatementDuplicate : 'WHERE' id1= Identifier id2= ( '>' | '<' | '=' | 'like' | 'not' | 'is null' | 'is not null' ) id3= ( Identifier | Number ) ;
	public final void whereStatementDuplicate() throws RecognitionException {
		Token id1=null;
		Token id2=null;
		Token id3=null;

		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:285:2: ( 'WHERE' id1= Identifier id2= ( '>' | '<' | '=' | 'like' | 'not' | 'is null' | 'is not null' ) id3= ( Identifier | Number ) )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:285:4: 'WHERE' id1= Identifier id2= ( '>' | '<' | '=' | 'like' | 'not' | 'is null' | 'is not null' ) id3= ( Identifier | Number )
			{
			match(input,51,FOLLOW_51_in_whereStatementDuplicate765); 
			id1=(Token)match(input,Identifier,FOLLOW_Identifier_in_whereStatementDuplicate769); 
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
	// $ANTLR end "whereStatementDuplicate"



	// $ANTLR start "whereStatementUpdate"
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:288:1: whereStatementUpdate : 'WHERE' id1= Identifier id2= ( '>' | '<' | '=' | 'like' | 'not' | 'is null' | 'is not null' ) id3= ( Identifier | Number ) ;
	public final void whereStatementUpdate() throws RecognitionException {
		Token id1=null;
		Token id2=null;
		Token id3=null;

		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:289:2: ( 'WHERE' id1= Identifier id2= ( '>' | '<' | '=' | 'like' | 'not' | 'is null' | 'is not null' ) id3= ( Identifier | Number ) )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:289:4: 'WHERE' id1= Identifier id2= ( '>' | '<' | '=' | 'like' | 'not' | 'is null' | 'is not null' ) id3= ( Identifier | Number )
			{
			match(input,51,FOLLOW_51_in_whereStatementUpdate818); 
			id1=(Token)match(input,Identifier,FOLLOW_Identifier_in_whereStatementUpdate822); 
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

				ColumnsUpdate.add("WHERE");
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



	// $ANTLR start "whereStatementUpdateDuplicate"
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:297:1: whereStatementUpdateDuplicate : id1= Identifier id2= ( '>' | '<' | '=' | 'like' | 'not' | 'is null' | 'is not null' ) id3= ( Identifier | Number ) ;
	public final void whereStatementUpdateDuplicate() throws RecognitionException {
		Token id1=null;
		Token id2=null;
		Token id3=null;

		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:298:2: (id1= Identifier id2= ( '>' | '<' | '=' | 'like' | 'not' | 'is null' | 'is not null' ) id3= ( Identifier | Number ) )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:298:5: id1= Identifier id2= ( '>' | '<' | '=' | 'like' | 'not' | 'is null' | 'is not null' ) id3= ( Identifier | Number )
			{
			id1=(Token)match(input,Identifier,FOLLOW_Identifier_in_whereStatementUpdateDuplicate878); 
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

				ColumnsUpdate.add("WHERE");

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
	// $ANTLR end "whereStatementUpdateDuplicate"



	// $ANTLR start "whereStatementDelete"
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:306:1: whereStatementDelete : 'WHERE' id1= Identifier id2= ( '>' | '<' | '=' | 'like' | 'not' | 'is null' | 'is not null' ) id3= ( Identifier | Number ) ;
	public final void whereStatementDelete() throws RecognitionException {
		Token id1=null;
		Token id2=null;
		Token id3=null;

		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:307:2: ( 'WHERE' id1= Identifier id2= ( '>' | '<' | '=' | 'like' | 'not' | 'is null' | 'is not null' ) id3= ( Identifier | Number ) )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:307:4: 'WHERE' id1= Identifier id2= ( '>' | '<' | '=' | 'like' | 'not' | 'is null' | 'is not null' ) id3= ( Identifier | Number )
			{
			match(input,51,FOLLOW_51_in_whereStatementDelete929); 
			id1=(Token)match(input,Identifier,FOLLOW_Identifier_in_whereStatementDelete933); 
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

				
				ColumnsDelete.add("WHERE");
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



	// $ANTLR start "whereStatementDeleteDuplicate"
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:316:1: whereStatementDeleteDuplicate : id1= Identifier id2= ( '>' | '<' | '=' | 'like' | 'not' | 'is null' | 'is not null' ) id3= ( Identifier | Number ) ;
	public final void whereStatementDeleteDuplicate() throws RecognitionException {
		Token id1=null;
		Token id2=null;
		Token id3=null;

		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:317:2: (id1= Identifier id2= ( '>' | '<' | '=' | 'like' | 'not' | 'is null' | 'is not null' ) id3= ( Identifier | Number ) )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:317:5: id1= Identifier id2= ( '>' | '<' | '=' | 'like' | 'not' | 'is null' | 'is not null' ) id3= ( Identifier | Number )
			{
			id1=(Token)match(input,Identifier,FOLLOW_Identifier_in_whereStatementDeleteDuplicate988); 
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

				
				ColumnsDelete.add("WHERE");
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
	// $ANTLR end "whereStatementDeleteDuplicate"



	// $ANTLR start "joinStatement"
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:326:1: joinStatement : 'JOIN' id1= Identifier 'ON' id2= Identifier '.' id3= Identifier '=' id4= Identifier '.' id5= Identifier ;
	public final void joinStatement() throws RecognitionException {
		Token id1=null;
		Token id2=null;
		Token id3=null;
		Token id4=null;
		Token id5=null;

		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:327:2: ( 'JOIN' id1= Identifier 'ON' id2= Identifier '.' id3= Identifier '=' id4= Identifier '.' id5= Identifier )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:327:4: 'JOIN' id1= Identifier 'ON' id2= Identifier '.' id3= Identifier '=' id4= Identifier '.' id5= Identifier
			{
			match(input,39,FOLLOW_39_in_joinStatement1039); 
			id1=(Token)match(input,Identifier,FOLLOW_Identifier_in_joinStatement1043); 
			match(input,41,FOLLOW_41_in_joinStatement1045); 
			id2=(Token)match(input,Identifier,FOLLOW_Identifier_in_joinStatement1049); 
			match(input,17,FOLLOW_17_in_joinStatement1051); 
			id3=(Token)match(input,Identifier,FOLLOW_Identifier_in_joinStatement1055); 
			match(input,19,FOLLOW_19_in_joinStatement1057); 
			id4=(Token)match(input,Identifier,FOLLOW_Identifier_in_joinStatement1061); 
			match(input,17,FOLLOW_17_in_joinStatement1063); 
			id5=(Token)match(input,Identifier,FOLLOW_Identifier_in_joinStatement1067); 

					
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
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:349:1: constraintDefinition : 'FOREIGN KEY' '(' id1= Identifier ')' 'REFERENCES' id2= Identifier '(' id3= Identifier ')' ;
	public final void constraintDefinition() throws RecognitionException {
		Token id1=null;
		Token id2=null;
		Token id3=null;

		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:350:2: ( 'FOREIGN KEY' '(' id1= Identifier ')' 'REFERENCES' id2= Identifier '(' id3= Identifier ')' )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:350:4: 'FOREIGN KEY' '(' id1= Identifier ')' 'REFERENCES' id2= Identifier '(' id3= Identifier ')'
			{
			match(input,34,FOLLOW_34_in_constraintDefinition1133); 
			match(input,13,FOLLOW_13_in_constraintDefinition1135); 
			id1=(Token)match(input,Identifier,FOLLOW_Identifier_in_constraintDefinition1139); 
			match(input,14,FOLLOW_14_in_constraintDefinition1141); 
			match(input,43,FOLLOW_43_in_constraintDefinition1143); 
			id2=(Token)match(input,Identifier,FOLLOW_Identifier_in_constraintDefinition1147); 
			match(input,13,FOLLOW_13_in_constraintDefinition1149); 
			id3=(Token)match(input,Identifier,FOLLOW_Identifier_in_constraintDefinition1153); 
			match(input,14,FOLLOW_14_in_constraintDefinition1155); 

					
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
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:358:1: columnDefinition : Identifier Type Nullability ;
	public final void columnDefinition() throws RecognitionException {
		Token Identifier8=null;
		Token Type9=null;
		Token Nullability10=null;

		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:359:2: ( Identifier Type Nullability )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:359:4: Identifier Type Nullability
			{
			Identifier8=(Token)match(input,Identifier,FOLLOW_Identifier_in_columnDefinition1169); 
			Type9=(Token)match(input,Type,FOLLOW_Type_in_columnDefinition1171); 
			Nullability10=(Token)match(input,Nullability,FOLLOW_Nullability_in_columnDefinition1173); 

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
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:383:1: primaryKey : 'PRIMARY KEY(' Identifier ')' ;
	public final void primaryKey() throws RecognitionException {
		Token Identifier11=null;

		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:384:2: ( 'PRIMARY KEY(' Identifier ')' )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:384:4: 'PRIMARY KEY(' Identifier ')'
			{
			match(input,42,FOLLOW_42_in_primaryKey1244); 
			Identifier11=(Token)match(input,Identifier,FOLLOW_Identifier_in_primaryKey1246); 
			match(input,14,FOLLOW_14_in_primaryKey1248); 

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
	public static final BitSet FOLLOW_40_in_listDB143 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_46_in_startDB153 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_47_in_stopDB164 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_29_in_displayDB175 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_displayDB177 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_45_in_setDB191 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_setDB195 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_27_in_createTable207 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_createTable209 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_23_in_createTable211 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_createTable213 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_columnDefinition_in_createTable215 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_createTable220 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_columnDefinition_in_createTable223 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_createTable228 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_primaryKey_in_createTable231 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_14_in_createTable233 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_22_in_alterTable247 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_alterTable249 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_21_in_alterTable252 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_24_in_alterTable254 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_constraintDefinition_in_alterTable256 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_31_in_dropTable267 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_dropTable269 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_26_in_createIndex286 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_createIndex290 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_41_in_createIndex292 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_createIndex296 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_createIndex298 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_createIndex301 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_14_in_createIndex303 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_44_in_selectStatement320 = new BitSet(new long[]{0x0000000800018050L});
	public static final BitSet FOLLOW_15_in_selectStatement325 = new BitSet(new long[]{0x0000000800018050L});
	public static final BitSet FOLLOW_Identifier_in_selectStatement334 = new BitSet(new long[]{0x0000000800030050L});
	public static final BitSet FOLLOW_17_in_selectStatement337 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_selectStatement341 = new BitSet(new long[]{0x0000000800030050L});
	public static final BitSet FOLLOW_16_in_selectStatement351 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_selectStatement355 = new BitSet(new long[]{0x0000000800030010L});
	public static final BitSet FOLLOW_17_in_selectStatement358 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_selectStatement362 = new BitSet(new long[]{0x0000000800030010L});
	public static final BitSet FOLLOW_16_in_selectStatement375 = new BitSet(new long[]{0x0000000800010010L});
	public static final BitSet FOLLOW_AggregateFunctions_in_selectStatement383 = new BitSet(new long[]{0x0000000800000010L});
	public static final BitSet FOLLOW_35_in_selectStatement388 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_selectStatement392 = new BitSet(new long[]{0x0008009300000002L});
	public static final BitSet FOLLOW_joinStatement_in_selectStatement395 = new BitSet(new long[]{0x0008009300000002L});
	public static final BitSet FOLLOW_whereStatement_in_selectStatement404 = new BitSet(new long[]{0x0008001300000102L});
	public static final BitSet FOLLOW_LogicToken_in_selectStatement412 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_whereStatementAUX_in_selectStatement416 = new BitSet(new long[]{0x0008001300000102L});
	public static final BitSet FOLLOW_36_in_selectStatement428 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_selectStatement432 = new BitSet(new long[]{0x0000001300000002L});
	public static final BitSet FOLLOW_49_in_updateStatement473 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_updateStatement477 = new BitSet(new long[]{0x0001000000000000L});
	public static final BitSet FOLLOW_48_in_updateStatement480 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_updateStatement484 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_19_in_updateStatement487 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_updateStatement493 = new BitSet(new long[]{0x0008000000000102L});
	public static final BitSet FOLLOW_whereStatementUpdate_in_updateStatement502 = new BitSet(new long[]{0x0008000000000102L});
	public static final BitSet FOLLOW_LogicToken_in_updateStatement511 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_whereStatementUpdateDuplicate_in_updateStatement516 = new BitSet(new long[]{0x0000000000000102L});
	public static final BitSet FOLLOW_28_in_delete543 = new BitSet(new long[]{0x0000000800000000L});
	public static final BitSet FOLLOW_35_in_delete545 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_delete547 = new BitSet(new long[]{0x0008000000000102L});
	public static final BitSet FOLLOW_whereStatementDelete_in_delete551 = new BitSet(new long[]{0x0008000000000102L});
	public static final BitSet FOLLOW_LogicToken_in_delete561 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_whereStatementDeleteDuplicate_in_delete566 = new BitSet(new long[]{0x0000000000000102L});
	public static final BitSet FOLLOW_37_in_insertInto583 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_38_in_insertInto585 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_insertInto589 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_insertInto592 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_insertInto596 = new BitSet(new long[]{0x0000000000014000L});
	public static final BitSet FOLLOW_16_in_insertInto601 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_insertInto605 = new BitSet(new long[]{0x0000000000014000L});
	public static final BitSet FOLLOW_14_in_insertInto612 = new BitSet(new long[]{0x0004000000000000L});
	public static final BitSet FOLLOW_50_in_insertInto614 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_insertInto616 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_insertInto620 = new BitSet(new long[]{0x0000000000014000L});
	public static final BitSet FOLLOW_16_in_insertInto627 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_insertInto631 = new BitSet(new long[]{0x0000000000014000L});
	public static final BitSet FOLLOW_14_in_insertInto637 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_51_in_whereStatement659 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_whereStatement663 = new BitSet(new long[]{0x00F00000001C0000L});
	public static final BitSet FOLLOW_set_in_whereStatement667 = new BitSet(new long[]{0x0000000000000442L});
	public static final BitSet FOLLOW_Identifier_in_whereStatementAUX715 = new BitSet(new long[]{0x00F00000001C0000L});
	public static final BitSet FOLLOW_set_in_whereStatementAUX719 = new BitSet(new long[]{0x0000000000000440L});
	public static final BitSet FOLLOW_set_in_whereStatementAUX747 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_51_in_whereStatementDuplicate765 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_whereStatementDuplicate769 = new BitSet(new long[]{0x00F00000001C0000L});
	public static final BitSet FOLLOW_set_in_whereStatementDuplicate773 = new BitSet(new long[]{0x0000000000000440L});
	public static final BitSet FOLLOW_set_in_whereStatementDuplicate801 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_51_in_whereStatementUpdate818 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_whereStatementUpdate822 = new BitSet(new long[]{0x00F00000001C0000L});
	public static final BitSet FOLLOW_set_in_whereStatementUpdate826 = new BitSet(new long[]{0x0000000000000440L});
	public static final BitSet FOLLOW_set_in_whereStatementUpdate854 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Identifier_in_whereStatementUpdateDuplicate878 = new BitSet(new long[]{0x00F00000001C0000L});
	public static final BitSet FOLLOW_set_in_whereStatementUpdateDuplicate882 = new BitSet(new long[]{0x0000000000000440L});
	public static final BitSet FOLLOW_set_in_whereStatementUpdateDuplicate910 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_51_in_whereStatementDelete929 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_whereStatementDelete933 = new BitSet(new long[]{0x00F00000001C0000L});
	public static final BitSet FOLLOW_set_in_whereStatementDelete937 = new BitSet(new long[]{0x0000000000000440L});
	public static final BitSet FOLLOW_set_in_whereStatementDelete965 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Identifier_in_whereStatementDeleteDuplicate988 = new BitSet(new long[]{0x00F00000001C0000L});
	public static final BitSet FOLLOW_set_in_whereStatementDeleteDuplicate992 = new BitSet(new long[]{0x0000000000000440L});
	public static final BitSet FOLLOW_set_in_whereStatementDeleteDuplicate1020 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_39_in_joinStatement1039 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_joinStatement1043 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_41_in_joinStatement1045 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_joinStatement1049 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_17_in_joinStatement1051 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_joinStatement1055 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_19_in_joinStatement1057 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_joinStatement1061 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_17_in_joinStatement1063 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_joinStatement1067 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_34_in_constraintDefinition1133 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_constraintDefinition1135 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_constraintDefinition1139 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_14_in_constraintDefinition1141 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_43_in_constraintDefinition1143 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_constraintDefinition1147 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_constraintDefinition1149 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_constraintDefinition1153 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_14_in_constraintDefinition1155 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Identifier_in_columnDefinition1169 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_Type_in_columnDefinition1171 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_Nullability_in_columnDefinition1173 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_42_in_primaryKey1244 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_primaryKey1246 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_14_in_primaryKey1248 = new BitSet(new long[]{0x0000000000000002L});
}
