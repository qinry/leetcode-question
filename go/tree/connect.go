package tree

type Node struct {
	Val   int
	Left  *Node
	Right *Node
	Next  *Node
}

func connect(root *Node) *Node {
	var stack []*Node
	curr := root
	for curr != nil || len(stack) != 0 {
		for curr != nil {
			linkNode(curr)
			stack = append(stack, curr)
			curr = curr.Left
		}
		curr = stack[len(stack)-1]
		stack = stack[:len(stack)-1]
		curr = curr.Right
	}
	return root
}

func connect2(root *Node) *Node {
	var dfs func(root *Node) *Node
	dfs = func(root *Node) *Node {
		if root == nil {
			return root
		}
		linkNode(root)
		dfs(root.Left)
		dfs(root.Right)
		return root
	}
	return dfs(root)
}

func connect3(root *Node) *Node {
	q1 := []*Node{}
	q2 := []*Node{}
	if root != nil {
		q1 = append(q1, root)
	}
	var prev *Node
	for len(q1) != 0 {
		curr := q1[0]
		q1 = q1[1:]
		if prev != nil {
			prev.Next = curr
		}
		if curr.Left != nil {
			q2 = append(q2, curr.Left)
		}
		if curr.Right != nil {
			q2 = append(q2, curr.Right)
		}
		if len(q1) == 0 {
			tmp := q1
			q1 = q2
			q2 = tmp
			prev = nil
		} else {
			prev = curr
		}
	}
	return root
}

func linkNode(node *Node) {
	if node.Left != nil && node.Right != nil {
		node.Left.Next = node.Right
		if node.Next != nil {
			node.Right.Next = node.Next.Left
		}
	}
}
