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

package com.bragi.textanalyzer;

/**
 * The ITextAnalyzer interface
 * 
 * @author Benedict Holste <benedict@bholste.net>
 *
 */
public interface ITextAnalyzer {
	
	/**
	 * Returns the total number of characters in the input text.
	 * 
	 * @return The total number of characters
	 */
	int totalCharCount();
	
	/**
	 * Returns the total number of words in the input text.
	 * 
	 * @return The total number of words
	 */
	int totalWordCount();
	
	/**
	 * Returns the total number of punctuation marks in the input text.
	 * 
	 * @return The total number of punctuation marks
	 */
	int totalPunctuationCount();
	
	/**
	 * Return the average length of words in the input text.
	 * 
	 * @return The average length of words
	 */
	int averageWordLength();
	
	/**
	 * Returns the average length of sentences in the input text.
	 * 
	 * @return The average length of sentences
	 */
	int averageSentenceLength();
	
	/**
	 * Analyzes the input text for various characteristics.
	 * 
	 * @param text The text which should be analyzed
	 */
	void analyzeText(String text);
	
}
