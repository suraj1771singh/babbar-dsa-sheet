
//-------SPACE OPTIMZATION (DP)

class Solution3 {
    
    public int FindMaxSum(int arr[], int n) {
        int prev = 0, prevToPrev = 0;
        for (int i = 0; i < n; i++) {
            int notpick = prev;
            int pick = arr[i] + prevToPrev;
            prevToPrev = prev;
            prev = Math.max(notpick, pick);
        }
        return prev;
    }

}
// Time complexity : O(n);
// Space complexity : O(1);