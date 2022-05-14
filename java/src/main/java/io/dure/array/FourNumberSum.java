package io.dure.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourNumberSum {

    public List<List<Integer>> fourNumberSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> quadruplets = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; ) {
            for (int j = i + 1; j < nums.length - 2; ) {
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    int currentSum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (currentSum == target) {
                        quadruplets.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[++left]);
                        right--;
                    } else if (currentSum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
                while (j < nums.length - 2 && nums[j] == nums[++j]);
            }
            while (i < nums.length - 3 && nums[i] == nums[++i]);
        }
        return quadruplets;
    }
}
