public class SpaceOptimzedSol {
    public static int maxProfit(int n, int[] price) {
        int firstBuy = (int) Math.pow(10, 9);
        int firstSell = 0;
        int secondBuy = -(int) Math.pow(10, 9);
        int secondSell = 0;

        for (int i = 0; i < n; i++) {
            firstBuy = Math.max(firstBuy, -price[i]);
            firstSell = Math.max(firstSell, firstBuy + price[i]);
            secondBuy = Math.max(secondBuy, firstSell - price[i]);
            secondSell = Math.max(secondSell, secondBuy + price[i]);
        }
        return secondSell;
    }

}
