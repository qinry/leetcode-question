package tree

func sumNumbers(root *TreeNode) int {
	var dfs func(node *TreeNode, path int) int
	dfs = func(node *TreeNode, path int) int {
		if node == nil {
			return 0
		}
		path = path*10 + node.Val
		if node.Left == nil && node.Right == nil {
			return path
		}
		return dfs(node.Left, path) + dfs(node.Right, path)
	}
	return dfs(root, 0)
}
