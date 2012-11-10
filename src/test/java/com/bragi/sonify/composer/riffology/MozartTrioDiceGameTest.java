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
import java.nio.file.Files;
import java.nio.file.Path;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;

import junit.framework.TestCase;
import junitx.framework.FileAssert;

import com.bragi.sonify.composer.AComposer;

/**
 * Class for testing the Mozart Waltz Dice Game  using JUnit
 * 
 * @author Jan-Christoph Klie <rentier42@gmail.com>
 */
public class MozartTrioDiceGameTest extends TestCase {
	
	public MozartTrioDiceGameTest(String testName) {
		super(testName);
	}
	
	/**
	 * In this test, a text is sonified twice with the same text and the both
	 * results are compared binary. Since the result of sonifiing the same text
	 * twice should yield the exact same file, this case is asserted.
	 * 
	 */
	public void testReproducabillity() {		
		try {
			File f = new File("src/test/resources/literature/roman.txt"); 
			
			AComposer firstComposer = new MozartTrioDiceGame(f);
			Sequence firstSequence = firstComposer.createSequence();
			Path firstTempPath = Files.createTempFile(null, null );
			File firstFile = firstTempPath.toFile();
			MidiSystem.write( firstSequence, 1, firstFile);
			
			AComposer secondComposer = new MozartTrioDiceGame(f);
			Sequence secondSequence = secondComposer.createSequence();
			Path secondTempPath = Files.createTempFile(null, null );
			File secondFile = secondTempPath.toFile();
			MidiSystem.write( secondSequence, 1, secondFile);
			
			FileAssert.assertBinaryEquals(firstFile, secondFile);
		} catch( InvalidMidiDataException | IOException e  ) {

		}
	}

}
