// $ANTLR 3.5.1 /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g 2015-09-24 21:37:16

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
		"'GROUP BY'", "'INSERT INTO'", "'JOIN'", "'LIST DATABASES'", "'ON'", "'PRIMARY KEY('", 
		"'REFERENCES'", "'SELECT'", "'SET DATABASE'", "'START'", "'STOP'", "'Set'", 
		"'UPDATE'", "'VALUES'", "'WHERE'", "'is not null'", "'is null'", "'like'", 
		"'not'"
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
		
		
		@Override
		  public void reportError(RecognitionException e) {
			System.out.println("ERROR \n "+e.toString());
		  	//System.out.println("ERROR \n "+e.getMessage());
		  	//mainRuntime.reportedError(e.getMessage());
		       //InError=true; 
		       
		}
	        	
	        	//900 PARA LEXICO
	        	//901 PARA SINTACTICO
	        	
	    


	// $ANTLR start "query"
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:59:1: query : ( script )* ;
	public final void query() throws RecognitionException {
		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:59:7: ( ( script )* )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:60:2: ( script )*
			{
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:60:2: ( script )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==22||(LA1_0 >= 25 && LA1_0 <= 31)||LA1_0==37||LA1_0==39||(LA1_0 >= 43 && LA1_0 <= 46)||LA1_0==48) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:60:2: script
					{
					pushFollow(FOLLOW_script_in_query62);
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
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:62:1: script : ( createDB | dropDB | listDB | startDB | stopDB | displayDB | setDB | createTable | alterTable | dropTable | createIndex | selectStatement | updateStatement | delete | insertInto );
	public final void script() throws RecognitionException {
		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:62:8: ( createDB | dropDB | listDB | startDB | stopDB | displayDB | setDB | createTable | alterTable | dropTable | createIndex | selectStatement | updateStatement | delete | insertInto )
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
			case 29:
				{
				alt2=6;
				}
				break;
			case 44:
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
			case 43:
				{
				alt2=12;
				}
				break;
			case 48:
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
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:63:2: createDB
					{
					pushFollow(FOLLOW_createDB_in_script73);
					createDB();
					state._fsp--;

					}
					break;
				case 2 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:63:13: dropDB
					{
					pushFollow(FOLLOW_dropDB_in_script77);
					dropDB();
					state._fsp--;

					}
					break;
				case 3 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:63:22: listDB
					{
					pushFollow(FOLLOW_listDB_in_script81);
					listDB();
					state._fsp--;

					}
					break;
				case 4 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:63:30: startDB
					{
					pushFollow(FOLLOW_startDB_in_script84);
					startDB();
					state._fsp--;

					}
					break;
				case 5 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:63:42: stopDB
					{
					pushFollow(FOLLOW_stopDB_in_script90);
					stopDB();
					state._fsp--;

					}
					break;
				case 6 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:63:51: displayDB
					{
					pushFollow(FOLLOW_displayDB_in_script94);
					displayDB();
					state._fsp--;

					}
					break;
				case 7 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:63:63: setDB
					{
					pushFollow(FOLLOW_setDB_in_script98);
					setDB();
					state._fsp--;

					}
					break;
				case 8 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:63:71: createTable
					{
					pushFollow(FOLLOW_createTable_in_script102);
					createTable();
					state._fsp--;

					}
					break;
				case 9 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:64:3: alterTable
					{
					pushFollow(FOLLOW_alterTable_in_script107);
					alterTable();
					state._fsp--;

					}
					break;
				case 10 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:64:16: dropTable
					{
					pushFollow(FOLLOW_dropTable_in_script111);
					dropTable();
					state._fsp--;

					}
					break;
				case 11 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:64:27: createIndex
					{
					pushFollow(FOLLOW_createIndex_in_script114);
					createIndex();
					state._fsp--;

					}
					break;
				case 12 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:64:40: selectStatement
					{
					pushFollow(FOLLOW_selectStatement_in_script117);
					selectStatement();
					state._fsp--;

					}
					break;
				case 13 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:64:58: updateStatement
					{
					pushFollow(FOLLOW_updateStatement_in_script121);
					updateStatement();
					state._fsp--;

					}
					break;
				case 14 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:64:77: delete
					{
					pushFollow(FOLLOW_delete_in_script126);
					delete();
					state._fsp--;

					}
					break;
				case 15 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:64:86: insertInto
					{
					pushFollow(FOLLOW_insertInto_in_script130);
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
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:69:1: createDB : 'CREATE DATABASE' Identifier ;
	public final void createDB() throws RecognitionException {
		Token Identifier1=null;

		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:70:2: ( 'CREATE DATABASE' Identifier )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:70:4: 'CREATE DATABASE' Identifier
			{
			match(input,25,FOLLOW_25_in_createDB143); 
			Identifier1=(Token)match(input,Identifier,FOLLOW_Identifier_in_createDB145); 

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
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:80:1: dropDB : 'DROP DATABASE' Identifier ;
	public final void dropDB() throws RecognitionException {
		Token Identifier2=null;

		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:81:2: ( 'DROP DATABASE' Identifier )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:81:4: 'DROP DATABASE' Identifier
			{
			match(input,30,FOLLOW_30_in_dropDB159); 
			Identifier2=(Token)match(input,Identifier,FOLLOW_Identifier_in_dropDB161); 
				
				
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
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:92:1: listDB : 'LIST DATABASES' ;
	public final void listDB() throws RecognitionException {
		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:92:8: ( 'LIST DATABASES' )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:92:10: 'LIST DATABASES'
			{
			match(input,39,FOLLOW_39_in_listDB180); 

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
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:101:1: startDB : 'START' ;
	public final void startDB() throws RecognitionException {
		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:101:9: ( 'START' )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:101:11: 'START'
			{
			match(input,45,FOLLOW_45_in_startDB190); 
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
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:105:1: stopDB : 'STOP' ;
	public final void stopDB() throws RecognitionException {
		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:105:8: ( 'STOP' )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:105:10: 'STOP'
			{
			match(input,46,FOLLOW_46_in_stopDB201); 
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
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:107:1: displayDB : 'DISPLAY DATABASE' Identifier ;
	public final void displayDB() throws RecognitionException {
		Token Identifier3=null;

		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:108:2: ( 'DISPLAY DATABASE' Identifier )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:108:4: 'DISPLAY DATABASE' Identifier
			{
			match(input,29,FOLLOW_29_in_displayDB212); 
			Identifier3=(Token)match(input,Identifier,FOLLOW_Identifier_in_displayDB214); 

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
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:121:1: setDB : 'SET DATABASE' id1= Identifier ;
	public final void setDB() throws RecognitionException {
		Token id1=null;

		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:122:2: ( 'SET DATABASE' id1= Identifier )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:122:4: 'SET DATABASE' id1= Identifier
			{
			match(input,44,FOLLOW_44_in_setDB228); 
			id1=(Token)match(input,Identifier,FOLLOW_Identifier_in_setDB232); 

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
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:132:1: createTable : 'CREATE TABLE' Identifier 'AS' '(' columnDefinition ( ',' columnDefinition )* ',' primaryKey ')' ;
	public final void createTable() throws RecognitionException {
		Token Identifier4=null;

		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:133:2: ( 'CREATE TABLE' Identifier 'AS' '(' columnDefinition ( ',' columnDefinition )* ',' primaryKey ')' )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:133:4: 'CREATE TABLE' Identifier 'AS' '(' columnDefinition ( ',' columnDefinition )* ',' primaryKey ')'
			{
			match(input,27,FOLLOW_27_in_createTable244); 
			Identifier4=(Token)match(input,Identifier,FOLLOW_Identifier_in_createTable246); 
			ColumnsCreateTable.add((Identifier4!=null?Identifier4.getText():null));
			match(input,23,FOLLOW_23_in_createTable248); 
			match(input,13,FOLLOW_13_in_createTable250); 
			pushFollow(FOLLOW_columnDefinition_in_createTable252);
			columnDefinition();
			state._fsp--;

			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:133:100: ( ',' columnDefinition )*
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
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:133:101: ',' columnDefinition
					{
					match(input,16,FOLLOW_16_in_createTable257); 
					pushFollow(FOLLOW_columnDefinition_in_createTable260);
					columnDefinition();
					state._fsp--;

					}
					break;

				default :
					break loop3;
				}
			}

			match(input,16,FOLLOW_16_in_createTable265); 
			pushFollow(FOLLOW_primaryKey_in_createTable268);
			primaryKey();
			state._fsp--;

			match(input,14,FOLLOW_14_in_createTable270); 

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
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:144:1: alterTable : 'ALTER TABLE' Identifier 'ADD' 'CONSTRAINT' constraintDefinition ;
	public final void alterTable() throws RecognitionException {
		Token Identifier5=null;

		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:145:2: ( 'ALTER TABLE' Identifier 'ADD' 'CONSTRAINT' constraintDefinition )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:145:4: 'ALTER TABLE' Identifier 'ADD' 'CONSTRAINT' constraintDefinition
			{
			match(input,22,FOLLOW_22_in_alterTable284); 
			Identifier5=(Token)match(input,Identifier,FOLLOW_Identifier_in_alterTable286); 
			ColumnsAlterTable.add((Identifier5!=null?Identifier5.getText():null));
			match(input,21,FOLLOW_21_in_alterTable289); 
			match(input,24,FOLLOW_24_in_alterTable291); 
			pushFollow(FOLLOW_constraintDefinition_in_alterTable293);
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
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:153:1: dropTable : 'DROP TABLE' Identifier ;
	public final void dropTable() throws RecognitionException {
		Token Identifier6=null;

		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:154:2: ( 'DROP TABLE' Identifier )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:154:4: 'DROP TABLE' Identifier
			{
			match(input,31,FOLLOW_31_in_dropTable304); 
			Identifier6=(Token)match(input,Identifier,FOLLOW_Identifier_in_dropTable306); 

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
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:165:1: createIndex : 'CREATE INDEX' id1= Identifier 'ON' id2= Identifier '(' id3= Identifier ')' ;
	public final void createIndex() throws RecognitionException {
		Token id1=null;
		Token id2=null;
		Token id3=null;

		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:166:2: ( 'CREATE INDEX' id1= Identifier 'ON' id2= Identifier '(' id3= Identifier ')' )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:166:4: 'CREATE INDEX' id1= Identifier 'ON' id2= Identifier '(' id3= Identifier ')'
			{
			match(input,26,FOLLOW_26_in_createIndex323); 
			id1=(Token)match(input,Identifier,FOLLOW_Identifier_in_createIndex327); 
			match(input,40,FOLLOW_40_in_createIndex329); 
			id2=(Token)match(input,Identifier,FOLLOW_Identifier_in_createIndex333); 
			match(input,13,FOLLOW_13_in_createIndex335); 
			id3=(Token)match(input,Identifier,FOLLOW_Identifier_in_createIndex338); 
			match(input,14,FOLLOW_14_in_createIndex340); 

					
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
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:191:1: selectStatement : 'SELECT' id1= ( '*' )* (id2= Identifier ( '.' id3= Identifier )* )* ( ',' id4= Identifier ( '.' id5= Identifier )* )* ( ',' )* (Ag= AggregateFunctions )* 'FROM' fromId= Identifier ( joinStatement )* ( ( whereStatement ) (logic= LogicToken whereStatementAUX )* )* ( 'GROUP BY' id6= Identifier )* ( 'FOR JSON' | 'FOR XML' )* ;
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
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:191:17: ( 'SELECT' id1= ( '*' )* (id2= Identifier ( '.' id3= Identifier )* )* ( ',' id4= Identifier ( '.' id5= Identifier )* )* ( ',' )* (Ag= AggregateFunctions )* 'FROM' fromId= Identifier ( joinStatement )* ( ( whereStatement ) (logic= LogicToken whereStatementAUX )* )* ( 'GROUP BY' id6= Identifier )* ( 'FOR JSON' | 'FOR XML' )* )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:192:3: 'SELECT' id1= ( '*' )* (id2= Identifier ( '.' id3= Identifier )* )* ( ',' id4= Identifier ( '.' id5= Identifier )* )* ( ',' )* (Ag= AggregateFunctions )* 'FROM' fromId= Identifier ( joinStatement )* ( ( whereStatement ) (logic= LogicToken whereStatementAUX )* )* ( 'GROUP BY' id6= Identifier )* ( 'FOR JSON' | 'FOR XML' )*
			{
			match(input,43,FOLLOW_43_in_selectStatement357); 
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:192:16: ( '*' )*
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( (LA4_0==15) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:192:17: '*'
					{
					id1=(Token)match(input,15,FOLLOW_15_in_selectStatement362); 
					}
					break;

				default :
					break loop4;
				}
			}

			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:192:24: (id2= Identifier ( '.' id3= Identifier )* )*
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( (LA6_0==Identifier) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:192:26: id2= Identifier ( '.' id3= Identifier )*
					{
					id2=(Token)match(input,Identifier,FOLLOW_Identifier_in_selectStatement371); 
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:192:41: ( '.' id3= Identifier )*
					loop5:
					while (true) {
						int alt5=2;
						int LA5_0 = input.LA(1);
						if ( (LA5_0==17) ) {
							alt5=1;
						}

						switch (alt5) {
						case 1 :
							// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:192:42: '.' id3= Identifier
							{
							match(input,17,FOLLOW_17_in_selectStatement374); 
							id3=(Token)match(input,Identifier,FOLLOW_Identifier_in_selectStatement378); 
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

			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:192:68: ( ',' id4= Identifier ( '.' id5= Identifier )* )*
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
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:192:69: ',' id4= Identifier ( '.' id5= Identifier )*
					{
					match(input,16,FOLLOW_16_in_selectStatement388); 
					id4=(Token)match(input,Identifier,FOLLOW_Identifier_in_selectStatement392); 
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:192:88: ( '.' id5= Identifier )*
					loop7:
					while (true) {
						int alt7=2;
						int LA7_0 = input.LA(1);
						if ( (LA7_0==17) ) {
							alt7=1;
						}

						switch (alt7) {
						case 1 :
							// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:192:89: '.' id5= Identifier
							{
							match(input,17,FOLLOW_17_in_selectStatement395); 
							id5=(Token)match(input,Identifier,FOLLOW_Identifier_in_selectStatement399); 
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

			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:192:118: ( ',' )*
			loop9:
			while (true) {
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( (LA9_0==16) ) {
					alt9=1;
				}

				switch (alt9) {
				case 1 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:192:119: ','
					{
					match(input,16,FOLLOW_16_in_selectStatement412); 
					}
					break;

				default :
					break loop9;
				}
			}

			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:192:126: (Ag= AggregateFunctions )*
			loop10:
			while (true) {
				int alt10=2;
				int LA10_0 = input.LA(1);
				if ( (LA10_0==AggregateFunctions) ) {
					alt10=1;
				}

				switch (alt10) {
				case 1 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:192:127: Ag= AggregateFunctions
					{
					Ag=(Token)match(input,AggregateFunctions,FOLLOW_AggregateFunctions_in_selectStatement420); 
					}
					break;

				default :
					break loop10;
				}
			}

			match(input,35,FOLLOW_35_in_selectStatement425); 
			fromId=(Token)match(input,Identifier,FOLLOW_Identifier_in_selectStatement429); 
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:192:177: ( joinStatement )*
			loop11:
			while (true) {
				int alt11=2;
				int LA11_0 = input.LA(1);
				if ( (LA11_0==38) ) {
					alt11=1;
				}

				switch (alt11) {
				case 1 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:192:178: joinStatement
					{
					pushFollow(FOLLOW_joinStatement_in_selectStatement432);
					joinStatement();
					state._fsp--;

					}
					break;

				default :
					break loop11;
				}
			}

			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:193:3: ( ( whereStatement ) (logic= LogicToken whereStatementAUX )* )*
			loop13:
			while (true) {
				int alt13=2;
				int LA13_0 = input.LA(1);
				if ( (LA13_0==50) ) {
					alt13=1;
				}

				switch (alt13) {
				case 1 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:193:5: ( whereStatement ) (logic= LogicToken whereStatementAUX )*
					{
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:193:5: ( whereStatement )
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:193:6: whereStatement
					{
					pushFollow(FOLLOW_whereStatement_in_selectStatement441);
					whereStatement();
					state._fsp--;

					}

					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:193:23: (logic= LogicToken whereStatementAUX )*
					loop12:
					while (true) {
						int alt12=2;
						int LA12_0 = input.LA(1);
						if ( (LA12_0==LogicToken) ) {
							alt12=1;
						}

						switch (alt12) {
						case 1 :
							// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:193:25: logic= LogicToken whereStatementAUX
							{
							logic=(Token)match(input,LogicToken,FOLLOW_LogicToken_in_selectStatement449); 
							 ColumnsSelect.add((logic!=null?logic.getText():null));   
							pushFollow(FOLLOW_whereStatementAUX_in_selectStatement453);
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

			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:193:107: ( 'GROUP BY' id6= Identifier )*
			loop14:
			while (true) {
				int alt14=2;
				int LA14_0 = input.LA(1);
				if ( (LA14_0==36) ) {
					alt14=1;
				}

				switch (alt14) {
				case 1 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:193:108: 'GROUP BY' id6= Identifier
					{
					match(input,36,FOLLOW_36_in_selectStatement465); 
					id6=(Token)match(input,Identifier,FOLLOW_Identifier_in_selectStatement469); 
					}
					break;

				default :
					break loop14;
				}
			}

			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:193:136: ( 'FOR JSON' | 'FOR XML' )*
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
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:238:1: updateStatement : 'UPDATE' id1= Identifier 'Set' id2= Identifier '=' id3= Identifier ( whereStatementUpdate )* (id4= ( LogicToken ) ( whereStatementUpdateDuplicate ) )* ;
	public final void updateStatement() throws RecognitionException {
		Token id1=null;
		Token id2=null;
		Token id3=null;
		Token id4=null;

		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:239:2: ( 'UPDATE' id1= Identifier 'Set' id2= Identifier '=' id3= Identifier ( whereStatementUpdate )* (id4= ( LogicToken ) ( whereStatementUpdateDuplicate ) )* )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:239:4: 'UPDATE' id1= Identifier 'Set' id2= Identifier '=' id3= Identifier ( whereStatementUpdate )* (id4= ( LogicToken ) ( whereStatementUpdateDuplicate ) )*
			{
			match(input,48,FOLLOW_48_in_updateStatement510); 
			id1=(Token)match(input,Identifier,FOLLOW_Identifier_in_updateStatement514); 
			ColumnsUpdate.add((id1!=null?id1.getText():null));
			match(input,47,FOLLOW_47_in_updateStatement517); 
			id2=(Token)match(input,Identifier,FOLLOW_Identifier_in_updateStatement521); 
			ColumnsUpdate.add((id2!=null?id2.getText():null));
			match(input,19,FOLLOW_19_in_updateStatement524); 
			id3=(Token)match(input,Identifier,FOLLOW_Identifier_in_updateStatement530); 
			ColumnsUpdate.add((id3!=null?id3.getText():null));
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:241:5: ( whereStatementUpdate )*
			loop16:
			while (true) {
				int alt16=2;
				int LA16_0 = input.LA(1);
				if ( (LA16_0==50) ) {
					alt16=1;
				}

				switch (alt16) {
				case 1 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:241:6: whereStatementUpdate
					{
					pushFollow(FOLLOW_whereStatementUpdate_in_updateStatement539);
					whereStatementUpdate();
					state._fsp--;

					}
					break;

				default :
					break loop16;
				}
			}

			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:241:29: (id4= ( LogicToken ) ( whereStatementUpdateDuplicate ) )*
			loop17:
			while (true) {
				int alt17=2;
				int LA17_0 = input.LA(1);
				if ( (LA17_0==LogicToken) ) {
					alt17=1;
				}

				switch (alt17) {
				case 1 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:241:31: id4= ( LogicToken ) ( whereStatementUpdateDuplicate )
					{
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:241:35: ( LogicToken )
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:241:36: LogicToken
					{
					id4=(Token)match(input,LogicToken,FOLLOW_LogicToken_in_updateStatement548); 
					}

					  ColumnsUpdate.add((id4!=null?id4.getText():null)); 
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:241:82: ( whereStatementUpdateDuplicate )
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:241:83: whereStatementUpdateDuplicate
					{
					pushFollow(FOLLOW_whereStatementUpdateDuplicate_in_updateStatement553);
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
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:251:1: delete : 'DELETE' 'FROM' Identifier ( whereStatementDelete )* (id1= ( LogicToken ) ( whereStatementDeleteDuplicate ) )* ;
	public final void delete() throws RecognitionException {
		Token id1=null;
		Token Identifier7=null;

		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:251:8: ( 'DELETE' 'FROM' Identifier ( whereStatementDelete )* (id1= ( LogicToken ) ( whereStatementDeleteDuplicate ) )* )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:252:3: 'DELETE' 'FROM' Identifier ( whereStatementDelete )* (id1= ( LogicToken ) ( whereStatementDeleteDuplicate ) )*
			{
			match(input,28,FOLLOW_28_in_delete580); 
			match(input,35,FOLLOW_35_in_delete582); 
			Identifier7=(Token)match(input,Identifier,FOLLOW_Identifier_in_delete584); 
			ColumnsDelete.add((Identifier7!=null?Identifier7.getText():null));
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:252:68: ( whereStatementDelete )*
			loop18:
			while (true) {
				int alt18=2;
				int LA18_0 = input.LA(1);
				if ( (LA18_0==50) ) {
					alt18=1;
				}

				switch (alt18) {
				case 1 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:252:69: whereStatementDelete
					{
					pushFollow(FOLLOW_whereStatementDelete_in_delete588);
					whereStatementDelete();
					state._fsp--;

					}
					break;

				default :
					break loop18;
				}
			}

			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:252:93: (id1= ( LogicToken ) ( whereStatementDeleteDuplicate ) )*
			loop19:
			while (true) {
				int alt19=2;
				int LA19_0 = input.LA(1);
				if ( (LA19_0==LogicToken) ) {
					alt19=1;
				}

				switch (alt19) {
				case 1 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:252:95: id1= ( LogicToken ) ( whereStatementDeleteDuplicate )
					{
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:252:99: ( LogicToken )
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:252:100: LogicToken
					{
					id1=(Token)match(input,LogicToken,FOLLOW_LogicToken_in_delete598); 
					}

					  ColumnsDelete.add((id1!=null?id1.getText():null)); 
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:252:146: ( whereStatementDeleteDuplicate )
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:252:147: whereStatementDeleteDuplicate
					{
					pushFollow(FOLLOW_whereStatementDeleteDuplicate_in_delete603);
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
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:259:1: insertInto : 'INSERT INTO' id1= Identifier '(' id2= Identifier ( ',' id3= Identifier )* ')' 'VALUES' '(' id4= ( Identifier | Number ) ( ',' id5= ( Identifier | Number ) )* ')' ;
	public final void insertInto() throws RecognitionException {
		Token id1=null;
		Token id2=null;
		Token id3=null;
		Token id4=null;
		Token id5=null;

		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:260:2: ( 'INSERT INTO' id1= Identifier '(' id2= Identifier ( ',' id3= Identifier )* ')' 'VALUES' '(' id4= ( Identifier | Number ) ( ',' id5= ( Identifier | Number ) )* ')' )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:260:4: 'INSERT INTO' id1= Identifier '(' id2= Identifier ( ',' id3= Identifier )* ')' 'VALUES' '(' id4= ( Identifier | Number ) ( ',' id5= ( Identifier | Number ) )* ')'
			{
			match(input,37,FOLLOW_37_in_insertInto620); 
			id1=(Token)match(input,Identifier,FOLLOW_Identifier_in_insertInto624); 
			ColumnsInsertInto.add((id1!=null?id1.getText():null)); 
			match(input,13,FOLLOW_13_in_insertInto627); 
			id2=(Token)match(input,Identifier,FOLLOW_Identifier_in_insertInto631); 
			ColumnsInsertInto.add((id2!=null?id2.getText():null));
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:260:124: ( ',' id3= Identifier )*
			loop20:
			while (true) {
				int alt20=2;
				int LA20_0 = input.LA(1);
				if ( (LA20_0==16) ) {
					alt20=1;
				}

				switch (alt20) {
				case 1 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:260:125: ',' id3= Identifier
					{
					match(input,16,FOLLOW_16_in_insertInto636); 
					id3=(Token)match(input,Identifier,FOLLOW_Identifier_in_insertInto640); 
					ColumnsInsertInto.add((id3!=null?id3.getText():null));
					}
					break;

				default :
					break loop20;
				}
			}

			match(input,14,FOLLOW_14_in_insertInto647); 
			match(input,49,FOLLOW_49_in_insertInto649); 
			match(input,13,FOLLOW_13_in_insertInto651); 
			id4=input.LT(1);
			if ( input.LA(1)==Identifier||input.LA(1)==Number ) {
				input.consume();
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			 ColumnsInsertInto.add("VALUES");  ColumnsInsertInto.add((id4!=null?id4.getText():null));
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:261:2: ( ',' id5= ( Identifier | Number ) )*
			loop21:
			while (true) {
				int alt21=2;
				int LA21_0 = input.LA(1);
				if ( (LA21_0==16) ) {
					alt21=1;
				}

				switch (alt21) {
				case 1 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:261:3: ',' id5= ( Identifier | Number )
					{
					match(input,16,FOLLOW_16_in_insertInto666); 
					id5=input.LT(1);
					if ( input.LA(1)==Identifier||input.LA(1)==Number ) {
						input.consume();
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					ColumnsInsertInto.add((id5!=null?id5.getText():null)); 
					}
					break;

				default :
					break loop21;
				}
			}

			match(input,14,FOLLOW_14_in_insertInto680); 
				
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
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:272:1: whereStatement : 'WHERE' id1= Identifier id2= ( '>' | '<' | '=' | 'like' | 'not' | 'is null' | 'is not null' ) id3= ( Identifier | Number )* ;
	public final void whereStatement() throws RecognitionException {
		Token id1=null;
		Token id2=null;
		Token id3=null;

		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:273:2: ( 'WHERE' id1= Identifier id2= ( '>' | '<' | '=' | 'like' | 'not' | 'is null' | 'is not null' ) id3= ( Identifier | Number )* )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:273:4: 'WHERE' id1= Identifier id2= ( '>' | '<' | '=' | 'like' | 'not' | 'is null' | 'is not null' ) id3= ( Identifier | Number )*
			{
			match(input,50,FOLLOW_50_in_whereStatement702); 
			id1=(Token)match(input,Identifier,FOLLOW_Identifier_in_whereStatement706); 
			id2=input.LT(1);
			if ( (input.LA(1) >= 18 && input.LA(1) <= 20)||(input.LA(1) >= 51 && input.LA(1) <= 54) ) {
				input.consume();
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:273:96: ( Identifier | Number )*
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
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:290:1: whereStatementAUX : id1= Identifier id2= ( '>' | '<' | '=' | 'like' | 'not' | 'is null' | 'is not null' ) id3= ( Identifier | Number ) ;
	public final void whereStatementAUX() throws RecognitionException {
		Token id1=null;
		Token id2=null;
		Token id3=null;

		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:291:2: (id1= Identifier id2= ( '>' | '<' | '=' | 'like' | 'not' | 'is null' | 'is not null' ) id3= ( Identifier | Number ) )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:291:5: id1= Identifier id2= ( '>' | '<' | '=' | 'like' | 'not' | 'is null' | 'is not null' ) id3= ( Identifier | Number )
			{
			id1=(Token)match(input,Identifier,FOLLOW_Identifier_in_whereStatementAUX758); 
			id2=input.LT(1);
			if ( (input.LA(1) >= 18 && input.LA(1) <= 20)||(input.LA(1) >= 51 && input.LA(1) <= 54) ) {
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
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:299:1: whereStatementDuplicate : 'WHERE' id1= Identifier id2= ( '>' | '<' | '=' | 'like' | 'not' | 'is null' | 'is not null' ) id3= ( Identifier | Number ) ;
	public final void whereStatementDuplicate() throws RecognitionException {
		Token id1=null;
		Token id2=null;
		Token id3=null;

		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:300:2: ( 'WHERE' id1= Identifier id2= ( '>' | '<' | '=' | 'like' | 'not' | 'is null' | 'is not null' ) id3= ( Identifier | Number ) )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:300:4: 'WHERE' id1= Identifier id2= ( '>' | '<' | '=' | 'like' | 'not' | 'is null' | 'is not null' ) id3= ( Identifier | Number )
			{
			match(input,50,FOLLOW_50_in_whereStatementDuplicate808); 
			id1=(Token)match(input,Identifier,FOLLOW_Identifier_in_whereStatementDuplicate812); 
			id2=input.LT(1);
			if ( (input.LA(1) >= 18 && input.LA(1) <= 20)||(input.LA(1) >= 51 && input.LA(1) <= 54) ) {
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
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:303:1: whereStatementUpdate : 'WHERE' id1= Identifier id2= ( '>' | '<' | '=' | 'like' | 'not' | 'is null' | 'is not null' ) id3= ( Identifier | Number ) ;
	public final void whereStatementUpdate() throws RecognitionException {
		Token id1=null;
		Token id2=null;
		Token id3=null;

		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:304:2: ( 'WHERE' id1= Identifier id2= ( '>' | '<' | '=' | 'like' | 'not' | 'is null' | 'is not null' ) id3= ( Identifier | Number ) )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:304:4: 'WHERE' id1= Identifier id2= ( '>' | '<' | '=' | 'like' | 'not' | 'is null' | 'is not null' ) id3= ( Identifier | Number )
			{
			match(input,50,FOLLOW_50_in_whereStatementUpdate861); 
			id1=(Token)match(input,Identifier,FOLLOW_Identifier_in_whereStatementUpdate865); 
			id2=input.LT(1);
			if ( (input.LA(1) >= 18 && input.LA(1) <= 20)||(input.LA(1) >= 51 && input.LA(1) <= 54) ) {
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
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:312:1: whereStatementUpdateDuplicate : id1= Identifier id2= ( '>' | '<' | '=' | 'like' | 'not' | 'is null' | 'is not null' ) id3= ( Identifier | Number ) ;
	public final void whereStatementUpdateDuplicate() throws RecognitionException {
		Token id1=null;
		Token id2=null;
		Token id3=null;

		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:313:2: (id1= Identifier id2= ( '>' | '<' | '=' | 'like' | 'not' | 'is null' | 'is not null' ) id3= ( Identifier | Number ) )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:313:5: id1= Identifier id2= ( '>' | '<' | '=' | 'like' | 'not' | 'is null' | 'is not null' ) id3= ( Identifier | Number )
			{
			id1=(Token)match(input,Identifier,FOLLOW_Identifier_in_whereStatementUpdateDuplicate921); 
			id2=input.LT(1);
			if ( (input.LA(1) >= 18 && input.LA(1) <= 20)||(input.LA(1) >= 51 && input.LA(1) <= 54) ) {
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
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:321:1: whereStatementDelete : 'WHERE' id1= Identifier id2= ( '>' | '<' | '=' | 'like' | 'not' | 'is null' | 'is not null' ) id3= ( Identifier | Number ) ;
	public final void whereStatementDelete() throws RecognitionException {
		Token id1=null;
		Token id2=null;
		Token id3=null;

		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:322:2: ( 'WHERE' id1= Identifier id2= ( '>' | '<' | '=' | 'like' | 'not' | 'is null' | 'is not null' ) id3= ( Identifier | Number ) )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:322:4: 'WHERE' id1= Identifier id2= ( '>' | '<' | '=' | 'like' | 'not' | 'is null' | 'is not null' ) id3= ( Identifier | Number )
			{
			match(input,50,FOLLOW_50_in_whereStatementDelete972); 
			id1=(Token)match(input,Identifier,FOLLOW_Identifier_in_whereStatementDelete976); 
			id2=input.LT(1);
			if ( (input.LA(1) >= 18 && input.LA(1) <= 20)||(input.LA(1) >= 51 && input.LA(1) <= 54) ) {
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
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:331:1: whereStatementDeleteDuplicate : id1= Identifier id2= ( '>' | '<' | '=' | 'like' | 'not' | 'is null' | 'is not null' ) id3= ( Identifier | Number ) ;
	public final void whereStatementDeleteDuplicate() throws RecognitionException {
		Token id1=null;
		Token id2=null;
		Token id3=null;

		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:332:2: (id1= Identifier id2= ( '>' | '<' | '=' | 'like' | 'not' | 'is null' | 'is not null' ) id3= ( Identifier | Number ) )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:332:5: id1= Identifier id2= ( '>' | '<' | '=' | 'like' | 'not' | 'is null' | 'is not null' ) id3= ( Identifier | Number )
			{
			id1=(Token)match(input,Identifier,FOLLOW_Identifier_in_whereStatementDeleteDuplicate1031); 
			id2=input.LT(1);
			if ( (input.LA(1) >= 18 && input.LA(1) <= 20)||(input.LA(1) >= 51 && input.LA(1) <= 54) ) {
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
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:341:1: joinStatement : 'JOIN' id1= Identifier 'ON' id2= Identifier '.' id3= Identifier '=' id4= Identifier '.' id5= Identifier ;
	public final void joinStatement() throws RecognitionException {
		Token id1=null;
		Token id2=null;
		Token id3=null;
		Token id4=null;
		Token id5=null;

		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:342:2: ( 'JOIN' id1= Identifier 'ON' id2= Identifier '.' id3= Identifier '=' id4= Identifier '.' id5= Identifier )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:342:4: 'JOIN' id1= Identifier 'ON' id2= Identifier '.' id3= Identifier '=' id4= Identifier '.' id5= Identifier
			{
			match(input,38,FOLLOW_38_in_joinStatement1082); 
			id1=(Token)match(input,Identifier,FOLLOW_Identifier_in_joinStatement1086); 
			match(input,40,FOLLOW_40_in_joinStatement1088); 
			id2=(Token)match(input,Identifier,FOLLOW_Identifier_in_joinStatement1092); 
			match(input,17,FOLLOW_17_in_joinStatement1094); 
			id3=(Token)match(input,Identifier,FOLLOW_Identifier_in_joinStatement1098); 
			match(input,19,FOLLOW_19_in_joinStatement1100); 
			id4=(Token)match(input,Identifier,FOLLOW_Identifier_in_joinStatement1104); 
			match(input,17,FOLLOW_17_in_joinStatement1106); 
			id5=(Token)match(input,Identifier,FOLLOW_Identifier_in_joinStatement1110); 

					
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
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:364:1: constraintDefinition : 'FOREIGN KEY' '(' id1= Identifier ')' 'REFERENCES' id2= Identifier '(' id3= Identifier ')' ;
	public final void constraintDefinition() throws RecognitionException {
		Token id1=null;
		Token id2=null;
		Token id3=null;

		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:365:2: ( 'FOREIGN KEY' '(' id1= Identifier ')' 'REFERENCES' id2= Identifier '(' id3= Identifier ')' )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:365:4: 'FOREIGN KEY' '(' id1= Identifier ')' 'REFERENCES' id2= Identifier '(' id3= Identifier ')'
			{
			match(input,34,FOLLOW_34_in_constraintDefinition1176); 
			match(input,13,FOLLOW_13_in_constraintDefinition1178); 
			id1=(Token)match(input,Identifier,FOLLOW_Identifier_in_constraintDefinition1182); 
			match(input,14,FOLLOW_14_in_constraintDefinition1184); 
			match(input,42,FOLLOW_42_in_constraintDefinition1186); 
			id2=(Token)match(input,Identifier,FOLLOW_Identifier_in_constraintDefinition1190); 
			match(input,13,FOLLOW_13_in_constraintDefinition1192); 
			id3=(Token)match(input,Identifier,FOLLOW_Identifier_in_constraintDefinition1196); 
			match(input,14,FOLLOW_14_in_constraintDefinition1198); 

					
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
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:373:1: columnDefinition : Identifier Type Nullability ;
	public final void columnDefinition() throws RecognitionException {
		Token Identifier8=null;
		Token Type9=null;
		Token Nullability10=null;

		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:374:2: ( Identifier Type Nullability )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:374:4: Identifier Type Nullability
			{
			Identifier8=(Token)match(input,Identifier,FOLLOW_Identifier_in_columnDefinition1212); 
			Type9=(Token)match(input,Type,FOLLOW_Type_in_columnDefinition1214); 
			Nullability10=(Token)match(input,Nullability,FOLLOW_Nullability_in_columnDefinition1216); 

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
	// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:398:1: primaryKey : 'PRIMARY KEY(' Identifier ')' ;
	public final void primaryKey() throws RecognitionException {
		Token Identifier11=null;

		try {
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:399:2: ( 'PRIMARY KEY(' Identifier ')' )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:399:4: 'PRIMARY KEY(' Identifier ')'
			{
			match(input,41,FOLLOW_41_in_primaryKey1287); 
			Identifier11=(Token)match(input,Identifier,FOLLOW_Identifier_in_primaryKey1289); 
			match(input,14,FOLLOW_14_in_primaryKey1291); 

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



	public static final BitSet FOLLOW_script_in_query62 = new BitSet(new long[]{0x000178A0FE400002L});
	public static final BitSet FOLLOW_createDB_in_script73 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_dropDB_in_script77 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_listDB_in_script81 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_startDB_in_script84 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_stopDB_in_script90 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_displayDB_in_script94 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_setDB_in_script98 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_createTable_in_script102 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_alterTable_in_script107 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_dropTable_in_script111 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_createIndex_in_script114 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_selectStatement_in_script117 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_updateStatement_in_script121 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_delete_in_script126 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_insertInto_in_script130 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_25_in_createDB143 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_createDB145 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_30_in_dropDB159 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_dropDB161 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_39_in_listDB180 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_45_in_startDB190 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_46_in_stopDB201 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_29_in_displayDB212 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_displayDB214 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_44_in_setDB228 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_setDB232 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_27_in_createTable244 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_createTable246 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_23_in_createTable248 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_createTable250 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_columnDefinition_in_createTable252 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_createTable257 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_columnDefinition_in_createTable260 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_createTable265 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_primaryKey_in_createTable268 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_14_in_createTable270 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_22_in_alterTable284 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_alterTable286 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_21_in_alterTable289 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_24_in_alterTable291 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_constraintDefinition_in_alterTable293 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_31_in_dropTable304 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_dropTable306 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_26_in_createIndex323 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_createIndex327 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_40_in_createIndex329 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_createIndex333 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_createIndex335 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_createIndex338 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_14_in_createIndex340 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_43_in_selectStatement357 = new BitSet(new long[]{0x0000000800018050L});
	public static final BitSet FOLLOW_15_in_selectStatement362 = new BitSet(new long[]{0x0000000800018050L});
	public static final BitSet FOLLOW_Identifier_in_selectStatement371 = new BitSet(new long[]{0x0000000800030050L});
	public static final BitSet FOLLOW_17_in_selectStatement374 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_selectStatement378 = new BitSet(new long[]{0x0000000800030050L});
	public static final BitSet FOLLOW_16_in_selectStatement388 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_selectStatement392 = new BitSet(new long[]{0x0000000800030010L});
	public static final BitSet FOLLOW_17_in_selectStatement395 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_selectStatement399 = new BitSet(new long[]{0x0000000800030010L});
	public static final BitSet FOLLOW_16_in_selectStatement412 = new BitSet(new long[]{0x0000000800010010L});
	public static final BitSet FOLLOW_AggregateFunctions_in_selectStatement420 = new BitSet(new long[]{0x0000000800000010L});
	public static final BitSet FOLLOW_35_in_selectStatement425 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_selectStatement429 = new BitSet(new long[]{0x0004005300000002L});
	public static final BitSet FOLLOW_joinStatement_in_selectStatement432 = new BitSet(new long[]{0x0004005300000002L});
	public static final BitSet FOLLOW_whereStatement_in_selectStatement441 = new BitSet(new long[]{0x0004001300000102L});
	public static final BitSet FOLLOW_LogicToken_in_selectStatement449 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_whereStatementAUX_in_selectStatement453 = new BitSet(new long[]{0x0004001300000102L});
	public static final BitSet FOLLOW_36_in_selectStatement465 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_selectStatement469 = new BitSet(new long[]{0x0000001300000002L});
	public static final BitSet FOLLOW_48_in_updateStatement510 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_updateStatement514 = new BitSet(new long[]{0x0000800000000000L});
	public static final BitSet FOLLOW_47_in_updateStatement517 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_updateStatement521 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_19_in_updateStatement524 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_updateStatement530 = new BitSet(new long[]{0x0004000000000102L});
	public static final BitSet FOLLOW_whereStatementUpdate_in_updateStatement539 = new BitSet(new long[]{0x0004000000000102L});
	public static final BitSet FOLLOW_LogicToken_in_updateStatement548 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_whereStatementUpdateDuplicate_in_updateStatement553 = new BitSet(new long[]{0x0000000000000102L});
	public static final BitSet FOLLOW_28_in_delete580 = new BitSet(new long[]{0x0000000800000000L});
	public static final BitSet FOLLOW_35_in_delete582 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_delete584 = new BitSet(new long[]{0x0004000000000102L});
	public static final BitSet FOLLOW_whereStatementDelete_in_delete588 = new BitSet(new long[]{0x0004000000000102L});
	public static final BitSet FOLLOW_LogicToken_in_delete598 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_whereStatementDeleteDuplicate_in_delete603 = new BitSet(new long[]{0x0000000000000102L});
	public static final BitSet FOLLOW_37_in_insertInto620 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_insertInto624 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_insertInto627 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_insertInto631 = new BitSet(new long[]{0x0000000000014000L});
	public static final BitSet FOLLOW_16_in_insertInto636 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_insertInto640 = new BitSet(new long[]{0x0000000000014000L});
	public static final BitSet FOLLOW_14_in_insertInto647 = new BitSet(new long[]{0x0002000000000000L});
	public static final BitSet FOLLOW_49_in_insertInto649 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_insertInto651 = new BitSet(new long[]{0x0000000000000440L});
	public static final BitSet FOLLOW_set_in_insertInto655 = new BitSet(new long[]{0x0000000000014000L});
	public static final BitSet FOLLOW_16_in_insertInto666 = new BitSet(new long[]{0x0000000000000440L});
	public static final BitSet FOLLOW_set_in_insertInto670 = new BitSet(new long[]{0x0000000000014000L});
	public static final BitSet FOLLOW_14_in_insertInto680 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_50_in_whereStatement702 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_whereStatement706 = new BitSet(new long[]{0x00780000001C0000L});
	public static final BitSet FOLLOW_set_in_whereStatement710 = new BitSet(new long[]{0x0000000000000442L});
	public static final BitSet FOLLOW_Identifier_in_whereStatementAUX758 = new BitSet(new long[]{0x00780000001C0000L});
	public static final BitSet FOLLOW_set_in_whereStatementAUX762 = new BitSet(new long[]{0x0000000000000440L});
	public static final BitSet FOLLOW_set_in_whereStatementAUX790 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_50_in_whereStatementDuplicate808 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_whereStatementDuplicate812 = new BitSet(new long[]{0x00780000001C0000L});
	public static final BitSet FOLLOW_set_in_whereStatementDuplicate816 = new BitSet(new long[]{0x0000000000000440L});
	public static final BitSet FOLLOW_set_in_whereStatementDuplicate844 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_50_in_whereStatementUpdate861 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_whereStatementUpdate865 = new BitSet(new long[]{0x00780000001C0000L});
	public static final BitSet FOLLOW_set_in_whereStatementUpdate869 = new BitSet(new long[]{0x0000000000000440L});
	public static final BitSet FOLLOW_set_in_whereStatementUpdate897 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Identifier_in_whereStatementUpdateDuplicate921 = new BitSet(new long[]{0x00780000001C0000L});
	public static final BitSet FOLLOW_set_in_whereStatementUpdateDuplicate925 = new BitSet(new long[]{0x0000000000000440L});
	public static final BitSet FOLLOW_set_in_whereStatementUpdateDuplicate953 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_50_in_whereStatementDelete972 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_whereStatementDelete976 = new BitSet(new long[]{0x00780000001C0000L});
	public static final BitSet FOLLOW_set_in_whereStatementDelete980 = new BitSet(new long[]{0x0000000000000440L});
	public static final BitSet FOLLOW_set_in_whereStatementDelete1008 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Identifier_in_whereStatementDeleteDuplicate1031 = new BitSet(new long[]{0x00780000001C0000L});
	public static final BitSet FOLLOW_set_in_whereStatementDeleteDuplicate1035 = new BitSet(new long[]{0x0000000000000440L});
	public static final BitSet FOLLOW_set_in_whereStatementDeleteDuplicate1063 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_38_in_joinStatement1082 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_joinStatement1086 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_40_in_joinStatement1088 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_joinStatement1092 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_17_in_joinStatement1094 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_joinStatement1098 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_19_in_joinStatement1100 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_joinStatement1104 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_17_in_joinStatement1106 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_joinStatement1110 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_34_in_constraintDefinition1176 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_constraintDefinition1178 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_constraintDefinition1182 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_14_in_constraintDefinition1184 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_42_in_constraintDefinition1186 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_constraintDefinition1190 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_constraintDefinition1192 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_constraintDefinition1196 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_14_in_constraintDefinition1198 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Identifier_in_columnDefinition1212 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_Type_in_columnDefinition1214 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_Nullability_in_columnDefinition1216 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_41_in_primaryKey1287 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_primaryKey1289 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_14_in_primaryKey1291 = new BitSet(new long[]{0x0000000000000002L});
}
