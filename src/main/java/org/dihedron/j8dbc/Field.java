/*
 * Copyright (c) 2012-2015, Andrea Funto'. All rights reserved. See LICENSE for details.
 */
package org.dihedron.j8dbc;

import org.dihedron.core.License;

/**
 * A class representing a database field, that is the element in
 * the database row corresponding to a specific column. This class
 * is merely a data transfer object to be used in JDBC streams.
 * 
 * @author Andrea Funto'
 */
@License
public abstract class Field {
	
	/**
	 * The field data.
	 */
	protected Object data;
	
	/**
	 * The name of the column.
	 */
	protected String name;
	
	/**
	 * The suggested displayable name of the column.
	 */
	protected String label;
	
	/**
	 * The display size (in characters) of the column.
	 */
	protected int displaySize;
	
	/**
	 * The type of data in the field.
	 */
	protected int sqlDataType;
	
	/**
	 * The name of the data type in the field.
	 */
	protected String sqlDataTypeName;
	
	/**
	 * The designated column's specified column size.
	 */
	protected int precision;
	
	/**
	 * The designated column's number of digits to right of the decimal point.
	 */
	protected int scale;
	
	/**
	 * Indicates whether the designated column is automatically numbered.
	 */
	protected boolean autoIncrement;
	
	/**
	 * Indicates whether a column's case matters.
	 */
	protected boolean caseSensitive;
	
	/**
	 * Indicates whether the designated column is a cash value.
	 */
	protected boolean currency;
	
	/**
	 * Indicates whether a write on the designated column will definitely succeed.
	 */
	protected boolean definitelyWritable;
	
	/**
	 * Indicates the nullability of values in the designated column.
	 */
	protected int nullable;
	
	/**
	 * Indicates whether the designated column is definitely not writable.
	 */
	protected boolean readOnly;
	
	/**
	 * Indicates whether the designated column can be used in a where clause.
	 */
	protected boolean searchable;
	
	/**
	 * Indicates whether values in the designated column are signed numbers.
	 */
	protected boolean signed;
	
	/**
	 * Indicates whether it is possible for a write on the designated column to succeed.
	 */
	protected boolean writable;
			
	/**
	 * Returns the value of the field as a raw object.
	 * 
	 * @return
	 *   the value of the field as a raw object.
	 */
	public Object value() {
		return data;
	}
	
	/**
	 * Attempts to cast the field object as the given type.
	 * 
	 * @param clazz
	 *   the type to which the data should be cast.
	 * @return
	 *   the data (if cast can be performed), {@code null} otherwise.
	 */
	public <T> T as(Class<T> clazz) {
		if(clazz != null && data != null && clazz.isAssignableFrom(data.getClass())) {
			return clazz.cast(data);
		}
		return null;
	}
	
	/**
	 * Returns the name of the column to which this field belongs.
	 * 
	 * @return
	 *   the name of the column to which this field belongs.
	 */
	public String name() {
		return name;
	}
	
	/**
	 * Returns the suggested displayable name of the column to which this
	 * field belongs.
	 *   
	 * @return
	 *   the suggested displayable name of the column to which this
	 *   field belongs.
	 */
	public String label() {
		return label;
	}
	
	/**
	 * Returns the display size (in characters) of the column to which this
	 * field corresponds.
	 * 
	 * @return
	 *   the display size (in characters) of the column to which this
	 *   field corresponds.
	 */
	public int displaySize() {
		return displaySize;
	}
	
	/**
	 * Returns the column SQL data type.
	 * 
	 * @return
	 *   the column SQL data type.
	 */
	public int sqlDataType() {
		return sqlDataType;
	}
	
	/**
	 * Returns the column SQL data type name.
	 * 
	 * @return
	 *   the column SQL data type name.
	 */
	public String sqlDataTypeName() {
		return sqlDataTypeName;
	}	
	
	/**
	 * Returns the designated column's specified column size.
	 * 
	 * @return
	 *   the designated column's specified column size.
	 */
	public int precision() {
		return precision;
	}
	
	/**
	 * Returns the designated column's number of digits to right of the decimal point.
	 * 
	 * @return
	 *   the designated column's number of digits to right of the decimal point.
	 */
	public int scale() {
		return scale;
	}
	
	/**
	 * Returns whether the designated column is automatically numbered.
	 * 
	 * @return
	 *   whether the designated column is automatically numbered.
	 */
	public boolean autoIncrement() {
		return autoIncrement;
	}
	
	/**
	 * Returns whether a column's case matters.
	 * 
	 * @return
	 *   whether a column's case matters.
	 */
	public boolean caseSensitive() {
		return caseSensitive;
	}
	
	/**
	 * Returns whether the designated column is a cash value.
	 * 
	 * @return
	 *   whether the designated column is a cash value.
	 */
	public boolean isCurrency() {
		return currency;
	}
	
	/**
	 * Returns whether a write on the designated column will definitely succeed.
	 * 
	 * @return
	 *   whether a write on the designated column will definitely succeed.
	 */
	public boolean definitelyWritable() {
		return definitelyWritable;
	}
	 
	/**
	 * Returns the nullability of values in the designated column.
	 * 
	 * @return
	 *  the nullability of values in the designated column.
	 */
	public int nullable() {
		return nullable;
	}
	
	/**
	 * Returns whether the designated column is definitely not writable. 
	 * 
	 * @return
	 *   whether the designated column is definitely not writable.
	 */
	public boolean readOnly() {
		return readOnly;
	}
	
	/**
	 * Returns whether the designated column can be used in a where clause.
	 * 
	 * @return
	 *   whether the designated column can be used in a where clause.
	 */
	public boolean searchable() {
		return searchable;
	}
	
	/**
	 * Returns whether values in the designated column are signed numbers.
	 * 
	 * @return
	 *   whether values in the designated column are signed numbers.
	 */
	public boolean signed() {
		return signed;
	}
	
	/**
	 * Returns whether it is possible for a write on the designated column to succeed.
	 * 
	 * @return
	 *   whether it is possible for a write on the designated column to succeed.
	 */
	public boolean writable() {
		return writable;
	}
}
