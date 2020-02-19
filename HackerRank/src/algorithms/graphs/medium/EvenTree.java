package algorithms.graphs.medium;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class EvenTree {

    // Complete the evenForest function below.
    static int evenForest(int t_nodes, int t_edges, List<Integer> t_from, List<Integer> t_to) {
        int edges=0;
        return edges;
    }

    public static void evenTree(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] tNodesEdges = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int tNodes = Integer.parseInt(tNodesEdges[0]);
        int tEdges = Integer.parseInt(tNodesEdges[1]);

        List<Integer> tFrom = new ArrayList<>();
        List<Integer> tTo = new ArrayList<>();

        IntStream.range(0, tEdges).forEach(i -> {
            try {
                String[] tFromTo = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                tFrom.add(Integer.parseInt(tFromTo[0]));
                tTo.add(Integer.parseInt(tFromTo[1]));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int res = evenForest(tNodes, tEdges, tFrom, tTo);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

/*
You are given a tree (a simple connected graph with no cycles).

Find the maximum number of edges you can remove from the tree to get a forest such that each connected component of the forest contains an even number of nodes.

As an example, the following tree with  nodes can be cut at most  time to create an even forest.

image

Function Description

Complete the evenForest function in the editor below. It should return an integer as described.

evenForest has the following parameter(s):

t_nodes: the number of nodes in the tree
t_edges: the number of undirected edges in the tree
t_from: start nodes for each edge
t_to: end nodes for each edge, (Match by index to t_from.)
Input Format

The first line of input contains two integers  and , the number of nodes and edges.
The next  lines contain two integers  and  which specify nodes connected by an edge of the tree. The root of the tree is node .

Constraints

Note: The tree in the input will be such that it can always be decomposed into components containing an even number of nodes.  is the set of positive even integers.

Output Format

Print the number of removed edges.

Sample Input 1

CopyDownload
Undirected Graph: t
2
1
3
4
5
6
7
8
9
10


10 9
2 1
3 1
4 3
5 2
6 1
7 2
8 6
9 8
10 8
Sample Output 1

2
Explanation 1

Remove edges  and  to get the desired result.


image image

No more edges can be removed.
 */

//https://www.hackerrank.com/challenges/even-tree/problem
