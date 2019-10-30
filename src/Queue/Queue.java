package Queue;

public class Queue {
    private int N;         // number of elements on queue
    private Node first;    // beginning of queue
    private Node last;     // end of queue

    // helper linked list class
    private class Node {
        private Object item;
        private Node next;
    }

    /**
     * Create an empty queue.
     */
    public Queue() {
        first = null;
        last  = null;
        N = 0;
    }

    /**
     * Is the queue empty?
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * Return the number of items in the queue.
     */
    public int size() {
        return N;
    }

    /**
     * Return the item least recently added to the queue.
     * @throws java.util.NoSuchElementException if queue is empty.
     */
    public Object front() {
        if (isEmpty()) {
            return null;
            //System.out.println("Queue underflow");
        }
        return first.item;
    }

    /**
     * Add the item to the queue.
     */
    public void enqueue(Object item) {
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else           oldlast.next = last;
        N++;
    }

    /**
     * Remove and return the item on the queue least recently added.
     * @throws java.util.NoSuchElementException if queue is empty.
     */
    public Object dequeue() {
        if (isEmpty()) {
            return null;
            //System.out.println("Queue underflow");
        }
        Object item = first.item;
        first = first.next;
        N--;
        if (isEmpty()) last = null;   // to avoid loitering
        return item;
    }

    /**
     * Return string representation.
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        Node tmp = first;
        while (tmp != null) {
            s.append((String)tmp.item + " ");
            tmp = tmp.next;
        }
        return s.toString();
    }

    /**
     * A test client.
     */
    public static void main(String[] args) {

        Queue q = new Queue();
        q.enqueue ("a");
        System.out.println(q);
        q.enqueue ("b");
        System.out.println(q);
        q.dequeue ();
        System.out.println(q);
        q.enqueue ("c");
        System.out.println(q);
        q.enqueue ("d");
        System.out.println(q);
        q.enqueue ("e");
        System.out.println(q);
        q.dequeue ();
        System.out.println(q);
        q.dequeue ();
        System.out.println(q);
        q.dequeue ();
        System.out.println(q);
        q.dequeue ();
        System.out.println(q);
    }
}
