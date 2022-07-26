import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

//-------------------------BINARY SEARCH
public class Solution1 {
    public static void main(String[] args) throws java.lang.Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String s[] = br.readLine().split(" ");
            int n = Integer.parseInt(s[0]);
            int h = Integer.parseInt(s[1]);
            s = br.readLine().split(" ");
            int arr[] = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(s[i]);

            System.out.println(f(arr, n, h));
        } catch (Exception e) {

            System.out.println(e);
        }

    }

    public static int f(int[] a, int n, int h) {
        Arrays.sort(a);
        int l = 0, r = a[n - 1], ans = 0;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int sum = 0;
            for (int i : a)
                if (i > mid)
                    sum += i - mid;
            if (sum == h)
                return mid;
            if (sum > h) {
                ans = mid;
                l = mid + 1;
            } else
                h = mid - 1;

        }
        return ans;
    }
}
// Time complexity : O(n*log n)
// Space complexity : O(1)