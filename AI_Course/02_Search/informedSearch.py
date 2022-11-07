import math
import sys
from collections import deque


class Problem:
    """The abstract class for a formal problem. You should subclass
    this and implement the methods actions and result, and possibly
    __init__, goal_test, and path_cost. Then you will create instances
    of your subclass and solve them with the various search functions."""

    def __init__(self, initial, goal=None):
        """The constructor specifies the initial state, and possibly a goal
        state, if there is a unique goal. Your subclass's constructor can add
        other arguments."""
        self.initial = initial
        self.goal = goal

    def actions(self, state):
        """Return the actions that can be executed in the given
        state. The result would typically be a list, but if there are
        many actions, consider yielding them one at a time in an
        iterator, rather than building them all at once."""
        raise NotImplementedError

    def result(self, state, action):
        """Return the state that results from executing the given
        action in the given state. The action must be one of
        self.actions(state)."""
        raise NotImplementedError

    def goal_test(self, state):
        """Return True if the state is a goal. The default method compares the
        state to self.goal or checks for state in self.goal if it is a
        list, as specified in the constructor. Override this method if
        checking against a single self.goal is not enough."""
        if isinstance(self.goal, list):
            return is_in(state, self.goal)
        else:
            return state == self.goal

    def path_cost(self, c, state1, action, state2):
        """Return the cost of a solution path that arrives at state2 from
        state1 via action, assuming cost c to get up to state1. If the problem
        is such that the path doesn't matter, this function will only look at
        state2. If the path does matter, it will consider c and maybe state1
        and action. The default method costs 1 for every step in the path."""
        return c + 1

    def value(self, state):
        """For optimization problems, each state has a value. Hill Climbing
        and related algorithms try to maximize this value."""
        raise NotImplementedError


# ______________________________________________________________________________


class Node:
    """A node in a search tree. Contains a pointer to the parent (the node
    that this is a successor of) and to the actual state for this node. Note
    that if a state is arrived at by two paths, then there are two nodes with
    the same state. Also includes the action that got us to this state, and
    the total path_cost (also known as g) to reach the node. Other functions
    may add an f and h value; see best_first_graph_search and astar_search for
    an explanation of how the f and h values are handled. You will not need to
    subclass this class."""

    def __init__(self, state, parent=None, action=None, path_cost=0):
        """Create a search tree Node, derived from a parent by an action."""
        self.state = state
        self.parent = parent
        self.action = action
        self.path_cost = path_cost
        self.depth = 0
        if parent:
            self.depth = parent.depth + 1

    def __repr__(self):
        return "<Node {}>".format(self.state)

    def __lt__(self, node):
        return self.state < node.state

    def expand(self, problem):
        """List the nodes reachable in one step from this node."""
        return [self.child_node(problem, action)
                for action in problem.actions(self.state)]

    def child_node(self, problem, action):
        """[Figure 3.10]"""
        next_state = problem.result(self.state, action)
        next_node = Node(next_state, self, action, problem.path_cost(self.path_cost, self.state, action, next_state))
        return next_node

    def solution(self):
        """Return the sequence of actions to go from the root to this node."""
        return [node.state for node in self.path()[0:]]

    def path(self):
        """Return a list of nodes forming the path from the root to this node."""
        node, path_back = self, []
        while node:
            path_back.append(node)
            node = node.parent
        return list(reversed(path_back))

    # We want for a queue of nodes in breadth_first_graph_search or
    # astar_search to have no duplicated states, so we treat nodes
    # with the same state as equal. [Problem: this may not be what you
    # want in other contexts.]

    def __eq__(self, other):
        return isinstance(other, Node) and self.state == other.state

    def __hash__(self):
        # We use the hash value of the state
        # stored in the node instead of the node
        # object itself to quickly search a node
        # with the same state in a Hash Table
        return hash(self.state)


neighbor_map = {'Arad': ['Zerind', 'Sibiu', 'Timisoara'], 'Bucharest': ['Urziceni', 'Pitesti', 'Giurgiu', 'Fagaras'],
                'Craiova': ['Drobeta', 'Rimnicu', 'Pitesti'], 'Drobeta': ['Mehadia'], 'Eforie': ['Hirsova'],
                'Fagaras': ['Sibiu'], 'Hirsova': ['Urziceni'], 'Iasi': ['Vaslui', 'Neamt'],
                'Lugoj': ['Timisoara', 'Mehadia'],
                'Oradea': ['Zerind', 'Sibiu'], 'Pitesti': ['Rimnicu'], 'Rimnicu': ['Sibiu'], 'Urziceni': ['Vaslui']}

