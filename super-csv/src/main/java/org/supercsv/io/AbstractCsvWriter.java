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

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;
import org.supercsv.encoder.CsvEncoder;
import org.supercsv.prefs.CsvPreference;
import org.supercsv.util.CsvContext;
import org.supercsv.util.Util;

/**
 * Defines the standard behaviour of a CSV writer.
 *
 * @author Kasper B. Graversen
 * @author James Bassett
 */
public abstract class AbstractCsvWriter implements ICsvWriter {

    private final Writer writer;

    private final CsvPreference preference;

    private final CsvEncoder encoder;

    // the line number being written / just written
    private int lineNumber = 0;

    // the row being written / just written
    private int rowNumber = 0;

    // the column being written / just written
    private int columnNumber = 0;

    /**
     * Constructs a new <tt>AbstractCsvWriter</tt> with the supplied writer and preferences.
     *
     * @param writer
     *            the stream to write to
     * @param preference
     *            the CSV preferences
     * @throws NullPointerException
     *             if writer or preference is null
     */
    public AbstractCsvWriter(final Writer writer, final CsvPreference preference) {
        this(writer, preference, true);
    }

    /**
     * Constructs a new <tt>AbstractCsvWriter</tt> with the supplied writer, preferences and option
     * to wrap the writer.
     *
     * @param writer
     *            the stream to write to
     * @param preference
     *            the CSV preferences
     * @param bufferizeWriter
     *            indicates if the writer should be wrapped internally with a BufferedWriter
     * @throws NullPointerException
     *             if writer or preference is null
     */
    public AbstractCsvWriter(final Writer writer, final CsvPreference preference, boolean bufferizeWriter) {
        if (writer == null) {
            throw new NullPointerException("writer should not be null");
        } else if (preference == null) {
            throw new NullPointerException("preference should not be null");
        }
        this.writer = bufferizeWriter ? new BufferedWriter(writer) : writer;
        this.preference = preference;
        this.encoder = preference.getEncoder();
    }

    /**
     * Closes the underlying writer, flushing it first.
     */
    public void close() throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Flushes the underlying writer.
     */
    public void flush() throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * In order to maintain the current row and line numbers, this method <strong>must</strong> be called at the very
     * beginning of every write method implemented in concrete CSV writers. This will allow the correct row/line numbers
     * to be used in any exceptions thrown before writing occurs (e.g. during CellProcessor execution), and means that
     * {@link #getLineNumber()} and {@link #getRowNumber()} can be called after writing to return the line/row just
     * written.
     */
    protected void incrementRowAndLineNo() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * {@inheritDoc}
     */
    public int getLineNumber() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * {@inheritDoc}
     */
    public int getRowNumber() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Writes a List of columns as a line to the CsvWriter.
     *
     * @param columns
     *            the columns to write
     * @throws IllegalArgumentException
     *             if columns.size == 0
     * @throws IOException
     *             If an I/O error occurs
     * @throws NullPointerException
     *             if columns is null
     */
    protected void writeRow(final List<?> columns) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Writes one or more Object columns as a line to the CsvWriter.
     *
     * @param columns
     *            the columns to write
     * @throws IllegalArgumentException
     *             if columns.length == 0
     * @throws IOException
     *             If an I/O error occurs
     * @throws NullPointerException
     *             if columns is null
     */
    protected void writeRow(final Object... columns) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Writes one or more String columns as a line to the CsvWriter.
     *
     * @param columns
     *            the columns to write
     * @throws IllegalArgumentException
     *             if columns.length == 0
     * @throws IOException
     *             If an I/O error occurs
     * @throws NullPointerException
     *             if columns is null
     */
    protected void writeRow(final String... columns) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * {@inheritDoc}
     */
    public void writeComment(final String comment) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * {@inheritDoc}
     */
    public void writeHeader(final String... header) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
