
//------------------EFFICIENT SOLUTION

class Solution1 {
    public static long[] productExceptSelf(int nums[], int n) {
        long ans[] = new long[n];
        long prod = 1;
        for (int i = 0; i < n; i++) {
            ans[i] = prod;
            prod *= nums[i];
        }
        prod = 1;
        for (int i = n - 1; i >= 0; i--) {
            ans[i] *= prod;
            prod *= nums[i];
        }
        return ans;
    }
}
// Time complexity : O(n)
// Space compleixty : O(1)