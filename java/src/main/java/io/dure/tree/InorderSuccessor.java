package io.dure.tree;

public class InorderSuccessor {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode curr = root;
        TreeNode result = null;
        while (curr != null) {
            if (curr.val > p.val) {
                result = curr;
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
        return result;
    }
}
