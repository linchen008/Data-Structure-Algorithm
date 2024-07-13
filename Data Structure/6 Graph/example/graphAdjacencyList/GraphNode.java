package org.example.graph.graphAdjacencyList;

import java.util.ArrayList;

/**
 * @author : Tommy
 * @version : 1.0
 * @createTime : 04/07/2024 11:43
 * @Description :
 */
public class GraphNode {
    public String name;
    public int index;
    public boolean isVisited = false;

    public ArrayList<GraphNode> neighbors = new ArrayList<>();

    public GraphNode(String name, int index) {
        this.name = name;
        this.index = index;
    }
}
