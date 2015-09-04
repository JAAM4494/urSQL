// $ANTLR 3.5.1 /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g 2015-09-03 20:05:20
package RuntimeDBProcessor.parser;
import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class urSQLLexer extends Lexer {
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

	// $ANTLR start "T__8"
	public final void mT__8() throws RecognitionException {
		try {
			int _type = T__8;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:2:6: ( 'CREATE' )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:2:8: 'CREATE'
			{
			match("CREATE"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__8"

	// $ANTLR start "T__9"
	public final void mT__9() throws RecognitionException {
		try {
			int _type = T__9;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:3:6: ( 'DATABASE' )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:3:8: 'DATABASE'
			{
			match("DATABASE"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__9"

	// $ANTLR start "T__10"
	public final void mT__10() throws RecognitionException {
		try {
			int _type = T__10;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:4:7: ( 'DATABASES' )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:4:9: 'DATABASES'
			{
			match("DATABASES"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__10"

	// $ANTLR start "T__11"
	public final void mT__11() throws RecognitionException {
		try {
			int _type = T__11;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:5:7: ( 'DISPLAY' )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:5:9: 'DISPLAY'
			{
			match("DISPLAY"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__11"

	// $ANTLR start "T__12"
	public final void mT__12() throws RecognitionException {
		try {
			int _type = T__12;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:6:7: ( 'DROP' )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:6:9: 'DROP'
			{
			match("DROP"); 

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
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:7:7: ( 'LIST' )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:7:9: 'LIST'
			{
			match("LIST"); 

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
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:8:7: ( 'START' )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:8:9: 'START'
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
	// $ANTLR end "T__14"

	// $ANTLR start "T__15"
	public final void mT__15() throws RecognitionException {
		try {
			int _type = T__15;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:9:7: ( 'STOP' )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:9:9: 'STOP'
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
	// $ANTLR end "T__15"

	// $ANTLR start "Identifier"
	public final void mIdentifier() throws RecognitionException {
		try {
			int _type = Identifier;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:22:3: ( LETTER ( LETTER | DIGIT )* )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:22:6: LETTER ( LETTER | DIGIT )*
			{
			mLETTER(); 

			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:22:13: ( LETTER | DIGIT )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( ((LA1_0 >= '0' && LA1_0 <= '9')||(LA1_0 >= 'A' && LA1_0 <= 'Z')||(LA1_0 >= 'a' && LA1_0 <= 'z')) ) {
					alt1=1;
				}

				switch (alt1) {
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
					break loop1;
				}
			}

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
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:24:17: ( ( 'a' .. 'z' | 'A' .. 'Z' ) )
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
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:25:16: ( '0' .. '9' )
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
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:27:4: ( ( ' ' | '\\t' )+ )
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:27:6: ( ' ' | '\\t' )+
			{
			// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:27:6: ( ' ' | '\\t' )+
			int cnt2=0;
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( (LA2_0=='\t'||LA2_0==' ') ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:
					{
					if ( input.LA(1)=='\t'||input.LA(1)==' ' ) {
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
					if ( cnt2 >= 1 ) break loop2;
					EarlyExitException eee = new EarlyExitException(2, input);
					throw eee;
				}
				cnt2++;
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
		// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:1:8: ( T__8 | T__9 | T__10 | T__11 | T__12 | T__13 | T__14 | T__15 | Identifier | WS )
		int alt3=10;
		switch ( input.LA(1) ) {
		case 'C':
			{
			int LA3_1 = input.LA(2);
			if ( (LA3_1=='R') ) {
				int LA3_7 = input.LA(3);
				if ( (LA3_7=='E') ) {
					int LA3_13 = input.LA(4);
					if ( (LA3_13=='A') ) {
						int LA3_20 = input.LA(5);
						if ( (LA3_20=='T') ) {
							int LA3_27 = input.LA(6);
							if ( (LA3_27=='E') ) {
								int LA3_34 = input.LA(7);
								if ( ((LA3_34 >= '0' && LA3_34 <= '9')||(LA3_34 >= 'A' && LA3_34 <= 'Z')||(LA3_34 >= 'a' && LA3_34 <= 'z')) ) {
									alt3=9;
								}

								else {
									alt3=1;
								}

							}

							else {
								alt3=9;
							}

						}

						else {
							alt3=9;
						}

					}

					else {
						alt3=9;
					}

				}

				else {
					alt3=9;
				}

			}

			else {
				alt3=9;
			}

			}
			break;
		case 'D':
			{
			switch ( input.LA(2) ) {
			case 'A':
				{
				int LA3_8 = input.LA(3);
				if ( (LA3_8=='T') ) {
					int LA3_14 = input.LA(4);
					if ( (LA3_14=='A') ) {
						int LA3_21 = input.LA(5);
						if ( (LA3_21=='B') ) {
							int LA3_28 = input.LA(6);
							if ( (LA3_28=='A') ) {
								int LA3_35 = input.LA(7);
								if ( (LA3_35=='S') ) {
									int LA3_39 = input.LA(8);
									if ( (LA3_39=='E') ) {
										switch ( input.LA(9) ) {
										case 'S':
											{
											int LA3_43 = input.LA(10);
											if ( ((LA3_43 >= '0' && LA3_43 <= '9')||(LA3_43 >= 'A' && LA3_43 <= 'Z')||(LA3_43 >= 'a' && LA3_43 <= 'z')) ) {
												alt3=9;
											}

											else {
												alt3=3;
											}

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
											alt3=9;
											}
											break;
										default:
											alt3=2;
										}
									}

									else {
										alt3=9;
									}

								}

								else {
									alt3=9;
								}

							}

							else {
								alt3=9;
							}

						}

						else {
							alt3=9;
						}

					}

					else {
						alt3=9;
					}

				}

				else {
					alt3=9;
				}

				}
				break;
			case 'I':
				{
				int LA3_9 = input.LA(3);
				if ( (LA3_9=='S') ) {
					int LA3_15 = input.LA(4);
					if ( (LA3_15=='P') ) {
						int LA3_22 = input.LA(5);
						if ( (LA3_22=='L') ) {
							int LA3_29 = input.LA(6);
							if ( (LA3_29=='A') ) {
								int LA3_36 = input.LA(7);
								if ( (LA3_36=='Y') ) {
									int LA3_40 = input.LA(8);
									if ( ((LA3_40 >= '0' && LA3_40 <= '9')||(LA3_40 >= 'A' && LA3_40 <= 'Z')||(LA3_40 >= 'a' && LA3_40 <= 'z')) ) {
										alt3=9;
									}

									else {
										alt3=4;
									}

								}

								else {
									alt3=9;
								}

							}

							else {
								alt3=9;
							}

						}

						else {
							alt3=9;
						}

					}

					else {
						alt3=9;
					}

				}

				else {
					alt3=9;
				}

				}
				break;
			case 'R':
				{
				int LA3_10 = input.LA(3);
				if ( (LA3_10=='O') ) {
					int LA3_16 = input.LA(4);
					if ( (LA3_16=='P') ) {
						int LA3_23 = input.LA(5);
						if ( ((LA3_23 >= '0' && LA3_23 <= '9')||(LA3_23 >= 'A' && LA3_23 <= 'Z')||(LA3_23 >= 'a' && LA3_23 <= 'z')) ) {
							alt3=9;
						}

						else {
							alt3=5;
						}

					}

					else {
						alt3=9;
					}

				}

				else {
					alt3=9;
				}

				}
				break;
			default:
				alt3=9;
			}
			}
			break;
		case 'L':
			{
			int LA3_3 = input.LA(2);
			if ( (LA3_3=='I') ) {
				int LA3_11 = input.LA(3);
				if ( (LA3_11=='S') ) {
					int LA3_17 = input.LA(4);
					if ( (LA3_17=='T') ) {
						int LA3_24 = input.LA(5);
						if ( ((LA3_24 >= '0' && LA3_24 <= '9')||(LA3_24 >= 'A' && LA3_24 <= 'Z')||(LA3_24 >= 'a' && LA3_24 <= 'z')) ) {
							alt3=9;
						}

						else {
							alt3=6;
						}

					}

					else {
						alt3=9;
					}

				}

				else {
					alt3=9;
				}

			}

			else {
				alt3=9;
			}

			}
			break;
		case 'S':
			{
			int LA3_4 = input.LA(2);
			if ( (LA3_4=='T') ) {
				switch ( input.LA(3) ) {
				case 'A':
					{
					int LA3_18 = input.LA(4);
					if ( (LA3_18=='R') ) {
						int LA3_25 = input.LA(5);
						if ( (LA3_25=='T') ) {
							int LA3_32 = input.LA(6);
							if ( ((LA3_32 >= '0' && LA3_32 <= '9')||(LA3_32 >= 'A' && LA3_32 <= 'Z')||(LA3_32 >= 'a' && LA3_32 <= 'z')) ) {
								alt3=9;
							}

							else {
								alt3=7;
							}

						}

						else {
							alt3=9;
						}

					}

					else {
						alt3=9;
					}

					}
					break;
				case 'O':
					{
					int LA3_19 = input.LA(4);
					if ( (LA3_19=='P') ) {
						int LA3_26 = input.LA(5);
						if ( ((LA3_26 >= '0' && LA3_26 <= '9')||(LA3_26 >= 'A' && LA3_26 <= 'Z')||(LA3_26 >= 'a' && LA3_26 <= 'z')) ) {
							alt3=9;
						}

						else {
							alt3=8;
						}

					}

					else {
						alt3=9;
					}

					}
					break;
				default:
					alt3=9;
				}
			}

			else {
				alt3=9;
			}

			}
			break;
		case 'A':
		case 'B':
		case 'E':
		case 'F':
		case 'G':
		case 'H':
		case 'I':
		case 'J':
		case 'K':
		case 'M':
		case 'N':
		case 'O':
		case 'P':
		case 'Q':
		case 'R':
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
			alt3=9;
			}
			break;
		case '\t':
		case ' ':
			{
			alt3=10;
			}
			break;
		default:
			NoViableAltException nvae =
				new NoViableAltException("", 3, 0, input);
			throw nvae;
		}
		switch (alt3) {
			case 1 :
				// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:1:10: T__8
				{
				mT__8(); 

				}
				break;
			case 2 :
				// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:1:15: T__9
				{
				mT__9(); 

				}
				break;
			case 3 :
				// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:1:20: T__10
				{
				mT__10(); 

				}
				break;
			case 4 :
				// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:1:26: T__11
				{
				mT__11(); 

				}
				break;
			case 5 :
				// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:1:32: T__12
				{
				mT__12(); 

				}
				break;
			case 6 :
				// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:1:38: T__13
				{
				mT__13(); 

				}
				break;
			case 7 :
				// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:1:44: T__14
				{
				mT__14(); 

				}
				break;
			case 8 :
				// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:1:50: T__15
				{
				mT__15(); 

				}
				break;
			case 9 :
				// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:1:56: Identifier
				{
				mIdentifier(); 

				}
				break;
			case 10 :
				// /Users/macbook/NetBeansProjects/urSQLNoRep/urSQL.g:1:67: WS
				{
				mWS(); 

				}
				break;

		}
	}



}
