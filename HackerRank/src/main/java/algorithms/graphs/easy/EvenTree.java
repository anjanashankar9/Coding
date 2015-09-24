package algorithms.graphs.easy;

import java.util.Scanner;

/**
 * Created by ashankar1 on 7/6/15.
 */
public class EvenTree {
    static int edgeRemove = 0;

    public static void EvenTree(String args[]){
        Scanner in = new Scanner(System.in);
        int V = in.nextInt();
        int E = in.nextInt();
        int Graph[][] = new int[V][V];
        for(int i=0;i<E;i++){
            int u = in.nextInt();
            int v = in.nextInt();
            Graph[u-1][v-1] = Graph[v-1][u-1] = 1;
        }
        System.out.println();
        int[] visited = new int[Graph.length];
        dfs(0,Graph,visited);
        System.out.println(edgeRemove);

    }
    private static int dfs(int vertex,int [][] graph,int[] visited){
        visited[vertex] = 1;
        int numVertex = 0;
        for(int i=0;i<graph.length;i++){
            if(graph[vertex][i]!=0 && visited[i] == 0){
                int subtree_nodes = dfs(i,graph,visited);
                if(subtree_nodes%2 == 0)
                    edgeRemove++;
                else
                    numVertex+= subtree_nodes;
            }
        }
        return numVertex+1;
    }
}

/*

You are given a tree (a simple connected graph with no cycles). You have to remove as many edges from the tree as possible to obtain a forest with the condition that : Each connected component of the forest should contain an even number of vertices.

To accomplish this, you will remove some edges from the tree. Find out the number of removed edges.

Input Format
The first line of input contains two integers N and M. N is the number of vertices and M is the number of edges.
The next M lines contain two integers ui and vi which specifies an edge of the tree. (1-based index)

Output Format
Print the answer, a single integer.

Constraints
2 <= N <= 100.

Note: The tree in the input will be such that it can always be decomposed into components containing even number of nodes.

Sample Input

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
Sample Output

2
Explanation
On removing edges (1, 3) and (1, 6), we can get the desired result.

 */

//https://www.hackerrank.com/challenges/even-tree
