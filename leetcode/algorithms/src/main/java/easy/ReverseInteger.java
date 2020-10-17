package easy;

/**
 * @Author Anjana Shankar
 * @Created 2020-10-17
 */
public class ReverseInteger {
    public int reverse(int x) {
        long result = 0; //storing the result in a long, so that we can check
        // if the result is overflowing at the end.

        while (x != 0) {
            result = result * 10 + (x % 10);
            x /= 10;
        }

        if (result < Integer.MIN_VALUE || result > Integer.MAX_VALUE) return 0;
        else return (int) result;

    }

    public static void main(String[] args) {
        int num1 = 123;
        int num2 = -123;
        int num3 = 1020;
        int num4 = 0;

        System.out.println(new ReverseInteger().reverse(num1));
        System.out.println(new ReverseInteger().reverse(num2));
        System.out.println(new ReverseInteger().reverse(num3));
        System.out.println(new ReverseInteger().reverse(num4));

    }
}

/*
Given a 32-bit signed integer, reverse digits of an integer.

Note:
Assume we are dealing with an environment that could only store integers
within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose
of this problem, assume that your function returns 0 when the
reversed integer overflows.



Example 1:

Input: x = 123
Output: 321
Example 2:

Input: x = -123
Output: -321
Example 3:

Input: x = 120
Output: 21
Example 4:

Input: x = 0
Output: 0


Constraints:

-231 <= x <= 231 - 1
 */

//https://leetcode.com/problems/reverse-integer/
