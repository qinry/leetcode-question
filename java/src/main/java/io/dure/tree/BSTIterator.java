package io.dure.tree;

import java.util.Deque;
import java.util.LinkedList;

public class BSTIterator {
    private Deque<TreeNode> stack;
    private TreeNode curr;
    public BSTIterator(TreeNode root) {
        stack = new LinkedList<>();
        curr = root;
    }

    public int next() {
        int result;
        while (curr != null) {
            stack.push(curr);
            curr = curr.left;
        }
        curr = stack.pop();
        result = curr.val;
        curr = curr.right;
        return result;
    }

    public boolean hasNext() {
        return curr != null || !stack.isEmpty();
    }
}
