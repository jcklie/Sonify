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
 * This AComposer uses the measures given by the sheet music "Anleitung so viel
 * Walzer oder Schleifer mit zwei Würfeln zu componiren so viel man will ohne
 * musikalisch zu seyn noch etwas von der Composition zu verstehen" from
 * Wolfgang Amadeus Mozart as found in [Haupenthal, Gerhard: Geschichte der
 * Würfelmusik in Beispielen. Teilband 2: Noten.].
 * 
 * Only the measures of the trio part were used.
 * 
 * The sheets there were handwritten and were digitized by using the Music OCR
 * (OMR, Optical Music Recognition) software capella scan
 * http://www.capella.de/us/index.cfm/products/capella-scan/info-capella-scan/.
 * 
 * Since the recognition was only 20-70 percent correct, the result was
 * controlled and corrected by hand. Then measure for measure was extracted to
 * MIDI files (can be found in etc/midi/mozart_waltz.
 * 
 * To generate music, a dice represented by a random generator is used to choose
 * from the set of measures. How exactly the rules are can be read in the quoted
 * book or in the PDF found on www.pian-e-forte.de/noten/pdf/109599.pdf .
 * 
 * @author Sebastian Muszytowski <sebastian@muszytowski.net>
 * @author Jan-Christoph Klie
 */
public class MozartTrioDiceGame extends AComposer {
	
	private static List<Map<Integer, Integer>> measureMapList;
	private static final int NUM_MEASURES = 16;
	private static final int MIDI_RESOLUTION = 480;
	private static final String PATH_TO_MIDI_FORMAT = "/midi/mozart_trio/T%d.mid";
	private static final int REPEATS = 1;
	
	static {
		measureMapList = new LinkedList<Map<Integer, Integer>>();
		
		for( int i = 0; i < NUM_MEASURES; i++ ) {		
			measureMapList.add( new HashMap<Integer, Integer>() );			
		}
		
		Map<Integer, Integer> measureMap;

		/*
		 * Measure 1
		 */

		measureMap = measureMapList.get(0);
		measureMap.put(1, 72);
		measureMap.put(2, 56);
		measureMap.put(3, 75);
		measureMap.put(4, 40);
		measureMap.put(5, 83);
		measureMap.put(6, 18);

		/*
		 * Measure 2
		 */

		measureMap = measureMapList.get(1);
		measureMap.put(1, 6);
		measureMap.put(2, 82);
		measureMap.put(3, 39);
		measureMap.put(4, 73);
		measureMap.put(5, 3);
		measureMap.put(6, 45);

		/*
		 * Measure 3
		 */

		measureMap = measureMapList.get(2);
		measureMap.put(1, 59);
		measureMap.put(2, 42);
		measureMap.put(3, 54);
		measureMap.put(4, 16);
		measureMap.put(5, 28);
		measureMap.put(6, 62);

		/*
		 * Measure 4
		 */

		measureMap = measureMapList.get(3);
		measureMap.put(1, 25);
		measureMap.put(2, 74);
		measureMap.put(3, 1);
		measureMap.put(4, 68);
		measureMap.put(5, 53);
		measureMap.put(6, 38);

		/*
		 * Measure 5
		 */

		measureMap = measureMapList.get(4);
		measureMap.put(1, 81);
		measureMap.put(2, 14);
		measureMap.put(3, 65);
		measureMap.put(4, 29);
		measureMap.put(5, 37);
		measureMap.put(6, 5);

		/*
		 * Measure 6
		 */

		measureMap = measureMapList.get(5);
		measureMap.put(1, 41);
		measureMap.put(2, 7);
		measureMap.put(3, 43);
		measureMap.put(4, 55);
		measureMap.put(5, 17);
		measureMap.put(6, 28);

		/*
		 * Measure 7
		 */

		measureMap = measureMapList.get(6);
		measureMap.put(1, 89);
		measureMap.put(2, 26);
		measureMap.put(3, 15);
		measureMap.put(4, 2);
		measureMap.put(5, 44);
		measureMap.put(6, 52);

		/*
		 * Measure 8
		 */

		measureMap = measureMapList.get(7);
		measureMap.put(1, 13);
		measureMap.put(2, 71);
		measureMap.put(3, 80);
		measureMap.put(4, 61);
		measureMap.put(5, 70);
		measureMap.put(6, 94);

		/*
		 * Measure 9
		 */

		measureMap = measureMapList.get(8);
		measureMap.put(1, 36);
		measureMap.put(2, 76);
		measureMap.put(3, 9);
		measureMap.put(4, 22);
		measureMap.put(5, 63);
		measureMap.put(6, 11);

		/*
		 * Measure 10
		 */

		measureMap = measureMapList.get(9);
		measureMap.put(1, 5);
		measureMap.put(2, 20);
		measureMap.put(3, 34);
		measureMap.put(4, 67);
		measureMap.put(5, 85);
		measureMap.put(6, 92);

		/*
		 * Measure 11
		 */

		measureMap = measureMapList.get(10);
		measureMap.put(1, 46);
		measureMap.put(2, 64);
		measureMap.put(3, 93);
		measureMap.put(4, 49);
		measureMap.put(5, 32);
		measureMap.put(6, 24);

		/*
		 * Measure 12
		 */

		measureMap = measureMapList.get(11);
		measureMap.put(1, 79);
		measureMap.put(2, 84);
		measureMap.put(3, 48);
		measureMap.put(4, 77);
		measureMap.put(5, 96);
		measureMap.put(6, 86);

		/*
		 * Measure 13
		 */

		measureMap = measureMapList.get(12);
		measureMap.put(1, 30);
		measureMap.put(2, 8);
		measureMap.put(3, 69);
		measureMap.put(4, 57);
		measureMap.put(5, 12);
		measureMap.put(6, 51);

		/*
		 * Measure 14
		 */

		measureMap = measureMapList.get(13);
		measureMap.put(1, 95);
		measureMap.put(2, 35);
		measureMap.put(3, 58);
		measureMap.put(4, 87);
		measureMap.put(5, 23);
		measureMap.put(6, 60);

		/*
		 * Measure 15
		 */

		measureMap = measureMapList.get(14);
		measureMap.put(1, 19);
		measureMap.put(2, 47);
		measureMap.put(3, 90);
		measureMap.put(4, 33);
		measureMap.put(5, 50);
		measureMap.put(6, 78);

		/*
		 * Measure 16
		 */

		measureMap = measureMapList.get(15);
		measureMap.put(1, 66);
		measureMap.put(2, 88);
		measureMap.put(3, 21);
		measureMap.put(4, 10);
		measureMap.put(5, 91);
		measureMap.put(6, 31);
	}
	
	public MozartTrioDiceGame(File f) throws IOException {		
		super(f);
	}

	@Override
	public Sequence createSequence() throws InvalidMidiDataException, IOException {
		MidiAppender appender =  new MidiAppender(MIDI_RESOLUTION);
		Random r = new Random( analyzer.hashCode());
		
		for( int repeat = 0; repeat <= REPEATS; repeat++) {
			for(int i = 0; i < NUM_MEASURES; i++) {
				// One dice roll
				int diceRoll = r.nextInt(6) + 1;
	
				int measureNumber = measureMapList.get(i).get(diceRoll);
				InputStream stream = FileUtil.getResourcetStream(String.format(PATH_TO_MIDI_FORMAT, measureNumber));
				appender.addFile(stream);
				stream.close();
			}		
		}		
		return appender.getSequence();
	}
}
