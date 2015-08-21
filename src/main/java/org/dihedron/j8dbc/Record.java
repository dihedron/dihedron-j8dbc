/*
 * Copyright (c) 2012-2015, Andrea Funto'. All rights reserved. See LICENSE for details.
 */ 
package org.dihedron.j8dbc;

import java.lang.ref.WeakReference;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.dihedron.core.License;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A class representing an instance of a database row (a record).
 * 
 * @author Andrea Funto'
 */
@License
public class Record {
	
	private static final Logger logger = LoggerFactory.getLogger(Record.class);
	
	private WeakReference<ResultSet> rs = null;
	
	private int fieldCount = 0;
	
	Record(ResultSet rs) {
		if(rs != null) {
			this.rs = new WeakReference<>(rs);
			try {
				fieldCount = rs.getMetaData().getColumnCount();
			} catch (SQLException e) {
				logger.error("error accessing database table metadata", e);			
			}
		}
	}
	
	/**
	 * Returns the number of fields in this record.
	 *  
	 * @return
	 *   the number of fields in this record.
	 */
	public int fieldCount() {
		return fieldCount;
	}
	
	/**
	 * Returns the n-th (0 based) field value, or {@code null} if unavailable.
	 * 
	 * @param index
	 *   the 0-based index of the field to retrieve; the value must then be cast 
	 *   to the appropriate type before being used.
	 * @return
	 */
	public Field get(int index) {
		if(index >= 0) {
			try {
				ResultSet results = this.rs.get(); 
				if(results != null) {
					ResultSetMetaData metadata = results.getMetaData();
					return new Field()
							.setData(results.getObject(index + 1))
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
				}
			} catch(SQLException e) {
				logger.error("error retrieving data from JDBC connection", e);
			}
		}
		return new Field();
	}
	
	/**
	 * Returns the field with the given name (case insensitive), or {@code null}.
	 * 
	 * @param name
	 *   the case insensitive name of the field.
	 * @return
	 *   the field corresponding to the given name, or {@code null}.
	 */
	public Field get(String name) {
		try {
			ResultSet results = this.rs.get(); 
			if(results != null) {
				ResultSetMetaData metadata = results.getMetaData();
				int index = -1;
				for(int i = 0; i < metadata.getColumnCount(); ++i) {
					if(metadata.getColumnName(i + 1).equalsIgnoreCase(name)) {
						index = i;
						break;
					}
				}
				return get(index);
			}
		} catch(SQLException e) {
			logger.error("error retrieving data from JDBC connection", e);
		}
		return new Field();
	}
	
	public Stream<Field> fields() {
		return StreamSupport.stream(new RecordIterable(this).spliterator(), false);
	}
}
