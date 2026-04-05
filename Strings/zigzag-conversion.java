/*
Problem: Zigzag Conversion
Platform: LeetCode
Link: https://leetcode.com/problems/zigzag-conversion/

Difficulty: Medium
Topics: String

--------------------------------------------------

Approach (Simulation):
- Create an array of StringBuilders for each row.
- Traverse characters of the string.
- Append each character to the current row.
- Change direction when reaching:
    → Top row (0)
    → Bottom row (numRows - 1)
- Finally, concatenate all rows.

--------------------------------------------------

Why this works:
- Zigzag pattern can be simulated row by row.
- Direction control (up/down) ensures correct placement.
- Avoids building an actual 2D matrix → saves space.

--------------------------------------------------

Time Complexity: O(n)
Space Complexity: O(n)

--------------------------------------------------
*/

public class ZigzagConversion {

    public String convert(String s, int numRows) {

        if (numRows == 1 || s.length() <= numRows) {
            return s;
        }

        StringBuilder[] rows = new StringBuilder[numRows];

        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int currentRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {

            rows[currentRow].append(c);

            // Change direction at top or bottom
            if (currentRow == 0 || currentRow == numRows - 1) {
                goingDown = !goingDown;
            }

            currentRow += goingDown ? 1 : -1;
        }

        StringBuilder result = new StringBuilder();

        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        ZigzagConversion obj = new ZigzagConversion();

        String input = "PAYPALISHIRING";
        int numRows = 3;

        String result = obj.convert(input, numRows);

        System.out.println(result); // Expected: "PAHNAPLSIIGYIR"
    }
}
