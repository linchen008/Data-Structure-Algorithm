package org.example.graph.graphAdjacencyList;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author : Tommy
 * @version : 1.0
 * @createTime : 13/07/2024 11:14
 * @Description :
 */
public class GraphBFS {

    ArrayList<GraphNode> nodeList = new ArrayList<>();

    public GraphBFS(ArrayList<GraphNode> nodeList) {
        this.nodeList = nodeList;
    }

    //BFS
    void bfsVisit(GraphNode node) {
        LinkedList<GraphNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            GraphNode current = queue.remove();
            current.isVisited = true;
            System.out.print(current.name + " ");
            for (GraphNode neighbor : current.neighbors) {
                if (!neighbor.isVisited) {
                    queue.add(neighbor);
                    neighbor.isVisited = true;
                }
            }
        }
    }

    void bfs() {
        for (GraphNode node : nodeList) {
            if (!node.isVisited) {
                bfsVisit(node);
            }
        }
    }
}
