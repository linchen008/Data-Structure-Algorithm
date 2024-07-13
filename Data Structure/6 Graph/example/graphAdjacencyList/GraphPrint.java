package org.example.graph.graphAdjacencyList;

import java.util.ArrayList;

/**
 * @author : Tommy
 * @version : 1.0
 * @createTime : 04/07/2024 11:43
 * @Description :
 */
public class GraphPrint {
    ArrayList<GraphNode> nodeList = new ArrayList<>();

    public GraphPrint(ArrayList<GraphNode> nodeList) {
        this.nodeList = nodeList;
    }

    // For printing Graph to the console
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < nodeList.size(); i++) {
            s.append(nodeList.get(i).name + ": ");
            for (int j = 0; j < nodeList.get(i).neighbors.size(); j++) {
                if (j == nodeList.get(i).neighbors.size() - 1) {
                    s.append((nodeList.get(i).neighbors.get(j).name));
                } else {
                    s.append((nodeList.get(i).neighbors.get(j).name) + " -> ");
                }
            }
            s.append("\n");
        }
        return s.toString();
    }

}
