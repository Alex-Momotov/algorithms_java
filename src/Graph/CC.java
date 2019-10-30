package Graph;

import List.LinkedList;

public class CC {
    private boolean[] marked;
    private int[] id;
    private int count;

    public CC(Graph G) {
        marked = new boolean[G.V()];
        id = new int[G.V()];
        for (int v = 0; v < G.V(); v++) {
            if (!marked[v]) {
                dfs(G, v);
                count++;
            }
        }
    }

//  Number of connected components.
    public int count() {
        return count;
    }

//  To which connected component does vertex v belong
    public int id(int v) {
        return id[v];
    }


    private void dfs(Graph G, int v) {
        marked[v] = true;
        id[v] = count;
        LinkedList adj = G.adj(v);
        for (int i = 0; i < adj.count(); ++i) {
            int w = (int) adj.getData(i);
            if (!marked[w]) {
                dfs(G,w);
            }
        }
    }

    public static void main(String[] args) {
        Graph G = new Graph(13);
        G.addEdge(0,1);
        G.addEdge(0,2);
        G.addEdge(0,6);
        G.addEdge(0,5);
        G.addEdge(4,6);
        G.addEdge(5,4);
        G.addEdge(5,3);
        G.addEdge(4,3);

        G.addEdge(7,8);

        G.addEdge(9,10);
        G.addEdge(9,11);
        G.addEdge(9,12);
        G.addEdge(11,12);

        CC cc = new CC(G);
        System.out.println("Nbr Connected Components: " + cc.count());
        for (int i = 0; i < G.V(); ++i) {
            System.out.println(i + ":\t" +cc.id(i));
        }
    }
}
