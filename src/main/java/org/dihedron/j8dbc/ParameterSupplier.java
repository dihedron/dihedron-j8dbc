/*
 * Copyright (c) 2012-2015, Andrea Funto'. All rights reserved. See LICENSE for details.
 */ 
package org.dihedron.j8dbc;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.dihedron.core.License;

/**
 * A functional interface to provide a way of invoking lambda expressions
 * against compiled query without having to worry about {@code SQLException}s
 * that might be thrown from its body.
 *  
 * @author Andrea Funto'
 */
@License
@FunctionalInterface
public interface ParameterSupplier {
	/**
	 * The actual lambda implementation; typical examples will use the
	 * provided {@code PreparedStatement} to set parameters or query
	 * options.
	 *  
	 * @param statement
	 *   the statement on which options will be set.
	 * @throws SQLException
	 */
    public void accept(PreparedStatement statement) throws SQLException;
}