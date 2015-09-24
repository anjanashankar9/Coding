package algorithms.warmup.easy;

import java.util.Scanner;

/**
 * Created by ashankar1 on 4/9/15.
 */
public class UtopianTree {
    public static void utopianTree(){
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();

        for(int i=0;i<T;i++){
            int N = in.nextInt();
            int growth = findHeight(N);
            System.out.println(growth);
        }
    }
    private static int findHeight(int N){
        int height = 1;

        for(int i=1;i<=N;i++){
            if(i%2 == 1)
                height = height*2;
            else
                height+=1;
        }
        return height;
    }
}

/*
The Utopian Tree goes through 2 cycles of growth every year. The first growth cycle occurs during the spring, when it doubles in height.
The second growth cycle occurs during the summer, when its height increases by 1 meter.

Now, a new Utopian Tree sapling is planted at the onset of spring. Its height is 1 meter.
Can you find the height of the tree after N growth cycles?

Input Format

The first line contains an integer, T, the number of test cases.
T lines follow; each line contains an integer, N, that denotes the number of cycles for that test case.

Constraints
1≤T≤10
0≤N≤60
Output Format

For each test case, print the height of the Utopian Tree after N cycles. Each line thus has to contain a single integer, only.

Sample Input

3
0
1
4
Sample Output

1
2
7
Explanation

There are 3 test cases.

In the first case (N=0), the height of the tree remains unchanged.

In the second case (when N = 1, i.e. after the 1st cycle), the tree doubles its height as it's planted at the onset of spring.

In the third case (N=4), the tree first doubles its height (2), then grows a meter (3), then doubles again (6),
before growing another meter; at the end of the 4th cycle, its height is 7 meters.
*/

//https://www.hackerrank.com/challenges/utopian-tree