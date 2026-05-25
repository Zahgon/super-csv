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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.exception.SuperCsvConstraintViolationException;
import org.supercsv.exception.SuperCsvException;

/**
 * Useful utility methods.
 *
 * @author Kasper B. Graversen
 * @author James Bassett
 */
public final class Util {

    // no instantiation
    private Util() {
    }

    /**
     * Processes each element in the source List (using the corresponding processor chain in the processors array) and
     * adds it to the destination List. A <tt>null</tt> CellProcessor in the array indicates that no processing is
     * required and the element should be added as-is.
     *
     * @param destination
     *            the List to add the processed elements to (which is cleared before it's populated)
     * @param source
     *            the List of source elements to be processed
     * @param processors
     *            the array of CellProcessors used to process each element. The number of elements in this array must
     *            match the size of the source List. A <tt>null</tt> CellProcessor in this array indicates that no
     *            processing is required and the element should be added as-is.
     * @param lineNo
     *            the current line number
     * @param rowNo
     *            the current row number
     * @throws NullPointerException
     *             if destination, source or processors are null
     * @throws SuperCsvConstraintViolationException
     *             if a CellProcessor constraint failed
     * @throws SuperCsvException
     *             if source.size() != processors.length, or CellProcessor execution failed
     */
    public static void executeCellProcessors(final List<Object> destination, final List<?> source, final CellProcessor[] processors, final int lineNo, final int rowNo) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Converts a List to a Map using the elements of the nameMapping array as the keys of the Map.
     *
     * @param destinationMap
     *            the destination Map (which is cleared before it's populated)
     * @param nameMapping
     *            the keys of the Map (corresponding with the elements in the sourceList). Cannot contain duplicates.
     * @param sourceList
     *            the List to convert
     * @param <T>
     *            the type of the values in the map
     * @throws NullPointerException
     *             if destinationMap, nameMapping or sourceList is null
     * @throws SuperCsvException
     *             if nameMapping and sourceList are not the same size
     */
    public static <T> void filterListToMap(final Map<String, T> destinationMap, final String[] nameMapping, final List<? extends T> sourceList) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns a List of all of the values in the Map whose key matches an entry in the nameMapping array.
     *
     * @param map
     *            the map
     * @param nameMapping
     *            the keys of the Map values to add to the List
     * @return a List of all of the values in the Map whose key matches an entry in the nameMapping array
     * @throws NullPointerException
     *             if map or nameMapping is null
     */
    public static List<Object> filterMapToList(final Map<String, ?> map, final String[] nameMapping) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Converts a Map to an array of objects, adding only those entries whose key is in the nameMapping array.
     *
     * @param values
     *            the Map of values to convert
     * @param nameMapping
     *            the keys to extract from the Map (elements in the target array will be added in this order)
     * @return the array of Objects
     * @throws NullPointerException
     *             if values or nameMapping is null
     */
    public static Object[] filterMapToObjectArray(final Map<String, ?> values, final String[] nameMapping) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Converts an Object array to a String array (null-safe), by calling toString() on each element.
     *
     * @param objectArray
     *            the Object array
     * @return the String array, or null if objectArray is null
     */
    public static String[] objectArrayToStringArray(final Object[] objectArray) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Converts an {@code List<Object>} to a String array (null-safe), by calling {@code toString()} on each element.
     *
     * @param objectList
     *            the List
     * @return the String array, or null if objectList is null
     */
    public static String[] objectListToStringArray(final List<?> objectList) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * subtract bom information of {@code String} line.
     * @param line
     *         the first line row of file
     * @return the String without bom information
     */
    public static String subtractBom(String line) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
