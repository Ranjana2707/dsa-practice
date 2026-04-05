/*
Problem: Next Permutation
Platform: LeetCode
Link: https://leetcode.com/problems/next-permutation/

Difficulty: Medium
Topics: Array

--------------------------------------------------

Approach:
1. Find first decreasing element from right (i):
    → nums[i] < nums[i + 1]

2. If found:
    - Find element just greater than nums[i] from right (j)
    - Swap nums[i] and nums[j]

3. Reverse the subarray from i+1 to end

--------------------------------------------------

Why this works:
- We find the next lexicographically greater permutation.
- Reversing ensures smallest possible order after swap.

--------------------------------------------------

Time Complexity: O(n)
Space Complexity: O(1)

--------------------------------------------------
*/

public class NextPermutation {

    public void nextPermutation(int[] nums) {

        int i = nums.length - 2;

        // Step 1: Find first decreasing element
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        // Step 2: Swap with just larger element
        if (i >= 0) {

            int j = nums.length - 1;

            while (nums[j] <= nums[i]) {
                j--;
            }

            swap(nums, i, j);
        }

        // Step 3: Reverse right part
        reverse(nums, i + 1, nums.length - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start++, end--);
        }
    }

    public static void main(String[] args) {
        NextPermutation obj = new NextPermutation();

        int[] nums = {1, 2, 3};
        obj.nextPermutation(nums);

        for (int num : nums) {
            System.out.print(num + " ");
        }
        // Expected: 1 3 2
    }
}
