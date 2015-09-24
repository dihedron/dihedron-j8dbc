/*
 * Copyright (c) 2012-2015, Andrea Funto'. All rights reserved. See LICENSE for details.
 */
package org.dihedron.j8dbc;

import java.lang.ref.WeakReference;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.dihedron.core.License;
import org.dihedron.j8dbc.impl.ConnectedRecordFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The abstract base class for record factories.
 * 
 * @author Andrea Funto'
 */
@License
public abstract class RecordFactory {
	
	/**
	 * The logger.
	 */
	private static final Logger logger = LoggerFactory.getLogger(ConnectedRecordFactory.class);

	/**
	 * A weak reference to the underlying JDBC {@code ResultSet}.
	 */	
	protected WeakReference<ResultSet> reference = null;

	/**
	 * A weak reference to the JDBC {@code Statement} associated with the 
	 * {@code ResultSet}.
	 */	
	protected WeakReference<Statement> statement = null;
	
	/**
	 * Constructor.
	 * 
	 * @param rs
	 *   the {@code ResultSet} from which this factory will generate records.
	 * @param stmt
	 *   the {@code Statement} associated with the {@code ResultSet}.
	 */
	protected RecordFactory(ResultSet rs, Statement stmt) {
		reference = new WeakReference<>(rs);
		statement = new WeakReference<>(stmt);
	}
		
	/**
	 * Returns whether the factory can produce more record.
	 * 
	 * @return
	 *   whether the factory can produce more records.
	 */
	public boolean hasMore() {		
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
	 * Returns a record.
	 * 
	 * @return
	 *   a record.
	 */
	public abstract Record makeRecord();
}
