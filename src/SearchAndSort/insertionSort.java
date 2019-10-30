package SearchAndSort;

public class insertionSort {

    public static int[] insertionSort(int[] A) {
        for(int i = 1; i < A.length; ++i) {
            int key = A[i];
            int j = i - 1;
            while(j > -1 && A[j] > key) {
                A[j + 1] = A[j];
                j = j -1;
            }
            A[j + 1] = key;
        }
        return A;
    }

    public static void main(String[] args) {
        int[] A = {3,6,2,7,3,4,8,6,5,7,1,2};
        for (int i = 0; i < A.length; ++i) {
            System.out.print(A[i] + " ");
        }
        System.out.println();
        int[] A2 = insertionSort(A);
        for (int i = 0; i < A2.length; ++i) {
            System.out.print(A[i] + " ");
        }
    }
}
