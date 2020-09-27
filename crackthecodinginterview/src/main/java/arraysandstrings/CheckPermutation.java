package arraysandstrings;

import java.util.HashMap;

/**
 * @Author Anjana Shankar
 * @Created 2020-09-27
 */
public class CheckPermutation {
    private boolean isPermutation(String s1, String s2) {

        if (s1.length() != s2.length()) {
            return false;
        }
        HashMap<Character, Integer> letterCount = new HashMap<>();

        for(Character c: s1.toCharArray()) {
            if(!letterCount.containsKey(c)) {
                letterCount.put(c, 0);
            }
            letterCount.put(c, letterCount.get(c)+1);
        }

        for(Character c: s2.toCharArray()) {
            if(!letterCount.containsKey(c)) {
                return false;
            }
            letterCount.put(c, letterCount.get(c)-1);
            if(letterCount.get(c) == 0) {
                letterCount.remove(c);
            }
        }

        if (letterCount.size() != 0) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "caa";

        System.out.println(new CheckPermutation().isPermutation(s1,s2));
    }
}

//Check Permutation: Given two strings,write a method to decide if one is a permutation of the
//other.
