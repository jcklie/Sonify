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

package com.bragi.sonify.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

/**
 * This 'static' class is home for utillity methods concerning file operations
 * 
 * @author Jan-Christoph Klie 
 */
public class FileUtil {
	
	/**
	 * Reads the contents of a text file and returns them in a string 
	 * @param f The text file to read
	 * @return The contents of the file as a string
	 * @throws IOException
	 */
	public static String readFile(File f) throws IOException {
		FileInputStream stream = new FileInputStream(f);
		try {
			FileChannel fc = stream.getChannel();
			MappedByteBuffer bb = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size());
			/* Instead of using default, pass in a decoder. */
			return Charset.defaultCharset().decode(bb).toString();
		} finally {
			stream.close();
		}
	}
	
	/**
	 * Gets an input stream on a resource
	 * @param path The path to the resource
	 * @return input stream on the resource specified by path 
	 */
	public static InputStream getResourcetStream(String path) {
		if( !path.startsWith("/")) {
			path = "/" + path;
		}		
		
		return FileUtil.class.getResourceAsStream(path);		
	}
}
