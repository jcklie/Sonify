#!/usr/bin/env python

import re

p1 = """| 23 | 63 | 79 | 13 | 43 | 32 
| 77 | 54 | 75 | 57 | 7 | 47 
| 62 | 2 | 42 | 64 | 86 | 84 
| 70 | 53 | 5 | 74 | 31 | 20 
| 29 | 41 | 50 | 11 | 18 | 22 
| 83 | 37 | 69 | 3 | 89 | 49 
| 59 | 71 | 52 | 67 | 87 | 56 
| 36 | 90 | 8 | 73 | 58 | 48 """


p2 = """| 33 | 55 | 4 | 95 | 38 | 44
| 60 | 46 | 12 | 78 | 93 | 76
| 21 | 88 | 94 | 80 | 15 | 34
| 14 | 39 | 9 | 30 | 92 | 19
| 45 | 65 | 25 | 1 | 28 | 17
| 68 | 6 | 35 | 51 | 61 | 10
| 26 | 91 | 66 | 82 | 72 | 27
| 40 | 81 | 24 | 16 | 85 | 96"""

measureHead = """
/*
 * Measure {0}
 */
"""

def print_properly(map, i):
	print(  measureHead.format(i+9) )
	print( "measureMap = measureMapList.get({0});".format(i+8) )
	for i in range( 1, 7):
		print( "measureMap.put({0}, {1});".format(i, map[i]) )

def foo(s):

	s = re.sub(r'\|', ' ', s)
	s = re.sub(r'^ *', '', s, flags=re.M)
	s = re.sub(r' +', ' ', s, flags=re.M)
	s_splitted = re.split( r'\n', s)
	res = []
	for j, line in zip(range(0, len(s_splitted)), s_splitted):
		res.append( {})
		line = line.rstrip(' ')
		line_splitted = re.split( r' ', line)
		
		for i in range(len(line_splitted)):
			res[j][i+1] = line_splitted[i]
		
		
	return res

m = foo(p2)
for k, v in zip(range(0, len(m)), m):
	print_properly(v, k)


