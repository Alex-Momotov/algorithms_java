package Graph;

import List.LinkedList;
import Queue.Queue;

public class BreadthFirstSearch {
    private boolean[] marked; //marked[v] = is there an s-v path?
    private int[] edgeTo;  //edgeTo[v] = last edge on s-v path
    private int[] distTo;  //distance to
    private final int s;  //source vertex

    public BreadthFirstSearch(Graph G, int s) {
        this.s = s;
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        distTo = new int[G.V()];
        bfs(G, s);
    }

//  BFS from single source s
    public void bfs(Graph G, int s) {
        for (int v = 0; v < G.V(); ++v) {
            distTo[v] = Integer.MAX_VALUE;
            marked[v] = false;
        }
        Queue q = new Queue();
        distTo[s] = 0;
        marked[s] = true;
        q.enqueue(s);
        while (!q.isEmpty()) {
            int v = (int) q.dequeue();
            LinkedList adj = G.adj(v);
            int count = adj.count();
            for (int i = 0; i < count; ++i) {
                int w = (int) adj.getData(i);
                if (!marked[w]) {
                    distTo[w] = distTo[v] + 1;
                    marked[w] = true;
                    edgeTo[w] = v;
                    q.enqueue(w);
                }
            }
        }
    }

//  Is there a path between s and v?
    public boolean hasPathTo(int v) {
        return marked[v];
    }

//  Return path between s to v; null if no such path.
    public LinkedList pathTo(int v) {
        if (!hasPathTo(v)) return null;
        LinkedList path = new LinkedList();
        for (int x = v; x != s; x = edgeTo[x]) {
            path.addStart(x);
        }
        path.addStart(s);
        return path;
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

        BreadthFirstSearch b = new BreadthFirstSearch(G,0);
        System.out.println(b.pathTo(4));
        System.out.println();
        for (int i = 0; i < G.V(); ++i) {
            System.out.println(b.marked[i]);
        }
    }


}
