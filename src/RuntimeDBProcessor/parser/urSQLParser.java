// $ANTLR 3.5.1 /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g 2015-09-27 00:00:27

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
		"Identifier", "LETTER", "LogicToken", "Nullability", "Types", "WS", "'('", 
		"')'", "'*'", "','", "'.'", "'<'", "'='", "'>'", "'ADD'", "'ALTER TABLE'", 
		"'AS'", "'CONSTRAINT'", "'CREATE DATABASE'", "'CREATE INDEX'", "'CREATE TABLE'", 
		"'DELETE'", "'DISPLAY DATABASE'", "'DROP DATABASE'", "'DROP TABLE'", "'FOR JSON'", 
		"'FOR XML'", "'FOREIGN KEY'", "'FROM'", "'GET STATUS'", "'GROUP BY'", 
		"'INSERT INTO'", "'JOIN'", "'LIST DATABASES'", "'ON'", "'PRIMARY KEY('", 
		"'REFERENCES'", "'SELECT'", "'SET DATABASE'", "'START'", "'STOP'", "'Set'", 
		"'UPDATE'", "'VALUES'", "'WHERE'", "'is not null'", "'is null'", "'like'", 
		"'not'"
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
	public static final int AggregateFunctions=4;
	public static final int DIGIT=5;
	public static final int Identifier=6;
	public static final int LETTER=7;
	public static final int LogicToken=8;
	public static final int Nullability=9;
	public static final int Types=10;
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
		
		Boolean InError=false;
		

		RuntimeDB mainRuntime= new RuntimeDB();
		
		
		@Override
		  public void reportError(RecognitionException e) {
			System.out.println("ERROR \n "+e.toString());
			
		  	//System.out.println("ERROR \n "+e.getMessage());
		  	mainRuntime.reportedError(e.toString(),"parser");
		       	InError=true;       
		}   	
	        	//900 PARA LEXICO
	        	//901 PARA SINTACTICO
	        	
	        	



	// $ANTLR start "query"
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:71:1: query : ( script )* ;
	public final void query() throws RecognitionException {
		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:71:7: ( ( script )* )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:72:2: ( script )*
			{
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:72:2: ( script )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==21||(LA1_0 >= 24 && LA1_0 <= 30)||LA1_0==35||LA1_0==37||LA1_0==39||(LA1_0 >= 43 && LA1_0 <= 46)||LA1_0==48) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:72:2: script
					{
					pushFollow(FOLLOW_script_in_query64);
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
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:74:1: script : ( createDB | dropDB | listDB | startDB | stopDB | displayDB | setDB | createTable | getStatus | alterTable | dropTable | createIndex | selectStatement | updateStatement | delete | insertInto );
	public final void script() throws RecognitionException {
		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:74:8: ( createDB | dropDB | listDB | startDB | stopDB | displayDB | setDB | createTable | getStatus | alterTable | dropTable | createIndex | selectStatement | updateStatement | delete | insertInto )
			int alt2=16;
			switch ( input.LA(1) ) {
			case 24:
				{
				alt2=1;
				}
				break;
			case 29:
				{
				alt2=2;
				}
				break;
			case 39:
				{
				alt2=3;
				}
				break;
			case 45:
				{
				alt2=4;
				}
				break;
			case 46:
				{
				alt2=5;
				}
				break;
			case 28:
				{
				alt2=6;
				}
				break;
			case 44:
				{
				alt2=7;
				}
				break;
			case 26:
				{
				alt2=8;
				}
				break;
			case 35:
				{
				alt2=9;
				}
				break;
			case 21:
				{
				alt2=10;
				}
				break;
			case 30:
				{
				alt2=11;
				}
				break;
			case 25:
				{
				alt2=12;
				}
				break;
			case 43:
				{
				alt2=13;
				}
				break;
			case 48:
				{
				alt2=14;
				}
				break;
			case 27:
				{
				alt2=15;
				}
				break;
			case 37:
				{
				alt2=16;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}
			switch (alt2) {
				case 1 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:75:2: createDB
					{
					pushFollow(FOLLOW_createDB_in_script75);
					createDB();
					state._fsp--;

					}
					break;
				case 2 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:75:13: dropDB
					{
					pushFollow(FOLLOW_dropDB_in_script79);
					dropDB();
					state._fsp--;

					}
					break;
				case 3 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:75:22: listDB
					{
					pushFollow(FOLLOW_listDB_in_script83);
					listDB();
					state._fsp--;

					}
					break;
				case 4 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:75:30: startDB
					{
					pushFollow(FOLLOW_startDB_in_script86);
					startDB();
					state._fsp--;

					}
					break;
				case 5 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:75:42: stopDB
					{
					pushFollow(FOLLOW_stopDB_in_script92);
					stopDB();
					state._fsp--;

					}
					break;
				case 6 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:75:51: displayDB
					{
					pushFollow(FOLLOW_displayDB_in_script96);
					displayDB();
					state._fsp--;

					}
					break;
				case 7 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:75:63: setDB
					{
					pushFollow(FOLLOW_setDB_in_script100);
					setDB();
					state._fsp--;

					}
					break;
				case 8 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:75:71: createTable
					{
					pushFollow(FOLLOW_createTable_in_script104);
					createTable();
					state._fsp--;

					}
					break;
				case 9 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:75:83: getStatus
					{
					pushFollow(FOLLOW_getStatus_in_script106);
					getStatus();
					state._fsp--;

					}
					break;
				case 10 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:76:3: alterTable
					{
					pushFollow(FOLLOW_alterTable_in_script111);
					alterTable();
					state._fsp--;

					}
					break;
				case 11 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:76:16: dropTable
					{
					pushFollow(FOLLOW_dropTable_in_script115);
					dropTable();
					state._fsp--;

					}
					break;
				case 12 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:76:27: createIndex
					{
					pushFollow(FOLLOW_createIndex_in_script118);
					createIndex();
					state._fsp--;

					}
					break;
				case 13 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:76:40: selectStatement
					{
					pushFollow(FOLLOW_selectStatement_in_script121);
					selectStatement();
					state._fsp--;

					}
					break;
				case 14 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:76:58: updateStatement
					{
					pushFollow(FOLLOW_updateStatement_in_script125);
					updateStatement();
					state._fsp--;

					}
					break;
				case 15 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:76:77: delete
					{
					pushFollow(FOLLOW_delete_in_script130);
					delete();
					state._fsp--;

					}
					break;
				case 16 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:76:86: insertInto
					{
					pushFollow(FOLLOW_insertInto_in_script134);
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
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:81:1: createDB : 'CREATE DATABASE' Identifier ;
	public final void createDB() throws RecognitionException {
		Token Identifier1=null;

		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:82:2: ( 'CREATE DATABASE' Identifier )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:82:4: 'CREATE DATABASE' Identifier
			{
			match(input,24,FOLLOW_24_in_createDB147); 
			Identifier1=(Token)match(input,Identifier,FOLLOW_Identifier_in_createDB149); 

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
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:92:1: dropDB : 'DROP DATABASE' Identifier ;
	public final void dropDB() throws RecognitionException {
		Token Identifier2=null;

		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:93:2: ( 'DROP DATABASE' Identifier )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:93:4: 'DROP DATABASE' Identifier
			{
			match(input,29,FOLLOW_29_in_dropDB163); 
			Identifier2=(Token)match(input,Identifier,FOLLOW_Identifier_in_dropDB165); 
				
				
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
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:104:1: listDB : 'LIST DATABASES' ;
	public final void listDB() throws RecognitionException {
		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:104:8: ( 'LIST DATABASES' )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:104:10: 'LIST DATABASES'
			{
			match(input,39,FOLLOW_39_in_listDB184); 

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
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:113:1: startDB : 'START' ;
	public final void startDB() throws RecognitionException {
		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:113:9: ( 'START' )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:113:11: 'START'
			{
			match(input,45,FOLLOW_45_in_startDB194); 
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
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:117:1: stopDB : 'STOP' ;
	public final void stopDB() throws RecognitionException {
		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:117:8: ( 'STOP' )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:117:10: 'STOP'
			{
			match(input,46,FOLLOW_46_in_stopDB205); 
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
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:119:1: displayDB : 'DISPLAY DATABASE' Identifier ;
	public final void displayDB() throws RecognitionException {
		Token Identifier3=null;

		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:120:2: ( 'DISPLAY DATABASE' Identifier )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:120:4: 'DISPLAY DATABASE' Identifier
			{
			match(input,28,FOLLOW_28_in_displayDB216); 
			Identifier3=(Token)match(input,Identifier,FOLLOW_Identifier_in_displayDB218); 

						if(InError==false){
							mainRuntime.DisplayDB((Identifier3!=null?Identifier3.getText():null));
							
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
	// $ANTLR end "displayDB"



	// $ANTLR start "getStatus"
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:127:1: getStatus : 'GET STATUS' ;
	public final void getStatus() throws RecognitionException {
		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:128:2: ( 'GET STATUS' )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:128:4: 'GET STATUS'
			{
			match(input,35,FOLLOW_35_in_getStatus232); 

					if(InError==false){
						mainRuntime.GetStatus();		
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
	// $ANTLR end "getStatus"



	// $ANTLR start "setDB"
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:135:1: setDB : 'SET DATABASE' id1= Identifier ;
	public final void setDB() throws RecognitionException {
		Token id1=null;

		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:136:2: ( 'SET DATABASE' id1= Identifier )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:136:4: 'SET DATABASE' id1= Identifier
			{
			match(input,44,FOLLOW_44_in_setDB247); 
			id1=(Token)match(input,Identifier,FOLLOW_Identifier_in_setDB251); 

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
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:146:1: createTable : 'CREATE TABLE' Identifier 'AS' '(' columnDefinition ( ',' columnDefinition )* ',' primaryKey ')' ;
	public final void createTable() throws RecognitionException {
		Token Identifier4=null;

		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:147:2: ( 'CREATE TABLE' Identifier 'AS' '(' columnDefinition ( ',' columnDefinition )* ',' primaryKey ')' )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:147:4: 'CREATE TABLE' Identifier 'AS' '(' columnDefinition ( ',' columnDefinition )* ',' primaryKey ')'
			{
			match(input,26,FOLLOW_26_in_createTable263); 
			Identifier4=(Token)match(input,Identifier,FOLLOW_Identifier_in_createTable265); 
			ColumnsCreateTable.add((Identifier4!=null?Identifier4.getText():null));
			match(input,22,FOLLOW_22_in_createTable267); 
			match(input,12,FOLLOW_12_in_createTable269); 
			pushFollow(FOLLOW_columnDefinition_in_createTable271);
			columnDefinition();
			state._fsp--;

			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:147:100: ( ',' columnDefinition )*
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
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:147:101: ',' columnDefinition
					{
					match(input,15,FOLLOW_15_in_createTable276); 
					pushFollow(FOLLOW_columnDefinition_in_createTable279);
					columnDefinition();
					state._fsp--;

					}
					break;

				default :
					break loop3;
				}
			}

			match(input,15,FOLLOW_15_in_createTable284); 
			pushFollow(FOLLOW_primaryKey_in_createTable287);
			primaryKey();
			state._fsp--;

			match(input,13,FOLLOW_13_in_createTable289); 

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
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:158:1: alterTable : 'ALTER TABLE' Identifier 'ADD' 'CONSTRAINT' constraintDefinition ;
	public final void alterTable() throws RecognitionException {
		Token Identifier5=null;

		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:159:2: ( 'ALTER TABLE' Identifier 'ADD' 'CONSTRAINT' constraintDefinition )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:159:4: 'ALTER TABLE' Identifier 'ADD' 'CONSTRAINT' constraintDefinition
			{
			match(input,21,FOLLOW_21_in_alterTable303); 
			Identifier5=(Token)match(input,Identifier,FOLLOW_Identifier_in_alterTable305); 
			ColumnsAlterTable.add((Identifier5!=null?Identifier5.getText():null));
			match(input,20,FOLLOW_20_in_alterTable308); 
			match(input,23,FOLLOW_23_in_alterTable310); 
			pushFollow(FOLLOW_constraintDefinition_in_alterTable312);
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
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:167:1: dropTable : 'DROP TABLE' Identifier ;
	public final void dropTable() throws RecognitionException {
		Token Identifier6=null;

		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:168:2: ( 'DROP TABLE' Identifier )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:168:4: 'DROP TABLE' Identifier
			{
			match(input,30,FOLLOW_30_in_dropTable323); 
			Identifier6=(Token)match(input,Identifier,FOLLOW_Identifier_in_dropTable325); 

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
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:179:1: createIndex : 'CREATE INDEX' id1= Identifier 'ON' id2= Identifier '(' id3= Identifier ')' ;
	public final void createIndex() throws RecognitionException {
		Token id1=null;
		Token id2=null;
		Token id3=null;

		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:180:2: ( 'CREATE INDEX' id1= Identifier 'ON' id2= Identifier '(' id3= Identifier ')' )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:180:4: 'CREATE INDEX' id1= Identifier 'ON' id2= Identifier '(' id3= Identifier ')'
			{
			match(input,25,FOLLOW_25_in_createIndex342); 
			id1=(Token)match(input,Identifier,FOLLOW_Identifier_in_createIndex346); 
			match(input,40,FOLLOW_40_in_createIndex348); 
			id2=(Token)match(input,Identifier,FOLLOW_Identifier_in_createIndex352); 
			match(input,12,FOLLOW_12_in_createIndex354); 
			id3=(Token)match(input,Identifier,FOLLOW_Identifier_in_createIndex357); 
			match(input,13,FOLLOW_13_in_createIndex359); 

					
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
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:205:1: selectStatement : 'SELECT' id1= ( '*' )* (id2= Identifier )* ( '.' id3= Identifier )* ( ',' id4= Identifier )* ( '.' id5= Identifier )* ( ',' )* (Ag= AggregateFunctions )* 'FROM' fromId= Identifier ( joinStatement )* ( whereStatement )* (logic= LogicToken whereStatementAUX )* ( 'GROUP BY' id6= Identifier )* id7= ( 'FOR JSON' | 'FOR XML' )* ;
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
		Token id7=null;

		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:205:17: ( 'SELECT' id1= ( '*' )* (id2= Identifier )* ( '.' id3= Identifier )* ( ',' id4= Identifier )* ( '.' id5= Identifier )* ( ',' )* (Ag= AggregateFunctions )* 'FROM' fromId= Identifier ( joinStatement )* ( whereStatement )* (logic= LogicToken whereStatementAUX )* ( 'GROUP BY' id6= Identifier )* id7= ( 'FOR JSON' | 'FOR XML' )* )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:206:3: 'SELECT' id1= ( '*' )* (id2= Identifier )* ( '.' id3= Identifier )* ( ',' id4= Identifier )* ( '.' id5= Identifier )* ( ',' )* (Ag= AggregateFunctions )* 'FROM' fromId= Identifier ( joinStatement )* ( whereStatement )* (logic= LogicToken whereStatementAUX )* ( 'GROUP BY' id6= Identifier )* id7= ( 'FOR JSON' | 'FOR XML' )*
			{
			match(input,43,FOLLOW_43_in_selectStatement376); 
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:206:16: ( '*' )*
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( (LA4_0==14) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:206:17: '*'
					{
					id1=(Token)match(input,14,FOLLOW_14_in_selectStatement381); 
					}
					break;

				default :
					break loop4;
				}
			}

			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:206:25: (id2= Identifier )*
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( (LA5_0==Identifier) ) {
					alt5=1;
				}

				switch (alt5) {
				case 1 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:206:26: id2= Identifier
					{
					id2=(Token)match(input,Identifier,FOLLOW_Identifier_in_selectStatement390); 
					}
					break;

				default :
					break loop5;
				}
			}

			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:206:43: ( '.' id3= Identifier )*
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( (LA6_0==16) ) {
					int LA6_2 = input.LA(2);
					if ( (LA6_2==Identifier) ) {
						alt6=1;
					}

				}

				switch (alt6) {
				case 1 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:206:44: '.' id3= Identifier
					{
					match(input,16,FOLLOW_16_in_selectStatement395); 
					id3=(Token)match(input,Identifier,FOLLOW_Identifier_in_selectStatement399); 
					}
					break;

				default :
					break loop6;
				}
			}

			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:206:68: ( ',' id4= Identifier )*
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( (LA7_0==15) ) {
					int LA7_2 = input.LA(2);
					if ( (LA7_2==Identifier) ) {
						alt7=1;
					}

				}

				switch (alt7) {
				case 1 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:206:69: ',' id4= Identifier
					{
					match(input,15,FOLLOW_15_in_selectStatement407); 
					id4=(Token)match(input,Identifier,FOLLOW_Identifier_in_selectStatement411); 
					}
					break;

				default :
					break loop7;
				}
			}

			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:206:92: ( '.' id5= Identifier )*
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( (LA8_0==16) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:206:93: '.' id5= Identifier
					{
					match(input,16,FOLLOW_16_in_selectStatement418); 
					id5=(Token)match(input,Identifier,FOLLOW_Identifier_in_selectStatement422); 
					}
					break;

				default :
					break loop8;
				}
			}

			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:206:116: ( ',' )*
			loop9:
			while (true) {
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( (LA9_0==15) ) {
					alt9=1;
				}

				switch (alt9) {
				case 1 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:206:117: ','
					{
					match(input,15,FOLLOW_15_in_selectStatement429); 
					}
					break;

				default :
					break loop9;
				}
			}

			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:206:124: (Ag= AggregateFunctions )*
			loop10:
			while (true) {
				int alt10=2;
				int LA10_0 = input.LA(1);
				if ( (LA10_0==AggregateFunctions) ) {
					alt10=1;
				}

				switch (alt10) {
				case 1 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:206:125: Ag= AggregateFunctions
					{
					Ag=(Token)match(input,AggregateFunctions,FOLLOW_AggregateFunctions_in_selectStatement437); 
					}
					break;

				default :
					break loop10;
				}
			}

			match(input,34,FOLLOW_34_in_selectStatement442); 
			fromId=(Token)match(input,Identifier,FOLLOW_Identifier_in_selectStatement446); 
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:206:175: ( joinStatement )*
			loop11:
			while (true) {
				int alt11=2;
				int LA11_0 = input.LA(1);
				if ( (LA11_0==38) ) {
					alt11=1;
				}

				switch (alt11) {
				case 1 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:206:176: joinStatement
					{
					pushFollow(FOLLOW_joinStatement_in_selectStatement449);
					joinStatement();
					state._fsp--;

					}
					break;

				default :
					break loop11;
				}
			}

			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:207:4: ( whereStatement )*
			loop12:
			while (true) {
				int alt12=2;
				int LA12_0 = input.LA(1);
				if ( (LA12_0==50) ) {
					alt12=1;
				}

				switch (alt12) {
				case 1 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:207:5: whereStatement
					{
					pushFollow(FOLLOW_whereStatement_in_selectStatement457);
					whereStatement();
					state._fsp--;

					}
					break;

				default :
					break loop12;
				}
			}

			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:207:23: (logic= LogicToken whereStatementAUX )*
			loop13:
			while (true) {
				int alt13=2;
				int LA13_0 = input.LA(1);
				if ( (LA13_0==LogicToken) ) {
					alt13=1;
				}

				switch (alt13) {
				case 1 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:207:25: logic= LogicToken whereStatementAUX
					{
					logic=(Token)match(input,LogicToken,FOLLOW_LogicToken_in_selectStatement466); 
					 ColumnsSelect.add((logic!=null?logic.getText():null));   
					pushFollow(FOLLOW_whereStatementAUX_in_selectStatement470);
					whereStatementAUX();
					state._fsp--;

					}
					break;

				default :
					break loop13;
				}
			}

			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:207:105: ( 'GROUP BY' id6= Identifier )*
			loop14:
			while (true) {
				int alt14=2;
				int LA14_0 = input.LA(1);
				if ( (LA14_0==36) ) {
					alt14=1;
				}

				switch (alt14) {
				case 1 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:207:106: 'GROUP BY' id6= Identifier
					{
					match(input,36,FOLLOW_36_in_selectStatement480); 
					id6=(Token)match(input,Identifier,FOLLOW_Identifier_in_selectStatement484); 
					}
					break;

				default :
					break loop14;
				}
			}

			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:207:138: ( 'FOR JSON' | 'FOR XML' )*
			loop15:
			while (true) {
				int alt15=2;
				int LA15_0 = input.LA(1);
				if ( ((LA15_0 >= 31 && LA15_0 <= 32)) ) {
					alt15=1;
				}

				switch (alt15) {
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
						if((id7!=null?id7.getText():null)!=null){
							
							ColumnsSelect.add((id7!=null?id7.getText():null));
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
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:255:1: updateStatement : 'UPDATE' id1= Identifier 'Set' id2= Identifier '=' id3= Identifier ( whereStatementUpdate )* (id4= ( LogicToken ) ( whereStatementUpdateDuplicate ) )* ;
	public final void updateStatement() throws RecognitionException {
		Token id1=null;
		Token id2=null;
		Token id3=null;
		Token id4=null;

		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:256:2: ( 'UPDATE' id1= Identifier 'Set' id2= Identifier '=' id3= Identifier ( whereStatementUpdate )* (id4= ( LogicToken ) ( whereStatementUpdateDuplicate ) )* )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:256:4: 'UPDATE' id1= Identifier 'Set' id2= Identifier '=' id3= Identifier ( whereStatementUpdate )* (id4= ( LogicToken ) ( whereStatementUpdateDuplicate ) )*
			{
			match(input,48,FOLLOW_48_in_updateStatement527); 
			id1=(Token)match(input,Identifier,FOLLOW_Identifier_in_updateStatement531); 
			ColumnsUpdate.add((id1!=null?id1.getText():null));
			match(input,47,FOLLOW_47_in_updateStatement534); 
			id2=(Token)match(input,Identifier,FOLLOW_Identifier_in_updateStatement538); 
			ColumnsUpdate.add((id2!=null?id2.getText():null));
			match(input,18,FOLLOW_18_in_updateStatement541); 
			id3=(Token)match(input,Identifier,FOLLOW_Identifier_in_updateStatement547); 
			ColumnsUpdate.add((id3!=null?id3.getText():null));
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:258:5: ( whereStatementUpdate )*
			loop16:
			while (true) {
				int alt16=2;
				int LA16_0 = input.LA(1);
				if ( (LA16_0==50) ) {
					alt16=1;
				}

				switch (alt16) {
				case 1 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:258:6: whereStatementUpdate
					{
					pushFollow(FOLLOW_whereStatementUpdate_in_updateStatement556);
					whereStatementUpdate();
					state._fsp--;

					}
					break;

				default :
					break loop16;
				}
			}

			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:258:29: (id4= ( LogicToken ) ( whereStatementUpdateDuplicate ) )*
			loop17:
			while (true) {
				int alt17=2;
				int LA17_0 = input.LA(1);
				if ( (LA17_0==LogicToken) ) {
					alt17=1;
				}

				switch (alt17) {
				case 1 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:258:31: id4= ( LogicToken ) ( whereStatementUpdateDuplicate )
					{
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:258:35: ( LogicToken )
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:258:36: LogicToken
					{
					id4=(Token)match(input,LogicToken,FOLLOW_LogicToken_in_updateStatement565); 
					}

					  ColumnsUpdate.add((id4!=null?id4.getText():null)); 
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:258:82: ( whereStatementUpdateDuplicate )
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:258:83: whereStatementUpdateDuplicate
					{
					pushFollow(FOLLOW_whereStatementUpdateDuplicate_in_updateStatement570);
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
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:268:1: delete : 'DELETE' 'FROM' Identifier ( whereStatementDelete )* (id1= ( LogicToken ) ( whereStatementDeleteDuplicate ) )* ;
	public final void delete() throws RecognitionException {
		Token id1=null;
		Token Identifier7=null;

		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:268:8: ( 'DELETE' 'FROM' Identifier ( whereStatementDelete )* (id1= ( LogicToken ) ( whereStatementDeleteDuplicate ) )* )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:269:3: 'DELETE' 'FROM' Identifier ( whereStatementDelete )* (id1= ( LogicToken ) ( whereStatementDeleteDuplicate ) )*
			{
			match(input,27,FOLLOW_27_in_delete597); 
			match(input,34,FOLLOW_34_in_delete599); 
			Identifier7=(Token)match(input,Identifier,FOLLOW_Identifier_in_delete601); 
			ColumnsDelete.add((Identifier7!=null?Identifier7.getText():null));
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:269:68: ( whereStatementDelete )*
			loop18:
			while (true) {
				int alt18=2;
				int LA18_0 = input.LA(1);
				if ( (LA18_0==50) ) {
					alt18=1;
				}

				switch (alt18) {
				case 1 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:269:69: whereStatementDelete
					{
					pushFollow(FOLLOW_whereStatementDelete_in_delete605);
					whereStatementDelete();
					state._fsp--;

					}
					break;

				default :
					break loop18;
				}
			}

			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:269:93: (id1= ( LogicToken ) ( whereStatementDeleteDuplicate ) )*
			loop19:
			while (true) {
				int alt19=2;
				int LA19_0 = input.LA(1);
				if ( (LA19_0==LogicToken) ) {
					alt19=1;
				}

				switch (alt19) {
				case 1 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:269:95: id1= ( LogicToken ) ( whereStatementDeleteDuplicate )
					{
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:269:99: ( LogicToken )
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:269:100: LogicToken
					{
					id1=(Token)match(input,LogicToken,FOLLOW_LogicToken_in_delete615); 
					}

					  ColumnsDelete.add((id1!=null?id1.getText():null)); 
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:269:146: ( whereStatementDeleteDuplicate )
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:269:147: whereStatementDeleteDuplicate
					{
					pushFollow(FOLLOW_whereStatementDeleteDuplicate_in_delete620);
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
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:276:1: insertInto : 'INSERT INTO' id1= Identifier '(' id2= Identifier ( ',' id3= Identifier )* ')' 'VALUES' '(' id4= ( Identifier ) ( ',' id5= Identifier )* ')' ;
	public final void insertInto() throws RecognitionException {
		Token id1=null;
		Token id2=null;
		Token id3=null;
		Token id4=null;
		Token id5=null;

		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:277:2: ( 'INSERT INTO' id1= Identifier '(' id2= Identifier ( ',' id3= Identifier )* ')' 'VALUES' '(' id4= ( Identifier ) ( ',' id5= Identifier )* ')' )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:277:4: 'INSERT INTO' id1= Identifier '(' id2= Identifier ( ',' id3= Identifier )* ')' 'VALUES' '(' id4= ( Identifier ) ( ',' id5= Identifier )* ')'
			{
			match(input,37,FOLLOW_37_in_insertInto637); 
			id1=(Token)match(input,Identifier,FOLLOW_Identifier_in_insertInto641); 
			ColumnsInsertInto.add((id1!=null?id1.getText():null)); 
			match(input,12,FOLLOW_12_in_insertInto644); 
			id2=(Token)match(input,Identifier,FOLLOW_Identifier_in_insertInto648); 
			ColumnsInsertInto.add((id2!=null?id2.getText():null));
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:277:124: ( ',' id3= Identifier )*
			loop20:
			while (true) {
				int alt20=2;
				int LA20_0 = input.LA(1);
				if ( (LA20_0==15) ) {
					alt20=1;
				}

				switch (alt20) {
				case 1 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:277:125: ',' id3= Identifier
					{
					match(input,15,FOLLOW_15_in_insertInto653); 
					id3=(Token)match(input,Identifier,FOLLOW_Identifier_in_insertInto657); 
					ColumnsInsertInto.add((id3!=null?id3.getText():null));
					}
					break;

				default :
					break loop20;
				}
			}

			match(input,13,FOLLOW_13_in_insertInto664); 
			match(input,49,FOLLOW_49_in_insertInto666); 
			match(input,12,FOLLOW_12_in_insertInto668); 
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:277:204: ( Identifier )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:277:205: Identifier
			{
			id4=(Token)match(input,Identifier,FOLLOW_Identifier_in_insertInto673); 
			}

			 ColumnsInsertInto.add("VALUES");  ColumnsInsertInto.add((id4!=null?id4.getText():null));
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:278:2: ( ',' id5= Identifier )*
			loop21:
			while (true) {
				int alt21=2;
				int LA21_0 = input.LA(1);
				if ( (LA21_0==15) ) {
					alt21=1;
				}

				switch (alt21) {
				case 1 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:278:3: ',' id5= Identifier
					{
					match(input,15,FOLLOW_15_in_insertInto682); 
					id5=(Token)match(input,Identifier,FOLLOW_Identifier_in_insertInto686); 
					ColumnsInsertInto.add((id5!=null?id5.getText():null)); 
					}
					break;

				default :
					break loop21;
				}
			}

			match(input,13,FOLLOW_13_in_insertInto693); 
				
					System.out.println("Verification");
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
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:289:1: whereStatement : 'WHERE' id1= Identifier id2= ( '>' | '<' | '=' | 'like' | 'not' | 'is null' | 'is not null' ) id3= Identifier ;
	public final void whereStatement() throws RecognitionException {
		Token id1=null;
		Token id2=null;
		Token id3=null;

		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:290:2: ( 'WHERE' id1= Identifier id2= ( '>' | '<' | '=' | 'like' | 'not' | 'is null' | 'is not null' ) id3= Identifier )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:290:4: 'WHERE' id1= Identifier id2= ( '>' | '<' | '=' | 'like' | 'not' | 'is null' | 'is not null' ) id3= Identifier
			{
			match(input,50,FOLLOW_50_in_whereStatement715); 
			id1=(Token)match(input,Identifier,FOLLOW_Identifier_in_whereStatement719); 
			id2=input.LT(1);
			if ( (input.LA(1) >= 17 && input.LA(1) <= 19)||(input.LA(1) >= 51 && input.LA(1) <= 54) ) {
				input.consume();
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			id3=(Token)match(input,Identifier,FOLLOW_Identifier_in_whereStatement751); 

					
					ColumnsSelect.add("WHERE");
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
	// $ANTLR end "whereStatement"



	// $ANTLR start "whereStatementAUX"
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:299:1: whereStatementAUX : id1= Identifier id2= ( '>' | '<' | '=' | 'like' | 'not' | 'is null' | 'is not null' ) id3= Identifier ;
	public final void whereStatementAUX() throws RecognitionException {
		Token id1=null;
		Token id2=null;
		Token id3=null;

		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:300:2: (id1= Identifier id2= ( '>' | '<' | '=' | 'like' | 'not' | 'is null' | 'is not null' ) id3= Identifier )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:300:5: id1= Identifier id2= ( '>' | '<' | '=' | 'like' | 'not' | 'is null' | 'is not null' ) id3= Identifier
			{
			id1=(Token)match(input,Identifier,FOLLOW_Identifier_in_whereStatementAUX766); 
			id2=input.LT(1);
			if ( (input.LA(1) >= 17 && input.LA(1) <= 19)||(input.LA(1) >= 51 && input.LA(1) <= 54) ) {
				input.consume();
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			id3=(Token)match(input,Identifier,FOLLOW_Identifier_in_whereStatementAUX798); 

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
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:308:1: whereStatementDuplicate : 'WHERE' id1= Identifier id2= ( '>' | '<' | '=' | 'like' | 'not' | 'is null' | 'is not null' ) id3= Identifier ;
	public final void whereStatementDuplicate() throws RecognitionException {
		Token id1=null;
		Token id2=null;
		Token id3=null;

		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:309:2: ( 'WHERE' id1= Identifier id2= ( '>' | '<' | '=' | 'like' | 'not' | 'is null' | 'is not null' ) id3= Identifier )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:309:4: 'WHERE' id1= Identifier id2= ( '>' | '<' | '=' | 'like' | 'not' | 'is null' | 'is not null' ) id3= Identifier
			{
			match(input,50,FOLLOW_50_in_whereStatementDuplicate812); 
			id1=(Token)match(input,Identifier,FOLLOW_Identifier_in_whereStatementDuplicate816); 
			id2=input.LT(1);
			if ( (input.LA(1) >= 17 && input.LA(1) <= 19)||(input.LA(1) >= 51 && input.LA(1) <= 54) ) {
				input.consume();
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			id3=(Token)match(input,Identifier,FOLLOW_Identifier_in_whereStatementDuplicate848); 
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
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:312:1: whereStatementUpdate : 'WHERE' id1= Identifier id2= ( '>' | '<' | '=' | 'like' | 'not' | 'is null' | 'is not null' ) id3= Identifier ;
	public final void whereStatementUpdate() throws RecognitionException {
		Token id1=null;
		Token id2=null;
		Token id3=null;

		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:313:2: ( 'WHERE' id1= Identifier id2= ( '>' | '<' | '=' | 'like' | 'not' | 'is null' | 'is not null' ) id3= Identifier )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:313:4: 'WHERE' id1= Identifier id2= ( '>' | '<' | '=' | 'like' | 'not' | 'is null' | 'is not null' ) id3= Identifier
			{
			match(input,50,FOLLOW_50_in_whereStatementUpdate861); 
			id1=(Token)match(input,Identifier,FOLLOW_Identifier_in_whereStatementUpdate865); 
			id2=input.LT(1);
			if ( (input.LA(1) >= 17 && input.LA(1) <= 19)||(input.LA(1) >= 51 && input.LA(1) <= 54) ) {
				input.consume();
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			id3=(Token)match(input,Identifier,FOLLOW_Identifier_in_whereStatementUpdate897); 

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
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:321:1: whereStatementUpdateDuplicate : id1= Identifier id2= ( '>' | '<' | '=' | 'like' | 'not' | 'is null' | 'is not null' ) id3= Identifier ;
	public final void whereStatementUpdateDuplicate() throws RecognitionException {
		Token id1=null;
		Token id2=null;
		Token id3=null;

		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:322:2: (id1= Identifier id2= ( '>' | '<' | '=' | 'like' | 'not' | 'is null' | 'is not null' ) id3= Identifier )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:322:5: id1= Identifier id2= ( '>' | '<' | '=' | 'like' | 'not' | 'is null' | 'is not null' ) id3= Identifier
			{
			id1=(Token)match(input,Identifier,FOLLOW_Identifier_in_whereStatementUpdateDuplicate917); 
			id2=input.LT(1);
			if ( (input.LA(1) >= 17 && input.LA(1) <= 19)||(input.LA(1) >= 51 && input.LA(1) <= 54) ) {
				input.consume();
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			id3=(Token)match(input,Identifier,FOLLOW_Identifier_in_whereStatementUpdateDuplicate949); 

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
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:330:1: whereStatementDelete : 'WHERE' id1= Identifier id2= ( '>' | '<' | '=' | 'like' | 'not' | 'is null' | 'is not null' ) id3= Identifier ;
	public final void whereStatementDelete() throws RecognitionException {
		Token id1=null;
		Token id2=null;
		Token id3=null;

		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:331:2: ( 'WHERE' id1= Identifier id2= ( '>' | '<' | '=' | 'like' | 'not' | 'is null' | 'is not null' ) id3= Identifier )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:331:4: 'WHERE' id1= Identifier id2= ( '>' | '<' | '=' | 'like' | 'not' | 'is null' | 'is not null' ) id3= Identifier
			{
			match(input,50,FOLLOW_50_in_whereStatementDelete964); 
			id1=(Token)match(input,Identifier,FOLLOW_Identifier_in_whereStatementDelete968); 
			id2=input.LT(1);
			if ( (input.LA(1) >= 17 && input.LA(1) <= 19)||(input.LA(1) >= 51 && input.LA(1) <= 54) ) {
				input.consume();
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			id3=(Token)match(input,Identifier,FOLLOW_Identifier_in_whereStatementDelete1000); 

				
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
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:340:1: whereStatementDeleteDuplicate : id1= Identifier id2= ( '>' | '<' | '=' | 'like' | 'not' | 'is null' | 'is not null' ) id3= Identifier ;
	public final void whereStatementDeleteDuplicate() throws RecognitionException {
		Token id1=null;
		Token id2=null;
		Token id3=null;

		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:341:2: (id1= Identifier id2= ( '>' | '<' | '=' | 'like' | 'not' | 'is null' | 'is not null' ) id3= Identifier )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:341:5: id1= Identifier id2= ( '>' | '<' | '=' | 'like' | 'not' | 'is null' | 'is not null' ) id3= Identifier
			{
			id1=(Token)match(input,Identifier,FOLLOW_Identifier_in_whereStatementDeleteDuplicate1018); 
			id2=input.LT(1);
			if ( (input.LA(1) >= 17 && input.LA(1) <= 19)||(input.LA(1) >= 51 && input.LA(1) <= 54) ) {
				input.consume();
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			id3=(Token)match(input,Identifier,FOLLOW_Identifier_in_whereStatementDeleteDuplicate1050); 

				
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
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:350:1: joinStatement : 'JOIN' id1= Identifier 'ON' id2= Identifier '.' id3= Identifier '=' id4= Identifier '.' id5= Identifier ;
	public final void joinStatement() throws RecognitionException {
		Token id1=null;
		Token id2=null;
		Token id3=null;
		Token id4=null;
		Token id5=null;

		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:351:2: ( 'JOIN' id1= Identifier 'ON' id2= Identifier '.' id3= Identifier '=' id4= Identifier '.' id5= Identifier )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:351:4: 'JOIN' id1= Identifier 'ON' id2= Identifier '.' id3= Identifier '=' id4= Identifier '.' id5= Identifier
			{
			match(input,38,FOLLOW_38_in_joinStatement1064); 
			id1=(Token)match(input,Identifier,FOLLOW_Identifier_in_joinStatement1068); 
			match(input,40,FOLLOW_40_in_joinStatement1070); 
			id2=(Token)match(input,Identifier,FOLLOW_Identifier_in_joinStatement1074); 
			match(input,16,FOLLOW_16_in_joinStatement1076); 
			id3=(Token)match(input,Identifier,FOLLOW_Identifier_in_joinStatement1080); 
			match(input,18,FOLLOW_18_in_joinStatement1082); 
			id4=(Token)match(input,Identifier,FOLLOW_Identifier_in_joinStatement1086); 
			match(input,16,FOLLOW_16_in_joinStatement1088); 
			id5=(Token)match(input,Identifier,FOLLOW_Identifier_in_joinStatement1092); 

					
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
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:373:1: constraintDefinition : 'FOREIGN KEY' '(' id1= Identifier ')' 'REFERENCES' id2= Identifier '(' id3= Identifier ')' ;
	public final void constraintDefinition() throws RecognitionException {
		Token id1=null;
		Token id2=null;
		Token id3=null;

		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:374:2: ( 'FOREIGN KEY' '(' id1= Identifier ')' 'REFERENCES' id2= Identifier '(' id3= Identifier ')' )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:374:4: 'FOREIGN KEY' '(' id1= Identifier ')' 'REFERENCES' id2= Identifier '(' id3= Identifier ')'
			{
			match(input,33,FOLLOW_33_in_constraintDefinition1158); 
			match(input,12,FOLLOW_12_in_constraintDefinition1160); 
			id1=(Token)match(input,Identifier,FOLLOW_Identifier_in_constraintDefinition1164); 
			match(input,13,FOLLOW_13_in_constraintDefinition1166); 
			match(input,42,FOLLOW_42_in_constraintDefinition1168); 
			id2=(Token)match(input,Identifier,FOLLOW_Identifier_in_constraintDefinition1172); 
			match(input,12,FOLLOW_12_in_constraintDefinition1174); 
			id3=(Token)match(input,Identifier,FOLLOW_Identifier_in_constraintDefinition1178); 
			match(input,13,FOLLOW_13_in_constraintDefinition1180); 

					
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
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:382:1: columnDefinition : Identifier Types Nullability ;
	public final void columnDefinition() throws RecognitionException {
		Token Identifier8=null;
		Token Types9=null;
		Token Nullability10=null;

		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:383:2: ( Identifier Types Nullability )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:383:4: Identifier Types Nullability
			{
			Identifier8=(Token)match(input,Identifier,FOLLOW_Identifier_in_columnDefinition1194); 
			Types9=(Token)match(input,Types,FOLLOW_Types_in_columnDefinition1196); 
			Nullability10=(Token)match(input,Nullability,FOLLOW_Nullability_in_columnDefinition1198); 

				ColumnsCreateTable.add("Column Definition");
				ColumnsCreateTable.add((Identifier8!=null?Identifier8.getText():null));
				ColumnsCreateTable.add((Types9!=null?Types9.getText():null));
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
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:407:1: primaryKey : 'PRIMARY KEY(' Identifier ')' ;
	public final void primaryKey() throws RecognitionException {
		Token Identifier11=null;

		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:408:2: ( 'PRIMARY KEY(' Identifier ')' )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:408:4: 'PRIMARY KEY(' Identifier ')'
			{
			match(input,41,FOLLOW_41_in_primaryKey1295); 
			Identifier11=(Token)match(input,Identifier,FOLLOW_Identifier_in_primaryKey1297); 
			match(input,13,FOLLOW_13_in_primaryKey1299); 

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



	public static final BitSet FOLLOW_script_in_query64 = new BitSet(new long[]{0x000178A87F200002L});
	public static final BitSet FOLLOW_createDB_in_script75 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_dropDB_in_script79 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_listDB_in_script83 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_startDB_in_script86 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_stopDB_in_script92 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_displayDB_in_script96 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_setDB_in_script100 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_createTable_in_script104 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_getStatus_in_script106 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_alterTable_in_script111 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_dropTable_in_script115 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_createIndex_in_script118 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_selectStatement_in_script121 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_updateStatement_in_script125 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_delete_in_script130 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_insertInto_in_script134 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_24_in_createDB147 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_createDB149 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_29_in_dropDB163 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_dropDB165 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_39_in_listDB184 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_45_in_startDB194 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_46_in_stopDB205 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_28_in_displayDB216 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_displayDB218 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_35_in_getStatus232 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_44_in_setDB247 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_setDB251 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_26_in_createTable263 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_createTable265 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_22_in_createTable267 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_12_in_createTable269 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_columnDefinition_in_createTable271 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_15_in_createTable276 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_columnDefinition_in_createTable279 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_15_in_createTable284 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_primaryKey_in_createTable287 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_createTable289 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_21_in_alterTable303 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_alterTable305 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_20_in_alterTable308 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_23_in_alterTable310 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_constraintDefinition_in_alterTable312 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_30_in_dropTable323 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_dropTable325 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_25_in_createIndex342 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_createIndex346 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_40_in_createIndex348 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_createIndex352 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_12_in_createIndex354 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_createIndex357 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_createIndex359 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_43_in_selectStatement376 = new BitSet(new long[]{0x000000040001C050L});
	public static final BitSet FOLLOW_14_in_selectStatement381 = new BitSet(new long[]{0x000000040001C050L});
	public static final BitSet FOLLOW_Identifier_in_selectStatement390 = new BitSet(new long[]{0x0000000400018050L});
	public static final BitSet FOLLOW_16_in_selectStatement395 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_selectStatement399 = new BitSet(new long[]{0x0000000400018010L});
	public static final BitSet FOLLOW_15_in_selectStatement407 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_selectStatement411 = new BitSet(new long[]{0x0000000400018010L});
	public static final BitSet FOLLOW_16_in_selectStatement418 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_selectStatement422 = new BitSet(new long[]{0x0000000400018010L});
	public static final BitSet FOLLOW_15_in_selectStatement429 = new BitSet(new long[]{0x0000000400008010L});
	public static final BitSet FOLLOW_AggregateFunctions_in_selectStatement437 = new BitSet(new long[]{0x0000000400000010L});
	public static final BitSet FOLLOW_34_in_selectStatement442 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_selectStatement446 = new BitSet(new long[]{0x0004005180000102L});
	public static final BitSet FOLLOW_joinStatement_in_selectStatement449 = new BitSet(new long[]{0x0004005180000102L});
	public static final BitSet FOLLOW_whereStatement_in_selectStatement457 = new BitSet(new long[]{0x0004001180000102L});
	public static final BitSet FOLLOW_LogicToken_in_selectStatement466 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_whereStatementAUX_in_selectStatement470 = new BitSet(new long[]{0x0000001180000102L});
	public static final BitSet FOLLOW_36_in_selectStatement480 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_selectStatement484 = new BitSet(new long[]{0x0000001180000002L});
	public static final BitSet FOLLOW_48_in_updateStatement527 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_updateStatement531 = new BitSet(new long[]{0x0000800000000000L});
	public static final BitSet FOLLOW_47_in_updateStatement534 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_updateStatement538 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_18_in_updateStatement541 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_updateStatement547 = new BitSet(new long[]{0x0004000000000102L});
	public static final BitSet FOLLOW_whereStatementUpdate_in_updateStatement556 = new BitSet(new long[]{0x0004000000000102L});
	public static final BitSet FOLLOW_LogicToken_in_updateStatement565 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_whereStatementUpdateDuplicate_in_updateStatement570 = new BitSet(new long[]{0x0000000000000102L});
	public static final BitSet FOLLOW_27_in_delete597 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_34_in_delete599 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_delete601 = new BitSet(new long[]{0x0004000000000102L});
	public static final BitSet FOLLOW_whereStatementDelete_in_delete605 = new BitSet(new long[]{0x0004000000000102L});
	public static final BitSet FOLLOW_LogicToken_in_delete615 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_whereStatementDeleteDuplicate_in_delete620 = new BitSet(new long[]{0x0000000000000102L});
	public static final BitSet FOLLOW_37_in_insertInto637 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_insertInto641 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_12_in_insertInto644 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_insertInto648 = new BitSet(new long[]{0x000000000000A000L});
	public static final BitSet FOLLOW_15_in_insertInto653 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_insertInto657 = new BitSet(new long[]{0x000000000000A000L});
	public static final BitSet FOLLOW_13_in_insertInto664 = new BitSet(new long[]{0x0002000000000000L});
	public static final BitSet FOLLOW_49_in_insertInto666 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_12_in_insertInto668 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_insertInto673 = new BitSet(new long[]{0x000000000000A000L});
	public static final BitSet FOLLOW_15_in_insertInto682 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_insertInto686 = new BitSet(new long[]{0x000000000000A000L});
	public static final BitSet FOLLOW_13_in_insertInto693 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_50_in_whereStatement715 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_whereStatement719 = new BitSet(new long[]{0x00780000000E0000L});
	public static final BitSet FOLLOW_set_in_whereStatement723 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_whereStatement751 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Identifier_in_whereStatementAUX766 = new BitSet(new long[]{0x00780000000E0000L});
	public static final BitSet FOLLOW_set_in_whereStatementAUX770 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_whereStatementAUX798 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_50_in_whereStatementDuplicate812 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_whereStatementDuplicate816 = new BitSet(new long[]{0x00780000000E0000L});
	public static final BitSet FOLLOW_set_in_whereStatementDuplicate820 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_whereStatementDuplicate848 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_50_in_whereStatementUpdate861 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_whereStatementUpdate865 = new BitSet(new long[]{0x00780000000E0000L});
	public static final BitSet FOLLOW_set_in_whereStatementUpdate869 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_whereStatementUpdate897 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Identifier_in_whereStatementUpdateDuplicate917 = new BitSet(new long[]{0x00780000000E0000L});
	public static final BitSet FOLLOW_set_in_whereStatementUpdateDuplicate921 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_whereStatementUpdateDuplicate949 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_50_in_whereStatementDelete964 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_whereStatementDelete968 = new BitSet(new long[]{0x00780000000E0000L});
	public static final BitSet FOLLOW_set_in_whereStatementDelete972 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_whereStatementDelete1000 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Identifier_in_whereStatementDeleteDuplicate1018 = new BitSet(new long[]{0x00780000000E0000L});
	public static final BitSet FOLLOW_set_in_whereStatementDeleteDuplicate1022 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_whereStatementDeleteDuplicate1050 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_38_in_joinStatement1064 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_joinStatement1068 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_40_in_joinStatement1070 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_joinStatement1074 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_joinStatement1076 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_joinStatement1080 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_18_in_joinStatement1082 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_joinStatement1086 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_joinStatement1088 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_joinStatement1092 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_33_in_constraintDefinition1158 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_12_in_constraintDefinition1160 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_constraintDefinition1164 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_constraintDefinition1166 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_42_in_constraintDefinition1168 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_constraintDefinition1172 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_12_in_constraintDefinition1174 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_constraintDefinition1178 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_constraintDefinition1180 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Identifier_in_columnDefinition1194 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_Types_in_columnDefinition1196 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_Nullability_in_columnDefinition1198 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_41_in_primaryKey1295 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_primaryKey1297 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_primaryKey1299 = new BitSet(new long[]{0x0000000000000002L});
}
