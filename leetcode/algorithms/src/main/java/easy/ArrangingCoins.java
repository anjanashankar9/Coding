package easy;

/**
 * @Author Anjana Shankar
 * @Created 2020-10-07
 */
public class ArrangingCoins {
    public int arrangeCoins(int n) {
        int i=0;
        while (n>=0) {
            i++;
            n = n-i;
        }
        return i-1;
    }

    public static void main(String[] args) {
        System.out.println(new ArrangingCoins().arrangeCoins(10));
        System.out.println(new ArrangingCoins().arrangeCoins(8));
        System.out.println(new ArrangingCoins().arrangeCoins(5));
        System.out.println(new ArrangingCoins().arrangeCoins(1));
        System.out.println(new ArrangingCoins().arrangeCoins(0));
    }
}

/*
You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.

Given n, find the total number of full staircase rows that can be formed.

n is a non-negative integer and fits within the range of a 32-bit signed integer.

Example 1:

n = 5

The coins can form the following rows:
¤
¤ ¤
¤ ¤

Because the 3rd row is incomplete, we return 2.
Example 2:

n = 8

The coins can form the following rows:
¤
¤ ¤
¤ ¤ ¤
¤ ¤

Because the 4th row is incomplete, we return 3.

 */
//https://leetcode.com/problems/arranging-coins/
