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

import java.io.IOException;
import java.nio.ByteBuffer;

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
 * This class offers a framework to create MIDI tracks by simply providing
 * pitch, note value and instrument for every note, one after another.
 * 
 * In addition, one can specify general parameters like beats per minute.
 * 
 * These tracks are combined to form a sequence which can be written to a MIDI
 * file.
 * 
 * @deprecated
 * @author Jan-Christoph Klie
 */
public class SongWriter {
	
	private Sequence sequence;

	private int curID = 0;
	
	private static final int MICROSECONDS_PER_MINUTE = 60000000;
	
	/**
	 * This class acts as a handle for the tracks of the SongWriter, since these
	 * are just stored internally. This class is the way to retrieve them from
	 * the inner data structures to access its API
	 */
	public class TrackHandle {
		private Track track;
		private int ticks;
		private Interval transposition;
		private int pressure;
		private final int id;
		
		/**
		 * Creates a ProperyContainer with default values:
		 * 
		 * Ticks: zero
		 * Transposition: 0
		 * Pressure: 64
		 */
		private TrackHandle(Track track) {
			this.track = track;
			transposition = Interval.PERFECT_UNISON;
			ticks = 0;
			pressure = 64;
			id = curID;
			curID++;
		}
	}
	
	/**
	 * Enum which holds MIDI constants not specified in the Java Sound API
	 */
	private enum MidiCode {
		TEMP0(0x51),
		END(0x2F);
		
		int val;
		
		MidiCode(int k) {
			this.val = k;
		}
	}
	
	/**
	 * Creates a clean SongWriter with no tracks and given pulses per quarter.
	 * @throws InvalidMidiDataException
	 */
	public SongWriter(int ppq) throws InvalidMidiDataException {
		sequence = new Sequence(Sequence.PPQ,ppq);
	}	
	
	/**
	 * Creates a clean SongWriter with no tracks and default pulses per quarter (24).
	 * @throws InvalidMidiDataException
	 */
	public SongWriter() throws InvalidMidiDataException {
		this(24);
	}
	
	/**
	 * Adds a newly created track to the sequence of the SongWriter
	 * and returns a handle for further operations.
	 * 
	 * @return A handle for the created track
	 * @throws InvalidMidiDataException 
	 */
	public TrackHandle createNewTrack() throws InvalidMidiDataException {			
		Track t = sequence.createTrack();
		initializeTrack(t);
		TrackHandle handle = new TrackHandle(t);
		
		return handle;
	}
	
	/**
	 * Sets the tempo of the given track to the supplied beats per minute
	 * 
	 * @param track The handle for the track to set the BPM for
	 * @param bpm The new tempo of the track, given in beats per minute
	 * @throws InvalidMidiDataException
	 */
	public void setBPM(TrackHandle handle, int bpm) throws InvalidMidiDataException {
		MetaMessage mm;
		MidiEvent me;
		
		mm = new MetaMessage();
		mm.setMessage(MidiCode.TEMP0.val, convertBPMToByte(bpm), 3);
		me = new MidiEvent(mm,(long)0);
		handle.track.add(me);
	}
	
	/**
	 * Sets the instrument for the given track.
	 * 
	 * @param handle The handle for the track to set the instrument for
	 * @param instrument The instrument the track will play
	 * @throws InvalidMidiDataException 
	 */
	public void setInstrument(TrackHandle handle, Instrument instrument) throws InvalidMidiDataException {
		ShortMessage msg;
		MidiEvent me;
		
		msg = new ShortMessage();
		msg.setMessage(ShortMessage.PROGRAM_CHANGE, handle.id, instrument.key, handle.ticks);
		me = new MidiEvent(msg,(long)0);
		handle.track.add(me);
	}
	
	/**
	 * Transposes the track from now on by the given interval
	 * 
	 * @param handle The handle for the track to transpose
	 * @param interval The interval of the transposing job
	 */
	public void setTransposition(TrackHandle handle, Interval interval) {
		handle.transposition = interval;
	}
	
