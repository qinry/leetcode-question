package tree

func maxDepth(root *TreeNode) int {
	var dfs func(root *TreeNode) int
	dfs = func(root *TreeNode) int {
		if root == nil {
			return 0
		}
		return max(dfs(root.Left), dfs(root.Right)) + 1
	}
	return dfs(root)
}

func max(x, y int) int {
	if x >= y {
		return x
	}
	return y
}
