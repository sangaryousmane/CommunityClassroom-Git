import scipy.stats as stats
A=[0.54,0.74,0.88,0.74]
B=[0.29,0.29,0.19,0.09]
C=[0.11,0.11,0.21,0.11]
D=[0.24,0.24,0.24,0.24]
E=[0.29,0.69,0.39,0.29]
F=[0.09,0.09,0.09,0.31]
G=[0.01,0.91,0.44,0.51]
H=[0.19,0.89,0.79,0.59]
I=[0.29,0.69,0.09,0.65]
J=[0.31,0.61,0.56,0.58]
K=[0.48,0.71,0.71,0.67]
L=[0.44,0.67,0.59,0.54]
print(stats.kruskal(A,B,C,D,E,F,G,H,I,J,K,L))
print("------------------------")
# print(stats.kruskal(A,B))
# print(stats.kruskal(A,C))
# print(stats.kruskal(A,D))
# print(stats.kruskal(A,E))
# print(stats.kruskal(A,F))
# print(stats.kruskal(A,G))
# print(stats.kruskal(A,H))
# print(stats.kruskal(A,I))
# print(stats.kruskal(A,J))
# print(stats.kruskal(A,K))

print(stats.mannwhitneyu(A,B,alternative='two-sided'))
print(stats.mannwhitneyu(A,C,alternative='two-sided'))
print(stats.mannwhitneyu(A,D,alternative='two-sided'))
print(stats.mannwhitneyu(A,E,alternative='two-sided'))
print(stats.mannwhitneyu(A,F,alternative='two-sided'))
print(stats.mannwhitneyu(A,G,alternative='two-sided'))
print(stats.mannwhitneyu(A,H,alternative='two-sided'))
print(stats.mannwhitneyu(A,I,alternative='two-sided'))
print(stats.mannwhitneyu(A,J,alternative='two-sided'))
print(stats.mannwhitneyu(A,K,alternative='two-sided'))
print(stats.mannwhitneyu(A,L,alternative='two-sided'))