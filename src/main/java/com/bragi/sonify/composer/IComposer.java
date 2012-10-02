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

import javax.sound.midi.Sequence;

/**
 * IComposer is the basic interface of all algorithms which create
 * MIDI-Sequences from a given input encapsulated in a class. 
 * 
 * @author Jan-Christoph Klie
 * 
 */
public interface IComposer {

	/**
	 * Generates a Sequence (collection of Tracks which itself are a
	 * collection of MIDI-Events) and returns it.
	 * 
	 * @param text The text used to determine the generation process
	 * @return The generated sequence
	 */
	Sequence createMidi(String text);

}

