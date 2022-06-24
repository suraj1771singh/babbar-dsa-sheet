import java.util.Arrays;

//sort an array and return kth  index element

class Solution {
    public static int kthSmallest(int[] arr, int l, int r, int k) {
        int res = 0;
        Arrays.sort(arr);
        res = arr[k - 1];
        return res;
    }
}

// Time complexity : O(n* logn)