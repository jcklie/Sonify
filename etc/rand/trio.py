#!/usr/bin/env python

t1 = {'1':72, '2':56, '3':75, '4':40, '5':83, '6':18}
t2 = {'1':6, '2':82, '3':39, '4':73, '5':3, '6':45}
t3 = {'1':59, '2':42, '3':54, '4':16, '5':28, '6':62}
t4 = {'1':25, '2':74, '3':1, '4':68, '5':53, '6':38}
t5 = {'1':81, '2':14, '3':65, '4':29, '5':37, '6':5}
t6 = {'1':41, '2':7, '3':43, '4':55, '5':17, '6':28}
t7 = {'1':89, '2':26, '3':15, '4':2, '5':44, '6':52}
t8 = {'1':13, '2':71, '3':80, '4':61, '5':70, '6':94}
t9 = {'1':36, '2':76, '3':9, '4':22, '5':63, '6':11}
t10 = {'1':5, '2':20, '3':34, '4':67, '5':85, '6':92}
t11 = {'1':46, '2':64, '3':93, '4':49, '5':32, '6':24}
t12 = {'1':79, '2':84, '3':48, '4':77, '5':96, '6':86}
t13 = {'1':30, '2':8, '3':69, '4':57, '5':12, '6':51}
t14 = {'1':95, '2':35, '3':58, '4':87, '5':23, '6':60}
t15 = {'1':19, '2':47, '3':90, '4':33, '5':50, '6':78}
t16 = {'1':66, '2':88, '3':21, '4':10, '5':91, '6':31}

measureHead = """
/*
 * Measure {0}
 */
"""

def print_properly(map, i):
  print(  measureHead.format(i) )
  print( "measureMap = measureMapList.get({0});".format(i-1) )
  for i in range( 1, 7):
    print( "measureMap.put({0}, {1});".format(i, map[str(i)]) )

print_properly(t1, 1)
print_properly(t2, 2)
print_properly(t3, 3)
print_properly(t4, 4)
print_properly(t5, 5)
print_properly(t6, 6)
print_properly(t7, 7)
print_properly(t8, 8)
print_properly(t9, 9)
print_properly(t10, 10)
print_properly(t11, 11)
print_properly(t12, 12)
print_properly(t13, 13)
print_properly(t14, 14)
print_properly(t15, 15)
print_properly(t16, 16)