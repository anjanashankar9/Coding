package easy;

/**
 * @Author Anjana Shankar
 * @Created 2020-09-21
 */
public class GreatestElementOnRight {
    public int[] replaceElements(int[] arr) {
        int maxTillNow = arr[arr.length-1];
        arr[arr.length-1] = -1;
        for(int i= arr.length-2; i>=0; i--) {
            int temp = arr[i];
            arr[i] = maxTillNow;
            if(temp > maxTillNow) {
                maxTillNow = temp;
            }
        }
        return arr;
    }

    public static void greatestElementOnRight(String[] args) {
        int[] nums = {17,18,5,4,6,1};
        GreatestElementOnRight ge =
                new GreatestElementOnRight();
        int[] result = ge.replaceElements(nums);
        for(int i: result) {
            System.out.print(i+" ");
        }
    }
}

/*
Given an array arr, replace every element in that array with the greatest element among the elements to its right, and replace the last element with -1.

After doing so, return the array.



Example 1:

Input: arr = [17,18,5,4,6,1]
Output: [18,6,6,6,1,-1]


Constraints:

1 <= arr.length <= 10^4
1 <= arr[i] <= 10^5
 */
//https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side/
