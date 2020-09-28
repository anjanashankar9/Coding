package arraysandstrings;

/**
 * @Author Anjana Shankar
 * @Created 2020-09-27
 */
public class OneAway {
    /*
    Strings can at most differ in length by 1.
    if length difference is 1, it can either be insert or remove.
    An insertion in string 2 can be thought of as removal from s1.
    Thus one function can do both these checks.

    If the length difference is zero, at most one character can be different
    between s1 and s2.
     */
    private boolean isOneAway(String s1, String s2) {
        if(Math.abs(s1.length() - s2.length())>1)
            return false;

        // Identifying shorter and longer string.
        String first = s1.length() > s2.length() ? s1 : s2;
        String second = s1.length() <= s2.length() ? s1 : s2;

        int i = 0;
        int j = 0;
        boolean foundDifference = false;

        while(j < second.length() && i < first.length()) {
            if(first.charAt(i) != second.charAt(j)) {
                if(foundDifference)
                    return false;

                foundDifference = true;

                if (first.length() == second.length()) {
                    i++; j++;
                }
                else
                    i++;

            }
            else {
                i++; j++;
            }
        }

        return true;
    }
    public static void oneAway(String[] args) {
        String s1 = "pales";
        String s2 = "pale";
        System.out.println(new OneAway().isOneAway(s1,s2));
    }
}

/*
There are three types of edits that can be performed on strings:
insert a character, remove a character, or replace a character.
Given two strings, write a function to check if they are one edit
(or zero edits) away.
EXAMPLE
pale, ple -> true
pales, pale -> true
pale, bale -> true
pale, bake -> false
 */