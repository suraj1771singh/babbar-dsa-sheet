import java.util.Arrays;

// Naive Approach

class Solution1 {
    public int countOccurence(int[] arr, int n, int k) {
        Arrays.sort(arr);
        int count = 1;
        int ans = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i] == arr[i - 1])
                count++;
            else {
                if (count > n / k)
                    ans++;
                count = 1;
            }
        }
        if (count > n / k)
            ans++;

        return ans;

    }
}

// Time complexity : O(n*logn)
// Space COmplexity :O(1)