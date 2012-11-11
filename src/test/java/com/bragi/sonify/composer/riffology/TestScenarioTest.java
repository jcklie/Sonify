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

import junit.framework.TestCase;

/**
 * This unit test is home of the tests which are described in chapter 10 of the
 * functional specifications document. (As far as software tests can achieve it).
 */
public class TestScenarioTest extends TestCase {
	
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
	
	



}
