package io.dure.tree;

import java.util.HashMap;
import java.util.Map;

public class PathSum {
    public int pathSum(TreeNode root, int targetSum) {
        Map<Integer, Integer> pathSumToCount = new HashMap<>();
        pathSumToCount.put(0, 1);
        return dfs(root, targetSum, 0, pathSumToCount);
    }

    private int dfs(TreeNode node, int targetSum, int pathSum, Map<Integer, Integer> pathSumToCount) {
        if (node == null) {
            return 0;
        }
        pathSum += node.val;
        int count = pathSumToCount.getOrDefault(pathSum - targetSum, 0);
        pathSumToCount.put(pathSum, pathSumToCount.getOrDefault(pathSum, 0) + 1);

        count += dfs(node.left, targetSum, pathSum, pathSumToCount);
        count += dfs(node.right, targetSum, pathSum, pathSumToCount);

        pathSumToCount.put(pathSum, pathSumToCount.get(pathSum) - 1);
        return count;
    }
}
