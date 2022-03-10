package practiceArena;

import java.sql.SQLOutput;
import java.util.*;

public class Graph {
    public static void main(String args[])
    {
        int V = 7;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(V);
        for(int i = 0;i<=V;i++)
        {
            adj.add(new ArrayList<Integer>());
        }

        addEdge(adj,1,2);
        addEdge(adj,2,3);
        addEdge(adj,2,7);
        addEdge(adj,3,5);
        addEdge(adj,7,5);
        addEdge(adj,4,6);

//        for (int i = 0; i < adj.size(); i++) {
//            System.out.println("\nAdjacency list of vertex"
//                    + i);
//            System.out.print("head");
//            for (int j = 0; j < adj.get(i).size(); j++) {
//                System.out.print(" -> "
//                        + adj.get(i).get(j));
//            }
//            System.out.println();
//        }

        Required obj = new Required();
        ArrayList<Integer> ans = obj.DFS(V,adj);
        for(int i =0;i<ans.size();i++)
        {
            System.out.print(ans.get(i) + " ");
        }

    }

    static void addEdge(ArrayList<ArrayList<Integer>> adj ,int u , int v)
    {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
}

class Required
{

    public static ArrayList<Integer> BFS(int V ,ArrayList<ArrayList<Integer>> adj )
    {
        ArrayList<Integer> bfs = new ArrayList<Integer>();
        boolean vis[] = new boolean[V+1];



        for(int i =1;i<=V;i++)
        {
            if(!vis[i])
            {
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                vis[i] = true;   //as you add in the queue make it visited
                while(!q.isEmpty())
                {
                    int node = q.poll();
                    bfs.add(node);
                    for(int it : adj.get(node))
                    {
                        if(!vis[it]) {
                            q.add(it); vis[it] = true;  //as you add in the queue make it visited
                        }
                    }
                }

            }
        }

        return bfs;
    }
    public static void recurdfs(int node , ArrayList<ArrayList<Integer>> adj , boolean vis[],   ArrayList<Integer> dfs )
    {
        dfs.add(node);
        vis[node] = true;
        for(int it : adj.get(node))
        {
            if(!vis[it])
            recurdfs(it,adj,vis,dfs);
        }

    }

    public static  ArrayList<Integer> DFS(int V ,ArrayList<ArrayList<Integer>> adj)
    {
        ArrayList<Integer> dfs = new ArrayList<Integer>();
        boolean vis[] = new boolean[V+1];

        for(int i =1;i<=V;i++)
        {
            if(!vis[i])
            {
                 recurdfs(i,adj,vis,dfs)  ;
            }

        }

        return dfs;
    }



}
