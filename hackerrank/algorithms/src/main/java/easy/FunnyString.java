package algorithms.strings.easy;

import java.util.Scanner;

/**
 * Created by ashankar1 on 4/7/15.
 */
public class FunnyString {
    public static void funnyString(){
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int i=0;i<T;i++){
            String s = in.next();
            String isFunny = isFunnyString(s);
            System.out.println(isFunny);
        }
    }

    private static String isFunnyString(String s) {
        StringBuffer orig = new StringBuffer(s);
        int len = s.length();
        for(int j=1;j<len;j++){
            int asciiRev = (int)orig.charAt(len-j);
            int modOrig = (int)orig.charAt(j) - (int)orig.charAt(j-1);
            int modRev = (int)orig.charAt(len-j)- orig.charAt(len-j-1);
            if(Math.abs(modOrig) !=  Math.abs(modRev)){
                return "Not Funny";
            }
        }
        return "Funny";
    }
}

/*
Suppose you have a strings S which has length N and is indexed from 0 to N−1. String R is the reverse of the strings S.
The strings S is funny if the condition |Si−Si−1|=|Ri−Ri−1| is true for every i from 1 to N−1.

(Note: Given a strings str, stri denotes the ascii value of the ith character (0-indexed) of str.
|x| denotes the absolute value of an integer x)

Input Format

First line of the input will contain an integer T. T testcases follow. Each of the next T lines contains one strings S.

Constraints

1<=T<=10
1<=length of S<=10000
Output Format

For each strings, print Funny or Not Funny in separate lines.

Sample Input

2
acxz
bcxz
Sample Output

Funny
Not Funny
Explanation

Consider the 1st testcase acxz

here

|c-a| = |x-z| = 2
|x-c| = |c-x| = 21
|z-x| = |a-c| = 2
Hence Funny.

Consider the 2st testcase bcxz

here

|c-b| != |x-z|
Hence Not Funny.
 */

//https://www.hackerrank.com/challenges/funny-string
