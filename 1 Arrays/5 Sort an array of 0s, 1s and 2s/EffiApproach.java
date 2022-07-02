
//Dutch National FLag algorithm

public class EffiApproach {

    public static void sort012(int arr[], int n) {
        int low = 0, mid = 0, high = n - 1;
        while (mid <= high) {
            if (arr[mid] == 0) {
                swap(mid, low, arr);
                low++;
                mid++;

            } else if (arr[mid] == 2) {
                swap(mid, high, arr);
                high--;

            } else
                mid++;

        }
    }

    private static void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}

// Time complexity :O(n)