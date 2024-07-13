[Hello Algo: Graph Traversal](https://www.hello-algo.com/en/chapter_graph/graph_traversal/)
Trees represent a "one-to-many" relationship, while graphs have a higher degree of freedom and can represent any "many-to-many" relationship. Therefore, we can consider trees as a special case of graphs. Clearly, **tree traversal operations are also a special case of graph traversal operations**.

Both graphs and trees require the application of search algorithms to implement traversal operations. Graph traversal can be divided into two types: **Breadth-First Search (BFS)** and **Depth-First Search (DFS)**.

## 1 Breadth-first search
**Breadth-first search is a near-to-far traversal method, starting from a certain node, always prioritizing the visit to the nearest vertices and expanding outwards layer by layer**. As shown in Figure 9-9, starting from the top left vertex, first traverse all adjacent vertices of that vertex, then traverse all adjacent vertices of the next vertex, and so on, until all vertices have been visited.
![[Pasted image 20240703150646.png|800]]
### Algorithm implementation
BFS is usually implemented with the help of a queue, as shown in the code below. The queue has a "first in, first out" property, which aligns with the BFS idea of traversing "from near to far".

1. Add the starting vertex `startVet` to the queue and start the loop.
2. In each iteration of the loop, pop the vertex at the front of the queue and record it as visited, then add all adjacent vertices of that vertex to the back of the queue.
3. Repeat step `2.` until all vertices have been visited.

To prevent revisiting vertices, we use a hash set `visited` to record which nodes have been visited.

```
enqueue any starting vertex
 while queue is not empty

   p = dequeue()
   if p is unvisited

     mark it visited
     enqueue all adjacent
     unvisited vertices of p
```
#### 1.1 Queue - Adjacency List
```Java
public class GraphNode {  
    public String name;  
    public int index;  
    public boolean isVisited = false;  
  
    public ArrayList<GraphNode> neighbors = new ArrayList<GraphNode>();  
  
    public GraphNode(String name, int index) {  
        this.name = name;  
        this.index = index;  
    }  
}
//BFS
void bfsVisit(GraphNode node) {  
    LinkedList<GraphNode> queue = new LinkedList<>();  
    queue.add(node);  
    while (!queue.isEmpty()) {  
        GraphNode current = queue.remove();  
        current.isVisited = true;  
        System.out.print(current.name+" ");  
        for (GraphNode neighbor : current.neighbors) {  
            if (!neighbor.isVisited) {  
                queue.add(neighbor);  
                neighbor.isVisited = true;  
            }  
        }  
    }  
}  
  
void bfs(){  
    for (GraphNode node : nodeList) {  
        if (!node.isVisited) {  
            bfsVisit(node);  
        }  
    }  
}
```

#### 1.2 Queue - Adjacency Matrix
```Java
public class GraphNode {  
    public String name;  
    public int index;  
    public boolean isVisited = false;  
    public GraphNode(String name, int index) {  
        this.name = name;  
        this.index = index;  
    }  
}
//get Neighbors  
public ArrayList<GraphNode> getNeighbors(GraphNode node) {  
    ArrayList<GraphNode> neighbors = new ArrayList<>();  
    int nodeIndex = node.index;  
    for(int i =0; i < adjacencyMatrix.length; i++) {  
        if(adjacencyMatrix[nodeIndex][i] == 1) {  
            neighbors.add(nodeList.get(i));  
        }  
    }  
    return neighbors;  
}  
//BFS  
void bfsVisit(GraphNode node) {  
    LinkedList<GraphNode> queue = new LinkedList<>();  
    queue.add(node);  
    while(!queue.isEmpty()) {  
        GraphNode current = queue.remove();  
        current.isVisited = true;  
        System.out.println(current.name + " ");  
        //get neighbors
        ArrayList<GraphNode> neighbors = getNeighbors(current);  
        for(GraphNode neighbor : neighbors) {  
            if(!neighbor.isVisited) {  
                queue.add(neighbor);  
                neighbor.isVisited = true;  
            }  
        }  
    }  
}  
  
void bfs(){  
    for(GraphNode node : nodeList) {  
        if(!node.isVisited) {  
            bfsVisit(node);  
        }  
    }  
}
```

### Complexity analysis
**Time complexity**: All vertices will be enqueued and dequeued once, using 𝑂(|𝑉|) time; in the process of traversing adjacent vertices, since it is an undirected graph, all edges will be visited 2 times, using 𝑂(2|𝐸|) time; overall using 𝑂(|𝑉|+|𝐸|) time.

**Space complexity**: The maximum number of vertices in list `res`, hash set `visited`, and queue `que` is |𝑉|, using 𝑂(|𝑉|) space.

## 2 Depth-first search
**Depth-first search is a traversal method that prioritizes going as far as possible and then backtracks when no further paths are available**. As shown in Figure 9-11, starting from the top left vertex, visit some adjacent vertex of the current vertex until no further path is available, then return and continue until all vertices are traversed.
![[Pasted image 20240704133339.png|1000]]
### Algorithm implementation
This "go as far as possible and then return" algorithm paradigm is usually implemented based on recursion. Similar to breadth-first search, in depth-first search, we also need the help of a hash set `visited` to record the visited vertices to avoid revisiting.
```
push any starting vertex
 while stack is not empty

  p = pop()
  if p is unvisited
     mark it visited
     Push all adjacent
     unvisited vertices of p
```
#### 2.1 Stack - Adjacency List
```Java
public class GraphNode {  
    public String name;  
    public int index;  
    public boolean isVisited = false;  
  
    public ArrayList<GraphNode> neighbors = new ArrayList<GraphNode>();  
  
    public GraphNode(String name, int index) {  
        this.name = name;  
        this.index = index;  
    }  
}
//dept-first traversal for Adjacency List
void dfsVisit(GraphNode node) {  
    Stack<GraphNode> stack = new Stack<GraphNode>();  
    stack.push(node);  
    while (!stack.isEmpty()) {  
        GraphNode current = stack.pop();  
        System.out.print(current.name+" ");  
        for (GraphNode neighbor : current.neighbors) {  
            if (!neighbor.isVisited) {  
                stack.push(neighbor);  
                neighbor.isVisited = true;  
            }  
        }  
    }  
}  
  
//void dfs  
void dfs() {  
    for (GraphNode node : nodeList) {  
        if (!node.isVisited) {  
            dfsVisit(node);  
        }  
    }  
}
```

#### 2.2 Stack - Adjacency Matrix
```Java
public class GraphNode {  
    public String name;  
    public int index;  
    public boolean isVisited = false;  
    public GraphNode(String name, int index) {  
        this.name = name;  
        this.index = index;  
    }  
}
//get Neighbors  
public ArrayList<GraphNode> getNeighbors(GraphNode node) {  
    ArrayList<GraphNode> neighbors = new ArrayList<>();  
    int nodeIndex = node.index;  
    for(int i =0; i < adjacencyMatrix.length; i++) {  
        if(adjacencyMatrix[nodeIndex][i] == 1) {  
            neighbors.add(nodeList.get(i));  
        }  
    }  
    return neighbors;  
}  
  
//DFS  
void dfsVisit(GraphNode node) {  
    Stack<GraphNode> stack = new Stack<>();  
    stack.push(node);  
    while(!stack.isEmpty()) {  
        GraphNode current = stack.pop();  
        current.isVisited = true;  
        System.out.println(current.name + " "); 
        //get neighbors
        ArrayList<GraphNode> neighbors = getNeighbors(current);  
        for(GraphNode neighbor : neighbors) {  
            if(!neighbor.isVisited) {  
                stack.push(neighbor);  
                neighbor.isVisited = true;  
            }  
        }  
    }  
}  
  
void dfs(){  
    for(GraphNode node : nodeList) {  
        if(!node.isVisited) {  
            dfsVisit(node);  
        }  
    }
}
```

### Complexity analysis
**Time complexity**: All vertices will be visited once, using 𝑂(|𝑉|) time; all edges will be visited twice, using 𝑂(2|𝐸|) time; overall using 𝑂(|𝑉|+|𝐸|) time.

**Space complexity**: The maximum number of vertices in list `res`, hash set `visited` is |𝑉|, and the maximum recursion depth is |𝑉|, therefore using 𝑂(|𝑉|) space.
