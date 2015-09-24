/*
 * Copyright (c) 2012-2015, Andrea Funto'. All rights reserved. See LICENSE for details.
 */ 
package org.dihedron.j8dbc;

import java.sql.Connection;
import java.sql.SQLException;

import org.dihedron.core.License;

/**
 * Master class to generate JDBC-backed streams according to user-provided 
 * selection criteria.
 * 
 * @author Andrea Funto'
 */
@License
public class Select  {	
	/**
	 * Factory method to create a {@code Query}, which will in its turn be used
	 * to run a query against the database connection.
	 * 
	 * @param connection
	 *   the database connection.
	 * @return
	 *   a new {@code Query} object.
	 * @throws SQLException
	 */
	public static Query using(Connection connection) throws SQLException {
		return new Query(connection);		
	}		
}
