package Graph;

import java.util.*;
import java.util.ArrayList;
class Node
{
    int N; int weight;
    Node(int N , int weight)
    {
        this.N = N;
        this.weight = weight;
    }

}

public class MST {
    public static void main(String args[])
    {
        int V = 5;
        ArrayList<ArrayList<Node>> adj = new ArrayList<ArrayList<Node>>();
        for(int i =0;i<V;i++)
            adj.add(new ArrayList<Node>());

        adj.get(0).add(new Node(1,2));
        adj.get(0).add(new Node(3,6));

        adj.get(1).add(new Node(0,2));
        adj.get(1).add(new Node(2,3));
        adj.get(1).add(new Node(3,8));
        adj.get(1).add(new Node(4,5));

        adj.get(2).add(new Node(1,3));
        adj.get(2).add(new Node(4,7));

        adj.get(3).add(new Node(0,6));
        adj.get(3).add(new Node(1,8));

        adj.get(4).add(new Node(1,5));
        adj.get(4).add(new Node(2,7));

        niam obj = new niam();
        obj.prims(V,adj);
    }
}

class niam
{
    public static void prims(int V ,  ArrayList<ArrayList<Node>> adj)
    {
        int key[] = new int[V];
        boolean mst[] = new boolean[V];
        int parent[] = new int[V];

        for(int i = 0;i<V;i++)
        {
            key[i] = 1000000000;
            mst[i] = false;
            parent[i] = -1;

        }

        key[0] = 0;

        for(int i = 0;i<V-1;i++)
        {
            int min =  1000000000 , u = 0;
            for(int k = 0;k<V;k++)  //finding the minimal value in key array
            {
                if(mst[k]==false && key[k]<min)
                {
                    min = key[k];
                    u = k;
                }
            }

            mst[u] = true;  //set the minimal as true

            for(Node it : adj.get(u))
            {
                if(mst[it.N] == false && it.weight < key[it.N])
                {
                    parent[it.N] = u;
                    key[it.N] = it.weight;
                }
            }
        }

        for(int i = 1;i<V;i++)
        {
              System.out.println(parent[i] + " __ " + i);
        }

    }
}
