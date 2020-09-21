package trees;

import java.util.Scanner;

public class BalancedForest {

    // Complete the balancedForest function below.
    static int balancedForest(int[] c, int[][] edges) {

        return 0;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void balancedForest(String[] args) {
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] c = new int[n];

            String[] cItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int cItem = Integer.parseInt(cItems[i]);
                c[i] = cItem;
            }

            int[][] edges = new int[n - 1][2];

            for (int i = 0; i < n - 1; i++) {
                String[] edgesRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < 2; j++) {
                    int edgesItem = Integer.parseInt(edgesRowItems[j]);
                    edges[i][j] = edgesItem;
                }
            }

            int result = balancedForest(c, edges);

            System.out.println(result);
        }

        scanner.close();
    }
}


/*
Greg has a tree of nodes containing integer data. He wants to insert a node with some non-zero integer value somewhere into the tree. His goal is to be able to cut two edges and have the values of each of the three new trees sum to the same amount. This is called a balanced forest. Being frugal, the data value he inserts should be minimal. Determine the minimal amount that a new node can have to allow creation of a balanced forest. If it's not possible to create a balanced forest, return -1.
For example, you are given node values  and . It is the following tree:
image
The blue node is root, the first number in a node is node number and the second is its value. Cuts can be made between nodes  and  and nodes  and  to have three trees with sums ,  and . Adding a new node  of  to the third tree completes the solution.
Function Description
Complete the balancedForest function in the editor below. It must return an integer representing the minimum value of that can be added to allow creation of a balanced forest, or  if it is not possible.
balancedForest has the following parameter(s):
c: an array of integers, the data values for each node
edges: an array of 2 element arrays, the node pairs per edge
Input Format
The first line contains a single integer, , the number of queries.
Each of the following  sets of lines is as follows:
The first line contains an integer, , the number of nodes in the tree.
The second line contains  space-separated integers describing the respective values of , where each denotes the value at node .
Each of the following  lines contains two space-separated integers,  and , describing edge  connecting nodes  and .
Constraints



Each query forms a valid undirected tree.
Subtasks
For  of the maximum score:


For  of the maximum score:


Output Format
For each query, return the minimum value of the integer . If no such value exists, return  instead.
Sample Input
2
5
1 2 2 1 1
1 2
1 3
3 5
1 4
3
1 3 5
1 3
1 2
Sample Output
2
-1
Explanation
We perform the following two queries:
The tree initially looks like this:
image
Greg can add a new node  with  and create a new edge connecting nodes  and . Then he cuts the edge connecting nodes  and  and the edge connecting nodes  and . We now have a three-tree balanced forest where each tree has a sum of .
image
In the second query, it's impossible to add a node in such a way that we can split the tree into a three-tree balanced forest so we return .
 */

//https://www.hackerrank.com/challenges/balanced-forest/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=trees