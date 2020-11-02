package easy;

/**
 * @Author Anjana Shankar
 * @Created 2020-11-02
 */
public class LastWordLength {
    public int lengthOfLastWord(String s) {

        s = s.trim();
        if(!s.contains(" ")) {
            return s.length();
        }
        int l = s.length()-1;
        int cnt = 0;
        while(l>=0 && s.charAt(l)!=' ') {
            cnt++;
            l--;
        }
        return cnt;
    }

    public static void main(String[] args) {
        String s1 = "Hello World";
        String s2 = "H";
        String s3 = " ";
        String s4 = "a ";
        System.out.println(new LastWordLength().lengthOfLastWord(s1));
        System.out.println(new LastWordLength().lengthOfLastWord(s2));
        System.out.println(new LastWordLength().lengthOfLastWord(s3));
        System.out.println(new LastWordLength().lengthOfLastWord(s4));
    }
}

/*
Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word (last word means the last appearing word if we loop from left to right) in the string.

If the last word does not exist, return 0.

Note: A word is defined as a maximal substring consisting of non-space characters only.

Example:

Input: "Hello World"
Output: 5
 */
