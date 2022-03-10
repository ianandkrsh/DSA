package Graph;

import java.util.*;
public class CycleDFS {
    public static void main(String args[])
    {
        int V = 9;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for(int i = 0;i<=V;i++)
            adj.add(new ArrayList<Integer>());

        addEdge(adj ,1,2);
        addEdge(adj ,2,3);
        addEdge(adj ,3,4);
        addEdge(adj ,3,6);
        addEdge(adj ,4,5);
        addEdge(adj ,6,5);
        addEdge(adj ,7,2);
        addEdge(adj ,7,8);
        addEdge(adj ,9,8);
        addEdge(adj ,9,7);

        Solution obj = new Solution();
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


class Solution
{
    public static boolean checkforCycle(int node,ArrayList<ArrayList<Integer>> adj , boolean vis[] ,boolean dfsvis[])
    {
        vis[node] = true;
        dfsvis[node] = true;  //current call
        for(int it :adj.get(node))
        {
            if(vis[it] == false)
            {

                if(checkforCycle(it,adj,vis,dfsvis))
                    return true;
            }

            else if(dfsvis[it])
                return true;




        }
        dfsvis[node] = false;

        return false;

    }





    public static boolean isCycle(int V ,ArrayList<ArrayList<Integer>> adj )
    {
        boolean vis[] = new boolean[V+1];
        boolean dfsvis[] = new boolean[V+1];
        Arrays.fill(vis,false);

        for(int i =1;i<=V;i++)
        {
            if(vis[i] == false)
            {
//                vis[i] = true;
                if(checkforCycle(i,adj,vis,dfsvis))
                    return true;
            }
        }

        return false;
    }

}
