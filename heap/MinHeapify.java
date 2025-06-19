package heap;

class MinHeapify {

    public static void main(String[] args) {
        int[] nums = {2,4,3,6,5,7,8,7};
        MinHeapify h = new MinHeapify();
        h.minHeapify(nums, 0,7);
    }

    public void minHeapify(int[] heap, int index, int val) {
        heap[index] = val;
        int n = heap.length;
        if (index > 0 && heap[parent(index)] > heap[index]) {
            heapifyUp(heap, index);
        } else {
            heapifyDown(heap, index, n);
        }
    }

    private void heapifyUp(int[] heap, int index) {
        while (index > 0 && heap[parent(index)] > heap[index]) {
            swap(heap, index, parent(index));
            index = parent(index);
        }
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private void heapifyDown(int[] heap, int index, int n) {
        while (true) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            int smallest = index;

            if (left < n && heap[left] < heap[smallest]) smallest = left;
            if (right < n && heap[right] < heap[smallest]) smallest = right;

            if (smallest == index) break;

            swap(heap, index, smallest);
            index = smallest;
        }
    }

    private void swap(int[] heap, int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

}
