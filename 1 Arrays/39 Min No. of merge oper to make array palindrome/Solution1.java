
//recursive solution

class Solution1 {
    public static void main(String[] args) {
        int arr[] = new int[] { 1, 4, 5, 9, 1 };
        System.out.println("Count of minimum operations is " +
                findMinOps(arr, arr.length));

    }

    static int findMinOps(int[] arr, int n) {
        return f(0, n - 1, arr);

    }

    static int f(int i, int j, int a[]) {
        if (i > j)
            return 0;
        if (a[i] > a[j]) {
            a[j - 1] = a[j - 1] + a[j];
            return 1 + f(i, j - 1, a);

        } else if (a[i] < a[j]) {
            a[i + 1] = a[i + 1] + a[i];
            return 1 + f(i + 1, j, a);
        } else
            return f(i + 1, j - 1, a);
    }
}
// Time complexity : O(n);
// Auxilary SC : O(n)