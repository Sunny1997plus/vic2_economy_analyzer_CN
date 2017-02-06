/* The following code was generated by JFlex 1.4.3 on 7/13/13 6:50 PM */

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * EUGScanner.java                                                           *
 * This file is generated from scanner.flex. Please edit that file if you    *
 * wish to make changes.                                                     *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

package eug.parser;

/**
 * This is a simple scanner that does no error checking. If there is a problem
 * (e.g., an "=" in a list), the parser that uses this class is responsible for
 * recovering.
 * <p>
 * To use this class, the following sequence is typical:
 * <ol>
 * <li>Call the {@link EUGScanner(java.io.Reader) constructor} with a
 * <code>Reader</code>.<br> Note that it is also possible to use an
 * <code>InputStream</code>, but it will be wrapped in an
 * <code>InputStreamReader</code>.<br> Note also that this class uses a
 * buffer internally, so a <code>BufferedReader</code> is not necessary.
 * <li>Loop with calls to {@link #nextToken()}, performing whatever parsing is
 * necessary.<br>The text read (minus any extraneous characters such as '#'
 * or '"') can be retrieved through {@link lastStr()}.
 * <li>When finished, call {@link #close()}.
 * </ol>
 * <h4>Comment Handling:</h4>
 * Comments can be enabled or disabled through
 * {@link #setCommentsIgnored(boolean)}. If they are disabled,
 * <code>nextToken()</code> will never return {@link TokenType#COMMENT}.
 *
 * @author Michael Myers
 */

public final class EUGScanner {

    /**
     * This character denotes the end of file
     */
    private static final int YYEOF = -1;

    /**
     * initial size of the lookahead buffer
     */
    private static final int ZZ_BUFFERSIZE = 16384;

    /**
     * lexical states
     */
    private static final int YYINITIAL = 0;
    private static final int HAS_IDENT = 2;

    /**
     * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
     * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
     * at the beginning of a line
     * l is of the form l = 2*k, k a non negative integer
     */
    private static final int ZZ_LEXSTATE[] = {
            0, 0, 1, 1
    };

