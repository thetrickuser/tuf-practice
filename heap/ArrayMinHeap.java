package heap;

class ArrayMinHeap {

    public static void main(String[] args) {
        int[] nums = {10,20,30,21,23};
        ArrayMinHeap h = new ArrayMinHeap();
// //        h.heapify(nums, 0,7);
//         h.buildMinHeap(nums);
//         for (int n: nums) {
//             System.out.println(n);
//         }
        h.minToMaxHeap(nums);
        for (int num: nums) {
            System.out.println(num);
        }
        // System.out.println(h.isHeap(nums));   
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

    public boolean isHeap(int[] nums) {
        for (int i=nums.length - 1; i>=0; i--) {
            if (nums[parent(i)] > nums[i]) return false;
        }
        return true;
    }

    public int[] minToMaxHeap(int[] nums) {
        int n = nums.length;
        ArrayMaxHeap h = new ArrayMaxHeap();
        for (int i=(n/2 - 1); i>=0; i--) {
            h.heapifyDown(nums, i, n);
        }
        return nums;
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
