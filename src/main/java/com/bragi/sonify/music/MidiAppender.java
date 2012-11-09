package com.bragi.sonify.music;

import java.io.File;
import java.io.IOException;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Track;

public class MidiAppender {

	private Sequence sequence;
	private Track track;
	private long offset;
	
	public MidiAppender(int ppq) throws InvalidMidiDataException {
		sequence = new Sequence(Sequence.PPQ, ppq);
		track = sequence.createTrack();
		offset = 0;
	}
	
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

	public Sequence getSequence() {
		return sequence;
	}
	
	public static void main(String[] args) throws InvalidMidiDataException, IOException {
		String path = "/home/jan-christoph/Dropbox/Bragi/docs/plugin.audio.mozart/resources/files/M%d.mid";
		MidiAppender appender = new MidiAppender(480);
		
		for(int i = 42; i <= 176; i++ ) {
			File f = new File( String.format(path, i));
			appender.addFile(f);
		}
		
		File out = new File("/tmp/midifile.mid");
		MidiSystem.write( appender.sequence,1,out);
	}

}
