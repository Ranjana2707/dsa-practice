/*
Problem: Search in Rotated Sorted Array
Platform: LeetCode
Link: https://leetcode.com/problems/search-in-rotated-sorted-array/

Difficulty: Medium
Topics: Array, Binary Search

--------------------------------------------------

Approach (Modified Binary Search):
- Use binary search with low and high pointers.
- At each step:
    → One half of the array is always sorted.
- Check which half is sorted:
    1. If left half is sorted:
        → Check if target lies in this range
    2. Else right half is sorted:
        → Check if target lies in this range
- Narrow search space accordingly.

--------------------------------------------------

Why this works:
- Even after rotation, at least one half remains sorted.
- Allows binary search logic to still apply.

--------------------------------------------------

Time Complexity: O(log n)
Space Complexity: O(1)

--------------------------------------------------
*/

public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {

        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            // Left half is sorted
            if (nums[low] <= nums[mid]) {

                if (target >= nums[low] && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }

            } 
            // Right half is sorted
            else {

                if (target > nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArray obj = new SearchInRotatedSortedArray();

        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;

        int result = obj.search(nums, target);

        System.out.println(result); // Expected: 4
    }
}
