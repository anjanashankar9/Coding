package bitmanipulation;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Anjana Shankar
 * @Created 2020-09-29
 */
public class FlipBitToWin {
    /**
     * Time Complexity : O(b)
     * Space Complexity : O(1)
     *
     * Walk through the integer, tracking the current 1s sequence length and the
     * previous 1s sequence length. When we hit a 0, we update previousLength:
     *
     * If the next bit is a 1, previousLength should be set to currentlength;
     * If the next bit is a 0, we cannot merge these sequences together. So,
     * set previousLength to 0;
     *
     * @param n
     * @return
     */
    private int findLongestSequence(int n) {
        if(n == ~0) {
            // n contains all 1s
            return Integer.BYTES;
        }

        int curLength = 0;
        int prevLength = 0;
        int max = 1;
        while(n != 0) {
            if((n & 1) == 1) { // current bit is 1;
                curLength++;
            }
            else if((n & 1) == 0){ // current bit is 0
                prevLength = (n & 2) == 0 ? 0 : curLength;
                curLength = 0;
            }
            max = Math.max(max, prevLength+1+curLength);
            n >>>=1;
        }
        return max;
    }

    public static void main(String[] args) {
        FlipBitToWin f = new FlipBitToWin();
        System.out.println(f.findLongestSequence(1775));

    }
}

/*
You have an integer and you can flip exactly one bit from a 0 to a 1.
Write code to find the length of the longest sequence of ls you could create.
EXAMPLE
Input: 1775 (or: 11011101111) Output: 8
 */
