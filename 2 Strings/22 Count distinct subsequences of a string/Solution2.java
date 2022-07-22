import java.util.*;

//-----------OBSERVATION 
/*
 1) take abc and start with empty subseq and observe pattern
*/

public class Solution2 {
    final int MOD = (int) Math.pow(10, 9) + 7;

    int distinctSubsequences(String s) {
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        int dp[] = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            char c = s.charAt(i - 1);
            if (map.containsKey(c))
                dp[i] = (2 * dp[i - 1] % MOD - dp[map.get(c) - 1] + MOD) % MOD;
            else
                dp[i] = (2 * dp[i - 1]) % MOD;
            map.put(c, i);
        }
        return dp[n] % MOD;
    }
}
// Time complexity : O(n)
// Space complexity : O(n)