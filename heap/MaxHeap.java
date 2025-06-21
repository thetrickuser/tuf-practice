package heap;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MaxHeap {

    private final static Logger log = Logger.getLogger("Max Heap");

    private List<Integer> heap;

    public void initializeHeap() {
        heap = new ArrayList<>();
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public int heapSize() {
        return heap.size();
    }

    public int getMax() {
        if (!isEmpty()) return heap.getFirst();
        else {
            log.log(Level.SEVERE, "Empty heap");
            return Integer.MIN_VALUE;
        }
    }

    public void insert(int val) {
        heap.addFirst(val);
        heapifyDown(0);
    }

    public void changeKey(int index, int val) {
        heap.set(index, val);
        if (index > 0 && heap.get(parent(index)) < heap.get(index)) {
            heapifyUp(index);
        } else {
            heapifyDown(index);
        }
    }

    public void extractMax() {
        swap(0, heapSize()-1);
        heap.removeLast();
        heapifyDown(0);
    }


    private void heapifyUp(int index) {
        while (index > 0 && heap.get(parent(index)) < heap.get(index)) {
            swap(index, parent(index));
            index = parent(index);
        }
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private void heapifyDown(int index) {
        while (true) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            int largest = index;
            int n = heapSize();

            if (left < n && heap.get(left) > heap.get(largest)) largest = left;
            if (right < n && heap.get(right) > heap.get(largest)) largest = right;

            if (largest == index) break;

            swap(index, largest);
            index = largest;
        }
    }

    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

}
