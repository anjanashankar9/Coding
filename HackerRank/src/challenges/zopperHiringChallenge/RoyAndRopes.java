package challenges.zopperHiringChallenge;

import java.util.Scanner;

/**
 * Created by ashankar1 on 4/25/15.
 */
public class RoyAndRopes {
    public static void royAndRopes(){
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int i=0;i<T;i++) {
            int L = in.nextInt();
            int upper[] = new int[L-1];
            int lower[] = new int[L-1];
            int singleArr[] = new int[L-1];
            for(int j=0;j<L-1;j++){
                upper[j] = in.nextInt();
            }
            for(int j=0;j<L-1;j++){
                lower[j] = in.nextInt();
            }
            findTime(L,upper,lower);
        }

    }

    private static void findTime(int l, int[] upper, int[] lower) {
        long timeToBurn = 1;
        int remainingTime = l-1;
        for(int i=0;i<l-1;i++){
            remainingTime = Math.max(Math.max(upper[i],lower[i]),remainingTime);
            timeToBurn+=1;
            remainingTime-=1;
        }
        System.out.println(timeToBurn+remainingTime);
    }
}
