import java.util.*;

//---------EFFICIENT SOLUTION
// Array is sorted , so we can use binary search 

public class Solution2 {
    ArrayList<Long> find(long arr[], int n, int x) {
        ArrayList<Long> ans = new ArrayList<>();
        int lo = 0, hi = n - 1, first = -1, last = -1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] > x)
                hi = mid - 1;
            else if (arr[mid] < x)
                lo = mid + 1;
            else {
                first = last = mid;
                // first will be in left side
                hi = mid - 1;

            }
        }
        if (last != -1) {
            lo = last;
            hi = n - 1;
            while (lo < hi) {
                int mid = lo + (hi - lo) / 2;
                if (arr[mid] > x)
                    hi = mid - 1;
                else if (arr[mid] < x)
                    lo = mid + 1;
                else {
                    last = mid;
                    // last will be in right side
                    lo = mid + 1;

                }
            }
        }
        ans.add((long) first);
        ans.add((long) last);
        return ans;
    }
}
// Time complexity : O(logn)
// Space complexity : O(1)