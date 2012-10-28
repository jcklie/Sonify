package com.bragi.sonify.music;

import java.util.Iterator;

import org.javatuples.Pair;

import com.bragi.sonify.util.ArrayIterator;

public class Melody implements Iterable<Pair<Note, NoteValue>> {
	
	private Pair<Note, NoteValue>[] data;

	/**
	 * Finally, a usage for var args.
	 * 
	 * @param data The data
	 */
	@SafeVarargs
	public Melody(Pair<Note, NoteValue> ... data) {
		this.data = data;
	}
	
	protected Pair<Note, NoteValue>[] getData() {
		return data;
	}

	@Override
	public Iterator<Pair<Note, NoteValue>> iterator() {
		return new ArrayIterator<Pair<Note, NoteValue>>(data);
	}

}
