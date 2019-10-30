package Stack;

public class test {
    public static void main(String[] args) {
        Stack D = new Stack(200);
        D.push(5);
        D.push(3);
        D.push(6);
        System.out.println(D.pop());
        D.print();
    }
}
