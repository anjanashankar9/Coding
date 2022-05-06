package easy;

// TODO : This doesnt work
public class AddBinary {
    public String addBinary(String a, String b) {
        StringBuffer result = new StringBuffer();
        int i = a.length() - 1;
        int j = b.length() - 1;

        int c = 0;
        char s1 = '0';
        int c1 = 0;
        while (i>=0 && j>= 0) {
            if ((a.charAt(i) == '1' && b.charAt(j) == '1') || (a.charAt(i) == '0' && b.charAt(j) == '0')) {
                s1 = '0';
                c1 = '1';
            }
            else {
                s1 = '1';
                c1 = 0;
            }


            result.append(s1);
        }

        return result.reverse().toString();
    }
}

/*
Given two binary strings a and b, return their sum as a binary string.



Example 1:

Input: a = "11", b = "1"
Output: "100"
Example 2:

Input: a = "1010", b = "1011"
Output: "10101"

 */
