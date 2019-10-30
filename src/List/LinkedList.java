package List;

public class LinkedList {
    private Node head = null;

    public LinkedList() {
        head = null;
    }

    public LinkedList(Node newNode) {
        head = newNode;
    }

    public LinkedList addStart(Object newData) {
        Node newNode = new Node(newData);
        newNode.setNext(head);
        head = newNode;
        return this;
    }

    public LinkedList addLast(Object newData) {
        Node newNode = new Node(newData);
        newNode.setNext(null);
        Node tmpNode = head;
        if (head == null) {
            head = newNode;
        } else {
            while (tmpNode.getNext() != null) {
                tmpNode = tmpNode.getNext();
            }
            tmpNode.setNext(newNode);
        }
        return this;
    }

    public LinkedList concate(LinkedList s) {
        Node tmpNode = head;
        if (head == null && s.head != null) {
            head = s.head;
        } else if (tmpNode != null) {
            while (tmpNode.getNext() != null) {
                tmpNode = tmpNode.getNext();
            }
            tmpNode.setNext(s.head);
        }
        return this;
    }

    public LinkedList insertAt(int pos, Object newData) {
        if (pos == 0) {
            addStart(newData);
        } else {
            Node newNode = new Node(newData);
            Node tmpNode = head;
            int i = 1;
            while (i < pos) {
                tmpNode = tmpNode.getNext();
                i++;
            }
            newNode.setNext(tmpNode.getNext());
            tmpNode.setNext(newNode);
        }
        return this;
    }

//  Removes a new node from position i.
    public LinkedList remove(int pos) {
        if(pos == 0) {
            head = head.getNext();
        } else {
            Node prevNode = head;
            int i = 1;
            while (i < pos) {
                prevNode = prevNode.getNext();
                ++i;
            }
            prevNode.setNext(prevNode.getNext().getNext());
        }
        return this;
    }

    public int count() {
        Node temp = head;
        int count = 0;
        while (temp != null) {
            ++count;
            temp = temp.getNext();
        }
        return count;
    }

    public Object getData(int idx) {
        Node tmp = head;
        for (int i = 0; i < idx; ++i) {
            if (tmp == null) System.out.println("Null reached during iteration.");
            tmp = tmp.getNext();
        }
        return tmp.getData();
    }

    public LinkedList splitAfter(int pos) {
        Node tmpNode = head;
        int i = 0;
        while (i < pos) {
            tmpNode = tmpNode.getNext();
            i++;
        }
        LinkedList newList = new LinkedList(tmpNode.getNext());
        tmpNode.setNext(null);
        return newList;
    }

//  Prints out the list, starting with head.
    public void print() {
        Node tmpNode = head;
        while (tmpNode != null) {
            System.out.print(tmpNode.getData() + " ");
            tmpNode = tmpNode.getNext();
        }
        System.out.println();
    }

    public String toString() {
        String s = "";
        Node tmpNode = head;
        while (tmpNode != null) {
            s = s + " " + tmpNode.getData();
            tmpNode = tmpNode.getNext();
        }
        return s;
    }
}
