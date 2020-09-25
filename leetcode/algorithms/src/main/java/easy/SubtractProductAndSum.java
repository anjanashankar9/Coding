package easy;

/**
 * @Author Anjana Shankar
 * @Created 2020-09-25
 */
public class SubtractProductAndSum {
    public int subtractProductAndSum(int n) {
        long product = 1;
        long sum = 0;

        while(n > 9) {
            int digit = n%10;
            product = product * digit;
            sum = sum + digit;
            n = n/10;
        }
        product = product * n;
        sum = sum + n;

        int result = (int) (product - sum);
        return result;
    }

    public static void subtractProductAndSum(String[] args) {
        int n = 22;
        SubtractProductAndSum sp = new SubtractProductAndSum();
        int response = sp.subtractProductAndSum(n);
        System.out.println(response);

    }
}

/*
Given an integer number n, return the difference between the product of its digits and the sum of its digits.


Example 1:

Input: n = 234
Output: 15
Explanation:
Product of digits = 2 * 3 * 4 = 24
Sum of digits = 2 + 3 + 4 = 9
Result = 24 - 9 = 15
Example 2:

Input: n = 4421
Output: 21
Explanation:
Product of digits = 4 * 4 * 2 * 1 = 32
Sum of digits = 4 + 4 + 2 + 1 = 11
Result = 32 - 11 = 21


Constraints:

1 <= n <= 10^5

 */
//https://leetcode.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer/
