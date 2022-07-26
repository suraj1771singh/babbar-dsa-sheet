
//--------------------BINARY SEARCH 

class Solution {
    int findNum(int n) {
        // lowest number with 0 trailing zero's
        // highes possible number 1e9
        int l = 1, h = (int) 1e9, ans = -1;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (getCount(mid) < n)
                l = mid + 1;
            else {
                ans = mid;
                h = mid - 1;
            }
        }
        return ans;

    }

    int getCount(int n) {
        int cnt = 0;
        while (n >= 5) {
            cnt += n / 5;
            n /= 5;
        }
        return cnt;
    }
}
// Time complexity : O( 9*log5 N).
// Space complexity : O(1)