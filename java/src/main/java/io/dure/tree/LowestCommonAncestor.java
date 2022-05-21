package io.dure.tree;

public class LowestCommonAncestor {
    // 二叉树
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return dfs(root, p, q);
    }

    private TreeNode dfs(TreeNode x, TreeNode p, TreeNode q) {
        if (x == null || x.val == p.val || x.val == q.val) {
            return x;
        }
        TreeNode left = dfs(x.left, p, q);
        TreeNode right = dfs(x.right, p, q);

        if (left == null) {
            return right;
        }

        if (right == null) {
            return left;
        }
        return x;
    }

    // 二叉搜索树
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ancestor = root;
        while (true) {
            if (ancestor.val < p.val && ancestor.val < q.val) {
                ancestor = ancestor.right;
            } else if (ancestor.val > p.val && ancestor.val > q.val){
                ancestor = ancestor.left;
            } else {
                break;
            }
        }
        return ancestor;
    }
}
