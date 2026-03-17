/*
Problem: Valid Palindrome
Platform: LeetCode
Link: https://leetcode.com/problems/valid-palindrome/

Difficulty: Easy
Topics: String, Two Pointers

--------------------------------------------------

Approach (Two Pointer Technique):
- Use two pointers: left (start) and right (end).
- Ignore non-alphanumeric characters using Character.isLetterOrDigit().
- Compare characters in lowercase for case-insensitive matching.
- Move pointers inward after each comparison.

--------------------------------------------------

Why this works:
- We only compare relevant characters.
- Two-pointer approach avoids extra space.
- Efficient single-pass traversal.

--------------------------------------------------

Time Complexity: O(n)
Space Complexity: O(1)

--------------------------------------------------
*/

public class PalindromeCheck {

    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;

        while (left < right) {

            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }

            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            if (Character.toLowerCase(s.charAt(left)) !=
                Character.toLowerCase(s.charAt(right))) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        PalindromeCheck obj = new PalindromeCheck();

        String input = "A man, a plan, a canal: Panama";
        boolean result = obj.isPalindrome(input);

        System.out.println(result); // true
    }
}
