def depthFirstSearch(problem):
    """
    Search the deepest nodes in the search tree first.

    Your search algorithm needs to return a list of actions that reaches the
    goal. Make sure to implement a graph search algorithm.

    To get started, you might want to try some of these simple commands to
    understand the search problem that is being passed in:

    print("Start:", problem.getStartState())
    print("Is the start a goal?", problem.isGoalState(problem.getStartState()))
    print("Start's successors:", problem.getSuccessors(problem.getStartState()))
    """
    "*** YOUR CODE HERE ***"
    # 创建空集合closed用于存放已经搜索过的节点
    closed = set()
    # 创建待搜索的节点集合fringe，根据深度优先搜索算法的特点，应该使用栈作为其数据结构
    fringe = util.Stack()
    # 并将搜索问题的初始状态作为第一个待搜索节点添加到fringe集合中
    node = {"state":problem.getStartState(), "path":[]}     # 每一个节点中除了当前的状态，还需要保存到达此节点所需执行的行动序列，即变量path中存放的内容
    fringe.push(node)
    # 构建循环进行搜索
    while True:
        # 如果fringe集合为空，表示已经把所有待搜索的节点都搜索过了，但依然没有找到可行的行动序列，则搜索失败
        if fringe.isEmpty():
            return None
        # 如果上面的步骤不成立，表示fringe中还存在待搜索的节点，则从fringe中取出下一个待搜索节点
        node = fringe.pop()
        # 判断取出的节点是不是目标节点，如果是的话，表示搜索成功，返回到达该节点的行动序列即可
        if problem.isGoalState(node["state"]):
            return node["path"]
        # 如果当前节点不是目标节点，且节点信息不在已经搜索过的节点集合closed中
        elif node["state"] not in closed:
            # 将当前节点添加到已搜索的节点集合closed中
            closed.add(node["state"])
            # 展开当前节点的后续节点，并对这些节点进行遍历搜索
            for childnode in problem.getSuccessors(node["state"]):
                # 构造后续节点的相关信息，并将其添加到待搜索节点集合fringe中
                childnode = {"state":childnode[0],
                            "path":node["path"]+[childnode[1]]}
                fringe.push(childnode)

def breadthFirstSearch(problem):
    """Search the shallowest nodes in the search tree first."""
    "*** YOUR CODE HERE ***"
    # 创建空集合closed用于存放已经搜索过的节点
    closed = set()
    # 创建待搜索的节点集合fringe，根据广度优先搜索算法的特点，应该使用队列作为其数据结构
    fringe = util.Queue()
    # 并将搜索问题的初始状态作为第一个待搜索节点添加到fringe集合中
    node = {"state":problem.getStartState(), "path":[]}     # 每一个节点中除了当前的状态，还需要保存到达此节点所需执行的行动序列，即变量path中存放的内容
    fringe.push(node)
    # 构建循环进行搜索
    while True:
        # 如果fringe集合为空，表示已经把所有待搜索的节点都搜索过了，但依然没有找到可行的行动序列，则搜索失败
        if fringe.isEmpty():
            return None
        # 如果上面的步骤不成立，表示fringe中还存在待搜索的节点，则从fringe中取出下一个待搜索节点
        node = fringe.pop()
        # 判断取出的节点是不是目标节点，如果是的话，表示搜索成功，返回到达该节点的行动序列即可
        if problem.isGoalState(node["state"]):
            return node["path"]
        # 如果当前节点不是目标节点，且节点信息不在已经搜索过的节点集合closed中
        elif node["state"] not in closed:
            # 将当前节点添加到已搜索的节点集合closed中
            closed.add(node["state"])
            # 展开当前节点的后续节点，并对这些节点进行遍历搜索
            for childnode in problem.getSuccessors(node["state"]):
                # 构造后续节点的相关信息，并将其添加到待搜索节点集合fringe中
                childnode = {"state":childnode[0],
                            "path":node["path"]+[childnode[1]]}
                fringe.push(childnode)