    /**
     * Translates characters to character classes
     */
    private static final String ZZ_CMAP_PACKED =
            "\10\0\2\2\1\4\2\0\1\3\22\0\1\2\1\5\1\6\1\5" +
                    "\3\0\1\1\3\0\1\1\1\1\1\1\1\1\1\0\12\1\1\0" +
                    "\1\5\1\0\1\7\3\0\33\1\1\0\1\1\1\0\1\1\1\0" +
                    "\32\1\1\10\1\0\1\11\42\0\1\2\7\0\1\1\1\0\1\1" +
                    "\11\0\2\1\4\0\1\1\5\0\27\1\1\0\37\1\1\0\u013f\1" +
                    "\31\0\162\1\4\0\14\1\16\0\5\1\11\0\1\1\213\0\1\1" +
                    "\13\0\1\1\1\0\3\1\1\0\1\1\1\0\24\1\1\0\54\1" +
                    "\1\0\46\1\1\0\5\1\4\0\202\1\10\0\105\1\1\0\46\1" +
                    "\2\0\2\1\6\0\20\1\41\0\46\1\2\0\1\1\7\0\47\1" +
                    "\110\0\33\1\5\0\3\1\56\0\32\1\5\0\13\1\43\0\2\1" +
                    "\1\0\143\1\1\0\1\1\17\0\2\1\7\0\2\1\12\0\3\1" +
                    "\2\0\1\1\20\0\1\1\1\0\36\1\35\0\3\1\60\0\46\1" +
                    "\13\0\1\1\u0152\0\66\1\3\0\1\1\22\0\1\1\7\0\12\1" +
                    "\43\0\10\1\2\0\2\1\2\0\26\1\1\0\7\1\1\0\1\1" +
                    "\3\0\4\1\3\0\1\1\36\0\2\1\1\0\3\1\16\0\2\1" +
                    "\23\0\6\1\4\0\2\1\2\0\26\1\1\0\7\1\1\0\2\1" +
                    "\1\0\2\1\1\0\2\1\37\0\4\1\1\0\1\1\23\0\3\1" +
                    "\20\0\11\1\1\0\3\1\1\0\26\1\1\0\7\1\1\0\2\1" +
                    "\1\0\5\1\3\0\1\1\22\0\1\1\17\0\2\1\43\0\10\1" +
                    "\2\0\2\1\2\0\26\1\1\0\7\1\1\0\2\1\1\0\5\1" +
                    "\3\0\1\1\36\0\2\1\1\0\3\1\17\0\1\1\21\0\1\1" +
                    "\1\0\6\1\3\0\3\1\1\0\4\1\3\0\2\1\1\0\1\1" +
                    "\1\0\2\1\3\0\2\1\3\0\3\1\3\0\10\1\1\0\3\1" +
                    "\113\0\10\1\1\0\3\1\1\0\27\1\1\0\12\1\1\0\5\1" +
                    "\46\0\2\1\43\0\10\1\1\0\3\1\1\0\27\1\1\0\12\1" +
                    "\1\0\5\1\3\0\1\1\40\0\1\1\1\0\2\1\43\0\10\1" +
                    "\1\0\3\1\1\0\27\1\1\0\20\1\46\0\2\1\43\0\22\1" +
                    "\3\0\30\1\1\0\11\1\1\0\1\1\2\0\7\1\72\0\60\1" +
                    "\1\0\2\1\14\0\7\1\72\0\2\1\1\0\1\1\2\0\2\1" +
                    "\1\0\1\1\2\0\1\1\6\0\4\1\1\0\7\1\1\0\3\1" +
                    "\1\0\1\1\1\0\1\1\2\0\2\1\1\0\4\1\1\0\2\1" +
                    "\11\0\1\1\2\0\5\1\1\0\1\1\25\0\2\1\42\0\1\1" +
                    "\77\0\10\1\1\0\42\1\35\0\4\1\164\0\42\1\1\0\5\1" +
                    "\1\0\2\1\45\0\6\1\112\0\46\1\12\0\51\1\7\0\132\1" +
                    "\5\0\104\1\5\0\122\1\6\0\7\1\1\0\77\1\1\0\1\1" +
                    "\1\0\4\1\2\0\7\1\1\0\1\1\1\0\4\1\2\0\47\1" +
                    "\1\0\1\1\1\0\4\1\2\0\37\1\1\0\1\1\1\0\4\1" +
                    "\2\0\7\1\1\0\1\1\1\0\4\1\2\0\7\1\1\0\7\1" +
                    "\1\0\27\1\1\0\37\1\1\0\1\1\1\0\4\1\2\0\7\1" +
                    "\1\0\47\1\1\0\23\1\105\0\125\1\14\0\u026c\1\2\0\10\1" +
                    "\12\0\32\1\5\0\113\1\25\0\15\1\1\0\4\1\16\0\22\1" +
                    "\16\0\22\1\16\0\15\1\1\0\3\1\17\0\64\1\43\0\1\1" +
                    "\4\0\1\1\103\0\130\1\10\0\51\1\127\0\35\1\63\0\36\1" +
                    "\2\0\5\1\u038b\0\154\1\224\0\234\1\4\0\132\1\6\0\26\1" +
                    "\2\0\6\1\2\0\46\1\2\0\6\1\2\0\10\1\1\0\1\1" +
                    "\1\0\1\1\1\0\1\1\1\0\37\1\2\0\65\1\1\0\7\1" +
                    "\1\0\1\1\3\0\3\1\1\0\7\1\3\0\4\1\2\0\6\1" +
                    "\4\0\15\1\5\0\3\1\1\0\7\1\164\0\1\1\15\0\1\1" +
                    "\202\0\1\1\4\0\1\1\2\0\12\1\1\0\1\1\3\0\5\1" +
                    "\6\0\1\1\1\0\1\1\1\0\1\1\1\0\4\1\1\0\3\1" +
                    "\1\0\7\1\3\0\3\1\5\0\5\1\u0ebb\0\2\1\52\0\5\1" +
                    "\5\0\2\1\4\0\126\1\6\0\3\1\1\0\132\1\1\0\4\1" +
                    "\5\0\50\1\4\0\136\1\21\0\30\1\70\0\20\1\u0200\0\u19b6\1" +
                    "\112\0\u51a6\1\132\0\u048d\1\u0773\0\u2ba4\1\u215c\0\u012e\1\2\0\73\1" +
                    "\225\0\7\1\14\0\5\1\5\0\1\1\1\0\12\1\1\0\15\1" +
                    "\1\0\5\1\1\0\1\1\1\0\2\1\1\0\2\1\1\0\154\1" +
                    "\41\0\u016b\1\22\0\100\1\2\0\66\1\50\0\14\1\164\0\5\1" +
                    "\1\0\207\1\44\0\32\1\6\0\32\1\13\0\131\1\3\0\6\1" +
                    "\2\0\6\1\2\0\6\1\2\0\3\1\43\0";

