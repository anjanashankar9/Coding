package interviewkit.dictionaries_and_hashmaps;


import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class TwoStrings {

    // Complete the twoStrings function below.
    // O(mn) solution
    static String twoStrings(String s1, String s2) {

        int m = s1.length();
        int n = s2.length();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    return "YES";
                }
            }
        }

        return "NO";
    }

    //O(n) solution
    static String twoStrings2(String s1, String s2) {

        int m = s1.length();
        int n = s2.length();

        Set<Character> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            set.add(s1.charAt(i));
        }

        for(int j=0;j<n;j++) {
            if (set.contains(s2.charAt(j))){
                return "YES";
            }
        }

        return "NO";
    }

    public static void twoStrings(String[] args) {

        int q = 2;

        String s1 = "hello";

        String s2 = "world";

        String result = twoStrings(s1, s2);

        System.out.println(result);

        String s3 = "hi";

        String s4 = "world";

        result = twoStrings(s3, s4);
        System.out.println(result);

    }
}


/*
Given two strings, determine if they share a common substring. A substring may be as small as one character.

For example, the words "a", "and", "art" share the common substring . The words "be" and "cat" do not share a substring.

Function Description

Complete the function twoStrings in the editor below. It should return a string, either YES or NO based on whether the strings share a common substring.

twoStrings has the following parameter(s):

s1, s2: two strings to analyze .
Input Format

The first line contains a single integer , the number of test cases.

The following  pairs of lines are as follows:

The first line contains string .
The second line contains string .
Constraints

 and  consist of characters in the range ascii[a-z].
Output Format

For each pair of strings, return YES or NO.

Sample Input

2
hello
world
hi
world
Sample Output

YES
NO
Explanation

We have  pairs to check:

, . The substrings  and  are common to both strings.
, .  and  share no common substrings.
 */

//https://www.hackerrank.com/challenges/two-strings/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps