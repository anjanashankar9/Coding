package easy;

import java.util.HashMap;

/**
 * @Author Anjana Shankar
 * @Created 2020-10-25
 */
public class CountAndSay {

    public String say(String s) {
        StringBuilder sb = new StringBuilder();

        int i=0;
        while(i<s.length()) {
            int cnt=1;
            while(++i<s.length() && s.charAt(i) == s.charAt(i-1)) {
                cnt++;
            }
            sb.append(cnt);
            sb.append(s.charAt(i-1));
        }

        return sb.toString();
    }

    public String countAndSay(int n) {
        if (n==1)
            return "1";
        return say(countAndSay(n-1));
    }

    public static void main(String[] args) {
//        String s = "3322251";
        String s = "3333";
        System.out.println(new CountAndSay().countAndSay(4));
        System.out.println(new CountAndSay().countAndSay(5));
        System.out.println(new CountAndSay().countAndSay(6));
    }

}

/*
The count-and-say sequence is a sequence of digit strings defined by the recursive formula:

countAndSay(1) = "1"
countAndSay(n) is the way you would "say" the digit string from countAndSay(n-1), which is then converted into a different digit string.
To determine how you "say" a digit string, split it into the minimal number of groups so that each group is a contiguous section all of the same character. Then for each group, say the number of characters, then say the character. To convert the saying into a digit string, replace the counts with a number and concatenate every saying.

For example, the saying and conversion for digit string "3322251":


Given a positive integer n, return the nth term of the count-and-say sequence.



Example 1:

Input: n = 1
Output: "1"
Explanation: This is the base case.
Example 2:

Input: n = 4
Output: "1211"
Explanation:
countAndSay(1) = "1"
countAndSay(2) = say "1" = one 1 = "11"
countAndSay(3) = say "11" = two 1's = "21"
countAndSay(4) = say "21" = one 2 + one 1 = "12" + "11" = "1211"
countAndSay(5) = say "1211" = one 1 + one 2+ two 1 = "111221"
countAndSay(6) = say "111221" = three 1 + two 2 + one 1 = "312211"
 */

//https://leetcode.com/problems/count-and-say/