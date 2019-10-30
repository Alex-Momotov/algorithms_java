package Graph;

public class PriorityContainer {
    public int vertex;
    public int priority;

    public int compareTo(PriorityContainer other) {
        return Integer.compare(priority, other.priority);
    }

    public PriorityContainer(int vertex, int priority) {
        this.vertex = vertex;
        this.priority = priority;
    }
}
