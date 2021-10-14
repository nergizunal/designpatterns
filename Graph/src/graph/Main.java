package graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.*;
public class Main {
    public static void main(String args[])
    {

        // Object of graph is created.
        Graph<Integer> g = new Graph<Integer>();

        // edges are added.
        // Since the graph is bidirectional,
        // so boolean bidirectional is passed as true.
        g.addEdge(0, 1, true);
        g.addEdge(0, 4, true);
        g.addEdge(1, 2, true);
        g.addEdge(1, 3, true);
        g.addEdge(1, 4, true);
        g.addEdge(2, 3, true);
        g.addEdge(3, 4, true);

        // print the graph.
        System.out.println("Graph:\n"
                + g.toString());

        // gives the no of vertices in the graph.
        g.getVertexCount();

        // gives the no of edges in the graph.
        g.getEdgesCount(true);

        // tells whether the edge is present or not.
        g.hasEdge(3, 4);

        // tells whether vertex is present or not
        g.hasVertex(5);


        Graph2 g2 = new Graph2(7);

        g2.addEdge(0, 1);
        g2.addEdge(0, 2);
        g2.addEdge(1, 3);
        g2.addEdge(4, 1);
        g2.addEdge(6, 4);
        g2.addEdge(5, 6);
        g2.addEdge(5, 2);
        g2.addEdge(6, 0);

        System.out.println("Following is Breadth First Traversal "+
                "(starting from vertex 2)");

        g2.BFS(2);
        System.out.println("\nFollowing is Depth First Traversal "+
                "(starting from vertex 2)");
        g2.DFS(2);
        System.out.println("\nMother Vertex: " +g2.findMotherVertex());

        int k = 2;
        Graph2 g1 = new Graph2(9);
        g1.addEdge(0, 1);
        g1.addEdge(0, 2);
        g1.addEdge(1, 2);
        g1.addEdge(1, 5);
        g1.addEdge(2, 3);
        g1.addEdge(2, 4);
        g1.addEdge(2, 5);
        g1.addEdge(2, 6);
        g1.addEdge(3, 4);
        g1.addEdge(3, 6);
        g1.addEdge(3, 7);
        g1.addEdge(4, 6);
        g1.addEdge(4, 7);
        g1.addEdge(5, 6);
        g1.addEdge(5, 8);
        g1.addEdge(6, 7);
        g1.addEdge(6, 8);
        g1.printKcores(k);
    }
}

class Graph<T> {

    private Map<T, List<T>> map = new HashMap<>();

    public void addVertex(T s){
        map.put(s, new LinkedList<T>());
    }
    public void addEdge(T source, T destination, boolean bidirectional){
        if(!map.containsKey(source))
            addVertex(source);
        if(!map.containsKey(destination))
            addVertex(destination);
        map.get(source).add(destination);
        if(bidirectional)
            map.get(destination).add(source);

    }
    public int getVertexCount(){
        return map.keySet().size();
    }
    public int getEdgesCount(boolean bidirectional){
        int count = 0;
        for(T v: map.keySet())
            count += map.get(v).size();
        if(bidirectional)
            count = count/2;

        return count;
    }
    public boolean hasVertex(T s){
        return map.containsKey(s);
    }
    public boolean hasEdge(T s, T d){
        if(map.containsKey(s))
            return map.get(s).contains(d);
        return false;
    }
    // from source s
    public void BFS(int s){

    }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(T v: map.keySet()) {
            sb.append(v.toString() + ": ");
            for(T w: map.get(v))
                sb.append(w.toString() + " ");
            sb.append("\n");
        }
        return sb.toString();
    }

}
class Graph2{
    public int V;
    public LinkedList<Integer> adj[];

    public Graph2(int v){
        V = v;
        adj = new LinkedList[v];
        for(int i = 0; i<v;i++){
            adj[i] = new LinkedList<>();
        }
    }

    void addEdge(int v, int w){
        adj[v].add(w);
    }
   // from source s
    void BFS(int s){
        boolean visited[] = new boolean[V];
        LinkedList<Integer> queue = new LinkedList<Integer>();
        visited[s] = true;
        queue.add(s);
        while(queue.size() != 0){
            s = queue.poll();
            System.out.print(s + " ");
            Iterator<Integer> iter = adj[s].listIterator();
            while(iter.hasNext()){
                int n = iter.next();
                if(!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    public void DFSUtil(int s, boolean visited[]){
        visited[s] = true;
        System.out.print(s + " ");
        Iterator<Integer> iter = adj[s].listIterator();
        while(iter.hasNext()){
            int n = iter.next();
            if(!visited[n])
                DFSUtil(n, visited); // recursive function has stack behavior
        }
    }

    void DFS(int v){
        boolean visited[] = new boolean[V];
        DFSUtil(v, visited);
    }
    int findMotherVertex(){
        boolean [] visited = new boolean[V];
        // to store last visited vertex
        int v = -1;
        for(int i = 0; i<V; i++) {
            if (!visited[i]) {
                DFSUtil(i, visited);
                v = i;
            }
        }
        boolean [] check = new boolean[V];
        DFSUtil(v, check);
        for(boolean val : check)
            if(!val)
                return -1;
        return v;
        }

    void printKcores(int k){
        boolean[] visited = new boolean[V];
        boolean[] processed = new boolean[V];
        Arrays.fill(visited,false);
        Arrays.fill(processed,false);
        int mindegree = Integer.MAX_VALUE;
        int startVertex = 0;
        int [] Vdegree = new int[V];
        for(int i = 0; i<V;i++){
            Vdegree[i] = adj[i].size();
            if(Vdegree[i]<mindegree){
                mindegree = Vdegree[i];
                startVertex = i;
            }
        }
        DFSUtilKdegree(startVertex,visited, Vdegree,k);

        for(int i = 0; i<V; i++)
            if(!visited[i])
                DFSUtilKdegree(i,visited,Vdegree,k);
            System.out.println("K-cores : ");
        for(int v = 0; v<V;v++){
            if(Vdegree[v]>=k){
                System.out.printf("\n[%d]",v);
                for(int i : adj[v])
                    if(Vdegree[i]>=k)
                        System.out.printf(" -> %d", i);
            }
        }

    }
    boolean DFSUtilKdegree(int v, boolean[] visited, int[] Vdegree, int k){
        visited[k] = true;
        for(int i: adj[v]){
            if(Vdegree[v] < k)
                Vdegree[i]--;
            if(!visited[i])
                DFSUtilKdegree(i,visited,Vdegree,k);
        }
        return (Vdegree[v]<k);
    }

}


