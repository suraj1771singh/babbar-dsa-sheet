import java.util.*;
//--------MEOMOIZATION

class Solution2 {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        for (String str : wordDict)
            set.add(str);
        int dp[] = new int[s.length()];
        Arrays.fill(dp, -1);
        return isPresent(0, set, s, dp);
    }

    public static boolean isPresent(int ind, Set<String> set, String A, int[] dp) {
        if (ind == A.length())
            return true;
        if (dp[ind] != -1)
            return dp[ind] == 1 ? true : false;
        for (int i = ind; i < A.length(); i++) {
            if (set.contains(A.substring(ind, i + 1))) {
                if (isPresent(i + 1, set, A, dp)) {
                    dp[ind] = 1;
                    return true;
                }
            }
        }
        dp[ind] = 0;
        return false;
    }
}
// Time complexity : O(n^2) : n=string.length();
// Space complexity : O(n);