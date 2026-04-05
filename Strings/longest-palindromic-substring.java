/*
Problem: Longest Palindromic Substring
Platform: LeetCode
Link: https://leetcode.com/problems/longest-palindromic-substring/

Difficulty: Medium
Topics: String

--------------------------------------------------

Approach (Expand Around Center):
- A palindrome mirrors around its center.
- For each index, consider:
    → Odd length palindrome (center = i)
    → Even length palindrome (center = i, i+1)
- Expand outward while characters match.
- Track the longest palindrome using start and end indices.

--------------------------------------------------

Why this works:
- Every palindrome has a center.
- Expanding from center ensures all cases are checked.
- Avoids brute force substring checking (O(n³)).

--------------------------------------------------

Time Complexity: O(n²)
Space Complexity: O(1)

--------------------------------------------------
*/

public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {

        if (s == null || s.length() < 1) {
            return "";
        }

        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {

            int len1 = expand(s, i, i);       // odd length
            int len2 = expand(s, i, i + 1);   // even length

            int len = Math.max(len1, len2);

            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private int expand(String s, int left, int right) {

        while (left >= 0 && right < s.length()
                && s.charAt(left) == s.charAt(right)) {

            left--;
            right++;
        }

        return right - left - 1;
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring obj = new LongestPalindromicSubstring();

        String input = "babad";
        String result = obj.longestPalindrome(input);

        System.out.println(result); // "bab" or "aba"
    }
}
