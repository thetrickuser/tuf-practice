package heap;

class MaxHeap {

    public static void main(String[] args) {
        int[] nums = {12,11,10,9,8,7,6,5};
        MaxHeap h = new MaxHeap();
        h.heapify(nums, 0,7);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    public void heapify(int[] heap, int index, int val) {
        heap[index] = val;
        int n = heap.length;
        if (index > 0 && heap[parent(index)] < heap[index]) {
            heapifyUp(heap, index);
        } else {
            heapifyDown(heap, index, n);
        }
    }

    private void heapifyUp(int[] heap, int index) {
        while (index > 0 && heap[parent(index)] < heap[index]) {
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
            int largest = index;

            if (left < n && heap[left] > heap[largest]) largest = left;
            if (right < n && heap[right] > heap[largest]) largest = right;

            if (largest == index) break;

            swap(heap, index, largest);
            index = largest;
        }
    }

    private void swap(int[] heap, int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

}
