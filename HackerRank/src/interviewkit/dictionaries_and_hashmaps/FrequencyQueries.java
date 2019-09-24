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

public class FrequencyQueries {

    //Complete the freqQuery function below.
    // O(n) solution
    static List<Integer> freqQuery(List<int[]> queries) {
        List<Integer> ans = new ArrayList<>();
        HashMap<Integer, Integer> frequencies = new HashMap<>();
        HashMap<Integer, Integer> count = new HashMap<>();

        for (int[] q: queries) {
            Integer element = q[1];
            switch(q[0]) {
                case 1:
                    //Insert
                    int existingCount = frequencies.containsKey(element) ? frequencies.get(element) : 0;
                    int newCount = existingCount + 1;
                    frequencies.put(element, newCount);

                    int currentCount = count.containsKey(existingCount) ? count.get(existingCount) : 1;
                    if (existingCount > 0) {
                        count.put(existingCount, currentCount - 1);
                    }

                    int addCount = count.containsKey(newCount) ? count.get(newCount) : 0;
                    count.put(newCount , addCount + 1);
                    break;
                case 2: //Remove
                    existingCount = frequencies.containsKey(element) ? frequencies.get(element) : 1;
                    newCount = existingCount - 1;

                    if (frequencies.containsKey(element)) {
                        if (frequencies.get(element) == 1) {
                            frequencies.remove(element);
                        } else {
                            frequencies.put(element, newCount);
                        }
                        currentCount = count.containsKey(existingCount) ? count.get(existingCount) : 1;
                        count.put(existingCount , currentCount - 1);

                        addCount = count.containsKey(newCount) ? count.get(newCount) : 0;
                        count.put(newCount , addCount + 1);
                    }
                    break;
                case 3:
                    //Get Elements with Frequency, and add to ans
                    if (count.containsKey(element) && count.get(element) > 0)
                        ans.add(1);
                    else
                        ans.add(0);

            }
        }
        return ans;

    }

    public static void frequencyQueries(String[] args) {

        int q = 8;

        /*
        3 5
3 3
1 10000004
1 10000016
1 10000011
3 10
         */
        List<int[]> queries = new ArrayList<>();
        int[] i = new int[2];
        i[0] = 3;
        i[1] = 5;
        queries.add(i);

        i = new int[2];
        i[0] = 3;
        i[1] = 3;
        queries.add(i);

        i = new int[2];
        i[0] = 1;
        i[1] = 10000004;
        queries.add(i);

        i = new int[2];
        i[0] = 1;
        i[1] = 10000016;
        queries.add(i);

        i = new int[2];
        i[0] = 1;
        i[1] = 10000011;
        queries.add(i);

        i = new int[2];
        i[0] = 3;
        i[1] = 10;
        queries.add(i);

        i = new int[2];
        i[0] = 1;
        i[1] = 10000006;
        queries.add(i);

        i = new int[2];
        i[0] = 3;
        i[1] = 5;
        queries.add(i);


        List<Integer> ans = freqQuery(queries);

        for (Integer j: ans) {
            System.out.println(j);
        }

    }
}


/*
You are given  queries. Each query is of the form two integers described below:
-  : Insert x in your data structure.
-  : Delete one occurence of y from your data structure, if present.
-  : Check if any integer is present whose frequency is exactly . If yes, print 1 else 0.

The queries are given in the form of a 2-D array  of size  where  contains the operation, and  contains the data element. For example, you are given array . The results of each operation are:

Operation   Array   Output
(1,1)       [1]
(2,2)       [1]
(3,2)                   0
(1,1)       [1,1]
(1,1)       [1,1,1]
(2,1)       [1,1]
(3,2)                   1
Return an array with the output: .

Function Description

Complete the freqQuery function in the editor below. It must return an array of integers where each element is a  if there is at least one element value with the queried number of occurrences in the current array, or 0 if there is not.

freqQuery has the following parameter(s):

queries: a 2-d array of integers
Input Format

The first line contains of an integer , the number of queries.
Each of the next  lines contains two integers denoting the 2-d array .

Constraints

All
Output Format

Return an integer array consisting of all the outputs of queries of type .

Sample Input 0

8
1 5
1 6
3 2
1 10
1 10
1 6
2 5
3 2
Sample Output 0

0
1
Explanation 0

For the first query of type , there is no integer whose frequency is  (). So answer is .
For the second query of type , there are two integers in  whose frequency is  (integers =  and ). So, the answer is .

Sample Input 1

4
3 4
2 1003
1 16
3 1
Sample Output 1

0
1
Explanation 1

For the first query of type , there is no integer of frequency . The answer is .
For the second query of type , there is one integer,  of frequency  so the answer is .

Sample Input 2

10
1 3
2 3
3 2
1 4
1 5
1 5
1 4
3 2
2 4
3 2
Sample Output 2

0
1
1
Explanation 2

When the first output query is run, the array is empty. We insert two 's and two 's before the second output query,  so there are two instances of elements occurring twice. We delete a  and run the same query. Now only the instances of  satisfy the query.
 */
