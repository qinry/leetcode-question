package io.dure.tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNode {

    public static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
    // 完全二叉树
    public Node connect(Node root) {
        // 算法思想 1.双队列 2. DFS
        // O(n) time | O(n) space
        if (root == null) {
            return null;
        }

        // 队列1做遍历
        Queue<Node> queue1 = new LinkedList<>();
        // 队列2收集上一层结点的子节点
        Queue<Node> queue2 = new LinkedList<>();
        queue1.offer(root);
        Node prev = null;
        while (!queue1.isEmpty()) {
            Node curr = queue1.poll();
            if (prev != null)
                prev.next = curr;
            if (curr.left != null)
                queue2.offer(curr.left);
            if (curr.right != null)
                queue2.offer(curr.right);
            if (queue1.isEmpty()) {
                queue1 = queue2;
                queue2 = new LinkedList<>();
                prev = null;
            } else {
                prev = curr;
            }
        }
        return root;
    }

    public Node connect2(Node root) {
        // 前序遍历 操作结点 左子节点 右子节点
        Node current = root;
        Deque<Node> stack = new LinkedList<>();
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                helper(current);
                stack.push(current);
                current = current.left;
            }
            current = stack.pop(); // 取出上一次访问结点
            current = current.right;
        }
        return root;
    }

    private void helper(Node node) {
        if (node.left != null && node.right != null) {
            node.left.next = node.right;
            if (node.next != null) {
                node.right.next = node.next.left;
            }
        }
    }

    public Node connect3(Node root) {
        return dfs(root);
    }

    private Node dfs(Node root) {
        if (root == null) {
            return root;
        }
        helper(root);
        dfs(root.left);
        dfs(root.right);
        return root;
    }
}
