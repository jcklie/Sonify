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
 * Jan-Christoph Klie - Everything but RIFF statics
 * Sebastian Muszytowski - Epic Shell magic and editor regular expression magic to extract riffs from text
 * 
 *******************************************************************************/

package com.bragi.sonify.music;

import java.util.Iterator;

import com.bragi.sonify.util.ArrayIterator;

/**
 * A riff is considered to be a simple melodic fragment.
 * 
 * @deprecated
 * @author Sebastian Muszytowski
 * @author Jan-Christoph Klie
 */
public class Riff implements Iterable<Pitch> {	
	
	public static final Riff RIFF = new Riff(Pitch.A3,Pitch.B3,Pitch.C4,Pitch.D4);
	public static final Riff RIFF1 = new Riff(Pitch.E4,Pitch.D4,Pitch.C4,Pitch.B3);
	public static final Riff RIFF2 = new Riff(Pitch.C4,Pitch.D4,Pitch.E4,Pitch.F4);
	public static final Riff RIFF3 = new Riff(Pitch.Ab4,Pitch.F4,Pitch.E4,Pitch.D4);
	public static final Riff RIFF4 = new Riff(Pitch.E4,Pitch.F4,Pitch.Ab4,Pitch.A4);
	public static final Riff RIFF5 = new Riff(Pitch.B4,Pitch.A4,Pitch.Ab4,Pitch.F4);
	public static final Riff RIFF6 = new Riff(Pitch.Ab4,Pitch.A4,Pitch.B4,Pitch.C5);
	public static final Riff RIFF7 = new Riff(Pitch.D5,Pitch.C5,Pitch.B4,Pitch.A4);
	public static final Riff RIFF8 = new Riff(Pitch.A3,Pitch.C4,Pitch.B3,Pitch.D4);
	public static final Riff RIFF9 = new Riff(Pitch.E4,Pitch.C4,Pitch.D4,Pitch.B3);
	public static final Riff RIFF10 = new Riff(Pitch.C4,Pitch.E4,Pitch.D4,Pitch.F4);
	public static final Riff RIFF11 = new Riff(Pitch.Ab4,Pitch.E4,Pitch.F4,Pitch.D4);
	public static final Riff RIFF12 = new Riff(Pitch.E4,Pitch.Ab4,Pitch.F4,Pitch.A4);
	public static final Riff RIFF13 = new Riff(Pitch.B4,Pitch.Ab4,Pitch.A4,Pitch.F4);
	public static final Riff RIFF14 = new Riff(Pitch.Ab4,Pitch.B4,Pitch.A4,Pitch.C5);
	public static final Riff RIFF15 = new Riff(Pitch.D5,Pitch.B4,Pitch.C5,Pitch.A4);
	public static final Riff RIFF16 = new Riff(Pitch.A3,Pitch.B3,Pitch.C4,Pitch.A3);
	public static final Riff RIFF17 = new Riff(Pitch.B3,Pitch.C4,Pitch.D4,Pitch.B3);
	public static final Riff RIFF18 = new Riff(Pitch.C4,Pitch.D4,Pitch.E4,Pitch.C4);
	public static final Riff RIFF19 = new Riff(Pitch.D4,Pitch.E4,Pitch.F4,Pitch.D4);
	public static final Riff RIFF20 = new Riff(Pitch.E4,Pitch.D4,Pitch.C4,Pitch.E4);
	public static final Riff RIFF21 = new Riff(Pitch.D4,Pitch.C4,Pitch.B3,Pitch.D4);
	public static final Riff RIFF22 = new Riff(Pitch.C4,Pitch.B3,Pitch.A3,Pitch.C4);
	public static final Riff RIFF23 = new Riff(Pitch.B3,Pitch.A3,Pitch.Ab3,Pitch.B3);
	public static final Riff RIFF24 = new Riff(Pitch.B3,Pitch.A3,Pitch.B3,Pitch.C4);
	public static final Riff RIFF25 = new Riff(Pitch.D4,Pitch.C4,Pitch.D4,Pitch.E4);
	public static final Riff RIFF26 = new Riff(Pitch.F4,Pitch.E4,Pitch.F4,Pitch.Ab4);
	public static final Riff RIFF27 = new Riff(Pitch.A4,Pitch.Ab4,Pitch.A4,Pitch.B4);
	public static final Riff RIFF28 = new Riff(Pitch.A4,Pitch.B4,Pitch.A4,Pitch.Ab4);
	public static final Riff RIFF29 = new Riff(Pitch.F4,Pitch.Ab4,Pitch.F4,Pitch.E4);
	public static final Riff RIFF30 = new Riff(Pitch.D4,Pitch.E4,Pitch.D4,Pitch.C4);
	public static final Riff RIFF31 = new Riff(Pitch.B3,Pitch.C4,Pitch.B3,Pitch.A3);
	public static final Riff RIFF32 = new Riff(Pitch.A3,Pitch.C4,Pitch.E4,Pitch.C4);
	public static final Riff RIFF33 = new Riff(Pitch.B3,Pitch.E4,Pitch.Ab4,Pitch.D4);
	public static final Riff RIFF34 = new Riff(Pitch.C4,Pitch.E4,Pitch.A4,Pitch.E4);
	public static final Riff RIFF35 = new Riff(Pitch.D4,Pitch.F4,Pitch.A4,Pitch.F4);
	public static final Riff RIFF36 = new Riff(Pitch.E4,Pitch.Ab4,Pitch.B4,Pitch.Ab4);
	public static final Riff RIFF37 = new Riff(Pitch.F4,Pitch.A4,Pitch.C5,Pitch.A4);
	public static final Riff RIFF38 = new Riff(Pitch.Ab4,Pitch.B4,Pitch.D5,Pitch.B4);
	public static final Riff RIFF39 = new Riff(Pitch.C5,Pitch.A4,Pitch.E4,Pitch.C4);
	public static final Riff RIFF40 = new Riff(Pitch.A4,Pitch.E4,Pitch.C4,Pitch.A3);
	public static final Riff RIFF41 = new Riff(Pitch.Ab4,Pitch.E4,Pitch.D4,Pitch.B3);
	public static final Riff RIFF42 = new Riff(Pitch.F4,Pitch.D4,Pitch.A3,Pitch.F3);
	public static final Riff RIFF43 = new Riff(Pitch.E4,Pitch.C4,Pitch.A3,Pitch.E3);
	public static final Riff RIFF44 = new Riff(Pitch.D4,Pitch.B3,Pitch.Ab3,Pitch.E3);
	public static final Riff RIFF45 = new Riff(Pitch.D3,Pitch.A3,Pitch.F4,Pitch.A4);
	public static final Riff RIFF46 = new Riff(Pitch.E3,Pitch.B3,Pitch.D4,Pitch.Ab4);
	public static final Riff RIFF47 = new Riff(Pitch.E3,Pitch.A3,Pitch.E4,Pitch.C5);
	public static final Riff RIFF48 = new Riff(Pitch.A4,Pitch.E4,Pitch.A4,Pitch.C5);
	public static final Riff RIFF49 = new Riff(Pitch.B4,Pitch.E4,Pitch.B4,Pitch.D5);
	public static final Riff RIFF50 = new Riff(Pitch.C5,Pitch.E4,Pitch.C5,Pitch.E5);
	public static final Riff RIFF51 = new Riff(Pitch.D5,Pitch.Ab4,Pitch.D5,Pitch.F5);
	public static final Riff RIFF52 = new Riff(Pitch.E5,Pitch.Eb5,Pitch.E5,Pitch.B4);
	public static final Riff RIFF53 = new Riff(Pitch.C5,Pitch.B4,Pitch.C5,Pitch.A4);
	public static final Riff RIFF54 = new Riff(Pitch.B4,Pitch.Bb4,Pitch.B4,Pitch.Ab4);
	public static final Riff RIFF55 = new Riff(Pitch.A4,Pitch.Ab4,Pitch.A4,Pitch.E4);
	public static final Riff RIFF56 = new Riff(Pitch.Eb4,Pitch.D4,Pitch.A4,Pitch.F4,Pitch.E4,Pitch.C5,Pitch.A4,Pitch.A4);
	public static final Riff RIFF57 = new Riff(Pitch.F4,Pitch.A4,Pitch.Eb5,Pitch.D5,Pitch.E4,Pitch.A4,Pitch.C5,Pitch.A4);
	public static final Riff RIFF58 = new Riff(Pitch.Ab4,Pitch.A4,Pitch.B5,Pitch.G5,Pitch.B5,Pitch.Eb5,Pitch.C5,Pitch.E5);
	public static final Riff RIFF59 = new Riff(Pitch.Ab4,Pitch.A4,Pitch.B4,Pitch.C5,Pitch.Eb5,Pitch.E5,Pitch.Ab5,Pitch.A5);
	public static final Riff RIFF60 = new Riff(Pitch.A4,Pitch.Bb4,Pitch.B4,Pitch.C5,Pitch.Db5,Pitch.D5,Pitch.Eb5,Pitch.E5);
	public static final Riff RIFF61 = new Riff(Pitch.A4,Pitch.Bb4,Pitch.B4,Pitch.C5,Pitch.E5,Pitch.Eb5,Pitch.D5,Pitch.C5);
	public static final Riff RIFF62 = new Riff(Pitch.A4,Pitch.B4,Pitch.C5,Pitch.A4,Pitch.B4,Pitch.C5,Pitch.D5,Pitch.B4);
	public static final Riff RIFF63 = new Riff(Pitch.A4,Pitch.B4,Pitch.C5,Pitch.D5,Pitch.Eb5,Pitch.E5,Pitch.Eb5,Pitch.C5);
	public static final Riff RIFF64 = new Riff(Pitch.A4,Pitch.C5,Pitch.D5,Pitch.Eb5,Pitch.Gb5,Pitch.Ab5,Pitch.A5,Pitch.C6); /* Pat Metheny */
	public static final Riff RIFF65 = new Riff(Pitch.A4,Pitch.C5,Pitch.Eb5,Pitch.B4,Pitch.D5,Pitch.F5,Pitch.Eb5,Pitch.C5);
	public static final Riff RIFF66 = new Riff(Pitch.A4,Pitch.C5,Pitch.E5,Pitch.G5,Pitch.B5,Pitch.A5,Pitch.G5,Pitch.E5);
	public static final Riff RIFF67 = new Riff(Pitch.A4,Pitch.C5,Pitch.E5,Pitch.A5,Pitch.G5,Pitch.Eb5,Pitch.C5,Pitch.A4);
	public static final Riff RIFF68 = new Riff(Pitch.B4,Pitch.A4,Pitch.B4,Pitch.C5,Pitch.B4,Pitch.A4,Pitch.B4,Pitch.C5);
	public static final Riff RIFF69 = new Riff(Pitch.B4,Pitch.A4,Pitch.B4,Pitch.C5,Pitch.B4,Pitch.C5,Pitch.B4,Pitch.A4);
	public static final Riff RIFF70 = new Riff(Pitch.B4,Pitch.A4,Pitch.B4,Pitch.C5,Pitch.D5,Pitch.C5,Pitch.D5,Pitch.Eb5);
	public static final Riff RIFF71 = new Riff(Pitch.C5,Pitch.Ab4,Pitch.A4,Pitch.G5,Pitch.F5,Pitch.Gb5,Pitch.Eb5,Pitch.E5); /* Marty Cutler */
	public static final Riff RIFF72 = new Riff(Pitch.C5,Pitch.D5,Pitch.C5,Pitch.B4,Pitch.C5,Pitch.B4,Pitch.A4,Pitch.B5);
	public static final Riff RIFF73 = new Riff(Pitch.C5,Pitch.D5,Pitch.Eb5,Pitch.C5,Pitch.D5,Pitch.Eb5,Pitch.F5,Pitch.D5);
	public static final Riff RIFF74 = new Riff(Pitch.D5,Pitch.C5,Pitch.A4,Pitch.C5,Pitch.E5,Pitch.Eb5,Pitch.D5,Pitch.C5);
	public static final Riff RIFF75 = new Riff(Pitch.D5,Pitch.C5,Pitch.D5,Pitch.Eb5,Pitch.D5,Pitch.C5,Pitch.D5,Pitch.Eb5);
	public static final Riff RIFF76 = new Riff(Pitch.D5,Pitch.Eb5,Pitch.E5,Pitch.F5,Pitch.Gb5,Pitch.G5,Pitch.Ab5,Pitch.A5);
	public static final Riff RIFF77 = new Riff(Pitch.D5,Pitch.Eb5,Pitch.G5,Pitch.Eb5,Pitch.D5,Pitch.C5,Pitch.B4,Pitch.C5); /* Charlie Keagle */
	public static final Riff RIFF78 = new Riff(Pitch.D5,Pitch.Eb5,Pitch.A5,Pitch.D5,Pitch.B5,Pitch.C5,Pitch.A4,Pitch.E4);
	public static final Riff RIFF79 = new Riff(Pitch.D5,Pitch.E5,Pitch.G5,Pitch.E5,Pitch.C5,Pitch.B5,Pitch.D5,Pitch.A5); /* Lyle Mays / Steve Cantor */
	public static final Riff RIFF80 = new Riff(Pitch.Eb5,Pitch.D5,Pitch.Eb5,Pitch.D5,Pitch.B5,Pitch.C5,Pitch.A4,Pitch.B5);
	public static final Riff RIFF81 = new Riff(Pitch.Eb5,Pitch.D5,Pitch.Eb5,Pitch.F5,Pitch.Eb5,Pitch.D5,Pitch.C5,Pitch.B4);
	public static final Riff RIFF82 = new Riff(Pitch.Eb5,Pitch.E5,Pitch.D5,Pitch.C5,Pitch.B4,Pitch.A4,Pitch.Ab4,Pitch.A4); /* Richie Shulberg */
	public static final Riff RIFF83 = new Riff(Pitch.Eb5,Pitch.E5,Pitch.A5,Pitch.C5,Pitch.B4,Pitch.E5,Pitch.A4,Pitch.A4);
	public static final Riff RIFF84 = new Riff(Pitch.Eb5,Pitch.Gb5,Pitch.E5,Pitch.A4,Pitch.B4,Pitch.D5,Pitch.C5,Pitch.E4); /* Django Rheinhart */
	public static final Riff RIFF85 = new Riff(Pitch.E5,Pitch.A4,Pitch.C5,Pitch.Ab4,Pitch.B4,Pitch.G4,Pitch.Gb4,Pitch.E4); /* David Levine */
	public static final Riff RIFF86 = new Riff(Pitch.E5,Pitch.Eb5,Pitch.D5,Pitch.C5,Pitch.B4,Pitch.C5,Pitch.D5,Pitch.F5);
	public static final Riff RIFF87 = new Riff(Pitch.G5,Pitch.E5,Pitch.D5,Pitch.B4,Pitch.Eb5,Pitch.B5,Pitch.C5,Pitch.A4);
	public static final Riff RIFF88 = new Riff(Pitch.G5,Pitch.E5,Pitch.D5,Pitch.Gb5,Pitch.C5,Pitch.B5,Pitch.A4,Pitch.B5); /* Mike Cross */
	public static final Riff RIFF89 = new Riff(Pitch.Ab5,Pitch.A5,Pitch.Ab5,Pitch.A5,Pitch.Ab5,Pitch.A5,Pitch.Ab5,Pitch.A5); /* Django Rheinhart */
	public static final Riff RIFF90 = new Riff(Pitch.A5,Pitch.E5,Pitch.C5,Pitch.G4,Pitch.C5,Pitch.E5,Pitch.A5,Pitch.A5); /* Django Rheinhart */
	public static final Riff RIFF91 = new Riff(Pitch.A5,Pitch.E5,Pitch.C5,Pitch.A4,Pitch.G5,Pitch.Eb5,Pitch.C5,Pitch.A4);
	public static final Riff RIFF92 = new Riff(Pitch.A5,Pitch.B5,Pitch.G5,Pitch.E5,Pitch.F5,Pitch.Gb5,Pitch.G5,Pitch.Ab5);
	public static final Riff RIFF93 = new Riff(Pitch.B5,Pitch.C6,Pitch.A5,Pitch.E5,Pitch.G5,Pitch.B5,Pitch.A5,Pitch.B5);
	public static final Riff RIFF94 = new Riff(Pitch.B5,Pitch.D6,Pitch.C6,Pitch.E5,Pitch.Ab5,Pitch.B5,Pitch.A5,Pitch.C5); /* Django Rheinhart */

	private Pitch[] data;

	/**
	 * Finally, a usage for varargs.
	 * 
	 * @param data The data
	 */
	public Riff(Pitch... data) {
		this.data = data;
	}
	
	protected Pitch[] getData() {
		return data;
	}

	@Override
	public Iterator<Pitch> iterator() {
		return new ArrayIterator<Pitch>(data);
	}

}
