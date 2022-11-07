
class CornersProblem(search.SearchProblem):
    """
    This search problem finds paths through all four corners of a layout.

    You must select a suitable state space and successor function
    """

    def __init__(self, startingGameState):
        """
        Stores the walls, pacman's starting position and corners.
        """
        self.walls = startingGameState.getWalls()
        self.startingPosition = startingGameState.getPacmanPosition()
        top, right = self.walls.height-2, self.walls.width-2
        self.corners = ((1,1), (1,top), (right, 1), (right, top))
        for corner in self.corners:
            if not startingGameState.hasFood(*corner):
                print('Warning: no food in corner ' + str(corner))
        self._expanded = 0 # DO NOT CHANGE; Number of search nodes expanded
        # Please add any code here which you would like to use
        # in initializing the problem
        "*** YOUR CODE HERE ***"
        # 设置一个表示豆豆是否被吃掉的比特位元组
        self.startingFood = tuple([0]*len(self.corners))

    def getStartState(self):
        """
        Returns the start state (in your state space, not the full Pacman state
        space)
        """
        "*** YOUR CODE HERE ***"
        # 以吃豆人的初始位置和代表所有豆豆未被吃掉的比特位作为起始状态
        return (self.startingPosition,self.startingFood)

    def isGoalState(self, state):
        """
        Returns whether this search state is a goal state of the problem.
        """
        "*** YOUR CODE HERE ***"
        # 从当前的状态信息中分别拆解出吃豆人的位置和所有豆豆的状态信息
        currentPosition, foodEaten = state
        # 如果代表豆豆被吃掉的比特位全部都是1，则认定其达到了任务目标
        return sum(foodEaten) == len(self.corners)

    def getSuccessors(self, state):
        """
        Returns successor states, the actions they require, and a cost of 1.

         As noted in search.py:
            For a given state, this should return a list of triples, (successor,
            action, stepCost), where 'successor' is a successor to the current
            state, 'action' is the action required to get there, and 'stepCost'
            is the incremental cost of expanding to that successor
        """

        successors = []
        for action in [Directions.NORTH, Directions.SOUTH, Directions.EAST, Directions.WEST]:
            # Add a successor state to the successor list if the action is legal
            # Here's a code snippet for figuring out whether a new position hits a wall:
            #   x,y = currentPosition
            #   dx, dy = Actions.directionToVector(action)
            #   nextx, nexty = int(x + dx), int(y + dy)
            #   hitsWall = self.walls[nextx][nexty]

            "*** YOUR CODE HERE ***"
            # 先获取吃豆人的位置，状态中最开始的两个数字就是当前吃豆人的坐标
            x,y = state[0]
            # 根据action中的行动，得到下一个位置在哪里，同时判断下一个位置是不是遇到了障碍物
            dx, dy = Actions.directionToVector(action)
            nextx, nexty = int(x + dx), int(y + dy)
            hitsWall = self.walls[nextx][nexty]
            # 如果下一步没有遇到障碍物的话，就要构造后继节点的信息，并将其将其加入到后续节点集合successors中
            if not hitsWall:
                # 获取位置信息
                location = (nextx, nexty)
                # 获取所有豆豆的信息，并根据位置信息进行更新
                foodEaten = list(state[1])
                if location in self.corners:
                    index = self.corners.index(location)
                    foodEaten[index]=1
                # 由位置信息和状态信息，构造后继节点
                successor = (( location, tuple(foodEaten) ), action, 1)
                successors.append(successor)

        self._expanded += 1 # DO NOT CHANGE
        return successors

    def getCostOfActions(self, actions):
        """
        Returns the cost of a particular sequence of actions.  If those actions
        include an illegal move, return 999999.  This is implemented for you.
        """
        if actions == None: return 999999
        x,y= self.startingPosition
        for action in actions:
            dx, dy = Actions.directionToVector(action)
            x, y = int(x + dx), int(y + dy)
            if self.walls[x][y]: return 999999
        return len(actions)

def cornersHeuristic(state, problem):
    """
    A heuristic for the CornersProblem that you defined.

      state:   The current search state
               (a data structure you chose in your search problem)

      problem: The CornersProblem instance for this layout.

    This function should always return a number that is a lower bound on the
    shortest path from the state to a goal of the problem; i.e.  it should be
    admissible (as well as consistent).
    """
    corners = problem.corners # These are the corner coordinates
    walls = problem.walls # These are the walls of the maze, as a Grid (game.py)

    "*** YOUR CODE HERE ***"
    # 大概的思路就是从当前位置开始，总是先去吃掉离自己最近的豆豆
    x,y = state[0]                  # 获取当前吃豆人的位置
    heuristicAccumulator = 0        # 存放累加的启发值
    foodRemain = {}                 # 用来表示还有哪些豆豆没被吃掉
    # 需要先把所有没有吃掉的豆豆的位置保存下来，并设置值的初始值为0
    for i in range(len(state[1])):
        if state[1][i]==0:
            foodRemain[corners[i]] = 0
    # 然后从吃豆人初始的位置，挨个求出吃掉最近豆豆的曼哈顿距离，并求和
    while(len(foodRemain)>0):
        # 内部这个循环的目的是计算从当前位置(x,y)到每一个豆豆的曼哈顿距离，并保存下来
        for nextNode in foodRemain.keys():
            foodRemain[nextNode] = abs(x-nextNode[0])+abs(y-nextNode[1])
        # 完成上述的计算，就可以从一系列豆豆中找到曼哈顿距离最短的豆豆，并用其坐标更新(x,y)，表示下一次计算以这个豆豆的位置作为起始
        x,y = min(foodRemain,key=lambda key:foodRemain[key])
        # 并将该豆豆的曼哈顿距离计入启发值累加起来
        heuristicAccumulator += foodRemain[(x,y)]
        # 最后，将表示该豆豆的对应位置从表示未被吃掉的豆豆的集合中删掉，表示该豆豆已经吃掉了
        del foodRemain[(x,y)]
    # 上述循环做完之后，将累加的启发值返回出去即可
    return heuristicAccumulator

