package io.dure.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> order = new ArrayList<>();
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        List<Integer> level = new ArrayList<>();
        if (root != null) {
            q1.offer(root);
        }
        while (!q1.isEmpty()) {
            TreeNode currentNode = q1.poll();
            level.add(currentNode.val);
            if (currentNode.left != null) {
                q2.offer(currentNode.left);
            }
            if (currentNode.right != null) {
                q2.offer(currentNode.right);
            }
            if (q1.isEmpty()) {
                order.add(new ArrayList<>(level));
                level = new ArrayList<>();
                q1 = q2;
                q2 = new LinkedList<>();
            }
        }
        return order;
    }

    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> order = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> level = new ArrayList<>();
        int current = 0;
        int next = 0;
        if (root != null) {
            q.offer(root);
            current = 1;
        }
        while (!q.isEmpty()) {
            TreeNode currentNode = q.poll();
            current--;
            level.add(currentNode.val);
            if (currentNode.left != null) {
                q.offer(currentNode.left);
                next++;
            }
            if (currentNode.right != null) {
                q.offer(currentNode.right);
                next++;
            }
            if (current == 0) {
                order.add(new ArrayList<>(level));
                level = new ArrayList<>();
                current = next;
                next = 0;
            }
        }
        return order;
    }
}
