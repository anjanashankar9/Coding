package medium;

/**
 * @Author Anjana Shankar
 * @Created 2020-11-17
 */
public class UniqueBSTs {
    public int numTrees(int n) {
        /*
        Base Case:
        For n = 0 : 1 possibility.
        For n = 1: 1 possibility.

        For n=2 onwards, number of possibilities is equal to
        sum of number of trees that can be made with each element as the root.
         */

        int[] dp = new int[n+1];

        dp[0] = dp[1] = 1;
        for(int i=2; i<=n; i++) {
            int total = 0;
            for(int j=1; j<=i; j++) {
                total+= dp[j-1] * dp[i-j];
            }
            dp[i] = total;
        }
        return dp[n];
    }

    public static void main(String[] args) {
//        System.out.println(new UniqueBSTs().numTrees(1));
//        System.out.println(new UniqueBSTs().numTrees(2));
        System.out.println(new UniqueBSTs().numTrees(3));
        System.out.println(new UniqueBSTs().numTrees(4));
        System.out.println(new UniqueBSTs().numTrees(5));
        System.out.println(new UniqueBSTs().numTrees(6));
        System.out.println(new UniqueBSTs().numTrees(7));
        System.out.println(new UniqueBSTs().numTrees(8));
        System.out.println(new UniqueBSTs().numTrees(9));
        System.out.println(new UniqueBSTs().numTrees(10));
        System.out.println(new UniqueBSTs().numTrees(11));
        System.out.println(new UniqueBSTs().numTrees(12));
        System.out.println(new UniqueBSTs().numTrees(13));
        System.out.println(new UniqueBSTs().numTrees(14));
        System.out.println(new UniqueBSTs().numTrees(15));
        System.out.println(new UniqueBSTs().numTrees(16));
        System.out.println(new UniqueBSTs().numTrees(17));
        System.out.println(new UniqueBSTs().numTrees(18));
        System.out.println(new UniqueBSTs().numTrees(19));
    }

}

/*
Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?

Example:

Input: 3
Output: 5
Explanation:
Given n = 3, there are a total of 5 unique BST's:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3


Constraints:

1 <= n <= 19
 */