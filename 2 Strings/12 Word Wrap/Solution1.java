
//-------------RECURSIVE APPROACH

class Solution {
    public int solveWordWrap(int[] nums, int k) {
        return f(0, k, nums);
    }

    public int f(int ind, int k, int[] nums) {
        int n = nums.length;
        if (ind >= n)
            return 0;

        int len = nums[ind], i = ind, mini = (int) Math.pow(10, 9);

        while (len <= k && i < nums.length) {
            int cost;
            if (i == nums.length - 1)
                return 0;
            cost = (int) Math.pow(k - len, 2) + f(i + 1, k, nums);
            len += (nums[++i] + 1);
            mini = Math.min(mini, cost);
        }
        return mini;

    }
}
