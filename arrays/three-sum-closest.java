/*
Problem: 3Sum Closest
Platform: LeetCode
Link: https://leetcode.com/problems/3sum-closest/

Difficulty: Medium
Topics: Array, Two Pointers, Sorting

--------------------------------------------------

Approach (Sorting + Two Pointers):
- Sort the array.
- Fix one element (i) and use two pointers:
    → left = i + 1
    → right = end
- Calculate sum:
    → Update closestSum if current sum is nearer to target.
    → If sum < target → move left++
    → If sum > target → move right--
    → If sum == target → return immediately

--------------------------------------------------

Why this works:
- Sorting enables efficient two-pointer traversal.
- Avoids brute force O(n³).
- Continuously tracks the closest possible sum.

--------------------------------------------------

Time Complexity: O(n²)
Space Complexity: O(1)

--------------------------------------------------
*/

import java.util.Arrays;

public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);

        int closestSum = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length - 2; i++) {

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {

                int sum = nums[i] + nums[left] + nums[right];

                // Update closest sum
                if (Math.abs(sum - target) < Math.abs(closestSum - target)) {
                    closestSum = sum;
                }

                if (sum < target) {
                    left++;
                } 
                else if (sum > target) {
                    right--;
                } 
                else {
                    return sum; // exact match
                }
            }
        }

        return closestSum;
    }

    public static void main(String[] args) {
        ThreeSumClosest obj = new ThreeSumClosest();

        int[] nums = {-1, 2, 1, -4};
        int target = 1;

        int result = obj.threeSumClosest(nums, target);

        System.out.println(result); // Expected: 2
    }
}
