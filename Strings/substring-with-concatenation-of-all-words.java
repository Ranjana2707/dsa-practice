/*
Problem: Substring with Concatenation of All Words
Platform: LeetCode
Link: https://leetcode.com/problems/substring-with-concatenation-of-all-words/

Difficulty: Hard
Topics: String, Sliding Window, HashMap

--------------------------------------------------

Approach (Sliding Window + HashMap):
- Each word has fixed length → process string in chunks.
- Create a frequency map (wordCount) for given words.
- Iterate with different starting offsets (0 to wordLen-1).
- Use sliding window:
    → Extract word-sized substrings
    → Track counts using currentMap
- If frequency exceeds → shrink window from left.
- If count matches totalWords → valid index found.

--------------------------------------------------

Why this works:
- Fixed word size allows chunk-based traversal.
- Sliding window ensures efficient checking.
- HashMap maintains frequency constraints.

--------------------------------------------------

Time Complexity: O(n * wordLen)
Space Complexity: O(n)

--------------------------------------------------
*/

import java.util.*;

public class SubstringWithConcatenation {

    public List<Integer> findSubstring(String s, String[] words) {

        List<Integer> result = new ArrayList<>();

        if (s == null || s.length() == 0 || words.length == 0) {
            return result;
        }

        int wordLen = words[0].length();
        int totalWords = words.length;

        Map<String, Integer> wordCount = new HashMap<>();

        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        // Try all starting points within one word length
        for (int i = 0; i < wordLen; i++) {

            int left = i;
            int count = 0;
            Map<String, Integer> currentMap = new HashMap<>();

            for (int j = i; j + wordLen <= s.length(); j += wordLen) {

                String word = s.substring(j, j + wordLen);

                if (wordCount.containsKey(word)) {

                    currentMap.put(word, currentMap.getOrDefault(word, 0) + 1);
                    count++;

                    // If frequency exceeds, shrink window
                    while (currentMap.get(word) > wordCount.get(word)) {

                        String leftWord = s.substring(left, left + wordLen);
                        currentMap.put(leftWord, currentMap.get(leftWord) - 1);
                        left += wordLen;
                        count--;
                    }

                    // Valid window found
                    if (count == totalWords) {
                        result.add(left);
                    }

                } else {
                    currentMap.clear();
                    count = 0;
                    left = j + wordLen;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        SubstringWithConcatenation obj = new SubstringWithConcatenation();

        String s = "barfoothefoobarman";
        String[] words = {"foo", "bar"};

        List<Integer> result = obj.findSubstring(s, words);

        System.out.println(result); // Expected: [0, 9]
    }
}
