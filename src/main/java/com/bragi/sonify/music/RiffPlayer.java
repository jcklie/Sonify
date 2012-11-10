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

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Receiver;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Synthesizer;

import com.bragi.sonify.music.SongWriter.TrackHandle;

/**
 * This class is intended to provide simple test capabilities for previously
 * created riffs. Since a riff only specifies pitch and no note value, it is
 * randomly chosen.
 * 
 * In this version, all riffs which are declared in the Riff class are played
 * subsequently. Enjoy this awesome piece of high culture.
 * 
 * Acts as my digital playground. (JCK)
 * 
 * @deprecated
 * @author Jan-Christoph Klie
 */
public class RiffPlayer {
	
	static Random randGen = new Random();
	
	public static void play(Riff riff, Rhythm rhythm) throws MidiUnavailableException, InvalidMidiDataException {
		Synthesizer synth = MidiSystem.getSynthesizer();
		synth.open();
		Receiver rcvr = synth.getReceiver();
		ShortMessage msg = new ShortMessage();
		
		msg.setMessage(ShortMessage.PROGRAM_CHANGE, 0, 25, 0);
		rcvr.send(msg, -1);
		
		for(int i = 0; i < riff.getData().length; i++) {
			Pitch n = riff.getData()[i];
			NoteValue v = rhythm.getData()[i%rhythm.getData().length];
			msg.setMessage(ShortMessage.NOTE_ON, 0, n.key, 64);
			rcvr.send(msg, -1);
			
			try {
				Thread.sleep(v.val * 2); 
			} catch (Exception e) {
				
			}
			
			msg.setMessage(ShortMessage.NOTE_OFF, 0, n.key, 0);
			rcvr.send(msg, -1);
		}
		
		synth.close();
	}
	
	public static void main(String[] args) {

		Random rnd = new Random();
		try {
			List<Riff> riffz = new ArrayList<Riff>();
			List<Rhythm> r = new ArrayList<Rhythm>();

			SongWriter s = new SongWriter();
			TrackHandle track1 = s.createNewTrack();
			TrackHandle track2 = s.createNewTrack();
			
			s.setInstrument(track1, Instrument.AcousticGrandPiano);		
			s.setInstrument(track2, Instrument.AcousticGrandPiano);			
			
			s.setPressure(track1, 100);
			s.setPressure(track2, 60);
			
			for(int i = 1 ; i <= 94; i++) {
				Field f = Riff.class.getDeclaredField("RIFF"+i);
				riffz.add( (Riff) f.get( null ));
			}
			
			for(int i = 1 ; i <= 14; i++) {
				Field f = Rhythm.class.getDeclaredField("RHYTHM"+i);
				r.add( (Rhythm) f.get( null ));
			}
			
			
			s.setBPM(track1, 200);
			s.setBPM(track2, 200);			
			
			while( riffz.size() > 0) {
				int i = rnd.nextInt(riffz.size());
				int j = rnd.nextInt(r.size());
				Pitch[] curRiff = riffz.get(i).getData();
				NoteValue[] curRhythm = r.get(j).getData();
				
				for( int a = 0; a < curRiff.length; a++ ) {
					s.addNote(track1, curRiff[a], curRhythm[a%curRhythm.length]);
					s.addInterval(track2, curRiff[a], curRhythm[a%curRhythm.length], Interval.PERFECT_FIFTH);
				}
				
				riffz.remove(i);				
			}			
			
			s.endTrack(track1);
			s.play();


			
		} catch (Exception e) {			
			e.printStackTrace();
		}
	}

}
