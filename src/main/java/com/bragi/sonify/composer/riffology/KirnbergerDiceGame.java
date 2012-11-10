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
 * Sebastian Muszytowski - Digitalizing the sheet music and generating the midi files for every measure of the sheets
 * Jan-Christoph Klie - Everything else
 * 
 *******************************************************************************/

package com.bragi.sonify.composer.riffology;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.Sequence;

import com.bragi.sonify.composer.AComposer;
import com.bragi.sonify.music.Measure;

/**
 * This AComposer uses the measures given by the sheet music
 * "Der allezeit fertige Polonoisen- und Menuettencomponist" from Johann Philipp
 * Kirnberger as found in [Haupenthal, Gerhard: Geschichte der Würfelmusik in
 * Beispielen. Teilband 2: Noten.]
 * 
 * The sheets there were handwritten and were digitized by using the Music OCR
 * (OMR, Optical Music Recognition) software capella scan
 * http://www.capella.de/us/index.cfm/products/capella-scan/info-capella-scan/.
 * 
 * Since the recognition was only 20-70 percent correct, the result was
 * controlled and measure for measure was extracted to MIDI files (can be found
 * in etc/midi/kirnberger.
 * 
 * To generate music, a dice represented by a random generator is used to choose
 * from the set of measures. How exactly the rules are can be read in the
 * quoted book or in the PDF found on www.pian-e-forte.de/noten/pdf/109599.pdf .
 */
public class KirnbergerDiceGame extends AComposer {

	public KirnbergerDiceGame(File f) throws IOException {
		super(f);		
	}	

	@Override
	public Sequence createSequence() throws InvalidMidiDataException, IOException {
		// TODO Auto-generated method stub
		return null;
	}
	


}
