package tree

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func levelOrder(root *TreeNode) [][]int {
	order := [][]int{}
	if root == nil {
		return order
	}
	var q1 []*TreeNode
	q1 = append(q1, root)
	q2 := []*TreeNode{}
	level := []int{}
	for len(q1) != 0 {
		currentNode := q1[0]
		q1 = q1[1:]
		level = append(level, currentNode.Val)

		if currentNode.Left != nil {
			q2 = append(q2, currentNode.Left)
		}
		if currentNode.Right != nil {
			q2 = append(q2, currentNode.Right)
		}
		if len(q1) == 0 {
			q1 = q2
			q2 = []*TreeNode{}
			order = append(order, level)
			level = []int{}
		}
	}
	return order
}

func levelOrder2(root *TreeNode) [][]int {
	current := 0
	next := 0
	order := [][]int{}

	var q []*TreeNode
	if root != nil {
		q = append(q, root)
		current++
	}
	level := []int{}
	for len(q) != 0 {
		currentNode := q[0]
		q = q[1:]
		current--
		level = append(level, currentNode.Val)

		if currentNode.Left != nil {
			q = append(q, currentNode.Left)
			next++
		}
		if currentNode.Right != nil {
			q = append(q, currentNode.Right)
			next++
		}
		if current == 0{
			order = append(order, level)
			level = []int{}
			current = next
			next = 0
		}

	}
	return order
}
