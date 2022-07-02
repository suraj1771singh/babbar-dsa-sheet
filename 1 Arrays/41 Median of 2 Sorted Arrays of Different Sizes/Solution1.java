import java.util.Arrays;

//------ALGO
// sort arrays with using constant extra space 
// and find median

class GFG {
    public double findMedianSortedArrays(int[] a, int[] b) {
        double median = 0;
        int n = a.length, m = b.length;
        sortArrays(n, m, a, b);

        if ((n + m) % 2 == 0) {
            // even
            int mid = (n + m) / 2;
            if (mid > n - 1) {
                median += b[mid - n] / (double) 2;
            } else {
                median += a[mid] / (double) 2;
            }
            mid--;
            if (mid > n - 1) {
                median += b[mid - n] / (double) 2;
            } else {
                median += a[mid] / (double) 2;
            }

        } else {
            int mid = (n + m) / 2;

            if (mid > n - 1) {
                median += b[mid - n];
            } else
                median += a[mid];

        }
        return median;

    }

    static void sortArrays(int n, int m, int[] arr1, int[] arr2) {
        int l = n - 1, r = 0;
        while (arr1[l] > arr2[r] && r < n && l >= 0) {
            int temp = arr1[l];
            arr1[l] = arr2[r];
            arr2[r] = temp;
            l--;
            r++;
        }
        // sort
        Arrays.sort(arr1);
        Arrays.sort(arr2);

    }
}

// Time complexity : O(m*logm + n*logn)
// Space complexity : O(1)