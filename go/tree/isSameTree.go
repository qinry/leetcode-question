package tree

func isSameTree(p, q *TreeNode) bool {
	if p == nil || q == nil {
		return p == q
	}
	leftSame := isSameTree(p.Left, q.Left)
	rightSame := isSameTree(p.Left, q.Right)
	return p.Val == q.Val && leftSame && rightSame
}
