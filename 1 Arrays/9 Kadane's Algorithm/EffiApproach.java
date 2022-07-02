
// USING KADANE'S algorithm

public class EffiApproach {
    long maxSubarraySum(int arr[], int n) {
        long maxi = arr[0];
        for (int i = 1; i < n; i++) {
            arr[i] = Math.max(arr[i], arr[i] + arr[i - 1]);
            maxi = Math.max(maxi, arr[i]);
        }
        return maxi;

    }
}

// Time complexity :O(n)