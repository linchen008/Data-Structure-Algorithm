import java.util.List;
import java.util.ArrayList;

/**
 * WeightDigraph is a class that represents
 * a weighted directed graph using
 * adjacency list.
 */

class WeightDigraph1 {

    // store neighbors and weight
    public static class Edge {
        int to;
        int weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    // store all neighbors
    private List<Edge>[] graph;

    public WeightDigraph1(int n) {
        graph = new List[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
    }

    // add edge from 'from' to 'to' with weight, O(1)
    public void addEdge(int from, int to, int weight) {
        graph[from].add(new Edge(to, weight));
    }

    // delete edge from 'from' to 'to', O(V)
    public void removeEdge(int from, int to) {
        // find the edge and remove it
        for (int i = 0; i < graph[from].size(); i++) {
            // if found, remove it and break the loop
            if (graph[from].get(i).to == to) {
                graph[from].remove(i);
                break;
            }
        }
    }

    // check if there is an edge from 'from' to 'to', O(V)
    public boolean hasEdge(int from, int to) {
        for (Edge edge : graph[from]) {
            if (edge.to == to) {
                return true;
            }
        }
        return false;
    }

    // get weight of edge from 'from' to 'to', O(V)
    public int weight(int from, int to) {
        for (Edge edge : graph[from]) {
            if (edge.to == to) {
                return edge.weight;
            }
        }
        throw new IllegalArgumentException("Edge not found");
    }

    // get neighbors of vertex 'from', O(1)
    public List<Edge> getNeighbors(int from) {
        return graph[from];
    }
}