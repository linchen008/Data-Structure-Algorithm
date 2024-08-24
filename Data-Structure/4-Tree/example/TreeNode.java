package example;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author : Tommy
 * @version : 1.0
 * @createTime : 24/08/2024 11:50
 * @Description :
 */
class TreeNode {
    int val; // Node value
    TreeNode left; // Reference to left child node
    TreeNode right; // Reference to right child node

    TreeNode(int x) {
        val = x;
    }

    // recursively traversal
    public void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        //pre-order
        System.out.print(root.val + " ");
        preOrder(root.left);
        // in-order
        preOrder(root.right);
        //  post-order
    }

    // level order traversal
    void levelOrderTraverse1(TreeNode root) {
        if (root == null) {
            return;
        }
        // Create a queue to store the node
        Queue<TreeNode> queue = new LinkedList<>();
        // Add the root node to the queue
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            System.out.print(cur.val + " ");

            if (cur.left != null) {
                queue.offer(cur.left);
            }

            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
    }

    // level order traversal2
    void levelOrderTraverse2(TreeNode root) {
        if (root == null) {
            return;
        }
        // Create a queue to store the node
        Queue<TreeNode> queue = new LinkedList<>();
        // Add the root node to the queue
        queue.offer(root);
        // Record the depth of the tree
        int depth = 1;
        while (!queue.isEmpty()) {
            int sz = queue.size(); // Record the number of nodes in the current layer

//            while (sz-- > 0){
//                ...
//            }

            for (int i = 0; i < sz; i++) {
                // Take out the node at the head of the queue
                TreeNode cur = queue.poll();
                System.out.print(cur.val + " ");

                // Add the left and right child nodes of the current node to the queue
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            depth++;
        }
    }

    // level order traversal3
    // path weight
    class State {
        TreeNode node;
        int depth;

        State(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    void levelOrderTraverse3(TreeNode root) {
        if (root == null) {
            return;
        }
        // Create a queue to store the node
        Queue<State> queue = new LinkedList<>();
        // root node, path weight = 1
        queue.offer(new State(root, 1));

        while (!queue.isEmpty()) {
            State cur = queue.poll();
            System.out.println("depth: " + cur.depth + " value: " + cur.node.val);

            // Add the left and right child nodes of the current node to the queue
            if (cur.node.left != null) {
                queue.offer(new State(cur.node.left, cur.depth + 1));
            }

            if (cur.node.right != null) {
                queue.offer(new State(cur.node.right, cur.depth + 1));
            }
        }
    }
}