    /**
     * Translates characters to character classes
     */
    private static final char[] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

    /**
     * Translates DFA states to action switch labels.
     */
    private static final int[] ZZ_ACTION = zzUnpackAction();

    private static final String ZZ_ACTION_PACKED_0 =
            "\2\0\1\1\1\2\1\3\1\4\1\5\1\1\1\6" +
                    "\1\7\1\10\1\11\1\10\1\12\2\0\1\13\1\4" +
                    "\1\0\1\14\1\0\1\15";

    private static int[] zzUnpackAction() {
        int[] result = new int[22];
        int offset = 0;
        offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
        return result;
    }

    private static int zzUnpackAction(String packed, int offset, int[] result) {
        int i = 0;       /* index in packed string  */
        int j = offset;  /* index in unpacked array */
        int l = packed.length();
        while (i < l) {
            int count = packed.charAt(i++);
            int value = packed.charAt(i++);
            do result[j++] = value; while (--count > 0);
        }
        return j;
    }


    /**
     * Translates a state to a row index in the transition table
     */
    private static final int[] ZZ_ROWMAP = zzUnpackRowMap();

    private static final String ZZ_ROWMAP_PACKED_0 =
            "\0\0\0\12\0\24\0\36\0\50\0\62\0\74\0\106" +
                    "\0\120\0\132\0\24\0\144\0\156\0\170\0\202\0\214" +
                    "\0\226\0\24\0\106\0\202\0\156\0\24";

    private static int[] zzUnpackRowMap() {
        int[] result = new int[22];
        int offset = 0;
        offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
        return result;
    }

    private static int zzUnpackRowMap(String packed, int offset, int[] result) {
        int i = 0;  /* index in packed string  */
        int j = offset;  /* index in unpacked array */
        int l = packed.length();
        while (i < l) {
            int high = packed.charAt(i++) << 16;
            result[j++] = high | packed.charAt(i++);
        }
        return j;
    }

    /**
     * The transition table of the DFA
     */
    private static final int ZZ_TRANS[] = {
            2, 3, 4, 5, 4, 6, 7, 2, 8, 9,
            10, 11, 4, 5, 4, 6, 12, 10, 13, 10,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, 3, 14, 14, 14, 15, -1, 16, -1, -1,
            -1, -1, 4, -1, 4, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, 17, -1, -1, -1, -1, -1,
            6, 6, 6, -1, -1, 6, 6, 6, 6, 6,
            18, 18, 18, 18, 18, 18, 19, 18, 18, 18,
            -1, -1, 8, -1, 8, -1, -1, -1, -1, -1,
            -1, -1, 9, -1, 9, -1, -1, -1, -1, -1,
            -1, 11, -1, -1, -1, -1, -1, -1, -1, -1,
            20, 20, 20, 20, 20, 20, 21, 20, 20, 20,
            -1, -1, 13, -1, 13, -1, -1, -1, -1, -1,
            -1, -1, 14, 14, 14, 15, -1, 16, -1, -1,
            15, 15, 15, 14, 14, 15, 15, 15, 15, 15,
            -1, -1, 16, -1, 16, -1, -1, -1, -1, -1,
    };

    /* error codes */
    private static final int ZZ_UNKNOWN_ERROR = 0;
    private static final int ZZ_NO_MATCH = 1;
    private static final int ZZ_PUSHBACK_2BIG = 2;

    /* error messages for the codes above */
    private static final String ZZ_ERROR_MSG[] = {
            "Unkown internal scanner error",
            "Error: could not match input",
            "Error: pushback value was too large"
    };

    /**
     * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
     */
    private static final int[] ZZ_ATTRIBUTE = zzUnpackAttribute();

    private static final String ZZ_ATTRIBUTE_PACKED_0 =
            "\2\0\1\11\7\1\1\11\3\1\2\0\1\1\1\11" +
                    "\1\0\1\1\1\0\1\11";

    private static int[] zzUnpackAttribute() {
        int[] result = new int[22];
        int offset = 0;
        offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
        return result;
    }

