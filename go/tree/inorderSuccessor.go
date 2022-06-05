package tree

func inorderSuccessor(root *TreeNode, p *TreeNode) *TreeNode {
	curr := root
	var result *TreeNode = nil
	for curr != nil {
		if curr.Val > p.Val {
			result = curr
			curr = curr.Left
		} else {
			curr = curr.Right
		}
	}
	return result
}
