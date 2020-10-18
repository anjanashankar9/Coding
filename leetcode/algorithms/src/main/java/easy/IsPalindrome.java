package easy;

/**
 * @Author Anjana Shankar
 * @Created 2020-10-18
 */
public class IsPalindrome {
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;

        int copy = x;
        int reverseNumber = 0;
        while(copy>0) {
            reverseNumber = reverseNumber*10+ (copy%10);
            copy = copy/10;
        }

        return x == reverseNumber;

    }

    public static void main(String[] args) {
        int n1 = 121;
        int n2 = -121;
        int n3 = 10;
        int n4 = -101;
        int n5 = 0;

        System.out.println(new IsPalindrome().isPalindrome(n1));
        System.out.println(new IsPalindrome().isPalindrome(n2));
        System.out.println(new IsPalindrome().isPalindrome(n3));
        System.out.println(new IsPalindrome().isPalindrome(n4));
        System.out.println(new IsPalindrome().isPalindrome(n5));

    }
}

/*
Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.

Follow up: Could you solve it without converting the integer to a string?



Example 1:

Input: x = 121
Output: true
Example 2:

Input: x = -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
Example 3:

Input: x = 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
Example 4:

Input: x = -101
Output: false


Constraints:

-231 <= x <= 231 - 1
 */

//https://leetcode.com/problems/palindrome-number/
