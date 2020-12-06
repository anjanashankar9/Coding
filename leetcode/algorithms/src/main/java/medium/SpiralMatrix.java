package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Anjana Shankar
 * @Created 2020-12-04
 */
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        int r1 = 0;
        int r2 = matrix.length - 1;
        int c1 = 0;
        int c2 = matrix[0].length - 1;

        while (r1 <= r2 && c1 <= c2) {
            for (int c = c1; c <= c2; c++)
                result.add(matrix[r1][c]);

            for (int r = r1 + 1; r <= r2; r++)
                result.add(matrix[r][c2]);

            for (int c = c2 - 1; c >= c1; c--)
                result.add(matrix[r2][c]);

            for (int r = r2 - 1; r > r1; r--)
                result.add(matrix[r][c1]);

            r1++;
            c1++;
            r2--;
            c2--;
        }
        return result;
    }
}

/*
Given an m x n matrix, return all elements of the matrix in spiral order.



Example 1:


Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]
Example 2:


Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]


Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 10
-100 <= matrix[i][j] <= 100
 */
