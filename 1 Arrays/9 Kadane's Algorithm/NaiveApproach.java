class NaiveApproach {

    long maxSubarraySum(int arr[], int n) {
        long maxi = -(int) Math.pow(10, 9);
        for (int i = 0; i < n; i++) {
            long sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                maxi = Math.max(maxi, sum);
            }
        }
        return maxi;

    }

}

//Time Complexity :O(n^2)