	/**
	 * Sets the pressure (amount of force) of which the instruments are played.
	 * 
	 * @param handle The handle for the track to set the pressure for
	 * @param pressure The pressure (0-100)
	 */
	public void setPressure(TrackHandle handle, int pressure) {
		handle.pressure = pressure;
	}
	
	/**
	 * Adds a note with the specified duration to the given track
	 * 
	 * @param handle The handle for the track to set the instrument for
	 * @param note
	 * @param duration
	 * @throws InvalidMidiDataException
	 */
	public void addNote(TrackHandle handle, Pitch note, NoteValue duration) throws InvalidMidiDataException {	
		addNote(handle, note, duration.val);
	}
	
	/**
	 * Adds a note with the specified duration to the given track
	 * 
	 * @param handle The handle for the track to set the instrument for
	 * @param note
	 * @param duration
	 * @throws InvalidMidiDataException
	 */
	public void addNote(TrackHandle handle, Pitch note, int duration) throws InvalidMidiDataException {	
		ShortMessage msg;
		MidiEvent me;
		
		msg = new ShortMessage();
		msg.setMessage(ShortMessage.NOTE_ON, handle.id, note.key + handle.transposition.val, handle.pressure);
		me = new MidiEvent(msg,(long)handle.ticks);
		handle.track.add(me);
		
		handle.ticks += duration;
		
		msg = new ShortMessage();
		msg.setMessage(ShortMessage.NOTE_OFF, handle.id, note.key + handle.transposition.val , 0);
		me = new MidiEvent(msg,(long)handle.ticks);
		handle.track.add(me);
		
		handle.ticks++;
	}
	
	/**
	 * Adds a node specified by an interval from a given note. The added note
	 * has the value of the specified note plus the value of the interval
	 * 
	 * @param handle The handle for the track to set the instrument for
	 * @param note The note which is the reference for the interval.
	 * @param duration The duration of the note
	 * @param interval The interval of the note to add in comparison to the old.
	 * @throws InvalidMidiDataException
	 */
	public void addInterval(TrackHandle handle, Pitch note, NoteValue duration, Interval interval) throws InvalidMidiDataException {
		addInterval(handle, note, duration.val, interval);
	}
	
	/**
	 * Adds a node specified by an interval from a given note. The added note
	 * has the value of the specified note plus the value of the interval
	 * 
	 * @param handle The handle for the track to set the instrument for
	 * @param note The note which is the reference for the interval.
	 * @param duration The duration of the note
	 * @param interval The interval of the note to add in comparison to the old.
	 * @throws InvalidMidiDataException
	 */
	public void addInterval(TrackHandle handle, Pitch note, int duration, Interval interval) throws InvalidMidiDataException {
		ShortMessage msg;
		MidiEvent me;
		
		msg = new ShortMessage();
		msg.setMessage(ShortMessage.NOTE_ON, handle.id, note.key + interval.val + handle.transposition.val, handle.pressure);
		me = new MidiEvent(msg,(long)handle.ticks);
		handle.track.add(me);
		
		handle.ticks += duration;
		
		msg = new ShortMessage();
		msg.setMessage(ShortMessage.NOTE_OFF, handle.id, note.key + interval.val + handle.transposition.val, 0);
		me = new MidiEvent(msg,(long)handle.ticks);
		handle.track.add(me);
		
		handle.ticks++;
	}
	
	public void addMeasure(TrackHandle handle, Measure measure, int measureSize) throws InvalidMidiDataException {
		ShortMessage msg;
		MidiEvent me;
		
		for(Note note : measure) {
			msg = new ShortMessage();
			msg.setMessage(ShortMessage.NOTE_ON, handle.id, note.pitch.key + handle.transposition.val, handle.pressure);
			me = new MidiEvent(msg,(long)handle.ticks + note.position);
			handle.track.add(me);			
			
			msg = new ShortMessage();
			msg.setMessage(ShortMessage.NOTE_OFF, handle.id, note.pitch.key  + handle.transposition.val, 0);
			me = new MidiEvent(msg,(long)handle.ticks + note.position + note.duration);
			handle.track.add(me);
			
			
		}
		
		handle.ticks += measureSize;
	}
	
