package example;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author : Tommy
 * @version : 1.0
 * @createTime : 24/08/2024 12:19
 * @Description :
 */
class MultiTreeNode {
    int val;
    List<MultiTreeNode> children;

    //DFS
    void traverse(MultiTreeNode root) {
        if (root == null) {
            return;
        }
        // pre-order
        System.out.print(root.val + " ");
        for (MultiTreeNode child : root.children) {
            traverse(child);
        }
        // post-order
    }

    //BFS
    void levelOrderTraverse1(MultiTreeNode root) {
        if (root == null) {
            return;
        }

        Queue<MultiTreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            MultiTreeNode cur = queue.poll();
            System.out.print(cur.val + " ");

            for (MultiTreeNode child : cur.children) {
                queue.offer(child);
            }
        }
    }

    // BFS with level
    void levelOrderTraverse2(MultiTreeNode root) {
        if (root == null) {
            return;
        }
        Queue<MultiTreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int depth = 1;

        while (!queue.isEmpty()) {
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                MultiTreeNode cur = queue.poll();
                System.out.println("Level " + depth + ": " + cur.val);

                for (MultiTreeNode child : cur.children) {
                    queue.offer(child);
                }
            }
            depth++;
        }
    }

    // BFS with weight
    class State {
        MultiTreeNode node;
        int depth;

        State(MultiTreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    void levelOrderTraverse(MultiTreeNode root) {
        if (root == null) {
            return;
        }
        Queue<State> queue = new LinkedList<>();
        queue.offer(new State(root, 1));

        while (!queue.isEmpty()) {
            State state = queue.poll();
            MultiTreeNode cur = state.node;
            int depth = state.depth;
            System.out.println("Level " + depth + ": " + cur.val);

            for (MultiTreeNode child : cur.children) {
                queue.offer(new State(child, depth + 1));
            }
        }
    }
}