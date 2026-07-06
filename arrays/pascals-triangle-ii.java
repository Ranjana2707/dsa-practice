/*
Problem: Pascal's Triangle II
Platform: LeetCode
Link: https://leetcode.com/problems/pascals-triangle-ii/

Difficulty: Easy
Topics: Array, Dynamic Programming

--------------------------------------------------

Approach (In-place Dynamic Programming):
- Start with the first row: [1].
- Build each row one by one.
- Traverse from right to left:
    → Update current element as:
      row[j] = row[j] + row[j - 1]
- Append 1 at the end of every row.
- Right-to-left traversal prevents overwriting values
  needed for future calculations.

--------------------------------------------------

Why this works:
- Each element depends on the previous row.
- Updating from right to left preserves previous values.
- Uses only one list instead of storing the entire triangle.

--------------------------------------------------

Time Complexity: O(rowIndex²)
Space Complexity: O(rowIndex)

--------------------------------------------------
*/

import java.util.*;

public class PascalsTriangleII {

    public List<Integer> getRow(int rowIndex) {

        List<Integer> row = new ArrayList<>();
        row.add(1);

        for (int i = 1; i <= rowIndex; i++) {

            row.add(1);

            for (int j = i - 1; j > 0; j--) {
                row.set(j, row.get(j) + row.get(j - 1));
            }
        }

        return row;
    }

    public static void main(String[] args) {
        PascalsTriangleII obj = new PascalsTriangleII();

        int rowIndex = 3;

        List<Integer> result = obj.getRow(rowIndex);

        System.out.println(result);
        // Expected: [1, 3, 3, 1]
    }
}
