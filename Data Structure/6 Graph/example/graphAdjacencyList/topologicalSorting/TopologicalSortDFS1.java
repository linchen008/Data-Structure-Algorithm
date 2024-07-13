package org.example.graph.graphAdjacencyList.topologicalSorting;

import java.util.*;

/**
 * @author : Tommy
 * @version : 1.0
 * @createTime : 13/07/2024 14:48
 * @Description :
 */

/*
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
     */
public class TopologicalSortDFS1 {
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
        //Topological Sort starting from all vertices one by one
        for (int i = 0; i < v; i++) {
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

        //Graph represented as an directed adjacency list
        List<List<Integer>> adj = new ArrayList<>(v);
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
        //v=4 adj= [[ ], [ ], [ ], [ ]]

//        for(List<Integer> i: edges){
//            adj.get(i.get(0)).add(i.get(1));
//        }
        // 0 [[1],
        // 1 [2],
        // 2 [],
        // 3 [1, 2]]

        /*
For the edge (0,1), it adds 1 to the sublist at index 0: adj.get(0).add(1), resulting in adj becoming [[1], [], [], []].
For the edge (1,2), it adds 2 to the sublist at index 1: adj.get(1).add(2), resulting in adj becoming [[1], [2], [], []].
For the edge (3,1), it adds 1 to the sublist at index 3: adj.get(3).add(1), resulting in adj becoming [[1], [2], [], [1]].
For the edge (3,2), it adds 2 to the sublist at index 3: adj.get(3).add(2), resulting in adj becoming [[1], [2], [], [1, 2]].
         */
        edges.forEach(edge -> {
            adj.get(edge.get(0)).add(edge.get(1));
        });

        //print the adjacency list
        System.out.println(adj);

        topologicalSort(adj, v);
     }
}