def foodHeuristic(state, problem):
    """
    Your heuristic for the FoodSearchProblem goes here.

    This heuristic must be consistent to ensure correctness.  First, try to come
    up with an admissible heuristic; almost all admissible heuristics will be
    consistent as well.

    If using A* ever finds a solution that is worse uniform cost search finds,
    your heuristic is *not* consistent, and probably not admissible!  On the
    other hand, inadmissible or inconsistent heuristics may find optimal
    solutions, so be careful.

    The state is a tuple ( pacmanPosition, foodGrid ) where foodGrid is a Grid
    (see game.py) of either True or False. You can call foodGrid.asList() to get
    a list of food coordinates instead.

    If you want access to info like walls, capsules, etc., you can query the
    problem.  For example, problem.walls gives you a Grid of where the walls
    are.

    If you want to *store* information to be reused in other calls to the
    heuristic, there is a dictionary called problem.heuristicInfo that you can
    use. For example, if you only want to count the walls once and store that
    value, try: problem.heuristicInfo['wallCount'] = problem.walls.count()
    Subsequent calls to this heuristic can access
    problem.heuristicInfo['wallCount']
    """
    position, foodGrid = state
    "*** YOUR CODE HERE ***"
    # 大概的思路就是从当前位置开始，总是先去吃掉离自己最远的豆豆，因为可能会顺带消灭其他豆豆^_^
    # 应该还有更好的方法，但是我提供的这种方法，展开节点数量比较少，可以拿到额外的附加分
    x,y = position
    foodRemain = {}
    # 需要先把所有没有吃掉的豆豆的位置保存下来，并设置值的初始值为0
    for food in foodGrid.asList():
        foodRemain[food] = 0
    # 然后从吃豆人当前的位置，求出吃掉实际步数最多豆豆的距离，如果没有豆豆可以吃了，就返回0
    if len(foodRemain)>0:
        # 内部这个循环的目的是计算从当前位置(x,y)到每一个豆豆的实际行走距离，并保存下来
        for nextNode in foodRemain.keys():
            foodRemain[nextNode] = mazeDistance((x,y), nextNode, problem.startingGameState)
        # 从一系列豆豆中找到实际步数最多的豆豆，并用其坐标更新(x,y)
        x,y = max(foodRemain,key=lambda key:foodRemain[key])
        return foodRemain[(x,y)]
    else:
        return 0

class ClosestDotSearchAgent(SearchAgent):
    "Search for all food using a sequence of searches"
    def registerInitialState(self, state):
        self.actions = []
        currentState = state
        while(currentState.getFood().count() > 0):
            nextPathSegment = self.findPathToClosestDot(currentState) # The missing piece
            self.actions += nextPathSegment
            for action in nextPathSegment:
                legal = currentState.getLegalActions()
                if action not in legal:
                    t = (str(action), str(currentState))
                    raise Exception('findPathToClosestDot returned an illegal move: %s!\n%s' % t)
                currentState = currentState.generateSuccessor(0, action)
        self.actionIndex = 0
        print('Path found with cost %d.' % len(self.actions))

    def findPathToClosestDot(self, gameState):
        """
        Returns a path (a list of actions) to the closest dot, starting from
        gameState.
        """
        # Here are some useful elements of the startState
        startPosition = gameState.getPacmanPosition()
        food = gameState.getFood()
        walls = gameState.getWalls()
        problem = AnyFoodSearchProblem(gameState)

        "*** YOUR CODE HERE ***"
        # 根据题目提示，最快的方法就是以最小的代价吃掉屏幕上的任意豆豆，所以我们调用UCS算法即可完成这个题目
        return search.uniformCostSearch(AnyFoodSearchProblem(gameState))

class AnyFoodSearchProblem(PositionSearchProblem):
    """
    A search problem for finding a path to any food.

    This search problem is just like the PositionSearchProblem, but has a
    different goal test, which you need to fill in below.  The state space and
    successor function do not need to be changed.

    The class definition above, AnyFoodSearchProblem(PositionSearchProblem),
    inherits the methods of the PositionSearchProblem.

    You can use this search problem to help you fill in the findPathToClosestDot
    method.
    """

    def __init__(self, gameState):
        "Stores information from the gameState.  You don't need to change this."
        # Store the food for later reference
        self.food = gameState.getFood()

        # Store info for the PositionSearchProblem (no need to change this)
        self.walls = gameState.getWalls()
        self.startState = gameState.getPacmanPosition()
        self.costFn = lambda x: 1
        self._visited, self._visitedlist, self._expanded = {}, [], 0 # DO NOT CHANGE

    def isGoalState(self, state):
        """
        The state is Pacman's position. Fill this in with a goal test that will
        complete the problem definition.
        """
        x,y = state

        "*** YOUR CODE HERE ***"
        # 对于吃掉任意豆豆的目标状态应该就是只要吃豆人的位置和豆豆的位置相同即可
        return (x,y) in self.food.asList()