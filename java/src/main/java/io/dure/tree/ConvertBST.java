package io.dure.tree;

import java.util.Deque;
import java.util.LinkedList;

public class ConvertBST {
    public TreeNode convertBST(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode curr = root;
        int sum = 0;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.right;
            }
            curr = stack.pop();
            sum += curr.val;
            curr.val = sum;
            curr = curr.left;
        }
        return root;
    }
}
