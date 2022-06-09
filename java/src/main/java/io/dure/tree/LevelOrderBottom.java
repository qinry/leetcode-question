package io.dure.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderBottom {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> level = new LinkedList<>();
        int current = 0;
        int next = 0;
        if (root != null) {
            queue.offer(root);
            current++;
        }
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            current--;
            level.add(node.val);
            if (node.left != null) {
                queue.offer(node.left);
                next++;
            }
            if (node.right != null) {
                queue.offer(node.right);
                next++;
            }
            if (current == 0) {
                current = next;
                next = 0;
                res.add(0, level);
                level = new LinkedList<>();
            }
        }
        return res;
    }
}
