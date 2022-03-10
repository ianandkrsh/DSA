package Graph;

import java.util.*;
public class CycleDFSUn {
    public static void main(String args[])
    {
        int V = 8;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for(int i = 0;i<=V;i++)
            adj.add(new ArrayList<Integer>());

        addEdge(adj ,1,3);
        addEdge(adj ,2,5);
        addEdge(adj ,3,4);
        addEdge(adj ,5,6);
        addEdge(adj ,5,8);
       addEdge(adj ,6,7);
        addEdge(adj ,7,8);

        Solu obj = new Solu();
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
        adj.get(v).add(u);
    }
}


class Solu
{
    public static boolean checkforCycle(int node,int parent,ArrayList<ArrayList<Integer>> adj , boolean vis[])
    {
       vis[node] = true;
        for(int it :adj.get(node))
            {
                if(vis[it] == false)
                {

                 if(checkforCycle(it,node,adj,vis))
                     return true;
                }

                else if(parent!=it)
                    return true;


            }

        return false;

    }





    public static boolean isCycle(int V ,ArrayList<ArrayList<Integer>> adj )
    {
        boolean vis[] = new boolean[V+1];
        Arrays.fill(vis,false);

        for(int i =1;i<=V;i++)
        {
            if(vis[i] == false)
            {
//                vis[i] = true;
                if(checkforCycle(i,-1,adj,vis))
                    return true;
            }
        }

        return false;
    }

}
