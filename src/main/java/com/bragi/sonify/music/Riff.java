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

/**
 * A riff is considered to be a simple melodic fragment.
 */
public class Riff implements Iterable<Note> {	
	
	public static final Riff RIFF = new Riff(Note.A3,Note.B3,Note.C4,Note.D4);
	public static final Riff RIFF1 = new Riff(Note.E4,Note.D4,Note.C4,Note.B3);
	public static final Riff RIFF2 = new Riff(Note.C4,Note.D4,Note.E4,Note.F4);
	public static final Riff RIFF3 = new Riff(Note.Ab4,Note.F4,Note.E4,Note.D4);
	public static final Riff RIFF4 = new Riff(Note.E4,Note.F4,Note.Ab4,Note.A4);
	public static final Riff RIFF5 = new Riff(Note.B4,Note.A4,Note.Ab4,Note.F4);
	public static final Riff RIFF6 = new Riff(Note.Ab4,Note.A4,Note.B4,Note.C5);
	public static final Riff RIFF7 = new Riff(Note.D5,Note.C5,Note.B4,Note.A4);
	public static final Riff RIFF8 = new Riff(Note.A3,Note.C4,Note.B3,Note.D4);
	public static final Riff RIFF9 = new Riff(Note.E4,Note.C4,Note.D4,Note.B3);
	public static final Riff RIFF10 = new Riff(Note.C4,Note.E4,Note.D4,Note.F4);
	public static final Riff RIFF11 = new Riff(Note.Ab4,Note.E4,Note.F4,Note.D4);
	public static final Riff RIFF12 = new Riff(Note.E4,Note.Ab4,Note.F4,Note.A4);
	public static final Riff RIFF13 = new Riff(Note.B4,Note.Ab4,Note.A4,Note.F4);
	public static final Riff RIFF14 = new Riff(Note.Ab4,Note.B4,Note.A4,Note.C5);
	public static final Riff RIFF15 = new Riff(Note.D5,Note.B4,Note.C5,Note.A4);
	public static final Riff RIFF16 = new Riff(Note.A3,Note.B3,Note.C4,Note.A3);
	public static final Riff RIFF17 = new Riff(Note.B3,Note.C4,Note.D4,Note.B3);
	public static final Riff RIFF18 = new Riff(Note.C4,Note.D4,Note.E4,Note.C4);
	public static final Riff RIFF19 = new Riff(Note.D4,Note.E4,Note.F4,Note.D4);
	public static final Riff RIFF20 = new Riff(Note.E4,Note.D4,Note.C4,Note.E4);
	public static final Riff RIFF21 = new Riff(Note.D4,Note.C4,Note.B3,Note.D4);
	public static final Riff RIFF22 = new Riff(Note.C4,Note.B3,Note.A3,Note.C4);
	public static final Riff RIFF23 = new Riff(Note.B3,Note.A3,Note.Ab3,Note.B3);
	public static final Riff RIFF24 = new Riff(Note.B3,Note.A3,Note.B3,Note.C4);
	public static final Riff RIFF25 = new Riff(Note.D4,Note.C4,Note.D4,Note.E4);
	public static final Riff RIFF26 = new Riff(Note.F4,Note.E4,Note.F4,Note.Ab4);
	public static final Riff RIFF27 = new Riff(Note.A4,Note.Ab4,Note.A4,Note.B4);
	public static final Riff RIFF28 = new Riff(Note.A4,Note.B4,Note.A4,Note.Ab4);
	public static final Riff RIFF29 = new Riff(Note.F4,Note.Ab4,Note.F4,Note.E4);
	public static final Riff RIFF30 = new Riff(Note.D4,Note.E4,Note.D4,Note.C4);
	public static final Riff RIFF31 = new Riff(Note.B3,Note.C4,Note.B3,Note.A3);
	public static final Riff RIFF32 = new Riff(Note.A3,Note.C4,Note.E4,Note.C4);
	public static final Riff RIFF33 = new Riff(Note.B3,Note.E4,Note.Ab4,Note.D4);
	public static final Riff RIFF34 = new Riff(Note.C4,Note.E4,Note.A4,Note.E4);
	public static final Riff RIFF35 = new Riff(Note.D4,Note.F4,Note.A4,Note.F4);
	public static final Riff RIFF36 = new Riff(Note.E4,Note.Ab4,Note.B4,Note.Ab4);
	public static final Riff RIFF37 = new Riff(Note.F4,Note.A4,Note.C5,Note.A4);
	public static final Riff RIFF38 = new Riff(Note.Ab4,Note.B4,Note.D5,Note.B4);
	public static final Riff RIFF39 = new Riff(Note.C5,Note.A4,Note.E4,Note.C4);
	public static final Riff RIFF40 = new Riff(Note.A4,Note.E4,Note.C4,Note.A3);
	public static final Riff RIFF41 = new Riff(Note.Ab4,Note.E4,Note.D4,Note.B3);
	public static final Riff RIFF42 = new Riff(Note.F4,Note.D4,Note.A3,Note.F3);
	public static final Riff RIFF43 = new Riff(Note.E4,Note.C4,Note.A3,Note.E3);
	public static final Riff RIFF44 = new Riff(Note.D4,Note.B3,Note.Ab3,Note.E3);
	public static final Riff RIFF45 = new Riff(Note.D3,Note.A3,Note.F4,Note.A4);
	public static final Riff RIFF46 = new Riff(Note.E3,Note.B3,Note.D4,Note.Ab4);
	public static final Riff RIFF47 = new Riff(Note.E3,Note.A3,Note.E4,Note.C5);
	public static final Riff RIFF48 = new Riff(Note.A4,Note.E4,Note.A4,Note.C5);
	public static final Riff RIFF49 = new Riff(Note.B4,Note.E4,Note.B4,Note.D5);
	public static final Riff RIFF50 = new Riff(Note.C5,Note.E4,Note.C5,Note.E5);
	public static final Riff RIFF51 = new Riff(Note.D5,Note.Ab4,Note.D5,Note.F5);
	public static final Riff RIFF52 = new Riff(Note.E5,Note.Eb5,Note.E5,Note.B4);
	public static final Riff RIFF53 = new Riff(Note.C5,Note.B4,Note.C5,Note.A4);
	public static final Riff RIFF54 = new Riff(Note.B4,Note.Bb4,Note.B4,Note.Ab4);
	public static final Riff RIFF55 = new Riff(Note.A4,Note.Ab4,Note.A4,Note.E4);
	public static final Riff RIFF56 = new Riff(Note.Eb4,Note.D4,Note.A4,Note.F4,Note.E4,Note.C5,Note.A4,Note.A4);
	public static final Riff RIFF57 = new Riff(Note.F4,Note.A4,Note.Eb5,Note.D5,Note.E4,Note.A4,Note.C5,Note.A4);
	public static final Riff RIFF58 = new Riff(Note.Ab4,Note.A4,Note.B5,Note.G5,Note.B5,Note.Eb5,Note.C5,Note.E5);
	public static final Riff RIFF59 = new Riff(Note.Ab4,Note.A4,Note.B4,Note.C5,Note.Eb5,Note.E5,Note.Ab5,Note.A5);
	public static final Riff RIFF60 = new Riff(Note.A4,Note.Bb4,Note.B4,Note.C5,Note.Db5,Note.D5,Note.Eb5,Note.E5);
	public static final Riff RIFF61 = new Riff(Note.A4,Note.Bb4,Note.B4,Note.C5,Note.E5,Note.Eb5,Note.D5,Note.C5);
	public static final Riff RIFF62 = new Riff(Note.A4,Note.B4,Note.C5,Note.A4,Note.B4,Note.C5,Note.D5,Note.B4);
	public static final Riff RIFF63 = new Riff(Note.A4,Note.B4,Note.C5,Note.D5,Note.Eb5,Note.E5,Note.Eb5,Note.C5);
	public static final Riff RIFF64 = new Riff(Note.A4,Note.C5,Note.D5,Note.Eb5,Note.Gb5,Note.Ab5,Note.A5,Note.C6); /* Pat Metheny */
	public static final Riff RIFF65 = new Riff(Note.A4,Note.C5,Note.Eb5,Note.B4,Note.D5,Note.F5,Note.Eb5,Note.C5);
	public static final Riff RIFF66 = new Riff(Note.A4,Note.C5,Note.E5,Note.G5,Note.B5,Note.A5,Note.G5,Note.E5);
	public static final Riff RIFF67 = new Riff(Note.A4,Note.C5,Note.E5,Note.A5,Note.G5,Note.Eb5,Note.C5,Note.A4);
	public static final Riff RIFF68 = new Riff(Note.B4,Note.A4,Note.B4,Note.C5,Note.B4,Note.A4,Note.B4,Note.C5);
	public static final Riff RIFF69 = new Riff(Note.B4,Note.A4,Note.B4,Note.C5,Note.B4,Note.C5,Note.B4,Note.A4);
	public static final Riff RIFF70 = new Riff(Note.B4,Note.A4,Note.B4,Note.C5,Note.D5,Note.C5,Note.D5,Note.Eb5);
	public static final Riff RIFF71 = new Riff(Note.C5,Note.Ab4,Note.A4,Note.G5,Note.F5,Note.Gb5,Note.Eb5,Note.E5); /* Marty Cutler */
	public static final Riff RIFF72 = new Riff(Note.C5,Note.D5,Note.C5,Note.B4,Note.C5,Note.B4,Note.A4,Note.B5);
	public static final Riff RIFF73 = new Riff(Note.C5,Note.D5,Note.Eb5,Note.C5,Note.D5,Note.Eb5,Note.F5,Note.D5);
	public static final Riff RIFF74 = new Riff(Note.D5,Note.C5,Note.A4,Note.C5,Note.E5,Note.Eb5,Note.D5,Note.C5);
	public static final Riff RIFF75 = new Riff(Note.D5,Note.C5,Note.D5,Note.Eb5,Note.D5,Note.C5,Note.D5,Note.Eb5);
	public static final Riff RIFF76 = new Riff(Note.D5,Note.Eb5,Note.E5,Note.F5,Note.Gb5,Note.G5,Note.Ab5,Note.A5);
	public static final Riff RIFF77 = new Riff(Note.D5,Note.Eb5,Note.G5,Note.Eb5,Note.D5,Note.C5,Note.B4,Note.C5); /* Charlie Keagle */
	public static final Riff RIFF78 = new Riff(Note.D5,Note.Eb5,Note.A5,Note.D5,Note.B5,Note.C5,Note.A4,Note.E4);
	public static final Riff RIFF79 = new Riff(Note.D5,Note.E5,Note.G5,Note.E5,Note.C5,Note.B5,Note.D5,Note.A5); /* Lyle Mays / Steve Cantor */
	public static final Riff RIFF80 = new Riff(Note.Eb5,Note.D5,Note.Eb5,Note.D5,Note.B5,Note.C5,Note.A4,Note.B5);
	public static final Riff RIFF81 = new Riff(Note.Eb5,Note.D5,Note.Eb5,Note.F5,Note.Eb5,Note.D5,Note.C5,Note.B4);
	public static final Riff RIFF82 = new Riff(Note.Eb5,Note.E5,Note.D5,Note.C5,Note.B4,Note.A4,Note.Ab4,Note.A4); /* Richie Shulberg */
	public static final Riff RIFF83 = new Riff(Note.Eb5,Note.E5,Note.A5,Note.C5,Note.B4,Note.E5,Note.A4,Note.A4);
	public static final Riff RIFF84 = new Riff(Note.Eb5,Note.Gb5,Note.E5,Note.A4,Note.B4,Note.D5,Note.C5,Note.E4); /* Django Rheinhart */
	public static final Riff RIFF85 = new Riff(Note.E5,Note.A4,Note.C5,Note.Ab4,Note.B4,Note.G4,Note.Gb4,Note.E4); /* David Levine */
	public static final Riff RIFF86 = new Riff(Note.E5,Note.Eb5,Note.D5,Note.C5,Note.B4,Note.C5,Note.D5,Note.F5);
	public static final Riff RIFF87 = new Riff(Note.G5,Note.E5,Note.D5,Note.B4,Note.Eb5,Note.B5,Note.C5,Note.A4);
	public static final Riff RIFF88 = new Riff(Note.G5,Note.E5,Note.D5,Note.Gb5,Note.C5,Note.B5,Note.A4,Note.B5); /* Mike Cross */
	public static final Riff RIFF89 = new Riff(Note.Ab5,Note.A5,Note.Ab5,Note.A5,Note.Ab5,Note.A5,Note.Ab5,Note.A5); /* Django Rheinhart */
	public static final Riff RIFF90 = new Riff(Note.A5,Note.E5,Note.C5,Note.G4,Note.C5,Note.E5,Note.A5,Note.A5); /* Django Rheinhart */
	public static final Riff RIFF91 = new Riff(Note.A5,Note.E5,Note.C5,Note.A4,Note.G5,Note.Eb5,Note.C5,Note.A4);
	public static final Riff RIFF92 = new Riff(Note.A5,Note.B5,Note.G5,Note.E5,Note.F5,Note.Gb5,Note.G5,Note.Ab5);
	public static final Riff RIFF93 = new Riff(Note.B5,Note.C6,Note.A5,Note.E5,Note.G5,Note.B5,Note.A5,Note.B5);
	public static final Riff RIFF94 = new Riff(Note.B5,Note.D6,Note.C6,Note.E5,Note.Ab5,Note.B5,Note.A5,Note.C5); /* Django Rheinhart */

	private Note[] data;

	/**
	 * Finally, a usage for varargs.
	 * 
	 * @param data The data
	 */
	public Riff(Note... data) {
		this.data = data;
	}

	private class RiffIterator implements Iterator<Note> {
		private Note[] data;
		private int pos = 0;

		public RiffIterator(Note[] data) {
			this.data = data;
		}

		public boolean hasNext() {
			return pos < data.length;
		}

		public Note next() {
			return data[pos++];			
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

	@Override
	public Iterator<Note> iterator() {
		return new RiffIterator(data);
	}

}
