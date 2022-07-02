import java.util.Arrays;

//   MEMOISATION

public class memoisation {

    static int minJumps(int[] arr) {
        int dp[] = new int[arr.length];
        Arrays.fill(dp, -1);
        int res = f(arr, 0, dp);
        return res == (int) Math.pow(10, 9) ? -1 : res;
    }

    static int f(int[] arr, int index, int[] dp) {

        if (index >= arr.length - 1) {
            return 0;
        }
        if (dp[index] != -1)
            return dp[index];
        int limit = arr[index];
        int minstep = (int) Math.pow(10, 9);
        for (int i = index + 1; i <= index + limit; i++) {
            int steps = 1 + f(arr, i, dp);
            minstep = Math.min(minstep, steps);
        }
        return dp[index] = minstep;
    }
}