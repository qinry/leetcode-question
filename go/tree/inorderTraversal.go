package tree

func inorderTraversal(root *TreeNode) []int {
	var path []int
	var stack []*TreeNode
	curr := root
	for curr != nil || len(stack) != 0 { // 左 父 右
		for curr != nil {

			stack = append(stack, curr)
			curr = curr.Left
		}
		curr = stack[len(stack)-1]
		stack = stack[:len(stack)-1]
		path = append(path, curr.Val) // in
		curr = curr.Right
	}
	return path
}
