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
import java.net.URL;
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
	 * Gives easy access to files in the resource folder (src/main/resources/)
	 * @param path Path to the resource. 
	 * @return The file of the requested resource
	 */
	public static File getResourcetFile(String path) {
		
		/*
		 * Depending on the fact whether the application is run a *.jar or a
		 * *.class file, the resouces have different locations
		 */
		if( runFromJar() ) {
			if( path.startsWith("/")) {
				path = path.replaceFirst("/", "");
			}
			return new File("src/main/resources/", path);
		} else {
			
			/*
			 * According to the rules of the getResource method called,
			 * resources identfied by an absolute path need a trailing 
			 * front slash
			 */
			if( !path.startsWith("/")) {
				path = "/" + path;
			}
			
			URL url = FileUtil.class.getResource(path);
			return new File(url.getFile());
		}
	}
	
	/**
	 * Checks whether this function is called from a *.jar or a *.class
	 * @return
	 */
	public static boolean runFromJar() {
		String className = FileUtil.class.getName().replace('.', '/');
		String classJar = FileUtil.class.getResource("/" + className + ".class").toString();
		if (classJar.startsWith("jar:")) {			 
			return true;
		}		
		return false;
		
	}
		
	


}
