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
package org.supercsv.io.dozer;

import static org.dozer.loader.api.TypeMappingOptions.oneWay;
import static org.dozer.loader.api.TypeMappingOptions.wildcard;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import org.dozer.DozerBeanMapper;
import org.dozer.loader.api.BeanMappingBuilder;
import org.dozer.loader.api.FieldsMappingOptions;
import org.dozer.loader.api.TypeMappingBuilder;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.AbstractCsvWriter;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.prefs.CsvPreference;
import org.supercsv.util.Util;

/**
 * CsvDozerBeanWriter is a powerful replacement for {@link CsvBeanWriter} that uses Dozer to map from a bean to CSV.
 *
 * @author James Bassett
 * @since 2.0.0
 */
public class CsvDozerBeanWriter extends AbstractCsvWriter implements ICsvDozerBeanWriter {

    private final DozerBeanMapper dozerBeanMapper;

    // target of dozer bean mapping
    private final CsvDozerBeanData beanData = new CsvDozerBeanData();

    // temporary storage of processed columns to be written
    private final List<Object> processedColumns = new ArrayList<Object>();

    /**
     * Constructs a new <tt>CsvDozerBeanWriter</tt> with the supplied Writer and CSV preferences and and creates it's
     * own DozerBeanMapper. Note that the <tt>writer</tt> will be wrapped in a <tt>BufferedWriter</tt> before accessed.
     *
     * @param writer
     *            the writer
     * @param preference
     *            the CSV preferences
     * @throws NullPointerException
     *             if writer or preference are null
     */
    public CsvDozerBeanWriter(final Writer writer, final CsvPreference preference) {
        super(writer, preference);
        this.dozerBeanMapper = new DozerBeanMapper();
    }

    /**
     * Constructs a new <tt>CsvDozerBeanWriter</tt> with the supplied Writer, CSV preferences and DozerBeanMapper. Note
     * that the <tt>writer</tt> will be wrapped in a <tt>BufferedWriter</tt> before accessed.
     *
     * @param writer
     *            the writer
     * @param preference
     *            the CSV preferences
     * @param dozerBeanMapper
     *            the pre-configured DozerBeanMapper
     * @throws NullPointerException
     *             if writer, preference or dozerBeanMapper are null
     */
    public CsvDozerBeanWriter(final Writer writer, final CsvPreference preference, final DozerBeanMapper dozerBeanMapper) {
        super(writer, preference);
        if (dozerBeanMapper == null) {
            throw new NullPointerException("dozerBeanMapper should not be null");
        }
        this.dozerBeanMapper = dozerBeanMapper;
    }

    /**
     * {@inheritDoc}
     */
    public void configureBeanMapping(final Class<?> clazz, final String[] fieldMapping) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * {@inheritDoc}
     */
    public void write(final Object source) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * {@inheritDoc}
     */
    public void write(final Object source, final CellProcessor[] processors) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Assembles the dozer bean mappings required by CsvDozerBeanWriter programatically using the Dozer API.
     */
    private static class MappingBuilder extends BeanMappingBuilder {

        private final Class<?> clazz;

        private final String[] fieldMapping;

        /**
         * Constructs a new MappingBuilder.
         *
         * @param clazz
         *            the class to add mapping configuration for (same as the type passed into write methods)
         * @param fieldMapping
         *            the field mapping for for each column (cannot contain <tt>null</tt> elements)
         * @throws NullPointerException
         *             if clazz or fieldMapping (or one of its elements) is null
         */
        public MappingBuilder(final Class<?> clazz, final String[] fieldMapping) {
            if (clazz == null) {
                throw new NullPointerException("clazz should not be null");
            } else if (fieldMapping == null) {
                throw new NullPointerException("fieldMapping should not be null");
            }
            this.clazz = clazz;
            this.fieldMapping = fieldMapping;
        }

        @Override
        protected void configure() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
