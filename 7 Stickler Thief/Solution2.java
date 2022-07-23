
//-------TABULATION (DP)

class Solution2 {

    public int FindMaxSum(int arr[], int n) {
        int dp[] = new int[n];
        for (int i = 0; i < n; i++) {
            int notpick = i - 1 < 0 ? 0 : dp[i - 1];
            int pick = i - 2 < 0 ? arr[i] : arr[i] + dp[i - 2];
            dp[i] = Math.max(notpick, pick);
        }
        return dp[n - 1];
    }

}
// Time complexity : O(n);
// Space complexity : O(n);