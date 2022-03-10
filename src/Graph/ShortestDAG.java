package Graph;

import java.util.*;
public class ShortestDAG {
    public static void main(String args[])
    {
        int V = 6;
        int src = 4;

        ArrayList<ArrayList<Pair>> adj = new ArrayList<ArrayList<Pair>>();
        for(int i = 0;i<V;i++)
            adj.add(new ArrayList<Pair>());


        adj.get(0).add(new Pair(1,2));
        adj.get(0).add(new Pair(4,1));
        adj.get(1).add(new Pair(2,3));
        adj.get(2).add(new Pair(3,6));
        adj.get(4).add(new Pair(2,2));
        adj.get(4).add(new Pair(5,4));
        adj.get(5).add(new Pair(3,1));

        sol obj = new sol();
        obj.DAG(adj,V,src);


    }



}

class Pair
{
    int N ; //node
    int weight;

    Pair(int N , int weight)
    {
        this.N = N;
        this.weight = weight;
    }

}

class sol
{
    public static void topo(ArrayList<ArrayList<Pair>> adj ,boolean vis[] ,int node ,Stack<Integer> st )
    {
        vis[node] = true;
        for(Pair it : adj.get(node))
        {
            if(vis[it.N] == false)
            {
                topo(adj , vis , it.N , st);
            }
        }

        st.add(node);
    }
    public static void DAG(ArrayList<ArrayList<Pair>> adj  , int V , int src)
    {
        int dist[] = new int[V];
        for(int i = 0;i<V;i++)
            dist[i] = Integer.MAX_VALUE;

        boolean vis[] = new boolean[V];
        Stack<Integer> st = new Stack<>();

        for(int i = 0;i<V;i++)
        {
            if(!vis[i])
            {
               topo(adj,vis,i,st);
            }
        }

        dist[src] = 0;
        while(!st.isEmpty())
        {
            int node = (int)st.pop();
            if(dist[node]!=Integer.MAX_VALUE)
            {
               for(Pair it : adj.get(node))
               {
                   if(dist[node]+it.weight < dist[it.N])
                       dist[it.N] = dist[node]+it.weight;
               }
            }
        }


        for(int i = 0;i<V;i++) {
            if(dist[i]==Integer.MAX_VALUE)
                System.out.print("INF" + " ");
            else
                System.out.print(dist[i] + " ");
        }
    }
}
