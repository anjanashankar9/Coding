package graphs;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class NearestClone {

    // Complete the findShortest function below.

    /*
     * For the unweighted graph, <name>:
     *
     * 1. The number of nodes is <name>Nodes.
     * 2. The number of edges is <name>Edges.
     * 3. An edge exists between <name>From[i] to <name>To[i].
     *
     */
    static int findShortest(int graphNodes, int[] graphFrom, int[] graphTo, long[] ids, int val) {
        // solve here

        LinkedList<Integer> graph[] = new LinkedList[graphNodes];

        for (int i=0;i<graphNodes;i++) {
            graph[i] = new LinkedList<>();
        }

        for (int i=0; i< graphFrom.length; i++) {
            int u = graphFrom[i];
            int v = graphTo[i];

            graph[u-1].add(v-1);
            graph[v-1].add(u-1);
        }

        //Since the weights of the edges is same, a BFS will
        //give us the shortest path.
        return BFS(graph, ids, val);

    }

    static int BFS(LinkedList<Integer> graph[], long[] ids, int val) {
        int distance = 0;

        boolean[] visited = new boolean[graph.length];
        Queue<Integer> q = new LinkedList<>();
        int startNode = -1;

        for (int i=0; i<graph.length; i++) {
            if (ids[i] == val) {
                q.add(i);
                visited[i] = true;
                startNode = i;
                break;
            }
        }
        q.add(-1);

        while (!q.isEmpty()) {
            int current = q.remove();
            if (current == -1) {
                distance++;
                continue;
            }
            for (int i=0; i< graph[current].size(); i++) {
                if (graph[current].get(i) != startNode && ids[graph[current].get(i)] == val) {
                    return ++distance;
                }
                if (!visited[graph[current].get(i)]) {
                    q.add(graph[current].get(i));
                    visited[graph[current].get(i)] = true;
                }
            }
            q.add(-1);
        }

        return -1;
    }



    private static final Scanner scanner = new Scanner(System.in);

    public static void nearestClone(String[] args) {

        String[] graphNodesEdges = scanner.nextLine().split(" ");
        int graphNodes = Integer.parseInt(graphNodesEdges[0].trim());
        int graphEdges = Integer.parseInt(graphNodesEdges[1].trim());

        int[] graphFrom = new int[graphEdges];
        int[] graphTo = new int[graphEdges];

        for (int i = 0; i < graphEdges; i++) {
            String[] graphFromTo = scanner.nextLine().split(" ");
            graphFrom[i] = Integer.parseInt(graphFromTo[0].trim());
            graphTo[i] = Integer.parseInt(graphFromTo[1].trim());
        }

        long[] ids = new long[graphNodes];

        String[] idsItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < graphNodes; i++) {
            long idsItem = Long.parseLong(idsItems[i]);
            ids[i] = idsItem;
        }

        int val = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int ans = findShortest(graphNodes, graphFrom, graphTo, ids, val);

        System.out.println(ans);

        scanner.close();
    }
}


/*
In this challenge, there is a connected undirected graph where each of the nodes is a color. Given a color, find the shortest path connecting any two nodes of that color. Each edge has a weight of . If there is not a pair or if the color is not found, print .

For example, given , and  edges  and  and colors for each node are  we can draw the following graph:

image

Each of the nodes is labeled [node]/[color] and is colored appropriately. If we want the shortest path between color , blue, we see there is a direct path between nodes  and . For green, color , we see the path length  from . There is no pair for node  having color , red.

Function Description

Complete the findShortest function in the editor below. It should return an integer representing the length of the shortest path between two nodes of the same color, or  if it is not possible.

findShortest has the following parameter(s):

g_nodes: an integer, the number of nodes
g_from: an array of integers, the start nodes for each edge
g_to: an array of integers, the end nodes for each edge
ids: an array of integers, the color id per node
val: an integer, the id of the color to match
Input Format

The first line contains two space-separated integers  and , the number of nodes and edges in the graph.
Each of the next  lines contains two space-separated integers  and , the nodes connected by an edge.
The next line contains  space-seperated integers, , representing the color id of each node from  to .
The last line contains the id of the color to analyze.

Note: The nodes are indexed from  to .

Constraints




Output Format

Print the single integer representing the smallest path length or .

Sample Input 0

4 3
1 2
1 3
4 2
1 2 1 1
1
Sample Output 0

1
Explanation 0

image

In the above image the distance between the closest nodes having color label  is .

Sample Input 1

4 3
1 2
1 3
4 2
1 2 3 4
2
Sample Output 1

-1
Explanation 1

image

Sample Input 2

5 4
1 2
1 3
2 4
3 5
1 2 3 3 2
2
Sample Output 2

3
Explanation 2

image
 */

//https://www.hackerrank.com/challenges/find-the-nearest-clone/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=graphs