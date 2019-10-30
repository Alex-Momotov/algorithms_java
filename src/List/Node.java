package List;

public class Node {
    private Node next = null;
    private Object data;

    public Node() {

    }

    public Node(Object newData) {
        data = newData;
    }

    public void setData(Object newData) {
        data = newData;
    }

    public Object getData() {
        return data;
    }

    public void setNext(Node newNode) {
        next = newNode;
    }

    public Node getNext() {
        return next;
    }
}
