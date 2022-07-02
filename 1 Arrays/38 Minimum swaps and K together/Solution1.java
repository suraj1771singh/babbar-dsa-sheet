import java.util.Base64;

//-------ALGO

// observe problem statement
// Find the count of all elements which are less than or equal to ‘k’
// usiing sliding window tech , each time keep track of how many elements in this range are greater than ‘k’.
// return  min 

class Solution1 {

    public static int minSwap(int arr[], int n, int k) {
        int count = 0, ans = n;
        for (int i : arr) {
            if (i <= k)
                count++;
        }
        int bad_count = 0;

        for (int i = 0; i < count; i++) {
            if (arr[i] > k)
                bad_count++;
        }

        ans = bad_count;
        for (int i = 0, j = count; j < n; ++i, ++j) {
            if (arr[i] > k)
                bad_count--;
            if (arr[j] > k)
                bad_count++;
            ans = Math.min(ans, bad_count);
        }
        return ans;

    }

}

// Time complexity : O(n)
// Space complexity : O(1)