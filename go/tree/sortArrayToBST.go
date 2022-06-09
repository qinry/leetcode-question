package tree

func sortedArrayToBST(nums []int) *TreeNode {
	var dfs func(nums []int, minIdx int, maxIdx int) *TreeNode
	dfs = func(nums []int, minIdx int, maxIdx int) *TreeNode {
		if minIdx > maxIdx {
			return nil
		}
		rootIdx := minIdx + (maxIdx-minIdx+1)/2
		root := TreeNode{Val: nums[rootIdx]}
		root.Left = dfs(nums, minIdx, rootIdx-1)
		root.Right = dfs(nums, rootIdx+1, maxIdx)
		return &root
	}
	return dfs(nums, 0, len(nums)-1)
}
