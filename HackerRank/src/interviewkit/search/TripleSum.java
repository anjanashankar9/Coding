package interviewkit.search;

import java.util.*;

public class TripleSum {

    // Complete the triplets function below.
    static long triplets(int[] a, int[] b, int[] c) {
        long triplets = 0;

        //Sort the arrays.
        Arrays.sort(a);
        Arrays.sort(b);
        Arrays.sort(c);

        int lenA = removeDuplicates(a);
        int lenB = removeDuplicates(b);
        int lenC = removeDuplicates(c);

        int i = 0, j = 0, k = 0;

        while(i < lenB) {
            while (j < lenA && a[j] <= b[i] )
                j++;
            while ( k < lenC && c[k] <= b[i])
                k++;
            triplets += (long) j * k;
            i++;
        }

        return triplets;

    }

    private static int removeDuplicates(int[] arr) {
        int n = arr.length;
        if (n==0 || n==1){
            return n;
        }
        int[] temp = new int[n];
        int j = 0;
        for (int i=0; i<n-1; i++){
            if (arr[i] != arr[i+1]){
                temp[j++] = arr[i];
            }
        }
        temp[j++] = arr[n-1];
        // Changing original array
        for (int i=0; i<j; i++){
            arr[i] = temp[i];
        }
        return j;
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void tripleSum(String[] args) {

        String[] lenaLenbLenc = scanner.nextLine().split(" ");

        int lena = Integer.parseInt(lenaLenbLenc[0]);

        int lenb = Integer.parseInt(lenaLenbLenc[1]);

        int lenc = Integer.parseInt(lenaLenbLenc[2]);

        int[] arra = new int[lena];

        String[] arraItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < lena; i++) {
            int arraItem = Integer.parseInt(arraItems[i]);
            arra[i] = arraItem;
        }

        int[] arrb = new int[lenb];

        String[] arrbItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < lenb; i++) {
            int arrbItem = Integer.parseInt(arrbItems[i]);
            arrb[i] = arrbItem;
        }

        int[] arrc = new int[lenc];

        String[] arrcItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < lenc; i++) {
            int arrcItem = Integer.parseInt(arrcItems[i]);
            arrc[i] = arrcItem;
        }

        long ans = triplets(arra, arrb, arrc);
        System.out.println(ans);
        scanner.close();
    }
}


/*
Given  arrays  of different sizes, find the number of distinct triplets  where  is an element of , written as , , and , satisfying the criteria: .

For example, given  and , we find four distinct triplets: .

Function Description

Complete the triplets function in the editor below. It must return the number of distinct triplets that can be formed from the given arrays.

triplets has the following parameter(s):

a, b, c: three arrays of integers .
Input Format

The first line contains  integers , the sizes of the three arrays.
The next  lines contain space-separated integers numbering  respectively.

Constraints



Output Format

Print an integer representing the number of distinct triplets.

Sample Input 0

3 2 3
1 3 5
2 3
1 2 3
Sample Output 0

8
Explanation 0

The special triplets are  .

Sample Input 1

3 3 3
1 4 5
2 3 3
1 2 3
Sample Output 1

5
Explanation 1

The special triplets are

Sample Input 2

4 3 4
1 3 5 7
5 7 9
7 9 11 13
Sample Output 2

12
Explanation 2

The special triplets are .
 */
//https://www.hackerrank.com/challenges/triple-sum/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=search
