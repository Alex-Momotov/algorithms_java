package Graph;

public class GraphTest {
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


        DepthFirstSearch DFS = new DepthFirstSearch(G,12);
        for (int i = 0; i < DFS.marked.length; ++i) {
            System.out.println(DFS.marked[i]);
        }
    }
}
