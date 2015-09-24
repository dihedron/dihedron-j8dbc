/*
 * Copyright (c) 2012-2015, Andrea Funto'. All rights reserved. See LICENSE for details.
 */ 
package org.dihedron.j8dbc;

import java.util.Iterator;

import org.dihedron.core.License;

/**
 * Helper class to iterate in a stream-oriented fashion on the rows 
 * in a {@code ResultSet} and to create streams from.
 *
 * @author Andrea Funto'
 */
@License
public class ResultSetIterable implements Iterable<Record> {
	
	/**
	 * The record factory to use for instantiating new {@code Record}s.
	 */
	private RecordFactory factory;
	
	/**
	 * Constructor.
	 * 
	 * @param rs
	 *   the {@code ResultSet} on which to iterate.
	 * @param statement
	 *   the associated {@code Statement}: it must be closed
	 *   only when the stream is done iterating over the associated
	 *   {@code ResultSet} or an error would be raised.
	 */
	public ResultSetIterable(RecordFactory factory) {
		this.factory = factory;
	}

	/**
	 * Returns an iterator on the given {@code ResultSet}.
	 * 
	 * @see java.lang.Iterable#iterator()
	 */
    @Override
    public Iterator<Record> iterator() {
        return new ResultSetIterator(factory);
    }
}
