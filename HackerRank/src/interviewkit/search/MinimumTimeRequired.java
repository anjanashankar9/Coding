package interviewkit.search;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MinimumTimeRequired {

    // Complete the minTime function below.
    static long minTime(long[] machines, long goal) {
        long minTime = 0;
        Arrays.sort(machines);
        int n = machines.length;

        long max = (long)Math.ceil((goal* machines[n-1] / n));
        long min = (long)Math.floor((goal* machines[0] / n));

        minTime = modifiedBinarySearch(min, max, goal, machines);
        return minTime;

    }

    static long modifiedBinarySearch(long min, long max, long goal, long[] machines) {
        if (min > max)
            if (getProductionInXDays(max, machines) == goal)
                return max;
            else
                return max+1;
        long mid = (min+max)/2;
        long production = getProductionInXDays(mid, machines);
        if (production == goal) {
            //Need to go one day further below and see if one day before also same goal could be produced.
            long i=mid;
            while(i >= min) {
                if (production == goal)
                    i = i-1;
                else
                    return i+1;

            }
            return mid;
        }
        else if (production > goal)
            return modifiedBinarySearch(min, mid-1, goal, machines);
        else
            return modifiedBinarySearch(mid+1, max, goal, machines);
    }

    static long getProductionInXDays(long days, long[] machines) {
        long production = 0;
        int n = machines.length;
        for (int i=0; i<n; i++) {
            production += Math.floor(days/machines[i]);
        }
        return production;
    }

//    public static void minimumTimeRequired(String[] args) {
//
//        int n = 3;
//
//        long goal = 10;
//
//        long[] machines = {1,3, 4};
//
//        long ans = minTime(machines, goal);
//
//        System.out.println(ans);
//    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void minimumTimeRequired(String[] args) {

        String[] nGoal = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nGoal[0]);

        long goal = Long.parseLong(nGoal[1]);

        long[] machines = new long[n];

        String[] machinesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            long machinesItem = Long.parseLong(machinesItems[i]);
            machines[i] = machinesItem;
        }

        long ans = minTime(machines, goal);
        System.out.println(ans);
        scanner.close();
    }
}


/*
You are planning production for an order. You have a number of machines that each have a fixed number of days to produce an item. Given that all the machines operate simultaneously, determine the minimum number of days to produce the required order.

For example, you have to produce  items. You have three machines that take  days to produce an item. The following is a schedule of items produced:

Day Production  Count
2   2               2
3   1               3
4   2               5
6   3               8
8   2              10
It takes  days to produce  items using these machines.

Function Description

Complete the minimumTime function in the editor below. It should return an integer representing the minimum number of days required to complete the order.

minimumTime has the following parameter(s):

machines: an array of integers representing days to produce one item per machine
goal: an integer, the number of items required to complete the order
Input Format

The first line consist of two integers  and , the size of  and the target production.
The next line contains  space-separated integers, .

Constraints

Output Format

Return the minimum time required to produce  items considering all machines work simultaneously.

Sample Input 0

2 5
2 3
Sample Output 0

6
Explanation 0

In  days  can produce  items and  can produce  items. This totals up to .

Sample Input 1

3 10
1 3 4
Sample Output 1

7
Explanation 1

In  minutes,  can produce  items,  can produce  items and  can produce  item, which totals up to .

Sample Input 2

3 12
4 5 6
Sample Output 2

20
Explanation 2

In  days  can produce  items,  can produce , and  can produce .
 */

//https://www.hackerrank.com/challenges/minimum-time-required/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=search
