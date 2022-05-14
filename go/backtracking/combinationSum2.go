package main

import (
	"sort"
)

func combinationSum2(candidates []int, target int) [][]int {
	var result [][]int
	if len(candidates) == 0 {
		return result
	}
	sort.Ints(candidates)
	subset := []int{}
	var getNext func(idx int) int
	getNext = func(idx int) int {
		next := idx
		for next < len(candidates) && candidates[idx] == candidates[next] {
			next++
		}
		return next
	}
	var backtracking func(target, idx int)
	backtracking = func(target, idx int) {
		if target == 0 {
			temp := make([]int, len(subset))
			copy(temp, subset)
			result = append(result, temp)
		} else if target > 0 && idx < len(candidates) {
			backtracking(target, getNext(idx))
			subset = append(subset, candidates[idx])
			backtracking(target-candidates[idx], idx+1)
			subset = subset[:len(subset)-1]
		}
	}
	backtracking(target, 0)
	return result
}
