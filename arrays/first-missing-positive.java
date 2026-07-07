/*
Problem: First Missing Positive
Platform: LeetCode
Link: https://leetcode.com/problems/first-missing-positive/

Difficulty: Hard
Topics: Array, Hashing, Cyclic Sort

--------------------------------------------------

Approach (Cyclic Sort):
- Every positive integer x belongs at index (x - 1).
- Traverse the array:
    → If current number is in range [1, n]
    → And it is not already at its correct position
    → Swap it with its correct index.
- After rearranging:
    → Scan the array.
    → The first index where nums[i] != i + 1
      gives the smallest missing positive.
- If every position is correct, answer is n + 1.

--------------------------------------------------

Why this works:
- Places every valid positive number at its correct index.
- Missing positive is identified by the first mismatch.
- Achieves O(n) time without extra space.

--------------------------------------------------

Time Complexity: O(n)
Space Complexity: O(1)

--------------------------------------------------
*/

public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {

        int n = nums.length;
        int i = 0;

        // Place each number at its correct position
        while (i < n) {

            int correct = nums[i] - 1;

            if (nums[i] > 0 &&
                nums[i] <= n &&
                nums[i] != nums[correct]) {

                int temp = nums[i];
                nums[i] = nums[correct];
                nums[correct] = temp;

            } else {
                i++;
            }
        }

        // Find first missing positive
        for (i = 0; i < n; i++) {

            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return n + 1;
    }

    public static void main(String[] args) {
        FirstMissingPositive obj = new FirstMissingPositive();

        int[] nums = {3, 4, -1, 1};

        int result = obj.firstMissingPositive(nums);

        System.out.println(result); // Expected: 2
    }
}
