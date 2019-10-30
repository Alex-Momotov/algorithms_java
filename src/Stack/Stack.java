package Stack;

public class Stack {
    public static final int CAPACITY = 1000;
    private int capacity;
    private Object[] S;
    private int top = -1;

    public Stack() {
        this(CAPACITY);
    }

    public Stack(int cap) {
        capacity = cap;
        S = new Object[capacity];
    }

    public int size() {
        return top + 1;
    }

    public boolean isEmpty() {
        return top < 0;
    }

    public void push(Object obj) {
        if (size() == capacity) {
            System.out.println("Stack overflow.");
        }
        S[++top] =obj;
    }

    public Object top() {
        if (isEmpty())
            System.out.println("Stack is empty.");
        return S[top];
    }

    public Object pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
        }
        Object elem = S[top];
        S[top--] = null;
        return elem;
    }

    public void print() {
        for (int i = 0; i <= top; ++i) {
            System.out.println(S[i]);
        }
    }

}
