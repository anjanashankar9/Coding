package arraysandstrings;

/**
 * @Author Anjana Shankar
 * @Created 2020-09-27
 */
public class ZeroMatrix {

    private int[][] zeroMatrix(int[][] matrix) {
        int M = matrix.length;
        int N = matrix[0].length;
        boolean[] zeroRows = new boolean[matrix.length];
        boolean[] zeroCols = new boolean[matrix[0].length];

        for(int i=0; i< M; i++) {
            for(int j=0; j<N; j++) {
                if (matrix[i][j] == 0) {
                    zeroRows[i] = true;
                    zeroCols[j] = true;
                }
            }
        }

        for(int i=0; i<M; i++) {
            for(int j=0; j<N; j++) {
                if(zeroRows[i] || zeroCols[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
        return matrix;
    }

    public static void zeroMatrix(String[] args) {
        int[][] matrix = {
                {2,0,4,3},
                {1,2,3,4},
                {5,6,7,0}
        };
        int[][] result = new ZeroMatrix().zeroMatrix(matrix);
        for(int i=0; i<result.length; i++) {
            for (int j=0; j<result[0].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}

/*
Write an algorithm such that if an element in an MxN matrix is 0,
its entire row and column are set to 0.
 */
