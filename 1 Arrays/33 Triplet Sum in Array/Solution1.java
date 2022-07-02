//NAIVE Approach

class Solution1 {
    // Function to find if there exists a triplet in the
    // array A[] which sums up to X.
    public static boolean find3Numbers(int a[], int n, int x) {

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; j < n; k++) {
                    int sum = a[i] + a[j] + a[k];
                    if (sum == x)
                        return true;
                }
            }
        }
        return false;
    }
}

// Time complexity : O(n^3)