    private static int zzUnpackAttribute(String packed, int offset, int[] result) {
        int i = 0;       /* index in packed string  */
        int j = offset;  /* index in unpacked array */
        int l = packed.length();
        while (i < l) {
            int count = packed.charAt(i++);
            int value = packed.charAt(i++);
            do result[j++] = value; while (--count > 0);
        }
        return j;
    }

    /**
     * the input device
     */
    private java.io.Reader zzReader;

    /**
     * the current state of the DFA
     */
    private int zzState;

    /**
     * the current lexical state
     */
    private int zzLexicalState = YYINITIAL;

    /**
     * this buffer contains the current text to be matched and is
     * the source of the yytext() string
     */
    private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

    /**
     * the textposition at the last accepting state
     */
    private int zzMarkedPos;

    /**
     * the current text position in the buffer
     */
    private int zzCurrentPos;

    /**
     * startRead marks the beginning of the yytext() string in the buffer
     */
    private int zzStartRead;

    /**
     * endRead marks the last character in the buffer, that has been read
     * from input
     */
    private int zzEndRead;

    /**
     * number of newlines encountered up to the start of the matched text
     */
    private int yyline;

    /**
     * the number of characters up to the start of the matched text
     */
    private int yychar;

    /**
     * the number of characters from the last newline up to the start of the
     * matched text
     */
    private int yycolumn;

    /**
     * zzAtBOL == true <=> the scanner is currently at the beginning of a line
     */
    private boolean zzAtBOL = true;

    /**
     * zzAtEOF == true <=> the scanner is at the EOF
     */
    private boolean zzAtEOF;

    /**
     * denotes if the user-EOF-code has already been executed
     */
    private boolean zzEOFDone;

  /* user code: */
    /**
     * Save the last token type for use by {@link #lastStr}.
     */
    private TokenType lastType;

    private boolean commentsIgnored = false;

    /**
     * Name of the current file (must be set by {@link #setFileName}).
     *
     * @since EUGFile 1.07.00
     */
    private String filename = "(unknown file)";

    private static final java.util.regex.Pattern whitespacePattern =
            java.util.regex.Pattern.compile("\\s+");

    /**
     * Convenience method for getting an unquoted string from a quoted one.
     * All whitespace gaps are replaced with a single " ", so quoted strings
     * can span multiple lines.
     */
    private final String getDLString() {
        return whitespacePattern.matcher(yytext().trim().substring(1, yylength() - 1).trim()).replaceAll(" ");
    }

    /**
     * Convenience method for extracting the comment text from a comment string.
     * This method simply replaces all occurrences of the comment start
     * character ('#') with ' ', then trims whitespace off.
     */
    private final String getComment() {
        int lastIdxOfHash = 0;
        for (int i = 0; i < yylength(); i++) {
            if (yycharat(i) == '#')
                lastIdxOfHash = i;
            else
                break;
        }
        return yytext().substring(lastIdxOfHash + 1).trim();
    }

    //private static final java.util.regex.Pattern commentPattern =
    //        java.util.regex.Pattern.compile("#[^\r\n]*(\r|\n|\r\n)");

    /**
     * Convenience method for getting an identifier from a string such as "tag =".
     */
    private final String getIdent() {
        // Remove comments, remove the "=", then trim whitespace.
        boolean inQuotes = false;
        boolean hitWord = false;
        StringBuilder ident = new StringBuilder(yylength() - 2);
        for (int i = 0; i < yylength(); i++) {
            char c = yycharat(i);
            if (inQuotes) { // take anything up to a quote
                if (c == '"')
                    return ident.toString();
                else
                    ident.append(c);
            } else if (hitWord) { // stop at whitespace or equals
                if (c == '=' || c == ' ' || c == '\t' || c == '\n' || c == '\r') {
                    return ident.toString();
                } else {
                    ident.append(c);
                }
            } else {
                if (c == '"') {
                    inQuotes = true;
                    hitWord = true;
                } else if (c == '#' || c == ';' || c == '!') {
                    while (yycharat(i) != '\n' && yycharat(i) != '\r') {
                        i++;
                    }
                } else if (!(c == ' ' || c == '\t' || c == '\n' || c == '\r')) {
                    hitWord = true;
                    ident.append(c);
                }
            }
        }
        return ident.toString(); // shouldn't reach here, but if so, just dump what we've got
        //return commentPattern.matcher(yytext()).replaceAll("").replace('=', ' ').replace('"', ' ').trim();
    }

