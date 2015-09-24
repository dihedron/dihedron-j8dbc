/*
 * Copyright (c) 2012-2015, Andrea Funto'. All rights reserved. See LICENSE for details.
 */ 
package org.dihedron.j8dbc;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.dihedron.core.License;

/**
 * The base class to iterate on {@code ResultSet}s.
 * 
 * @author Andrea Funto'
 */
@License
public class ResultSetIterator implements Iterator<Record> {
	
	/**
	 * The record factory.
	 */
	private RecordFactory factory = null;
	
	/**
	 * Constructor.
	 * 
	 * @param rs
	 *   the {@code ResultSet} on which to iterate.
	 */
	public ResultSetIterator(RecordFactory factory) {
		this.factory = factory;
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
		return factory.hasMore();
	}

	/**
	 * Returns the next {@code Row} proxy object.
	 * 
	 * @return
	 *   the next {@code Row} proxy object.
	 * @see java.util.Iterator#next()
	 */
	@Override
	public Record next() throws NoSuchElementException {
		return factory.makeRecord();
	}
}
