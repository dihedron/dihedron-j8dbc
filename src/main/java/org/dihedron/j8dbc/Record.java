/*
 * Copyright (c) 2012-2015, Andrea Funto'. All rights reserved. See LICENSE for details.
 */
package org.dihedron.j8dbc;

import java.util.stream.Stream;

public interface Record {
	
	/**
	 * Returns the number of fields available in the {@code Record}.
	 * 
	 * @return
	 *   the number of fields available in the {@code Record}.
	 */
	int fieldCount();
	
	/**
	 * Returns the n-th (0 based) field value, or {@code null} if unavailable.
	 * 
	 * @param index
	 *   the 0-based index of the field to retrieve; the value must then be cast 
	 *   to the appropriate type before being used.
	 * @return
	 */
	Field get(int index);
	
	/**
	 * Returns the field with the given name (case insensitive), or {@code null}.
	 * 
	 * @param name
	 *   the case insensitive name of the field.
	 * @return
	 *   the field corresponding to the given name, or {@code null}.
	 */
	Field get(String name);
	
	/**
	 * Returns the fields as a stream.
	 * 
	 * @return
	 *   the fields as a stream.
	 */
	Stream<Field> fields();

}