    private void badChar(char c) {
        System.err.println("Illegal character: \'" + c +
                "\' (#" + Integer.toHexString((int) c) +
                ") on line " + getLine() + ", column " + getColumn() + " of " + filename);
    }

    /**
     * Reads the next token from the input reader.
     *
     * @return the type of token that was just read. The actual token text
     * (if the token was of type <code>DLSTRING</code>, <code>ULSTRING</code>,
     * or <code>COMMENT</code> [if comments are not ignored]) can be accessed
     * from {@link #lastStr()}.
     */
    public TokenType nextToken() {
        try {
            return (lastType = next());
        } catch (java.io.IOException ex) {
            return (lastType = TokenType.EOF);
        }
    }

    /**
     * Returns the last token type read from the input.
     *
     * @since EUGFile 1.06.00pre1
     */
    public TokenType lastToken() {
        return lastType;
    }

    /**
     * Call this method with <code>true</code> to keep comment tokens from being
     * parsed by {@link nextToken()}.
     *
     * @param ignored <code>true</code> to ignore comments, <code>false</code>
     *                to allow comments to be read.
     */
    public void setCommentsIgnored(boolean ignored) {
        commentsIgnored = ignored;
    }

    /**
     * Sets the name of the current file (used for printing helpful errors).
     *
     * @param filename the name of the current file.
     * @since EUGFile 1.07.00
     */
    public void setFileName(String filename) {
        this.filename = filename;
    }

    /**
     * Returns the last string read by the scanner, if the last token included
     * text.
     *
     * @return the last string read by the scanner, stripped of extraneous
     * characters such as '#' and '"'.
     */
    public String lastStr() {
        switch (lastType) {
            case ULSTRING:
                return yytext();
            case DLSTRING:
                return getDLString();
            case COMMENT:
                return getComment();
            case IDENT:
                return getIdent();
            default:
                return "";
        }
    }

    /**
     * Returns the current list in array form. All comments are stripped out.
     *
     * @see #getList()
     * @since EUGFile 1.01.00
     */
    public String[] getArray() {
        if (lastType != TokenType.LIST) {
            System.err.println("Shouldn't be trying to get a list from token type " + lastType);
            return new String[]{};
        }

        return ListScanner.parseArray(yytext().substring(yytext().indexOf('{') + 1, yytext().indexOf('}')));
    }

    /**
     * Returns the current list in the form of a <code>List&lt;String&gt;</code>.
     * All comments are stripped out.
     *
     * @see #getArray()
     */
    public java.util.List<String> getList() {
        if (lastType != TokenType.LIST) {
            System.err.println("Shouldn't be trying to get a list from token type " + lastType);
            return new java.util.ArrayList<String>();
        }

        return ListScanner.parseList(yytext().substring(yytext().indexOf('{') + 1, yytext().indexOf('}')));
    }

