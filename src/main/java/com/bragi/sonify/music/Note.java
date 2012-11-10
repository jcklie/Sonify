package com.bragi.sonify.music;

public class Note {

	public final Pitch pitch;
	public final int duration;
	public final int position;
	
	public Note(Pitch pitch, int duration, int position) {
		this.pitch = pitch;
		this.duration = duration;
		this.position = position;
	}
	
	public String toString() {
		return pitch + " " + duration;
	}

}
