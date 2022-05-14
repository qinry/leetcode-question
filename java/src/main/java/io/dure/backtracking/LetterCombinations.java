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

        backtracking(digits, digitToLetters, 0, new StringBuilder(), result);
        return result;
    }

    private void backtracking(String digits, Map<String,String> digitToLetters, int idx,
                              StringBuilder combination, List<String> combinations) {
        if (idx == digits.length()) {
            combinations.add(combination.toString());
        } else if (idx < digits.length()){
            String letters = digitToLetters.get(digits.substring(idx, idx+1));
            for (int i = 0; i < letters.length(); i++) {
                combination.append(letters.charAt(i));
                backtracking(digits, digitToLetters, idx+1, combination, combinations);
                combination.deleteCharAt(idx);
            }
        }
    }


}
