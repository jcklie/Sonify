#!/usr/bin/env python

import re#ntier
from os import listdir, path, rename

fileDir = "/home/jan-christoph/git/Sonify/src/main/resources/midi/mozart_contra"
fileList = listdir(fileDir)

for f in fileList:	 
	matched = re.search('\d+', f, re.IGNORECASE).group()
	newName = "C{}.mid".format(int(matched))
	rename( path.join(fileDir, f), path.join(fileDir, newName) ) 

	
	

