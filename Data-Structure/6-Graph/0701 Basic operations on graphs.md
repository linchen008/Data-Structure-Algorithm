The basic operations on graphs can be divided into operations on "`edges`" and operations on "`vertices`". Under the two representation methods of "adjacency matrix" and "adjacency list", the implementation methods are different.
## 1 Implementation based on ***adjacency matrix***
Given an undirected graph with 𝑛 vertices, the various operations are implemented as shown in Figure 9-7.
- **Adding or removing an edge**: Directly modify the specified edge in the adjacency matrix, using 𝑂(1) time. Since it is an undirected graph, it is necessary to update the edges in both directions simultaneously.
- **Adding a vertex**: Add a row and a column at the end of the adjacency matrix and fill them all with 0s, using 𝑂(𝑛) time.
- **Removing a vertex**: Delete a row and a column in the adjacency matrix. The worst case is when the first row and column are removed, requiring (𝑛−1)2 elements to be "moved up and to the left", thus using 𝑂(𝑛2) time.
- **Initialization**: Pass in 𝑛 vertices, initialize a vertex list `vertices` of length 𝑛, using 𝑂(𝑛) time; initialize an 𝑛×𝑛 size adjacency matrix `adjMat`, using 𝑂(𝑛2) time.
### Initialize adjacency matrix
![[Pasted image 20240701130906.png|800]]
### Add an edge
![[Pasted image 20240701130951.png|800]]
### Remove an edge
![[Pasted image 20240701131030.png|800]]
### Add a vertex
![[Pasted image 20240701131631.png|800]]
### Remove a vertex
![[Pasted image 20240701131706.png|800]]
### Implementation

```Java
//graphs represented using an adjacency matrix
//List<List<Integer>>
public class GraphAdjacencyMatrix {  
    //Using List instead of arrays provides flexibility in adding/removing vertices and edges.  
    //undirected graph class based on adjacency matrix    List<Integer> vertices; //vertex list, elements represent "vertex value", index represents "vertex index"  
    List<List<Integer>> adjMat; // adjacency matrix, row and column indices to "vertex index"  
  
    //Constructor    public GraphAdjacencyMatrix(int[] vertices, int[][] edges){  
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
    //parameters i,j correspond to vertices element indices    public void addEdge(int i, int j){  
        //handle index out of bounds and equality  
        if(i < 0 || i >= size() || j < 0 || j >= size()){  
            throw new IndexOutOfBoundsException();  
        }  
        // in an undirected graph,  
        // the adjacency matrix is symmetric about the main diagonal,        // i.e., satisfies (i, j) == (j, i)        adjMat.get(i).set(j,1);  
        adjMat.get(j).set(i,1);  
    }  
  
    //remove edge  
    //parameters i, j correspond to vertices element indices    public void removeEdge(int i, int j){  
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
```

```Java
//2D array
public class Graph2 {  
    private int[][] adjacencyMatrix;  
    private int numberOfVertices;  
  
    //Constructor to initialize the graph with the specified number of vertices  
    public Graph2(int numberOfVertices) {  
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
```

## 2 Implementation based on adjacency list
Given an undirected graph with a total of 𝑛 vertices and 𝑚 edges, the various operations can be implemented as shown in Figure 9-8.
- **Adding an edge**: Simply add the edge at the end of the corresponding vertex's linked list, using 𝑂(1) time. Because it is an undirected graph, it is necessary to add edges in both directions simultaneously.
- **Removing an edge**: Find and remove the specified edge in the corresponding vertex's linked list, using 𝑂(𝑚) time. In an undirected graph, it is necessary to remove edges in both directions simultaneously.
- **Adding a vertex**: Add a linked list in the adjacency list and make the new vertex the head node of the list, using 𝑂(1) time.
- **Removing a vertex**: It is necessary to traverse the entire adjacency list, removing all edges that include the specified vertex, using 𝑂(𝑛+𝑚) time.
- **Initialization**: Create 𝑛 vertices and 2𝑚 edges in the adjacency list, using 𝑂(𝑛+𝑚) time.

### Initialize adjacency list
![[Pasted image 20240703143218.png|800]]
### Add an Edge
![[Pasted image 20240703143737.png|800]]




### Remove an edge
![[Pasted image 20240703143824.png|800]]
### Add a vertex
![[Pasted image 20240703143900.png|800]]
### Remove a vertex
![[Pasted image 20240703143939.png|800]]


### Code
```Java

```

## Efficiency comparison
Assuming there are 𝑛 vertices and 𝑚 edges in the graph, Table 9-2 compares the time efficiency and space efficiency of the adjacency matrix and adjacency list.
*Comparison of adjacency matrix and adjacency list*

| |Adjacency matrix|Adjacency list (Linked list)|Adjacency list (Hash table)|
|---|---|---|---|
|Determine adjacency|𝑂(1)|𝑂(𝑚)|𝑂(1)|
|Add an edge|𝑂(1)|𝑂(1)|𝑂(1)|
|Remove an edge|𝑂(1)|𝑂(𝑚)|𝑂(1)|
|Add a vertex|𝑂(𝑛)|𝑂(1)|𝑂(1)|
|Remove a vertex|𝑂(𝑛2)|𝑂(𝑛+𝑚)|𝑂(𝑛)|
|Memory space usage|𝑂(𝑛2)|𝑂(𝑛+𝑚)|𝑂(𝑛+𝑚)|
Observing Table, it seems that the adjacency list (hash table) has the best time efficiency and space efficiency. However, in practice, operating on edges in the adjacency matrix is more efficient, requiring only a single array access or assignment operation. Overall, the adjacency matrix exemplifies the principle of "space for time", while the adjacency list exemplifies "time for space".

