package com.bragi.sonify.music;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This class counts the lines, words, and characters in a given text-file.
 * 
 * Later, this class can be used to create the parameters needed to generate pseudorandom
 * numbers.
 * 
 * @param input    The input-text-file to be analyzed
 * @param numChars The number of characters counted in this file. 
 * @param numWords The number of words counted in this file. 
 * @param numLines The number of lines counted in this file. 
 */
public class TextToParameters {
	private File input;
	public int numChars = 0;
	public int numWords = 0;
	public int numLines = 0;

	public TextToParameters(File input) {
		this.input = input;
	}

	private void getParms() {
		try {
			String text = new Scanner(input).useDelimiter("\\Z").next();

			final int len = text.length();
			boolean inWord = false;

			for (int i = 0; i < len; i++) {
				final char c = text.charAt(i);
				numChars++;
				switch (c) {
				case '\n':
					numLines++;
				case ' ':
					if (inWord) {
						numWords++;
						inWord = false;
					}
					break;
				default:
					inWord = true;
				}
			}
			numLines++;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new TextToParameters(new File("test.txt")).getParms();
	}
}