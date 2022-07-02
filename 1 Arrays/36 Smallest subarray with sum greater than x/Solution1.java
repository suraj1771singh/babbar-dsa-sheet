
//slinding window algo

class Solution {

    public static int smallestSubWithSum(int a[], int n, int x) {
        int l = 0, r = 0, sum = 0, ans = n;
        while (r < n) {
            sum += a[r];
            r++;
            if (sum > x) {
                ans = Math.min(ans, r - l + 1);
                while (sum > x) {
                    sum -= a[l];
                    l++;
                    ans = Math.min(ans, r - l + 1);
                }
            }
        }
        return ans;

    }
}