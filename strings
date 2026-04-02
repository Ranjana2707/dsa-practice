/*
Problem: Longest Substring Without Repeating Characters
Platform: LeetCode
Link: https://leetcode.com/problems/longest-substring-without-repeating-characters/

Difficulty: Medium
Topics: String, Sliding Window, HashSet

--------------------------------------------------

Approach (Sliding Window):
- Use two pointers: left and right to maintain a window.
- Use a HashSet to store unique characters in the current window.
- Expand window by moving right pointer.
- If duplicate found:
    → Shrink window from left until duplicate is removed.
- Track maximum window size.

--------------------------------------------------

Why this works:
- Sliding window ensures we check only valid substrings.
- HashSet gives O(1) lookup for duplicates.
- Avoids brute force O(n²) approach.

--------------------------------------------------

Time Complexity: O(n)
Space Complexity: O(min(n, charset))

--------------------------------------------------
*/

import java.util.*;

public class LongestSubstringWithoutRepeating {

    public int lengthOfLongestSubstring(String s) {

        Set<Character> set = new HashSet<>();
        int left = 0, maxLength = 0;

        for (int right = 0; right < s.length(); right++) {

            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }

            set.add(s.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeating obj = new LongestSubstringWithoutRepeating();

        String input = "abcabcbb";
        int result = obj.lengthOfLongestSubstring(input);

        System.out.println(result); // Expected: 3
    }
}
