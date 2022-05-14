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
	var result []string
	var backtracking func(digits string, digitToLetters map[string]string, idx int, subset string, result *[]string)
	backtracking = func(digits string, digitToLetters map[string]string, idx int, subset string, result *[]string) {
		if idx == len(digits) {
			*result = append(*result, subset)
		} else if idx < len(digits) {
			digit := string(digits[idx])
			letters := digitToLetters[digit]
			letterCount := len(digitToLetters[digit])
			for i := 0; i < letterCount; i++ {
				subset = subset + string(letters[i])
				backtracking(digits, digitToLetters, idx+1, subset, result)
				subset = subset[:len(subset)-1]
			}
		}
	}
	if len(digits) != 0 {
		backtracking(digits, digitToLetters, 0, "", &result)
	}

	return result
}
