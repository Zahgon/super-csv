/*
 * Copyright 2007 Kasper B. Graversen
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.supercsv.io;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import org.supercsv.comment.CommentMatcher;
import org.supercsv.exception.SuperCsvException;
import org.supercsv.prefs.CsvPreference;

/**
 * Reads the CSV file, line by line. If you want the line-reading functionality of this class, but want to define your
 * own implementation of {@link #readColumns(List)}, then consider writing your own Tokenizer by extending
 * AbstractTokenizer.
 *
 * @author Kasper B. Graversen
 * @author James Bassett
 * @author Pietro Aragona
 */
public class Tokenizer extends AbstractTokenizer {

    private static final char NEWLINE = '\n';

    private static final char SPACE = ' ';

    private final StringBuilder currentColumn = new StringBuilder();

    /* the raw, untokenized CSV row (may span multiple lines) */
    private final StringBuilder currentRow = new StringBuilder();

    private final char quoteChar;

    private final int delimiterChar;

    private final boolean surroundingSpacesNeedQuotes;

    private final boolean ignoreEmptyLines;

    private final CommentMatcher commentMatcher;

    private final int maxLinesPerRow;

    private final EmptyColumnParsing emptyColumnParsing;

    private final char quoteEscapeChar;

    /**
     * Enumeration of tokenizer states. QUOTE_MODE is activated between quotes.
     */
    private enum TokenizerState {

        NORMAL, QUOTE_MODE
    }

    /**
     * Constructs a new <tt>Tokenizer</tt>, which reads the CSV file, line by line.
     *
     * @param reader
     *            the reader
     * @param preferences
     *            the CSV preferences
     * @throws NullPointerException
     *             if reader or preferences are null
     */
    public Tokenizer(final Reader reader, final CsvPreference preferences) {
        super(reader, preferences);
        this.quoteChar = preferences.getQuoteChar();
        this.delimiterChar = preferences.getDelimiterChar();
        this.surroundingSpacesNeedQuotes = preferences.isSurroundingSpacesNeedQuotes();
        this.ignoreEmptyLines = preferences.isIgnoreEmptyLines();
        this.commentMatcher = preferences.getCommentMatcher();
        this.maxLinesPerRow = preferences.getMaxLinesPerRow();
        this.emptyColumnParsing = preferences.getEmptyColumnParsing();
        this.quoteEscapeChar = preferences.getQuoteEscapeChar();
    }

    /**
     * {@inheritDoc}
     */
    public boolean readColumns(final List<String> columns) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Adds the currentColumn to columns list managing the case with currentColumn.length() == 0
     * It was introduced to manage the emptyColumnParsing.
     *
     * @param columns
     * @param line
     * @param charIndex
     */
    private void addColumn(final List<String> columns, String line, int charIndex) {
        if (currentColumn.length() > 0) {
            columns.add(currentColumn.toString());
        } else {
            int previousCharIndex = charIndex - 1;
            boolean availableCharacters = previousCharIndex >= 0;
            boolean previousCharIsQuote = availableCharacters && line.charAt(previousCharIndex) == quoteChar;
            String noValue = ((previousCharIsQuote) && emptyColumnParsing.equals(EmptyColumnParsing.ParseEmptyColumnsAsEmptyString)) ? "" : null;
            columns.add(noValue);
        }
    }

    /**
     * Appends the required number of spaces to the StringBuilder.
     *
     * @param sb
     *            the StringBuilder
     * @param spaces
     *            the required number of spaces to append
     */
    private static void appendSpaces(final StringBuilder sb, final int spaces) {
        for (int i = 0; i < spaces; i++) {
            sb.append(SPACE);
        }
    }

    /**
     * {@inheritDoc}
     */
    public String getUntokenizedRow() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
