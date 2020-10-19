package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Anjana Shankar
 * @Created 2020-10-19
 */
public class RomanToInt {
    public int romanToInt(String s) {
        int result = 0;

        Map<Character, Integer> mappings = new HashMap<>();
        mappings.put('I', 1);
        mappings.put('V', 5);
        mappings.put('X', 10);
        mappings.put('L', 50);
        mappings.put('C', 100);
        mappings.put('D', 500);
        mappings.put('M', 1000);

        for(int i=0; i<s.length(); i++) {
            //II = 1+1
            //V = 5
            //IV = 1-5
            //XI = 10+1
            //IX = 10 - 1
            if(i+1 < s.length() &&
                    mappings.get(s.charAt(i)) < mappings.get(s.charAt(i+1))) {
                result -= mappings.get(s.charAt(i));
            }
            else {
                result += mappings.get(s.charAt(i));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s1 = "III";
        String s2 = "IV";
        String s3 = "IX";
        String s4 = "LVIII";
        String s5 = "MCMXCIV";

        System.out.println(new RomanToInt().romanToInt(s1));
        System.out.println(new RomanToInt().romanToInt(s2));
        System.out.println(new RomanToInt().romanToInt(s3));
        System.out.println(new RomanToInt().romanToInt(s4));
        System.out.println(new RomanToInt().romanToInt(s5));
    }
}

/*
Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9.
X can be placed before L (50) and C (100) to make 40 and 90.
C can be placed before D (500) and M (1000) to make 400 and 900.
Given a roman numeral, convert it to an integer.

 */

//https://leetcode.com/problems/roman-to-integer/
