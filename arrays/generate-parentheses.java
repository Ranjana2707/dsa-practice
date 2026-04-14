/*
Problem: Generate Parentheses
Platform: LeetCode
Link: https://leetcode.com/problems/generate-parentheses/

Difficulty: Medium
Topics: String, Backtracking

--------------------------------------------------

Approach (Backtracking):
- Build combinations using recursion.
- Track:
    → open → number of '(' used
    → close → number of ')' used
- Rules:
    → open < n → can add '('
    → close < open → can add ')'
- When length == 2 * n → valid combination

--------------------------------------------------

Why this works:
- Ensures only valid parentheses are generated.
- Prunes invalid combinations early.
- Backtracking explores all valid possibilities.

--------------------------------------------------

Time Complexity: O(2^n)
Space Complexity: O(n)

--------------------------------------------------
*/

import java.util.*;

public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {

        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }

    private void backtrack(List<String> result, String current,
                           int open, int close, int n) {

        // Base case
        if (current.length() == 2 * n) {
            result.add(current);
            return;
        }

        // Add '('
        if (open < n) {
            backtrack(result, current + "(", open + 1, close, n);
        }

        // Add ')'
        if (close < open) {
            backtrack(result, current + ")", open, close + 1, n);
        }
    }

    public static void main(String[] args) {
        GenerateParentheses obj = new GenerateParentheses();

        int n = 3;
        List<String> result = obj.generateParenthesis(n);

        System.out.println(result);
        // Expected: ["((()))","(()())","(())()","()(())","()()()"]
    }
}
