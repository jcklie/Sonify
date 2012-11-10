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

package com.bragi.sonify.music.parser;

import java.util.HashMap;
import java.util.Map;

/**
 * @deprecated
 * Intended to use for setting the pointer on MusicXML files
 * 
 * @author Jan-Christoph Klie
 */
public class Counter {

	private Map<Integer, Integer> ticks;
	private Map<Integer, Integer> lastTicks;
	
	public Counter(int size) {
		ticks = new HashMap<Integer, Integer>();
		lastTicks = new HashMap<Integer, Integer>();
		
		for(int i = 1; i <= size; i++) {
			ticks.put(i, 0);
			lastTicks.put(i, 0);
		}
	}
	
	public void add(int voiceNumber, int duration) {		
		int tick = ticks.get(voiceNumber);
		lastTicks.put(voiceNumber, tick);
		ticks.put(voiceNumber, tick + duration);
	}
	
	// TODO: Security (ala ticks >= 0 and stuff
	public void backup(int val) {
		for(int i = 1; i <= ticks.size(); i++) {
			int tick = ticks.get(i);
			ticks.put(i, tick - val);
		}
	}
	
	// TODO: Security (ala ticks >= 0 and stuff
	public void forward(int voiceNumber, int val) {
		int tick = ticks.get(voiceNumber);
		ticks.put(voiceNumber, tick - val);
	}
	
	public int getTick(int voice) {
		return ticks.get(voice);
	}
	
	public int getLastTick(int voice) {
		return lastTicks.get(voice);
	}
	



}
