class Solution {
    static int countSquares(int N) {
        int ans = 0;
        for (int i = 1; i * i < N; i++)
            ans++;
        return ans;
    }
}
// Time complexity : O(sqrt(n))
// Space complexity : O(1)