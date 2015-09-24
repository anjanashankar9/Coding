package algorithms.warmup.easy;

import java.util.Scanner;

/**
 * Created by ashankar1 on 4/6/15.
 */
public class CavityMap {
    public static void cavityMap(){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Integer[][] arr = new Integer[n][n];
        for(int i=0;i<n;i++){
            String str = in.next();
            for(int j=0;j<n;j++){
                arr[i][j] = Integer.parseInt(Character.toString(str.charAt(j)));
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++)
                System.out.print(arr[i][j]+" ");
            System.out.println();
        }
        findCavity(arr,n);
    }
    private static void findCavity(Integer[][] arr, int n){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==0 || j==0 || i==n-1 || j==n-1){
                    System.out.print(arr[i][j]);
                }
                else if((arr[i-1][j] < arr[i][j]) && (arr[i][j-1] < arr[i][j]) && (arr[i+1][j] < arr[i][j]) && (arr[i][j+1] < arr[i][j])){
                    System.out.print("X");
                }
                else
                    System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }
}



/*
You are given a square map of size n×n. Each cell of the map has a value denoting its depth. We will call a cell of the map a cavity if
and only if this cell is not on the border of the map and each cell adjacent to it has strictly smaller depth.
Two cells are adjacent if they have a common side.

You need to find all the cavities on the map and depict them with the uppercase character X.

Input Format

The first line contains an integer, n, denoting the size of the map.
Each of the following n lines contains n positive digits without spaces. Each digit (1-9) denotes the depth of the appropriate area.

Constraints

1≤n≤100
Output Format

Output n lines, denoting the resulting map. Each cavity should be replaced with character X.

Sample Input

4
1112
1912
1892
1234
Sample Output

1112
1X12
18X2
1234
*/

//https://www.hackerrank.com/challenges/cavity-map