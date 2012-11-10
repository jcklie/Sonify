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

package com.bragi.sonify;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.bragi.sonify.composer.lsystem.LSystemTest;
import com.bragi.sonify.composer.riffology.KirnbergerDiceGameTest;
import com.bragi.sonify.composer.riffology.MozartTrioDiceGameTest;
import com.bragi.sonify.composer.riffology.MozartWaltzDiceGameTest;
import com.bragi.sonify.composer.riffology.TestScenarioTest;

/**
 * Unit test for the sonificator. It should be run after each checking and each
 * compiling.
 */
public class AppTest extends TestCase {

	/**
	 * 
	 * Create the test case
	 * 
	 * @param testName name of the test case
	 */
	public AppTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		TestSuite s = new TestSuite();
		s.addTest(new LSystemTest("testGenerate"));
		
		s.addTest(new KirnbergerDiceGameTest("testReproducabillity"));
		s.addTest(new MozartTrioDiceGameTest("testReproducabillity"));
		s.addTest(new MozartWaltzDiceGameTest("testReproducabillity"));
		
		s.addTest(new TestScenarioTest("testGeneratingMidi"));
		

		return s;
	}

}