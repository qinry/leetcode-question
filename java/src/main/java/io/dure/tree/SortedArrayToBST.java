package io.dure.tree;

public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(nums, 0, nums.length-1);
    }
    private TreeNode buildTree(int[] nums, int minIdx, int maxIdx) {
        if (minIdx > maxIdx) {
            return null;
        }
        int rootIdx = minIdx + (maxIdx - minIdx + 1) / 2;
        int rootVal = nums[rootIdx];
        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree(nums, minIdx, rootIdx-1);
        root.right = buildTree(nums, rootIdx+1, maxIdx);
        return root;
    }
}
