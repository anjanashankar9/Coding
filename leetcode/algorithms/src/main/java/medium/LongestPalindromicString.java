package medium;

/**
 * @Author Anjana Shankar
 * @Created 2020-10-14
 */
public class LongestPalindromicString {

    // Brute Force - On(n*n*n)
    public String longestPalindromeBruteForce(String s) {

        if(s == null || s.length() < 2) {
            return s;
        }

        int start = 0;
        int end = 0;

        int length = s.length();
        for(int i=0; i<length; i++) {
            for(int j=i; j<length; j++) {
                String subStr = s.substring(i, j+1);
                String reverseStr = new StringBuilder(subStr)
                        .reverse().toString();
                if(subStr.equals(reverseStr)) {
                    if ((j-i)> (end - start)) {
                        end = j;
                        start = i;
                    }
                }
            }
        }
        return s.substring(start, end+1);
    }

    // O(N*N) solution - Expanding around middle
    // O(1) space
    public String longestPalindromeExpandMiddle(String s) {

        if(s == null || s.length() < 2) {
            return s;
        }

        int start = 0;
        int end = 0;

        int length = s.length();
        for(int i=0; i<length; i++) {
            // For odd length palindromes
            int len1 = expandFromMiddle(s, i, i);

            //For even length palindromes
            int len2 = expandFromMiddle(s, i, i+1);

            int len = Math.max(len1, len2);

            if(len > end-start) {
                start = i - ((len-1)/2);
                end = i+ ((len/2));
            }
        }
        return s.substring(start, end+1);
    }

    // Helper function for above
    public int expandFromMiddle(String s, int left, int right) {
        if (s== null || left > right) return 0;

        while(left>=0 && right < s.length() && s.charAt(left) ==  s.charAt(right)) {
            left--;
            right++;
        }

        return right-left-1;
    }

    // O(N*N) solution - Dynamic Programming
    // O(N*N) space
    /*
    Base Case:
    All single letter characters are palindromes.
    dp[i][i] = true;
    dp[i][i+1] = dp[i][i] && s[i] == s[i+1];

    From here on we expand for 3 letter, 4 letter and so on palindromes.

    Only one half of the dp matrix matters
    E.g For babad

    base case -  single letter palindromes

             0     1     2    3    4
             b     a     b    a    d

       0 b   T

       1 a         T

       2 b               T

       3 a                    T

       4  d                        T

       Step 2: 2 letter palindromes

             0     1     2    3    4
             b     a     b    a    d

       0 b   T     F

       1 a         T     F

       2 b               T    F

       3 a                    T    F

       4  d                        T

       Step 3: 3 letter palindromes

       dp[i][j] = dp[i-1][j+1] && s[i] == s[j]

             0     1     2    3    4
             b     a     b    a    d

       0 b   T     F

       1 a         T     F

       2 b               T    F

       3 a                    T    F

       4 d                        T


      dp[2][4] = dp[3][3] && s[2] == s[4]
      dp[1][3] = dp[2][2] && s[1] == s[3]
      dp[0][2] = dp[1][1] && s[0] == s[2]

             0     1     2    3    4
             b     a     b    a    d

       0 b   T     F     T

       1 a         T     F    T

       2 b               T    F    F

       3 a                    T    F

       4 d                        T


       4 letter palindromes

       dp[1][4] = dp[2][3] && s[1] == s[4]
       dp[0][3] = dp[1][2] && s[0] == s[3]


             0     1     2    3    4
             b     a     b    a    d

       0 b   T     F     T    F

       1 a         T     F    T    F

       2 b               T    F    F

       3 a                    T    F

       4 d                        T


       5 letter palindromes

       dp[0][4] = dp[1][3] && s[0] == s[4]


             0     1     2    3    4
             b     a     b    a    d

       0 b   T     F     T    F    F

       1 a         T     F    T    F

       2 b               T    F    F

       3 a                    T    F

       4 d                        T

       Traverse the array and see if j-i > end -start.
       If yes update.
       You can do that while filling up the array values as well.


     */
    public String longestPalindromeDynamicProgramming(String s) {

        if(s == null || s.length() == 0) {
            return "";
        }

        int length = s.length();
        boolean[][] dp = new boolean[length][length];
        int start = 0;
        int end = 0;
        int max = 0;

        //base case
        for(int i=0; i< length; i++) {
            dp[i][i] = true;
        }

        // two letter case
        for (int i=0; i< length-1; i++) {
            dp[i][i+1] = dp[i][i] && (s.charAt(i) == s.charAt(i+1));
            if(dp[i][i+1]) {
                start = i;
                end = i+1;
            }
        }

        for(int d=2; d<length; d++) {
            for(int i=0; i<length-d; i++) {
                dp[i][i+d] = dp[i+1][i+d-1] && (s.charAt(i) == s.charAt(i+d));
                if(dp[i][i+d]) {
                    start = i;
                    end = i+d;
                }
            }
        }


        return s.substring(start, end + 1);
    }


    public static void main(String[] args) {
        String s1 = "babad";
        String s2 = "cbbd";
        String s3 = "bb";
        String s4 = "ac";

        System.out.println(new LongestPalindromicString().longestPalindromeDynamicProgramming(s1));
        System.out.println(new LongestPalindromicString().longestPalindromeDynamicProgramming(s2));
        System.out.println(new LongestPalindromicString().longestPalindromeDynamicProgramming(s3));
        System.out.println(new LongestPalindromicString().longestPalindromeDynamicProgramming(s4));

    }

}
/*
Given a string s, return the longest palindromic substring in s.



Example 1:

Input: s = "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"
Example 3:

Input: s = "a"
Output: "a"
Example 4:

Input: s = "ac"
Output: "a"


Constraints:

1 <= s.length <= 1000
s consist of only digits and English letters (lower-case and/or upper-case),
 */
//https://leetcode.com/problems/longest-palindromic-substring/
