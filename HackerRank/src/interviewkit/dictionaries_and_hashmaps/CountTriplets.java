package interviewkit.dictionaries_and_hashmaps;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CountTriplets {

    // Complete the countTriplets function below.
    // O(n*n*n) solution
    static long countTriplets1(List<Long> arr, long r) {
        long found = 0;

        for(int i=0; i<arr.size(); i++) {
            for(int j=i+1; j<arr.size();j++){
                if (arr.get(j) == arr.get(i)*r) {
                    for (int k=j+1; k<arr.size(); k++) {
                        if (arr.get(k) == arr.get(i)*r*r) {
                            found++;
                        }
                    }
                }
            }
        }

        return found;

    }

    // O(n) solution
    static long countTriplets(List<Long> arr, long r) {
        long found = 0;
        Map<Long, Long> leftCount = new HashMap<>();
        Map<Long, Long> rightCount = new HashMap<>();

        for (int i=0; i< arr.size(); i++) {
            leftCount.put(arr.get(i), 0L);
            if (rightCount.containsKey(arr.get(i))) {
                rightCount.put(arr.get(i), rightCount.get(arr.get(i))+1);
            }
            else {
                rightCount.put(arr.get(i), 1L);
            }
        }

        for (int i=0; i<arr.size(); i++) {
            Long left = arr.get(i) / r;
            Long quotient = arr.get(i) % r;
            Long right = arr.get(i) * r;

            rightCount.put(arr.get(i), rightCount.get(arr.get(i)) - 1);
            if (leftCount.containsKey(left) && rightCount.containsKey(right) && quotient == 0) {
                found += (leftCount.get(left) * (rightCount.get(right)));
            }
            leftCount.put(arr.get(i), leftCount.get(arr.get(i)) + 1);
        }

        return found;

    }

    public static void countTriplets(String[] args) {
        
        int n = 4;
        System.out.print(n);

        long r = 1;

        List<Long> arr = new ArrayList<>();
        arr.add(Long.parseLong("1"));
        arr.add(Long.parseLong("1"));
        arr.add(Long.parseLong("1"));
        arr.add(Long.parseLong("1"));

        long ans = countTriplets(arr, r);

        System.out.println(ans);
    }
}


/*
You are given an array and you need to find number of tripets of indices  such that the elements at those indices are in geometric progression for a given common ratio  and .

For example, . If , we have  and  at indices  and .

Function Description

Complete the countTriplets function in the editor below. It should return the number of triplets forming a geometric progression for a given  as an integer.

countTriplets has the following parameter(s):

arr: an array of integers
r: an integer, the common ratio
Input Format

The first line contains two space-separated integers  and , the size of  and the common ratio.
The next line contains  space-seperated integers .

Constraints

Output Format

Return the count of triplets that form a geometric progression.

Sample Input 0

4 2
1 2 2 4
Sample Output 0

2
Explanation 0

There are  triplets in satisfying our criteria, whose indices are  and

Sample Input 1

6 3
1 3 9 9 27 81
Sample Output 1

6
Explanation 1

The triplets satisfying are index , , , ,  and .

Sample Input 2

5 5
1 5 5 25 125
Sample Output 2

4
Explanation 2

The triplets satisfying are index , , , .
 */

//https://www.hackerrank.com/challenges/count-triplets-1/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps
