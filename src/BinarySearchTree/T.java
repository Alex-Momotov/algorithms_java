package BinarySearchTree;

public class T {
    public static void main(String[] args) {
        BinarySearchTree B = new BinarySearchTree();
        B.put(5,5);
        for (int i = 1; i <= 10; ++i) {
            B.put(i,i);
        }
//        B.print();
//        System.out.println(B.root.getRight().getValue());
    }
}
