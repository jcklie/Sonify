package com.bragi.sonify.music.parser;

import java.util.HashMap;
import java.util.Map;

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
