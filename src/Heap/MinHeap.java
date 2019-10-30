package Heap;

public class MinHeap {
    public int[] elems;
    public int virtSize;

    public MinHeap(int N) {
        elems = new int[N];
        virtSize = 0;
    }

    public int size() {
        return virtSize;
    }

    public int minElem() {
        return elems[0];
    }

    public int parent(int idx) {
        return (idx-1)/2;
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

    public void insert(int num) {
        elems[virtSize] = num;
        int numIdx = virtSize;
        while (num < elems[parent(numIdx)]) {
            swap(numIdx, parent(numIdx));
            numIdx = parent(numIdx);
        }
        ++virtSize;
    }

    public boolean leftExists(int idx) {
        return leftChild(idx) < virtSize;
    }

    public boolean rightExists(int idx) {
        return rightChild(idx) < virtSize;
    }

    public int top() {
        int result = elems[0];
        int lastLeaf = elems[virtSize-1];
        elems[0] = lastLeaf;
        --virtSize;
        int leafIdx = 0;
        boolean bothExist = rightExists(leafIdx) && leftExists(leafIdx);
        boolean biggerThanLeft = leftExists(leafIdx) && lastLeaf > elems[leftChild(leafIdx)];
        boolean biggerThanRight = rightExists(leafIdx) && lastLeaf > elems[rightChild(leafIdx)];
        boolean biggerThanEither = biggerThanLeft || biggerThanRight;
        while (biggerThanEither) {
            if (bothExist && (elems[leftChild(leafIdx)] <= elems[rightChild(leafIdx)])) {
                swap(leafIdx, leftChild(leafIdx));
                leafIdx = leftChild(leafIdx);
            } else if (bothExist && (elems[leftChild(leafIdx)] > elems[rightChild(leafIdx)])) {
                swap(leafIdx, rightChild(leafIdx));
                leafIdx = rightChild(leafIdx);
            } else if (rightExists(leafIdx) && lastLeaf > elems[rightChild(leafIdx)]) {
                swap(leafIdx, rightChild(leafIdx));
                leafIdx = rightChild(leafIdx);
            } else if (leftExists(leafIdx) && lastLeaf > elems[leftChild(leafIdx)]) {
                swap(leafIdx, leftChild(leafIdx));
                leafIdx = leftChild(leafIdx);
            }
            bothExist = rightExists(leafIdx) && leftExists(leafIdx);
            biggerThanLeft = leftExists(leafIdx) && lastLeaf > elems[leftChild(leafIdx)];
            biggerThanRight = rightExists(leafIdx) && lastLeaf > elems[rightChild(leafIdx)];
            biggerThanEither = biggerThanLeft || biggerThanRight;
        }
        return result;
    }

    public void heapify(int i, int n) {
        int l = leftChild(i);
        int r = rightChild(i);
        int smallest = i;
        if (l <= n && elems[l] < elems[smallest]) smallest = l;
        if (r <= n && elems[r] < elems[smallest]) smallest = r;
        if (smallest != i) {
            swap(i,smallest);
            heapify(smallest, n);
        }
    }
}
