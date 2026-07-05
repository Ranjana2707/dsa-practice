/*
Problem: Longest Valid Parentheses
Platform: LeetCode
Link: https://leetcode.com/problems/longest-valid-parentheses/

Difficulty: Medium
Topics: String, Stack, Dynamic Programming

--------------------------------------------------

Approach (Stack):
- Use a stack to store indices.
- Push -1 initially as a base index.
- Traverse the string:
    → If '(' → push its index.
    → If ')' → pop the stack.
- If stack becomes empty:
    → Push current index as new base.
- Otherwise:
    → Calculate current valid length using:
      currentLength = i - stack.peek()
- Track the maximum valid length.

--------------------------------------------------

Why this works:
- The stack stores indices of unmatched parentheses.
- The base index (-1 or the latest unmatched ')')
  helps calculate the length of valid substrings.

--------------------------------------------------

Time Complexity: O(n)
Space Complexity: O(n)

--------------------------------------------------
*/

import java.util.Stack;

public class LongestValidParentheses {

    public int longestValidParentheses(String s) {

        Stack<Integer> stack = new Stack<>();

        // Base index before the string starts
        stack.push(-1);

        int max = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {

                stack.push(i);

            } else {

                stack.pop();

                if (stack.isEmpty()) {

                    // New base index
                    stack.push(i);

                } else {

                    max = Math.max(max, i - stack.peek());

                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        LongestValidParentheses obj = new LongestValidParentheses();

        String input = ")()())";

        int result = obj.longestValidParentheses(input);

        System.out.println(result); // Expected: 4
    }
}
