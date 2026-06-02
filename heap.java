import java.util.*;

class MaxHeap {

    private int[] heap;
    private int size;
    private int capacity;

    public MaxHeap(int capacity) {
        this.capacity = capacity;
        heap = new int[capacity];
        size = 0;
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int left(int i) {
        return 2 * i + 1;
    }

    private int right(int i) {
        return 2 * i + 2;
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public void heapify(int i) {
        int largest = i;

        int l = left(i);
        int r = right(i);

        if (l < size && heap[l] > heap[largest]) {
            largest = l;
        }

        if (r < size && heap[r] > heap[largest]) {
            largest = r;
        }

        if (largest != i) {
            swap(i, largest);
            heapify(largest);
        }
    }

    public void buildHeap(int[] arr) {
        size = arr.length;

        for (int i = 0; i < size; i++) {
            heap[i] = arr[i];
        }

        for (int i = size / 2 - 1; i >= 0; i--) {
            heapify(i);
        }
    }

    public void insert(int val) {
        if (size == capacity) {
            return;
        }

        int i = size;
        heap[size++] = val;

        while (i > 0 && heap[parent(i)] < heap[i]) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    public int deleteRoot() {
        if (size == 0) {
            return -1;
        }

        int root = heap[0];

        heap[0] = heap[size - 1];
        size--;

        heapify(0);

        return root;
    }

    public void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {

        MaxHeap heap = new MaxHeap(20);

        int[] arr = {10, 20, 15, 30, 40};

        heap.buildHeap(arr);
        heap.printHeap();

        heap.insert(50);
        heap.printHeap();

        System.out.println(heap.deleteRoot());
        heap.printHeap();
    }
}