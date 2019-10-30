package Graph;

import List.LinkedList;
import Stack.Stack;

public class TopologicalSort {
    public boolean[] marked;
    Stack reversePostorder;

    public TopologicalSort(Graph G) {
        reversePostorder = new Stack();
        marked = new boolean[G.V()];
        for (int v = 0; v < G.V(); v++) {
            if (!marked[v]) {
                dfs(G, v);
            }
        }
        while (!reversePostorder.isEmpty()) {
            System.out.println(reversePostorder.pop());
        }
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;
        LinkedList adj = G.adj(v);
        for (int i = 0; i < adj.count(); ++i) {
            int w = (int) adj.getData(i);
            if (!marked[w]) {
                dfs(G,w);
            }
        }
        reversePostorder.push(v);
    }

    public static void main(String[] args) {
        Graph G = new Graph(7);
        G.addDirectedEdge(0,1);
        G.addDirectedEdge(0,2);
        G.addDirectedEdge(0,5);

        G.addDirectedEdge(5,2);

        G.addDirectedEdge(1,4);

        G.addDirectedEdge(3,2);
        G.addDirectedEdge(3,5);
        G.addDirectedEdge(3,4);
        G.addDirectedEdge(3,6);

        G.addDirectedEdge(6,4);
        G.addDirectedEdge(6,0);

        TopologicalSort T = new TopologicalSort(G);


    }
}
