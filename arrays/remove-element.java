/*
Problem: Remove Element
Platform: LeetCode
Link: https://leetcode.com/problems/remove-element/

Difficulty: Easy
Topics: Array, Two Pointers

--------------------------------------------------

Approach (Two Pointers - In-place Filtering):
- Use pointer k to track position of valid elements.
- Traverse array:
    → If nums[i] != val → copy to nums[k], increment k
- Return k as new length.

--------------------------------------------------

Why this works:
- We overwrite unwanted elements (val) in-place.
- No need for extra space.
- Order of remaining elements is preserved.

--------------------------------------------------

Time Complexity: O(n)
Space Complexity: O(1)

--------------------------------------------------
*/

public class RemoveElement {

    public int removeElement(int[] nums, int val) {

        int k = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }

    public static void main(String[] args) {
        RemoveElement obj = new RemoveElement();

        int[] nums = {3, 2, 2, 3};
        int val = 3;

        int k = obj.removeElement(nums, val);

        System.out.println(k); // Expected: 2

        // Print modified array
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
