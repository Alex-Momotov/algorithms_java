package Hashing;

//This class demonstrates Gary's hashing example
public class Triplet {
    private int a, b, c;

    public int hashCode() {
        Integer A = a;
        Integer B = b;
        Integer C = c;
        int hash = A.hashCode();
        hash = hash * 31 + B.hashCode();
        hash = hash * 31 + C.hashCode();
        return hash;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Triplet)) {
            return false;
        } else {
            Triplet that = (Triplet) obj;
            return this.a == that.a &&
                    this.b == that.b &&
                    this.c == that.c;
        }
    }
}
