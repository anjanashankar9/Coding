package easy;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if(numRows == 0)
            return result;

        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        result.add(firstRow);

        for(int i =1; i<numRows; i++) {
            ArrayList<Integer> prevRow = (ArrayList<Integer>) result.get(i-1);
            ArrayList<Integer> currRow = new ArrayList<>();
            for(int j=0; j<i; j++) {
                currRow.add((j>0 ? prevRow.get(j-1) : 0 ) + prevRow.get(j));
            }
            currRow.add(prevRow.get(i-1));
            result.add(currRow);
        }

        return result;
    }

    public static void main(String[] args) {
        new PascalTriangle().generate(1);
    }
}

/*
Given an integer numRows, return the first numRows of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:




Example 1:

Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
Example 2:

Input: numRows = 1
Output: [[1]]
 */