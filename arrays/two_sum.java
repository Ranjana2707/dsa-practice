/*
Problem: Two Sum
Platform: LeetCode
Link: https://leetcode.com/problems/two-sum/

Difficulty: Easy
Topic: Array, HashMap

--------------------------------------------------

Approach:
1. Use a HashMap to store numbers and their indices.
2. Traverse the array.
3. For each element, calculate complement = target - nums[i].
4. If the complement exists in the map, return the indices.
5. Otherwise store the current number and its index in the map.

--------------------------------------------------

Time Complexity: O(n)
Space Complexity: O(n)

--------------------------------------------------
*/

import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }

            map.put(nums[i], i);
        }

        return new int[]{};
    }
}
