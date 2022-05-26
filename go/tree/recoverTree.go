package tree

func recoverTree(root *TreeNode) {
	var stack []*TreeNode
	curr := root
	var prev, x, y *TreeNode

	for curr != nil || len(stack) != 0 {
		for curr != nil {
			stack = append(stack, curr)
			curr = curr.Left
		}
		curr = stack[len(stack)-1]
		stack = stack[:len(stack)-1]

		if prev != nil && prev.Val > curr.Val {
			y = curr
			if x == nil {
				x = prev
			} else {
				break
			}
		}
		prev = curr
		curr = curr.Right
	}
	swap(x, y)
}

func swap(x, y *TreeNode) {
	temp := x.Val
	x.Val = y.Val
	y.Val = temp
}
