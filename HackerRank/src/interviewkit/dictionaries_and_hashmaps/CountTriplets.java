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
        HashMap<String, Long> threetripletCount= new HashMap<>();
        HashMap<String, Long> twoTripletCount= new HashMap<>();
        HashMap<Long, Long> oneTripletCount = new HashMap<>();


        for(int i=0; i<arr.size(); i++) {
            if (oneTripletCount.containsKey(arr.get(i))) {
                oneTripletCount.put(arr.get(i), oneTripletCount.get(arr.get(i))+1);
            }
            else {
                oneTripletCount.put(arr.get(i), 1L);
            }

            Long gp1 = arr.get(i)/(r*r);
            Long gp2 = arr.get(i)/r;


            if (gp2 > 0) {
                if (twoTripletCount.containsKey(gp2 + "_" + arr.get(i))) {
                    twoTripletCount.put(gp2 + "_" + arr.get(i),
                            twoTripletCount.get(gp2 + "_" + arr.get(i)) + 1);
                } else {
                    twoTripletCount.put(gp2 + "_" + arr.get(i),
                            1L);
                }

                if (gp1 > 0) {
                    if (threetripletCount.containsKey(gp1 + "_" + gp2 + "_" + arr.get(i))) {
                        threetripletCount.put(gp1 + "_" + gp2 + "_" + arr.get(i),
                                threetripletCount.get(gp1 + "_" + gp2 + "_" + arr.get(i)) + 1);
                    } else {
                        threetripletCount.put(gp1 + "_" + gp2 + "_" + arr.get(i), 1L);
                    }
                }
            }

        }

        for (String s:threetripletCount.keySet()) {
            found+= threetripletCount.get(s);
        }




        return found;

    }

    public static void countTriplets(String[] args) {

//        int n = 6;
//
//        long r = 3;
//
//        List<Long> arr = new ArrayList<>();
//        arr.add(Long.parseLong("1"));
//        arr.add(Long.parseLong("3"));
//        arr.add(Long.parseLong("9"));
//        arr.add(Long.parseLong("9"));
//        arr.add(Long.parseLong("27"));
//        arr.add(Long.parseLong("81"));
        int n = 4;

        long r = 2;

        List<Long> arr = new ArrayList<>();
        arr.add(Long.parseLong("1"));
        arr.add(Long.parseLong("2"));
        arr.add(Long.parseLong("2"));
        arr.add(Long.parseLong("4"));

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
