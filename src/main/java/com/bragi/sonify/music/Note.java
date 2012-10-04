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
 * This enum holds constants for three octaves of notes, starting from A3.
 * Every note has its MIDI key number.
 * 
 * For a further description of numbering notes in MIDI, refer to * 
 * http://computermusicresource.com/midikeys.html
 */
public enum Note {
	
	/*
	 * Octave 3
	 */
	
	A3(57),
	Bb3(58),
	B3(59),
	C3(60),
	Db3(61),
	D3(62),
	Eb3(63),
	E3(64),
	F3(65),
	Gb3(66),
	G3(67),
	Ab3(68),
	
	/*
	 * Octave 4
	 */	
	
	A4(69),
	Bb4(70),
	B4(71),
	C4(72),
	Db4(73),
	D4(74),
	Eb4(75),
	E4(76),
	F4(77),
	Gb4(78),
	G4(79),
	Ab4(80),
	
	/*
	 * Octave 5
	 */	
	
	A5(81),
	Bb5(82),
	B5(83),
	C5(84),
	Db5(85),
	D5(86),
	Eb5(87),
	E5(88),
	F5(89),
	Gb5(90),
	G5(91),
	Ab5(92),
	
	/*
	 * Octave 6
	 */	
	
	A6(93),
	Bb6(94),
	B6(95),
	C6(96),
	Db6(97),
	D6(98),
	Eb6(99),
	E6(100),
	F6(101),
	Gb6(102),
	G6(103),
	Ab6(104);
	
	int key;
	
	Note(int k) {
		this.key = k;
	}

}
