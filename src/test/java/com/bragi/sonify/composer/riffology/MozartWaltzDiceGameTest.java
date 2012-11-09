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
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;

import com.bragi.sonify.composer.AComposer;

import junit.framework.TestCase;

/**
 * Class for testing the Mozart Waltz Dice Game  using JUnit
 * 
 * @author Jan-Christoph Klie <rentier42@gmail.com>
 */
public class MozartWaltzDiceGameTest extends TestCase {
	
	public MozartWaltzDiceGameTest(String testName) {
		super(testName);
	}
	
	/**
	 * In this test, a text is sonified twice and the both 
	 * results are compared bitwise, whether they are identical.
	 *  
	 */
	public void testReproducabillity() {		
		try {
			File f = new File("src/test/resources/literature/kinderbuch.txt"); 
			
			AComposer firstComposer = new MozartWaltzDiceGame(f);
			Sequence firstSequence = firstComposer.createSequence();
			
			AComposer secondComposer = new MozartWaltzDiceGame(f);
			Sequence secondSequence = secondComposer.createSequence();
			
			assertEquals(firstSequence, secondSequence);
		} catch( InvalidMidiDataException | IOException e  ) {

		}
	}

}
