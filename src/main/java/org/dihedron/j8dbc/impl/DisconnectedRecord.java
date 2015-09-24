/*
 * Copyright (c) 2012-2015, Andrea Funto'. All rights reserved. See LICENSE for details.
 */ 
package org.dihedron.j8dbc.impl;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.dihedron.core.License;
import org.dihedron.j8dbc.Field;
import org.dihedron.j8dbc.Record;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A class representing an instance of a database row (a record).
 * 
 * @author Andrea Funto'
 */
@License
public class DisconnectedRecord extends Record {
	
	private static final Logger logger = LoggerFactory.getLogger(DisconnectedRecord.class);
	
	private Map<Integer, Field> fields = new HashMap<>();
	
	DisconnectedRecord(ResultSet rs) {		
		if(rs != null) {			
			try {
				ResultSetMetaData metadata = rs.getMetaData(); 
				fieldCount = metadata.getColumnCount();
				for(int index = 0; index < fieldCount; ++index) {
					Field field = new FieldImpl()
							.setData(rs.getObject(index + 1))
							.setName(metadata.getColumnName(index + 1))
							.setLabel(metadata.getColumnLabel(index + 1))
							.setDisplaySize(metadata.getColumnDisplaySize(index + 1))
							.setSqlDataType(metadata.getColumnType(index + 1))
							.setSqlDataTypeName(metadata.getColumnTypeName(index + 1))
							.setPrecision(metadata.getPrecision(index + 1))
							.setScale(metadata.getScale(index + 1))
							.setAutoIncrement(metadata.isAutoIncrement(index + 1))
							.setCaseSensitive(metadata.isCaseSensitive(index + 1))
							.setCurrency(metadata.isCurrency(index + 1))
							.setDefinitelyWritable(metadata.isDefinitelyWritable(index + 1))
							.setNullable(metadata.isNullable(index + 1))
							.setReadOnly(metadata.isReadOnly(index + 1))
							.setSearchable(metadata.isSearchable(index + 1))
							.setSigned(metadata.isSigned(index + 1))
							.setWritable(metadata.isWritable(index + 1));
					fields.put(index, field);
				}
			} catch (SQLException e) {
				logger.error("error accessing database", e);			
			}
		}
	}
	
	/**
	 * @see org.dihedron.j8dbc.Record#get(int)
	 */
	public Field get(int index) {
		if(index >= 0 && index < fieldCount) {
			return fields.get(index);
		}
		return new FieldImpl();
	}

	/**
	 * @see org.dihedron.j8dbc.Record#get(java.lang.String)
	 */
	public Field get(String name) {
		for(Entry<Integer, Field> entry : fields.entrySet()) {
			if(entry.getValue() != null && entry.getValue().name().equalsIgnoreCase(name)) {
				return entry.getValue();
			}
		}
		return new FieldImpl();
	}	
}
