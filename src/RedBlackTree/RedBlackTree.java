package RedBlackTree;

import static RedBlackTree.Node.isRed;

public class RedBlackTree {
    private Node root;
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    public Object get(int key) {
        Node x = root;
        while (x != null) {
            int cmp = key - x.key;
            if (cmp < 0) x = x.left;
            else if (cmp > 0) x = x.right;
            else if (cmp == 0) return x.value;
        }
        return null;
    }

    private Node put(Node h, int key, Object value) {
        if (h == null) return new Node(key, value, RED);
        int cmp = key - h.key;
        if (cmp < 0) h.left = put(h.left, key, value);
        else if (cmp > 0) h.right = put(h.right, key, value);
        else if (cmp == 0) h.value = value;
        if (isRed(h.right) && !isRed(h.left)) h = rotateLeft(h);
        if (isRed(h.left) && !isRed(h.left.left)) h = rotateRight(h);
        if (isRed(h.left) && !isRed(h.right)) flipColors(h);
        return h;
    }

    public Node rotateLeft(Node h) {
        assert isRed(h.right);
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    public Node rotateRight(Node h) {
        assert isRed(h.left);
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    public void flipColors(Node h) {
        assert !isRed(h);
        assert isRed(h.left);
        assert isRed(h.right);
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }



}
