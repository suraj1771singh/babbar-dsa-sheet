
//------------------BINARY SEARCH 

class Solution {
    static long minTime(int[] arr, int n, int k) {
        long maxi = 0, ans = 0;
        long sum = 0;
        for (int i : arr) {
            sum += i;
            maxi = Math.max(maxi, i);
        }
        // lower limit of ans is =maxi
        // higher limit of ans is =sum
        long l = maxi, h = sum;
        while (l <= h) {
            long mid = l + (h - l) / 2;
            if (isFeasible(mid, arr, k)) {
                ans = mid;
                h = mid - 1;
            } else
                l = mid + 1;
        }
        return ans;
    }

    static boolean isFeasible(long limit, int[] a, int k) {
        int req = 1;
        long sum = 0;
        for (int i = 0; i < a.length; i++) {
            if (sum + a[i] > limit) {
                req++;
                sum = a[i];
            } else
                sum += a[i];
        }
        return req <= k;
    }
}
// Time complexity : O(n*logn)
// Space complexity : O(1)