import java.util.Arrays;

//---------------------NAIVE SOLUTION (RECURSION DP)

class Solution1 {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int job[][] = new int[n][3];
        for (int i = 0; i < n; i++)
            job[i] = new int[] { startTime[i], endTime[i], profit[i] };
        Arrays.sort(job, (a, b) -> a[0] - b[0]);
        return f(0, job);

    }

    public int f(int curr, int[][] job) {
        if (curr == job.length)
            return 0;

        int notpick = f(curr + 1, job);
        int next = getNextJob(curr, job);
        int pick = next == -1 ? job[curr][2] : job[curr][2] + f(next, job);
        return Math.max(notpick, pick);
    }

    private int getNextJob(int curr, int[][] job) {
        for (int i = curr + 1; i < job.length; i++)
            if (job[i][0] >= job[curr][1])
                return i;
        return -1;
    }
}
// Time complexity : O(n*2^n)
// Space complexity : O(n)