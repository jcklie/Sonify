package com.bragi.sonify.music;

import java.util.Iterator;
import java.util.List;

import com.bragi.sonify.util.ArrayIterator;

public class Measure implements Iterable<Note> {
	
	private Note[] data;

	/**
	 * Finally, a usage for var args.
	 * 
	 * @param data The data
	 */
	@SafeVarargs
	public Measure(Note ... data) {
		this.data = data;
	}
	
	public Measure( List<Note> data) {
		this.data = data.toArray(new Note[0]);
	}
	
	protected Note[] getData() {
		return data;
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		for(Note n : data) {
			sb.append("[" + n + "]");
		}
		return sb.toString();
	}

	@Override
	public Iterator<Note> iterator() {
		return new ArrayIterator<Note>(data);
	}

}
