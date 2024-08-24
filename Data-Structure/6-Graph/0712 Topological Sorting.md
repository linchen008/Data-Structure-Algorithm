Two important methods to solve are:

- Kahn’s Algorithm
- Depth-First Search (DFS) Algorithm

# Kahn’s algorithm for Topological Sorting

[Kahn’s algorithm](https://www.geeksforgeeks.org/topological-sorting-indegree-based-solution/)

> \***\*Kahn’s Algorithm\*\*** for Topological Sorting is a method used to order the vertices of a directed graph in a linear order such that for every directed edge from vertex \***\*A\*\*** to vertex \***\*B\*\***, \***\*A\*\*** comes before \***\*B\*\*** in the order. The algorithm works by **repeatedly finding vertices with no incoming edges, removing them from the graph, and updating the incoming edges of the remaining vertices**. This process continues until all vertices have been ordered.

## Algorithm

- Add all nodes with in-degree **0** to a queue.
- While the queue is not empty:
  - Remove a node from the queue.
  - For each outgoing edge from the removed node, decrement the in-degree of the destination node by **1**.
  - If the in-degree of a destination node becomes **0** , add it to the queue.
- If the queue is empty and there are still nodes in the graph, the graph contains a cycle and cannot be topologically sorted.
- The nodes in the queue represent the topological ordering of the graph.

### \***\*How to find the in-degree of each node?\*\*** 

> To find the \***\*in-degree\*\*** of each node by initially calculating the number of incoming edges to each node. Iterate through all the edges in the graph and \***\*increment\*\*** the \***\*in-degree\*\*** of the \***\*destination\*\*** \***\*node\*\*** for each edge. This way, you can determine the in-degree of each node before starting the sorting process.

## Example

![[assets/Diagram 2.svg]]
## Pseudo Code
1. **Initialize**:
	- Calculate in-degrees of all vertices.
	- Create a queue to store all vertices with in-degree 0.
2. **Process Vertices**:
    - Dequeue a vertex and add it to the topological order.
    - Reduce the in-degree of all adjacent vertices by 1.
    - If an adjacent vertex’s in-degree becomes 0, enqueue it.
3. **Continue until the queue is empty**.

```pseudo
1. Calculate in-degrees of all vertices and store them in an array `arrayInDegree`.
2. Create a queue `Q` and enqueue all vertices with in-degree 0.

3. Initialize a list `topological_order` to store the result.

4. While `Q` is not empty:
   a. Dequeue a vertex `v` from `Q`.
   b. Add `v` to `topological_order`.
   c. For each adjacent vertex `u` of `v`:
      i. Reduce the in-degree of `u` by 1.
      ii. If `u`'s in-degree becomes 0, enqueue `u`.

5. If the number of vertices in `topological_order` is less than the number of vertices in the graph, the graph has a cycle (and thus no topological ordering).

6. The `topological_order` list now contains the vertices in topologically sorted order.
```
## Implementation

```Java
class Solution {
	public void topo_sort(List<Integer>[] adj, int n)
	{
		List<Integer> indegree
			= new ArrayList<>(Collections.nCopies(n, 0));

		for (int i = 0; i < n; i++) {
			for (int it : adj[i]) {
				indegree.set(it, indegree.get(it) + 1);
			}
		}

		List<Integer> ans = new ArrayList<>();
		Queue<Integer> qrr = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			if (indegree.get(i) == 0) {
				qrr.add(i);
			}
		}

		while (!qrr.isEmpty()) {
			int node = qrr.poll();
			ans.add(node);

			for (int it : adj[node]) {
				indegree.set(it, indegree.get(it) - 1);

				if (indegree.get(it) == 0) {
					qrr.add(it);
				}
			}
		}

		for (int i = 0; i < n; i++) {
			System.out.print(ans.get(i) + " ");
		}
	}
}
class Main {

	@SuppressWarnings("unchecked")
	public static void main(String[] args)
	{
		int n = 6;
		List<Integer>[] adj = new ArrayList[n];

		for (int i = 0; i < n; i++) {
			adj[i] = new ArrayList<>();
		}

		addEdge(adj, 5, 0);
		addEdge(adj, 5, 2);
		addEdge(adj, 2, 0);
		addEdge(adj, 2, 3);
		addEdge(adj, 3, 0);
		addEdge(adj, 3, 1);
		addEdge(adj, 1, 0);
		addEdge(adj, 4, 0);
		addEdge(adj, 4, 1);

		Solution s1 = new Solution();
		s1.topo_sort(adj, n);
	}
	private static void addEdge(List<Integer>[] adj, int u,
								int v)
	{
		adj[u].add(v);
	}
}
```

## Complexity Analysis

- \***\*Time Complexity:\*\*** O(V+E).   
   The outer for loop will be executed V number of times and the inner for loop will be executed E number of times.
- \***\*Auxiliary Space:\*\*** O(V).   
   The queue needs to store all the vertices of the graph. So the space required is O(V

# DFS Approach

> DFS Approach is a recursive algorithm that performs a depth-first search on the DAG. It starts at a vertex, explores as far as possible along each branch before backtracking, and marks visited vertices. During the DFS traversal, vertices are added to a `stack` in the order they are visited. Once the DFS traversal is complete, the stack is reversed to obtain the topological ordering.

## Example

![[Pasted image 20240712225658.png|1200]]

## Steps

![[Pasted image 20240712225714.png]]
![[Pasted image 20240712225734.png]]
![[Pasted image 20240712225759.png]]
![[Pasted image 20240712225805.png]]
![[Pasted image 20240712225813.png]] \***\*Step 6:\*\*** This is the final step of the Topological sorting in which we pop all the element from the stack and print it in that order .

## Pseudo Code

1. **Initialize**:
   - Create an empty stack `S` to store the topological order.
   - Mark all the vertices as not visited (use a visited array).
2. **DFS Visit**:
   - Traverse the graph using DFS.
   - On visiting a vertex, mark it as visited.
   - Recursively visit all its adjacent vertices.
   - After visiting all the adjacent vertices, push the current vertex onto the stack.
3. **Extract Order**:
   - Pop vertices from the stack to get the topological order.

## Pseudo Code

```pseudo
1. Create a stack `S` to store the topological order.
2. Create a visited array `visited` and initialize all vertices as not visited.

3. Define a recursive function `DFS(v)`:
   a. Mark `v` as visited.
   b. For each adjacent vertex `u` of `v`:
      i. If `u` is not visited, call `DFS(u)`.
   c. Push `v` onto stack `S`.

4. For each vertex `v` in the graph:
   a. If `v` is not visited, call `DFS(v)`.

5. While stack `S` is not empty:
   a. Pop vertex from `S` and add it to the topological order.

6. The resulting topological order is the reverse of the finishing times of vertices.
```

## Implementation

```Java
/*
1. Create a stack `S` to store the topological order.
2. Create a visited array `visited` and initialize all vertices as not visited.
3. Define a recursive function `DFS(v)`:
	1. a. Mark `v` as visited.
	2. b. For each adjacent vertex `u` of `v`:
	3. i. If `u` is not visited, call `DFS(u)`.
	4. c. Push `v` onto stack `S`.
5. For each vertex `v` in the graph:
	1. a. If `v` is not visited, call `DFS(v)`.
2. While stack `S` is not empty:
3. a. Pop vertex from `S` and add it to the topological order.
4. The resulting topological order is the reverse of the finishing times of vertices.*/
public class TopologicalSort1 {
    //function to perform DFS and topological sort
    static void topologicalSortUtil(int v,
                                    List<List<Integer>> adj,
                                    boolean[] visited,
                                    Stack<Integer> stack) {
        //mark the current node as visited
        visited[v] = true;

        //recur for all the vertices adjacent to this vertex
        for (int i : adj.get(v)) {
            if (!visited[i]) {
                topologicalSortUtil(i, adj, visited, stack);
            }
        }
        //push current vertex to stack which stores the result
        stack.push(v);
    }

    //Function to perform topological sort
    static void topologicalSort(List<List<Integer>> adj,
                                int v) {
        //Stack to store the topological order
        Stack<Integer> stack = new Stack<>();
        // Mark all the vertices as not visited
        boolean[] visited = new boolean[v];
        //call the recursive helper function to store
        //Topological Sort starting from all vertices one by one        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                topologicalSortUtil(i, adj, visited, stack);
            }
        }
        //Print contents of stack
        System.out.print(
                "Topological sorting of the graph: ");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    //drive code
    public static void main(String[] args) {
        //number of vertices
        int v = 4;

        //edges of the graph: "undirected graph"
        List<List<Integer>> edges = new ArrayList<>();
        edges.add(Arrays.asList(0, 1));
        edges.add(Arrays.asList(1, 2));
        edges.add(Arrays.asList(3, 1));
        edges.add(Arrays.asList(3, 2));
        //[[0,1], [1,2], [3,1], [3,2]]

        //Graph represented as an directed adjacency list        List<List<Integer>> adj = new ArrayList<>(v);
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
        //v=4 adj= [[ ], [ ], [ ], [ ]]

//        for(List<Integer> i: edges){
//            adj.get(i.get(0)).add(i.get(1));
//        }
        // 0 [[1],        // 1 [2],        // 2 [],        // 3 [1, 2]]
        /*
For the edge (0,1), it adds 1 to the sublist at index 0: adj.get(0).add(1), resulting in adj becoming [[1], [], [], []].
For the edge (1,2), it adds 2 to the sublist at index 1: adj.get(1).add(2), resulting in adj becoming [[1], [2], [], []].
For the edge (3,1), it adds 1 to the sublist at index 3: adj.get(3).add(1), resulting in adj becoming [[1], [2], [], [1]].
For the edge (3,2), it adds 2 to the sublist at index 3: adj.get(3).add(2), resulting in adj becoming [[1], [2], [], [1, 2]].
         */        edges.forEach(edge -> {
            adj.get(edge.get(0)).add(edge.get(1));
        });

        //print the adjacency list
        System.out.println(adj);

        topologicalSort(adj, v);
     }
}
```
