/*
 * Copyright (c) 2012-2015, Andrea Funto'. All rights reserved. See LICENSE for details.
 */
package org.dihedron.j8dbc;

/**
 * The base interface for record factories.
 * 
 * @author Andrea Funto'
 */
public interface RecordFactory {
	
	/**
	 * Returns whether the factory can produce more record.
	 * 
	 * @return
	 *   whether the factory can produce more records.
	 */
	boolean hasMore();
	
	/**
	 * Returns a record.
	 * 
	 * @return
	 *   a record.
	 */
	Record makeRecord();
}
