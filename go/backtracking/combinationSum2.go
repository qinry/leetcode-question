package main

import (
	"sort"
)

func combinationSum2(candidates []int, target int) [][]int {
	var combinations [][]int
	if len(candidates) == 0 {
		return combinations
	}
	sort.Ints(candidates)
	combination := []int{}
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
			temp := make([]int, len(combination))
			copy(temp, combination)
			combinations = append(combinations, temp)
		} else if target > 0 && idx < len(candidates) {
			backtracking(target, getNext(idx))
			combination = append(combination, candidates[idx])
			backtracking(target-candidates[idx], idx+1)
			combination = combination[:len(combination)-1]
		}
	}
	backtracking(target, 0)
	return combinations
}
