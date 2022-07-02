import java.util.Arrays;

// ------- ALGO
// sort array
// check all possible continous subarrays length, and return max
// Time complexity :O(n*log n), Space complexity :O(1);

class Solution1 {

    static int findLongestConseqSubseq(int arr[], int N) {
        Arrays.sort(arr);
        int ans = 1;
        int count = 1;
        for (int i = 1; i < N; i++) {
            if (arr[i] - arr[i - 1] == 1) {
                count++;
            } else if (arr[i] - arr[i - 1] > 1)
                count = 1;
            ans = Math.max(ans, count);
        }
        return ans;
    }
}

