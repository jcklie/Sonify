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
 * Sebastian Muszytowski - Digitalizing the sheet music and generating the midi files for every measure of the sheets TLDR: The digitizing
 * Jan-Christoph Klie - Everything else
 * 
 *******************************************************************************/

package com.bragi.sonify.composer.riffology;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.Sequence;

import com.bragi.sonify.composer.AComposer;
import com.bragi.sonify.util.FileUtil;

/**
 * This AComposer uses the measures given by the sheet music
 * "Kontre-Tänze (Contra-Dance), K6 Anh. C30.01 (K3 Anh. 294d)" by Wolfgang
 * Amadeus Mozart as found on http://253.ccarh.org/lab/kerndice/.
 * 
 * Only the measures of the second part were used. Additionally, we cheat a bit
 * and add the first measure of the first contra dice game part to the start of
 * this game to get a nice beginning.
 * 
 * To generate music, a dice represented by a random generator is used to choose
 * from the set of measures. How exactly the rules are can be read on the quoted
 * web page.
 * 
 * @author Sebastian Muszytowski <sebastian@muszytowski.net>
 * @author Jan-Christoph Klie
 */
public class MozartContraDanceTwoDiceGame extends AComposer {

	private static List<Map<Integer, Integer>> measureMapList;
	private static final int NUM_MEASURES = 9;
	private static final int MIDI_RESOLUTION = 120;
	private static final String PATH_TO_MIDI_FORMAT = "/midi/mozart_contra/C%d.mid";
	private static final int REPEATS = 2;

	static {
		measureMapList = new LinkedList<Map<Integer, Integer>>();

		for (int i = 0; i < NUM_MEASURES; i++) {
			measureMapList.add(new HashMap<Integer, Integer>());
		}

		Map<Integer, Integer> measureMap;

		/*
		 * Measure 1
		 */

		measureMap = measureMapList.get(0);
		measureMap.put(2, 70);
		measureMap.put(3, 10);
		measureMap.put(4, 33);
		measureMap.put(5, 36);
		measureMap.put(6, 105);
		measureMap.put(7, 165);
		measureMap.put(8, 7);
		measureMap.put(9, 142);
		measureMap.put(10, 99);
		measureMap.put(11, 85);
		measureMap.put(12, 145);

		/*
		 * Measure 2
		 */

		measureMap = measureMapList.get(1);
		measureMap.put(2, 155);
		measureMap.put(3, 148);
		measureMap.put(4, 22);
		measureMap.put(5, 4);
		measureMap.put(6, 136);
		measureMap.put(7, 144);
		measureMap.put(8, 116);
		measureMap.put(9, 66);
		measureMap.put(10, 93);
		measureMap.put(11, 61);
		measureMap.put(12, 50);

		/*
		 * Measure 3
		 */

		measureMap = measureMapList.get(2);
		measureMap.put(2, 3);
		measureMap.put(3, 28);
		measureMap.put(4, 176);
		measureMap.put(5, 157);
		measureMap.put(6, 91);
		measureMap.put(7, 104);
		measureMap.put(8, 133);
		measureMap.put(9, 124);
		measureMap.put(10, 55);
		measureMap.put(11, 34);
		measureMap.put(12, 79);

		/*
		 * Measure 4
		 */

		measureMap = measureMapList.get(3);
		measureMap.put(2, 162);
		measureMap.put(3, 135);
		measureMap.put(4, 62);
		measureMap.put(5, 38);
		measureMap.put(6, 138);
		measureMap.put(7, 87);
		measureMap.put(8, 72);
		measureMap.put(9, 26);
		measureMap.put(10, 29);
		measureMap.put(11, 119);
		measureMap.put(12, 175);

		/*
		 * Measure 5
		 */

		measureMap = measureMapList.get(4);
		measureMap.put(2, 170);
		measureMap.put(3, 173);
		measureMap.put(4, 126);
		measureMap.put(5, 9);
		measureMap.put(6, 19);
		measureMap.put(7, 107);
		measureMap.put(8, 141);
		measureMap.put(9, 84);
		measureMap.put(10, 51);
		measureMap.put(11, 46);
		measureMap.put(12, 76);

		/*
		 * Measure 6
		 */

		measureMap = measureMapList.get(5);
		measureMap.put(2, 13);
		measureMap.put(3, 169);
		measureMap.put(4, 31);
		measureMap.put(5, 151);
		measureMap.put(6, 134);
		measureMap.put(7, 128);
		measureMap.put(8, 94);
		measureMap.put(9, 75);
		measureMap.put(10, 42);
		measureMap.put(11, 59);
		measureMap.put(12, 113);

		/*
		 * Measure 7
		 */

		measureMap = measureMapList.get(6);
		measureMap.put(2, 166);
		measureMap.put(3, 174);
		measureMap.put(4, 24);
		measureMap.put(5, 32);
		measureMap.put(6, 101);
		measureMap.put(7, 48);
		measureMap.put(8, 80);
		measureMap.put(9, 103);
		measureMap.put(10, 110);
		measureMap.put(11, 54);
		measureMap.put(12, 88);

		/*
		 * Measure 8
		 */

		measureMap = measureMapList.get(7);
		measureMap.put(2, 95);
		measureMap.put(3, 2);
		measureMap.put(4, 159);
		measureMap.put(5, 17);
		measureMap.put(6, 154);
		measureMap.put(7, 109);
		measureMap.put(8, 129);
		measureMap.put(9, 96);
		measureMap.put(10, 108);
		measureMap.put(11, 60);
		measureMap.put(12, 53);

		/*
		 * Measure 9
		 */

		measureMap = measureMapList.get(8);
		measureMap.put(2, 5);
		measureMap.put(3, 20);
		measureMap.put(4, 41);
		measureMap.put(5, 171);
		measureMap.put(6, 146);
		measureMap.put(7, 74);
		measureMap.put(8, 65);
		measureMap.put(9, 127);
		measureMap.put(10, 98);
		measureMap.put(11, 47);
		measureMap.put(12, 118);



	}

	public MozartContraDanceTwoDiceGame(File f) throws IOException {
		super(f);
	}

	@Override
	public Sequence createSequence() throws InvalidMidiDataException, IOException {
		MidiAppender appender = new MidiAppender(MIDI_RESOLUTION);
		Random r = new Random(analyzer.hashCode());

		for( int repeat = 0; repeat <= REPEATS; repeat++) {
			for (int i = 0; i < NUM_MEASURES; i++) {
	
				// Two Dice rolles, to keep the spirit of the game
				int diceRoll1 = r.nextInt(6) + 1;
				int diceRoll2 = r.nextInt(6) + 1;
				int measureNumber = measureMapList.get(i).get(diceRoll1 + diceRoll2);
	
				InputStream stream = FileUtil.getResourcetStream(String.format(PATH_TO_MIDI_FORMAT, measureNumber));
				appender.addFile(stream);
				stream.close();
			}
		}

		return appender.getSequence();
	}
}