	/**
	 * Tells the SongWriter to finish this track. After that, the specified
	 * track is closed for mutations and can be saved if all other tracks of
	 * this SongWriter instance have been ended, too.
	 * 
	 * @param track The handle for the track to end
	 * @throws InvalidMidiDataException
	 */
	public void endTrack(TrackHandle handle) throws InvalidMidiDataException {		
		MetaMessage mm;
		MidiEvent me;
		byte[] bet = {};
		
		mm = new MetaMessage();
		mm.setMessage(MidiCode.END.val, bet, 0);
		me = new MidiEvent(mm, (long) handle.ticks);
		handle.track.add(me);
	}
	
	/**
	 * Returns the sequence of this SongWriter instance
	 * 
	 * @return One Sequence to rule them all, One Sequence to find them, 
	 * 		   One Sequence to bring them all and in the darkness bind them 
	 *         In the Land of MIDI where the Shadows lie.
	 */
	public Sequence getSequence() {
		return sequence;
	}
	
	/**
	 * Sets some mysterious MIDI flags. For further information, see:
	 * http://www.automatic-pilot.com/midifile.html
	 * 
	 * @param t The track to initialize
	 * @throws InvalidMidiDataException
	 */
	private void initializeTrack(Track t) throws InvalidMidiDataException {
		ShortMessage mm;
		MidiEvent me;
		
		/*
		 * Turn on General MIDI sound set
		 */
		mm = new ShortMessage();
		mm.setMessage(0xB0, 0x7D,0x00);
		me = new MidiEvent(mm,(long)0);
		t.add(me);
		
		/*
		 * Set omni on
		 */
		mm = new ShortMessage();
		mm.setMessage(0xB0, 0x7D,0x00);
		me = new MidiEvent(mm,(long)0);
		t.add(me);
		
		/*
		 * Set poly on
		 */
		mm = new ShortMessage();
		mm.setMessage(0xB0, 0x7F,0x00);
		me = new MidiEvent(mm,(long)0);
		t.add(me);
	}
	
	/**
	 * Microseconds per quarter note = microseconds per minute / BPM 
	 * 
	 * @param bpm The BPM value the SongWriter will set to 
	 * @return The byte word which tells the MIDI sequencer to adjust the BPM to the specified BPM
	 */
	private byte[] convertBPMToByte(int bpm) {
		int mpm = MICROSECONDS_PER_MINUTE / bpm;
		ByteBuffer b = ByteBuffer.allocate(4);
		b.putInt(mpm);		
		return b.array();
	}
	
	/**
	 * Plays the song of this SongWriter instance. Make sure that all tracks are ended properly
	 * before invoking this function.
	 *
	 * @throws MidiUnavailableException
	 * @throws InvalidMidiDataException
	 * @throws IOException
	 */
	public void play() throws MidiUnavailableException, InvalidMidiDataException, IOException {
		// TODO : Add check for properly added tracks
		Sequencer sequencer = MidiSystem.getSequencer();
		Transmitter trans = sequencer.getTransmitter();
		Synthesizer synth = MidiSystem.getSynthesizer();
		Receiver rcvr = synth.getReceiver();

		sequencer.open();
		synth.open();
		trans.setReceiver(rcvr);

		sequencer.setSequence(getSequence());
		sequencer.setTempoInBPM(100);
		sequencer.start();
		while (true) {
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				System.err.println(e);
			}
			if (!sequencer.isRunning()) {
				break;
			}
		}
		
		sequencer.stop();
		sequencer.close();
		synth.close();

	}

}
