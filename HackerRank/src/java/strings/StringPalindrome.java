package java.strings;

import java.util.Scanner;

public class StringPalindrome {

    public static void stringPalindrome(String[] args) {

        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        /* Enter your code here. Print output to STDOUT. */
        StringBuffer s = new StringBuffer(A);
        if(A.equals(s.reverse().toString())) {
            System.out.println("Yes");
        }
        else {
            System.out.println("No");
        }
    }
}


/*
Given a string , print Yes if it is a palindrome, print No otherwise.

Constraints

 will consist at most  lower case english letters.
Sample Input

madam
Sample Output

Yes
 */
