package org.dihedron.j8dbc.impl;

import org.dihedron.j8dbc.Field;

public class FieldImpl extends Field {
	/**
	 * Initialises the field's data.
	 * 
	 * @param data
	 *   the value of the data.
	 * @return
	 *   the object itself, for method chaining.
	 */
	FieldImpl setData(Object data) {
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
	FieldImpl setName(String name) {
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
	FieldImpl setLabel(String label) {
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
	FieldImpl setDisplaySize(int size) {
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
	FieldImpl setSqlDataType(int type) {
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
	FieldImpl setSqlDataTypeName(String typeName) {
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
	FieldImpl setPrecision(int precision) {
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
	FieldImpl setScale(int scale) {
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
	FieldImpl setAutoIncrement(boolean autoincrement) {
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
	FieldImpl setCaseSensitive(boolean caseSensitive) {
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
	FieldImpl setCurrency(boolean currency) {
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
	FieldImpl setDefinitelyWritable(boolean definitelyWritable) {
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
	FieldImpl setNullable(int nullable) {
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
	FieldImpl setReadOnly(boolean readOnly) {
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
	FieldImpl setSearchable(boolean searchable) {
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
	FieldImpl setSigned(boolean signed) {
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
	FieldImpl setWritable(boolean writable) {
		this.writable = writable;
		return this;
	}
}
