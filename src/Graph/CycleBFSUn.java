package Graph;

import java.util.*;
public class CycleBFSUn {
    public static void main(String args[])
    {
        int V = 11;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for(int i = 0;i<=V;i++)
            adj.add(new ArrayList<Integer>());

        addEdge(adj ,1,2);
        addEdge(adj ,2,4);
        addEdge(adj ,3,5);
//        addEdge(adj ,5,6);
//        addEdge(adj ,5,10);
//        addEdge(adj ,6,7);
//        addEdge(adj ,7,8);
//        addEdge(adj ,8,9);
//        addEdge(adj ,8,11);
//        addEdge(adj ,9,10);

        Solution1 obj = new Solution1();
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
class Node1
{
    int first , second;
    public Node1(int first , int second)
    {
        this.first = first;
        this.second = second;
    }
}

class Solution1
{
         public static boolean checkforCycle(int s ,ArrayList<ArrayList<Integer>> adj , boolean vis[])
         {
             Queue<Node1> q = new LinkedList<>();
             q.add(new Node1(s,-1));
             vis[s] = true;

             while(!q.isEmpty())
             {
                 int node = q.peek().first;
                 int par = q.peek().second;
                 q.remove();

                 for(int it :adj.get(node))
                 {
                     if(vis[it] == false)
                     {
                         q.add(new Node1(it,node));
                         vis[it] = true;
                     }

                     else if(par!=it)
                         return true;


                 }
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
                    if(checkforCycle(i,adj,vis))
                        return true;
                }
            }

            return false;
        }

}
