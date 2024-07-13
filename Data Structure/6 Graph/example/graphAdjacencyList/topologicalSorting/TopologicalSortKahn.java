package org.example.graph.graphAdjacencyList.topologicalSorting;

import java.util.*;

/**
 * @author : Tommy
 * @version : 1.0
 * @createTime : 13/07/2024 18:55
 * @Description :
 */
/*
1. Calculate in-degrees of all vertices and store them in an array `arrayInDegree`.
2. Create a queue `Q` and enqueue all vertices with in-degree 0.
3. Initialize a list `topological_order` to store the result.
4. While `Q` is not empty:
   a. Dequeue a vertex `v` from `Q`.
   b. Add `v` to `topological_order`.
   c. For each adjacent vertex `u` of `v`:
      i. Reduce the in-degree of `u` by 1.
      ii. If `u`'s in-degree becomes 0, enqueue `u`.
5. If the number of vertices in `topological_order` is less than the number of vertices in the graph,
    the graph has a cycle (and thus no topological ordering).
6. The `topological_order` list now contains the vertices in topologically sorted order.
 */
public class TopologicalSortKahn {

    /**
     * Performs a topological sort on a directed graph using Kahn's algorithm.
     *
     * @param adj The adjacency list of the graph where each index represents a vertex
     *            and each element is a list of vertices that the vertex points to.
     * @param n   The number of vertices in the graph.
     *
     * The method initializes an indegree list to keep track of the number of incoming
     * edges for each vertex. It then iterates over the adjacency list to populate this
     * indegree list. Vertices with no incoming edges (indegree of 0) are added to a queue.
     *
     * The method proceeds to remove vertices from the queue one by one, adding them to the
     * topological order result list. For each removed vertex, it decreases the indegree of
     * its adjacent vertices. If any adjacent vertex's indegree becomes 0, it is added to the queue.
     *
     * This process repeats until the queue is empty. If the topological order list contains all
     * vertices, a topological ordering exists; otherwise, the graph has a cycle and no topological
     * ordering is possible.
     *
     * The topological order is then printed to the console.
     */
    public void topo_sort(List<Integer>[] adj, int n) {
        // Initialize indegree list with zeros for all vertices
        List<Integer> indegree = new ArrayList<>(Collections.nCopies(n, 0));
        // Calculate indegrees by iterating over each vertex's adjacency list
        for (int i = 0; i < n; i++) {
            for (int it : adj[i]) {
                indegree.set(it, indegree.get(it) + 1);
            }
        }
        // List to store the topological order
        List<Integer> ans = new ArrayList<>();
        // Queue to store vertices with no incoming edges
        Queue<Integer> qrr = new LinkedList<>();
        // Add vertices with no incoming edges to the queue
        for (int i = 0; i < n; i++) {
            if (indegree.get(i) == 0) {
                qrr.add(i);
            }
        }
        // Process vertices in the queue until the queue is empty
        while (!qrr.isEmpty()) {
            int node = qrr.poll(); // Dequeue a vertex
            ans.add(node); // Add the vertex to the topological order
            // Decrease the indegree of adjacent vertices
            for (int it : adj[node]) { // Process adjacent vertices
                indegree.set(it, indegree.get(it) - 1);
                // If the indegree of an adjacent vertex becomes 0, add it to the queue
                if (indegree.get(it) == 0) {
                    qrr.add(it);
                }
            }
        }
        // If the topological order list contains all vertices, print the topological order
        for (int i = 0; i < n; i++) {
            System.out.print(ans.get(i) + " ");
        }
    }

}
