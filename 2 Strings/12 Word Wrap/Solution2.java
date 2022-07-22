import java.util.Arrays;

//---------MOMOIZATION 

public class Solution2 {

    public int solveWordWrap(int[] nums, int k) {
        int dp[] = new int[nums.length + 1];
        Arrays.fill(dp, -1);
        return f(0, k, nums, dp);
    }

    public int f(int ind, int k, int[] nums, int[] dp) {
        int n = nums.length;
        if (ind >= n)
            return 0;
        if (dp[ind] != -1)
            return dp[ind];

        int len = nums[ind], i = ind, mini = (int) Math.pow(10, 9);

        while (len <= k && i < nums.length) {
            int cost;
            if (i == nums.length - 1)
                return 0;
            cost = (int) Math.pow(k - len, 2) + f(i + 1, k, nums, dp);
            len += (nums[++i] + 1);
            mini = Math.min(mini, cost);
        }
        return dp[ind] = mini;
    }
}
// Time complexity : O(n^2)
// Space complexity : O(n)
