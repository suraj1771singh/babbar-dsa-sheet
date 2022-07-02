import java.util.Arrays;

class Solution {
    int getMinDiff(int[] arr, int n, int k) {
        Arrays.sort(arr);
        int maxi = 0;
        int mini = (int) Math.pow(10, 9);
        int m = n / 2;
        for (int i = 0; i < m; i++) {
            int item = arr[i] + k;
            maxi = Math.max(maxi, item);
            mini = Math.min(mini, item);
        }
        for (int j = m; j < n; j++) {
            int item = arr[j];
            if (arr[j] - k > 0)
                item = arr[j] - k;

                
            maxi = Math.max(maxi, item);
            mini = Math.min(mini, item);
        }
        return maxi - mini;

    }
}