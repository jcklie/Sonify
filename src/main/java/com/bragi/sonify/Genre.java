/*******************************************************************************
 * Copyright (c) 2012 BragiSoft, Inc.
 * This source is subject to the BragiSoft Permissive License.
 * Please see the License.txt file for more information.
 * All other rights reserved.
 * 
 * THIS CODE AND INFORMATION ARE PROVIDED "AS IS" WITHOUT WARRANTY OF ANY 
 * KIND, EITHER EXPRESSED OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND/OR FITNESS FOR A
 * PARTICULAR PURPOSE.
 * 
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * Contributors:
 * Jan-Christoph Klie - Everything
 * 
 *******************************************************************************/

package com.bragi.sonify;

import java.security.InvalidParameterException;

/**
 * This enum holds text genres and their description in a language of choice.
 * The name of a description can be used for displaying a selection component
 * 
 * @author Jan-Christoph Klie
 */
public enum Genre {
	
	DRAMA("Drama"),
	KIDS_BOOK("Kinderbuch"),
	LYRICS("Lyrik"),
	NOVEL("Roman"),
	NONFICTION("Sachbuch");
	
	/**
	 * Description of the genre in a language of choice, intended to be used to
	 * display it on user interface components
	 */
	String name;
	
	Genre(String name) {
		this.name = name;
	}	
	
	/**
	 * Factory method used to create an Genre instance by specifying the name of a genre. 
	 * @param s The name of the genre
	 * @return A Genre instance with the name specified
	 */
	public static Genre getByName(String s) {
		switch( s ) {
			case "Drama": return DRAMA;
			case "Kinderbuch": return KIDS_BOOK;
			case "Lyrik": return LYRICS;
			case "Roman": return NOVEL;
			case "Sachbuch": return NONFICTION;
		default:
			throw new InvalidParameterException("There is no genre which has the specified name: " + s);
		}		
	}

}
