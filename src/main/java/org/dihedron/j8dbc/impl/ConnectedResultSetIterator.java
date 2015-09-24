/*
 * Copyright (c) 2012-2015, Andrea Funto'. All rights reserved. See LICENSE for details.
 */ 
package org.dihedron.j8dbc.impl;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.NoSuchElementException;

import org.dihedron.core.License;
import org.dihedron.j8dbc.Record;
import org.dihedron.j8dbc.RecordFactory;
import org.dihedron.j8dbc.ResultSetIterator;

/**
 * Helper class to iterate in a stream-oriented fashion on the
 * rows in a {@code ResultSet}.
 *
 * @author Andrea Funto'
 */
@License
class ConnectedResultSetIterator implements ResultSetIterator {
	
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
	public ConnectedResultSetIterator(ResultSet rs, Statement statement) {
		factory = new ConnectedRecordFactory(rs, statement);
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
