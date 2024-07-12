Two important methods to solve are:
- Kahn’s Algorithm
- Depth-First Search (DFS) Algorithm

# Kahn’s algorithm for Topological Sorting
[Kahn’s algorithm](https://www.geeksforgeeks.org/topological-sorting-indegree-based-solution/)
> ****Kahn’s Algorithm**** for Topological Sorting is a method used to order the vertices of a directed graph in a linear order such that for every directed edge from vertex ****A**** to vertex ****B****, ****A**** comes before ****B**** in the order. The algorithm works by **repeatedly finding vertices with no incoming edges, removing them from the graph, and updating the incoming edges of the remaining vertices**. This process continues until all vertices have been ordered.
## Algorithm
- Add all nodes with in-degree **0** to a queue.
- While the queue is not empty:
    - Remove a node from the queue.
    - For each outgoing edge from the removed node, decrement the in-degree of the destination node by **1**.
    - If the in-degree of a destination node becomes **0** , add it to the queue.
- If the queue is empty and there are still nodes in the graph, the graph contains a cycle and cannot be topologically sorted.
- The nodes in the queue represent the topological ordering of the graph.
### ****How to find the in-degree of each node?**** 
> To find the ****in-degree**** of each node by initially calculating the number of incoming edges to each node. Iterate through all the edges in the graph and ****increment**** the ****in-degree**** of the ****destination**** ****node**** for each edge. This way, you can determine the in-degree of each node before starting the sorting process.
## Example
![[assets/Diagram 2.svg]]
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
- ****Time Complexity:**** O(V+E).   
    The outer for loop will be executed V number of times and the inner for loop will be executed E number of times.
- ****Auxiliary Space:**** O(V).   
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
![[Pasted image 20240712225813.png]]
****Step 6:**** This is the final step of the Topological sorting in which we pop all the element from the stack and print it in that order .
## Implementation
```Java
public class TopologicalSort {
    // Function to perform DFS and topological sorting
    static void
    topologicalSortUtil(int v, List<List<Integer> > adj,
                        boolean[] visited,
                        Stack<Integer> stack)
    {
        // Mark the current node as visited
        visited[v] = true;
        // Recur for all adjacent vertices
        for (int i : adj.get(v)) {
            if (!visited[i])
                topologicalSortUtil(i, adj, visited, stack);
        }
        // Push current vertex to stack which stores the
        // result
        stack.push(v);
    }
    // Function to perform Topological Sort
    static void topologicalSort(List<List<Integer> > adj,
                                int V)
    {
        // Stack to store the result
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];
        // Call the recursive helper function to store
        // Topological Sort starting from all vertices one
        // by one
        for (int i = 0; i < V; i++) {
            if (!visited[i])
                topologicalSortUtil(i, adj, visited, stack);
        }
        // Print contents of stack
        System.out.print(
            "Topological sorting of the graph: ");
        while (!stack.empty()) {
            System.out.print(stack.pop() + " ");
        }
    }
    // Driver code
    public static void main(String[] args)
    {
        // Number of nodes
        int V = 4;

        // Edges
        List<List<Integer> > edges = new ArrayList<>();
        edges.add(Arrays.asList(0, 1));
        edges.add(Arrays.asList(1, 2));
        edges.add(Arrays.asList(3, 1));
        edges.add(Arrays.asList(3, 2));
        // Graph represented as an adjacency list
        List<List<Integer> > adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (List<Integer> i : edges) {
            adj.get(i.get(0)).add(i.get(1));
        }
        topologicalSort(adj, V);
    }
}
```
