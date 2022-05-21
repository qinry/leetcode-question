package tree

// 二叉树
func lowestCommonAncestor(root, p, q *TreeNode) *TreeNode {
	var dfs func(x, p, q *TreeNode) *TreeNode
	dfs = func(x, p, q *TreeNode) *TreeNode {
		if x == nil || x.Val == p.Val || x.Val == q.Val {
			return x
		}
		left := dfs(x.Left, p, q)
		right := dfs(x.Right, p, q)
		if left == nil {
			return right
		}
		if right == nil {
			return left
		}
		return x
	}
	return dfs(root, p, q)
}

// 二叉搜索树
func lowestCommonAncestor2(root, p, q *TreeNode) *TreeNode {
	ancestor := root
	for true {
		if ancestor.Val < p.Val && ancestor.Val < q.Val {
			ancestor = ancestor.Right
		} else if ancestor.Val > p.Val && ancestor.Val > q.Val {
			ancestor = ancestor.Left
		} else {
			break
		}
	}
	return ancestor
}
