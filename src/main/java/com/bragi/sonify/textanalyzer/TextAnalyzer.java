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
 * Benedict Holste - General layout of the class, implementation of totalCharCount, totalWordCount, averageWordLength
 * Sebastian Muszytowski - Documentation and implementation of totalSentenceCount, averageSentenceLength
 *******************************************************************************/

package com.bragi.sonify.textanalyzer;

/**
 * The TextAnalyzer class implements the ITextAnalyzer interface and
 * provides various information about the constitution of an input text.
 * 
 * @author Benedict Holste <benedict@bholste.net>
 * @author Sebastian Muszytowski <sebastian@muszytowski.net>
 *
 */
public class TextAnalyzer {
	
	private int totalCharCount;
	private int totalWordCount;
	private int averageWordLength;
	private int totalSentenceCount;
	private int averageSentenceCharLength;
	private int averageSentenceWordLength;
	
	public TextAnalyzer(String text) {
		analyzeText(text);
	}

	public int totalCharCount() {
		return totalCharCount;
	}

	public int totalWordCount() {
		return totalWordCount;
	}
	
	public int totalSentenceCount() {
		return totalSentenceCount;
	}

	public int averageWordLength() {
		return averageWordLength;
	}

	public int averageSentenceCharLength() {
		return averageSentenceCharLength;
	}
	
	public int averageSentenceWordLength() {
		return averageSentenceWordLength;
	}

	private void analyzeText(String text) {
		// set the total number of words
		String[] words = text.split("\\s+");
		totalWordCount = words.length;
		
		/*
		 * Average sentence length
		 */
		
		// loop over all words and sum up their length
		int wordLengthSum = 0;
		for(String word : words) {
			wordLengthSum += word.length();
		}
		
		
		
		
		// calculate the average word length
		averageWordLength = Math.round(wordLengthSum/totalWordCount);
		
		/*
		 * Set the total character count
		 */
		totalCharCount = text.length();
		
		/*
		 * Sentence count
		 */
		
		String[] sentences = text.split("(?<=[\\S])[\\.\\!\\?]\\s+");
		totalSentenceCount = sentences.length;
		
		/*
		 * Average sentence length
		 */
		
		int sentenceCharLengthSum = 0;
		int sentenceWordLengthSum = 0;
		for(String sentence : sentences) {
			sentenceCharLengthSum += sentence.length();
			words = sentence.split("\\s+");
			for(String word : words) {
				sentenceWordLengthSum += word.length();
			}			
		}		
		
		averageSentenceCharLength = Math.round(sentenceCharLengthSum/totalSentenceCount);	
		averageSentenceWordLength = Math.round(sentenceWordLengthSum/totalSentenceCount);		
	}
	
}
