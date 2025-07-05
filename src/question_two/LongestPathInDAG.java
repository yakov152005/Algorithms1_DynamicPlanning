
import java.util.*;

public class LongestPathInDAG {

    public static class Result {
        int[] delta;
        int[] pi;
        int endVertex;

        public Result(int[] delta, int[] pi, int endVertex) {
            this.delta = delta;
            this.pi = pi;
            this.endVertex = endVertex;
        }
    }


    public static List<Integer> topologicalSort(Graph G) {
        int n = G.getV();
        boolean[] visited = new boolean[n];
        List<Integer> order = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, G, visited, order);
            }
        }

        Collections.reverse(order);
        return order;
    }

    private static void dfs(int u, Graph G, boolean[] visited, List<Integer> order) {
        visited[u] = true;
        for (int v : G.getE().get(u)) {
            if (!visited[v]) {
                dfs(v, G, visited, order);
            }
        }
        order.add(u);
    }


    public static Result setLongestDistance(Graph G, List<Integer> topSort) {
        int n = G.getV();
        int[] delta = new int[n];
        int[] pi = new int[n];
        Arrays.fill(pi, -1);

        for (int u : topSort) {
            for (int v : G.getE().get(u)) {
                if (delta[v] < delta[u] + 1) {
                    delta[v] = delta[u] + 1;
                    pi[v] = u;
                }
            }
        }

        int maxIdx = 0;
        for (int i = 1; i < n; i++) {
            if (delta[i] > delta[maxIdx]) {
                maxIdx = i;
            }
        }

        return new Result(delta, pi, maxIdx);
    }


    public static List<Integer> reconstructPath(Result res) {
        List<Integer> path = new ArrayList<>();
        int current = res.endVertex;

        while (current != -1) {
            path.add(current);
            current = res.pi[current];
        }

        Collections.reverse(path);
        return path;
    }
}
