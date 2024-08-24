package org.example.graph;

/**
 * @author : Tommy
 * @version : 1.0
 * @createTime : 03/07/2024 10:49
 * @Description :
 */
public class Graph2DArray {
    private int[][] adjacencyMatrix;
    private int numberOfVertices;

    //Constructor to initialize the graph with the specified number of vertices
    public Graph2DArray(int numberOfVertices) {
        this.numberOfVertices = numberOfVertices;
        adjacencyMatrix = new int[numberOfVertices][numberOfVertices];
    }

    //method to add an edge to the graph
    public void addEdge(int source, int destination) {
        adjacencyMatrix[source][destination] = 1;
        adjacencyMatrix[destination][source] = 1; //for undirected graph
    }

    //method to check if there is an edge between two vertices
    public boolean hasEdge(int source, int destination) {
        return adjacencyMatrix[source][destination] == 1;
    }
}
