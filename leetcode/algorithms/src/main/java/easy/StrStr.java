package easy;

/**
 * @Author Anjana Shankar
 * @Created 2020-10-24
 */
public class StrStr {
    public int strStr(String haystack, String needle) {
        if (needle.equals("") || haystack.equals(needle))
            return 0;

        int haystackLength = haystack.length();
        int needleLength = needle.length();

        if(needleLength > haystackLength)
            return -1;
        int i=0;
        int j=0;
        while(i<haystackLength) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                if (j == needleLength - 1) {
                    return i - needleLength + 1;
                }
                i++;
                j++;
            } else {
                //resetPointers
                i = i - j + 1;
                j = 0;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String haystack1 = "hello";
        String needle1 = "ll";

        System.out.println(new StrStr().strStr(haystack1, needle1));

        String haystack2 = "abc";
        String needle2 = "c";

        System.out.println(new StrStr().strStr(haystack2, needle2));

        String haystack3 = "mississippi";
        String needle3 = "issip";

        System.out.println(new StrStr().strStr(haystack3, needle3));
    }
}

/*
Implement StrStr().

Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Clarification:

What should we return when needle is an empty string? This is a great question to ask during an interview.

For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().



Example 1:

Input: haystack = "hello", needle = "ll"
Output: 2
Example 2:

Input: haystack = "aaaaa", needle = "bba"
Output: -1
Example 3:

Input: haystack = "", needle = ""
Output: 0


Constraints:

0 <= haystack.length, needle.length <= 5 * 104
haystack and needle consist of only lower-case English characters.
 */

//https://leetcode.com/problems/implement-strstr/
