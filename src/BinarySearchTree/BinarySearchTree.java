package BinarySearchTree;

public class BinarySearchTree {
    public Node root;

    public BinarySearchTree() {
        root = null;
    }

    public Node get(int key) {
        Node tmp = root;
        while (tmp != null) {
            int cmp = key - tmp.getKey();
            if (cmp < 0) tmp = tmp.getLeft();
            else if (cmp > 0) tmp = tmp.getRight();
            else if (cmp == 0) return tmp;
        }
        return null;
    }

    public Node get(Node tmp, int key) {
        if (tmp == null) return null;
        int cmp = key - tmp.getKey();
        if (cmp < 0) return get(tmp.getLeft(), key);
        else if (cmp > 0) return get(tmp.getRight(), key);
        else return tmp;
    }

    public Node min(Node temp) {
        if (temp.getLeft() == null)
            return temp;
        else
            return min(temp.getLeft());
    }

    public Node max(Node temp) {
        if (temp.getRight() == null)
            return temp;
        else
            return max(temp.getRight());
    }

    public void put(int key, Object value) {
        root = put(root, key, value);
    }

    public Node put(Node temp, int key, Object value) {
        if (temp == null) return new Node(key, value);
        int cmp = key - temp.getKey();
        if (cmp < 0)
            temp.setLeft(put(temp.getLeft(), key, value));
        else if (cmp > 0)
            temp.setRight(put(temp.getRight(), key, value));
        else if (cmp == 0)
            temp.setValue(value);
        return temp;
    }

    public void delete(int key) {
        root = delete(root, key);
    }

    public Node delete(Node temp, int key) {
        if (temp == null) return temp;
        int cmp = key - temp.getKey();
        if (cmp < 0)
            temp.setLeft(delete(temp.getLeft(), key));
        else if (cmp > 0)
            temp.setRight(delete(temp.getRight(), key));
        else {
            if (temp.getLeft() == null)
                return temp.getRight();
            else if (temp.getRight() == null)
                return temp.getLeft();
            temp.setKey(min(temp.getRight()).getKey());
            temp.setRight(delete(temp.getRight(),temp.getKey()));
        }
        return temp;
    }

}
