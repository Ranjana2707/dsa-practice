/*
Problem: Remove Duplicates from Sorted Array
Platform: LeetCode
Link: https://leetcode.com/problems/remove-duplicates-from-sorted-array/

Difficulty: Easy
Topics: Array, Two Pointers

--------------------------------------------------

Approach (Two Pointers - In-place):
- Use two pointers:
    → i → slow pointer (tracks unique elements)
    → j → fast pointer (traverses array)
- Compare nums[j] with nums[i]:
    → If different → move i forward and update nums[i]
- Return i + 1 as length of unique elements

--------------------------------------------------

Why this works:
- Array is sorted → duplicates are adjacent
- Allows in-place removal without extra space

--------------------------------------------------

Time Complexity: O(n)
Space Complexity: O(1)

--------------------------------------------------
*/

public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {

        if (nums.length == 0) return 0;

        int i = 0;

        for (int j = 1; j < nums.length; j++) {

            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }

        return i + 1;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray obj = new RemoveDuplicatesFromSortedArray();

        int[] nums = {1, 1, 2};
        int k = obj.removeDuplicates(nums);

        System.out.println(k); // Expected: 2

        // Print modified array
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
