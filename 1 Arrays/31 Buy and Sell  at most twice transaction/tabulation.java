public class tabulation {
    public static int maxProfit(int n, int[] price) {
        int dp[][][] = new int[n + 1][3][2];

        for (int ind = n - 1; ind >= 0; ind--) {
            for (int txn = 1; txn <= 2; txn++) {
                for (int canBuy = 0; canBuy <= 1; canBuy++) {
                    if (canBuy == 1) {
                        int buy = -price[ind] + dp[ind + 1][txn][0];
                        int notbuy = dp[ind + 1][txn][1];
                        dp[ind][txn][1] = Math.max(buy, notbuy);
                    } else {
                        int sell = price[ind] + dp[ind + 1][txn - 1][1];
                        int notsell = dp[ind + 1][txn][0];
                        dp[ind][txn][0] = Math.max(sell, notsell);
                    }
                }
            }
        }
        return dp[0][2][1];

    }
}
