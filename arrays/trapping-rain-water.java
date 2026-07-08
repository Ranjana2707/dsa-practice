/*
Problem: Trapping Rain Water
Platform: LeetCode
Link: https://leetcode.com/problems/trapping-rain-water/

Difficulty: Hard
Topics: Array, Two Pointers

--------------------------------------------------

Approach (Two Pointers):
- Initialize two pointers:
    → left at the beginning
    → right at the end
- Maintain:
    → leftMax = highest bar seen from left
    → rightMax = highest bar seen from right
- Move the pointer with the smaller height:
    → If current height is smaller than its maximum,
      trapped water = maxHeight - currentHeight.
    → Otherwise, update the maximum height.
- Continue until both pointers meet.

--------------------------------------------------

Why this works:
- Water trapped at any position depends on the
  smaller of the left and right maximum heights.
- The smaller side determines the water level,
  allowing us to process the array in one pass.

--------------------------------------------------

Time Complexity: O(n)
Space Complexity: O(1)

--------------------------------------------------
*/

public class TrappingRainWater {

    public int trap(int[] height) {

        int left = 0;
        int right = height.length - 1;

        int leftMax = 0;
        int rightMax = 0;

        int water = 0;

        while (left < right) {

            if (height[left] < height[right]) {

                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    water += leftMax - height[left];
                }

                left++;

            } else {

                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    water += rightMax - height[right];
                }

                right--;
            }
        }

        return water;
    }

    public static void main(String[] args) {
        TrappingRainWater obj = new TrappingRainWater();

        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};

        int result = obj.trap(height);

        System.out.println(result); // Expected: 6
    }
}
