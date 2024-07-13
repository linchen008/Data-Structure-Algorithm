# What is Binary Tree
- A binary tree is a non-linear data structure that represents the hierarchical relationship between ancestors and descendants, embodying the divide-and-conquer logic of "splitting into two". Similar to a linked list, the basic unit of a binary tree is a node, each containing a value, a reference to the left child node, and a reference to the right child node.
```Java
/* Binary tree node */
class TreeNode {
    int val;         // Node value
    TreeNode left;   // Reference to left child node
    TreeNode right;  // Reference to right child node
    TreeNode(int x) { val = x; } // Contructor
}
```

- Each node has two references (pointers), pointing to the left-child node and right-child node, respectively. This node is called the parent node of these two child nodes. When given a node of a binary tree, we call the tree formed by this node's left child and all nodes under it the left subtree of this node. Similarly, the right subtree can be defined.

- In a binary tree, except for leaf nodes, all other nodes contain child nodes and non-empty subtrees. As shown in Figure 7-1, if "Node 2" is considered as the parent node, then its left and right child nodes are "Node 4" and "Node 5," respectively. The left subtree is "the tree formed by Node 4 and all nodes under it," and the right subtree is "the tree formed by Node 5 and all nodes under it."

![[Pasted image 20240630215847.png|800]]
## Common terminology of binary trees
The commonly used terminology of binary trees is shown in Figure 7-2.
- **Root node**: The node at the top level of the binary tree, which has no parent node.
- **Leaf node**: A node with no children, both of its pointers point to `None`.
- **Edge**: The line segment connecting two nodes, i.e., node reference (pointer).
- The **level** of a node: Incrementing from top to bottom, with the root node's level being 1.
- The **degree** of a node: The number of children a node has. In a binary tree, the degree can be 0, 1, or 2.
- The **height** of a binary tree: The number of edges passed from the root node to the farthest leaf node.
- The **depth** of a node: The number of edges passed from the root node to the node.
- The **height** of a node: The number of edges from the farthest leaf node to the node.
![[Pasted image 20240630220317.png|800]]
## Basic operations of binary trees
### 1.   Initializing a binary tree
Similar to a linked list, begin by initialize nodes, then construct references (pointers).
```Java
//initializing nodes
TreeNode n1 = new TreeNode(1);
TreeNode n2 = new TreeNode(2);
TreeNode n3 = new TreeNode(3);
TreeNode n4 = new TreeNode(4);
TreeNode n5 = new TreeNode(5);
//linking references (pointers) between nodes
n1.left = n2;
n1.right = n3;
n2.left = n4;
n2.right = n5;
```

### 2.   Inserting and removing nodes
Similar to a linked list, inserting and removing nodes in a binary tree can be achieved by modifying pointers. Figure 7-3 provides an example.
![[Pasted image 20240630220839.png|1200]]
```Java
//New node "P" points to node(0)
TreeNode P = new TreeNode(0);
//inserting node p between n1 and n2
n1.left = P;
P.left = n2;
//removing node P
n1.left = n2;
```

### Perfect binary tree
As shown in Figure 7-4, in a perfect binary tree, all levels of nodes are fully filled. In a perfect binary tree, the degree of leaf nodes is 0, while the degree of all other nodes is 2; if the tree's height is ℎ, then the total number of nodes is 2ℎ+1−1, showing a standard exponential relationship, reflecting the common phenomenon of cell division in nature.
![[Pasted image 20240630221319.png|500]]
### Complete binary tree
As shown in Figure 7-5, a complete binary tree has only the bottom level nodes not fully filled, and the bottom level nodes are filled as far left as possible.
![[Pasted image 20240630221432.png|500]]
### Full binary tree
As shown in Figure 7-6, a full binary tree has all nodes except leaf nodes having two children.
![[Pasted image 20240630221604.png|500]]
### Balanced binary tree
As shown in Figure 7-7, in a balanced binary tree, the absolute difference in height between the left and right subtrees of any node does not exceed 1.
![[Pasted image 20240630221644.png|1200]]
## Degeneration of binary trees
Figure 7-8 shows the ideal and degenerate structures of binary trees. A binary tree becomes a "perfect binary tree" when every level is filled; while it degenerates into a "linked list" when all nodes are biased toward one side.

- The perfect binary tree is the ideal situation, fully leveraging the "divide and conquer" advantage of binary trees.
- A linked list is another extreme, where operations become linear, degrading the time complexity to 𝑂(𝑛).
![[Pasted image 20240630222020.png|800]]
As shown in Table, in the best and worst structures, the number of leaf nodes, total number of nodes, and height of the binary tree reach their maximum or minimum values.

| Best and Worst Structures of Binary Trees     | Perfect binary tree | Linked list |
| --------------------------------------------- | ------------------- | ----------- |
| Number of nodes at level 𝑖                   | 2𝑖−1               | 1           |
| Number of leaf nodes in a tree with height ℎ  | 2ℎ                  | 1           |
| Total number of nodes in a tree with height ℎ | 2ℎ+1−1              | ℎ+1         |
| Height of a tree with 𝑛 total nodes          | log2⁡(𝑛+1)−1       | 𝑛−1        |
