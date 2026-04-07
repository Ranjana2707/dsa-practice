/*
Problem: Regular Expression Matching
Platform: LeetCode
Link: https://leetcode.com/problems/regular-expression-matching/

Difficulty: Hard
Topics: String, Dynamic Programming, Recursion

--------------------------------------------------

Approach (Recursion + Memoization):
- Use recursion to match characters of s and p.
- Use dp[i][j] to store results (memoization).

At each step:
1. Check if characters match:
    → s[i] == p[j] OR p[j] == '.'

2. If next character in pattern is '*':
    → Two choices:
        a) Skip pattern (j + 2)
        b) Use '*' if match → move i forward

3. If no '*':
    → Move both pointers if match

--------------------------------------------------

Why this works:
- '*' allows multiple possibilities → recursion explores both.
- Memoization avoids recomputation → reduces complexity.

--------------------------------------------------

Time Complexity: O(m * n)
Space Complexity: O(m * n)

--------------------------------------------------
*/

public class RegularExpressionMatching {

    public boolean isMatch(String s, String p) {

        Boolean[][] dp = new Boolean[s.length() + 1][p.length() + 1];
        return helper(s, p, 0, 0, dp);
    }

    private boolean helper(String s, String p, int i, int j, Boolean[][] dp) {

        if (dp[i][j] != null) return dp[i][j];

        // If pattern ends
        if (j == p.length()) {
            return dp[i][j] = (i == s.length());
        }

        boolean firstMatch = (i < s.length() &&
                (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'));

        // If next is '*'
        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {

            dp[i][j] = helper(s, p, i, j + 2, dp) ||
                       (firstMatch && helper(s, p, i + 1, j, dp));
        } 
        else {
            dp[i][j] = firstMatch && helper(s, p, i + 1, j + 1, dp);
        }

        return dp[i][j];
    }

    public static void main(String[] args) {
        RegularExpressionMatching obj = new RegularExpressionMatching();

        String s = "aab";
        String p = "c*a*b";

        boolean result = obj.isMatch(s, p);

        System.out.println(result); // Expected: true
    }
}
