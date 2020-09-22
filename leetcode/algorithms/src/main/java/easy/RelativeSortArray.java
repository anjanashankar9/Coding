package easy;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @Author Anjana Shankar
 * @Created 2020-09-22
 */
public class RelativeSortArray {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length];

        int temp = 0;

        HashSet<Integer> set = new HashSet<Integer>();

        for(int n : arr2){
            set.add(n);
        }

        //Add all elements from arr2
        for(int i = 0; i< arr2.length; i++){
            for(int j = 0; j<arr1.length; j++){

                if(arr2[i] == arr1[j]){

                    result[temp] = arr2[i];
                    temp++;
                }
            }
        }

        // add rest of elements from arr1;
        Arrays.sort(arr1);
        for(int i = 0; i<arr1.length; i++){

            if(!set.contains(arr1[i])){

                result[temp] = arr1[i];
                temp++;
            }
        }

        return result;
    }

    public static void relativeSortArray(String[] args) {
        int[] arr1 = {2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2 = {2,1,4,3,9,6};
        RelativeSortArray rs = new RelativeSortArray();
        int [] result = rs.relativeSortArray(arr1, arr2);
        for(int i=0; i<result.length; i++) {
            System.out.print(result[i]+" ");
        }
    }
}

/*
Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in arr2 are also in arr1.

Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in arr2.  Elements that don't appear in arr2 should be placed at the end of arr1 in ascending order.



Example 1:

Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
Output: [2,2,2,1,4,3,3,9,6,7,19]


Constraints:

arr1.length, arr2.length <= 1000
0 <= arr1[i], arr2[i] <= 1000
Each arr2[i] is distinct.
Each arr2[i] is in arr1.
 */
//https://leetcode.com/problems/relative-sort-array/
