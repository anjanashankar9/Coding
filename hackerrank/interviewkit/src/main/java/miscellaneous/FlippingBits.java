package miscellaneous;

import java.util.Scanner;

public class FlippingBits {

    public static void flipBits(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i=0;i<t;i++){
            long n = in.nextLong();
            flipBits(n);
        }

    }
    private static void flipBits(long n) {
        System.out.println((n) ^ 0x0FFFFFFFFl);
    }
}

/*
You will be given a list of 32 bit unsigned integers. Flip all the bits ( and ) and print the result as an unsigned integer.

For example, your decimal input . We're working with 32 bits, so:



Function Description

Complete the flippingBits function in the editor below. It should return the unsigned decimal integer result.

flippingBits has the following parameter(s):

n: an integer
Input Format

The first line of the input contains , the number of queries.
Each of the next  lines contain an integer, , to process.

Constraints



Output Format

Output one line per element from the list with the decimal value of the resulting unsigned integer.

Sample Input 0

3
2147483647
1
0
Sample Output 0

2147483648
4294967294
4294967295
Explanation 0







Sample Input 1

2
4
123456
Sample Output 1

4294967291
4294843839
Explanation 1





Sample Input 2

3
0
802743475
35601423
Sample Output 2

4294967295
3492223820
4259365872
Explanation 2








 */
//https://www.hackerrank.com/challenges/flipping-bits/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=miscellaneous
