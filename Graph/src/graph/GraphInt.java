package graph;

import java.util.List;

public interface GraphInt {
    enum GraphType{
        DIRECTED,
        UNDIRECTED
    }
    void addEdgee(int v1, int v2);
    List<Integer> getAdjecentVertices(int v);
}
