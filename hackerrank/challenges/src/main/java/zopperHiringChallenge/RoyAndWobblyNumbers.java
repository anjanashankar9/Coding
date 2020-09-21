package zopperHiringChallenge;

import java.util.Scanner;

/**
 * Created by ashankar1 on 4/25/15.
 */
public class RoyAndWobblyNumbers {

    public static void royWobblyNumbers(){
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int i=0;i<T;i++){
            int N = in.nextInt();
            int K = in.nextInt();
            findWobbly(N,K);
        }
    }

    private static void findWobbly(int n, int k) {
        StringBuilder number = new StringBuilder();
        int i=1;
        int j=-1;
        int l=0;
        int count =0;
        while(count<k) {
            if(j==9){
                i+=1;
                j=0;
            }
            else {
                j = j + 1;
                if(j==i){
                    j=j+1;
                }
            }
            if(i>=9 && j>=9)
                break;
            number.setLength(0);
            l=0;
            while (l < n) {
                if (l % 2 == 0) {
                    number.append(i);
                } else
                    number.append(j);
                l++;
            }
            count++;
        }
        if(count==k)
            System.out.println(number);
        else
            System.out.println(-1);
    }

}


/*
Roy is looking for Wobbly Numbers.

An N-length wobbly number is of the form "ababababab..." and so on of length N, where a != b.

A 3-length wobbly number would be of form "aba".
Eg: 101, 121, 131, 252, 646 etc
But 111, 222, 999 etc are not 3-length wobbly number, because here a != b condition is not satisfied.
Also 010 is not a 3-length wobbly number because it has preceding 0. So 010 equals 10 and 10 is not a 3-length wobbly number.

A 4-length wobbly number would be of form "abab".
Eg: 2323, 3232, 9090, 1414 etc

Similarly we can form a list of N-length wobbly numbers.

Now your task is to find Kth wobbly number from a lexicographically sorted list of N-length wobbly numbers. If the number does not exist print -1 else print the Kth wobbly number. See the sample test case and explanation for more clarity.

Input:
First line contains T - number of test cases
Each of the next T lines contains two space separated integers - N and K.

Output:
For each test case print the required output in a new line.

Constraints:
1 ≤ T ≤ 100
3 ≤ N ≤ 1000
1 ≤ K ≤ 100

Sample Input(Plaintext Link)
 6
3 1
3 2
3 100
4 3
4 4
5 2
Sample Output(Plaintext Link)
 101
121
-1
1313
1414
12121
Explanation
<p>First 10 terms of 3-length wobbly numbers arranged lexicographically is as follows:
101, 121, 131, 141, 151, 161, 171, 181, 191, 202</p>

<p>1st wobbly number of length 3 is 101.
2nd wobbly number of length 3 is 121.
100th wobbly number of length 3 does not exist, so the output is -1.</p>

<p>First 10 terms of 4-length wobbly numbers arranged lexicographically is as follows:
1010, 1212, 1313, 1414, 1515, 1616, 1717, 1818, 1919, 2020</p>

<p>3rd wobbly number of length 4 is 1313.
4th wobbly number of length 4 is 1414.</p>

<p>Similarly 2nd wobbly number of length 5 is 12121</p>

 */

//https://www.hackerearth.com/zopper-hiring-challenge/problems/8ef87146cd0f997fe14a12ff8fad495c/