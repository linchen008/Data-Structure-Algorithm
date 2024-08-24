package org.example.graph.graphAdjacencyMatrix;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author : Tommy
 * @version : 1.0
 * @createTime : 04/07/2024 13:53
 * @Description :
 */
public class Graph {
    ArrayList<GraphNode> nodeList = new ArrayList<>();
    int [][] adjacencyMatrix;

    public Graph(ArrayList<GraphNode> nodeList) {
        this.nodeList = nodeList;
        adjacencyMatrix = new int[nodeList.size()][nodeList.size()];
    }

    public void addUndirectedEdge(GraphNode source, GraphNode target) {
        adjacencyMatrix[source.index][target.index] = 1;
        adjacencyMatrix[target.index][source.index] = 1;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("   ");
        for (int i = 0; i < nodeList.size(); i++) {
            s.append(nodeList.get(i).name + " ");
        }
        s.append("\n");
        for (int i = 0; i < nodeList.size(); i++) {
            s.append(nodeList.get(i).name + ": ");
            for (int j : adjacencyMatrix[i]) {
                s.append((j) + " ");
            }
            s.append("\n");
        }
        return s.toString();
    }

//    //get Neighbors
//    public ArrayList<GraphNode> getNeighbors(GraphNode node) {
//        ArrayList<GraphNode> neighbors = new ArrayList<>();
//        int nodeIndex = node.index;
//        for(int i =0; i < adjacencyMatrix.length; i++) {
//            if(adjacencyMatrix[nodeIndex][i] == 1) {
//                neighbors.add(nodeList.get(i));
//            }
//        }
//        return neighbors;
//    }

    //BFS
    void bfsVisit(GraphNode node) {
        LinkedList<GraphNode> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()) {
            GraphNode current = queue.remove();
            current.isVisited = true;
            System.out.println(current.name + " ");
            ArrayList<GraphNode> neighbors = getNeighbors(current);
            for(GraphNode neighbor : neighbors) {
                if(!neighbor.isVisited) {
                    queue.add(neighbor);
                    neighbor.isVisited = true;
                }
            }
        }
    }

    void bfs(){
        for(GraphNode node : nodeList) {
            if(!node.isVisited) {
                bfsVisit(node);
            }
        }
    }

    //get Neighbors
    public ArrayList<GraphNode> getNeighbors(GraphNode node) {
        ArrayList<GraphNode> neighbors = new ArrayList<>();
        int nodeIndex = node.index;
        for(int i =0; i < adjacencyMatrix.length; i++) {
            if(adjacencyMatrix[nodeIndex][i] == 1) {
                neighbors.add(nodeList.get(i));
            }
        }
        return neighbors;
    }

    //DFS
    void dfsVisit(GraphNode node) {
        Stack<GraphNode> stack = new Stack<>();
        stack.push(node);
        while(!stack.isEmpty()) {
            GraphNode current = stack.pop();
            current.isVisited = true;
            System.out.println(current.name + " ");
            //get neighbors
            ArrayList<GraphNode> neighbors = getNeighbors(current);
            for(GraphNode neighbor : neighbors) {
                if(!neighbor.isVisited) {
                    stack.push(neighbor);
                    neighbor.isVisited = true;
                }
            }
        }
    }

    void dfs(){
        for(GraphNode node : nodeList) {
            if(!node.isVisited) {
                dfsVisit(node);
            }
        }
    }
}
