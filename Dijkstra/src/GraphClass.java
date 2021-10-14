import java.util.*;

public class GraphClass implements Graph {
    private List<Node> vertices = new ArrayList<>();
    private GraphType graphType = GraphType.DIRECTED;
    private int numVertices = 0;
    public GraphClass(int numVertices, GraphType gt){
        this.numVertices = numVertices;
        for(int i = 0; i < numVertices; i++){
            vertices.add(new Node(i));
        }
        this.graphType = graphType;
    }
    @Override
    public void addEdge(int v1, int v2) {
        if(v1>=numVertices || v1<0 || v2>=0 || v2 < 0)
            throw new IllegalArgumentException("Vertex num is not valid!");
        this.vertices.get(v1).addEdge(v2);
        if(this.graphType == GraphType.DIRECTED)
            this.vertices.get(v2).addEdge(v1);
    }

    @Override
    public List<Integer> getAdjacentVertices(int v) {
        if(!this.vertices.contains(v))
        {
            throw new IllegalArgumentException("Vertex num is not valid!");
        }

        return this.vertices.get(v).getAdjacentVertices();
    }
    public void DFS(Graph g, int[] visited, int currentVertex){
        if(visited[currentVertex] == 1)
            return;
        visited[currentVertex] = 1; //mark as visited
        List<Integer> list = g.getAdjacentVertices(currentVertex); // get adjacent vertices list
        for(int vertex : list){
            DFS(g,visited,vertex); // call the method for the first adjacent vertex and then for the second so on, recursively
        }
        System.out.print(currentVertex + "->");
    }
    public void BFS(GraphClass g, int[] visited, int currentVertex) {
        Queue<Integer> q = new LinkedList<>();
        q.add(currentVertex);
        while(!q.isEmpty()){
            int vertex = q.remove();
            if(visited[vertex] == 1)
                continue;
            System.out.print(vertex + "->");
            visited[vertex] = 1;
            List<Integer> list = g.getAdjacentVertices(vertex);
            for(int i: list)
                if(visited[i] !=1)
                    q.add(i);
        }

    }
    public void BFSUnconnected(GraphClass g, int[] visited, int currentVertex){
        for(int i = 0; i<this.numVertices; i++){
            this.BFS(g,visited,i);
        }
    }
    public Map<Integer, DistanceInfo> buildDistanceTable(GraphClass g, int source){
        Map<Integer,DistanceInfo> distanceTable = new HashMap<>();
        PriorityQueue<VertexInfo> pq = new PriorityQueue<>(new Comparator<VertexInfo>() {
            @Override
            public int compare(VertexInfo o1, VertexInfo o2) {
                return ((Integer) o1.getDistance()).compareTo(o2.getDistance());
            }
        });
        Map<Integer, VertexInfo> vertexMap = new HashMap<>();
        for(int i  = 0; i < g.getNumVertices(); i++){
            distanceTable.put(i, new DistanceInfo());
        }
        distanceTable.get(source).setDistance(0);
        distanceTable.get(source).setLastVertex(source);
        VertexInfo sourceInfo = new VertexInfo(source,0);
        pq.add(sourceInfo);
        vertexMap.put(source, sourceInfo);
        while(!pq.isEmpty()){
            VertexInfo vertexInfo = pq.poll();
            int current = vertexInfo.getVertexId();
            for(Integer neighbor: g.getAdjacentVertices(current)){
                int distance = distanceTable.get(current).getDistance() + g.getWeightedEdge(current, neighbor);
                if(distanceTable.get(neighbor).getDistance()>distance){
                    distanceTable.get(neighbor).setDistance(distance);
                    distanceTable.get(neighbor).setLastVertex(current);
                    VertexInfo neighborInfo = vertexMap.get(neighbor);
                    if(neighborInfo != null)
                        pq.remove(neighborInfo);
                    neighborInfo = new VertexInfo(neighbor,distance);
                    pq.add(neighborInfo);
                    vertexMap.put(neighbor,neighborInfo);
                }
            }
        }
        return distanceTable;
    }

    private int getWeightedEdge(int current, Integer neighbor) {
        return 0;
    }

    public void shortestPath(GraphClass g, int source, int destination){
        Map<Integer, DistanceInfo> distanceTable = buildDistanceTable(g,source);
        Stack<Integer> stack = new Stack<>();
        stack.push(destination); //backtrack from destination node
        int previousVertex = distanceTable.get(destination).getLastVertex();
        while(previousVertex != -1 && previousVertex !=source){
            stack.push(previousVertex); // push to stack until it reachs to source of -1 distance
            previousVertex = distanceTable.get(previousVertex).getLastVertex(); // go to previous
        }
        if(previousVertex == -1)
            System.out.println("There is no path from node " + source + " to node " + destination);
        else
        {
            System.out.print("Smallest path is " + source + " to node " + destination);
            while(!stack.isEmpty())
                System.out.print( "->" + stack.pop() ); // pop from stack
            System.out.println("Shortest path for unweigted is DONE!");
        }
    }

    public List<Node> getVertices() {
        return vertices;
    }

    public GraphType getGraphType() {
        return graphType;
    }

    public int getNumVertices() {
        return numVertices;
    }
}
class Node{
    int vertexId;
    Set<Integer> adjacencySet = new HashSet<>();
    public Node(int vertexId){
        this.vertexId = vertexId;
    }
    public void addEdge(int vertexId){
        this.adjacencySet.add(vertexId);
    }
    public List<Integer> getAdjacentVertices(){
        List<Integer> sortedList = new ArrayList<>(this.adjacencySet);
        Collections.sort(sortedList);
        return sortedList;
    }
}
class DistanceInfo {
    private int distance;
    private int lastVertex;
    public DistanceInfo(){
        this.distance = Integer.MAX_VALUE;
        this.lastVertex = -1;
    }
    public int getDistance(){
        return this.distance;
    }

    public int getLastVertex() {
        return lastVertex;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public void setLastVertex(int lastVertex) {
        this.lastVertex = lastVertex;
    }
}

class VertexInfo {
    private int vertexId;
    private int distance;

    public VertexInfo(int vertexId, int distance) {
        this.vertexId = vertexId;
        this.distance = distance;
    }

    public int getVertexId() {
        return vertexId;
    }

    public void setVertexId(int vertexId) {
        this.vertexId = vertexId;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}
