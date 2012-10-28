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
 * An interval is the distance between two notes. Intervals are always counted
 * from the lower note to the higher one, with the lower note being counted as
 * one. Intervals come in different qualities and size. This enum describes 
 * all possible intervals which can occur in one octave (12 semitones) by
 * the number of semitones between two given notes.
 * 
 * @author Jan-Christoph Klie
 */
public enum Interval {

	MINOR_SECOND_D(-1),
	MAJOR_SECOND_D(-2),
	MINOR_THIRD_D(-3),
	MAJOR_THIRD_D(-4),
	PERFECT_FOURTH_D(-5),
	DIMINISHED_FIFTH_D(-6),
	PERFECT_FIFTH_D(-7),
	MINOR_SIXTH_D(-8),
	MAJOR_SIXTH_D(-9),
	MINOR_SEVENTH_D(-10),
	MAJOR_SEVENTH_D(-11),
	PERFECT_OCTAVE_D(-12),
	PERFECT_UNISON(0),
	MINOR_SECOND(1),
	MAJOR_SECOND(2),
	MINOR_THIRD(3),
	MAJOR_THIRD(4),
	PERFECT_FOURTH(5),
	DIMINISHED_FIFTH(6),
	PERFECT_FIFTH(7),
	MINOR_SIXTH(8),
	MAJOR_SIXTH(9),
	MINOR_SEVENTH(10),
	MAJOR_SEVENTH(11),
	PERFECT_OCTAVE(12);

	/**
	 * The number of semitones
	 */
	int val;
	
	/**
	 * An interval, described by the number of semitones between two given notes
	 * @param val The number of semitones difference.
	 */
	Interval(int val) {
		this.val = val;
	}

}
