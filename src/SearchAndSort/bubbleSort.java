package SearchAndSort;

public class bubbleSort {

    public static int[] bubbleSort(int[] A) {
        for(int i = 0; i < A.length-1; ++i) {
            for(int j = 0; j < A.length-i-1; ++j) {
                if(A[j] > A[j+1]) {
                    int temp = A[j];
                    A[j] = A[j+1];
                    A[j+1] = temp;
                }
            }
        }
    return A;
    }

    public static void main(String[] args) {
        int[] A = {3,6,2,7,3,4,8,6,5,7,1,2};
        for (int i = 0; i < A.length; ++i) {
            System.out.print(A[i] + " ");
        }
        System.out.println();
        int[] A2 = bubbleSort(A);
        for (int i = 0; i < A2.length; ++i) {
            System.out.print(A[i] + " ");
        }
    }
}
