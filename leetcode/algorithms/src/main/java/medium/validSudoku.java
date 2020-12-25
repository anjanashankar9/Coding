package medium;

import java.util.HashSet;

/**
 * @Author Anjana Shankar
 * @Created 2020-12-25
 */
public class validSudoku {
    public boolean isValidSudoku(char[][] board) {

        //valid rows
        for(int i=0; i<9; i++) {
            HashSet<Integer> hashset = new HashSet<>();
            for (int j=0; j<9; j++) {
                if(board[i][j] != '.') {
                    int num = (int) board[i][j];
                    if (hashset.contains(num)) {
                        return false;
                    }
                    else {
                        hashset.add(num);
                    }
                }
            }
        }

        //valid cols
        for(int i=0; i<9; i++) {
            HashSet<Integer> hashset = new HashSet<>();
            for (int j=0; j<9; j++) {
                if(board[j][i] != '.') {
                    int num = (int) board[j][i];
                    if (hashset.contains(num)) {
                        return false;
                    }
                    else {
                        hashset.add(num);
                    }
                }
            }
        }

        //valid subboxes
        for(int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                HashSet<Integer> hashset = new HashSet<>();
                for(int k=0; k<3; k++) {
                    for(int l=0; l<3; l++) {
                        if(board[i*3+k][j*3+l] != '.') {
                            int num = (int) board[i*3+k][j*3+l];
                            if (hashset.contains(num)) {
                                return false;
                            }
                            else {
                                hashset.add(num);
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}

/*
Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
Note:

A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.


Example 1:


Input: board =
[["5","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
Output: true
Example 2:

Input: board =
[["8","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
Output: false
Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.


Constraints:

board.length == 9
board[i].length == 9
board[i][j] is a digit or '.'.
 */

//https://leetcode.com/problems/valid-sudoku/