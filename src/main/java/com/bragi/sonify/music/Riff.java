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

package com.bragi.sonify.music;

import java.util.Iterator;

public class Riff implements Iterable<Note> {

	private Note[] data;

	/**
	 * Finally, a usage for varargs.
	 * 
	 * @param data The data
	 */
	public Riff(Note... data) {
		this.data = data;
	}

	private class RiffIterator implements Iterator<Note> {
		private Note[] data;
		private int pos = 0;

		public RiffIterator(Note[] data) {
			this.data = data;
		}

		public boolean hasNext() {
			return pos < data.length;
		}

		public Note next() {
			return data[pos++];			
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

	@Override
	public Iterator<Note> iterator() {
		return new RiffIterator(data);
	}

}
