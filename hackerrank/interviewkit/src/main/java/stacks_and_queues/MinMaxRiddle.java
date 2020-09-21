package stacks_and_queues;

import java.util.Scanner;

public class MinMaxRiddle {

    // Complete the riddle function below.
    // DP solution
    static long[] riddleDP(long[] arr) {
        // complete this function
        long[] result = new long[arr.length];

        long[][] dp = new long[arr.length][arr.length];

        long max = Long.MIN_VALUE;
        for(int i=0; i<arr.length; i++) {
            dp[0][i] = arr[i];
            if (max < arr[i]) {
                max = arr[i];
            }
        }

        result[0] = max;

        for(int k=1; k<arr.length; k++) {
            max = Long.MIN_VALUE;
            for (int i=0; i<arr.length-k; i++) {
                dp[k][i] = Math.min(dp[k-1][i], arr[i+k]);
                if(max < dp[k][i])
                    max = dp[k][i];
            }
            result[k] = max;
        }
        return result;

    }

    // Complete the riddle function below.
    // stack solution
    static long[] riddle(long[] arr) {
        // complete this function
        long[] result = new long[arr.length];

        long[][] dp = new long[arr.length][arr.length];

        long max = Long.MIN_VALUE;
        for(int i=0; i<arr.length; i++) {
            dp[0][i] = arr[i];
            if (max < arr[i]) {
                max = arr[i];
            }
        }

        result[0] = max;

        for(int k=1; k<arr.length; k++) {
            max = Long.MIN_VALUE;
            for (int i=0; i<arr.length-k; i++) {
                dp[k][i] = Math.min(dp[k-1][i], arr[i+k]);
                if(max < dp[k][i])
                    max = dp[k][i];
            }
            result[k] = max;
        }
        return result;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void minMaxRiddle(String[] args) {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long[] arr = new long[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            long arrItem = Long.parseLong(arrItems[i]);
            arr[i] = arrItem;
        }

        long[] res = riddle(arr);

        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);

            if (i != res.length - 1) {
                System.out.println(" ");
            }
        }

        System.out.println();

        scanner.close();
    }
}

