package Graph;

import List.LinkedList;

public class Graph {
    private int V; // Number of vertices in this graph
    private double E;
    private LinkedList[] adj;
    private int[] distTo;
    private boolean[] marked;

//  Create an empty graph with V vertices
    public Graph(int V) {
        if (V < 0) throw new IllegalArgumentException("" +
                "Number of vertices must be nonnegative");
        this.V = V;
        this.E = 0;
        adj = new LinkedList[V];
        for (int v = 0; v < V; ++v) {
            adj[v] = new LinkedList();
        }
    }

//  Create a digraph from input stream
    public Graph(Reader in) {
        this(in.readInt());
        int E = in.readInt();
        for (int i = 0; i < E; ++i) {
            int v = in.readInt();
            int w = in.readInt();
            addEdge(v,w);
        }
    }

    public int V() {
        return V;
    }

    public int E() {
        return (int) E;
    }

//  Add an undirected edge by adding two directed edges v->w and w->v
    public void addEdge(int v, int w) {
        if (v < 0 || v >= V) throw new IndexOutOfBoundsException();
        if (w < 0 || w >= V) throw new IndexOutOfBoundsException();
        E = E + 2;
        adj[v].addStart(w);
        adj[w].addStart(v);
    }

//  Add one directed edge v -> w
    public void addDirectedEdge(int v, int w) {
        if (v < 0 || v >= V) throw new IndexOutOfBoundsException();
        if (w < 0 || w >= V) throw new IndexOutOfBoundsException();
        E = E + 1;
        adj[v].addStart(w);
    }

//  Add one directed weighted edge v -> w
    public void addDirWeightedEdge(int v, int w, int weight) {
        if (v < 0 || v >= V) throw new IndexOutOfBoundsException();
        if (w < 0 || w >= V) throw new IndexOutOfBoundsException();
        E = E + 1;
        Edge newEdge = new Edge(w, weight);
        adj[v].addStart(newEdge);
    }

//  Return list of adjacent vertices
    public LinkedList adj(int v) {
        if (v < 0 || v >= V) throw new IndexOutOfBoundsException();
        return adj[v];
    }

//  Return a string representation of the graph
    public String toString() {
        StringBuilder s = new StringBuilder();
        String NEWLINE = System.getProperty("line.separator");
        s.append(V + " vertices, " + E + " edges " + NEWLINE);
        for (int v = 0; v < V; v++) {
            s.append(v + ": ");
            s.append(adj[v].toString());
            s.append(NEWLINE);
        }
        return s.toString();
    }

    public void print() {
        for (int v = 0; v < V; ++v) {
            int count = adj[v].count();
            for (int i = 0; i < count; ++i) {
                System.out.print(v + "->" + adj[v].getData(i) + "\n");
            }
        }
    }

    public int[] getDistTo() {
        return distTo;
    }
}
