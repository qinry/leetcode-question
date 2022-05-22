package tree

// 二叉树
//func lowestCommonAncestor(root, p, q *TreeNode) *TreeNode {
//	var dfs func(node, p, q *TreeNode) *TreeNode
//	dfs = func(node, p, q *TreeNode) *TreeNode {
//		if node == nil || node.Val == p.Val || node.Val == q.Val {
//			return node
//		}
//		leftTarget := dfs(node.Left, p, q)
//		rightTarget := dfs(node.Right, p, q)
//		if leftTarget == nil {
//			return rightTarget
//		}
//		if rightTarget == nil {
//			return leftTarget
//		}
//		return node
//	}
//	return dfs(root, p, q)
//}
// 二叉树两个结点最短路径 = 最近公共祖先结点 + 祖先结点分别到这两个结点的路径和（父节点到某子节点的路径长度）
func lowestCommonAncestor(root, p, q *TreeNode) *TreeNode {
	parent := map[int]*TreeNode{} // K: 子结点数据 V：父节点
	visited := map[int]bool{}     // 表示已经访问过的结点
	var stack []*TreeNode
	curr := root
	for curr != nil || len(stack) != 0 {
		for curr != nil {
			if curr.Left != nil {
				parent[curr.Left.Val] = curr
			}
			stack = append(stack, curr)
			curr = curr.Left
		}

		curr = stack[len(stack)-1]
		stack = stack[:len(stack)-1]
		if curr.Right != nil {
			parent[curr.Right.Val] = curr
		}
		curr = curr.Right
	}
	for p != nil {
		visited[p.Val] = true
		p = parent[p.Val]
	}
	for q != nil {
		if visited[q.Val] == true {
			return q
		}
		q = parent[q.Val]
	}
	return nil
}

// 二叉搜索树
func lowestCommonAncestor2(root, p, q *TreeNode) *TreeNode {
	ancestor := root
	for true {
		if ancestor.Val < p.Val && ancestor.Val < q.Val {
			ancestor = ancestor.Right
		} else if ancestor.Val > p.Val && ancestor.Val > q.Val {
			ancestor = ancestor.Left
		} else {
			break
		}
	}
	return ancestor
}
