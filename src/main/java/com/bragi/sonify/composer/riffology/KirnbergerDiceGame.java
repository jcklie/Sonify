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
 * Sebastian Muszytowski - Digitalizing the sheet music and generating the midi files for every measure of the sheets. TLDR: The digitizing
 * Jan-Christoph Klie - Everything else
 * 
 *******************************************************************************/

package com.bragi.sonify.composer.riffology;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.Sequence;

import com.bragi.sonify.composer.AComposer;

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
 * controlled and corrected by hand. Then measure for measure was extracted to
 * MIDI files (they can be found in etc/midi/kirnberger).
 * 
 * To generate music, a dice represented by a random generator is used to choose
 * from the set of measures. How exactly the rules are can be read in the quoted
 * book or in the PDF found on www.pian-e-forte.de/noten/pdf/109599.pdf .
 * 
 * @author Sebastian Muszytowski <sebastian@muszytowski.net>
 * @author Jan-Christoph Klie
 */
public class KirnbergerDiceGame extends AComposer {

	private static List<Map<Integer, Integer>> measureMapList;
	private static final int NUM_MEASURES_PER_PART = 8;
	private static final int MIDI_RESOLUTION = 480;
	private static final String PATH_TO_MIDI_FORMAT = "etc" + File.separator + "midi" + File.separator + "kirnberger" + File.separator + "%d.mid";

	static {
		measureMapList = new LinkedList<Map<Integer, Integer>>();

		for (int i = 0; i < NUM_MEASURES_PER_PART*2; i++) {
			measureMapList.add(new HashMap<Integer, Integer>());
		}

		Map<Integer, Integer> measureMap;
		
		/*
		 * #######
		 * MEASURES OF THE FIRST PART
		 * #######
		 */

		/*
		 * Measure 1
		 */

		measureMap = measureMapList.get(0);
		measureMap.put(1, 23);
		measureMap.put(2, 63);
		measureMap.put(3, 79);
		measureMap.put(4, 13);
		measureMap.put(5, 43);
		measureMap.put(6, 32);

		/*
		 * Measure 2
		 */

		measureMap = measureMapList.get(1);
		measureMap.put(1, 77);
		measureMap.put(2, 54);
		measureMap.put(3, 75);
		measureMap.put(4, 57);
		measureMap.put(5, 7);
		measureMap.put(6, 47);

		/*
		 * Measure 3
		 */

		measureMap = measureMapList.get(2);
		measureMap.put(1, 62);
		measureMap.put(2, 2);
		measureMap.put(3, 42);
		measureMap.put(4, 64);
		measureMap.put(5, 86);
		measureMap.put(6, 84);

		/*
		 * Measure 4
		 */

		measureMap = measureMapList.get(3);
		measureMap.put(1, 70);
		measureMap.put(2, 53);
		measureMap.put(3, 5);
		measureMap.put(4, 74);
		measureMap.put(5, 31);
		measureMap.put(6, 20);

		/*
		 * Measure 5
		 */

		measureMap = measureMapList.get(4);
		measureMap.put(1, 29);
		measureMap.put(2, 41);
		measureMap.put(3, 50);
		measureMap.put(4, 11);
		measureMap.put(5, 18);
		measureMap.put(6, 22);

		/*
		 * Measure 6
		 */

		measureMap = measureMapList.get(5);
		measureMap.put(1, 83);
		measureMap.put(2, 37);
		measureMap.put(3, 69);
		measureMap.put(4, 3);
		measureMap.put(5, 89);
		measureMap.put(6, 49);

		/*
		 * Measure 7
		 */

		measureMap = measureMapList.get(6);
		measureMap.put(1, 59);
		measureMap.put(2, 71);
		measureMap.put(3, 52);
		measureMap.put(4, 67);
		measureMap.put(5, 87);
		measureMap.put(6, 56);

		/*
		 * Measure 8
		 */

		measureMap = measureMapList.get(7);
		measureMap.put(1, 36);
		measureMap.put(2, 90);
		measureMap.put(3, 8);
		measureMap.put(4, 73);
		measureMap.put(5, 58);
		measureMap.put(6, 48);
		
		/*
		 * #######
		 * MEASURES OF THE SECOND PART
		 * #######
		 */

		/*
		 * Measure 9
		 */

		measureMap = measureMapList.get(8);
		measureMap.put(1, 33);
		measureMap.put(2, 55);
		measureMap.put(3, 4);
		measureMap.put(4, 95);
		measureMap.put(5, 38);
		measureMap.put(6, 44);

		/*
		 * Measure 10
		 */

		measureMap = measureMapList.get(9);
		measureMap.put(1, 60);
		measureMap.put(2, 46);
		measureMap.put(3, 12);
		measureMap.put(4, 78);
		measureMap.put(5, 93);
		measureMap.put(6, 76);

		/*
		 * Measure 11
		 */

		measureMap = measureMapList.get(10);
		measureMap.put(1, 21);
		measureMap.put(2, 88);
		measureMap.put(3, 94);
		measureMap.put(4, 80);
		measureMap.put(5, 15);
		measureMap.put(6, 34);

		/*
		 * Measure 12
		 */

		measureMap = measureMapList.get(11);
		measureMap.put(1, 14);
		measureMap.put(2, 39);
		measureMap.put(3, 9);
		measureMap.put(4, 30);
		measureMap.put(5, 92);
		measureMap.put(6, 19);

		/*
		 * Measure 13
		 */

		measureMap = measureMapList.get(12);
		measureMap.put(1, 45);
		measureMap.put(2, 65);
		measureMap.put(3, 25);
		measureMap.put(4, 1);
		measureMap.put(5, 28);
		measureMap.put(6, 17);

		/*
		 * Measure 14
		 */

		measureMap = measureMapList.get(13);
		measureMap.put(1, 68);
		measureMap.put(2, 6);
		measureMap.put(3, 35);
		measureMap.put(4, 51);
		measureMap.put(5, 61);
		measureMap.put(6, 10);

		/*
		 * Measure 15
		 */

		measureMap = measureMapList.get(14);
		measureMap.put(1, 26);
		measureMap.put(2, 91);
		measureMap.put(3, 66);
		measureMap.put(4, 82);
		measureMap.put(5, 72);
		measureMap.put(6, 27);

		/*
		 * Measure 16
		 */

		measureMap = measureMapList.get(15);
		measureMap.put(1, 40);
		measureMap.put(2, 81);
		measureMap.put(3, 24);
		measureMap.put(4, 16);
		measureMap.put(5, 85);
		measureMap.put(6, 96);

	}

