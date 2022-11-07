# coding=utf-8                                                                                                                                                                                     
from math import sqrt
def calFloat(a):
    for i in range(7):
        a = a*a
    return a

if __name__ == '__main__':
    result = calFloat(0.0003)
    print(result)