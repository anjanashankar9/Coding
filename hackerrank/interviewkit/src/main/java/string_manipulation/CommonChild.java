package string_manipulation;

import java.util.Scanner;

public class CommonChild {

    // Complete the commonChild function below.
    static int commonChild(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] solution = new int[m+1][n+1];


        for (int i=1; i<m+1; i++) {
            for (int j=1; j<n+1; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    solution[i][j] = solution[i-1][j-1] + 1;
                }
                else {
                    solution[i][j] = Math.max(
                            solution[i-1][j], solution[i][j-1]
                    );
                }
            }
        }
        return solution[m][n];

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void commonChild(String[] args) {

        String s1 = scanner.nextLine();

        String s2 = scanner.nextLine();

        int result = commonChild(s1, s2);

        System.out.println(result);
        scanner.close();
    }
}

/*
A string is said to be a child of a another string if it can be formed by deleting 0 or more characters from the other string. Given two strings of equal length, what's the longest string that can be constructed such that it is a child of both?

For example, ABCD and ABDC have two children with maximum length 3, ABC and ABD. They can be formed by eliminating either the D or C from both strings. Note that we will not consider ABCD as a common child because we can't rearrange characters and ABCD  ABDC.

Function Description

Complete the commonChild function in the editor below. It should return the longest string which is a common child of the input strings.

commonChild has the following parameter(s):

s1, s2: two equal length strings
Input Format

There is one line with two space-separated strings,  and .

Constraints

All characters are upper case in the range ascii[A-Z].
Output Format

Print the length of the longest string , such that  is a child of both  and .

Sample Input

HARRY
SALLY
Sample Output

 2
Explanation

The longest string that can be formed by deleting zero or more characters from  and  is , whose length is 2.

Sample Input 1

AA
BB
Sample Output 1

0
Explanation 1

 and  have no characters in common and hence the output is 0.

Sample Input 2

SHINCHAN
NOHARAAA
Sample Output 2

3
Explanation 2

The longest string that can be formed between  and  while maintaining the order is .

Sample Input 3

ABCDEF
FBDAMN
Sample Output 3

2
Explanation 3
 is the longest child of the given strings.
 */

//https://www.hackerrank.com/challenges/common-child/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=strings