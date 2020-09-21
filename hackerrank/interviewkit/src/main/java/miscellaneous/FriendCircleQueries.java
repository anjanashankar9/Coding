package miscellaneous;

/**
 * @Author Anjana Shankar
 * @Created 2020-08-19
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FriendCircleQueries {


    // Complete the maxCircle function below.
    static int[] maxCircle(int[][] queries) {
        /*
        The premise for the solution is the union-find algorithm
        or the disjoint-set algorithm.
         */
        int[] max = new int[queries.length];
        Map<Integer, Integer> parent = new HashMap<>();
        Map<Integer, Integer> size = new HashMap<>();
        int maxTillNow = -1;

        for (int i=0; i<queries.length; i++) {
            int v1 = queries[i][0];
            int v2 = queries[i][1];

            if (!parent.containsKey(v1)) {
                parent.put(v1, v1);
                size.put(v1, 1);
            }
            if(!parent.containsKey(v2)) {
                parent.put(v2, v2);
                size.put(v2, 1);
            }

            int p1 = findParent(v1, parent);
            int p2 = findParent(v2, parent);

            int s1 = size.get(p1);
            int s2 = size.get(p2);
            if (p1 != p2) {
                if (s1 > s2) {
                    // Replace the parent of all nodes in path v2 as v1
                    // increase size of v1 with that of v2
                    replaceParent(p2, p1, parent);
                    parent.put(p2, p1);
                    size.put(p1, s1+s2);
                }
                else {
                    // Replace all the nodes with parent v2 as v1
                    // increase size of v1 with that of v2
                    replaceParent(p1, p2, parent);
                    parent.put(p1, p2);
                    size.put(p2, s1+s2);
                }
                if(s1+s2 > maxTillNow) {
                    maxTillNow = s1+s2;
                }
            }

            max[i] = maxTillNow;
        }
        return max;
    }

    private static int findParent(int v, Map<Integer, Integer> parent) {
        while (v != parent.get(v)) {
            v = parent.get(v);
        }
        return v;
    }

    private static void replaceParent(int v, int p, Map<Integer, Integer> parent) {
        while (v != parent.get(v)) {
            v = parent.get(v);
            parent.put(v, p);
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void friendCircleQueries(String[] args) {

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[][] queries = new int[q][2];

        for (int i = 0; i < q; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        int[] ans = maxCircle(queries);

        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }

        scanner.close();
    }
}


/*
The population of HackerWorld is . Initially, none of the people are friends with each other. In order to start a friendship, two persons  and  have to shake hands, where . The friendship relation is transitive, that is if  and  shake hands with each other,  and friends of  become friends with  and friends of .

You will be given  queries. After each query, you need to report the size of the largest friend circle (the largest group of friends) formed after considering that query.

For example, your list of queries is:

1 2
3 4
2 3
First,  and  shake hands, forming a circle of . Next,  and  do the same. Now there are two groups of  friends. When  and  become friends in the next query, both groups of friends are added together to make a circle of  friends. We would print

2
2
4
Function Description

Complete the function maxCircle in the editor below. It must return an array of integers representing the size of the maximum circle of friends after each query.

maxCircle has the following parameter(s):

queries: an array of integer arrays, each with two elements indicating a new friendship
Input Format

The first line contains an integer, , the number of queries to process.
Each of the next  lines consists of two space-separated integers denoting the 2-D array .

Constraints

 for
Output Format

Return an integer array of size , whose value at index  is the size of largest group present after processing the  query.

Sample Input 0

2
1 2
1 3
Sample Output 0

2
3
Explanation 0

In the first query,  and  shake hands. So, the size of largest group of friends is  (as no other friendships exist).
After the second query, ,  and  all become friends, as  shakes hand with ,  also become friends with  as he was already a friend of .

Sample Input 1

4
1000000000 23
11 3778
7 47
11 1000000000
Sample Output 1

2
2
2
4
Explanation 1

After first query, person  and person  become friends. So, the largest group size is .
After the second query, person  and person  become friends. So, the largest group size is still .
After the third query, person  and person  become friends. Answer is still .
After the last query, person  and person  become friends, which means , ,  and  all become friends. Hence, the answer now increased to .

Sample Input 2

6
1 2
3 4
1 3
5 7
5 6
7 4
Sample Output 2

2
2
4
4
4
7
Explanation 2

Friend circles after each iteration:

1   [1,2]
2   [1,2],[3,4]
3   [1,2,3,4]
4   [1,2,3,4],[5,7]
5   [1,2,3,4],[5,7,6]
6   [1,2,3,4,5,6,7]
 */

//https://www.hackerrank.com/challenges/friend-circle-queries/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=miscellaneous