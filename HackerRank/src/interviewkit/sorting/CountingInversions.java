package interviewkit.sorting;

public class CountingInversions {

    // Complete the countInversions function below.
    //O(n*n) solution
    static long countInversions(int[] arr) {
        long inversions = 0;
        int n = arr.length;
        for(int i=0;i<n; i++) {
            for (int j=i+1; j<n; j++) {
                if (arr[i] > arr[j]) {
                    inversions++;
                }
            }
        }
        return inversions;
    }

    //O(nlogn) solution
    //Using merge sort differently.ß
    static long countInversions2(int[] arr) {
        long inversions = 0;
        inversions = mergeSort(arr);
        return inversions;
    }

    public static long mergeSort(int [] arr){
        long inversions = mergeSort(arr,0,arr.length - 1);
        return inversions;
    }

    private static long mergeSort(int[]arr,int low,int high){
        int inversions = 0;
        if (high <=low)
            return 0;
        int  middle = (low+high)/2 ;
        long inversionsLeft = mergeSort(arr,low,middle);
        long inversionsRight = mergeSort(arr,middle+1,high);
        inversions += inversionsLeft+ inversionsRight + merge(arr,low,middle,high);
        return inversions;
    }

    private static long merge(int[] arr, int low, int middle, int high){
        long inversions = 0;
        int[] helper = new int[arr.length];
        int helperLength = middle-low+1;
        for(int i=low;i<=high;i++){
            helper[i] = arr[i];
        }

        int i=low;
        int j=middle+1;
        int k=low;

        while(i<=middle && j<=high){
            if(helper[i]<=helper[j]){
                arr[k] = helper[i];
                helperLength--;
                k++;i++;
            }
            else{
                inversions += helperLength;
                arr[k] = helper[j];
                k++;j++;
            }
        }
        while(i<=middle){
            arr[k] = helper[i];
            i++;k++;
        }
        while(j<=high){
            arr[k]=helper[j];
            k++;
            j++;
        }
        return inversions;
    }


    public static void countingInversions(String[] args)  {
        int n=5;
        long result = 0;
//        int[] arr1 = {1, 1, 1, 2, 2 };
//        result = countInversions2(arr1);
//        System.out.println(result);

        int[] arr2 = {2, 1, 3, 1, 2};
        result = countInversions2(arr2);
        System.out.println(result);

        int[] arr3 = {7, 5, 3, 1};
        result = countInversions2(arr3);
        System.out.println(result);


    }
}

/*
In an array, , the elements at indices  and  (where ) form an inversion if . In other words, inverted elements  and  are considered to be "out of order". To correct an inversion, we can swap adjacent elements.

For example, consider the dataset . It has two inversions:  and . To sort the array, we must perform the following two swaps to correct the inversions:

Given  datasets, print the number of inversions that must be swapped to sort each dataset on a new line.

Function Description

Complete the function countInversions in the editor below. It must return an integer representing the number of inversions required to sort the array.

countInversions has the following parameter(s):

arr: an array of integers to sort .
Input Format

The first line contains an integer, , the number of datasets.

Each of the next  pairs of lines is as follows:

The first line contains an integer, , the number of elements in .
The second line contains  space-separated integers, .
Constraints

Output Format

For each of the  datasets, return the number of inversions that must be swapped to sort the dataset.

Sample Input

2
5
1 1 1 2 2
5
2 1 3 1 2
Sample Output

0
4
Explanation

We sort the following  datasets:

 is already sorted, so there are no inversions for us to correct. Thus, we print  on a new line.
We performed a total of  swaps to correct inversions.
 */

//https://www.hackerrank.com/challenges/ctci-merge-sort/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=sorting