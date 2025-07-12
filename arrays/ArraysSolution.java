package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraysSolution {

  public static void main(String[] args) {
    ArraysSolution sln = new ArraysSolution();
    int[] arr = new int[] { 1, 3, 5, 6 };
    int[] arr2 = new int[] { 1, 2, 3, 4, 5, 6, 7, 8 };
    int[] arru = sln.unionArray(arr, arr2);
    for (int i : arru)
      System.out.println(i);

  }

  public void rotateArrayByOne(int[] nums) {
    int n = nums.length;
    for (int i = 0; i < n - 1; i++) {
      int temp = nums[i];
      nums[i] = nums[(i + 1) % n];
      nums[(i + 1) % n] = temp;
    }
  }

  public void rotateArray(int[] nums, int k) {
    int n = nums.length;
    if (k >= n) {
      k -= n;
    }
    if (k > 0) {
//      int[] temp = new int[k];
//      for (int i = 0; i < k; i++) {
//        temp[i] = nums[i];
//      }
        int[] temp = Arrays.copyOf(nums, k);

        for (int i = k; i < n; i++) {
        nums[i - k] = nums[i];
      }

      for (int i = n - k; i < n; i++) {
        nums[i] = temp[i - (n - k)];
      }
    }
  }

  public int[] unionArray(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        int[] unionArr = new int[n1+n2];
        int j = 0, k = 0, i=0;
        if (nums1[0] < nums2[0]) {
            unionArr[0] = nums1[0];
            j++;
        } else {
            unionArr[0] = nums2[0];
            k++;
        }

        while (j < n1 && k < n2) {
            if (nums1[j] < nums2[k]) {
                if (unionArr[i] != nums1[j]) {
                    i++;
                    unionArr[i] = nums1[j];
                }
                j++;
            } else {
                if (unionArr[i] != nums2[k]) {
                    i++;
                    unionArr[i] = nums2[k];
                }
                k++;
            }   
        }

        while (j < n1) {
            if (unionArr[i] != nums1[j]) {
              i++;    
                unionArr[i] = nums1[j];
            }
            j++;
        }

        while (k < n2) {
            if (unionArr[i] != nums2[k]) {
              i++;
                unionArr[i] = nums2[k];
            }
            k++;
        }

        return Arrays.copyOfRange(unionArr,0,i+1);
    }

    public int[] intersectionArray(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        List<Integer> intersectionArr = new ArrayList<>();

        int i=0, j=0; 
        // int k=0;
        while (i < n1 && j < n2) {
            if (nums1[i] == nums2[j]) {
                intersectionArr.add(nums1[i]);
                i++;
                j++;
            } else {

            if (nums1[i] < nums2[j]) i++;
            else j++;
            }
        }

        return intersectionArr.stream().mapToInt(Integer::intValue).toArray();
    }
}
