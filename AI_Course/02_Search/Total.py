# 定义节点类
class Node(object):
    def __init__(self,val,left=None,right=None):
        self.val = val
        self.left = left
        self.right = right
        
# 创建树模型
node = Node("A",Node("B",Node("D"),Node("E")),Node("C",Node("F"),Node("G")))

def DFS(root):
# 使用列表作为栈
    stack = []
    # 将首个根节点添加到栈中
    stack.append(root)
    # 当栈不为空时进行遍历
    while stack:
    # 从栈的末尾弹出一个节点并判断其是否有左右节点
    # 若有子节点则把对应子节点压入栈中，且优先判断右节点
        temp = stack.pop()
        left = temp.left
        right = temp.right
        if right:
            stack.append(right)
        if left:
            stack.append(left)
        print(temp.val,end=" ")

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
        right = temp.right
        if left:
            queue.append(left)
        if right:
            queue.append(right)
        print(temp.val,end=" ")

print("DFS",end=" ")
DFS(node)
print("")
print("BFS",end=" ")
BFS(node)
