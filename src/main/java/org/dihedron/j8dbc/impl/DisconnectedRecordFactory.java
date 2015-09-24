/*
 * Copyright (c) 2012-2015, Andrea Funto'. All rights reserved. See LICENSE for details.
 */
package org.dihedron.j8dbc.impl;

import java.sql.ResultSet;
import java.sql.Statement;

import org.dihedron.core.License;
import org.dihedron.j8dbc.Record;
import org.dihedron.j8dbc.RecordFactory;

/**
 * A factory for disconnected (locally cached) records. 
 * 
 * @author Andrea Funto'
 */
@License
public class DisconnectedRecordFactory extends RecordFactory {

	/**
	 * Constructor.
	 * 
	 * @param rs
	 *   the {@code ResultSet} from which this factory will generate records.
	 * @param stmt
	 *   the {@code Statement} associated with the {@code ResultSet}.
	 */
	public DisconnectedRecordFactory(ResultSet rs, Statement stmt) {
		super(rs, stmt);
	}

	/**
	 * @see org.dihedron.j8dbc.RecordFactory#makeRecord()
	 */
	@Override
	public Record makeRecord() {
		return new DisconnectedRecord(reference.get());
	}
}
