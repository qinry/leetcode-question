package array

import (
	"sort"
)

func fourNumberSum(nums []int, target int) [][]int {
	sort.Ints(nums)
	var quadruplets [][]int
	for i := 0; i < len(nums)-3; {
		for j := i + 1; j < len(nums)-2; {
			left := j + 1
			right := len(nums) - 1
			for left < right {
				currentSum := nums[i] + nums[j] + nums[left] + nums[right]
				if currentSum == target {
					quadruplets = append(quadruplets, []int{nums[i], nums[j], nums[left], nums[right]})
					temp := nums[left]
					for left < right && temp == nums[left] {
						left++
					}
					right--
				} else if currentSum < target {
					left++
				} else {
					right--
				}
			}
			temp := nums[j]
			for j < len(nums)-2 && temp == nums[j] {
				j++
			}
		}
		temp := nums[i]
		for i < len(nums)-1 && temp == nums[i] {
			i++
		}

	}
	return quadruplets
}
