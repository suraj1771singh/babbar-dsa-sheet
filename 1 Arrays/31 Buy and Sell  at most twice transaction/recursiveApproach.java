
class Solution {
    public static int maxProfit(int n, int[] price) {
        return f(0, 2, true, price);

    }

    public static int f(int ind, int txn, boolean canBuy, int[] price) {
        if (ind == price.length)
            return 0;
        if (txn == 0)
            return 0;
        if (canBuy) {
            int buy = -price[ind] + f(ind + 1, txn, false, price);
            int notbuy = f(ind + 1, txn, true, price);
            return Math.max(buy, notbuy);
        } else {
            int sell = price[ind] + f(ind + 1, txn - 1, true, price);
            int notsell = f(ind + 1, txn, false, price);
            return Math.max(sell, notsell);
        }
    }
}