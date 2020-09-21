package recursion_backtracking;

import java.util.Scanner;

public class DavisStairs {

    // Complete the stepPerms function below.
    static long stepPerms(int n) {
        int []resultArray = new int[n];
        if (n==1)
            return 1;
        if (n == 2)
            return 2;
        if (n == 3)
            return 4;
        resultArray[0] = 1; // permutations[1] = 1
        resultArray[1] = 2; // permutations[2] = 2
        resultArray[2] = 4; // permutations[3] = 4

        for (int i=3; i<n; i++) {
            resultArray[i] = resultArray[i-1] + resultArray[i-2] +
                    resultArray[i-3];
        }

        long number = 10000000007l;
        return resultArray[n-1] % number;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void davisStairs(String[] args) {

        int s = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int sItr = 0; sItr < s; sItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            long res = stepPerms(n);

            System.out.println(res);
        }

        scanner.close();
    }
}
