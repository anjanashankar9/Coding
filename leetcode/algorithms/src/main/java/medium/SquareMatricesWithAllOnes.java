package medium;

/**
 * @Author Anjana Shankar
 * @Created 2020-11-23
 */
public class SquareMatricesWithAllOnes {
    /*
    Explanation:
    We keep track of maximum side of square ending at (i,j)
    So for the first row and first col, since the maximum possible size of square
    ending in any of these positions can be only 1 or 0, based on the cell value

    That is our initialization strategy.

    For filling the rest of the matrix,
    we see the minimum value of the dp cell at i-1,j
    i, j-1
    and i-1, j-1
    And add 1 to it, if the cell is a 1.
    

    If its a ero, there can be no square ending at this cell.
     */
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int dp[][] = new int[m][n];
        for(int i=0; i<m; i++) {
            dp[i][0] = matrix[i][0];
        }
        for(int j=0; j<n; j++) {
            dp[0][j] = matrix[0][j];
        }

        for(int i=1; i<m; i++) {
            for(int j=1; j<n; j++) {
                if(matrix[i][j] == 1) {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                }
                else
                    dp[i][j] = 0;
            }
        }

        int count = 0;
        for(int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                count += dp[i][j];
            }
        }
        return count;
    }

    public static void main(String[] args) {

    }
}

/*
Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.



Example 1:

Input: matrix =
[
  [0,1,1,1],
  [1,1,1,1],
  [0,1,1,1]
]
Output: 15
Explanation:
There are 10 squares of side 1.
There are 4 squares of side 2.
There is  1 square of side 3.
Total number of squares = 10 + 4 + 1 = 15.
Example 2:

Input: matrix =
[
  [1,0,1],
  [1,1,0],
  [1,1,0]
]
Output: 7
Explanation:
There are 6 squares of side 1.
There is 1 square of side 2.
Total number of squares = 6 + 1 = 7.


Constraints:

1 <= arr.length <= 300
1 <= arr[0].length <= 300
0 <= arr[i][j] <= 1

 */
//https://leetcode.com/problems/count-square-submatrices-with-all-ones/