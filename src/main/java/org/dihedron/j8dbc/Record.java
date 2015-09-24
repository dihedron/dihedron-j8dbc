/*
 * Copyright (c) 2012-2015, Andrea Funto'. All rights reserved. See LICENSE for details.
 */
package org.dihedron.j8dbc;

import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.dihedron.core.License;

/**
 * An abstract class providing common functionalities to connected
 * and disconnected records.
 * 
 * @author Andrea Funto'
 */
@License
public abstract class Record {
	
	/**
	 * The number of fields in the record.
	 */
	protected int fieldCount;
	
	/**
	 * Returns the number of fields available in the {@code Record}.
	 * 
	 * @return
	 *   the number of fields available in the {@code Record}.
	 */
	public int fieldCount() {
		return fieldCount;
	}
	
	/**
	 * Returns the n-th (0 based) field value, or an empty field if unavailable.
	 * 
	 * @param index
	 *   the 0-based index of the field to retrieve; the value must then be cast 
	 *   to the appropriate type before being used.
	 * @return
	 *   the field value, or an empty field if unavailable.
	 */
	public abstract Field get(int index);
	
	/**
	 * Returns the field with the given name (case insensitive), or an empty
	 * field.
	 * 
	 * @param name
	 *   the case insensitive name of the field.
	 * @return
	 *   the field corresponding to the given name, or an empty field.
	 */
	public abstract Field get(String name);
	
	/**
	 * Returns the fields as a stream.
	 * 
	 * @return
	 *   the fields as a stream.
	 */
	public Stream<Field> stream() {
		return StreamSupport.stream(new RecordIterable(this).spliterator(), false);		
	}

	/**
	 * Returns the fields as a parallel stream.
	 * 
	 * @return
	 *   the fields as a parallel stream.
	 */
	public Stream<Field> parallelStream() {
		return StreamSupport.stream(new RecordIterable(this).spliterator(), true);		
	}	
}
