package dynamicprogramming;


import java.util.Scanner;

public class Abbreviation {

    // Complete the abbreviation function below.
    static String abbreviation(String a, String b) {

        /*
        This problem is similar to Edit Distance problem.
        You can convert the string a to b, provided you satisfy one of the
        following conditions.
        1. a-lastchar = B & lastchar is a lower case letter
        2. a-lastchar + cap(lastchar) = B
        3. Else these cannot be converted to each other.
        S(a,b) = S(a-1,b) OR

        a= AbcDE
        b = ABDE
         */
        int n = a.length();
        int m = b.length();

        boolean [][]possible = new boolean[m+1][n+1];
        possible[0][0] = true;

        for(int i=1; i<=n; i++)
        {
            possible[0][i] = (possible[0][i-1] && Character.isLowerCase(a.charAt(i-1)));
        }
        for (int j=1; j<=m; j++) {
            possible[j][0] = false;
        }


        for(int i=1; i<=m ; i++) {
            for (int j=1; j<=n; j++) {
                possible[i][j] = (possible[i-1][j-1] && a.charAt(j-1) == b.charAt(i-1))
                        || (possible[i][j-1] && Character.isLowerCase(a.charAt(j-1)))
                        || (possible[i-1][j-1] && Character.toUpperCase(a.charAt(j-1)) == b.charAt(i-1));
            }
        }

        if (possible[m][n])
            return "YES";
        else
            return "NO";

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void abbreviation(String[] args) {
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String a = scanner.nextLine();

            String b = scanner.nextLine();
            System.out.println();
            String result = abbreviation(a, b);

            System.out.println(result);
        }

        scanner.close();
    }
}

/*
You can perform the following operations on the string, :

Capitalize zero or more of 's lowercase letters.
Delete all of the remaining lowercase letters in .
Given two strings,  and , determine if it's possible to make  equal to  as described. If so, print YES on a new line. Otherwise, print NO.

For example, given  and , in  we can convert  and delete  to match . If  and , matching is not possible because letters may only be capitalized or discarded, not changed.

Function Description

Complete the function  in the editor below. It must return either  or .

abbreviation has the following parameter(s):

a: the string to modify
b: the string to match
Input Format

The first line contains a single integer , the number of queries.

Each of the next  pairs of lines is as follows:
- The first line of each query contains a single string, .
- The second line of each query contains a single string, .

Constraints

String  consists only of uppercase and lowercase English letters, ascii[A-Za-z].
String  consists only of uppercase English letters, ascii[A-Z].
Output Format

For each query, print YES on a new line if it's possible to make string  equal to string . Otherwise, print NO.

Sample Input

1
daBcd
ABC
Sample Output

YES
Explanation

image

We have  daBcd and  ABC. We perform the following operation:

Capitalize the letters a and c in  so that  dABCd.
Delete all the remaining lowercase letters in  so that  ABC.
Because we were able to successfully convert  to , we print YES on a new line.
 */

//https://www.hackerrank.com/challenges/abbr/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dynamic-programming
