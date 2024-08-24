package org.example.graph.graphAdjacencyList.topologicalSorting;

import org.example.graph.graphAdjacencyList.GraphNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author : Tommy
 * @version : 1.0
 * @createTime : 13/07/2024 11:18
 * @Description :
 */
public class TopologicalSortDFS {

    ArrayList<GraphNode> nodeList = new ArrayList<>();

    public TopologicalSortDFS(ArrayList<GraphNode> nodeList) {
        this.nodeList = nodeList;
    }

    // add an undirected edge between two nodes
    public void addUndirectedEdge(int i, int j) {
        GraphNode first = nodeList.get(i);
        GraphNode second = nodeList.get(j);
        first.neighbors.add(second);
        second.neighbors.add(first);
    }

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
    // Topological Sort
    void topologicalVisit(GraphNode node, Stack<GraphNode> stack) {
//        for (GraphNode neighbor : node.neighbors) {
//            if(!neighbor.isVisited){
//                topologicalVisit(neighbor, stack);
//            }
//            neighbor.isVisited = true;
//            stack.push(node);
//        }
        node.neighbors.forEach(neighbor -> {
            if (!neighbor.isVisited) {
                topologicalVisit(neighbor, stack);
            }
            neighbor.isVisited = true;
            stack.push(node);
        });
    }

    void topologicalSort(){
        Stack<GraphNode> stack = new Stack<>();
        for(GraphNode node : nodeList){
            if(!node.isVisited){
                topologicalVisit(node, stack);
            }
        }
        while (!stack.isEmpty()){
            System.out.print(stack.pop().name + " ");
        }
    }
}
