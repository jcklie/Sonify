package com.bragi.sonify.music;

public class MusicUtil {

	public static Pitch translatePitch(String step, String octave) {
		return Pitch.valueOf(step+octave);
	}
	
	public static NoteValue translateNoteValue() {
		return null;
	}

}
