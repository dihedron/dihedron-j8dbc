/*
 * Copyright (c) 2012-2015, Andrea Funto'. All rights reserved. See LICENSE for details.
 */ 
package org.dihedron.j8dbc;

import org.dihedron.core.License;
import org.dihedron.core.library.Library;
import org.dihedron.core.library.Traits;


/**
 * The library marker class.
 * 
 * @author Andrea Funto'
 */
@License
public class J8DBC extends Library {
	
	/**
	 * The name of the library.
	 */
	private static final String LIBRARY_NAME = "j8dbc";
	
	/**
	 * The single instance.
	 */
	private static J8DBC singleton = new J8DBC();

	/**
	 * Constructor.
	 */
	private J8DBC() {
		super(LIBRARY_NAME);
	}
	
	/**
	 * Returns the value of the give trait.
	 * 
	 * @param trait
	 *   the trait to retrieve.
	 * @return
	 *   the value of the trait.
	 */
	public static String valueOf(Traits trait) {
		synchronized(J8DBC.class) {
			if(singleton == null) {
				singleton = new J8DBC();
			}
		}
		return singleton.get(trait);
	}
}
