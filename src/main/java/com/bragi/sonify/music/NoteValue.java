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

/**
 * In music notation, a note value indicates the relative duration of a note.
 * In this case, they are not given in normal relation to a whole note, but
 * to the specified in ticks. Since the SongWriter uses 24 pulses (aka ticks),
 * the QUARTER has a value of 24. 
 * 
 * D means the note is dotted: Its value is 3/2 of the undotted version.
 * T means the note is a triole part : Its value is 2/3 of the untrioled version.
 */
public enum NoteValue {
	
	OMMIT(0),
	WHOLE(96),
	HALFD(72),
	HALF(48),
	QUARTERD(36),
	QUARTER(24),
	QUARTERT(16),
	EIGTHD(18),
	EIGTH(12),
	EIGTHT(8),
	SIXTEENTHD(9),
	SIXTEENTH(6),
	THIRTYSECOND(3);
	
	/**
	 * The note value itself.
	 */
	int val;
	
	/**
	 * Creates a new NoteValue with the given duration. 
	 * @param val The duration of the NoteValue
	 */
	NoteValue(int val) {
		this.val = val;
	}

}