	public KirnbergerDiceGame(File f) throws IOException {
		super(f);
	}

	@Override
	public Sequence createSequence() throws InvalidMidiDataException, IOException {
		
		/**
		 * We repeat not only because the sequence would be too short, but also
		 * the sheet music tells us to repeat every part.
		 */
		
		MidiAppender appender = new MidiAppender(MIDI_RESOLUTION);
		Random r = new Random(analyzer.hashCode());
		
		List<Integer> randomSequence = new LinkedList<Integer>();

		// First part
		for (int i = 0; i < NUM_MEASURES_PER_PART; i++) {
			// One dice roll
			int diceRoll = r.nextInt(6) + 1;

			int measureNumber = measureMapList.get(i).get(diceRoll);
			File f = new File(String.format(PATH_TO_MIDI_FORMAT, measureNumber));
			appender.addFile(f);
			randomSequence.add(diceRoll);
		}
		
		// Repetition of first part
		for (int i = 0; i < NUM_MEASURES_PER_PART; i++) {
			int measureNumber = measureMapList.get(i).get(randomSequence.get(i));
			File f = new File(String.format(PATH_TO_MIDI_FORMAT, measureNumber));
			appender.addFile(f);			
		}

		// Second part
		/*
		 * Magic number NUM_MEASURES_PER_PART says that we use measures for the
		 * second part, which start at index NUM_MEASURES_PER_PART. Magic number
		 * NUM_MEASURES_PER_PART*2 says that we go to the last measure for the
		 * second part
		 */
		for (int i = NUM_MEASURES_PER_PART; i < NUM_MEASURES_PER_PART*2; i++) {
			// One dice roll
			int diceRoll = r.nextInt(6) + 1;

			int measureNumber = measureMapList.get(i).get(diceRoll);
			File f = new File(String.format(PATH_TO_MIDI_FORMAT, measureNumber));
			appender.addFile(f);	
			randomSequence.add(diceRoll);
		}
		
		// Repetition of second part
		for (int i = NUM_MEASURES_PER_PART; i < NUM_MEASURES_PER_PART*2; i++) {
			int measureNumber = measureMapList.get(i).get(randomSequence.get(i));
			File f = new File(String.format(PATH_TO_MIDI_FORMAT, measureNumber));
			appender.addFile(f);			
		}

		return appender.getSequence();
	}


}
