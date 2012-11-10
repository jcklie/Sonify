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

/**
 * Simple container class representing a note as found in music theory.
 * 
 * @deprecated
 * @author Jan-Christoph Klie
 */
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
