/*
 * Copyright (c) 2012-2015, Andrea Funto'. All rights reserved. See LICENSE for details.
 */ 
package org.dihedron.j8dbc;

import java.lang.ref.WeakReference;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.NoSuchElementException;

import org.dihedron.core.License;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Helper class to iterate in a stream-oriented fashion on the
 * rows in a {@code ResultSet}.
 *
 * @author Andrea Funto'
 */
@License
class ResultSetIterator implements Iterator<Record> {

	/**
	 * The logger.
	 */
	private static final Logger logger = LoggerFactory.getLogger(ResultSetIterator.class);

	/**
	 * A weak reference to the underlying JDBC {@code ResultSet}.
	 */	
	private WeakReference<ResultSet> reference = null;

	/**
	 * A weak reference to the JDBC {@code Statement} associated with the 
	 * {@code ResultSet}.
	 */	
	private WeakReference<Statement> statement = null;
	
	/**
	 * Default constructor.
	 */
	public ResultSetIterator() {
		this(null);
	}
	
	/**
	 * Constructor.
	 * 
	 * @param rs
	 *   the {@code ResultSet} on which to iterate.
	 */
	public ResultSetIterator(ResultSet rs) {
		setResultSet(rs);
	}
	
	/**
	 * Initialises the reference to the {@code ResultSet} on which
	 * iteration will be performed.
	 * 
	 * @param rs
	 *   the {@code ResultSet} on which to iterate.
	 * @return
	 *   the object itself, for method chaining.
	 */
	public ResultSetIterator setResultSet(ResultSet rs) {
		reference = new WeakReference<>(rs);
		return this;
	}

	/**
	 * Initialises a reference to the {@code Statement} associated with the 
	 * {@code ResultSet} on which iteration will be performed.
	 * 
	 * @param rs
	 *   the {@code Statement} associated with the {@code ResultSet}.
	 * @return
	 *   the object itself, for method chaining.
	 */
	public ResultSetIterator setStatement(Statement statement) {
		this.statement = new WeakReference<>(statement);
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
		ResultSet rs = reference.get();		
		try {
			boolean hasNext = rs != null && rs.next();
			if(!hasNext) {
				logger.trace("closing associated statement");
				statement.get().close();
			}
			return hasNext;
		} catch (SQLException e) {
			logger.error("error reading data fromn JDBC stream", e);
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
	public Record next() throws NoSuchElementException { 
		return new Record(reference.get());
	}
}
