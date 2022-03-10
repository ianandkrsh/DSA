//package Graph;
//
//import java.util.*;
////class Node implements Comparator<Node>
////{
//    int N;
//    int weight;
//
//    Node(int N, int weight)
//    { this.N = N;
//        this.weight = weight; }
//
//
//    Node() {}
//
//    @Override
//    public int compare(Node node1, Node node2)
//    {
//        if (node1.weight < node2.weight)
//            return -1;
//        if (node1.weight > node2.weight)
//            return 1;
//        return 0;
//    }
//}
//public class Dijkstra {
//    public static void main(String[] args) {
//        int V = 5;
//        int src = 0;
//        ArrayList<ArrayList<Node>> adj = new ArrayList<ArrayList<Node>>();
//         for(int i = 0;i<V;i++)
//             adj.add(new ArrayList<Node>());
//
//        adj.get(0).add(new Node(1, 2));
//        adj.get(1).add(new Node(0, 2));
//
//        adj.get(1).add(new Node(2, 4));
//        adj.get(2).add(new Node(1, 4));
//
//        adj.get(0).add(new Node(3, 1));
//        adj.get(3).add(new Node(0, 1));
//
//        adj.get(3).add(new Node(2, 3));
//        adj.get(2).add(new Node(3, 3));
//
//        adj.get(1).add(new Node(4, 5));
//        adj.get(4).add(new Node(1, 5));
//
//        adj.get(2).add(new Node(4, 1));
//        adj.get(4).add(new Node(2, 1));
//
//        Main obj = new Main();
//        obj.shortestPath(src, adj, V);
//
//    }
//}
//
//
//
//class Main
//{
//    public static void shortestPath(int src, ArrayList<ArrayList<Node>> adj ,int V)
//    {
//        int dist[] = new int[V];
//        for(int i =0;i<V;i++)
//            dist[i] = Integer.MAX_VALUE;
//
//        dist[src] = 0;
//        //  PriorityQueue<String> queue = new
//        //        PriorityQueue<String>(new The_Comparator());
//        PriorityQueue<Node> pq = new PriorityQueue<Node>(V, new Node());
//        pq.add(new Node(src,0));
//
//        while(!pq.isEmpty()) {
//            Node node = pq.poll();
//
//            for (Node it : adj.get(node.N)) {
//                if (dist[node.N] + it.weight < dist[it.N]) {
//                    dist[it.N] = dist[node.N] + it.weight;
//                    pq.add(new Node(it.N, dist[it.N]));
//                }
//            }
//        }
//        for (int i = 0; i < V; i++)
//        {
//            System.out.print( dist[i] + " ");
//        }
//    }
//}
