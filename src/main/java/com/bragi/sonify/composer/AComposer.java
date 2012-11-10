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

package com.bragi.sonify.composer;

import java.io.File;
import java.io.IOException;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.Sequence;

import com.bragi.sonify.textanalyzer.TextAnalyzer;
import com.bragi.sonify.util.FileUtil;

/**
 * AComposer is the basic class of all classes which encapsulate algorithms to
 * create MIDI-Sequences from a given input text and genre.
 * 
 * @author Jan-Christoph Klie
 * 
 */
public abstract class AComposer {
	
	protected TextAnalyzer analyzer;
	
	/**
	 * Creates an AComposer instance including analyzing the text in file f by
	 * the TextAnalyzer class.
	 * @param f The file pointing on the text file
	 * @throws IOException
	 */
	public AComposer(File f) throws IOException {
		analyzer = new TextAnalyzer(FileUtil.readFile(f));
	}	 

	/**
	 * Generates a Sequence (collection of Tracks which itself are a
	 * collection of MIDI-Events) and returns it.
	 * 
	 * @param text The text used to determine the generation process
	 * @return The generated sequence
	 * @throws InvalidMidiDataException 
	 * @throws IOException 
	 */
	public abstract Sequence createSequence() throws InvalidMidiDataException, IOException;

}

