package Graph;

import java.util.*;
public class CycleBFS {
    public static void main(String args[])
    {
        int V = 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for(int i = 0;i<V;i++)
            adj.add(new ArrayList<Integer>());

        addEdge(adj, 2, 3);
        addEdge(adj, 3, 1);
        addEdge(adj, 4, 0);
        addEdge(adj, 4, 1);
        addEdge(adj, 5, 0);
        addEdge(adj, 5, 2);

        Solutio obj = new Solutio();
        boolean b = obj.isCycle(V , adj);
        System.out.println(b);
        if(b)
            System.out.println("Cycle");
        else
            System.out.println(" Not Cycle");




    }
    public static void addEdge(ArrayList<ArrayList<Integer>> adj , int u , int v)
    {
        adj.get(u).add(v);

    }
}


class Solutio
{






    public static boolean isCycle(int V ,ArrayList<ArrayList<Integer>> adj )
    {
       int indegree[] = new int[V];
        Queue<Integer> q = new LinkedList<>();
        for(ArrayList<Integer> item:adj)
        {
            for(int node :item)
                indegree[node] ++;
        }
        //top sort start from node having zero indegree
        for(int i = 0;i<V;i++)
        {
            if(indegree[i]== 0)
            {
                q.add(i);
            }
        }
      int count =0;
      while(!q.isEmpty())
      {
          int node = q.poll();
          count++;
          for(int it :adj.get(node))
          {
              if(--indegree[it]==0)
                  q.add(it);
          }
      }

     System.out.println(count);

      if(count==V)
          return false;
      else
          return true;

    }

}
