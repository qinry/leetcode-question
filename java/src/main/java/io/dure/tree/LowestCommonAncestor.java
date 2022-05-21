package io.dure.tree;

import java.util.*;

public class LowestCommonAncestor {
    // 二叉树
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode curr = root;
        Map<Integer, TreeNode> parent = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                if (curr.left != null) {
                    parent.put(curr.left.val, curr);
                }
                curr = curr.left;

            }
            curr = stack.pop();
            if (curr.right != null) {
                parent.put(curr.right.val, curr);
            }
            curr = curr.right;

        }
        while (p != null) {
            visited.add(p.val);
            p = parent.get(p.val);
        }
        while (q != null) {
            if (visited.contains(q.val)) {
                return q;
            }
            q = parent.get(q.val);
        }
        return null;
    }

//    private TreeNode dfs(TreeNode x, TreeNode p, TreeNode q) {
//        if (x == null || x.val == p.val || x.val == q.val) {
//            return x;
//        }
//        TreeNode left = dfs(x.left, p, q);
//        TreeNode right = dfs(x.right, p, q);
//
//        if (left == null) {
//            return right;
//        }
//
//        if (right == null) {
//            return left;
//        }
//        return x;
//    }

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
