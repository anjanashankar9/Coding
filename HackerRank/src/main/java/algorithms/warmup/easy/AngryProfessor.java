package algorithms.warmup.easy; /**
 * Created by ashankar1 on 3/23/15.
 */
import java.util.*;
public class AngryProfessor {

    public static void angryProfessor(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int i=0;i<T;i++){
            int N = in.nextInt();
            int K=in.nextInt();
            int[] arr = new int[N];
            for(int j=0;j<N;j++){
                arr[j]=in.nextInt();
            }
            classCancelled(N,K,arr);
        }
    }
    public static void classCancelled(int N,int K,int[] arr){
        int cnt = 0;
        for(int i=0;i<N;i++){
            if(arr[i]<=0) {
                cnt++;
                if(cnt>=K) {
                    System.out.println("NO");
                    return;
                }
            }
        }
        System.out.println("YES");
        return;
    }
}

/*
Problem Statement

The professor is conducting a course on Discrete Mathematics to a class of N students. He is angry at the lack of their discipline, and he decides to cancel the class if there are less than K students present after the class starts.

Given the arrival time of each student, your task is to find out if the class gets cancelled or not.

Input Format

The first line of the input contains T, the number of test cases. Each test case contains two lines. The first line of each test case contains two space-separated integers, N and K.
The next line contains N space-separated integers indicating the arrival time of each student.

If the arrival time of a given student is a non-positive integer (N≤0), then the student enters before the class starts. If the arrival time of a given student is a positive integer (N>0), the student enters after the class has started. If a student enters the class exactly when it starts (N=0), the student is considered to have entered before the class has started.

Constraints

1≤T≤10
1≤N≤1000
1≤K≤N
The absolute value of arrival time does not exceed 100.

Output Format

For each testcase, print YES if the class gets cancelled and NO otherwise.

Sample Input

2
4 3
-1 -3 4 2
4 2
0 -1 2 1
Sample Output

YES
NO
Explanation

For the first test case, K=3, i.e., the professor wants at least 3 students to be in class but there are only 2 who have arrived on time (−3 and −1), hence the class gets cancelled.

For the second test case, K=2, i.e, the professor wants at least 2 students to be in class and there are 2 who have arrived on time (0 and −1), hence the class does not get cancelled.
 */


//https://www.hackerrank.com/challenges/angry-professor

