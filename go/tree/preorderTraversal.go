package tree

func preorderTraversal(root *TreeNode) []int {
	var path []int
	var stack []*TreeNode
	curr := root
	for curr != nil || len(stack) != 0 {
		for curr != nil {
			path = append(path, curr.Val) // pre
			stack = append(stack, curr)
			curr = curr.Left
		}
		curr = stack[len(stack)-1]
		stack = stack[:len(stack)-1]
		curr = curr.Right
	}
	return path
}
