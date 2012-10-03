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

package com.bragi.sonify.music;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Receiver;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Synthesizer;

public class RiffPlayer {
	
	public static void play(Riff riff) throws MidiUnavailableException, InvalidMidiDataException {
		Synthesizer synth = MidiSystem.getSynthesizer();
		synth.open();
		Receiver rcvr = synth.getReceiver();
		ShortMessage msg = new ShortMessage();
		
		for(Note n : riff) {
			msg.setMessage(ShortMessage.NOTE_ON, 0, n.key, 64);
			rcvr.send(msg, -1);
			
			try {
				Thread.sleep(2 * 400); 
			} catch (Exception e) {
				
			}
			
			msg.setMessage(ShortMessage.NOTE_OFF, 0, n.key, 0);
			rcvr.send(msg, -1);
		}
		
		synth.close();
	}
	
	public static void main(String[] args) {
		Riff riff = new Riff(Note.A5, Note.E5, Note.C5, Note.G4, Note.C5, Note.E5, Note.A5, Note.A5  );
		try {
			play(riff);
		} catch (MidiUnavailableException | InvalidMidiDataException e) {
			
			e.printStackTrace();
		}
	}

}
