package tree

func buildTreeByPreorderAndInorder(preorder []int, inorder []int) *TreeNode {
	var dfs func(preorder []int, inorder []int, numToIdx map[int]int, preStart int, preEnd int, inStart int, inEnd int) *TreeNode
	dfs = func(preorder []int, inorder []int, numToIdx map[int]int, preStart int, preEnd int, inStart int, inEnd int) *TreeNode {
		if preStart > preEnd {
			return nil
		}
		rootVal := preorder[preStart]
		rootIdx := numToIdx[rootVal]
		root := TreeNode{Val: rootVal}
		leftNum := rootIdx - inStart
		root.Left = dfs(preorder, inorder, numToIdx, preStart+1, preStart+leftNum, inStart, rootIdx-1)
		root.Right = dfs(preorder, inorder, numToIdx, preStart+leftNum+1, preEnd, rootIdx+1, inEnd)
		return &root
	}
	numToIdx := map[int]int{}
	for idx, num := range inorder {
		numToIdx[num] = idx
	}
	return dfs(preorder, inorder, numToIdx, 0, len(preorder)-1, 0, len(inorder)-1)
}

func buildTreeByInorderAndPostorder(inorder []int, postorder []int) *TreeNode {
	var dfs func(inorder []int, postorder []int, numToIdx map[int]int, inStart int, inEnd int, postStart int, postEnd int) *TreeNode
	dfs = func(inorder []int, postorder []int, numToIdx map[int]int, inStart int, inEnd int, postStart int, postEnd int) *TreeNode {
		if inStart > inEnd {
			return nil
		}
		rootVal := postorder[postEnd]
		rootIdx := numToIdx[rootVal]
		root := TreeNode{Val: rootVal}
		rightNum := inEnd - rootIdx
		root.Left = dfs(inorder, postorder, numToIdx, inStart, rootIdx-1, postStart, postEnd-rightNum-1)
		root.Right = dfs(inorder, postorder, numToIdx, rootIdx+1, inEnd, postEnd-rightNum, postEnd-1)
		return &root
	}
	numToIdx := map[int]int{}
	for idx, num := range inorder {
		numToIdx[num] = idx
	}
	return dfs(inorder, postorder, numToIdx, 0, len(inorder)-1, 0, len(postorder)-1)
}
