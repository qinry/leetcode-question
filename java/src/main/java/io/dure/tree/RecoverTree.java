package io.dure.tree;

import java.util.Deque;
import java.util.LinkedList;

public class RecoverTree {
    public void recoverTree(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode curr = root;
        TreeNode prev = null, x = null, y = null;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            if (prev != null && prev.val > curr.val) {
                y = root;
                if (x == null) {
                    x = curr;
                } else {
                    break;
                }
            }
            prev = curr;
            curr = curr.right;
        }
    }

    private void swap(TreeNode x, TreeNode y) {
        int temp = x.val;
        x.val = y.val;
        y.val = temp;
    }
}
