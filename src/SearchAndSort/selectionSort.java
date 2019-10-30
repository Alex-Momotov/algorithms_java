package SearchAndSort;

public class selectionSort {

    public static int[] selectionSort(int[] A) {
        for(int i = 0; i < A.length-1; i++) {
            int minptr = i;
            for(int j = i+1; j < A.length; j++) {
                if(A[j] < A[minptr]) {
                    minptr = j;
                }
            }
            int temp = A[i];
            A[i] = A[minptr];
            A[minptr] = temp;
        }
        return A;
    }

    public static void main(String[] args) {
        int[] A = {3,6,2,7,3,4,8,6,5,7,1,2};
        for (int i = 0; i < A.length; ++i) {
            System.out.print(A[i] + " ");
        }
            System.out.println();
        int[] A2 = selectionSort(A);
        for (int i = 0; i < A2.length; ++i) {
            System.out.print(A[i] + " ");
        }
    }
}
