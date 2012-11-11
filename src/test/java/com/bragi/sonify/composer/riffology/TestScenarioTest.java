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

package com.bragi.sonify.composer.riffology;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.Sequence;

import com.bragi.sonify.composer.AComposer;

import junit.framework.TestCase;

/**
 * This unit test is home of the tests which are described in chapter 10 of the
 * functional specifications document. (As far as software tests can achieve it).
 */
public class TestScenarioTest extends TestCase {
	
	private File getTestFile(String name) {
		URL url = this.getClass().getResource("/literature/" + name);
		return new File(url.getFile());
	}
	
	private final File drama = getTestFile("drama.txt");
	private final File kidsBook = getTestFile("kinderbuch.txt");
	private final File lyric = getTestFile("lyrik.txt");
	private final File novel = getTestFile("roman.txt");
	private final File nonFiction = getTestFile("sachbuch.txt");
	
	private static final long THIRTY_SECONDS = 30000;
	private static final long TEN_MINUTES =  600000000;
	
	public TestScenarioTest(String testName) {
		super(testName);
	}
	
	/**
	 * /TS0010/ Generating MIDI
	 * 
	 * This tests uses every implementation of the AComposer, generates a MIDI file
	 * and saves it afterwards. It is then imported with the MidiFileReader class.
	 * 
	 *  If the file is invalid MIDI, an InvalidMidiDataException is thrown and the test fails.
	 */
	public void testGeneratingMidi() {
		
		
	}
	
	/**
	 * /TS0020/ Playing time
	 * 
	 * The playing time of a sequence has to be 
	 * @throws IOException 
	 * @throws InvalidMidiDataException 
	 */
	public void testPlayingTime() throws IOException, InvalidMidiDataException {
		AComposer composer;
		Sequence sequence;
		long playtime;
		
		/*
		 * Mozart trio composer
		 */
		
		composer =  new MozartTrioDiceGame(drama);		
		sequence = composer.createSequence();	
		playtime = sequence.getMicrosecondLength();
		assertTrue(playtime > THIRTY_SECONDS && playtime <= TEN_MINUTES);
		
		composer =  new MozartTrioDiceGame(kidsBook);		
		sequence = composer.createSequence();		
		playtime = sequence.getMicrosecondLength();
		assertTrue(playtime > THIRTY_SECONDS && playtime <= TEN_MINUTES);
		
		composer =  new MozartTrioDiceGame(lyric);		
		sequence = composer.createSequence();		
		playtime = sequence.getMicrosecondLength();
		assertTrue(playtime > THIRTY_SECONDS && playtime <= TEN_MINUTES);
		
		composer =  new MozartTrioDiceGame(novel);		
		sequence = composer.createSequence();		
		playtime = sequence.getMicrosecondLength();
		assertTrue(playtime > THIRTY_SECONDS && playtime <= TEN_MINUTES);
		
		composer =  new MozartTrioDiceGame(nonFiction);		
		sequence = composer.createSequence();		
		playtime = sequence.getMicrosecondLength();
		assertTrue(playtime > THIRTY_SECONDS && playtime <= TEN_MINUTES);
		
		/*
		 * Mozart waltz composer
		 */
		
		composer =  new MozartWaltzDiceGame(drama);		
		sequence = composer.createSequence();	
		playtime = sequence.getMicrosecondLength();
		assertTrue(playtime > THIRTY_SECONDS && playtime <= TEN_MINUTES);
		
		composer =  new MozartWaltzDiceGame(kidsBook);		
		sequence = composer.createSequence();		
		playtime = sequence.getMicrosecondLength();
		assertTrue(playtime > THIRTY_SECONDS && playtime <= TEN_MINUTES);
		
		composer =  new MozartWaltzDiceGame(lyric);		
		sequence = composer.createSequence();		
		playtime = sequence.getMicrosecondLength();
		assertTrue(playtime > THIRTY_SECONDS && playtime <= TEN_MINUTES);
		
		composer =  new MozartWaltzDiceGame(novel);		
		sequence = composer.createSequence();		
		playtime = sequence.getMicrosecondLength();
		assertTrue(playtime > THIRTY_SECONDS && playtime <= TEN_MINUTES);
		
		composer =  new MozartWaltzDiceGame(nonFiction);		
		sequence = composer.createSequence();		
		playtime = sequence.getMicrosecondLength();
		assertTrue(playtime > THIRTY_SECONDS && playtime <= TEN_MINUTES);
		
		/*
		 * Kirnberger composer
		 */
		
		composer =  new KirnbergerDiceGame(drama);		
		sequence = composer.createSequence();	
		playtime = sequence.getMicrosecondLength();
		assertTrue(playtime > THIRTY_SECONDS && playtime <= TEN_MINUTES);
		
		composer =  new KirnbergerDiceGame(kidsBook);		
		sequence = composer.createSequence();		
		playtime = sequence.getMicrosecondLength();
		assertTrue(playtime > THIRTY_SECONDS && playtime <= TEN_MINUTES);
		
		composer =  new KirnbergerDiceGame(lyric);		
		sequence = composer.createSequence();		
		playtime = sequence.getMicrosecondLength();
		assertTrue(playtime > THIRTY_SECONDS && playtime <= TEN_MINUTES);
		
		composer =  new KirnbergerDiceGame(novel);		
		sequence = composer.createSequence();		
		playtime = sequence.getMicrosecondLength();
		assertTrue(playtime > THIRTY_SECONDS && playtime <= TEN_MINUTES);
		
		composer =  new KirnbergerDiceGame(nonFiction);		
		sequence = composer.createSequence();		
		playtime = sequence.getMicrosecondLength();
		assertTrue(playtime > THIRTY_SECONDS && playtime <= TEN_MINUTES);

		
		
		
	}
	
	



}
