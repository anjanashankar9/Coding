package easy;

/**
 * @Author Anjana Shankar
 * @Created 2020-09-22
 */
public class ReverseBits {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        int i = 0;
        int j = 31;
        while(i<=j) {
            int bi = (n & (1<<i))==0?0:1;
            int bj = (n & (1<<j))==0?0:1;

            result |= bi<<j;
            result |= bj<<i;
            i++; j--;
        }
        return result;
    }

    public static void reverseBits(String[] args) {
        String input = "00000010100101000001111010011100";
        int inputInteger = Integer.parseInt(input, 2);
        ReverseBits rb = new ReverseBits();
        int result = rb.reverseBits(inputInteger);
        System.out.println(result);
        StringBuffer output = new StringBuffer();
        for(int i=31; i>=0; i--) {
            int b = (result & (1<<i))==0?0:1;
            output.append(b);
        }
        System.out.println(output.toString());
    }

}

/*
Reverse bits of a given 32 bits unsigned integer.



Example 1:

Input: 00000010100101000001111010011100
Output: 00111001011110000010100101000000
Explanation: The input binary string 00000010100101000001111010011100 represents the unsigned integer 43261596, so return 964176192 which its binary representation is 00111001011110000010100101000000.
Example 2:

Input: 11111111111111111111111111111101
Output: 10111111111111111111111111111111
Explanation: The input binary string 11111111111111111111111111111101 represents the unsigned integer 4294967293, so return 3221225471 which its binary representation is 10111111111111111111111111111111.


Note:

Note that in some languages such as Java, there is no unsigned integer type. In this case, both input and output will be given as signed integer type and should not affect your implementation, as the internal binary representation of the integer is the same whether it is signed or unsigned.
In Java, the compiler represents the signed integers using 2's complement notation. Therefore, in Example 2 above the input represents the signed integer -3 and the output represents the signed integer -1073741825.


Follow up:

If this function is called many times, how would you optimize it?



Constraints:

The input must be a binary string of length = 32
 */
//https://leetcode.com/problems/reverse-bits/