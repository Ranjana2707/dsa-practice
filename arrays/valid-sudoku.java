/*
Problem: Valid Sudoku
Platform: LeetCode
Link: https://leetcode.com/problems/valid-sudoku/

Difficulty: Medium
Topics: Array, Hashing

--------------------------------------------------

Approach (HashSet Validation):
- Traverse the board.
- For each non-empty cell:
    → Create unique keys for:
        1. Row check
        2. Column check
        3. 3x3 box check
- Store keys in HashSet.
- If any key already exists → invalid Sudoku.

--------------------------------------------------

Why this works:
- HashSet ensures O(1) lookup.
- Encoded keys uniquely represent constraints.
- Detects duplicates efficiently.

--------------------------------------------------

Time Complexity: O(1) (fixed 9x9 board)
Space Complexity: O(1)

--------------------------------------------------
*/

import java.util.*;

public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {

        Set<String> seen = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                char num = board[i][j];

                if (num != '.') {

                    String rowKey = num + " in row " + i;
                    String colKey = num + " in col " + j;
                    String boxKey = num + " in box " + (i / 3) + "-" + (j / 3);

                    if (!seen.add(rowKey) ||
                        !seen.add(colKey) ||
                        !seen.add(boxKey)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        ValidSudoku obj = new ValidSudoku();

        char[][] board = {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };

        boolean result = obj.isValidSudoku(board);

        System.out.println(result); // Expected: true
    }
}
