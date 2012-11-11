#!/usr/bin/env python

import re#ntier

p1 = """070 010 033 036 105 165 007 142 099 085 145 
014 064 001 114 150 152 081 106 068 045 097 
164 100 160 008 057 112 131 040 086 090 006 
122 012 163 035 071 015 037 069 139 158 121 
025 149 077 111 117 147 021 043 120 082 056 
153 030 156 039 052 027 125 140 092 123 067 
018 161 168 137 132 073 049 023 143 078 063 
167 011 172 044 130 102 115 089 083 058 016"""

p2 = """070 010 033 036 105 165 007 142 099 085 145
155 148 022 004 136 144 116 066 093 061 050
003 028 176 157 091 104 133 124 055 034 079 
162 135 062 038 138 087 072 026 029 119 175 
170 173 126 009 019 107 141 084 051 046 076 
013 169 031 151 134 128 094 075 042 059 113 
166 174 024 032 101 048 080 103 110 054 088 
095 002 159 017 154 109 129 096 108 060 053 
005 020 041 171 146 074 065 127 098 047 118"""


measureHead = """
/*
 * Measure {0}
 */
"""

def print_properly(map, i):
	print(  measureHead.format(i+1) )
	print( "measureMap = measureMapList.get({0});".format(i) )
	for i in range( 1, 12):
		print( "measureMap.put({0}, {1});".format(i+1, int(map[i])) )

def foo(s):

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
	pass
	print_properly(v, k)