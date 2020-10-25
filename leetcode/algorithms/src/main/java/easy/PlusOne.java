package easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author Anjana Shankar
 * @Created 2020-10-25
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        List<Integer> result = new ArrayList<>();

        int carry = 1;
        for(int i=digits.length-1; i>=0; i--) {
            int sum = digits[i]+carry;
            int d = sum%10;
            carry = sum/10;
            result.add(0, d);
        }
        if(carry>0) {
            result.add(0, carry);
        }

        int[] arr = new int[result.size()];
        for(int i=0; i<result.size(); i++) {
            arr[i] = result.get(i);
        }
        return arr;
    }
}
/*
Given a non-empty array of digits representing a non-negative integer, increment one to the integer.

The digits are stored such that the most significant digit is at the head of the list, and each element in the array contains a single digit.

You may assume the integer does not contain any leading zero, except the number 0 itself.



Example 1:

Input: digits = [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Example 2:

Input: digits = [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.
Example 3:

Input: digits = [0]
Output: [1]


Constraints:

1 <= digits.length <= 100
0 <= digits[i] <= 9

 */
//https://leetcode.com/problems/plus-one/