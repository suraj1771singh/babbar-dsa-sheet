class Solution {
    private int glob_inv;
    private int local_inv;

    public boolean isIdealPermutation(int[] nums) {
        int n = nums.length;
        glob_inv = 0;
        local_inv = getLocalInv(nums);
        mergeSort(0, n - 1, nums);
        return glob_inv == local_inv;

    }

    public void mergeSort(int lo, int hi, int a[]) {
        if (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            mergeSort(lo, mid, a);
            mergeSort(mid + 1, hi, a);
            merge(lo, mid, hi, a);
        }

    }

    public void merge(int lo, int mid, int hi, int[] a) {
        int n1 = mid - lo + 1, n2 = hi - mid;
        int left[] = new int[n1];
        int right[] = new int[n2];

        for (int i = 0; i < n1; i++)
            left[i] = a[lo + i];

        for (int i = 0; i < n2; i++)
            right[i] = a[mid + i + 1];

        int l = 0, r = 0, k = lo;

        while (l < n1 && r < n2) {
            if (left[l] <= right[r])
                a[k++] = left[l++];
            else {
                glob_inv += n1 - l;
                a[k++] = right[r++];
            }
        }

        while (l < n1)
            a[k++] = left[l++];

        while (r < n2)
            a[k++] = right[r++];
    }

    public int getLocalInv(int[] a) {
        int count = 0;
        for (int i = 1; i < a.length; i++)
            if (a[i - 1] > a[i])
                count++;
        return count;
    }
}

// Time complexity : O(n* logn)
// Space complexity : O(n)