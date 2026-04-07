/*
Problem: Length of Last Word
Platform: LeetCode
Link: https://leetcode.com/problems/length-of-last-word/

Difficulty: Easy
Topics: String

--------------------------------------------------

Approach (Reverse Traversal):
- Start from end of string.
- Skip trailing spaces.
- Count characters until next space or start of string.

--------------------------------------------------

Why this works:
- Last word is at the end of string.
- Skipping spaces ensures correct counting.
- No need to split string → more efficient.

--------------------------------------------------

Time Complexity: O(n)
Space Complexity: O(1)

--------------------------------------------------
*/

public class LengthOfLastWord {

    public int lengthOfLastWord(String s) {

        int i = s.length() - 1;
        int length = 0;

        // Skip trailing spaces
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }

        // Count last word
        while (i >= 0 && s.charAt(i) != ' ') {
            length++;
            i--;
        }

        return length;
    }

    public static void main(String[] args) {
        LengthOfLastWord obj = new LengthOfLastWord();

        String input = "Hello World";
        int result = obj.lengthOfLastWord(input);

        System.out.println(result); // Expected: 5
    }
}
