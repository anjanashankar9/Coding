package arraysandstrings;

/**
 * @Author Anjana Shankar
 * @Created 2020-09-27
 */
public class StringRotation {
    /*
    If s2 is a rotated string of s1 then that means you can represent
    these strings as:
    s1 = xy
    s2 = yx

    Thus, s2 will definitely be a substring of xyxy that is s1s1.
    This is the property we will be testing.
     */
    private boolean isRotatedString(String s1, String s2) {
        String s = new String(s1+s1);
        return s.contains(s2);
    }

    public static void stringRotation(String args[]) {
        String s1 = "waterbottle";
        String s2 = "erbottlewat";
        System.out.println(new StringRotation().isRotatedString(s1, s2));
    }
}

/*
Assumeyou have a method isSubstring which checks if one word
is a substring of another.
Given two strings, sl and s2, write code to check if s2 is a
rotation of sl using only one call to
isSubstring (e.g.,"waterbottle" is a rotation of"erbottlewat").
 */
