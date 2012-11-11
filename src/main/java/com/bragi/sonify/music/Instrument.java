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
 * Sebastian Muszytowski - Everything but creating this file:
 * Extracting the constants from a list and format them in Java enum style.
 * Jan-Christoph Klie - Only the layout of this file.
 *******************************************************************************/

package com.bragi.sonify.music;

/**
 * This enum holds constants for all MIDI instruments and their respective
 * keys as given by the MIDI standard.
 * 
 * For a further description, refer to:
 * http://soundprogramming.net/file_formats/general_midi_instrument_list
 * 
 * @deprecated
 * @author Sebastian Muszytowski
 * @author Jan-Christoph Klie
 */
public enum Instrument {
	
	/*
	 * Piano
	 */
	AcousticGrandPiano(1),
	BrightAcousticPiano(2),
	ElectricGrandPiano(3),
	HonkyTonkPiano(4),
	ElectricPiano1(5),
	ElectricPiano2(6),
	Harpsichord(7),
	Clavinet(8),
	
	/*
	 * Chromatic Percussion
	 */
	Celesta(9),
	Glockenspiel(10),
	MusicBox(11),
	Vibraphone(12),
	Marimba(13),
	Xylophone(14),
	TubularBells(15),
	Dulcimer(16),
	
	/*
	 * Organ
	 */
	DrawbarOrgan(17),
	PercussiveOrgan(18),
	RockOrgan(19),
	ChurchOrgan(20),
	ReedOrgan(21),
	Accordion(22),
	Harmonica(23),
	TangoAccordion(24),
	
	/*
	 * Guitar
	 */
	AcousticGuitarNylon(25), /* nylon */
	AcousticGuitarSteel(26), /* steel */
	ElectricGuitarJazz(27), /* jazz */
	ElectricGuitarClean(28), /* clean */
	ElectricGuitarMuted(29), /* muted */
	OverdrivenGuitar(30),
	DistortionGuitar(31),
	Guitarharmonics(32),
	
	/*
	 * Bass
	 */
	AcousticBass(33),
	ElectricBassFinger(34), /* finger */
	ElectricBassPick(35), /* pick */
	FretlessBass(36),
	SlapBass1(37),
	SlapBass2(38),
	SynthBass1(39),
	SynthBass2(40),
	
	/*
	 * Strings
	 */
	Violin(41),
	Viola(42),
	Cello(43),
	Contrabass(44),
	TremoloStrings(45),
	PizzicatoStrings(46),
	OrchestralHarp(47),
	Timpani(48),
	StringEnsemble1(49),
	StringEnsemble2(50),
	SynthStrings1(51),
	SynthStrings2(52),
	ChoirAahs(53),
	VoiceOohs(54),
	SynthVoice(55),
	OrchestraHit(56),
	
	/*
	 * Brass
	 */
	Trumpet(57),
	Trombone(58),
	Tuba(59),
	MutedTrumpet(60),
	FrenchHorn(61),
	BrassSection(62),
	SynthBrass1(63),
	SynthBrass2(64),
	
	/*
	 * Reed
	 */
	SopranoSax(65),
	AltoSax(66),
	TenorSax(67),
	BaritoneSax(68),
	Oboe(69),
	EnglishHorn(70),
	Bassoon(71),
	Clarinet(72),
	Piccolo(73),
	
	/*
	 * Pipe
	 */
	Flute(74),
	Recorder(75),
	PanFlute(76),
	BlownBottle(77),
	Shakuhachi(78),
	Whistle(79),
	Ocarina(80),
	
	/*
	 * Synth Lead
	 */
	Lead1(81), /* square */
	Lead2(82), /* sawtooth */
	Lead3(83), /* calliope */
	Lead4(84), /* chiff */
	Lead5(85), /* charang */
	Lead6(86), /* voice */
	Lead7(87), /* fifths */
	Lead8(88), /* bass+lead */
	
	/*
	 * Synth Pad
	 */
	Pad1(89), /* newage */
	Pad2(90), /* warm */
	Pad3(91), /* polysynth */
	Pad4(92), /* choir */
	Pad5(93), /* bowed */
	Pad6(94), /* metallic */
	Pad7(95), /* halo */
	Pad8(96), /* sweep */
	
	/*
	 * Synth Effects
	 */
	FX1(97),  /* rain */
	FX2(98),  /* soundtrack */
	FX3(99),  /* crystal */
	FX4(100), /* atmosphere */
	FX5(101), /* brightness */
	FX6(102), /* goblins */
	FX7(103), /* echoes */
	FX8(104), /* sci-fi */
	
	/*
	 * Ethnic
	 */
	Sitar(105),
	Banjo(106),
	Shamisen(107),
	Koto(108),
	Kalimba(109),
	Bagpipe(110),
	Fiddle(111),
	Shanai(112),
	TinkleBell(113),
	
	/*
	 * Percussive
	 */
	Agogo(114),
	SteelDrums(115),
	Woodblock(116),
	TaikoDrum(117),
	MelodicTom(118),
	SynthDrum(119),
	
	/*
	 * Sound effects
	 */
	ReverseCymbal(120),
	GuitarFretNoise(121),
	BreathNoise(122),
	Seashore(123),
	BirdTweet(124),
	TelephoneRing(125),
	Helicopter(126),
	Applause(127),
	Gunshot(128);
	
	int key;
	
	Instrument(int k) {
		this.key = k;
	}

}
