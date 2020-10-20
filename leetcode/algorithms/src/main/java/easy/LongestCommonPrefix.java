package easy;

/**
 * @Author Anjana Shankar
 * @Created 2020-10-20
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder prefix = new StringBuilder();

        if (strs.length == 0)
            return "";

        if (strs.length==1) {
            return strs[0];
        }

        for(int i=0; i< strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for(int j=1; j<strs.length; j++) {
                if(strs[j].length()<i+1) {
                    return prefix.toString();
                }
                if(strs[j].charAt(i) != c) {
                    return prefix.toString();
                }
            }
            prefix.append(c);
        }

        return prefix.toString();
    }

    public static void main(String[] args) {

//        String[] strs1 = new String[]{"flower","flow","flight"};
//        String[] strs2 = new String[]{"dog","racecar","car"};
        String[] strs3 = new String[]{"ab","a"};

//        System.out.println(new LongestCommonPrefix().longestCommonPrefix(strs1));
//        System.out.println(new LongestCommonPrefix().longestCommonPrefix(strs2));
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(strs3));

    }
}

/*
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".



Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.


Constraints:

0 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lower-case English letters.
 */

//https://leetcode.com/problems/longest-common-prefix/
