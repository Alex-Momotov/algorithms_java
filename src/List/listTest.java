package List;

public class listTest {

public static void main(String[] args) {
    LinkedList list = new LinkedList();
    list.addStart(1);
    list.addStart(2);
    list.addStart(3);
    list.insertAt(3,11);
    list.insertAt(2,22);
    list.insertAt(1,33);
    LinkedList list2 = list.splitAfter(1);
    list.print();
    System.out.println();
    list2.print();
}

}
