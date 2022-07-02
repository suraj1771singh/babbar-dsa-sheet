
//USING MERGE SORT 
//trick while merging count inversion 

public class EffiApproach {
    static long ans;

    static long inversionCount(long arr[], long n) {
        ans = 0;
        mergeSort(arr, 0, n - 1);
        return ans;
    }

    static void mergeSort(long arr[], long lo, long hi) {
        if (lo < hi) {
            long mid = lo + (hi - lo) / 2;
            mergeSort(arr, lo, mid);
            mergeSort(arr, mid + 1, hi);
            merge(arr, lo, mid, hi);
        }
    }

    static void merge(long arr[], long lo, long mid, long hi) {
        long n1 = mid - lo + 1, n2 = hi - mid;
        long arr1[] = new long[(int) n1];
        long arr2[] = new long[(int) n2];

        for (long i = 0; i < n1; i++)
            arr1[(int) i] = arr[(int) (lo + i)];
        for (long i = 0; i < n2; i++)
            arr2[(int) i] = arr[(int) (mid + i + 1)];

        long i = 0, j = 0, k = lo;

        while (i < n1 && j < n2) {
            if (arr1[(int) i] <= arr2[(int) j])
                arr[(int) k++] = arr1[(int) i++];
            else {
                ans += n1 - i; // Only this line added in merge sort code
                arr[(int) k++] = arr2[(int) j++];
            }
        }
        while (i < n1)
            arr[(int) k++] = arr1[(int) i++];
        while (j < n2)
            arr[(int) k++] = arr2[(int) j++];
    }
}

// Time complexity : O(nlog(n))
// Space complexity : O(1)
