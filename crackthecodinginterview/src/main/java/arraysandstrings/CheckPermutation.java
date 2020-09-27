package arraysandstrings;

import java.util.Arrays;
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

    private boolean isPermutationWithSorting(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        return new String(c1).equals(new String(c2));
    }


    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "cas";

        System.out.println(new CheckPermutation().isPermutationWithSorting(s1,s2));
    }
}

//Check Permutation: Given two strings,write a method to decide if one is a permutation of the
//other.
