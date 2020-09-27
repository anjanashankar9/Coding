package arraysandstrings;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @Author Anjana Shankar
 * @Created 2020-09-27
 */
public class IsUnique {
    private boolean isUniq(String s) {
        HashSet<Character> hashset = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (hashset.contains(c)) {
                return false;
            }
            hashset.add(c);
        }
        return true;
    }
    public static void isUniq(String[] args) {
        String s = "anjana";
        System.out.println(new IsUnique().isUniq(s));
    }
}

//Implement an algorithm to determine if a string has all unique characters. What if you cannot use additional data structures?
