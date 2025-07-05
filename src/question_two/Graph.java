import java.util.ArrayList;
import java.util.List;

public class Graph {
    private final List<List<Integer>> E;
    private final int V;

    public Graph(int V){
        this.V = V;
        this.E = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            E.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v){
        this.E.get(u).add(v);
    }

    public Graph transpose(Graph G){
        Graph T = new Graph(G.getV());
        for (int u = 0; u < G.getV(); u++) {
            for (int v : G.getE().get(u)){
                T.addEdge(v,u);
            }
        }
        return T;
    }

    public void addEdgeNotDirected(int u, int v){
        this.E.get(u).add(v);
        this.E.get(v).add(u);
    }

    public List<List<Integer>> getE() {
        return E;
    }

    public int getV() {
        return V;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < V; i++) {
            sb.append(i).append(" -> ").append(E.get(i)).append("\n");
        }
        return sb.toString();
    }
}
