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

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.List;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MetaMessage;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Receiver;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Synthesizer;
import javax.sound.midi.Track;
import javax.sound.midi.Transmitter;

/**
 * This class offers a framework to create MIDI tracks by
 * simply providing pitch, note value and instrument
 * for every note, one after another.
 * 
 * In addition, one can specify general parameters like
 * beats per minute.
 * 
 * These tracks are combined to form a sequence which can
 * be written to a MIDI file.
 */
public class SongWriter {
	
	private Sequence sequence;
	private List<Track> tracks;

	private int tick;
	
	private static final int MICROSECONDS_PER_MINUTE = 60000000;
	private static final int TICKS_PER_BEAT = 24;
	private static final int PRESSURE = 64;
	
	private enum MidiCode {
		TEMP0(0x51),
		END(0x2F);
		
		int val;
		
		MidiCode(int k) {
			this.val = k;
		}
	}
	
	public SongWriter() throws InvalidMidiDataException {
		tracks = new LinkedList<Track>();
		sequence = new Sequence(Sequence.PPQ,24);		
		tick = 0;
	}	
	
	public Track createNewTrack() {		
		Track t = sequence.createTrack();		
		tracks.add(t);
		return t;
	}
	
	/**
	 * Sets the tempo of the given track to the supplied beats per minute
	 * @param track The track which tempo will be altered
	 * @param bpm The new tempo of the track, given in beats per minute
	 * @throws InvalidMidiDataException
	 */
	public void setBPM(Track track, int bpm) throws InvalidMidiDataException {
		MetaMessage mm;
		MidiEvent me;
		
		mm = new MetaMessage();
		mm.setMessage(MidiCode.TEMP0.val, convertBPMToByte(bpm), 3);
		me = new MidiEvent(mm,(long)tick);
		track.add(me);
	}
	
	public void setInstrument(Track track, Instrument instrument) throws InvalidMidiDataException {
		ShortMessage msg;
		MidiEvent me;
		
		msg = new ShortMessage();
		msg.setMessage(ShortMessage.PROGRAM_CHANGE, 0, instrument.key, 0);
		me = new MidiEvent(msg,(long)tick);
		track.add(me);
	}
	
	public void addNote(Track track, Note note, int quarters) throws InvalidMidiDataException {
		ShortMessage msg;
		MidiEvent me;
		
		msg = new ShortMessage();
		msg.setMessage(ShortMessage.NOTE_ON, 0, note.key, PRESSURE);
		me = new MidiEvent(msg,(long)tick);
		track.add(me);
		
		tick += quarters * TICKS_PER_BEAT;
		
		msg = new ShortMessage();
		msg.setMessage(ShortMessage.NOTE_OFF, 0, note.key, 0);
		me = new MidiEvent(msg,(long)tick);
		track.add(me);
		
		tick++;
	}
	
	public void endTrack(Track track) throws InvalidMidiDataException {
		MetaMessage mm;
		MidiEvent me;
		byte[] bet = {};
		
		mm = new MetaMessage();
		mm.setMessage(MidiCode.END.val, bet, 0);
		me = new MidiEvent(mm, (long) tick);
		track.add(me);
	}
	
	public Sequence getSequence() {
		return sequence;
	}
	
	/**
	 * Microseconds per quarter note = microseconds per minute / BPM 
	 * @param bpm 
	 * @return
	 */
	private byte[] convertBPMToByte(int bpm) {
		int mpm = MICROSECONDS_PER_MINUTE / bpm;
		ByteBuffer b = ByteBuffer.allocate(4);
		b.putInt(mpm);		
		return b.array();
	}
	
	private void test() throws IOException, InvalidMidiDataException, MidiUnavailableException {
		SongWriter s = new SongWriter();
		Track track = s.createNewTrack();
		
		s.setBPM(track, 120);
		s.setInstrument(track, Instrument.AcousticGrandPiano);
		s.addNote(track, Note.Ab3, 3);
		s.addNote(track, Note.Ab3, 3);
		s.addNote(track, Note.Ab3, 3);
		s.addNote(track, Note.Ab3, 3);
		s.addNote(track, Note.Ab3, 3);
		s.addNote(track, Note.Ab3, 3);
		s.endTrack(track);		
		
		// Sequencer und Synthesizer initialisieren
		Sequencer sequencer = MidiSystem.getSequencer();
		Transmitter trans = sequencer.getTransmitter();
		Synthesizer synth = MidiSystem.getSynthesizer();
		Receiver rcvr = synth.getReceiver();
		// Beide öffnen und verbinden
		sequencer.open();
		synth.open();
		trans.setReceiver(rcvr);
		// Sequence abspielen
		sequencer.setSequence(s.getSequence());
		sequencer.setTempoInBPM(145);
		sequencer.start();
		while (true) {
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				// nothing
			}
			if (!sequencer.isRunning()) {
				break;
			}
		}
		// Sequencer anhalten und Geräte schließen
		sequencer.stop();
		sequencer.close();
		synth.close();
		
		int[] allowedTypes = MidiSystem.getMidiFileTypes(s.getSequence());
		if (allowedTypes.length == 0) {
			System.err.println("No supported MIDI file types.");
		} else {
			MidiSystem.write(s.getSequence(), allowedTypes[0], new File("/tmp/ma.mid"));
			System.exit(0);
		}
	}
	
	public static void main(String[] args) throws InvalidMidiDataException, IOException, MidiUnavailableException {



	}

}
