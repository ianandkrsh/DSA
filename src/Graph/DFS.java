package Graph;
import java.util.*;

import static Graph.DFS.addEdge;

public class DFS {

    public static void main(String args[])
    {
        int V = 7;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for(int i = 0;i<=V;i++)
             adj.add(new ArrayList<Integer>());


        // Adding edges one by one
        addEdge(adj, 1, 2);
        addEdge(adj, 2, 4);
        addEdge(adj, 2, 7);
        addEdge(adj, 3, 5);
        addEdge(adj, 4, 6);
        addEdge(adj, 6, 7);


        Solution2 obj = new Solution2();
        ArrayList<Integer>ans = obj.DFSofGraph(V, adj);
        for (int i =0 ;i < ans.size (); i++)
            System.out.print (ans.get (i) + " ");
        System.out.println();


    }

     static void addEdge(ArrayList<ArrayList<Integer> > adj, int u, int v)
    {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
}

class Solution2
{
    public static void dfs(int node , boolean[] vis , ArrayList<ArrayList<Integer>> adj ,ArrayList<Integer> storeDFS )
    {
        storeDFS.add(node);
        vis[node] = true;
        for (Integer it : adj.get(node)) {
            if (vis[it] == false) {
                dfs(it,vis,adj,storeDFS);
            }
        }
    }
    public static ArrayList<Integer> DFSofGraph(int V , ArrayList<ArrayList<Integer>> adj)
    {
        ArrayList<Integer> storeDFS = new ArrayList<Integer>();
        boolean[] vis = new boolean[V+1];
        for(int i = 1;i<=V;i++)
        {
            if(vis[i]== false)
            {
              dfs(i,vis,adj,storeDFS);
            }
        }

        return storeDFS;
    }
}