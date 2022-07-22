import java.util.*;

//-----NAIVE SOLUTION
class Solution1 {
    ArrayList<Long> find(long arr[], int n, int x) {
        int first = -1, last = -1;
        ArrayList<Long> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (arr[i] == x) {
                if (first == -1)
                    first = i;
                last = i;
            }
        }
        ans.add((long) first);
        ans.add((long) last);
        return ans;
    }
}
// Time complexity : O(n)
// Space complexity : O(1)