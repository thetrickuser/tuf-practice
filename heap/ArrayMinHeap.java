package heap;

class ArrayMinHeap {

    public static void main(String[] args) {
        int[] nums = {5,4,3,2,1};
        ArrayMinHeap h = new ArrayMinHeap();
//        h.heapify(nums, 0,7);
        h.buildMinHeap(nums);
        for (int n: nums) {
            System.out.println(n);
        }
    }

    public void buildMinHeap(int[] nums) {
        int n = nums.length;
        for (int i=n-1; i>=0; i--) {
            heapifyDown(nums, i, n);
        }
    }

    public void heapify(int[] heap, int index, int val) {
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
