package BinarySearchTree;

public class Node {
    private int key;
    private Object value;
    private Node left, right;

    public Node(int key, Object value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int newKey) {
        key = newKey;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object newValue) {
        value = newValue;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }


}
