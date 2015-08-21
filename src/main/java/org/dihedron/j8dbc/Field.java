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
public class Field {
	
	/**
	 * The field data.
	 */
	private Object data;
	
	/**
	 * The name of the column.
	 */
	private String name;
	
	/**
	 * The suggested displayable name of the column.
	 */
	private String label;
	
	/**
	 * The display size (in characters) of the column.
	 */
	private int displaySize;
	
	/**
	 * The type of data in the field.
	 */
	private int sqlDataType;
	
	/**
	 * The name of the data type in the field.
	 */
	private String sqlDataTypeName;
	
	/**
	 * The designated column's specified column size.
	 */
	private int precision;
	
	/**
	 * The designated column's number of digits to right of the decimal point.
	 */
	private int scale;
	
	/**
	 * Indicates whether the designated column is automatically numbered.
	 */
	private boolean	autoIncrement;
	
	/**
	 * Indicates whether a column's case matters.
	 */
	private boolean	caseSensitive;
	
	/**
	 * Indicates whether the designated column is a cash value.
	 */
	private boolean	currency;
	
	/**
	 * Indicates whether a write on the designated column will definitely succeed.
	 */
	private boolean	definitelyWritable;
	
	/**
	 * Indicates the nullability of values in the designated column.
	 */
	private int	nullable;
	
	/**
	 * Indicates whether the designated column is definitely not writable.
	 */
	private boolean	readOnly;
	
	/**
	 * Indicates whether the designated column can be used in a where clause.
	 */
	private boolean	searchable;
	
	/**
	 * Indicates whether values in the designated column are signed numbers.
	 */
	private boolean	signed;
	
	/**
	 * Indicates whether it is possible for a write on the designated column to succeed.
	 */
	private boolean	writable;
			
	/**
	 * Initialises the field's data.
	 * 
	 * @param data
	 *   the value of the data.
	 * @return
	 *   the object itself, for method chaining.
	 */
	Field setData(Object data) {
		this.data = data;
		return this;
	}

	/**
	 * Sets the field name.
	 * 
	 * @param name
	 *   the name of the column to which this field corresponds.
	 * @return
	 *   the object itself, for method chaining.
	 */
	Field setName(String name) {
		this.name = name;
		return this;
	}
	
	/**
	 * Sets the suggested, displayable name of the column.
	 * 
	 * @param label
	 *   the suggested displayable name of the column.
	 * @return
	 *   the object itself, for method chaining.
	 */
	Field setLabel(String label) {
		this.label = label;
		return this;
	}
	
	/**
	 * Sets the display size of the column, in characters.
	 * 
	 * @param size
	 *   the display size of the column in characters.
	 * @return
	 *   the object itself, for method chaining.
	 */
	Field setDisplaySize(int size) {
		this.displaySize = size;
		return this;
	}
	
	/**
	 * Sets the data type of the field.
	 * 
	 * @param type
	 *   the data type of the field.
	 * @return
	 *   the object itself, for method chaining.
	 */
	Field setSqlDataType(int type) {
		this.sqlDataType = type;
		return this;
	}
	
	/**
	 * Sets the name of the data type of the field.
	 * 
	 * @param type
	 *   the name of the data type of the field.
	 * @return
	 *   the object itself, for method chaining.
	 */
	Field setSqlDataTypeName(String typeName) {
		this.sqlDataTypeName = typeName;
		return this;
	}
	
	/**
	 * Sets the designated column's specified column size.
	 * 
	 * @param precision
	 *   the designated column's specified column size.
	 * @return
	 *   the object itself, for method chaining.
	 */
	Field setPrecision(int precision) {
		this.precision = precision;
		return this;
	}
	
	/**
	 * Sets the designated column's number of digits to right of the decimal point.
	 * 
	 * @param scale
	 *   the designated column's number of digits to right of the decimal point.
	 * @return
	 *   the object itself, for method chaining.
	 */
	Field setScale(int scale) {
		this.scale = scale;
		return this;
	}

	/**
	 * Sets whether the designated column is automatically numbered.
	 * 
	 * @param autoincrement
	 *   whether the designated column is automatically numbered.
	 * @return
	 *   the object itself, for method chaining.
	 */
	Field setAutoIncrement(boolean autoincrement) {
		this.autoIncrement = autoincrement;
		return this;
	}
	
	/**
	 * Sets whether a column's case matters.
	 * 
	 * @param caseSensitive
	 *   whether a column's case matters.
	 * @return
	 *   the object itself, for method chaining.
	 */
	Field setCaseSensitive(boolean caseSensitive) {
		this.caseSensitive = caseSensitive;
		return this;
	}
 
	/**
	 * Sets whether the designated column is a cash value.
	 * 
	 * @param isCurrency
	 *   whether the designated column is a cash value.
	 * @return
	 *   the object itself, for method chaining.
	 */
	Field setCurrency(boolean currency) {
		this.currency = currency;
		return this;
	}

	/**
	 * Sets whether a write on the designated column will definitely succeed.
	 * 
	 * @param definitelyWritable
	 *   whether a write on the designated column will definitely succeed.
	 * @return
	 *   the object itself, for method chaining.
	 */
	Field setDefinitelyWritable(boolean definitelyWritable) {
		this.definitelyWritable = definitelyWritable;
		return this;
	}
	
	/**
	 * Sets the nullability of values in the designated column.
	 * 
	 * @param nullable
	 *   the nullability of values in the designated column.
	 * @return
	 *   the object itself, for method chaining.
	 */
	Field setNullable(int nullable) {
		this.nullable = nullable;
		return this;
	}
	
	/**
	 * Sets whether the designated column is definitely not writable.
	 * 
	 * @param readOnly
	 *   whether the designated column is definitely not writable.
	 * @return
	 *   the object itself, for method chaining.
	 */
	Field setReadOnly(boolean readOnly) {
		this.readOnly = readOnly;
		return this;
	}
	
	/**
	 * Sets whether the designated column can be used in a where clause.
	 * 
	 * @param readOnly
	 *   whether the designated column can be used in a where clause.
	 * @return
	 *   the object itself, for method chaining.
	 */
	Field setSearchable(boolean searchable) {
		this.searchable = searchable;
		return this;
	}

	/**
	 * Sets whether values in the designated column are signed numbers.
	 * 
	 * @param readOnly
	 *   whether values in the designated column are signed numbers.
	 * @return
	 *   the object itself, for method chaining.
	 */
	Field setSigned(boolean signed) {
		this.signed = signed;
		return this;
	}

	/**
	 * Sets whether it is possible for a write on the designated column to succeed.
	 * 
	 * @param readOnly
	 *   whether it is possible for a write on the designated column to succeed.
	 * @return
	 *   the object itself, for method chaining.
	 */
	Field setWritable(boolean writable) {
		this.writable = writable;
		return this;
	}

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
