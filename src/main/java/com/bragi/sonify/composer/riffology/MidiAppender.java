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
 * Sebastian Muszytowski - Having the idea to simplify things from parsing MusicXML to 'simply' appending measures given by MIDI files and creating them
 * Jan-Christoph Klie - Everything else
 * 
 *******************************************************************************/

package com.bragi.sonify.composer.riffology;

import java.io.File;
import java.io.IOException;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Track;

/**
 * This class creates a MIDI sequence by appending MIDI files.
 * 
 * @author Sebastian Muszytowski <sebastian@muszytowski.net>
 * @author Jan-Christoph Klie
 */
public class MidiAppender {

	private Sequence sequence;
	private Track track;
	private long offset;
	
	/**
	 * Creates a new MidiAppender istance while specifying the resolution of the
	 * MIDI sequence to generate.
	 * 
	 * THIS HAS TO BE THE SAME RESOLUTION AS THE ONE OF ALL FOLLOWING FILES
	 * WHICH WILL BE APPENDED OR THE TIMING OF THE GENERATED SEQUENCE WILL BE
	 * SCREWED UP!
	 * 
	 * @param ppq The resolution of the MIDI sequence to generate in pulses per quarter (PPQ)
	 * @throws InvalidMidiDataException
	 */
	public MidiAppender(int ppq) throws InvalidMidiDataException {
		sequence = new Sequence(Sequence.PPQ, ppq);
		track = sequence.createTrack();
		offset = 0;
	}
	
	/**
	 * Appends the MIDI file given to the MIDI sequence of this MidiAppender instance
	 * @param f The MIDI file to append
	 * @throws InvalidMidiDataException
	 * @throws IOException
	 */
	public void addFile(File f) throws InvalidMidiDataException, IOException {
		Sequence seq = MidiSystem.getSequence(f);

		for( Track t : seq.getTracks()) {
			for( int i = 0; i < t.size(); i++) {
				MidiEvent event = t.get(i);				
				long tick = event.getTick();
				event.setTick(tick + offset);
				track.add(event);
			}
		}
		
		offset = sequence.getTickLength();
	}

	/**
	 * Returns the sequence generated by appending other MIDI files
	 * @return The  sequence generated
	 */
	public Sequence getSequence() {
		return sequence;
	}
}
