package easy;

/**
 * @Author Anjana Shankar
 * @Created 2020-09-27
 */
public class MatrixDiagonalSum {
    public int diagonalSum(int[][] mat) {
        int sum =0;
        int n = mat.length;
        for(int i=0; i<n; i++) {
            sum += mat[i][i];
            sum += mat[i][n-i-1];
        }

        //Removing the duplicated element that is added
        if(n%2 != 0 ) {
            sum -= mat[(n-1)/2][(n-1)/2];
        }
        return sum;
    }

    public static void matrixDiagnoalSum(String[] args) {
        int[][] mat = {{7,3,1,9}
        ,{3,4,6,9},
                {6,9,6,6},
                {9,5,8,5}};
        MatrixDiagonalSum md = new MatrixDiagonalSum();
        int sum = md.diagonalSum(mat);
        System.out.println(sum);
    }
}

/*
Given a square matrix mat, return the sum of the matrix diagonals.

Only include the sum of all the elements on the primary diagonal and all the elements on the secondary diagonal that are not part of the primary diagonal.



Example 1:


Input: mat = [[1,2,3],
              [4,5,6],
              [7,8,9]]
Output: 25
Explanation: Diagonals sum: 1 + 5 + 9 + 3 + 7 = 25
Notice that element mat[1][1] = 5 is counted only once.
Example 2:

Input: mat = [[1,1,1,1],
              [1,1,1,1],
              [1,1,1,1],
              [1,1,1,1]]
Output: 8
Example 3:

Input: mat = [[5]]
Output: 5


Constraints:

n == mat.length == mat[i].length
1 <= n <= 100
1 <= mat[i][j] <= 100
 */
//https://leetcode.com/problems/matrix-diagonal-sum/
