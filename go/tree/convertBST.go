package tree

func convertBST(root *TreeNode) *TreeNode {
	var stack []*TreeNode
	curr := root
	sum := 0
	for curr != nil || len(stack) != 0 {
		for curr != nil {
			stack = append(stack, curr)
			curr = curr.Right
		}
		curr = stack[len(stack)-1]
		stack = stack[:len(stack)-1]
		sum += curr.Val
		curr.Val = sum
		curr = curr.Left
	}
	return root
}
