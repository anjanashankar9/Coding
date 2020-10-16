package medium;

import java.util.ArrayList;

/**
 * @Author Anjana Shankar
 * @Created 2020-10-16
 */
public class ZigzagConversion {

    // O(n) and space O(n)
    public String convert(String s, int numRows) {
        int len = s.length();

        ArrayList<Character>[] zigzag = new ArrayList[numRows];

        for(int i=0; i<numRows; i++) {
            zigzag[i] = new ArrayList<>();
        }
        int row = 0;

        boolean moveDown = true;

        for(int i = 0; i< len; i++) {
            zigzag[row].add(s.charAt(i));
            if (moveDown) {
                row += 1;
            }
            else {
                row -=1;
            }

            if(row <= -1) {
                moveDown = true;
                row +=2;
                row = row <numRows ? row: numRows;
            }
            if(row >= numRows) {
                moveDown = false;
                row-=2;
                row = row > 0 ? row: 0;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<numRows; i++) {
            for(Character c : zigzag[i]) {
                sb.append(c);
            }
        }
        return sb.toString();

    }

    public static void main(String[] args) {
        String s = "AB";
        System.out.println(new ZigzagConversion().convert(s,1));
    }
}

/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);


Example 1:

Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"
Example 2:

Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:
P     I    N
A   L S  I G
Y A   H R
P     I
Example 3:

Input: s = "A", numRows = 1
Output: "A"


Constraints:

1 <= s.length <= 1000
s consists of English letters (lower-case and upper-case), ',' and '.'.
1 <= numRows <= 1000
 */

//https://leetcode.com/problems/zigzag-conversion/