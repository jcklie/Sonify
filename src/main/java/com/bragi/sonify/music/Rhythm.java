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

import com.bragi.sonify.util.ArrayIterator;

/**
 * Rhythm is the variation of the length and accentuation of a series of sounds
 * or other events. Samples are given here. A rhythm is simply a list of NoteValues. 
 */
public class Rhythm implements Iterable<NoteValue> {
	
	public static final Rhythm RHYTHM1 = new Rhythm(NoteValue.WHOLE, NoteValue.OMMIT, NoteValue.OMMIT, NoteValue.OMMIT);
	public static final Rhythm RHYTHM2 = new Rhythm(NoteValue.HALF, NoteValue.OMMIT, NoteValue.HALF, NoteValue.OMMIT);
	public static final Rhythm RHYTHM3 = new Rhythm(NoteValue.QUARTER, NoteValue.QUARTER, NoteValue.QUARTER, NoteValue.QUARTER);
	public static final Rhythm RHYTHM4 = new Rhythm(NoteValue.QUARTER, NoteValue.OMMIT, NoteValue.HALFD, NoteValue.OMMIT);
	public static final Rhythm RHYTHM5 = new Rhythm(NoteValue.HALF, NoteValue.OMMIT, NoteValue.QUARTER, NoteValue.QUARTER);
	public static final Rhythm RHYTHM6 = new Rhythm(NoteValue.QUARTER, NoteValue.QUARTER, NoteValue.QUARTER, NoteValue.QUARTER);
	public static final Rhythm RHYTHM7 = new Rhythm(NoteValue.QUARTER, NoteValue.OMMIT, NoteValue.QUARTER, NoteValue.HALF);
	public static final Rhythm RHYTHM8 = new Rhythm(NoteValue.QUARTERD, NoteValue.QUARTERD, NoteValue.QUARTERD, NoteValue.HALF);
	public static final Rhythm RHYTHM9 = new Rhythm(NoteValue.HALF, NoteValue.QUARTER, NoteValue.EIGTHD, NoteValue.SIXTEENTH);
	
	public static final Rhythm RHYTHM10 = new Rhythm(NoteValue.QUARTER, NoteValue.QUARTER, NoteValue.QUARTERT, NoteValue.EIGTHT);
	public static final Rhythm RHYTHM11 = new Rhythm(NoteValue.QUARTERT, NoteValue.QUARTERT, NoteValue.OMMIT, NoteValue.QUARTERT);
	public static final Rhythm RHYTHM12 = new Rhythm(NoteValue.QUARTER, NoteValue.EIGTH, NoteValue.SIXTEENTH, NoteValue.SIXTEENTH);
	public static final Rhythm RHYTHM13 = new Rhythm(NoteValue.QUARTER, NoteValue.EIGTHT, NoteValue.EIGTHT, NoteValue.EIGTHT);
	public static final Rhythm RHYTHM14 = new Rhythm(NoteValue.EIGTHD, NoteValue.EIGTHD, NoteValue.EIGTHD, NoteValue.EIGTHD);
	
	private NoteValue[] data;

	/**
	 * Finally, a usage for varargs.
	 * 
	 * @param data The data
	 */
	public Rhythm(NoteValue... data) {
		this.data = data;
	}

	@Override
	public Iterator<NoteValue> iterator() {
		return new ArrayIterator<NoteValue>(data);
	}
	
	/**
	 * Retrieves the NoteValue array of this Rhythm.
	 * @return The NoteValue array of this Rhythm
	 */
	protected NoteValue[] getData() {
		return data;
	}

}
