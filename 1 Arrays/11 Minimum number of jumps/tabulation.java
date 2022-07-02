
//    TABULATION

public class tabulation {

    static int minJumps(int[] arr) {
        int n = arr.length;
        int dp[] = new int[n + 1];
        for (int index = n - 2; index >= 0; index--) {

            int limit = arr[index];
            int minstep = (int) Math.pow(10, 9);

            for (int i = index + 1; i <= Math.min(index + limit, n); i++) {
                int steps = 1 + dp[i];
                minstep = Math.min(minstep, steps);
            }
            dp[index] = minstep;
        }

        return dp[0] == (int) Math.pow(10, 9) ? -1 : dp[0];
    }

}