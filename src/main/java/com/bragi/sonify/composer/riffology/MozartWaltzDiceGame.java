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
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.Sequence;

import com.bragi.sonify.composer.AComposer;

/**
 * This AComposer uses the measures given by the sheet music "Anleitung so viel
 * Walzer oder Schleifer mit zwei Würfeln zu componiren so viel man will ohne
 * musikalisch zu seyn noch etwas von der Composition zu verstehen" from
 * Wolfgang Amadeus Mozart as found in [Haupenthal, Gerhard: Geschichte der
 * Würfelmusik in Beispielen. Teilband 2: Noten.].
 * 
 * Only the measures of the waltz part were used.
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
public class MozartWaltzDiceGame extends AComposer {
	
	private static List<Map<Integer, Integer>> measureMapList;
	private static final int NUM_MEASURES = 16;
	private static final int MIDI_RESOLUTION = 480;
	private static final String PATH_TO_MIDI_FORMAT = "etc" + File.separator + "midi" + File.separator + "mozart_waltz" + File.separator + "M%d.mid";
	
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
		measureMap.put(2, 96);
		measureMap.put(3, 32);
		measureMap.put(4, 69);
		measureMap.put(5, 40);
		measureMap.put(6, 148);
		measureMap.put(7, 104);
		measureMap.put(8, 152);
		measureMap.put(9, 119);
		measureMap.put(10, 98);
		measureMap.put(11, 3);
		measureMap.put(12, 54);

		/*
		 * Measure 2
		 */

		measureMap = measureMapList.get(1);
		measureMap.put(2, 22);
		measureMap.put(3, 6);
		measureMap.put(4, 95);
		measureMap.put(5, 17);
		measureMap.put(6, 74);
		measureMap.put(7, 157);
		measureMap.put(8, 60);
		measureMap.put(9, 84);
		measureMap.put(10, 142);
		measureMap.put(11, 87);
		measureMap.put(12, 130);

		/*
		 * Measure 3
		 */

		measureMap = measureMapList.get(2);
		measureMap.put(2, 141);
		measureMap.put(3, 128);
		measureMap.put(4, 158);
		measureMap.put(5, 113);
		measureMap.put(6, 163);
		measureMap.put(7, 27);
		measureMap.put(8, 171);
		measureMap.put(9, 114);
		measureMap.put(10, 42);
		measureMap.put(11, 165);
		measureMap.put(12, 10);

		/*
		 * Measure 4
		 */

		measureMap = measureMapList.get(3);
		measureMap.put(2, 41);
		measureMap.put(3, 63);
		measureMap.put(4, 13);
		measureMap.put(5, 85);
		measureMap.put(6, 45);
		measureMap.put(7, 167);
		measureMap.put(8, 53);
		measureMap.put(9, 50);
		measureMap.put(10, 156);
		measureMap.put(11, 61);
		measureMap.put(12, 103);

		/*
		 * Measure 5
		 */

		measureMap = measureMapList.get(4);
		measureMap.put(2, 105);
		measureMap.put(3, 146);
		measureMap.put(4, 153);
		measureMap.put(5, 161);
		measureMap.put(6, 80);
		measureMap.put(7, 154);
		measureMap.put(8, 99);
		measureMap.put(9, 140);
		measureMap.put(10, 75);
		measureMap.put(11, 135);
		measureMap.put(12, 28);

		/*
		 * Measure 6
		 */

		measureMap = measureMapList.get(5);
		measureMap.put(2, 122);
		measureMap.put(3, 46);
		measureMap.put(4, 55);
		measureMap.put(5, 2);
		measureMap.put(6, 97);
		measureMap.put(7, 68);
		measureMap.put(8, 133);
		measureMap.put(9, 86);
		measureMap.put(10, 129);
		measureMap.put(11, 47);
		measureMap.put(12, 106);

		/*
		 * Measure 7
		 */

		measureMap = measureMapList.get(6);
		measureMap.put(2, 11);
		measureMap.put(3, 134);
		measureMap.put(4, 110);
		measureMap.put(5, 159);
		measureMap.put(6, 36);
		measureMap.put(7, 118);
		measureMap.put(8, 21);
		measureMap.put(9, 169);
		measureMap.put(10, 62);
		measureMap.put(11, 147);
		measureMap.put(12, 106);

		/*
		 * Measure 8
		 */

		measureMap = measureMapList.get(7);
		measureMap.put(2, 30);
		measureMap.put(3, 81);
		measureMap.put(4, 24);
		measureMap.put(5, 100);
		measureMap.put(6, 107);
		measureMap.put(7, 91);
		measureMap.put(8, 127);
		measureMap.put(9, 94);
		measureMap.put(10, 123);
		measureMap.put(11, 33);
		measureMap.put(12, 5);

		/*
		 * Measure 9
		 */

		measureMap = measureMapList.get(8);
		measureMap.put(2, 70);
		measureMap.put(3, 117);
		measureMap.put(4, 66);
		measureMap.put(5, 90);
		measureMap.put(6, 25);
		measureMap.put(7, 138);
		measureMap.put(8, 16);
		measureMap.put(9, 120);
		measureMap.put(10, 65);
		measureMap.put(11, 102);
		measureMap.put(12, 35);

		/*
		 * Measure 10
		 */

		measureMap = measureMapList.get(9);
		measureMap.put(2, 121);
		measureMap.put(3, 39);
		measureMap.put(4, 139);
		measureMap.put(5, 176);
		measureMap.put(6, 143);
		measureMap.put(7, 71);
		measureMap.put(8, 155);
		measureMap.put(9, 88);
		measureMap.put(10, 77);
		measureMap.put(11, 4);
		measureMap.put(12, 20);

		/*
		 * Measure 11
		 */

		measureMap = measureMapList.get(10);
		measureMap.put(2, 26);
		measureMap.put(3, 126);
		measureMap.put(4, 15);
		measureMap.put(5, 7);
		measureMap.put(6, 64);
		measureMap.put(7, 150);
		measureMap.put(8, 57);
		measureMap.put(9, 48);
		measureMap.put(10, 19);
		measureMap.put(11, 31);
		measureMap.put(12, 108);

		/*
		 * Measure 12
		 */

		measureMap = measureMapList.get(11);
		measureMap.put(2, 9);
		measureMap.put(3, 56);
		measureMap.put(4, 132);
		measureMap.put(5, 34);
		measureMap.put(6, 125);
		measureMap.put(7, 29);
		measureMap.put(8, 175);
		measureMap.put(9, 166);
		measureMap.put(10, 82);
		measureMap.put(11, 164);
		measureMap.put(12, 92);

		/*
		 * Measure 13
		 */

		measureMap = measureMapList.get(12);
		measureMap.put(2, 112);
		measureMap.put(3, 174);
		measureMap.put(4, 73);
		measureMap.put(5, 67);
		measureMap.put(6, 76);
		measureMap.put(7, 101);
		measureMap.put(8, 43);
		measureMap.put(9, 51);
		measureMap.put(10, 137);
		measureMap.put(11, 144);
		measureMap.put(12, 12);

		/*
		 * Measure 14
		 */

		measureMap = measureMapList.get(13);
		measureMap.put(2, 49);
		measureMap.put(3, 18);
		measureMap.put(4, 58);
		measureMap.put(5, 160);
		measureMap.put(6, 136);
		measureMap.put(7, 162);
		measureMap.put(8, 168);
		measureMap.put(9, 115);
		measureMap.put(10, 38);
		measureMap.put(11, 59);
		measureMap.put(12, 124);

		/*
		 * Measure 15
		 */

		measureMap = measureMapList.get(14);
		measureMap.put(2, 109);
		measureMap.put(3, 116);
		measureMap.put(4, 145);
		measureMap.put(5, 52);
		measureMap.put(6, 1);
		measureMap.put(7, 23);
		measureMap.put(8, 89);
		measureMap.put(9, 72);
		measureMap.put(10, 149);
		measureMap.put(11, 173);
		measureMap.put(12, 44);

		/*
		 * Measure 16
		 */

		measureMap = measureMapList.get(15);
		measureMap.put(2, 14);
		measureMap.put(3, 83);
		measureMap.put(4, 79);
		measureMap.put(5, 170);
		measureMap.put(6, 93);
		measureMap.put(7, 151);
		measureMap.put(8, 172);
		measureMap.put(9, 111);
		measureMap.put(10, 8);
		measureMap.put(11, 78);
		measureMap.put(12, 131);
		
	}	

	public MozartWaltzDiceGame(File f) throws IOException {		
		super(f);
	}

	@Override
	public Sequence createSequence() throws InvalidMidiDataException, IOException {
		MidiAppender appender =  new MidiAppender(MIDI_RESOLUTION);
		Random r = new Random( analyzer.hashCode());

		for(int i = 0; i < NUM_MEASURES; i++) {
			// Two Dice rolles, to keep the spirit of the game
			int diceRoll1 = r.nextInt(6) + 1;
			int diceRoll2 = r.nextInt(6) + 1;
			int measureNumber = measureMapList.get(i).get(diceRoll1 + diceRoll2 );
			File f = new File( String.format(PATH_TO_MIDI_FORMAT, measureNumber));
			appender.addFile(f);
		}
		
		return appender.getSequence();
	}
	
}
