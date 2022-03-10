package Graph;
import java.util.*;



public class Topological {

    public static void main(String args[])
    {
        int V = 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for(int i = 0;i<V;i++)
            adj.add(new ArrayList<Integer>());


        // Adding edges one by one

        addEdge(adj, 2, 3);
        addEdge(adj, 3, 1);
        addEdge(adj, 4, 0);
        addEdge(adj, 4, 1);
        addEdge(adj, 5, 0);
        addEdge(adj, 5, 2);

        Solution21 obj = new Solution21();
        ArrayList<Integer>ans = obj.topSort(V, adj);
        for (int i =0 ;i < ans.size (); i++)
            System.out.print (ans.get (i) + " ");
        System.out.println();
    }

    static void addEdge(ArrayList<ArrayList<Integer> > adj, int u, int v)
    {
        adj.get(u).add(v);

    }
}

class Solution21
{
    public static void dfs(int node , boolean[] vis , ArrayList<ArrayList<Integer>> adj ,Stack<Integer> st)
    {

        vis[node] = true;
        for (Integer it : adj.get(node)) {
            if (vis[it] == false) {
                dfs(it,vis,adj,st);
            }
        }
        st.push(node);
    }

    public static  ArrayList<Integer> topSort(int V , ArrayList<ArrayList<Integer>> adj)
    {
//        Stack<Integer> st = new Stack<>();
//        boolean[] vis = new boolean[V];

        ArrayList<Integer> bfs = new ArrayList<>();
        int indegree[] = new int[V];
        Queue<Integer> q = new LinkedList<>();
        for(ArrayList<Integer> item:adj)
        {
            for(int node :item)
                indegree[node] ++;
        }
        System.out.println("Indegree");
        for(int node :indegree)
            System.out.print(node+" ");
        System.out.println();

   //top sort start from node having zero indegree
        for(int i = 0;i<V;i++)
        {
            if(indegree[i]== 0)
            {
              q.add(i);
            }
        }


        while (!q.isEmpty()) {
            Integer node = q.poll();
            bfs.add(node);


            for (Integer it : adj.get(node)) {
                if (--indegree[it] == 0)
                    q.add(it);
            }
        }

//        int top[] = new int[V];
//        int index =0;
//        while(!st.isEmpty())
//        {
//            top[index++] = st.pop();
//        }
//
//        for(int i = 0; i<top.length;i++)
//        {
//            System.out.println(top[i]+" ");
//        }

        return bfs;
    }
}