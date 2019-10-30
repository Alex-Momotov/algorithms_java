package SearchAndSort;

public class test {

    public static void quickSort(int[] A, int low, int high) {
        if(low < high) {
            int pivot = partition(A,low,high);
            quickSort(A,low,pivot);
            quickSort(A,pivot+1,high);
        }
    }

    public static int partition(int[] A, int low, int high) {
        int pivot = A[low];
        int leftwall = low;
        for (int i = low+1; i < high; ++i) {
            if(A[i] < pivot) {
            int temp = A[i];
                A[i] = A[leftwall];
                A[leftwall] = temp;
                leftwall++;
            }
        }
        int t = pivot;
        pivot = A[leftwall];
        A[leftwall] = t;
        return leftwall;
    }

    public static void main(String[] args) {
        int[] A = {3,6,2,7,3,4,8,6,5,7,1,2};
        for (int i = 0; i < A.length; ++i) {
            System.out.print(A[i] + " ");
        }
        System.out.println();
        quickSort(A,0,A.length-1);
        for (int i = 0; i < A.length; ++i) {
            System.out.print(A[i] + " ");
        }
    }
}
