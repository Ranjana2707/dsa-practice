/*
Problem: Container With Most Water
Platform: LeetCode
Link: https://leetcode.com/problems/container-with-most-water/

Difficulty: Medium
Topics: Array, Two Pointers

--------------------------------------------------

Approach (Two Pointer Technique):
- Initialize two pointers: left at start, right at end.
- Calculate area using:
    width = right - left
    height = min(height[left], height[right])
    area = width * height
- Track maximum area.
- Move the pointer with smaller height:
    → Because area depends on minimum height.
    → Moving larger height won't increase area.

--------------------------------------------------

Why this works:
- We try to maximize width first.
- Then optimize height by moving smaller pointer.
- Avoids checking all pairs → reduces from O(n²) to O(n).

--------------------------------------------------

Time Complexity: O(n)
Space Complexity: O(1)

--------------------------------------------------
*/

public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) {

            int width = right - left;
            int minHeight = Math.min(height[left], height[right]);
            int area = width * minHeight;

            maxArea = Math.max(maxArea, area);

            // Move the pointer with smaller height
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        ContainerWithMostWater obj = new ContainerWithMostWater();

        int[] height = {1,8,6,2,5,4,8,3,7};
        int result = obj.maxArea(height);

        System.out.println(result); // Expected: 49
    }
}
