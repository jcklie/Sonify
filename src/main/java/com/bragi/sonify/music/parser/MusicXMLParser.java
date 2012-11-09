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

package com.bragi.sonify.music.parser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.XMLEvent;

import com.bragi.sonify.music.Instrument;
import com.bragi.sonify.music.Interval;
import com.bragi.sonify.music.Measure;
import com.bragi.sonify.music.Note;
import com.bragi.sonify.music.Pitch;
import com.bragi.sonify.music.SongWriter;
import com.bragi.sonify.music.SongWriter.TrackHandle;

/**
 * @author Jan-Christoph Klie
 */
public class MusicXMLParser {
	
	private static final String MEASURE = "measure";
	private static final String NOTE = "note";
	private static final String PITCH = "pitch";
	private static final String STEP = "step";
	private static final String OCTAVE = "octave";
	private static final String DURATION = "duration";
	private static final String FORWARD = "forward";
	private static final String BACKUP = "backup";
	
	private enum Duration {
		FORWARD, BACKUP, NOTE;
	}
		
	public static List<Measure> readConfig(File f) {
		List<Measure> items = new LinkedList<Measure>();
		
		List<Note> notes = new LinkedList<Note>();
		Pitch pitch = null;
		String step = null;
		String octave = null;
		
		int duration = 0;
		int position = 0;
		
		Duration d = null;
		
		try {
			XMLInputFactory inputFactory = XMLInputFactory.newInstance();
			InputStream in = new FileInputStream(f);
			XMLEventReader eventReader = inputFactory.createXMLEventReader(in);
			XMLEvent event;
			

			while (eventReader.hasNext()) {
				event = eventReader.nextEvent();	

				if (event.isStartElement()) {
					
					switch( event.asStartElement().getName().getLocalPart()) {
						case MEASURE:							
							notes.clear();
							position = 0;
							break;
						case NOTE:
							d = Duration.NOTE;
							break;
						case FORWARD:
							d = Duration.FORWARD;
							break;
						case BACKUP:
							d = Duration.BACKUP;
							break;
						case PITCH:							
							pitch = null;
							break;
						case STEP:
							step = eventReader.getElementText();							
							break;
						case OCTAVE:
							octave = eventReader.getElementText();
							break;
						case DURATION:
							switch(d) {
								case BACKUP:
									position -= Integer.parseInt( eventReader.getElementText() );
									break;
								case FORWARD:
									position += Integer.parseInt( eventReader.getElementText() );
									break;
								case NOTE:
									duration = Integer.parseInt( eventReader.getElementText() );
									position += duration;
									break;
								default:
									break;							
							}
							break;
					}					

				} else if (event.isEndElement()) {				
					
					switch( event.asEndElement().getName().getLocalPart()) {
						case PITCH:				
							pitch = Pitch.valueOf(step+octave);
							break;
						case NOTE:
							notes.add(new Note(pitch, duration, position));
							break;
						case MEASURE:							
							items.add( new Measure(notes) );
							break;
					}
					
				}

				
			}
			
		}  catch (FileNotFoundException | XMLStreamException e) {
		      e.printStackTrace();
	    }
		return items; 
	}


	public static void main(String[] args) throws InvalidMidiDataException, MidiUnavailableException, IOException {
		SongWriter s = new SongWriter(12);
		File f = new File( "src/test/resources/musicxml/MozartPianoSonata.xml");
		List<Measure> l = readConfig(f);
		
		TrackHandle track = s.createNewTrack();
		s.setTransposition(track, Interval.PERFECT_OCTAVE_D);
		
		s.setInstrument(track, Instrument.AcousticGrandPiano);		
		s.setPressure(track, 64);		

		
		for(Measure m : l) {			
			s.addMeasure(track, m, 36);
		}
		
		

		File out = new File("/tmp/midifile.mid");
		MidiSystem.write(s.getSequence(),1,out);
		//s.play();
	}

}