    /**
     * Close the scanner's reader. Any <code>IOException</code> will be caught
     * and printed to standard error.
     */
    public void close() {
        try {
            yyclose();
        } catch (java.io.IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Resets the scanner to read from a new input stream.
     * Does not close the old reader.
     *
     * @since EUGFile 1.06.00pre1
     */
    public void reset(java.io.Reader in) {
        yyreset(in);
    }

    /**
     * Resets the scanner to read from a new input stream.
     * Does not close the old reader.
     *
     * @since EUGFile 1.06.00pre1
     */
    public void reset(java.io.InputStream in) {
        yyreset(new java.io.InputStreamReader(in));
    }

    /**
     * Push the current token back into the stream.
     */
    public void pushBack() {
        yypushback(yylength());
        yybegin(YYINITIAL);
    }

    /**
     * Returns the number of newlines encountered up to the start of the token plus one.
     */
    public int getLine() {
        return yyline + 1;
    }

    /**
     * Returns the number of characters from the last newline up to the start of
     * the token.
     */
    public int getColumn() {
        return yycolumn + 1;
    }

    /**
     * Returns the number of characters up to the start of the token.
     *
     * @see #getTokenStart()
     */
    public int getCharsRead() {
        return yychar;
    }

    /**
     * Returns the index of the start of the token. Useful for
     * syntax highlighting.
     *
     * @see #getCharsRead()
     * @since EUGFile 1.06.00pre1
     */
    public int getTokenStart() {
        return yychar;
    }

    /**
     * Returns the number of characters contained in the token. Useful for
     * syntax highlighting.
     *
     * @since EUGFile 1.06.00pre1
     */
    public int getTokenSize() {
        return yylength();
    }

    /**
     * Returns the index of the end of the token. Useful for
     * syntax highlighting.
     *
     * @since EUGFile 1.06.00pre1
     */
    public int getTokenEnd() {
        return yychar + yylength();
    }

    /**
     * Skips the next token or block, depending on the type of the next token.
     *
     * @since EUGFile 1.07.00
     */
    public void skipNext() {
        TokenType current = nextToken();
        if (current == TokenType.LBRACE) {
            while (current != TokenType.RBRACE && current != TokenType.EOF) {
                current = nextToken();
            }
        }
    }


    /**
     * Creates a new scanner
     * There is also a java.io.InputStream version of this constructor.
     *
     * @param in the java.io.Reader to read input from.
     */
    public EUGScanner(java.io.Reader in) {
        this.zzReader = in;
    }

    /**
     * Creates a new scanner.
     * There is also java.io.Reader version of this constructor.
     *
     * @param in the java.io.Inputstream to read input from.
     */
    public EUGScanner(java.io.InputStream in) {
        this(new java.io.InputStreamReader(in));
    }

    /**
     * Unpacks the compressed character translation table.
     *
     * @param packed the packed character translation table
     * @return the unpacked character translation table
     */
    private static char[] zzUnpackCMap(String packed) {
        char[] map = new char[0x10000];
        int i = 0;  /* index in packed string  */
        int j = 0;  /* index in unpacked array */
        while (i < 1174) {
            int count = packed.charAt(i++);
            char value = packed.charAt(i++);
            do map[j++] = value; while (--count > 0);
        }
        return map;
    }


    /**
     * Refills the input buffer.
     *
     * @return <code>false</code>, iff there was new input.
     * @throws java.io.IOException if any I/O-Error occurs
     */
    private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
        if (zzStartRead > 0) {
            System.arraycopy(zzBuffer, zzStartRead,
                    zzBuffer, 0,
                    zzEndRead - zzStartRead);

      /* translate stored positions */
            zzEndRead -= zzStartRead;
            zzCurrentPos -= zzStartRead;
            zzMarkedPos -= zzStartRead;
            zzStartRead = 0;
        }

    /* is the buffer big enough? */
        if (zzCurrentPos >= zzBuffer.length) {
      /* if not: blow it up */
            char newBuffer[] = new char[zzCurrentPos * 2];
            System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
            zzBuffer = newBuffer;
        }

    /* finally: fill the buffer with new input */
        int numRead = zzReader.read(zzBuffer, zzEndRead,
                zzBuffer.length - zzEndRead);

        if (numRead > 0) {
            zzEndRead += numRead;
            return false;
        }
        // unlikely but not impossible: read 0 characters, but not at end of stream
        if (numRead == 0) {
            int c = zzReader.read();
            if (c == -1) {
                return true;
            } else {
                zzBuffer[zzEndRead++] = (char) c;
                return false;
            }
        }

        // numRead < 0
        return true;
    }


    /**
     * Closes the input stream.
     */
    private final void yyclose() throws java.io.IOException {
        zzAtEOF = true;            /* indicate end of file */
        zzEndRead = zzStartRead;  /* invalidate buffer    */

        if (zzReader != null)
            zzReader.close();
    }


    /**
     * Resets the scanner to read from a new input stream.
     * Does not close the old reader.
     * <p>
     * All internal variables are reset, the old input stream
     * <b>cannot</b> be reused (internal buffer is discarded and lost).
     * Lexical state is set to <tt>ZZ_INITIAL</tt>.
     *
     * @param reader the new input stream
     */
    private final void yyreset(java.io.Reader reader) {
        zzReader = reader;
        zzAtBOL = true;
        zzAtEOF = false;
        zzEOFDone = false;
        zzEndRead = zzStartRead = 0;
        zzCurrentPos = zzMarkedPos = 0;
        yyline = yychar = yycolumn = 0;
        zzLexicalState = YYINITIAL;
    }


    /**
     * Returns the current lexical state.
     */
    private final int yystate() {
        return zzLexicalState;
    }


    /**
     * Enters a new lexical state
     *
     * @param newState the new lexical state
     */
    private final void yybegin(int newState) {
        zzLexicalState = newState;
    }


    /**
     * Returns the text matched by the current regular expression.
     */
    private final String yytext() {
        return new String(zzBuffer, zzStartRead, zzMarkedPos - zzStartRead);
    }


    /**
     * Returns the character at position <tt>pos</tt> from the
     * matched text.
     * <p>
     * It is equivalent to yytext().charAt(pos), but faster
     *
     * @param pos the position of the character to fetch.
     *            A value from 0 to yylength()-1.
     * @return the character at position pos
     */
    private final char yycharat(int pos) {
        return zzBuffer[zzStartRead + pos];
    }


    /**
     * Returns the length of the matched text region.
     */
    private final int yylength() {
        return zzMarkedPos - zzStartRead;
    }


    /**
     * Reports an error that occured while scanning.
     * <p>
     * In a wellformed scanner (no or only correct usage of
     * yypushback(int) and a match-all fallback rule) this method
     * will only be called with things that "Can't Possibly Happen".
     * If this method is called, something is seriously wrong
     * (e.g. a JFlex bug producing a faulty scanner etc.).
     * <p>
     * Usual syntax/scanner level error handling should be done
     * in error fallback rules.
     *
     * @param errorCode the code of the errormessage to display
     */
    private void zzScanError(int errorCode) {
        String message;
        try {
            message = ZZ_ERROR_MSG[errorCode];
        } catch (ArrayIndexOutOfBoundsException e) {
            message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
        }

        throw new Error(message);
    }


    /**
     * Pushes the specified amount of characters back into the input stream.
     * <p>
     * They will be read again by then next call of the scanning method
     *
     * @param number the number of characters to be read again.
     *               This number must not be greater than yylength()!
     */
    private void yypushback(int number) {
        if (number > yylength())
            zzScanError(ZZ_PUSHBACK_2BIG);

        zzMarkedPos -= number;
    }


    /**
     * Resumes scanning until the next regular expression is matched,
     * the end of input is encountered or an I/O-Error occurs.
     *
     * @return the next token
     * @throws java.io.IOException if any I/O-Error occurs
     */
    private TokenType next() throws java.io.IOException {
        int zzInput;
        int zzAction;

        // cached fields:
        int zzCurrentPosL;
        int zzMarkedPosL;
        int zzEndReadL = zzEndRead;
        char[] zzBufferL = zzBuffer;
        char[] zzCMapL = ZZ_CMAP;

        int[] zzTransL = ZZ_TRANS;
        int[] zzRowMapL = ZZ_ROWMAP;
        int[] zzAttrL = ZZ_ATTRIBUTE;

        while (true) {
            zzMarkedPosL = zzMarkedPos;

            yychar += zzMarkedPosL - zzStartRead;

            boolean zzR = false;
            for (zzCurrentPosL = zzStartRead; zzCurrentPosL < zzMarkedPosL;
                 zzCurrentPosL++) {
                switch (zzBufferL[zzCurrentPosL]) {
                    case '\u000B':
                    case '\u000C':
                    case '\u0085':
                    case '\u2028':
                    case '\u2029':
                        yyline++;
                        yycolumn = 0;
                        zzR = false;
                        break;
                    case '\r':
                        yyline++;
                        yycolumn = 0;
                        zzR = true;
                        break;
                    case '\n':
                        if (zzR)
                            zzR = false;
                        else {
                            yyline++;
                            yycolumn = 0;
                        }
                        break;
                    default:
                        zzR = false;
                        yycolumn++;
                }
            }

            if (zzR) {
                // peek one character ahead if it is \n (if we have counted one line too much)
                boolean zzPeek;
                if (zzMarkedPosL < zzEndReadL)
                    zzPeek = zzBufferL[zzMarkedPosL] == '\n';
                else if (zzAtEOF)
                    zzPeek = false;
                else {
                    boolean eof = zzRefill();
                    zzEndReadL = zzEndRead;
                    zzMarkedPosL = zzMarkedPos;
                    zzBufferL = zzBuffer;
                    if (eof)
                        zzPeek = false;
                    else
                        zzPeek = zzBufferL[zzMarkedPosL] == '\n';
                }
                if (zzPeek) yyline--;
            }
            zzAction = -1;

            zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

            zzState = ZZ_LEXSTATE[zzLexicalState];


            zzForAction:
            {
                while (true) {

                    if (zzCurrentPosL < zzEndReadL)
                        zzInput = zzBufferL[zzCurrentPosL++];
                    else if (zzAtEOF) {
                        zzInput = YYEOF;
                        break zzForAction;
                    } else {
                        // store back cached positions
                        zzCurrentPos = zzCurrentPosL;
                        zzMarkedPos = zzMarkedPosL;
                        boolean eof = zzRefill();
                        // get translated positions and possibly new buffer
                        zzCurrentPosL = zzCurrentPos;
                        zzMarkedPosL = zzMarkedPos;
                        zzBufferL = zzBuffer;
                        zzEndReadL = zzEndRead;
                        if (eof) {
                            zzInput = YYEOF;
                            break zzForAction;
                        } else {
                            zzInput = zzBufferL[zzCurrentPosL++];
                        }
                    }
                    int zzNext = zzTransL[zzRowMapL[zzState] + zzCMapL[zzInput]];
                    if (zzNext == -1) break zzForAction;
                    zzState = zzNext;

                    int zzAttributes = zzAttrL[zzState];
                    if ((zzAttributes & 1) == 1) {
                        zzAction = zzState;
                        zzMarkedPosL = zzCurrentPosL;
                        if ((zzAttributes & 8) == 8) break zzForAction;
                    }

                }
            }

            // store back cached position
            zzMarkedPos = zzMarkedPosL;

            switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
                case 12: {
                    return TokenType.DLSTRING;
                }
                case 14:
                    break;
                case 3: {
                    break;
                }
                case 15:
                    break;
                case 4: {
                    if (commentsIgnored) return next();
                    else return TokenType.NEWLINE;
                }
                case 16:
                    break;
                case 8: {
                    System.err.print("HAS_IDENT: ");
                    badChar(yycharat(0));
                    return next();
                }
                case 17:
                    break;
                case 5: {
                    if (commentsIgnored) return next();
                    else return TokenType.COMMENT;
                }
                case 18:
                    break;
                case 13: {
                    yybegin(YYINITIAL);
                    return TokenType.DLSTRING;
                }
                case 19:
                    break;
                case 7: {
                    return TokenType.RBRACE;
                }
                case 20:
                    break;
                case 11: {
                    yybegin(HAS_IDENT);
                    return TokenType.IDENT;
                }
                case 21:
                    break;
                case 10: {
                    yybegin(YYINITIAL);
                    return TokenType.LBRACE;
                }
                case 22:
                    break;
                case 2: {
                    return TokenType.ULSTRING;
                }
                case 23:
                    break;
                case 1: {
                    System.err.print("YYINITIAL: ");
                    badChar(yycharat(0));
                    return next();
                }
                case 24:
                    break;
                case 9: {
                    yybegin(YYINITIAL);
                    return TokenType.ULSTRING;
                }
                case 25:
                    break;
                case 6: {
                    return TokenType.LBRACE;
                }
                case 26:
                    break;
                default:
                    if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
                        zzAtEOF = true;
                        {
                            return TokenType.EOF;
                        }
                    } else {
                        zzScanError(ZZ_NO_MATCH);
                    }
            }
        }
    }

    /**
     * Runs the scanner on input files.
     * <p>
     * This is a standalone scanner, it will print any unmatched
     * text to System.out unchanged.
     *
     * @param argv the command line, contains the filenames to run
     *             the scanner on.
     */
    public static void main(String argv[]) {
        if (argv.length == 0) {
            System.out.println("Usage : java EUGScanner <inputfile>");
        } else {
            for (int i = 0; i < argv.length; i++) {
                EUGScanner scanner = null;
                try {
                    scanner = new EUGScanner(new java.io.FileReader(argv[i]));
                    while (!scanner.zzAtEOF) scanner.next();
                } catch (java.io.FileNotFoundException e) {
                    System.out.println("File not found : \"" + argv[i] + "\"");
                } catch (java.io.IOException e) {
                    System.out.println("IO error scanning file \"" + argv[i] + "\"");
                    System.out.println(e);
                } catch (Exception e) {
                    System.out.println("Unexpected exception:");
                    e.printStackTrace();
                }
            }
        }
    }


}