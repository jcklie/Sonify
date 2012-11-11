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
 * Sebastian Muszytowski - Digitizing the sheet music and generating the midi files for every measure of the sheets TLDR: The digitizing
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
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;

import com.bragi.sonify.composer.AComposer;
import com.bragi.sonify.util.FileUtil;

/**
 * This AComposer uses the measures given by the sheet music
 * "Kontre-Tänze (Contra-Dance), K6 Anh. C30.01 (K3 Anh. 294d)" by Wolfgang
 * Amadeus Mozart as found on http://253.ccarh.org/lab/kerndice/.
 * 
 * Only the measures of the first part were used. Additionally, we cheat a bit
 * and add the last measure of the second contra dice game part to the end of
 * this game to get a nice ending.
 * 
 * To generate music, a dice represented by a random generator is used to choose
 * from the set of measures. How exactly the rules are can be read on the quoted
 * web page.
 * 
 * @author Sebastian Muszytowski <sebastian@muszytowski.net>
 * @author Jan-Christoph Klie
 */
public class MozartContraDanceOneDiceGame extends AComposer {

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
		measureMap.put(2, 14);
		measureMap.put(3, 64);
		measureMap.put(4, 1);
		measureMap.put(5, 114);
		measureMap.put(6, 150);
		measureMap.put(7, 152);
		measureMap.put(8, 81);
		measureMap.put(9, 106);
		measureMap.put(10, 68);
		measureMap.put(11, 45);
		measureMap.put(12, 97);

		/*
		 * Measure 3
		 */

		measureMap = measureMapList.get(2);
		measureMap.put(2, 164);
		measureMap.put(3, 100);
		measureMap.put(4, 160);
		measureMap.put(5, 8);
		measureMap.put(6, 57);
		measureMap.put(7, 112);
		measureMap.put(8, 131);
		measureMap.put(9, 40);
		measureMap.put(10, 86);
		measureMap.put(11, 90);
		measureMap.put(12, 6);

		/*
		 * Measure 4
		 */

		measureMap = measureMapList.get(3);
		measureMap.put(2, 122);
		measureMap.put(3, 12);
		measureMap.put(4, 163);
		measureMap.put(5, 35);
		measureMap.put(6, 71);
		measureMap.put(7, 15);
		measureMap.put(8, 37);
		measureMap.put(9, 69);
		measureMap.put(10, 139);
		measureMap.put(11, 158);
		measureMap.put(12, 121);

		/*
		 * Measure 5
		 */

		measureMap = measureMapList.get(4);
		measureMap.put(2, 25);
		measureMap.put(3, 149);
		measureMap.put(4, 77);
		measureMap.put(5, 111);
		measureMap.put(6, 117);
		measureMap.put(7, 147);
		measureMap.put(8, 21);
		measureMap.put(9, 43);
		measureMap.put(10, 120);
		measureMap.put(11, 82);
		measureMap.put(12, 56);

		/*
		 * Measure 6
		 */

		measureMap = measureMapList.get(5);
		measureMap.put(2, 153);
		measureMap.put(3, 30);
		measureMap.put(4, 156);
		measureMap.put(5, 39);
		measureMap.put(6, 52);
		measureMap.put(7, 27);
		measureMap.put(8, 125);
		measureMap.put(9, 140);
		measureMap.put(10, 92);
		measureMap.put(11, 123);
		measureMap.put(12, 67);

		/*
		 * Measure 7
		 */

		measureMap = measureMapList.get(6);
		measureMap.put(2, 18);
		measureMap.put(3, 161);
		measureMap.put(4, 168);
		measureMap.put(5, 137);
		measureMap.put(6, 132);
		measureMap.put(7, 73);
		measureMap.put(8, 49);
		measureMap.put(9, 23);
		measureMap.put(10, 143);
		measureMap.put(11, 78);
		measureMap.put(12, 63);

		/*
		 * Measure 8
		 */

		measureMap = measureMapList.get(7);
		measureMap.put(2, 167);
		measureMap.put(3, 11);
		measureMap.put(4, 172);
		measureMap.put(5, 44);
		measureMap.put(6, 130);
		measureMap.put(7, 102);
		measureMap.put(8, 115);
		measureMap.put(9, 89);
		measureMap.put(10, 83);
		measureMap.put(11, 58);
		measureMap.put(12, 16);
		
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

	public MozartContraDanceOneDiceGame(File f) throws IOException {
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
	
				InputStream stream = FileUtil.getResourcetStream( String.format(PATH_TO_MIDI_FORMAT, measureNumber) );
				appender.addFile(stream);
				stream.close();
			}
		}

		return appender.getSequence();
	}
	
	public static void main(String[] args) throws IOException, InvalidMidiDataException {
		AComposer comp = new MozartContraDanceTwoDiceGame(new File("/home/jan-christoph/git/Sonify/src/main/resources/labels.properties"));
		Sequence s = comp.createSequence();
		MidiSystem.write( s, 0, new File("/tmp/foo.mid"));
	}
}
