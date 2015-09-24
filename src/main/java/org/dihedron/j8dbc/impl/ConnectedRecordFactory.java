package org.dihedron.j8dbc.impl;

import java.lang.ref.WeakReference;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.dihedron.j8dbc.Record;
import org.dihedron.j8dbc.RecordFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConnectedRecordFactory implements RecordFactory {
	
	/**
	 * The logger.
	 */
	private static final Logger logger = LoggerFactory.getLogger(ConnectedRecordFactory.class);

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
	 * Constructor.
	 * 
	 * @param rs
	 *   the {@code ResultSet} from which this factory will generate records.
	 * @param stmt
	 *   the {@code Statement} associated with the {@code ResultSet}.
	 */
	ConnectedRecordFactory(ResultSet rs, Statement stmt) {
		reference = new WeakReference<>(rs);
		statement = new WeakReference<>(stmt);
	}
		
	/**
	 * @see org.dihedron.j8dbc.RecordFactory#hasMore()
	 */
	@Override
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
	 * @see org.dihedron.j8dbc.RecordFactory#makeRecord()
	 */
	@Override
	public Record makeRecord() {
		return new ConnectedRecord(reference.get());
	}
}
