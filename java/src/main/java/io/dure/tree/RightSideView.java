package io.dure.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> views = new ArrayList<>();
        int current = 0;
        int next = 0;
        if (root != null) {
            q.offer(root);
            current = 1;
        }
        while (!q.isEmpty()) {
            TreeNode currNode = q.poll();
            current--;
            if (currNode.left != null) {
                q.offer(currNode.left);
                next++;
            }
            if (currNode.right != null) {
                q.offer(currNode.right);
                next++;
            }
            if (current == 0) {
                current = next;
                next = 0;
                views.add(currNode.val);
            }
        }
        return views;
    }
}
