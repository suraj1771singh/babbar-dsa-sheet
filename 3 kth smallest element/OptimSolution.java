
import java.util.Random;

class Solution {
    public static int kthSmallest(int[] arr, int l, int r, int k) {
        int res = 0;
        while (k - 1 >= l && k - 1 <= r) {
            int pos = partition(arr, l, r, k);

            if (pos < k - 1) {
                // check in right side
                kthSmallest(arr, pos + 1, r, k);
            } else if (pos > k - 1) {
                // check in left side
                kthSmallest(arr, l, pos - 1, k);
            } else {
                res = arr[pos];
                break;
            }
        }
        return res;
    }

    public static int partition(int[] arr, int l, int r, int k) {
        int i = l;
        Random random = new Random();
        int pivot = random.nextInt(r - l + 1) + l;
        swap(pivot, r, arr);//swapping pivot element in the last 
        pivot = r;
        for (int j = l; j <= r - 1; j++) {
            if (arr[j] <= arr[pivot]) {
                swap(i, j, arr);
                i++;
            }
        }
        // swap i with pivot
        swap(i, pivot, arr);
        return i;
    }

    public static void swap(int i, int j, int arr[]) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

// averge time complexity O(n)
// by randomly picking picking we can gurrantee that even in wrost case it won't be
// O(n^2)
