package Graph;

import List.LinkedList;

public class DepthFirstSearch {
    public boolean[] marked;   //marked[v] = vertices reachable by source
    public int[] edgeTo;       //edgeTo[v] = last edge on s-v path
    public final int s;        //source vertex

    public DepthFirstSearch(Graph G, int s) {
        this.s = s;
        edgeTo = new int[G.V()];
        marked = new boolean[G.V()];
        dfs(G,s);
    }

//  depth first search from v
    private void dfs(Graph G, int v) {
        marked[v] = true;
        LinkedList adj = G.adj(v);
        for (int i = 0; i < adj.count(); ++i) {
            int w = (int) adj.getData(i);
            if (!marked[w]) {
                edgeTo[w] = v; //extra bit for finding path, unnecessary for basic DFS
                dfs(G,w);
            }
        }
    }

//  Is there a path between s and v?
    public boolean hasPathTo(int v) {
        return marked[v];
    }

//  Return a path between s and v; null if no such path
    public LinkedList pathTo(int v) {
        if (!hasPathTo(v)) return null;
        LinkedList path = new LinkedList();
        for (int x = v; x != s; x = edgeTo[x]) {
            path.addStart(x);
        }
        path.addStart(s);
        return path;
    }


}
