package tree

type BSTIterator struct {
	curr  *TreeNode
	stack []*TreeNode
}

func Constructor(root *TreeNode) BSTIterator {
	return BSTIterator{curr: root}
}

func (this *BSTIterator) Next() int {
	for this.curr != nil {
		this.stack = append(this.stack, this.curr)
		this.curr = this.curr.Left
	}
	this.curr = this.stack[len(this.stack)-1]
	this.stack = this.stack[:len(this.stack)-1]
	result := this.curr.Val
	this.curr = this.curr.Right
	return result
}

func (this *BSTIterator) HasNext() bool {
	return this.curr != nil || len(this.stack) != 0
}
