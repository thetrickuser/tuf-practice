package heap;

public class HeapSort {

    public static void main(String[] args) {
        int[] nums = {7,4,1,5,3};
        HeapSort h = new HeapSort();
        h.heapSort(nums);
        for (int n: nums) System.out.println(n);
    }

    /*
    Uses a max heap to sort the given array nums in ascending order
    1. Build max heap
    2. Use extractMax to put the largest element at last of array but don't remove it
     */
    public void heapSort(int[] nums) {
        int n = nums.length;
        for (int i=(n/2 - 1); i>=0; i--) {
            heapifyDown(nums, i, n);
        }
        int j=n;
        for (int i=0; i<n; i++) {
            moveMaxToEnd(nums, j);
            j--;
        }
    }

    public int kthLargestElement(int[] nums, int k) {
        int n = nums.length;
        for (int i=(n/2 - 1); i>=0; i--) {
            heapifyDown(nums, i, n);
        }
        int j=n;
        for (int i=0; i<k; i++) {
            moveMaxToEnd(nums, j);
            j--;
        }

        return nums[n-k];
    }

    private void moveMaxToEnd(int[] heap, int n) {
        swap(heap, 0, n-1);
        heapifyDown(heap,0, n-1);
    }

    private void swap(int[] heap, int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public void heapifyDown(int[] heap, int index, int n) {
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
}
