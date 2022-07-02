import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        ArrayList<int[]> ans = new ArrayList<>();
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
        int[] last_interval = intervals[0];
        ans.add(last_interval);
        for (int i = 1; i < n; i++) {

            int[] curr_interval = intervals[i];
            if (last_interval[1] >= curr_interval[0])

                last_interval[1] = Math.max(last_interval[1], curr_interval[1]);

            else {
                last_interval = curr_interval;
                ans.add(last_interval);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}