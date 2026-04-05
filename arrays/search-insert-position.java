/*
Problem: Search Insert Position
Platform: LeetCode
Link: https://leetcode.com/problems/search-insert-position/

Difficulty: Easy
Topics: Array, Binary Search

--------------------------------------------------

Approach (Binary Search):
- Use standard binary search.
- If target is found → return index.
- If not found:
    → left pointer ends at correct insertion position.
- Return left.

--------------------------------------------------

Why this works:
- Binary search narrows down position efficiently.
- When loop ends:
    → left points to first element ≥ target.

--------------------------------------------------

Time Complexity: O(log n)
Space Complexity: O(1)

--------------------------------------------------
*/

public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } 
            else if (nums[mid] < target) {
                left = mid + 1;
            } 
            else {
                right = mid - 1;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        SearchInsertPosition obj = new SearchInsertPosition();

        int[] nums = {1, 3, 5, 6};
        int target = 2;

        int result = obj.searchInsert(nums, target);

        System.out.println(result); // Expected: 1
    }
}
