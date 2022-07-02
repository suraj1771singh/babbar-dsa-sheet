import java.util.Arrays;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length, count = 0;
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
        int[] last_interval = intervals[0];

        for (int i = 1; i < n; i++) {
            int[] curr_interval = intervals[i];
            if (last_interval[1] > curr_interval[0]) {
                last_interval[1] = Math.min(last_interval[1], curr_interval[1]);
                count++;
            } else
                last_interval = curr_interval;
        }
        return count;
    }
}

// Time Complexity : O(n * logn )