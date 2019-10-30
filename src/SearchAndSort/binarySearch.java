package SearchAndSort;

public class binarySearch {

    public static boolean binarySearch(int[] A, int s, int f, int M) {
        boolean found = false;
        if (s<=f) {
            int m = (s + f) / 2;
            if (M == A[m]) {
                found = true;
            } else {
                if (M < A[m]) {
                    found = binarySearch(A,s,m-1,M);
                } else {
                    found = binarySearch(A,m+1,f,M);
                }
            }
        }
        return found;
    }


    public static void main(String[] args) {
        int[] A = {1,2,4,4,5,7,9,10,12,12,13,14,15,16};
        for (int i = 0; i < A.length; ++i) {
            System.out.print(A[i] + " ");
        }
        System.out.println(binarySearch(A,0,A.length,6));
    }
}
