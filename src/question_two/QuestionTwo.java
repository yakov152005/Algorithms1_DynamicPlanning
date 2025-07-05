package question_two;

import java.util.List;

public class QuestionTwo {
    public static void main(String[] args) {
        Graph G = new Graph(6);

        G.addEdge(0, 1);
        G.addEdge(0, 2);
        G.addEdge(1, 3);
        G.addEdge(2, 3);
        G.addEdge(3, 4);
        G.addEdge(4, 5);

        System.out.println("question_two.Graph: ");
        System.out.println(G);

        List<Integer> topSort = LongestPathInDAG.topologicalSort(G);
        System.out.println("Topo Sort: " + topSort);

        LongestPathInDAG.Result result = LongestPathInDAG.setLongestDistance(G, topSort);
        List<Integer> path = LongestPathInDAG.reconstructPath(result);

        System.out.println("The longest path: " + result.delta[result.endVertex]);
        System.out.println("Path: " + path);
    }
}