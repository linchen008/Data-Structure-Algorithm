From the perspective of physical structure, *a tree is a data structure based on linked lists*, hence its traversal method involves accessing nodes one by one through pointers. However, a tree is a non-linear data structure, which makes traversing a tree more complex than traversing a linked list, requiring the assistance of search algorithms to achieve.

Common traversal methods for binary trees include *level-order traversal, pre-order traversal, in-order traversal, and post-order traversal*, among others.

## 1 Level-order traversal
As shown in Figure 7-9, level-order traversal traverses the binary tree from top to bottom, layer by layer, and accesses nodes in each layer *in a left-to-right order*.

Level-order traversal essentially belongs to **breadth-first traversal**, also known as **breadth-first search (BFS)**, which embodies a "circumferentially outward expanding" layer-by-layer traversal method.
![[Pasted image 20240630223025.png|800]]
### 1.   Code implementation
Breadth-first traversal is usually implemented with the help of a "queue". The queue follows the "first in, first out" rule, while breadth-first traversal follows the "layer-by-layer progression" rule, the underlying ideas of the two are consistent. The implementation code is as follows:
```Java
public class LevelOrder {  
    List<Integer> levelOrder(TreeNode root){  
        //Initialize queue, add root node  
        Queue<TreeNode> queue = new LinkedList<>();  
        queue.add(root);  
        //Initialize a list to store the traversal sequence  
        List<Integer> list = new ArrayList<>();  
        while(!queue.isEmpty()){  
            TreeNode node = queue.poll(); //Queue dequeues  
            list.add(node.val); //save node value  
            if(node.left != null){  
                queue.offer(node.left); //left child node enqueues  
            }  
            if(node.right != null){  
                queue.offer(node.right);//right child node enqueues  
            }  
        }  
        return list;  
    }  
}
```
### 2.   Complexity analysis
- **Time complexity is 𝑂(𝑛)**: All nodes are visited once, using 𝑂(𝑛) time, where 𝑛 is the number of nodes.
- **Space complexity is 𝑂(𝑛)**: In the worst case, i.e., a full binary tree, before traversing to the lowest level, the queue can contain at most (𝑛+1)/2 nodes at the same time, occupying 𝑂(𝑛) space.
