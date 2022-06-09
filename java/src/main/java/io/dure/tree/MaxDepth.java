package io.dure.tree;

import java.util.LinkedList;
import java.util.Queue;

public class MaxDepth {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public int maxDepth2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        int curr = 0;
        int next = 0;
        int level = 0;
        if (root != null) {
            queue.offer(root);
            curr += 1;
        }
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            curr--;
            if (node.left != null) {
                queue.offer(node.left);
                next++;
            }
            if (node.right != null) {
                queue.offer(node.right);
                next++;
            }
            if (curr == 0) {
                curr = next;
                next = 0;
                level++;
            }
        }
        return level;
    }
}
