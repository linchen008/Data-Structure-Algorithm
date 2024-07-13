package org.example.graph.graphAdjacencyList.topologicalSorting;

import java.util.Map;
import java.util.Queue;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ArrayDeque;

/**
 * @author : Tommy
 * @version : 1.0
 * @createTime : 12/07/2024 21:08
 * @Description :
 */
public class TopologicalSortKahn1 {

    /**
     * Performs topological sorting on a directed graph represented as a map from nodes to their adjacent nodes.
     * This method implements a version of Kahn's algorithm to ensure that for any directed edge from node U to node V,
     * U comes before V in the returned ordering. It's particularly useful for scheduling tasks, ensuring prerequisites
     * are handled before dependent tasks.
     *
     * @param digraph A map where each key is a node (String) and its value is an array of adjacent nodes (String[]),
     *                representing the directed edges in the graph.
     * @return An array of nodes (String[]) representing the topological ordering of the nodes in the graph.
     * @throws IllegalArgumentException if the graph contains a cycle, indicating that no valid topological ordering exists.
     *
     * The method first constructs a map to track the indegree of each node (i.e., the number of edges coming into a node).
     * It initializes this map with all nodes having an indegree of 0. It then iterates over the graph to update the indegrees
     * based on the adjacency information in the digraph parameter.
     *
     * After calculating indegrees, the method identifies nodes with no incoming edges and processes them sequentially.
     * Processing a node involves adding it to the topological ordering and reducing the indegree of its neighbors.
     * If a neighbor's indegree drops to 0, it's added to the queue of nodes to be processed.
     *
     * This process repeats until there are no more nodes with an indegree of 0. If the size of the topological ordering
     * matches the number of nodes in the graph, a valid topological ordering has been found. Otherwise, the graph contains
     * a cycle, and an IllegalArgumentException is thrown.
     */
    private static String[] topologicalSort(Map<String, String[]> digraph) {
        // digraph is a map:
        // key: a node
        // value: an array of adjacent neighboring nodes

        // construct a hash mapping nodes to their indegrees
        Map<String, Integer> indegrees = new HashMap<>();
        for (String node : digraph.keySet()) {
            // initialize all nodes with an indegree of 0
            indegrees.put(node, 0);
        }

        for (Map.Entry<String, String[]> entry : digraph.entrySet()) {
            String node = entry.getKey();
            for (String neighbor : entry.getValue()) {
                indegrees.put(neighbor, indegrees.get(neighbor) + 1);
            }
        }

        // track nodes with no incoming edges
        Queue<String> nodesWithNoIncomingEdges = new ArrayDeque<>();
        for(Map.Entry<String, Integer> entry : indegrees.entrySet()) {
            if (entry.getValue() == 0) {
                nodesWithNoIncomingEdges.add(entry.getKey());
            }
        }

        // initially, no nodes in our ordering
        List<String> topologicalOrdering = new ArrayList<>();

        // as long as there are nodes with no incoming edges that can be
        // added to the ordering
        while (nodesWithNoIncomingEdges.size() > 0) {

            // add one of those nodes to the ordering
            String node = nodesWithNoIncomingEdges.poll();
            topologicalOrdering.add(node);

            // decremenet the indegree of that node's neighbors
            for (String neighbor : digraph.get(node)) {
                indegrees.put(neighbor, indegrees.get(neighbor) - 1);
                if (indegrees.get(neighbor) == 0) {
                    nodesWithNoIncomingEdges.add(neighbor);
                }
            }
        }

        // we've run out of nodes with no incoming edges
        // did we add all the nodes or find a cycle?
        if (topologicalOrdering.size() != digraph.size()) {
            throw new IllegalArgumentException("Graph has a cycle! No topological ordering exists.");
        }

        return topologicalOrdering.toArray(new String[topologicalOrdering.size()]);
    }
}
