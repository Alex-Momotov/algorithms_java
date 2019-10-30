package Graph;

public class Edge {
    public final int target; //Target vertex
    public final int weight; //Weight of this edge

    public Edge(int target, int weight) {
        this.target = target;
        this.weight = weight;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Edge) {
            Edge edge = (Edge) obj;
            if (edge.target == this.target) return true;
        }
        return false;
    }

    public int hashCode() {
        return 7 - (target % 7);
    }

    public static void main(String [] args) {
        Edge E1 = new Edge(3,3);
        Edge E2 = new Edge(3,3);
        System.out.println(E1.equals(E2));
        System.out.println(E1.hashCode());
        System.out.println(E2.hashCode());

    }
}
