
public class Solution {
    long maxProduct(int[] arr, int n) {
        long ans = maxOfArray(arr);
        long currMin = 1, curMax = 1;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                curMax = currMin = 1;
                continue;
            }
            long temp = curMax * arr[i];
            curMax = getMax(arr[i] * curMax, arr[i] * currMin, arr[i]);
            currMin = getMin(temp, arr[i] * currMin, arr[i]);
            ans = Math.max(ans, curMax);
        }
        return (int) ans;
    }

    long getMax(long a, long b, long c) {
        return Math.max(a, Math.max(b, c));
    }

    long getMin(long a, long b, long c) {
        return Math.min(a, Math.min(b, c));
    }

    long maxOfArray(int[] a) {
        int maxi = a[0];
        for (int i : a)
            maxi = Math.max(i, maxi);
        return maxi;
    }
}

// Time complexity :O(n)
// Space complexity :O(1)
