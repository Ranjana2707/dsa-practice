/*
Problem: Single Number
Platform: LeetCode
Link: https://leetcode.com/problems/single-number/

Difficulty: Easy
Topics: Array, Bit Manipulation

--------------------------------------------------

Approach (Bit Manipulation - XOR):
- Initialize answer as 0.
- Traverse the array and perform XOR with each element.
- Duplicate numbers cancel each other out:
    → a ^ a = 0
- XOR with 0 returns the number itself:
    → a ^ 0 = a
- The remaining value is the single number.

--------------------------------------------------

Why this works:
- XOR operation removes all duplicate elements.
- Only the element that appears once remains.

--------------------------------------------------

Time Complexity: O(n)
Space Complexity: O(1)

--------------------------------------------------
*/

public class SingleNumber {

    public int singleNumber(int[] nums) {

        int ans = 0;

        for (int num : nums) {
            ans ^= num;
        }

        return ans;
    }

    public static void main(String[] args) {
        SingleNumber obj = new SingleNumber();

        int[] nums = {4, 1, 2, 1, 2};

        int result = obj.singleNumber(nums);

        System.out.println(result); // Expected: 4
    }
}
