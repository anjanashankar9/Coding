import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * @Author Anjana Shankar
 * @Created 2020-09-21
 */
public class Graph {
    private final int v;
    private int e;
    private List<Integer>[] adj;

    /**
     * Create a Graph with V vertices
     * @param V number of vertices in the graph
     */
    public Graph(int V) {
        if(V<0)
            throw new IllegalArgumentException("Number of vertices must be non negative");
        this.v = V;
        this.e=0;
        adj = (LinkedList<Integer>[]) new LinkedList[V];
        for(int i=0;i<v;i++){
            adj[i] = new LinkedList<Integer>();
        }
    }

    /**
     * Getter for number of vertices
     * @return number of vertices
     */
    public int getV(){
        return v;
    }

    /**
     * Getter for number of edges
     * @return number of edges
     */
    public int getE(){
        return e;
    }

    /**
     * Add edge for directed graph
     * @param u source vertex
     * @param w destination vertex
     */
    public void addEdge(int u, int w){
        /*check for bounds on v and w*/
        if(u<0 || u>=v || w<0 || w>=v)
            throw new IndexOutOfBoundsException();
        e++;
        adj[u].add(w);
    }

    /**
     * Returns the list of vertices connected to U
     * @param u
     * @return list of vertices
     */
    private List<Integer> getAdjacentVertices(int u){
        if(u<0 || u>=v)
            throw new IndexOutOfBoundsException();
        return adj[u];
    }

    /**
     * Prints the graph
     */
    public void printGraph(){
        for(int i=0;i<v;i++){
            System.out.print(i+" : ");
            List<Integer> adjVertices = getAdjacentVertices(i);
            for(int w:adjVertices){
                System.out.print(w+" ");
            }
            System.out.println();
        }
    }

    /**
     * A utility function for topological sort. It recursively pushes all vertices connected to this vertex
     * @param vertex
     * @param visited A boolean array for keeping track of which vertices are visited
     * @param stack Stack for maintaining the traversal order
     */
    private void topologicalSortUtil(int vertex, boolean[] visited, Stack<Integer> stack){
        visited[vertex] = true;

        List<Integer> adjVertices = getAdjacentVertices(vertex);
        for(int u:adjVertices){
            if(!visited[u]){
                topologicalSortUtil(u,visited,stack);
            }
        }
        //Push current vertex to Stack
        stack.push(vertex);
    }

    /**
     * Function that does a topological sort for the given array
     * Topological sort for DAG is a linear ordering of vertices such that for every directed edge uv,
     * u comes before v in the ordering.
     * Topological sort is not possible if the graph is not a DAG.
     */
    public void topologicalSort(){
        Stack<Integer> stack = new Stack<>();

        boolean[] visited = new boolean[v];

        for(int i=0;i<v;i++){
            if(!visited[i]){
                topologicalSortUtil(i,visited,stack);
            }
        }
        //Print contents of Stack
        while(!stack.empty()){
            int c = 'a'+stack.pop();
            System.out.print((char)c+" ");
        }
    }

    /**
     * Depth first traversal of the graph starting from a given vertex
     * Runs in O(V+E) time
     * @param w starting vertex
     * Note: In case the graph is a disconnected graph,
     *          the function will only be able to traverse the component in which the starting vertex is present
     */
    public void DFS(int w){
        boolean[] visited = new boolean[v];
        for(int i=0;i<v;i++){
            visited[i] = false;
        }
        DFS(visited,w);
    }

    /**
     * Helper function for Depth first traversal. Recursively traverses the graph in a depth first manner
     * @param visited A boolean array that keeps track of the visited vertices
     * @param w The vertex from which we need to traverse.
     */
    private void DFS(boolean [] visited,int w){
        System.out.print(w+" ");
        visited[w] = true;
        for(int u:adj[w]){
            if(!visited[u]){
                DFS(visited,u);
            }
        }
    }

    /**
     * Breadth first traversal of the graph starting from a given vertex
     * Runs in O(V+E) time
     * @param w starting vertex
     * Note: In case the graph is a disconnected graph,
     *          the function will only be able to traverse the component in which the starting vertex is present
     */
    public void BFS(int w){
        boolean[] visited = new boolean[v];
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(w);
        visited[w] = true;
        while(q.size() > 0){
            int vertex = q.remove();
            System.out.print(vertex+" ");
            List<Integer> adjVertices = getAdjacentVertices(vertex);
            for(int u : adjVertices){
                if(!visited[u]){
                    q.add(u);
                    visited[u] = true;
                }
            }
        }
    }

}

