package easy;

public class CountOdds {
//    7-3 = 4/2 = 2 + 1
//    7-4 = 3/2 = 2 + 1  5, 7
//    8-4 = 4/2 = 2        5,7
    //8-3 = 5/2 = 3 [3,5,7]
//    10-8 = 2/2 = 1 + 0

    public int countOdds(int low, int high) {
        int oddCount = 0;
        oddCount +=  Math.ceil((high-low)/2.0);
        if (high%2 == 1 && low%2 == 1)
            oddCount++;
        return oddCount;
    }
}

/*
Given two non-negative integers low and high. Return the count of odd numbers between low and high (inclusive).



Example 1:

Input: low = 3, high = 7
Output: 3
Explanation: The odd numbers between 3 and 7 are [3,5,7].
Example 2:

Input: low = 8, high = 10
Output: 1
Explanation: The odd numbers between 8 and 10 are [9].


Constraints:

0 <= low <= high <= 10^9
 */
