package Heap;

public class maxHeap {
    public int virtSize;
    public int[] elems;

    public maxHeap(int N) {
        elems = new int[N];
        virtSize = 0;
    }

    public int size() {
        return virtSize;
    }

    public int maxElem() {
        return elems[0];
    }

    public int parent(int idx) {
        return (idx - 1) / 2;
    }

    public int leftChild(int idx) {
        return 2*idx + 1;
    }

    public int rightChild(int idx) {
        return 2*idx + 2;
    }

    public void swap(int idx1, int idx2) {
        int t = elems[idx1];
        elems[idx1] = elems[idx2];
        elems[idx2] = t;
    }

    public void insert(int newElem) {
        elems[virtSize] = newElem;
        int temp = virtSize;
        while (newElem > elems[parent(temp)]) {
            swap(temp, parent(temp));
            temp = parent(temp);
        }
        virtSize++;
    }





}
