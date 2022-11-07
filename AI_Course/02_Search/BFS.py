# 定义节点类
class Node(object):
    def __init__(self,val,left=None,middle=None,right=None):
        self.val = val
        self.left = left
        self.middle = middle
        self.right = right
        
# 创建树模型
node = Node("S",Node("D",Node("B",Node("A")),Node("C",Node("A")),Node("E",Node("H",Node("P",Node("Q")),Node("Q")),Node("R",Node("F",Node("C",Node("A")),Node("G"))))),Node("E",Node("H",Node("P",Node("Q")),Node("Q")),Node("R",Node("F",Node("C",Node("A")),Node("G")))),Node("P",Node("Q")))

def BFS(root):
# 使用列表作为队列
    queue = []
    # 将首个根节点添加到队列中
    queue.append(root)
    # 当队列不为空时进行遍历
    while queue:
    # 从队列头部取出一个节点并判断其是否有左右节点
    # 若有子节点则把对应子节点添加到队列中，且优先判断左节点
        temp = queue.pop(0)
        left = temp.left
        middle = temp.middle
        right = temp.right
        if left:
            queue.append(left)
        if middle:
            queue.append(middle)
        if right:
            queue.append(right)
        print(temp.val,end=" ")

print("BFS",end=" ")
BFS(node)
