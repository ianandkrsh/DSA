package practiceArena;

import java.sql.SQLOutput;
import java.util.*;

public class Cycle {
    public static void main(String args[])
    {
        int V = 3;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(V);
        for(int i = 0;i<=V;i++)
        {
            adj.add(new ArrayList<Integer>());
        }

        addEdge(adj,1,2);
        addEdge(adj,2,3);
//        addEdge(adj,3,5);
//        addEdge(adj,5,6);
//        addEdge(adj,5,10);
//        addEdge(adj,6,7);
//        addEdge(adj,7,8);
//        addEdge(adj,8,9);
//        addEdge(adj,8,11);
//        addEdge(adj,9,10);


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

        Req obj = new Req();
        boolean ans = obj.BFS(V,adj);

            System.out.print(ans);


    }

    static void addEdge(ArrayList<ArrayList<Integer>> adj ,int u , int v)
    {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
}

class Node
{
    int first;
    int second;
    Node(int first , int second)
    {
        this.first = first;
        this.second = second;
    }
}

class Req
{

    public static boolean isCycle(int node , int parent , ArrayList<ArrayList<Integer>> adj , boolean vis[])
    {
        vis[node] = true;
        for(int it : adj.get(node))
        {
            if(!vis[it])
            {
                if( isCycle(it,node,adj,vis))
                    return true;
            }
            else if(parent!= it)
                return true;
        }

        return false;
    }
    public static boolean DFS(int V , ArrayList<ArrayList<Integer>> adj)
    {
          boolean vis[] = new boolean[V+1];

          for(int i =1;i<=V;i++)
          {
              if(!vis[i])
              {
               if( isCycle(i,-1,adj,vis))
                   return true;
              }
          }

          return false;
    }

    public static boolean checkCycle(int s , ArrayList<ArrayList<Integer>> adj , boolean vis[])
    {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(s,-1));
        vis[s] = true;

        while(!q.isEmpty())
        {
            int node = q.peek().first;
            int parent = q.peek().second;
            q.remove();

            for(int it : adj.get(node))
            {
                if(!vis[it])
                {
                    vis[it] = true;
                    q.add(new Node(it,node));
                }
                else if(parent!= it)
                    return true;
            }
        }

      return false;
    }

    public static boolean BFS(int V , ArrayList<ArrayList<Integer>> adj)
    {
        boolean vis[] = new boolean[V+1];

        for(int i =1;i<=V;i++)
        {
            if(!vis[i])
            {
                if( checkCycle(i,adj,vis))
                    return true;
            }
        }

        return false;
    }


}