package tree

func generateTrees(n int) []*TreeNode {
	if n == 0 {
		return []*TreeNode{}
	}
	var recursive func(start, end int) []*TreeNode
	recursive = func(start, end int) []*TreeNode {
		allTrees := []*TreeNode{}
		if start > end {
			allTrees = append(allTrees, nil)
			return allTrees
		}
		for i := start; i <= end; i++ {
			leftTrees := recursive(start, i-1)
			rightTrees := recursive(i+1, end)
			for _, left := range leftTrees {
				for _, right := range rightTrees {
					root := TreeNode{Val: i}
					root.Val = i
					root.Left = left
					root.Right = right
					allTrees = append(allTrees, &root)
				}
			}
		}
		return allTrees
	}
	return recursive(1, n)
}
