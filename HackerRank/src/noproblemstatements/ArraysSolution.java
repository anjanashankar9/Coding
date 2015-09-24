package noproblemstatements;

import java.util.Scanner;

/**
 * Created by ashankar1 on 4/9/15.
 */
public class ArraysSolution {
    public static void arraysSolution(){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int arr[] = new int[N];
        for(int i=0;i<N;i++){
            arr[i] = in.nextInt();
        }
        countShifts(arr);

    }
    private static void countShifts(int arr[]){
        int shifts=0;
        int N=arr.length;
        for(int i=1;i<N;i++){
            for(int j=0;j<i;j++){
                while(arr[j]>arr[i]){
                    int temp=arr[j];
                    arr[j]=arr[i];
                    arr[i]=temp;
                    shifts++;
                }
            }
        }
        System.out.println(shifts);
    }
}
