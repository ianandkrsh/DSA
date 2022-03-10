import java.lang.*;
import java.io.*;
import java.util.*;
class BFS
{
    public static void main(String[] args) throws IOException
    {
        // Creating a graph with 5 vertices
        int V = 7;
        ArrayList<ArrayList<Integer> > adj
                = new ArrayList<ArrayList<Integer> >(V);

        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<Integer>());

        // Adding edges one by one
        addEdge(adj, 0, 1);
        addEdge(adj, 1, 2);
        addEdge(adj, 1, 6);
        addEdge(adj, 3, 5);
        addEdge(adj, 2, 4);
        addEdge(adj, 6, 4);
                //adj.get(u).add(v);
                // adj.get(v).add(u);

            Solution obj = new Solution();
            ArrayList<Integer>ans = obj.bfsOfGraph(V, adj);
            for (int i =0 ;i < ans.size (); i++)
                System.out.print (ans.get (i) + " ");
            System.out.println();

    }

    static void addEdge(ArrayList<ArrayList<Integer> > adj,
                        int u, int v)
    {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

}
// } Driver Code Ends


class Solution
{
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj)
    {

        ArrayList<Integer> bfs = new ArrayList<>();
        boolean vis[] = new boolean[V];

        for(int i = V-1;i>=0;i--) {

            if(vis[i]==false) {
                Queue<Integer> q = new LinkedList<>();

                q.add(i);
                vis[i] = true;

                while (!q.isEmpty()) {
                    Integer node = q.poll();
                    bfs.add(node);

                    // Get all adjacent vertices of the dequeued vertex s
                    // If a adjacent has not been visited, then mark it
                    // visited and enqueue it
                    for (Integer it : adj.get(node)) {
                        if (vis[it] == false) {
                            vis[it] = true;
                            q.add(it);
                        }
                    }
                }


            }
        }

        return bfs;
        // Code here
    }
}