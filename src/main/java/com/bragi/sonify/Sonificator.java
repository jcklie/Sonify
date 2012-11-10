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

package com.bragi.sonify;

import java.io.File;
import java.io.IOException;
import java.security.InvalidParameterException;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import com.bragi.sonify.composer.AComposer;
import com.bragi.sonify.composer.riffology.KirnbergerDiceGame;
import com.bragi.sonify.composer.riffology.MozartTrioDiceGame;
import com.bragi.sonify.composer.riffology.MozartWaltzDiceGame;

/**
 * This class acts as the layer between the user interaction and the music-generating 
 * magic itself. It is responsible to check the input given by any user interface.
 * 
 * If correct, the right composer is chosen and the sequence is generated. One error,
 * the concerning is thrown and left to be handled by the calling class/function.
 * 
 * @author Jan-Christoph Klie
 */
public class Sonificator {

	/**
	 * The core function of the Sonificator. It checks the input and if correct, it gets
	 * a AComposer instance and uses it to generate the music which is afterwards saved.
	 * 
	 * @param genre The genre of the text which was chosen to sonify
	 * @param input The file pointing on the text to use 
	 * @param output The file where the music is stored
	 * @throws IOException
	 * @throws InvalidMidiDataException
	 */
	public static void sonificate(Genre genre, File input, File output) throws IOException, InvalidMidiDataException {
		// I only care for input not existing, since output will be created if not existing.
		if( !input.exists()  ) {
			throw new IOException("File does not exist" + input.getAbsolutePath());
		}
		
		AComposer composer = chooseComposer(genre, input);
		Sequence sequence = composer.createSequence();
		
		MidiSystem.write( sequence, 1, output);
	}
	
	/**
	 * Every genre has a specific AComposer which is used to achieve the difference in the 
	 * generated music. 
	 * 
	 * @param genre The genre of the text which will be fed to the TextAnalyzer of the returned AComposer
	 * @param f The file pointing on the text to use
	 * @return The AComposer instance which generated music is suitable for the given genre
	 * @throws IOException
	 */
	private static AComposer chooseComposer(Genre genre, File f) throws IOException {		
		switch( genre ) {
			case DRAMA:
				throw new NotImplementedException();
			case KIDS_BOOK:
				throw new NotImplementedException(); 
			case LYRICS:
				return new MozartTrioDiceGame(f);
			case NONFICTION:
				return new MozartWaltzDiceGame(f);
			case NOVEL:
				throw new NotImplementedException();
				//return new KirnbergerDiceGame(f);
			default:
				// Should never happen
				throw new InvalidParameterException("The given genre is invalid!: " + genre );		
		}
	}

}
