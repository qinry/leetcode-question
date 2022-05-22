package tree

func postorderTraversal(root *TreeNode) []int {
	var path []int
	var stack []*TreeNode
	curr := root
	var prev *TreeNode
	for curr != nil || len(stack) != 0 {
		for curr != nil {
			stack = append(stack, curr)
			curr = curr.Left
		}
		curr = stack[len(stack)-1]
		if curr.Right != nil && curr.Right != prev {
			curr = curr.Right
		} else {
			stack = stack[:len(stack)-1]
			path = append(path, curr.Val)
			prev = curr
			curr = nil
		}
	}
	return path
}
