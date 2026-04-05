/*
Problem: Valid Parentheses
Platform: LeetCode
Link: https://leetcode.com/problems/valid-parentheses/

Difficulty: Easy
Topics: String, Stack

--------------------------------------------------

Approach (Using Stack):
- Traverse each character of the string.
- If it's an opening bracket:
    → Push its corresponding closing bracket onto stack.
- If it's a closing bracket:
    → Check if stack is empty OR top doesn't match → return false.
- At the end:
    → Stack should be empty for valid parentheses.

--------------------------------------------------

Why this works:
- Stack follows LIFO → matches nested structure of brackets.
- Storing expected closing brackets simplifies comparison.

--------------------------------------------------

Time Complexity: O(n)
Space Complexity: O(n)

--------------------------------------------------
*/

import java.util.Stack;

public class ValidParentheses {

    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {

            if (c == '(') stack.push(')');
            else if (c == '{') stack.push('}');
            else if (c == '[') stack.push(']');
            else {

                if (stack.isEmpty() || stack.pop() != c) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParentheses obj = new ValidParentheses();

        String input = "()[]{}";
        boolean result = obj.isValid(input);

        System.out.println(result); // true
    }
}
