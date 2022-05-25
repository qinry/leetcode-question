package tree

import "math"

func isValidBST(root *TreeNode) bool {
	var dfs func(node *TreeNode, min, max int) bool
	dfs = func(node *TreeNode, min, max int) bool {
		if node == nil {
			return true
		}
		if node.Val <= min || node.Val >= max {
			return false
		}

		return dfs(node.Left, min, node.Val) && dfs(node.Right, node.Val, max)

	}
	return dfs(root, math.MinInt64, math.MaxInt64)
}

func isValidBST2(root *TreeNode) bool {
	var stack []*TreeNode
	curr := root
	preVal := math.MinInt64
	for curr != nil || len(stack) != 0 {
		for curr != nil {
			stack = append(stack, curr)
			curr = curr.Left
		}
		curr = stack[len(stack)-1]
		stack = stack[:len(stack)-1]
		if curr.Val <= preVal {
			return false
		}
		preVal = curr.Val
		curr = curr.Right
	}
	return true
}
