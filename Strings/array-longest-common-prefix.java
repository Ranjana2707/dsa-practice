/*
Problem: Longest Common Prefix
Platform: LeetCode
Link: https://leetcode.com/problems/longest-common-prefix/

Difficulty: Easy
Topics: String

--------------------------------------------------

Approach (Horizontal Scanning):
- Take the first string as initial prefix.
- Compare it with each string in the array.
- While current string does not start with prefix:
    → Reduce prefix by removing last character.
- Continue until prefix matches all strings.

--------------------------------------------------

Why this works:
- Common prefix can only shrink, never grow.
- Efficiently eliminates mismatches step by step.

--------------------------------------------------

Time Complexity: O(n * m)
(n = number of strings, m = length of prefix)

Space Complexity: O(1)

--------------------------------------------------
*/

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0) {
            return "";
        }

        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {

            while (!strs[i].startsWith(prefix)) {

                prefix = prefix.substring(0, prefix.length() - 1);

                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }

        return prefix;
    }

    public static void main(String[] args) {
        LongestCommonPrefix obj = new LongestCommonPrefix();

        String[] input = {"flower", "flow", "flight"};
        String result = obj.longestCommonPrefix(input);

        System.out.println(result); // Expected: "fl"
    }
}
