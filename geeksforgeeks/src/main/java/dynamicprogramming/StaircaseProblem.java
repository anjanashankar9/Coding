package dynamicprogramming;

/**
 * @Author Anjana Shankar
 * @Created 2020-11-17
 */
public class StaircaseProblem {

    public int reachTop(int n) {
        int dp[] = new int[n+1];

        if(n<=0)
            return 0;

        if(n==1)
            return 1;
        if(n==2)
            return 2;

        dp[1] = 1; // There is only one way to reach the top.
        dp[2] = 2; // 2 ways to reach top. 1+1 or 2;

        for(int i=3; i<=n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    public static void main(String[] args) {

        System.out.println(new StaircaseProblem().reachTop(1));
        System.out.println(new StaircaseProblem().reachTop(2));
        System.out.println(new StaircaseProblem().reachTop(3));
        System.out.println(new StaircaseProblem().reachTop(4));
        System.out.println(new StaircaseProblem().reachTop(5));


    }
}
/*
There are n stairs, a person standing at the bottom wants to reach the top.
The person can climb either 1 stair or 2 stairs at a time.
Count the number of ways, the person can reach the top.
 */
