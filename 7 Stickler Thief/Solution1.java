import java.util.Arrays;

//-------MEMOIZATION (DP)

class Solution1 {

    public int FindMaxSum(int arr[], int n) {
        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        return f(n - 1, arr, dp);
    }

    public int f(int ind, int arr[], int dp[]) {
        if (ind < 0)
            return 0;
        if (dp[ind] != -1)
            return dp[ind];
        int notpick = f(ind - 1, arr, dp);
        int pick = arr[ind] + f(ind - 2, arr, dp);
        return dp[ind] = Math.max(notpick, pick);
    }

}
// Time complexity : O(n);
// Space complexity : O(n), AS: O(n)