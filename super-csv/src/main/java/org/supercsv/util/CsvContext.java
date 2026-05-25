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
package org.supercsv.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * This object represents the current context of a given CSV file being either read or written to. The lineNumber is the
 * actual line number (beginning at 1) of the file being read or written to. The rowNumber (beginning at 1) is the
 * number of the CSV row (which will be identical to lineNumber if no rows span multiple lines) - the last rowNumber
 * will correspond with the number of CSV records. The columnNumber (beginning at 1) is the number of the CSV column.
 *
 * @author Kasper B. Graversen
 * @author James Bassett
 */
public class CsvContext implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * the line number of the file being read/written
     */
    private int lineNumber;

    /**
     * the CSV row number (CSV rows can span multiple lines)
     */
    private int rowNumber;

    /**
     * the CSV column number
     */
    private int columnNumber;

    /**
     * the row just read in, or to be written
     */
    private List<Object> rowSource;

    /**
     * Constructs a new <tt>CsvContext</tt>.
     *
     * @param lineNumber
     *            the current line number
     * @param rowNumber
     *            the current CSV row number
     * @param columnNumber
     *            the current CSV column number
     */
    public CsvContext(final int lineNumber, final int rowNumber, final int columnNumber) {
        this.lineNumber = lineNumber;
        this.rowNumber = rowNumber;
        this.columnNumber = columnNumber;
    }

    /**
     * Constructs a new <tt>CsvContext</tt> that is a copy of the provided <tt>CsvContext</tt>.
     *
     * @param c the context to be copied
     */
    public CsvContext(final CsvContext c) {
        this(c.lineNumber, c.rowNumber, c.columnNumber);
        if (c.rowSource != null) {
            // Shallow clone is OK here. A deep clone implementation would be tricky
            // because the declared type of the items in the array is "Object" which does not
            // have an exposed copy constructor or clone method.
            this.rowSource = new ArrayList<Object>(c.rowSource);
        }
    }

    /**
     * @return the lineNumber
     */
    public int getLineNumber() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @param lineNumber
     *            the lineNumber to set
     */
    public void setLineNumber(int lineNumber) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @return the rowNumber
     */
    public int getRowNumber() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @param rowNumber
     *            the rowNumber to set
     */
    public void setRowNumber(int rowNumber) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @return the columnNumber
     */
    public int getColumnNumber() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @param columnNumber
     *            the columnNumber to set
     */
    public void setColumnNumber(int columnNumber) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @return the rowSource
     */
    public List<Object> getRowSource() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @param rowSource
     *            the rowSource to set
     */
    public void setRowSource(List<Object> rowSource) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object obj) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
