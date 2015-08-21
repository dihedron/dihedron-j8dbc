/*
 * Copyright (c) 2012-2015, Andrea Funto'. All rights reserved. See LICENSE for details.
 */ 
package org.dihedron.j8dbc;

import java.lang.ref.WeakReference;
import java.util.Iterator;

import org.dihedron.core.License;

/**
 * Helper class to iterate in a stream-oriented fashion on a
 * {@code Record} fields.
 * 
 * @author Andrea Funto'
 */
@License
class RecordIterator implements Iterator<Field> {

	/**
	 * A weak reference to the underlying JDBC {@code ResultSet}.
	 */	
	private WeakReference<Record> reference = null;

	/**
	 * The current field index. 
	 */	
	private int index = -1;
	
	/**
	 * Default constructor.
	 */
	public RecordIterator() {
		this(null);
	}
	
	/**
	 * Constructor.
	 * 
	 * @param rs
	 *   the {@code ResultSet} on which to iterate.
	 */
	public RecordIterator(Record record) {
		setRecord(record);
	}
	
	/**
	 * Initialises the reference to the {@code Record} on whose
	 * fields  iteration will be performed.
	 * 
	 * @param record
	 *   the {@code Reconrd} on which to iterate.
	 * @return
	 *   the object itself, for method chaining.
	 */
	public RecordIterator setRecord(Record record) {
		reference = new WeakReference<>(record);
		return this;
	}
	
	/**
	 * Checks whether the {@code ResultSet} contains more results.
	 * 
	 * @return
	 *   whether the {@code ResultSet} contains more results.
	 * @see java.util.Iterator#hasNext()
	 */
	@Override
	public boolean hasNext() {
		Record record = reference.get();
		if(record != null && index + 1 < record.fieldCount()) {
			return true;
		}
		return false;
	}

	/**
	 * Returns the next {@code Row} proxy object.
	 * 
	 * @return
	 *   the next {@code Row} proxy object.
	 * @see java.util.Iterator#next()
	 */
	@Override
	public Field next() {
		Record record = reference.get();
		if(record != null) {
			return record.get(++index);
		}
		return null;
	}
}
