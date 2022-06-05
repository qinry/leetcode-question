package tree

func pathSum(root *TreeNode, targetSum int) int {
	pathSumToCount := map[int]int{}
	pathSumToCount[0] = 1
	var dfs func(node *TreeNode, targetSum int, pathSum int, pathSumToCount map[int]int) int
	dfs = func(node *TreeNode, targetSum int, pathSum int, pathSumToCount map[int]int) int {
		if node == nil {
			return 0
		}
		pathSum += node.Val
		count := pathSumToCount[pathSum-targetSum]
		pathSumToCount[pathSum] += 1
		count += dfs(node.Left, targetSum, pathSum, pathSumToCount)
		count += dfs(node.Right, targetSum, pathSum, pathSumToCount)
		pathSumToCount[pathSum] -= 1
		return count
	}
	return dfs(root, targetSum, 0, pathSumToCount)
}
