package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author Anjana Shankar
 * @Created 2020-12-23
 */
public class LetterCombinationsofPhoneNumber {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        HashMap<String, String> map = new HashMap<>();

        if (digits.length() == 0)
            return result;
        map.put("2","abc");
        map.put("3","def");
        map.put("4","ghi");
        map.put("5","jkl");
        map.put("6","mno");
        map.put("7","pqrs");
        map.put("8","tuv");
        map.put("9","wxyz");

        backtrack(map, result, "", digits);

        return result;
    }

    public void backtrack(HashMap<String, String> map, List<String> result, String combination, String digits){
        if(digits.length() == 0) {
            result.add(combination);
        }
        else {
            String s = map.get(digits.substring(0,1));
            for (Character c: s.toCharArray()) {
                backtrack(map, result, combination+c, digits.substring(1));
            }
        }
    }
}


/*
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.





Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
Example 2:

Input: digits = ""
Output: []
Example 3:

Input: digits = "2"
Output: ["a","b","c"]


Constraints:

0 <= digits.length <= 4
digits[i] is a digit in the range ['2', '9'].
 */

//https://leetcode.com/problems/letter-combinations-of-a-phone-number/
