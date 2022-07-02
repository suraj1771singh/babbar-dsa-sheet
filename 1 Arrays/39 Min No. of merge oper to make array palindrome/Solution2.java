
//Iterative solution

public class Solution2 {
    public static void main(String[] args) {
        int arr[] = new int[] { 1, 4, 5, 9, 1 };
        System.out.println("Count of minimum operations is " +
                findMinOps(arr, arr.length));

    }

    static int findMinOps(int[] a, int n) {
        int i = 0, j = n - 1;
        int ans = 0;
        while (i < j) {
            if (a[i] > a[j]) {
                a[j - 1] += a[j];
                ans++;
                j--;
            } else if (a[i] < a[j]) {
                a[i + 1] += a[i];
                ans++;
                i++;
            } else {
                i++;
                j--;
            }
        }
        return ans;

    }

}
// Time complexity : O(n);
// Space complexity C : O(1)
