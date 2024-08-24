import java.util.ArrayList;
import java.util.List;

/*
 * WeightDigraph is a class that represents 
 * a weighted directed graph 
 * using adjacency matrix.
 */

class WeightDigraph2 {

    // store neighbors and weight
    public static class Edge {
        int to;
        int weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    // matrix representation of graph
    // matrix[i][j] = weight of edge from i to j
    // 0 denotes no edge
    private int[][] matrix;

    public WeightDigraph2(int n) {
        matrix = new int[n][n];
    }

    // add edge from 'from' to 'to' with weight, O(1)
    public void addEdge(int from, int to, int weight) {
        matrix[from][to] = weight;
    }

    // delete edge from 'from' to 'to', O(1)
    public void removeEdge(int from, int to) {
        matrix[from][to] = 0;
    }

    // check if there is an edge from 'from' to 'to', O(1)
    public boolean hasEdge(int from, int to) {
        return matrix[from][to] != 0;
    }

    // get weight of edge from 'from' to 'to', O(1)
    public int getWeight(int from, int to) {
        return matrix[from][to];
    }

    // get all neighbors of node 'from', O(V)
    public List<Edge> getNeighbors(int v) {
        List<Edge> neighbors = new ArrayList<>();
        for (int i = 0; i < matrix[v].length; i++) {
            if (matrix[v][i] > 0) {
                neighbors.add(new Edge(i, matrix[v][i]));
            }
        }
        return neighbors;
    }
}
