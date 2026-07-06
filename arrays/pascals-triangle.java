/*
Problem: Pascal's Triangle
Platform: LeetCode
Link: https://leetcode.com/problems/pascals-triangle/

Difficulty: Easy
Topics: Array, Dynamic Programming

--------------------------------------------------

Approach (Simulation):
- Build the triangle row by row.
- The first and last element of every row is 1.
- For all other elements:
    → Value = previousRow[j - 1] + previousRow[j]
- Store each completed row in the result list.

--------------------------------------------------

Why this works:
- Every element (except the edges) depends only on
  the two elements directly above it.
- Previously generated rows are reused to construct
  the next row.

--------------------------------------------------

Time Complexity: O(numRows²)
Space Complexity: O(numRows²)

--------------------------------------------------
*/

import java.util.*;

public class PascalsTriangle {

    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {

            List<Integer> row = new ArrayList<>();

            for (int j = 0; j <= i; j++) {

                // First and last elements are always 1
                if (j == 0 || j == i) {

                    row.add(1);

                } else {

                    row.add(ans.get(i - 1).get(j - 1)
                           + ans.get(i - 1).get(j));

                }
            }

            ans.add(row);
        }

        return ans;
    }

    public static void main(String[] args) {
        PascalsTriangle obj = new PascalsTriangle();

        int numRows = 5;

        List<List<Integer>> result = obj.generate(numRows);

        System.out.println(result);
        // Expected:
        // [[1],
        //  [1,1],
        //  [1,2,1],
        //  [1,3,3,1],
        //  [1,4,6,4,1]]
    }
}
