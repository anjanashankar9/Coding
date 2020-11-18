package medium;

/**
 * @Author Anjana Shankar
 * @Created 2020-11-18
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        if(amount == 0)
            return -1;
        dp[0] = 0;

        for(int i=1; i<=amount; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        for(int i=1; i<=amount; i++) {
            int min = Integer.MAX_VALUE;
            for(int j = coins.length-1; j>=0; j--) {
                int val = 0;
                if(coins[j]<=i) {
                    val = dp[i-coins[j]];
                    min = min>val ? val : min;
                }
            }
            if(min == Integer.MAX_VALUE)
                dp[i] = min;
            else
                dp[i] = min+1;
        }

        if(dp[amount] == Integer.MAX_VALUE)
            return -1;
        return dp[amount];
    }
}

/*
You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.



Example 1:

Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
Example 2:

Input: coins = [2], amount = 3
Output: -1
Example 3:

Input: coins = [1], amount = 0
Output: 0
Example 4:

Input: coins = [1], amount = 1
Output: 1
Example 5:

Input: coins = [1], amount = 2
Output: 2


Constraints:

1 <= coins.length <= 12
1 <= coins[i] <= 231 - 1
0 <= amount <= 104
 */
