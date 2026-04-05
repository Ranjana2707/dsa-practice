/*
Problem: Sudoku Solver
Platform: LeetCode
Link: https://leetcode.com/problems/sudoku-solver/

Difficulty: Hard
Topics: Backtracking

--------------------------------------------------

Approach (Backtracking):
- Traverse the board to find empty cell ('.').
- Try placing digits '1' to '9'.
- For each digit:
    → Check if placement is valid.
    → Place digit and recurse.
    → If fails → backtrack (reset to '.').
- Continue until board is completely filled.

--------------------------------------------------

Why this works:
- Sudoku constraints restrict valid placements.
- Backtracking explores all valid possibilities.
- Stops early when a valid solution is found.

--------------------------------------------------

Time Complexity: O(9^(n*n)) (worst case)
Space Complexity: O(n*n) recursion stack

--------------------------------------------------
*/

public class SudokuSolver {

    public void solveSudoku(char[][] board) {
        backtrack(board);
    }

    private boolean backtrack(char[][] board) {

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {

                if (board[row][col] == '.') {

                    for (char num = '1'; num <= '9'; num++) {

                        if (isValid(board, row, col, num)) {

                            board[row][col] = num;

                            if (backtrack(board)) {
                                return true;
                            }

                            board[row][col] = '.'; // backtrack
                        }
                    }

                    return false;
                }
            }
        }

        return true; // solved
    }

    private boolean isValid(char[][] board, int row, int col, char num) {

        // Row check
        for (int j = 0; j < 9; j++) {
            if (board[row][j] == num) return false;
        }

        // Column check
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == num) return false;
        }

        // 3x3 grid check
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;

        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == num) return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        SudokuSolver obj = new SudokuSolver();

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

        obj.solveSudoku(board);

        // Print solved board
        for (char[] row : board) {
            for (char c : row) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }
}
