package mst.prim;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class MSTPrim {

    class Edge{
        
        int dest, weight;
        
        Edge(int dest, int weight){
            this.dest = dest;
            this.weight = weight;
        }
    }
    
    static class Graph{
        int V;
        LinkedList<Edge>[] adj;
        
        Graph(int v) {
            V = v;
            adj = new LinkedList[V];
            for (int i = 0; i < V; i++) {
                adj[i] = new  LinkedList<>();
            }
        }
    }
    
    class Node {
        int vertex;
        int key;
    }
    
    class comparator implements Comparator<Node>{
        
        @Override
        public int compare(Node o1, Node o2) {
            return o1.key - o2.key;
        }
    }
    
    public void addEdge(Graph graph, int src, int dest, int weight) {
        Edge edge = new Edge(dest, weight);
        Edge edge2 = new Edge(src, weight);
        graph.adj[src].addLast(edge);
        graph.adj[dest].addLast(edge2);
    }
    
    public void prim(Graph graph) {
        Boolean[] set = new Boolean[graph.V];
        Node[] node = new Node[graph.V];
        
        int[] parent = new int[graph.V];
        
        for (int i = 0; i < graph.V; i++) {
            node[i] = new Node();
        }
        
        for (int i = 0; i < graph.V; i++) {
            set[i] = false;
            
            node[i].key = Integer.MAX_VALUE;
            node[i].vertex = i;
            parent[i] = -1;
        }
        
        set[0] = true;
        node[0].key = 0;
        
        TreeSet<Node> queue = new TreeSet<Node>(new comparator());
        
        for (int i = 0; i < graph.V; i++) {
            queue.add(node[i]);
        }
        
        while(!queue.isEmpty()) {
            Node now = queue.pollFirst();
            
            set[now.vertex] = true;
            
            for (Edge iterator : graph.adj[now.vertex]) {
                if (set[iterator.dest] == false) {
                    if (node[iterator.dest].key  >  iterator.weight) {
                        queue.remove(node[iterator.dest]);
                        node[iterator.dest].key = iterator.weight;
                        queue.add(node[iterator.dest]);
                        parent[iterator.dest] = now.vertex;
                    }
                }
            }
        }
        
        for (int i = 1; i < graph.V; i++) {
            System.out.println(parent[i] + " " + "-" + " " + i );
        }
        
    }

    public static void main(String[] args) {
        
        int V = 9;
        
        Graph graph = new Graph(V);
        
        MSTPrim prim = new MSTPrim();
        
        prim.addEdge(graph, 0, 1, 4);
        prim.addEdge(graph, 0, 7, 8);
        prim.addEdge(graph, 1, 2, 8);
        prim.addEdge(graph, 1, 7, 11);
        prim.addEdge(graph, 2, 3, 7);
        prim.addEdge(graph, 2, 8, 2);
        prim.addEdge(graph, 2, 5, 4);
        prim.addEdge(graph, 3, 4, 9);
        prim.addEdge(graph, 3, 5, 14);
        prim.addEdge(graph, 4, 5, 10);
        prim.addEdge(graph, 5, 6, 2);
        prim.addEdge(graph, 6, 7, 1);
        prim.addEdge(graph, 6, 8, 6);
        prim.addEdge(graph, 7, 8, 7);
        
        prim.prim(graph);
        
    }

}

