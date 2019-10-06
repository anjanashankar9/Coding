package interviewkit.sorting;



import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class FraudulentActivityNotifications {

    // Complete the activityNotifications function below.
    //O(ndlogd) solution
    static int activityNotifications(int[] expenditure, int d) {
        int notifications = 0;

        if (expenditure.length <= d)
            return 0;
        for (int i=d+1; i<expenditure.length; i++) {
            double median = findMedian (expenditure, i-d-1, d);
            if (expenditure[i] >= 2*median)
                notifications++;
        }

        return notifications;
    }

    private static double findMedian(int[] expenditure, int start, int d) {
        int[] arr = new int[d];

        for (int i=start, j=0; i<d; i++, j++) {
            arr[j] = expenditure[i];
        }

        Arrays.sort(arr);

        double median = 0;
        if (arr.length % 2 == 1) {
            median = arr[arr.length /2];
        }
        else {
            median = (arr[(arr.length/2) - 1] + arr[arr.length /2])/2.0;
        }
        return median;
    }

    //O(n*d) solution
    static int activityNotifications2(int[] expenditure, int d) {
        int notifications = 0;
        int[] countSort = new int[201];

        if (expenditure.length <= d)
            return 0;

        for(int i=0; i<d; i++) {
            countSort[expenditure[i]]++;
        }

        for(int i=d; i<expenditure.length; i++) {
            double median = findMedian(countSort, d);
            if (expenditure[i] >= 2*median)
                notifications++;
            countSort[expenditure[i-d]]--;
            countSort[expenditure[i]]++;

        }

        return notifications;
    }


    static double findMedian(int[] countSort, int d) {

        int left = -1;
        int right = 0;
        if (d%2 == 0) {
            // if d is even, median is average of 2 numbers.
            int count = 0;
            int mid = d/2;
            for (int i=0 ; i<201; i++) {
                count += countSort[i];
                if (count >= mid) {
                    left = i;
                    if (count == mid)
                        right = i+1;
                    else
                        right = i;
                    return (left + right)/2.0;
                }
            }

        }
        else {
            // if d is odd, median is the middle number.
            int count = 0;
            int mid = d/2;
            for (int i=0 ; i<201; i++) {
                count += countSort[i];
                if (count >= mid+1)
                    return i;
            }
        }
        return 0;
    }


    public static void fraudulentActivityNotification(String[] args){

//        int n = 9;
//
//        int d = 5;
//
//        int[] expenditure = {2, 3, 4, 2, 3, 6, 8, 4, 5};

        int n = 5;

        int d = 4;

        int[] expenditure = {1,2,3,4,4};


        int result = activityNotifications2(expenditure, d);

        System.out.println(result);

    }
}

/*
HackerLand National Bank has a simple policy for warning clients about possible fraudulent account activity. If the amount spent by a client on a particular day is greater than or equal to  the client's median spending for a trailing number of days, they send the client a notification about potential fraud. The bank doesn't send the client any notifications until they have at least that trailing number of prior days' transaction data.

Given the number of trailing days  and a client's total daily expenditures for a period of  days, find and print the number of times the client will receive a notification over all  days.

For example,  and . On the first three days, they just collect spending data. At day , we have trailing expenditures of . The median is  and the day's expenditure is . Because , there will be a notice. The next day, our trailing expenditures are  and the expenditures are . This is less than  so no notice will be sent. Over the period, there was one notice sent.

Note: The median of a list of numbers can be found by arranging all the numbers from smallest to greatest. If there is an odd number of numbers, the middle one is picked. If there is an even number of numbers, median is then defined to be the average of the two middle values. (Wikipedia)

Function Description

Complete the function activityNotifications in the editor below. It must return an integer representing the number of client notifications.

activityNotifications has the following parameter(s):

expenditure: an array of integers representing daily expenditures
d: an integer, the lookback days for median spending
Input Format

The first line contains two space-separated integers  and , the number of days of transaction data, and the number of trailing days' data used to calculate median spending.
The second line contains  space-separated non-negative integers where each integer  denotes .

Constraints

Output Format

Print an integer denoting the total number of times the client receives a notification over a period of  days.

Sample Input 0

9 5
2 3 4 2 3 6 8 4 5
Sample Output 0

2
Explanation 0

We must determine the total number of  the client receives over a period of  days. For the first five days, the customer receives no notifications because the bank has insufficient transaction data: .

On the sixth day, the bank has  days of prior transaction data, , and  dollars. The client spends  dollars, which triggers a notification because : .

On the seventh day, the bank has  days of prior transaction data, , and  dollars. The client spends  dollars, which triggers a notification because : .

On the eighth day, the bank has  days of prior transaction data, , and  dollars. The client spends  dollars, which does not trigger a notification because : .

On the ninth day, the bank has  days of prior transaction data, , and a transaction median of  dollars. The client spends  dollars, which does not trigger a notification because : .

Sample Input 1

5 4
1 2 3 4 4
Sample Output 1

0
There are  days of data required so the first day a notice might go out is day . Our trailing expenditures are  with a median of  The client spends  which is less than  so no notification is sent.
 */

//https://www.hackerrank.com/challenges/fraudulent-activity-notifications/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=sorting
