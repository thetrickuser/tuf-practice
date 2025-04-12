package sorting;

public class SortingSolution {

  public static void main(String[] args) {
    SortingSolution sln = new SortingSolution();
    int[] arr = new int[] {7,4,1,5,3};
    System.out.println("Original array: ");
    System.out.println("---------------------------------------------------");
    for (int i: arr) {
      System.out.print(i + " ");
    }
    System.out.println();
    System.out.println("---------------------------------------------------");
    sln.quickSort(arr);
    System.out.println("Sorted array: ");
    System.out.println("---------------------------------------------------");
    for (int i: arr) {
      System.out.print(i + " ");
    }
    System.out.println();
    System.out.println("---------------------------------------------------");
  }

  public int[] mergeSort(int[] nums) {
    mergeSortHelper(nums, 0, nums.length - 1);
    return nums;
  }

  public int[] quickSort(int[] nums) {
    quickSortHelper(nums, 0, nums.length - 1);
    return nums;
  }

  private void quickSortHelper(int[] nums, int low, int high) {
    if (low < high) {
      int partitionIndex = partition(nums, low, high);
      quickSortHelper(nums, low, partitionIndex - 1);
      quickSortHelper(nums, partitionIndex + 1, high);
    }
  }

  private int partition(int[] nums, int low, int high) {
    int pivot = nums[low];
    int i = low, j = high;
    while (i < j) {
      while (i <= high && nums[i] <= pivot) {
        i++;
      }
      while (j >= low && nums[j] > pivot) {
        j--;
      }

      if (i < j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
      }
    }
    nums[low] = nums[j];
    nums[j] = pivot;
    return j;
  }

  private void mergeSortHelper(int[] nums, int left, int right) {
    if (left >= right)
      return;
    int mid = left + (right - left) / 2;
    mergeSortHelper(nums, left, mid);
    mergeSortHelper(nums, mid + 1, right);
    merge(nums, left, mid, right);
  }

  private void merge(int[] nums, int left, int mid, int right) {
    int p1 = left;
    int p2 = mid + 1;
    int[] arr = new int[right - left + 1];
    int i = 0;
    while (p1 <= mid && p2 <= right) {
      if (nums[p1] < nums[p2]) {
        arr[i++] = nums[p1++];
      } else {
        arr[i++] = nums[p2++];
      }
    }

    while (p1 <= mid) {
      arr[i++] = nums[p1++];
    }

    while (p2 <= right) {
      arr[i++] = nums[p2++];
    }

    i = left;
    while (i <= right) {
      nums[i] = arr[i - left];
      i++;
    }
  }

}
