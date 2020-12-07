package medium;

/**
 * @Author Anjana Shankar
 * @Created 2020-12-07
 */
public class DivideTwoNumbers {
    public int divide(int dividend, int divisor) {
        if (divisor == 0)
            return Integer.MAX_VALUE;

        // Since both numbers are integer, the only way the result will overflow
        // is if the dividend is min integer and we are dividing it by -1.
        // The following condition takes care of that.
        if (divisor == -1 && dividend == Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        }

        //sign or result
        boolean sign = (dividend >= 0) == (divisor>=0);

        // Keeping the absolute values of the dividend and divisor. We will add
        // the sign later.
        int dividendAbs = Math.abs(dividend);
        int divisorAbs = Math.abs(divisor);

        int ans = 0;

        // Checking if we can subtract the divisor atleast once.
        // If not we have found the quotient
        while (dividendAbs-divisorAbs >= 0) {
            int x = 0;
            // The shift operator results in doubling the divisor's
            // value in each iteration
            // e.g if divisor is 3,
            // the shift will result in
            // 3*2
            // 3*2*2
            // 3*2*2 and so on.
            while ( dividendAbs - (divisorAbs<<1<<x) >=0) {
                x++;
            }
            ans += 1 << x;
            dividendAbs -= divisorAbs << x;
        }

        if (sign)
            return ans;
        return -ans;
    }
}

/*
Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.

Return the quotient after dividing dividend by divisor.

The integer division should truncate toward zero, which means losing its fractional part. For example, truncate(8.345) = 8 and truncate(-2.7335) = -2.

Note:

Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For this problem, assume that your function returns 231 − 1 when the division result overflows.


Example 1:

Input: dividend = 10, divisor = 3
Output: 3
Explanation: 10/3 = truncate(3.33333..) = 3.
Example 2:

Input: dividend = 7, divisor = -3
Output: -2
Explanation: 7/-3 = truncate(-2.33333..) = -2.
Example 3:

Input: dividend = 0, divisor = 1
Output: 0
Example 4:

Input: dividend = 1, divisor = 1
Output: 1


Constraints:

-231 <= dividend, divisor <= 231 - 1
divisor != 0

 */
