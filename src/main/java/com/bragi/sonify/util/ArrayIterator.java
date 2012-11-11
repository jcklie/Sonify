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

package com.bragi.sonify.util;

import java.util.Iterator;

/**
 * Iterator for iterables which only have an array to iterate over.
 * 
 * @author Jan-Christoph Klie 
 */
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
