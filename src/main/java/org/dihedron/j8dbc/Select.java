/*
 * Copyright (c) 2012-2015, Andrea Funto'. All rights reserved. See LICENSE for details.
 */ 
package org.dihedron.j8dbc;

import java.lang.ref.WeakReference;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.dihedron.core.License;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Master class to generate JDBC-backed streams according to user-provided 
 * selection criteria.
 * 
 * @author Andrea Funto'
 */
@License
public class Select  {
		
	private static final Logger logger = LoggerFactory.getLogger(Select.class);
	
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
	
	/**
	 * An helper class to provide a DSL for querying the database - possibly
	 * setting query parameters - and getting back a stream of records.
	 * 
	 * @author Andrea Funto'
	 */
	public static class Query {
		
		/**
		 * A weak back-reference to the associated connection, used to create
		 * the prepared statement; it's not up to this class to get rid of the
		 * connection once it's done using it, but it will not hinder garbage 
		 * collection thanks to its holding only a weak reference to it.
		 */
		private WeakReference<Connection> connection;
		
		/**
		 * A weak reference to the prepared statement that will be used to query 
		 * the database; the statement will be closed by the stream once it's done
		 * retrieving its records from the database. 
		 */
		private WeakReference<PreparedStatement> statement;
		
		/**
		 * Compiles the query into a prepared statement; optional query parameters
		 * can now be added to the query.
		 * 
		 * @param select
		 *   the actuals SQL query to compile.
		 * @return
		 *   the object itself, for method chaining.
		 * @throws SQLException
		 */
		public Query compile(String select) throws SQLException {
			logger.trace("compiling query '{}'", select);
			statement = new WeakReference<>(connection.get().prepareStatement(select));
			return this;
		}
				
		/**
		 * Sets a query parameter into the query via a lambda expression.
		 * 
		 * @param lambda
		 *   the lambda expression that has the chance of setting one or
		 *   more query parameters into the {@code Query}'s prepared statement.
		 * @return
		 *   the object itself, for method chaining.
		 * @throws SQLException
		 */
		public Query with(ParameterSupplier lambda) throws SQLException {
			if(statement.get() != null) {
				lambda.accept(statement.get());
				return this;
			} else {
				throw new SQLException("invalid state: the query object must have been compiled first (see Query.compile(java.lang.String)");
			}
		}
		
		/**
		 * Runs the query against the database, returining a stream
		 * of {@code Record} objects.
		 * 
		 * @return
		 *   a {@code stream} of {@code Record} objects.
		 * @throws SQLException
		 */
		public Stream<Record> run() throws SQLException {
			ResultSet results = statement.get().executeQuery();
			// NOTE: nobody closes the prepared statement: if we did it here its associated result 
			// set would be closed immediately too; thus we have to pass it on along with the result 
			// set and expect the stream-supporting classes to clean up properly as soon as they're 
			// done iterating on the records
			return StreamSupport.stream(new ResultSetIterable(results, statement.get()).spliterator(), false);			
		}
		
		/**
		 * Private constructor.
		 * 
		 * @param connection
		 *   the actual database connection.
		 */
		private Query(Connection connection) {
			this.connection = new WeakReference<>(connection);
		}		
	}	
}
