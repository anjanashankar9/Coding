package arraysandstrings;

/**
 * @Author Anjana Shankar
 * @Created 2020-09-27
 */
public class RotateMatrix {
    private int[][] rotatedMatrix(int[][] input) {
        if (input.length== 0 || input.length != input[0].length) {
            System.out.println("Cannot be rotated");
            return input;
        }
        int n = input.length;
        for (int layer = 0; layer < n / 2; layer++) {
            int first = layer;
            int last = n - 1 - layer;
            for (int i = first; i < last; i++) {
                int offset = i - first;
                int top = input[first][i];
                input[first][i] = input[last - offset][first];
                input[last - offset][first] = input[last][last - offset];
                input[last][last - offset] = input[i][last];
                input[i][last] = top;
            }
        }
        return input;
    }

    public static void rotateMatrix(String[] args) {

    }
}

/*
Given an image represented by an NxN matrix, where each pixel in the image is
4 bytes, write a method to rotate the image by 90 degrees.
Can you do this in place?
 */
