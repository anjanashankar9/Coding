package string_manipulation;

import java.util.Scanner;

public class AlternatingCharacters {

    public static void alternatingCharacters(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int i=0;i<T;i++){
            String s = in.next();
            int delReqd = deletionsReqd(s);
            System.out.println(delReqd);
        }
    }
    private static int deletionsReqd(String s) {
        int count=0;
        int len = s.length();
        char prevChar = s.charAt(0);
        for(int i=1;i<len;i++){
            char currChar = s.charAt(i);
            if(currChar == prevChar){
                count++;
            }
            else{
                prevChar = currChar;
            }
        }
        return count;
    }
}

/*
    You are given a string containing characters  and  only. Your task is to change it into a string such that there are no matching adjacent characters. To do this, you are allowed to delete zero or more characters in the string.

Your task is to find the minimum number of required deletions.

For example, given the string , remove an  at positions  and  to make  in  deletions.

Function Description

Complete the alternatingCharacters function in the editor below. It must return an integer representing the minimum number of deletions to make the alternating string.

alternatingCharacters has the following parameter(s):

s: a string
Input Format

The first line contains an integer , the number of queries.
The next  lines each contain a string .

Constraints

Each string  will consist only of characters  and
Output Format

For each query, print the minimum number of deletions required on a new line.

Sample Input

5
AAAA
BBBBB
ABABABAB
BABABA
AAABBB
Sample Output

3
4
0
0
4
Explanation

The characters marked red are the ones that can be deleted so that the string doesn't have matching consecutive characters.

image
 */

//https://www.hackerrank.com/challenges/alternating-characters/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=strings