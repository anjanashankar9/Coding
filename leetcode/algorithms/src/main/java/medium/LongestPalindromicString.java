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

    // O(N*N) solution - Expanding around middle
    // O(N*N) space
    public String longestPalindromeDynamicProgramming(String s) {

        if(s == null || s.length() == 0) {
            return "";
        }
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        int start = 0;
        int end = 0;
        int max = 0;
        for(int i = 0; i < s.length(); i++) {
            for(int j = 0; j <= i; j++) {
                if(s.charAt(i) == s.charAt(j) && (i - j <= 2 || dp[j+1][i-1])) {
                    dp[j][i] = true;
                }
                if(dp[j][i] && max < i - j + 1) {
                    max = i - j + 1;
                    start = j;
                    end = i;
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
