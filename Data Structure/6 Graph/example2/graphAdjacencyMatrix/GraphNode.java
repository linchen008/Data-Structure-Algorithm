package org.example.graph.graphAdjacencyMatrix;

/**
 * @author : Tommy
 * @version : 1.0
 * @createTime : 04/07/2024 13:53
 * @Description :
 */
public class GraphNode {
    public String name;
    public int index;
    public boolean isVisited = false;

    public GraphNode(String name, int index) {
        this.name = name;
        this.index = index;
    }
}
