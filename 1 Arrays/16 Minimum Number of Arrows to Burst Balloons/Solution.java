import java.util.Arrays;
import java.util.Currency;

class Solution {
    public int findMinArrowShots(int[][] points) {
        int n = points.length, count = 1;
        Arrays.sort(points, (i1, i2) -> Integer.compare(i1[1], i2[1]));
        int[] last_interval = points[0];
        for (int i = 0; i < n; i++) {
            int[] curr_interval = points[i];
            if (last_interval[1] > curr_interval[0])
                last_interval[1] = Math.min(last_interval[1], curr_interval[1]);
            else {
                last_interval = curr_interval;
                count++;
            }
        }
        return count;
    }
}

// Time complexity : O(n*logn)
// Space complexity : O(1)