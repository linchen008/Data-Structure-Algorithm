package org.example.graph.graphAdjacencyList;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author : Tommy
 * @version : 1.0
 * @createTime : 13/07/2024 11:13
 * @Description :
 */
public class GraphDFS {
    ArrayList<GraphNode> nodeList = new ArrayList<>();

    public GraphDFS(ArrayList<GraphNode> nodeList) {
        this.nodeList = nodeList;
    }

    //dept-first traversal helper function
    void dfsVisit(GraphNode node) {
        Stack<GraphNode> stack = new Stack<GraphNode>();
        stack.push(node);
        while (!stack.isEmpty()) {
            GraphNode current = stack.pop();
            System.out.print(current.name + " ");
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
}
