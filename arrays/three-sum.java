/*
Problem: 3Sum
Platform: LeetCode
Link: https://leetcode.com/problems/3sum/

Difficulty: Medium
Topics: Array, Two Pointers, Sorting

--------------------------------------------------

Approach (Sorting + Two Pointers):
- Sort the array.
- Fix one element (i) and use two pointers:
    → left = i + 1
    → right = end
- Calculate sum:
    → If sum == 0 → store triplet
    → If sum < 0 → move left++
    → If sum > 0 → move right--
- Skip duplicates to avoid repeated triplets.

--------------------------------------------------

Why this works:
- Sorting allows efficient two-pointer traversal.
- Eliminates need for brute force O(n³).
- Duplicate skipping ensures unique triplets.

--------------------------------------------------

Time Complexity: O(n²)
Space Complexity: O(1) (excluding output)

--------------------------------------------------
*/

import java.util.*;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {

            // Skip duplicate elements
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {

                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {

                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Skip duplicates
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;

                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        ThreeSum obj = new ThreeSum();

        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = obj.threeSum(nums);

        System.out.println(result); // [[-1, -1, 2], [-1, 0, 1]]
    }
}
