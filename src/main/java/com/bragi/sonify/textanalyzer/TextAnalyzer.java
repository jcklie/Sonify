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
 * Benedict Holste - everything, ...till now
 *******************************************************************************/

package com.bragi.sonify.textanalyzer;

/**
 * The TextAnalyzer class implements the ITextAnalyzer interface and
 * 
 * @author Benedict Holste <benedict@bholste.net>
 *
 */
public class TextAnalyzer implements ITextAnalyzer{
	
	private int totalCharCount;
	private int totalWordCount;
	private int averageWordLength;
	
	public TextAnalyzer() {
		
	}

	@Override
	public int totalCharCount() {
		// TODO Auto-generated method stub
		return totalCharCount;
	}

	@Override
	public int totalWordCount() {
		// TODO Auto-generated method stub
		return totalCharCount;
	}

	@Override
	public int totalPunctuationCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int averageWordLength() {
		// TODO Auto-generated method stub
		return averageWordLength;
	}

	@Override
	public int averageSentenceLength() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void analyzeText(String text) {
		
		// TODO How to handle numbers, e.g. 1,2,3...?!
		// set the total number of words
		String[] words = text.split(" ");
		totalWordCount = words.length;
		
		// loop over all words and sum up their length
		int wordLengthSum = 0;
		for(String word : words) {
			wordLengthSum += word.length();
		}
		
		// calculate teh average word length
		averageWordLength = wordLengthSum/totalWordCount;
		
		// TODO How to handle whitespace?!
		// set the total character count
		totalCharCount = text.length();
		
	}
}
