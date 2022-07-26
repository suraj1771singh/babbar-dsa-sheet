import java.util.Arrays;

//---------------------MEMOIZATION DP 

class Solution3 {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int job[][] = new int[n][3];
        for (int i = 0; i < n; i++)
            job[i] = new int[] { startTime[i], endTime[i], profit[i] };
        Arrays.sort(job, (a, b) -> a[0] - b[0]);
        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        return f(0, job, dp);

    }

    public int f(int curr, int[][] job, int dp[]) {
        if (curr == job.length)
            return 0;
        if (dp[curr] != -1)
            return dp[curr];

        int notpick = f(curr + 1, job, dp);
        int next = getNextJob(curr, job);
        int pick = next == -1 ? job[curr][2] : job[curr][2] + f(next, job, dp);
        return dp[curr] = Math.max(notpick, pick);
    }

    // O(log n)
    private int getNextJob(int curr, int[][] job) {
        int l = curr + 1, h = job.length - 1, target = job[curr][1], ans = -1;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (job[mid][0] < target)
                l = mid + 1;
            else if (job[mid][0] > target) {
                ans = mid;
                h = mid - 1;
            } else {
                ans = mid;
                h = mid - 1; // looking for first occurence
            }
        }
        return ans;
    }
}
// Time complexity : O(n*log n)
// Space complexity : O(n)+O(n)