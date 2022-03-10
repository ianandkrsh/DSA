

import java.util.*;

public class Shortest {

    public static void main(String args[])
    {
        int V = 9;
        int src = 6; //source
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer> >();
        for(int i =0;i<V;i++)
            adj.add(new ArrayList<Integer>());


        addEdge(adj,0,1);
        addEdge(adj,0,3);
        addEdge(adj,1,2);
        addEdge(adj,1,3);
        addEdge(adj,2,6);
        addEdge(adj,3,4);
        addEdge(adj,4,5);
        addEdge(adj,5,6);
        addEdge(adj,6,7);
        addEdge(adj,6,8);
        addEdge(adj,7,8);



        Solution10 obj = new Solution10();
        obj.BFS(V,src,adj);

    }

    static void addEdge(ArrayList<ArrayList<Integer>> adj , int u  , int v)
    {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

}

class Solution10
{
    public static void BFS(int V ,int src , ArrayList<ArrayList<Integer>> adj)
    {
        //distance array of all nodes from the source node
        int dist[] = new int[V];
       for(int i= 0;i<dist.length;i++)
           dist[i] = 1000;

        Queue<Integer> q = new LinkedList<>();

        q.add(src);
        dist[src] = 0;

        while(!q.isEmpty())
        {
            int node = q.poll();
            for(int it : adj.get(node))
            {
                if(dist[node] + 1 < dist[it]){
                    dist[it] = dist[node] + 1;
                    q.add(it);
                }
            }
        }

        for(int item : dist)
            System.out.print(item + " ");

    }
}
