package easy;

import java.util.HashSet;

/**
 * @Author Anjana Shankar
 * @Created 2020-09-21
 */
public class JewelsAndStones {
    public int numJewelsInStones(String J, String S) {
        int jewels = 0;
        HashSet<Character> jArray = new HashSet<>();
        for(char c: J.toCharArray()) {
            jArray.add(c);
        }
        for(char c : S.toCharArray()) {
            if (jArray.contains(c)) {
                jewels++;
            }
        }
        return jewels;
    }

    public static void jewelsAndStones(String[] args) {
        JewelsAndStones js = new JewelsAndStones();
        String j = "aA";
        String s = "aAAbbbb";
        int result = js.numJewelsInStones(j, s);
        System.out.println(result);
    }
}
/*
You're given strings J representing the types of stones that are jewels, and S representing the stones you have.  Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.

The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive, so "a" is considered a different type of stone from "A".

Example 1:

Input: J = "aA", S = "aAAbbbb"
Output: 3
Example 2:

Input: J = "z", S = "ZZ"
Output: 0
Note:

S and J will consist of letters and have length at most 50.
The characters in J are distinct.
 */
//https://leetcode.com/problems/jewels-and-stones/