def uniformCostSearch(problem):
    """Search the node of least total cost first."""
    "*** YOUR CODE HERE ***"
    # 创建空集合closed用于存放已经搜索过的节点
    closed = set()
    # 创建待搜索的节点集合fringe，根据一致代价搜索算法的特点，应该使用优先级队列作为其数据结构
    fringe = util.PriorityQueue()
    # 并将搜索问题的初始状态作为第一个待搜索节点添加到fringe集合中
    # 每一个节点中除了当前的状态，还需要保存到达此节点所需执行的行动序列和代价，即变量path和cost中存放的内容
    node = {"state":problem.getStartState(), "path":[], "cost":0}
    fringe.push(node, node["cost"])
    # 构建循环进行搜索
    while True:
        # 如果fringe集合为空，表示已经把所有待搜索的节点都搜索过了，但依然没有找到可行的行动序列，则搜索失败
        if fringe.isEmpty():
            return None
        # 如果上面的步骤不成立，表示fringe中还存在待搜索的节点，则从fringe中取出下一个待搜索节点
        node = fringe.pop()
        # 判断取出的节点是不是目标节点，如果是的话，表示搜索成功，返回到达该节点的行动序列即可
        if problem.isGoalState(node["state"]):
            return node["path"]
        # 如果当前节点不是目标节点，且节点信息不在已经搜索过的节点集合closed中
        elif node["state"] not in closed:
            # 将当前节点添加到已搜索的节点集合closed中
            closed.add(node["state"])
            # 展开当前节点的后续节点，并对这些节点进行遍历搜索
            for childnode in problem.getSuccessors(node["state"]):
                # 构造后续节点的相关信息，并将其添加到待搜索节点集合fringe中
                childnode = {"state":childnode[0],
                            "path":node["path"]+[childnode[1]],
                            "cost":node["cost"]+childnode[2]}
                fringe.update(childnode,childnode["cost"])

def aStarSearch(problem, heuristic=nullHeuristic):
    """Search the node that has the lowest combined cost and heuristic first."""
    "*** YOUR CODE HERE ***"
    # 创建空集合closed用于存放已经搜索过的节点
    closed = set()
    # 创建待搜索的节点集合fringe，根据统一代价搜索算法的特点，应该使用优先级队列作为其数据结构
    fringe = util.PriorityQueue()
    # 并将搜索问题的初始状态作为第一个待搜索节点添加到fringe集合中
    # 每一个节点中除了当前的状态，还需要保存到达此节点所需执行的行动序列和代价，即变量path和cost中存放的内容
    node = {"state":problem.getStartState(), "path":[], "cost":0}
    fringe.push(node, node["cost"]+heuristic(node["state"], problem))
    # 构建循环进行搜索
    while True:
        # 如果fringe集合为空，表示已经把所有待搜索的节点都搜索过了，但依然没有找到可行的行动序列，则搜索失败
        if fringe.isEmpty():
            return None
        # 如果上面的步骤不成立，表示fringe中还存在待搜索的节点，则从fringe中取出下一个待搜索节点
        node = fringe.pop()
        # 判断取出的节点是不是目标节点，如果是的话，表示搜索成功，返回到达该节点的行动序列即可
        if problem.isGoalState(node["state"]):
            return node["path"]
        # 如果当前节点不是目标节点，且节点信息不在已经搜索过的节点集合closed中
        elif node["state"] not in closed:
            # 将当前节点添加到已搜索的节点集合closed中
            closed.add(node["state"])
            # 展开当前节点的后续节点，并对这些节点进行遍历搜索
            for childnode in problem.getSuccessors(node["state"]):
                # 构造后续节点的相关信息，并将其添加到待搜索节点集合fringe中
                childnode = {"state":childnode[0],
                            "path":node["path"]+[childnode[1]],
                            "cost":node["cost"]+childnode[2]}
                fringe.update(childnode,childnode["cost"]+heuristic(childnode["state"], problem))