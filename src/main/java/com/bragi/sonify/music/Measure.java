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

package com.bragi.sonify.music;

import java.util.Iterator;
import java.util.List;

import com.bragi.sonify.util.ArrayIterator;

/**
 * A measure as found in the MusicXML specification
 * 
 * @deprecated
 * @author Jan-Christoph Klie
 */
public class Measure implements Iterable<Note> {
	
	private Note[] data;

	/**
	 * Finally, a usage for var args.
	 * 
	 * @param data The data
	 */
	@SafeVarargs
	public Measure(Note ... data) {
		this.data = data;
	}
	
	public Measure( List<Note> data) {
		this.data = data.toArray(new Note[0]);
	}
	
	protected Note[] getData() {
		return data;
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		for(Note n : data) {
			sb.append("[" + n + "]");
		}
		return sb.toString();
	}

	@Override
	public Iterator<Note> iterator() {
		return new ArrayIterator<Note>(data);
	}

}
