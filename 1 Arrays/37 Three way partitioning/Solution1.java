
//-----ALGO

// maintain two poiters lo , mid
// lo = pointers to elements < a
// mid= pointers to elements >=a && <=b

class Solution1 {

    public void threeWayPartition(int arr[], int a, int b) {
        int lo = 0, mid = 0, n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] < a) {
                swap(lo, i, arr);
                lo++;
                // check isn't the swapped element lies between [a,b]
                if (arr[i] >= a && arr[i] <= b) {
                    swap(mid, i, arr);
                    mid++;
                }
                // mid should be always >=lo
                if (lo > mid)
                    mid = lo;

            } else if (arr[i] >= a && arr[i] <= b) {
                swap(mid, i, arr);
                mid++;
            }
        }
    }

    public void swap(int i, int j, int[] a) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}

// Time complexity : O(n)
// Space complexity :O(1)