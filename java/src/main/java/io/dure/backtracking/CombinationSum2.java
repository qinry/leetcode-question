package io.dure.backtracking;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> combinations = new LinkedList<>();
        if (candidates == null || candidates.length == 0) {
            return combinations;
        }
        Arrays.sort(candidates);
        backtracking(candidates, target,  0, new LinkedList<>(), combinations);
        return combinations;
    }
    private void backtracking(int[] candidates, int target, int idx, List<Integer> combination, List<List<Integer>> combinations) {
        if (target == 0) {
            combinations.add(new LinkedList<>(combination));
        } else if (target > 0 && idx < candidates.length) {
            backtracking(candidates, target, getNext(candidates, idx), combination, combinations);

            combination.add(candidates[idx]);
            backtracking(candidates, target - candidates[idx], idx+1, combination, combinations);
            combination.remove(combination.size() - 1);
        }
    }
    private int getNext(int[] candidates, int idx) {
        int next = idx;
        while (next < candidates.length && candidates[next] == candidates[idx]) {
            next++;
        }

        return next;
    }

}
