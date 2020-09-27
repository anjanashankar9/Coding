package arraysandstrings;

/**
 * @Author Anjana Shankar
 * @Created 2020-09-27
 */
public class URLify {
    /*
    Solution:
    Pass1 : Count the spaces in the string.
    The total number of characters in the string will increase with 2x chars
    where x is the number of spaces.
    Pass2: Take an appropriate sized array.
    Move from the back of the given array, and copy chars appropriately.
     */
    private String urlIfy(String s, int n) {
        int count = 0;
        for(int i=0; i<n; i++) {
            if (s.charAt(i) != ' '){
                count++;
            }
            else {
                count += 3;
            }
        }

        char[] result = new char[count];

        for(int i=n-1, j=count-1; i>=0; i--) {
            if(s.charAt(i) != ' ') {
                result[j--] = s.charAt(i);
            }
            else {
                result[j--] = '0';
                result[j--] = '2';
                result[j--] = '%';
            }
        }

        return new String(result);
    }

    private String urlifyString(String s,int n) {
        return s.substring(0,n).replaceAll(" ", "%20");
    }
    public static void main(String[] args) {
        String s = "Mr John Smith     ";
        int n = 15;

        System.out.println(new URLify().urlifyString(s, n));
    }
}

/*
Write a method to replace all spaces in a string with '%20'. You may assume that the string has sufficient space at the end to hold the additional characters, and that you are given the "true" length of the string. (Note: if implementing in Java, please use a character array so that you can perform this operation in place.)
 */
