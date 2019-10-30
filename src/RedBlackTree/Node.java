package RedBlackTree;

public class Node {
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    int key;
    Object value;
    Node left, right;
    boolean color;

    public Node(int key, Object value, boolean color) {
        this.key = key;
        this.value = value;
        this.color = color;
    }

    public static boolean isRed(Node x) {
        if (x == null) return false;
        return x.color == RED;
    }
}
