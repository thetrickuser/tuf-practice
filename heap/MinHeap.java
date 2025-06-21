package heap;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MinHeap {

    private final static Logger log = Logger.getLogger("Min Heap");

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

    public int getMin() {
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

    public void extractMin() {
        swap(0, heapSize()-1);
        heap.removeLast();
        heapifyDown(0);
    }

    private void heapifyUp(int index) {
        while (index > 0 && heap.get(parent(index)) > heap.get(index)) {
            swap(index, parent(index));
            index = parent(index);
        }
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private void heapifyDown(int index) {
        int n = heapSize();
        while (true) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            int smallest = index;

            if (left < n && heap.get(left) < heap.get(smallest)) smallest = left;
            if (right < n && heap.get(right) < heap.get(smallest)) smallest = right;

            if (smallest == index) break;

            swap(index, smallest);
            index = smallest;
        }
    }

    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

}
