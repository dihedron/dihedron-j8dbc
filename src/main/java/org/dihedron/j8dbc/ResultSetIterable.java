/*
 * Copyright (c) 2012-2015, Andrea Funto'. All rights reserved. See LICENSE for details.
 */ 
package org.dihedron.j8dbc;

import java.lang.ref.WeakReference;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Iterator;

import org.dihedron.core.License;

/**
 * Helper class to iterate over the elements in a {@code ResultSet}.
 * 
 * @author Andrea Funto'
 */
@License
class ResultSetIterable implements Iterable<Record> {
	
	/**
	 * A weak reference to the underlying JDBC {@code ResultSet}.
	 */	
	private WeakReference<ResultSet> reference;
	
	/**
	 * A weak reference to the underlying JDBC {@code Statement}.
	 */
	private WeakReference<Statement> statement;
	
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
	public ResultSetIterable(ResultSet rs, Statement statement) {
		reference = new WeakReference<>(rs);
		this.statement = new WeakReference<>(statement);
	}

	/**
	 * Returns an iterator on the given {@code ResultSet}.
	 * 
	 * @see java.lang.Iterable#iterator()
	 */
    @Override
    public Iterator<Record> iterator() {
        return new ResultSetIterator().setResultSet(reference.get()).setStatement(statement.get());
    }
}	