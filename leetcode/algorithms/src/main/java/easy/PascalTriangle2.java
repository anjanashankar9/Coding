package easy;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle2 {
    public List<Integer> getRow(int rowIndex) {
        ArrayList<Integer> prevRow = new ArrayList<>();
        ArrayList<Integer> currRow = new ArrayList<>();

        prevRow.add(1);

        for(int i =1; i<=rowIndex; i++) {
            currRow = new ArrayList<>();
            for(int j=0; j<i; j++) {
                currRow.add((j>0 ? prevRow.get(j-1) : 0 ) + prevRow.get(j));
            }
            currRow.add(prevRow.get(i-1));
            prevRow = currRow;
        }

        return prevRow;
    }

    public static void main(String[] args) {
        System.out.println(new PascalTriangle2().getRow(33));
    }
}

/*
Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:




Example 1:

Input: rowIndex = 3
Output: [1,3,3,1]
Example 2:

Input: rowIndex = 0
Output: [1]
Example 3:

Input: rowIndex = 1
Output: [1,1]


Constraints:

0 <= rowIndex <= 33
 */