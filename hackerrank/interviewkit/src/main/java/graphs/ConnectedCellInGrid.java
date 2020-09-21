package graphs;

import java.util.Scanner;
import java.util.Stack;

class StackNode {
    int row;
    int col;

    StackNode(int row, int col) {
        this.row = row;
        this.col = col;
    }
}


public class ConnectedCellInGrid {


    // Complete the maxRegion function below.
    static int maxRegion(int[][] grid, int n, int m) {
        int result = 0;
        boolean[][] visited = new boolean[n][m];

        int row, col = 0;

        for(int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (!visited[i][j] && grid[i][j] != 0) {
                    int region = DFS(i, j, grid, n, m, visited);
                    if (region > result) {
                        result = region;
                    }
                }
            }
        }

        return result;
    }


    static int DFS(int startRow, int startCol, int[][] grid, int row, int col, boolean[][] visited) {
        Stack<StackNode> stack = new Stack<>();
        int region = 0;

        visited[startRow][startCol] = true;
        stack.push(new StackNode(startRow, startCol));

        while (!stack.isEmpty()) {
            StackNode current = stack.pop();
            region++;
            int currentRow = current.row;
            int currentCol = current.col;

            if (currentRow-1 >= 0 && currentCol-1 >= 0 &&
                    grid[currentRow-1][currentCol-1] > 0 && !visited[currentRow-1][currentCol-1]) {
                stack.push(new StackNode(currentRow-1, currentCol-1));
                visited[currentRow-1][currentCol-1] = true;
            }
            if (currentRow-1 >= 0 &&
                    grid[currentRow-1][currentCol] > 0 && !visited[currentRow-1][currentCol]) {
                stack.push(new StackNode(currentRow-1, currentCol));
                visited[currentRow-1][currentCol] = true;
            }
            if (currentRow-1 >= 0 && currentCol+1 < col &&
                    grid[currentRow-1][currentCol+1] > 0 && !visited[currentRow-1][currentCol+1]) {
                stack.push(new StackNode(currentRow-1, currentCol+1));
                visited[currentRow-1][currentCol+1] = true;
            }

            if (currentCol-1 >= 0 &&
                grid[currentRow][currentCol-1] > 0 && !visited[currentRow][currentCol-1]) {
                stack.push(new StackNode(currentRow, currentCol-1));
                visited[currentRow][currentCol-1] = true;
            }
            if (currentCol+1 < col &&
                grid[currentRow][currentCol+1] > 0 && !visited[currentRow][currentCol+1]) {
                stack.push(new StackNode(currentRow, currentCol+1));
                visited[currentRow][currentCol+1] = true;
            }


            if (currentRow+1 < row && currentCol-1 >= 0 &&
                    grid[currentRow+1][currentCol-1] > 0 && !visited[currentRow+1][currentCol-1]) {
                stack.push(new StackNode(currentRow+1, currentCol-1));
                visited[currentRow+1][currentCol-1] = true;
            }

            if (currentRow+1 < row &&
                    grid[currentRow+1][currentCol] > 0 && !visited[currentRow+1][currentCol]) {
                stack.push(new StackNode(currentRow+1, currentCol));
                visited[currentRow+1][currentCol] = true;
            }

            if (currentRow+1 < row && currentCol+1 < col &&
                    grid[currentRow+1][currentCol+1] > 0 && !visited[currentRow+1][currentCol+1]) {
                stack.push(new StackNode(currentRow+1, currentCol+1));
                visited[currentRow+1][currentCol+1] = true;
            }
        }
        return region;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void connectedCellInGrid(String[] args) {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[][] grid = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] gridRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < m; j++) {
                int gridItem = Integer.parseInt(gridRowItems[j]);
                grid[i][j] = gridItem;
            }
        }

        int res = maxRegion(grid, n, m);

        System.out.println(res);

        scanner.close();
    }
}

/*
Consider a matrix where each cell contains either a  or a  and any cell containing a  is called a filled cell. Two cells are said to be connected if they are adjacent to each other horizontally, vertically, or diagonally. In the diagram below, the two colored regions show cells connected to the filled cells. Black on white are not connected.

Cells adjacent to filled cells: image

If one or more filled cells are also connected, they form a region. Note that each cell in a region is connected to at least one other cell in the region but is not necessarily directly connected to all the other cells in the region.

Regions: image

Given an  matrix, find and print the number of cells in the largest region in the matrix.

Function Description

Complete the function maxRegion in the editor below. It must return an integer value, the size of the largest region.

maxRegion has the following parameter(s):

grid: a two dimensional array of integers
Input Format

The first line contains an integer, , the number of rows in the matrix, .
The second line contains an integer, , the number of columns in the matrix.

Each of the following  lines contains a row of  space-separated integers, .

Constraints

Output Format

Print the number of cells in the largest region in the given matrix.

Sample Input

4
4
1 1 0 0
0 1 1 0
0 0 1 0
1 0 0 0
Sample Output

5
Explanation

The diagram below depicts two regions of the matrix:

image
The first region has five cells and the second region has one cell. We choose the larger region.
 */

//https://www.hackerrank.com/challenges/ctci-connected-cell-in-a-grid/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=graphs
