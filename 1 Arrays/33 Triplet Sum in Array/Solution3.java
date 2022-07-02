import java.util.Arrays;

//----ALGO
// sort array
// pick each element and find pair on right side (i+1) with sum x-a[i]
// this will require only constant space 

public class Solution3 {
    public static boolean find3Numbers(int a[], int n, int x) {
        Arrays.sort(a);
        for (int i = 0; i < n; i++)
            if (findPair(i + 1, n - 1, x - a[i], a))
                return true;
        return false;

    }

    public static boolean findPair(int l, int r, int x, int a[]) {
        while (l < r) {
            if (a[l] + a[r] < x)
                l++;
            else if (a[l] + a[r] > x)
                r--;
            else
                return true;
        }
        return false;
    }
}

// Time complexity :O(n^2)
// Space complexity :O(1)
