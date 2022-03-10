package Graph;

import java.util.*;
public class Bipartite {
    public static void main(String args[])
    {
        int V = 8;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for(int i = 0;i<=V;i++)
            adj.add(new ArrayList<Integer>());

        addEdge(adj ,1,2);
        addEdge(adj ,2,3);
        addEdge(adj ,2,7);
        addEdge(adj ,3,4);
        addEdge(adj ,4,5);
        addEdge(adj ,5,6);
        addEdge(adj ,5,8);
        addEdge(adj ,6,7);


        Solution9 obj = new Solution9();
        boolean b = obj.isBipartite(V , adj);
        System.out.println(b);
        if(b)
            System.out.println("Bipartite");
        else
            System.out.println(" Not Bipartite");




    }
    public static void addEdge(ArrayList<ArrayList<Integer>> adj , int u , int v)
    {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
}


class Solution9
{
    public static boolean checkforBipartite(int node ,ArrayList<ArrayList<Integer>> adj , int color[]) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        color[node] = 1;
        while(!q.isEmpty())
       {
           int nde = q.poll();
         for (int it : adj.get(nde)) {
            if (color[it] == -1) {
                color[it] = 1 - color[nde];
                q.add(it);

            } else if (color[nde] == color[it])
                return false;


        }
      }


        return true;
    }
    public static boolean checkforBipartitedfs(int node ,ArrayList<ArrayList<Integer>> adj , int color[]) {

            if (color[node]==-1)
                color[node] = 1;
            for (int it : adj.get(node)) {
                if (color[it] == -1) {
                    color[it] = 1 - color[node];


                } else if (color[node] == color[it])
                    return false;


            }



        return true;
    }


    public static boolean isBipartite(int V ,ArrayList<ArrayList<Integer>> adj )
    {
       int color[] = new int[V+1];
        Arrays.fill(color,-1);



        for(int i =1;i<=V;i++)
        {
            if(color[i] == -1)
            {
                if(!checkforBipartitedfs(i,adj,color))
                    return false;
            }
        }

        return true;
    }

}























