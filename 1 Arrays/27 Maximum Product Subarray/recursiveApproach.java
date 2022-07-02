import java.util.Arrays;

class recursiveApproach {
    // Function to find maximum product subarray
    long maxProduct(int[] arr, int n) {
        long dp[][] = new long[2][n];
        for (long[] r : dp) {
            Arrays.fill(r, -1);
        }
        if (n == 1)
            return arr[0];
        // storing in array
        f(n - 1, 1, arr, dp);
        long ans = 1;

        // getting maximum by traversing an array

        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dp[1][i]);
        }
        return ans;
    }

    long f(int ind, int isGetMax, int[] arr, long dp[][]) {
        long ans = 1;

        if (ind < 0)
            return 1;
        if (dp[isGetMax][ind] != -1)
            return dp[isGetMax][ind];

        long curr_val = arr[ind] == 0 ? 1 : arr[ind];
        long prev_max = f(ind - 1, 1, arr, dp);
        long prev_min = f(ind - 1, 0, arr, dp);

        if (isGetMax == 1) {
            // we want max value
            ans = getMax(curr_val * prev_max, curr_val * prev_min, curr_val);
        } else {
            // we want min value
            ans = getMin(curr_val * prev_max, curr_val * prev_min, curr_val);
        }

        if (arr[ind] == 0) {
            dp[isGetMax][ind] = 1;
        } else {
            dp[isGetMax][ind] = ans;
        }
        return dp[isGetMax][ind];

    }

    long getMax(long a, long b, long c) {
        return Math.max(a, Math.max(b, c));
    }

    long getMin(long a, long b, long c) {
        return Math.min(a, Math.min(b, c));
    }

}