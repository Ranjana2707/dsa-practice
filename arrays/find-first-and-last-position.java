/*
Problem: Find First and Last Position of Element in Sorted Array
Platform: LeetCode
Link: https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

Difficulty: Medium
Topics: Array, Binary Search

--------------------------------------------------

Approach (Binary Search - Boundary Finding):
- Perform two binary searches:
    → findFirst: first occurrence (left boundary)
    → findLast: last occurrence (right boundary)
- For first:
    → Move left when match found
- For last:
    → Move right when match found

--------------------------------------------------

Why this works:
- Binary search can be modified to find boundaries.
- Instead of stopping at match:
    → Continue searching in one direction.

--------------------------------------------------

Time Complexity: O(log n)
Space Complexity: O(1)

--------------------------------------------------
*/

public class FindFirstAndLastPosition {

    public int[] searchRange(int[] nums, int target) {

        int first = findFirst(nums, target);
        int last = findLast(nums, target);

        return new int[]{first, last};
    }

    private int findFirst(int[] nums, int target) {

        int low = 0, high = nums.length - 1;
        int ans = -1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                ans = mid;
                high = mid - 1; // move left
            }
            else if (nums[mid] < target) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        return ans;
    }

    private int findLast(int[] nums, int target) {

        int low = 0, high = nums.length - 1;
        int ans = -1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                ans = mid;
                low = mid + 1; // move right
            }
            else if (nums[mid] < target) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        FindFirstAndLastPosition obj = new FindFirstAndLastPosition();

        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;

        int[] result = obj.searchRange(nums, target);

        System.out.println(result[0] + ", " + result[1]); // Expected: 3, 4
    }
}
