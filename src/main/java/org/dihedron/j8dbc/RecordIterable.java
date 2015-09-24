/*
 * Copyright (c) 2012-2015, Andrea Funto'. All rights reserved. See LICENSE for details.
 */ 
package org.dihedron.j8dbc;

import java.lang.ref.WeakReference;
import java.util.Iterator;

import org.dihedron.core.License;

/**
 * Helper class to iterate over a {@code Record} fields.
 * 
 * @author Andrea Funto'
 */
@License
public class RecordIterable implements Iterable<Field> {
	
	/**
	 * A weak reference to the {@code Record} to iterate upon.
	 */	
	private WeakReference<Record> reference;
	
	/**
	 * Constructor.
	 * 
	 * @param rs
	 *   the {@code Record} whose {@code Fields} are to be enumerated.
	 */
	public RecordIterable(Record record) {
		reference = new WeakReference<>(record);
	}

	/**
	 * Returns an iterator on the given {@code Record}.
	 * 
	 * @see java.lang.Iterable#iterator()
	 */
    @Override
    public Iterator<Field> iterator() {
        return new RecordIterator().setRecord(reference.get());
    }
}	
