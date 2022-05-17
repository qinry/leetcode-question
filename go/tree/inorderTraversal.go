package tree

func inorderTraversal(root *TreeNode) []int {
	path := []int{}
	stack := []*TreeNode{}
	curr := root
	for curr != nil || len(stack) != 0 {
		for curr != nil {

			stack = append(stack, curr)
			curr = curr.Left
		}
		curr = stack[len(stack)-1]
		stack = stack[:len(stack)-1]
		path = append(path, curr.Val)
		curr = curr.Right
	}
	return path
}
