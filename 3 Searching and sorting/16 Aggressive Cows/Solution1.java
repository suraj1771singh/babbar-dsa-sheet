import java.util.*;

//---------------BINARY SEARCH

public class Solution1 {
    public static int aggressiveCows(ArrayList<Integer> stalls, int k) {
        int maxi = -1, ans = -1;
        for (int i : stalls)
            maxi = Math.max(maxi, i);
        Collections.sort(stalls);
        int l = 1, h = maxi;
        while (l <= h) {
            int mid = (l + h) / 2;
            if (canPlaceCow(stalls, k, mid)) {
                ans = mid;
                l = mid + 1;
            } else
                h = mid - 1;
        }
        return ans;
    }

    public static boolean canPlaceCow(ArrayList<Integer> stalls, int k, int dist) {
        int req = 1, lastone = stalls.get(0);
        for (int i : stalls) {
            if (i - lastone >= dist) {
                req++;
                lastone = i;
            }
            if (req == k)
                return true;
        }
        return false;
    }
}
// Time complexity : O(n*log n)
// Space complexity : O(1)