package graph;

import java.util.LinkedList;

public class GraphBook {
    public Node[] nodes;

    boolean search(GraphBook g, Node start, Node end){
        if(start == end)
            return true;
        LinkedList<Node> q = new LinkedList<Node>();
        for ( Node u: g.getNodes())
            u.state = State.unvisited;
        start.state = State.visiting;
        q.add(start);
        Node u;
        while (!q.isEmpty()){
            u = q.removeFirst();
            if(u!=null){
                for( Node v: u.getAdjacent()){
                    if(v.state == State.unvisited){
                        if(v == end)
                            return true;
                        else
                        {
                            v.state = State.visited;
                            q.add(v);
                        }
                    }
                }
            }
            u.state = State.visited;
        }
        return false;
    }
    public Node[] getNodes(){
        return this.nodes;
    }
}
class Node {
    public String name;
    public Node[] children;
    public State state;
    public Node[] getAdjacent() {
        return this.children;
    }
}
enum State {
    visited,
    unvisited,
    visiting
}
