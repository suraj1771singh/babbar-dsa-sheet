import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public long findMinDiff(ArrayList<Integer> a, int n, int m) {
        long ans = (long) Math.pow(10, 9);
        Collections.sort(a);
        for (int i = 0; i <= n - m; i++) {
            ans = Math.min(ans, Math.abs(a.get(i) - a.get(i + m - 1)));
        }
        return ans;

    }
}

// Time complexity : o(n* log n)
// Space complexity : O(1)