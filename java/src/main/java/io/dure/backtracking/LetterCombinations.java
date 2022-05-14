package io.dure.backtracking;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LetterCombinations {
    public List<String> letterCombinations(String digits) {
        Map<String,String> digitToLetters = new HashMap<>();
        digitToLetters.put("2", "abc");
        digitToLetters.put("3", "def");
        digitToLetters.put("4", "ghi");
        digitToLetters.put("5", "jkl");
        digitToLetters.put("6", "mno");
        digitToLetters.put("7", "pqrs");
        digitToLetters.put("8", "tuv");
        digitToLetters.put("9", "wxyz");
        List<String> result = new LinkedList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }

        helper(digits, digitToLetters, 0, new StringBuilder(), result);
        return result;
    }

    private void helper(String digits, Map<String,String> digitToLetters, int idx,
                        StringBuilder subset, List<String> result) {
        if (idx == digits.length()) {
            result.add(subset.toString());
        } else if (idx < digits.length()){
            String letters = digitToLetters.get(digits.substring(idx, idx+1));
            for (int i = 0; i < letters.length(); i++) {
                subset.append(letters.charAt(i));
                helper(digits, digitToLetters, idx+1, subset, result);
                subset.deleteCharAt(idx);
            }
        }
    }


}
