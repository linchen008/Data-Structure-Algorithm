package org.example.graph;

import java.util.List;
import java.util.ArrayList;

/**
 * @author : Tommy
 * @version : 1.0
 * @createTime : 01/07/2024 13:29
 * @Description : implementation code for graphs represented using an adjacency matrix
 */
public class GraphAdjacencyMatrix {
    //Using List instead of arrays provides flexibility in adding/removing vertices and edges.
    //undirected graph class based on adjacency matrix
    List<Integer> vertices; //vertex list, elements represent "vertex value", index represents "vertex index"
    List<List<Integer>> adjMat; // adjacency matrix, row and column indices to "vertex index"

    //Constructor
    public GraphAdjacencyMatrix(int[] vertices, int[][] edges){
        this.vertices = new ArrayList<>();
        this.adjMat = new ArrayList<>();

        //add vertex
        for(int val : vertices){
            addVertex(val);
        }

        //add edge
        for(int[] e : edges){
            addEdge(e[0],e[1]);
        }
    }

    //get the number of vertices
    public int size(){
        return vertices.size();
    }

    //add vertex
    public void addVertex(int val){
        int n = size();
        //add new vertex value to the vertex list
        vertices.add(val);
        //add a row to the adjacency matrix
        List<Integer> newRow = new ArrayList<>(n);
        for(int j = 0; j < n; j++){
            newRow.add(0);
        }
        adjMat.add(newRow);
        //add a column to the adjacency matrix
        for(List<Integer> row : adjMat){
            row.add(0);
        }
    }

    //remove vertex
    public void removeVertex(int index){
        if(index >= size())
            throw new IndexOutOfBoundsException();
        //remove vertex at 'index' from the vertex list
        vertices.remove(index);
        //remove the row at 'index' from the adjacency matrix
        adjMat.remove(index);
        //remove the column at 'index' from the adjacency matrix
        for(List<Integer> row : adjMat){
            row.remove(index);
        }
    }

    //add edge
    //parameters i,j correspond to vertices element indices
    public void addEdge(int i, int j){
        //handle index out of bounds and equality
        if(i < 0 || i >= size() || j < 0 || j >= size()){
            throw new IndexOutOfBoundsException();
        }
        // in an undirected graph,
        // the adjacency matrix is symmetric about the main diagonal,
        // i.e., satisfies (i, j) == (j, i)
        adjMat.get(i).set(j,1);
        adjMat.get(j).set(i,1);
    }

    //remove edge
    //parameters i, j correspond to vertices element indices
    public void removeEdge(int i, int j){
        //handle index out of bound and equality
        if(i < 0 || i >= size() || j < 0 || j >= size()){
            throw new IndexOutOfBoundsException();
        }
        adjMat.get(i).set(j,0);
        adjMat.get(j).set(i,0);
    }

    //print adjacency matrix
    public void print(){
        System.out.print("Vertex list = ");
        System.out.println(vertices);
        System.out.println("Adjacency matrix = ");
        //PrintUtil.printMatrix(adjMat);
    }
}
