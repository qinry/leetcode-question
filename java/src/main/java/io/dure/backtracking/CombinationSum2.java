package io.dure.backtracking;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> combination = new LinkedList<>();
        if (candidates == null || candidates.length == 0) {
            return combination;
        }
        Arrays.sort(candidates);
        backtracking(candidates, target,  0, new LinkedList<>(), combination);
        return combination;
    }
    private void backtracking(int[] candidates, int target, int idx, List<Integer> subset, List<List<Integer>> combination) {
        if (target == 0) {
            combination.add(new LinkedList<>(subset));
        } else if (target > 0 && idx < candidates.length) {
            backtracking(candidates, target, getNext(candidates, idx), subset, combination);

            subset.add(candidates[idx]);
            backtracking(candidates, target - candidates[idx], idx+1, subset, combination);
            subset.remove(subset.size() - 1);
        }
    }
    private int getNext(int[] candidates, int idx) {
        int next = idx;
        while (next < candidates.length && candidates[next] == candidates[idx]) {
            next++;
        }

        return next;
    }

    public static void main(String[] args) {
        int[] candidates = { 3, 1, 3, 5, 1, 1 };
        int target = 8;
        CombinationSum2 combinationSum2 = new CombinationSum2();
        List<List<Integer>> result = combinationSum2.combinationSum2(candidates, target);
        System.out.println(result);
    }
}
