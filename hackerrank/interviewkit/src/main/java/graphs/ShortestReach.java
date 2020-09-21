package graphs;



import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ShortestReach {
    public static class QueueNode {
        Integer node;
        Integer level;

        QueueNode(int node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    public static class Graph {
        int [][] adj;
        int size;

        public Graph(int size) {
            this.size = size;
            adj = new int[size][size];

        }

        public void addEdge(int first, int second) {
            adj[first][second] = 6;
            adj[second][first] = 6;
        }



        public int[] shortestReach(int startId) { // 0 indexed
            int[] dist = new int[size];
            boolean[] visited = new boolean[size];

            Queue<QueueNode> queue = new LinkedList<QueueNode>();

            queue.add(new QueueNode(startId, 0));
            queue.add(new QueueNode(-1, 0));
            visited[startId] = true;

            int distance = 0;
            while(!queue.isEmpty()) {
                QueueNode current = queue.remove();
                int node = current.node;
                int level = current.level;
                if (node == -1) {
                    continue;
                }
                dist[node] = (level)*6;
                for (int i=0; i< this.size; i++) {
                    if(adj[node][i] != 0 && !visited[i]) {
                        queue.add(new QueueNode(i, level+1));
                        visited[i] = true;
                    }
                }
                queue.add(new QueueNode(-1, level+1));
            }
            return dist;
        }
    }

    public static void shortestReach(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int queries = scanner.nextInt();

        for (int t = 0; t < queries; t++) {

            // Create a graph of size n where each edge weight is 6:
            Graph graph = new Graph(scanner.nextInt());
            int m = scanner.nextInt();

            // read and set edges
            for (int i = 0; i < m; i++) {
                int u = scanner.nextInt() - 1;
                int v = scanner.nextInt() - 1;

                // add each edge to the graph
                graph.addEdge(u, v);
            }

            // Find shortest reach from node s
            int startId = scanner.nextInt() - 1;
            int[] distances = graph.shortestReach(startId);

            for (int i = 0; i < distances.length; i++) {
                if (i != startId) {
                    if (distances[i] == 0) {
                        System.out.print("-1");
                    }
                    else
                        System.out.print(distances[i]);
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        scanner.close();
    }
}



/*
Consider an undirected graph consisting of  nodes where each node is labeled from  to  and the edge between any two nodes is always of length . We define node  to be the starting position for a BFS. Given a graph, determine the distances from the start node to each of its descendants and return the list in node number order, ascending. If a node is disconnected, it's distance should be .

For example, there are  nodes in the graph with a starting node . The list of , and each has a weight of .

image

Starting from node  and creating a list of distances, for nodes  through  we have .

Function Description

Define a Graph class with the required methods to return a list of distances.

Input Format

The first line contains an integer, , the number of queries.

Each of the following  sets of lines is as follows:

The first line contains two space-separated integers,  and , the number of nodes and the number of edges.
Each of the next  lines contains two space-separated integers,  and , describing an edge connecting node  to node .
The last line contains a single integer, , the index of the starting node.
Constraints

Output Format

For each of the  queries, print a single line of  space-separated integers denoting the shortest distances to each of the  other nodes from starting position . These distances should be listed sequentially by node number (i.e., ), but should not include node . If some node is unreachable from , print  as the distance to that node.

Sample Input

2
4 2
1 2
1 3
1
3 1
2 3
2
Sample Output

6 6 -1
-1 6
Explanation

We perform the following two queries:

The given graph can be represented as:
image
where our start node, , is node . The shortest distances from  to the other nodes are one edge to node , one edge to node , and there is no connection to node .
The given graph can be represented as:
image
where our start node, , is node . There is only one edge here, so node  is unreachable from node  and node  has one edge connecting it to node . We then print node 's distance to nodes  and  (respectively) as a single line of space-separated integers: -1 6.

Note: Recall that the actual length of each edge is , and we print  as the distance to any node that's unreachable from .
 */

//https://www.hackerrank.com/challenges/ctci-bfs-shortest-reach/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=graphs