package practiceArena;

import java.sql.SQLOutput;
import java.util.*;

public class Bipartite {
    public static void main(String args[])
    {
        int V = 8;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(V);
        for(int i = 0;i<=V;i++)
        {
            adj.add(new ArrayList<Integer>());
        }

        addEdge(adj,1,2);
        addEdge(adj,2,3);
        addEdge(adj,2,8);
        addEdge(adj,3,4);
        addEdge(adj,4,5);
        addEdge(adj,5,6);
        addEdge(adj,5,8);
        addEdge(adj,6,7);

//        addEdge(adj,1,2);
//        addEdge(adj,2,3);
//        addEdge(adj,2,7);
//        addEdge(adj,3,4);
//        addEdge(adj,4,5);
//        addEdge(adj,5,6);
//        addEdge(adj,5,8);
//        addEdge(adj,6,7);

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

        Rd obj = new Rd();
        boolean ans = obj.DFS(V,adj);

        if(ans)
            System.out.print("Bipartite");
        else
            System.out.print("Not Bipartite");



    }

    static void addEdge(ArrayList<ArrayList<Integer>> adj ,int u , int v)
    {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
}

class Rd
{
    public static boolean checkBipartite(int s ,ArrayList<ArrayList<Integer>> adj , int color[] )
    {
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        color[s] = 1;

        while(!q.isEmpty())
        {
            int node = q.poll();
            for(int it : adj.get(node))
            {
                if(color[it]==-1)
                {
                    q.add(it);
                    color[it] = 1 - color[node];

                }

                else if(color[it]==color[node])
                    return false;

            }
        }
      return true;
    }
    public static boolean BFS(int V ,ArrayList<ArrayList<Integer>> adj)
    {
        int color[] = new int[V+1];
        Arrays.fill(color,-1);

        for(int i =1;i<=V;i++)
        {
            if(color[i]==-1)
            {
                if(!checkBipartite(i,adj,color))
                    return false;
            }
        }

        return true;
    }

    ///DFS


    public static boolean isBipartite(int node ,ArrayList<ArrayList<Integer>> adj , int color[] )
    {

        if (color[node]==-1)
            color[node] = 1;
            for(int it : adj.get(node))
            {
                if(color[it]==-1)
                {

                    color[it] = 1 - color[node];
                   if( !isBipartite(it,adj,color))
                       return false;

                }

                else if(color[it]==color[node])
                    return false;

            }

        return true;
    }

    public static boolean DFS(int V ,ArrayList<ArrayList<Integer>> adj)
    {
        int color[] = new int[V+1];
        Arrays.fill(color,-1);

        for(int i =1;i<=V;i++)
        {
            if(color[i]==-1)
            {
                if(!isBipartite(i,adj,color))
                    return false;
            }
        }

        return true;
    }




}