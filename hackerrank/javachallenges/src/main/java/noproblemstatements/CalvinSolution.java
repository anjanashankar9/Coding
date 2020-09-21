package noproblemstatements;

import java.util.Scanner;

/**
 * Created by ashankar1 on 4/9/15.
 */
public class CalvinSolution {
    private static int findVehicle(int entry, int exit, int W[], int N){
        int vehicleNumber = 3;
        for(int i=entry;i<=exit;i++){
            if(W[i] < vehicleNumber)
                vehicleNumber = W[i];
        }
        return vehicleNumber;
    }
    public static void calvinSolution(String[] args){
        int[] width = new int[100000];
        Scanner in = new Scanner(System.in);
        int N;
        N = in.nextInt();
        int T = in.nextInt();
        for(int i=0;i<N;i++){
            width[i] = in.nextInt();
        }
        for(int i=0;i<T;i++){
            int entry = in.nextInt();
            int exit = in.nextInt();
            int vehicle = findVehicle(entry,exit,width,N);
            System.out.println(vehicle);
        }
    }
}
