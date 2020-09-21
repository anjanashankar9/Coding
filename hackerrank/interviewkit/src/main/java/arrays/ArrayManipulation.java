package arrays;

public class ArrayManipulation {
    // Complete the arrayManipulation function below.
    // O(mn) solution.
    static long arrayManipulation(int n, int[][] queries) {
        long max = 0;
        long[] arr = new long[n];

        int m = queries.length;
        for (int i=0;i<m; i++) {
            for(int j=queries[i][0]-1; j<queries[i][1]; j++){
                arr[j] = arr[j]+queries[i][2];
                if (arr[j] > max) {
                    max = arr[j];
                }
            }
        }

        return max;
    }

    //O(n) solution
    //Can be done using prefix sum.
    static long arrayManipulation2(int n, int[][] queries) {
        long max = 0;
        long[] arr = new long[n];

        int m = queries.length;
        /*
        Adding to index at 0, and subtracting from index at 1
        This will ensure that the prefix sum of indexes between these two will give the right value.
         */
        for (int i=0;i<m; i++) {
            arr[queries[i][0]-1] += queries[i][2];
            if (queries[i][1] < n)
                arr[queries[i][1]] -= queries[i][2];
        }

        //calculating prefix sum
        long prefixSum=0;
        for(int i=0; i<n; i++) {
            prefixSum += arr[i];
            if(prefixSum > max)
                max = prefixSum;
        }

        return max;
    }

    public static void arrayManipulation(String[] args)  {

        int n = 10;

        int m = 4;

        int[][] queries = {
                {2, 6, 8},
                {3, 5, 7},
                {1, 8, 1},
                {5, 9, 15}
        };




        long result = arrayManipulation2(n, queries);
        System.out.println(result);

    }
}

/*
Starting with a 1-indexed array of zeros and a list of operations, for each operation add a value to each of the array element between two given indices, inclusive. Once all operations have been performed, return the maximum value in your array.

For example, the length of your array of zeros . Your list of queries is as follows:

    a b k
    1 5 3
    4 8 7
    6 9 1
Add the values of  between the indices  and  inclusive:

index->	 1 2 3  4  5 6 7 8 9 10
	[0,0,0, 0, 0,0,0,0,0, 0]
	[3,3,3, 3, 3,0,0,0,0, 0]
	[3,3,3,10,10,7,7,7,0, 0]
	[3,3,3,10,10,8,8,8,1, 0]
The largest value is  after all operations are performed.

Function Description

Complete the function arrayManipulation in the editor below. It must return an integer, the maximum value in the resulting array.

arrayManipulation has the following parameters:

n - the number of elements in your array
queries - a two dimensional array of queries where each queries[i] contains three integers, a, b, and k.
Input Format

The first line contains two space-separated integers  and , the size of the array and the number of operations.
Each of the next  lines contains three space-separated integers ,  and , the left index, right index and summand.

Constraints

Output Format

Return the integer maximum value in the finished array.

Sample Input

5 3
1 2 100
2 5 100
3 4 100
Sample Output

200
Explanation

After the first update list will be 100 100 0 0 0.
After the second update list will be 100 200 100 100 100.
After the third update list will be 100 200 200 200 100.
The required answer will be .
 */

//https://www.hackerrank.com/challenges/crush/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays
