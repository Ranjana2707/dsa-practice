/*
Problem: Letter Combinations of a Phone Number
Platform: LeetCode
Link: https://leetcode.com/problems/letter-combinations-of-a-phone-number/

Difficulty: Medium
Topics: String, Backtracking

--------------------------------------------------

Approach (Backtracking):
- Each digit maps to a set of characters.
- Generate all possible combinations using recursion.
- At each step:
    → Pick a character from current digit
    → Move to next digit
- Backtrack after exploring each choice.

--------------------------------------------------

Why this works:
- Problem requires generating all combinations → typical backtracking.
- We explore all possible paths (decision tree).
- Backtracking ensures we reuse the same structure efficiently.

--------------------------------------------------

Time Complexity: O(4^n)
Space Complexity: O(n)

--------------------------------------------------
*/

import java.util.*;

public class LetterCombinationsPhoneNumber {

    public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();

        if (digits.length() == 0) {
            return result;
        }

        String[] map = {
            "", "", "abc", "def", "ghi",
            "jkl", "mno", "pqrs", "tuv", "wxyz"
        };

        backtrack(digits, 0, new StringBuilder(), result, map);

        return result;
    }

    private void backtrack(String digits, int index, StringBuilder current,
                           List<String> result, String[] map) {

        // Base case
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        String letters = map[digits.charAt(index) - '0'];

        for (char c : letters.toCharArray()) {

            current.append(c);  // choose
            backtrack(digits, index + 1, current, result, map);
            current.deleteCharAt(current.length() - 1); // backtrack
        }
    }

    public static void main(String[] args) {
        LetterCombinationsPhoneNumber obj = new LetterCombinationsPhoneNumber();

        String input = "23";
        List<String> result = obj.letterCombinations(input);

        System.out.println(result); // [ad, ae, af, bd, be, bf, cd, ce, cf]
    }
}
