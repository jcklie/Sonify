package com.bragi.sonify.util;

import java.util.Iterator;

public class ArrayIterator<J> implements Iterator<J> {

	private J[] data;
	private int pos = 0;

	public ArrayIterator(J[] data) {
		this.data = data;
	}

	public boolean hasNext() {
		return pos < data.length;
	}

	public J next() {
		return data[pos++];
	}

	public void remove() {
		throw new UnsupportedOperationException();
	}

}
