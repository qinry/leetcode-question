package io.dure.tree;

import java.util.HashMap;
import java.util.Map;

public class BuildTree {
    public TreeNode buildTreeByPreorderAndInorder(int[] preorder, int[] inorder) {
        Map<Integer, Integer> numToIdx = new HashMap<>();
        for (int i=0; i<inorder.length; i++) {
            numToIdx.put(inorder[i], i);
        }
        return buildTreeByPreorderAndInorder(preorder, inorder, numToIdx, 0, preorder.length-1, 0, inorder.length-1);
    }
    private TreeNode buildTreeByPreorderAndInorder(int[] preorder, int[] inorder, Map<Integer, Integer> numToIdx, int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart >  preEnd) {
            return null;
        }
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        int rootIdx = numToIdx.get(rootVal);
        int leftLen = rootIdx - inStart;
        root.left = buildTreeByPreorderAndInorder(preorder, inorder, numToIdx, preStart + 1, preStart + leftLen, inStart, rootIdx - 1);
        root.right = buildTreeByPreorderAndInorder(preorder, inorder, numToIdx, preStart + leftLen + 1, preEnd, rootIdx + 1,  inEnd);
        return root;
    }

    public TreeNode buildTreeByInorderAndPostorder(int[] inorder, int[] postorder) {
        Map<Integer, Integer> numToIdx = new HashMap<>();
        for (int i=0; i<inorder.length; i++) {
            numToIdx.put(inorder[i], i);
        }
        return buildTreeByInorderAndPostorder(inorder, postorder, numToIdx, 0, inorder.length-1, 0, postorder.length-1);
    }

    private TreeNode buildTreeByInorderAndPostorder(int[] inorder, int[] postorder, Map<Integer,Integer> numToIdx, int inStart, int inEnd, int postStart, int postEnd) {
        if (inStart > inEnd) {
            return null;
        }
        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);
        int rootIdx = numToIdx.get(rootVal);
        int rightLen = inEnd - rootIdx;
        root.left = buildTreeByInorderAndPostorder(inorder, postorder, numToIdx, inStart, rootIdx-1, postStart, postEnd-rightLen-1);
        root.right = buildTreeByInorderAndPostorder(inorder, postorder, numToIdx, rootIdx+1, inEnd, postEnd-rightLen, postEnd-1);
        return root;
    }
}
