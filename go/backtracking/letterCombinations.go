package main

func letterCombinations(digits string) []string {
	var digitToLetters map[string]string = map[string]string{
		"2": "abc",
		"3": "def",
		"4": "ghi",
		"5": "jkl",
		"6": "mno",
		"7": "pqrs",
		"8": "tuv",
		"9": "wxyz",
	}
	var combinations []string
	var backtracking func(digits string, digitToLetters map[string]string, idx int, combination string)
	backtracking = func(digits string, digitToLetters map[string]string, idx int, combination string) {
		if idx == len(digits) {
			combinations = append(combinations, combination)
		} else if idx < len(digits) {
			letters := digitToLetters[digits[idx:idx+1]]
			letterCount := len(letters)
			for i := 0; i < letterCount; i++ {
				backtracking(digits, digitToLetters, idx+1, combination+string(letters[i]))
			}
		}
	}
	if len(digits) != 0 {
		backtracking(digits, digitToLetters, 0, "")
	}

	return combinations
}
