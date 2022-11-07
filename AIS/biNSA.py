""" binary negative selection algorithm
"""

# Author: Wendie Zhou <zw_mmwh@whu.edu.cn>
# Forrest S, Perelson A S, Allen L, et al. Self-nonself discrimination in a computer[C]//Proceedings of 1994 IEEE computer society symposium on research in security and privacy. Ieee, 1994: 202-212.
# License:

import math
import random

def _assess_parameters(m, l, r, pf):
    """Compute the log-likelihood of a rank ``rank`` dataset.
    Parameters
    ----------

    Returns
    -------
    """
    pm = math.pow(m,-r)*((l-r)*(m-1)/m+1)
    nr = math.log10(pf)/math.log10(1-pm)
    return pm, nr


class biNSA():
    """binary negative selection algorithm (biNSA).

    A method for change detection which is based on the generation of T cells 
    in the immune system.

    The algorithm has two phases: 
    1. Generate a set of detectors. Each detector is a string that does not match 
    any of the protected data (see below for a careful definition of match").
    2. Monitor the protected data by comparing them with the detectors. If a 
    detector is ever activated, a change is known to have occurred.

    Parameters
    ----------
    checkFalsePro(Pf): float, default=0.0
        The probability that NR detectors fail to detect an intrusion.
    
    symNum(m): int
        the number of alphabet symbols
    
    symStrNum(l): int
        the number of symbols in a string (length of the string)
    
    selfStrNum(NS): int
        The number of self strings
    
    conMatchNum(r): int
        the number of contiguous matches required for a match
    
    Attributes
    ----------
    n_features_ : int
        Number of features in the training data.

    n_samples_ : int
        Number of samples in the training data.
    
    iniDetectorNum(NR0): int
        The number of initial detector strings (before censoring)
    
    detectorNum(NR): int
        The number of detector strings after censoring (size of the repertoire).
    
    selfStrNum(NS): int
        The number of self strings
    
    matchPro(PM): float, default=0.0
        The probability of a match between 2 random strings
    
    notMatchPro(f): float, default=0.0
        The probability of a random string not matching any of the Ns self strings
    
    checkFalsePros(Pf): float, default=0.0
        The probability that NR detectors fail to detect an intrusion.
   

    Examples
    --------
    >>> import numpy as np
    >>> from sklearn.decomposition import PCA
    >>> X = np.array([[-1, -1], [-2, -1], [-3, -2], [1, 1], [2, 1], [3, 2]])
    >>> pca = PCA(n_components=2)
    >>> pca.fit(X)
    PCA(n_components=2)
    >>> print(pca.explained_variance_ratio_)
    [0.9924... 0.0075...]
    >>> print(pca.singular_values_)
    [6.30061... 0.54980...]

    """
    def __init__(self, checkFalsePro=0.0, symNum=1, symStrNum=1, selfStrNum= 1,
                 conMatchNum=1) -> None:
        self.checkFalsePro = checkFalsePro
        self.symNum = symNum
        self.symStrNum = symStrNum
        self.selfStrNum = selfStrNum
        self.conMatchNum = conMatchNum

    def fit(self, X, y):
        """Fit the model with X.

        Parameters
        ----------
        X : array-like of shape (n_samples, n_features)
            Training data, where n_samples is the number of samples
            and n_features is the number of features.

        y : Ignored
 
        Returns
        -------
        self : object
            Returns the instance itself.
        """
        matchPro, detectorNum = _assess_parameters(self.symNum, self.symStrNum, self.conMatchNum, self.checkFalsePro)
        detectorsSet = []
        pf = 0
        for i in range(50):
            print("iteration:",i)
            detectorsSet = self.geneDetector(detectorNum)
            pf += self.test(X, y, detectorsSet)
        pfPre = pf/50
        return pfPre

    def geneDetector(self, detectorNum):
        """generate detectors"""
        selfSet = []
        selfSet = self.geneStrings(self.selfStrNum)
        randomSet = []
        randomSet = self.geneStrings(100)
        detectorsSet = []
        i = 0
        while(i < detectorNum):
            for j in range(len(selfSet)):
                for k in range(len(randomSet)):
                    # judge the similarity beween selfSet and randomSet
                    lenth = self.getMaxCommonSubstr(selfSet[j], randomSet[k])
                    # if two continues bits are the same, delete, else, consider as detector
                    if lenth < self.conMatchNum:
                        detectorsSet.append(randomSet[k])
                        i = i+1
        return detectorsSet



    def test(self, X, y, detectorsSet):
        """test"""
        n_samples = len(X)
        _y = [0 for i in range(n_samples)]
        for j in range(n_samples):
                for k in range(len(detectorsSet)):
                    # judge the similarity beween selfSet and randomSet
                    lenth = self.getMaxCommonSubstr(X[j], detectorsSet[k])
                    # if two continues bits are the same, delete, else, consider as detector
                    if lenth >= self.conMatchNum:
                        _y[j] = 1       #anomaly
                    else:
                        _y[j] = 0       #normal
        pf = self.score(y, _y)
        return pf


    def score(self, y, _y):
        """The probability that NR detectors fail to detect an intrusion."""
        j = 0
        sum = 0
        for i in range(len(y)):
            sum += y[i]
            if y[i] == 1 and _y[i] == 0:
                j = j + 1
        anomalyPro = j/sum
        return anomalyPro

    # generate self strings
    def geneStrings(self, num):
        geStrings = []
        for i in range(num):
            geStrings.append(f'{random.getrandbits(self.symStrNum):=032b}')
        return geStrings


    def getMaxCommonSubstr(self, s1, s2):
        # 求两个字符串的最长公共子串
        # 思想：建立一个二维数组，保存连续位相同与否的状态
        len_s1 = len(s1)
        len_s2 = len(s2)
        # 生成0矩阵，为方便后续计算，多加了1行1列
        # 行: (len_s1+1)
        # 列: (len_s2+1)
        record = [[0 for i in range(len_s2+1)] for j in range(len_s1+1)]    
        maxNum = 0          # 最长匹配长度
        p = 0               # 字符串匹配的终止下标 
        for i in range(len_s1):
            for j in range(len_s2):
                if s1[i] == s2[j]:
                    # 相同则累加
                    record[i+1][j+1] = record[i][j] + 1                    
                    if record[i+1][j+1] > maxNum:
                        maxNum = record[i+1][j+1]
                        p = i # 匹配到下标i
        # 返回子串长度
        return maxNum

if __name__ == "__main__":
    nsa = biNSA(checkFalsePro=0.1, symNum=2, symStrNum=32, selfStrNum= 8,
                 conMatchNum=8)
    testSet = nsa.geneStrings(10)
    y = [0,1,1,0,1,0,1,1,0,1]
    pfPre = nsa.fit(testSet,y)
    print(nsa.selfStrNum, pfPre)
