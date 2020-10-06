package easy;

/**
 * @Author Anjana Shankar
 * @Created 2020-10-06
 */
public class AddStrings {
    public String addStrings(String num1, String num2) {
        int i = num1.length()-1;
        int j = num2.length()-1;

        StringBuilder sb = new StringBuilder();
        int carry = 0;

        while(i>=0 && j>=0) {
            int d1 = num1.charAt(i) - '0';
            int d2 = num2.charAt(j) - '0';

            int num = d1+d2+carry;
            sb.append(num%10);
            carry = num/10;
            i--;
            j--;
        }

        while(i>=0) {
            int d1 = num1.charAt(i) - '0';
            int num = d1+carry;
            sb.append(num%10);
            carry = num/10;
            i--;
        }

        while(j>=0) {
            int d2 = num2.charAt(j) - '0';
            int num = d2+carry;
            sb.append(num%10);
            carry = num/10;
            j--;
        }
        if (carry>0) {
            sb.append(carry);
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        AddStrings s = new AddStrings();
        System.out.println(s.addStrings("123", "512"));

    }
}

/*
Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.

Note:

The length of both num1 and num2 is < 5100.
Both num1 and num2 contains only digits 0-9.
Both num1 and num2 does not contain any leading zero.
You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */
//https://leetcode.com/problems/add-strings/
