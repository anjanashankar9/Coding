package algorithms.strings.easy;

import java.util.Scanner;

/**
 * Created by ashankar1 on 4/7/15.
 */
public class AlternatingCharacters {
    public static void altChars(){
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
Shashank likes strings in which consecutive characters are different. For example, he likes ABABA, while he doesn't like ABAA.
Given a string containing characters A and B only, he wants to change it into a string he likes.
To do this, he is allowed to delete the characters in the string.

Your task is to find the minimum number of required deletions.

Input Format

The first line contains an integer T, i.e. the number of test cases.
The next T lines contain a string each.

Output Format

For each test case, print the minimum number of deletions required.

Constraints

1≤T≤10
1≤ length of string ≤105
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

AAAA ⟹ A, 3 deletions
BBBBB ⟹ B, 4 deletions
ABABABAB ⟹ ABABABAB, 0 deletions
BABABA ⟹ BABABA, 0 deletions
AAABBB ⟹ AB, 4 deletions
 */

//https://www.hackerrank.com/challenges/alternating-characters
