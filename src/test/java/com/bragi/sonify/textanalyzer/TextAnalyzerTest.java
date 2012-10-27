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
 * Benedict Holste - General class layout
 * Sebastian Muszytowski - Implementing ALL the assertions
 * 
 *******************************************************************************/

package com.bragi.sonify.textanalyzer;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

import junit.framework.TestCase;

import org.junit.Test;

/**
 * @author Benedict Holste <benedict@bholste.net>
 * @author Sebastian Muszytowski <sebastian@muszytowski.net>
 */
public class TextAnalyzerTest extends TestCase {
	
	private static String readFile(File f) throws IOException {
		FileInputStream stream = new FileInputStream(f);
		try {
			FileChannel fc = stream.getChannel();
			MappedByteBuffer bb = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size());
			/* Instead of using default, pass in a decoder. */
			return Charset.defaultCharset().decode(bb).toString();
		} finally {
			stream.close();
		}
	}
	
	@Test
	public void test() throws IOException {
		URL url = this.getClass().getResource("/sample.txt");
		File f = new File(url.getFile());
		
		String s = readFile(f);
		TextAnalyzer analyzer = new TextAnalyzer(s);		

		assertEquals(515, analyzer.totalCharCount());
		assertEquals(81, analyzer.totalWordCount());
		assertEquals(8, analyzer.totalSentenceCount());
		
		assertEquals(5, analyzer.averageWordLength());
		assertEquals(62, analyzer.averageSentenceCharLength());
		assertEquals(53, analyzer.averageSentenceWordLength());

		
	}
}
