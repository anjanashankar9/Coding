package algorithms.graphs.medium;


import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class EvenTree {

    // Complete the evenForest function below.
    static int evenForest(int t_nodes, int t_edges, List<Integer> t_from, List<Integer> t_to) {
        int edges=0;
        //create a graph from inputs
        Tree tree = new Tree(t_nodes, t_edges);
        for(int i=0; i<t_edges; i++) {
            tree.addEdge(t_from.get(i), t_to.get(i));
        }
        tree.countNodesSubtree();
        edges = tree.findEvenSubtreeEdges();
        return edges;
    }


    public static void evenTree(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

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

class TreeNode {
    private int data;
    private int nodesInSubtree;
    private List<TreeNode> children;

    TreeNode(int data) {
        this.data = data;
        this.nodesInSubtree = 0;
        this.children = new ArrayList<>();
    }

    public int getData() {
        return data;
    }

    public void addChildren(TreeNode t) {
        children.add(t);
    }

    public List<TreeNode> getChildren() {
        return this.children;
    }

    public int getNodesInSubtree() {
        return nodesInSubtree;
    }

    public void setNodesInSubtree(int nodesInSubtree) {
        this.nodesInSubtree = nodesInSubtree;
    }
}

class Tree {
    private final int n;
    private int e;
    private List<TreeNode> treeNodes;

    /**
     * Create a Tree with N nodes and E edges
     * @param N number of nodes in tree
     * @param E number of edges in tree
     */
    public Tree(int N, int E) {
        if(N<0)
            throw new IllegalArgumentException("Number of vertices must be non negative");
        this.n = N;
        this.e = E;
        treeNodes = new ArrayList<>();
        for(int i=1; i<=N; i++) {
            treeNodes.add(i-1, new TreeNode(i));
        }
    }

     TreeNode getRoot() {
        if (this.n > 0)
            return treeNodes.get(0);
        else
            System.out.println("No data in Tree");
        return null;
    }

    /**
     * Add edge for tree
     * @param u source node
     * @param w destination node
     */
    public void addEdge(int u, int w){
        /*check for bounds on v and w*/
        if(u<1 || u>n || w<1 || w>n)
            throw new IndexOutOfBoundsException();
        if(u<w)
            treeNodes.get(u-1).addChildren(treeNodes.get(w-1));
        else
            treeNodes.get(w-1).addChildren(treeNodes.get(u-1));
    }

    /**
     * Count the number of Nodes in Subtree
     */
    public void countNodesSubtree(){
        countNodesSubtree(this.getRoot());
    }

    /**
     * Count the number of nodes in subtree starting at root
     * @param root: Root of the subtree
     */

    public int countNodesSubtree(TreeNode root){
        int sum=0;
        if(root.getChildren().size() == 0) {
            root.setNodesInSubtree(1);
            return 1;
        }
        for(TreeNode c: root.getChildren())
            sum += countNodesSubtree(c);
        root.setNodesInSubtree(1 + sum);
        return sum+1;
    }

    /**
     * Finds the edges that when removed gives us an even subtree
     * @return Number of edges to be disconnected
     */
    public int findEvenSubtreeEdges() {
        int edges = 0;
        for (TreeNode t: this.treeNodes) {
            if(t.getNodesInSubtree()%2 == 0)
                edges++;
        }
        return edges-1;
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
