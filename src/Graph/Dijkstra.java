package Graph;
import List.LinkedList;
import Queue.Queue;

import java.util.PriorityQueue;

public class Dijkstra {
    private boolean[] marked; //marked[v] = is there an s-v path?
    private int[] edgeTo;  //vertex taken to reach this vertex for min distance
    private int[] minDistTo;  //minimum distance to that vertex
    private final int s;  //source vertex

    public Dijkstra(Graph G, int s) {
        this.s = s;
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        minDistTo = new int[G.V()];
        for (int v = 0; v < G.V(); ++v) {
            minDistTo[v] = Integer.MAX_VALUE;
            marked[v] = false;
            edgeTo[v] = -1;
        }
        DijkstraSearch(G, s);
    }

    //  BFS from single source s
    public void DijkstraSearch(Graph G, int s) {
        minDistTo[s] = 0;
        PriorityQueue<PriorityContainer> q = new PriorityQueue<PriorityContainer>();
        PriorityContainer S = new PriorityContainer(s,0);
        q.add(S);
        while (!q.isEmpty()) {
            PriorityContainer u = q.poll();
            marked[u.vertex] = true;
            LinkedList adj = G.adj(u.vertex);
            int count = adj.count();
            for (int i = 0; i < count; ++i) {
                Edge w = (Edge) adj.getData(i);
                int newDist = minDistTo[w.target] + w.weight;
                if (minDistTo[w.target] > newDist) {
                    q.remove(w.target);
                    minDistTo[w.target] = newDist;
                    edgeTo[w.target] = u.vertex;
                    PriorityContainer temp = new PriorityContainer(w.target,newDist);
                    q.add(temp);
                }
           }
        }
    }

    public static void main(String[] args) {

    }
}
