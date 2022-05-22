package tree

func rightSideView(root *TreeNode) []int {
	var views []int
	var q []*TreeNode
	current := 0
	next := 0
	if root != nil {
		q = append(q, root)
		current = 1
	}
	for len(q) != 0 {
		currNode := q[0]
		q = q[1:]
		current--
		if currNode.Left != nil {
			q = append(q, currNode.Left)
			next++
		}
		if currNode.Right != nil {
			q = append(q, currNode.Right)
			next++
		}
		if current == 0 {
			current = next
			next = 0
			views = append(views, currNode.Val)
		}
	}
	return views
}
