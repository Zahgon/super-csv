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
import java.io.Writer;
import java.util.Collection;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.supercsv.prefs.CsvPreference;

/**
 * Default implementation of {@link ICsvTypedBeanWriter}.
 *
 * @param <T> Type of beans to be written.
 */
public final class CsvTypedBeanWriter<T> implements ICsvTypedBeanWriter<T> {

    private final ICsvListWriter writer;

    /**
     * Constructs a new <tt>CsvTypedBeanWriter</tt> with the supplied Writer and CSV preferences.
     * Note that the <tt>writer</tt> will be wrapped in a <tt>BufferedWriter</tt> before accessed.
     *
     * @param writer the writer
     * @param preference the CSV preferences
     * @throws NullPointerException if writer or preference are null
     */
    public CsvTypedBeanWriter(final Writer writer, final CsvPreference preference) {
        this.writer = new CsvListWriter(writer, preference);
    }

    @Override
    public void write(final Collection<T> beans, final Collection<Function<T, ?>> extractors) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public int getLineNumber() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public int getRowNumber() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void writeComment(final String comment) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void writeHeader(final String... header) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void close() throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void flush() throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
