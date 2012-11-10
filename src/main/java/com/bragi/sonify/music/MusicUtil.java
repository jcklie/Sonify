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
 * 'Static' class for general factory methods concerning music objects.
 * @deprecated
 * Jan-Christoph Klie
 */
public class MusicUtil {

	/**
	 * MusicXML has two tags to represent the pitch of a node: step and octave. This function
	 * creates from this information a Pitch object and returns it
	 * 
	 * @param step The step of the pitch 
	 * @param octave The octave of the pitch 
	 * @return A pitch with the given step and octave
	 */
	public static Pitch translatePitch(String step, String octave) {
		return Pitch.valueOf(step+octave);
	}


}
