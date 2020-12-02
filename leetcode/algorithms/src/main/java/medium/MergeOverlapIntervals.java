package medium;

import java.util.Arrays;

/**
 * @Author Anjana Shankar
 * @Created 2020-12-02
 */

public class MergeOverlapIntervals {
    public int[][] merge(int[][] intervals) {

            if (intervals == null || intervals.length <= 1)
                return intervals;

            Arrays.sort(intervals, (int[] a, int[] b) -> (a[0]-b[0]));
            int[][] result = new int[intervals.length][2];
            int k = 0;
            result[k++] = intervals[0];

            for (int j=1; j<intervals.length; j++) {
                int i=0;
                for(; i<j; i++) {

                    int low1 = intervals[j][0];
                    int high1 = intervals[j][1];

                    int low2 = result[i][0];
                    int high2 = result[i][1];

                    if(intervals[j][0] > result[i][0]) {
                        low1 = result[i][0];
                        high1 = result[i][1];

                        low2 = intervals[j][0];
                        high2 = intervals[j][1];
                    }

                    if(high1 >= low2) {
                        int low = low1;
                        int high = Math.max(high1, high2);
                        result[i][0] = low;
                        result[i][1] = high;
                    }
                }
                if(i==j) {
                    result[k++] = intervals[j];
                }

            }

            int [][] overlap = new int[k][2];
            for(int i=0; i<k; i++) {
                overlap[i] = result[i];
            }
            return overlap;
    }

    public static void main(String[] args) {
//        int intervals[][] = new int[4][2];
//        intervals[0][0] = 1;
//        intervals[0][1] = 3;
//
//        intervals[1][0] = 2;
//        intervals[1][1] = 6;
//
//        intervals[2][0] = 8;
//        intervals[2][1] = 10;
//
//        intervals[3][0] = 15;
//        intervals[3][1] = 18;

        int intervals[][] = new int[2][2];
        intervals[0][0] = 1;
        intervals[0][1] = 4;

        intervals[1][0] = 0;
        intervals[1][1] = 1;

        int[][] result = new MergeOverlapIntervals().merge(intervals);
        System.out.println("REsSULT");
    }
}
/*
Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.



Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.


Constraints:

1 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti <= endi <= 104
 */
//https://leetcode.com/problems/merge-intervals/