import java.util.Arrays;

public class memoization {
    public static int maxProfit(int n, int[] price) {
        int dp[][][] = new int[n][3][2];
        for (int[][] i : dp) {
            for (int[] j : i) {
                Arrays.fill(j, -1);
            }
        }
        return f(0, 2, true, price, dp);

    }

    public static int f(int ind, int txn, boolean canBuy, int[] price, int[][][] dp) {
        if (ind == price.length)
            return 0;
        if (txn == 0)
            return 0;

        if (canBuy) {
            if (dp[ind][txn][1] != -1)
                return dp[ind][txn][1];
            int buy = -price[ind] + f(ind + 1, txn, false, price, dp);
            int notbuy = f(ind + 1, txn, true, price, dp);
            return dp[ind][txn][1] = Math.max(buy, notbuy);
        } else {
            if (dp[ind][txn][0] != -1)
                return dp[ind][txn][0];
            int sell = price[ind] + f(ind + 1, txn - 1, true, price, dp);
            int notsell = f(ind + 1, txn, false, price, dp);
            return dp[ind][txn][0] = Math.max(sell, notsell);
        }
    }
}