neighbormapWithweight = {'Arad': {'Zerind': 75, 'Sibiu': 140, 'Timisoara': 118},
                         'Bucharest': {'Urziceni': 85, 'Pitesti': 101, 'Giurgiu': 90, 'Fagaras': 211},
                         'Craiova': {'Drobeta': 120, 'Rimnicu': 146, 'Pitesti': 138},
                         'Drobeta': {'Mehadia': 75},
                         'Eforie': {'Hirsova': 86},
                         'Fagaras': {'Sibiu': 99},
                         'Hirsova': {'Urziceni': 98},
                         'Iasi': {'Vaslui': 92, 'Neamt': 87},
                         'Lugoj': {'Timisoara': 111, 'Mehadia': 70},
                         'Oradea': {'Zerind': 71, 'Sibiu': 151},
                         'Pitesti': {'Rimnicu': 97},
                         'Rimnicu': {'Sibiu': 80},
                         'Urziceni': {'Vaslui': 142}
                         }

romania_map_locations = dict(
    Arad=(91, 492), Bucharest=(400, 327), Craiova=(253, 288),
    Drobeta=(165, 299), Eforie=(562, 293), Fagaras=(305, 449),
    Giurgiu=(375, 270), Hirsova=(534, 350), Iasi=(473, 506),
    Lugoj=(165, 379), Mehadia=(168, 339), Neamt=(406, 537),
    Oradea=(131, 571), Pitesti=(320, 368), Rimnicu=(233, 410),
    Sibiu=(207, 457), Timisoara=(94, 410), Urziceni=(456, 350),
    Vaslui=(509, 444), Zerind=(108, 531))

straight_line_distance_to_Bucharest = dict(
    Arad=366, Bucharest=0, Craiova=160,
    Drobeta=242, Eforie=161, Fagaras=178,
    Giurgiu=77, Hirsova=151, Iasi=266,
    Lugoj=244, Mehadia=241, Neamt=234,
    Oradea=380, Pitesti=98, Rimnicu=193,
    Sibiu=253, Timisoara=329, Urziceni=80,
    Vaslui=199, Zerind=374)

"""将通过每一个城市都可以找到它的邻居"""
all_city_neighbor = set(neighbor_map)

for i in neighbor_map:
    for a_city in neighbor_map[i]:
        if a_city not in all_city_neighbor:
            all_city_neighbor.add(a_city)

city_neighbor = {a: {} for a in all_city_neighbor}

for i in city_neighbor:
    if i in neighbormapWithweight:
        city_neighbor[i] = neighbormapWithweight[i]
for i in city_neighbor:
    for j in neighbormapWithweight:
        if i in neighbormapWithweight[j]:
            city_neighbor[i][j] = neighbormapWithweight[j][i]
print(city_neighbor)

start = "Arad"
goal = "Bucharest"

start_to_goal_distance = dict()
for i in romania_map_locations:
    """用曼哈顿距离"""
    # start_to_goal_distance[i] = abs(romania_map_locations[i][0] - romania_map_locations[goal][0]) \
    #                             + abs(romania_map_locations[i][1] - romania_map_locations[goal][1])
    """用A-B启发函数值"""
    # start_to_goal_distance[i] = straight_line_distance_to_Bucharest[i]
    """用直线距离"""
    start_to_goal_distance[i] = math.sqrt((romania_map_locations[i][0] - romania_map_locations[goal][0]) ** 2
                                          + (romania_map_locations[i][1] - romania_map_locations[goal][1]) ** 2)
print(start_to_goal_distance)

"""astar_search"""
def astar_search(problem):
    node_new = Node(problem.initial)  # 初始化node结点
    frontier = []  # frontier表的初始化
    frontier.append(node_new)  # 添加初始结点
    explored = []  # explored表初始化

    while True:
        # 当frontier表中没有结果时返回失败
        if len(frontier) == 0:
            return
        # 从frontier表中取出最优的结点拓展
        node_new = frontier[0]
        # 从frontier表中删除已经拓展的结点
        del frontier[0]
        # 若找到目标结点则对路径进行输出
        if problem.goal_test(node_new.state):
            print("最小的代价值为", node_new.path_cost)
            return node_new.solution()
        # 将已经搜索表拓展新的结点
        explored.append(node_new)
        # 搜索并拓展新的frontier表
        for p in city_neighbor[node_new.state]:
            child = Node(p, node_new, None, (city_neighbor[node_new.state][p] + node_new.path_cost))
            # 如果新的子结点不在explored和frontier中，则在frontier表中加入新的拓展结点
            figure = 0
            for i in explored or frontier:
                if i.state == child.state:
                    figure += 1
            if figure <= 0:
            # if child.state not in explored or frontier:
                frontier.append(Node(child.state, node_new, None, child.path_cost))
            # 如果新结点在frontier中，则更新其一致代价
            else:
                for i in frontier:
                    if i.state == child.state:
                        if i.path_cost < child.path_cost:
                            i.path_cost = child.path_cost
                            break
        # 对新加入的结点或者更新的结点进行排序
        frontier = sorted(frontier, key=lambda x: x.path_cost + start_to_goal_distance[x.state])



"""实现并输出A*搜索的路径"""
romania_problem = Problem(start, goal)
road = astar_search(romania_problem)
print(road)
