import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws java.lang.Exception {
        testcase();
    }

    public static void testcase() {
        try {
            BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(r.readLine());
            while (t-- > 0) {
                int k = Integer.parseInt(r.readLine());
                String s[] = r.readLine().split(" ");
                int n = Integer.parseInt(s[0]);

                /*------- For input array */
                int arr[] = new int[n];
                for (int i = 0; i < n; i++) {
                    arr[i] = Integer.parseInt(s[i + 1]);
                }

                f(n, k, arr);
            }

        } catch (Exception e) {
        }
    }

    public static void f(int n, int k, int[] arr) {
        int maxi = 0, ans = 0;
        for (int i : arr)
            maxi = Math.max(maxi, i);
        // lower time taken is 1 min
        // highest time taken by highest level cook = maxi*k*(k+1)/2
        int l = 1, h = (maxi * k * (k + 1)) / 2;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (isFeasible(mid, k, arr)) {
                ans = mid;
                h = mid - 1;
            } else
                l = mid + 1;
        }
        System.out.println(ans);

    }

    private static boolean isFeasible(int limit, int k, int[] arr) {
        int req = 0;
        for (int i : arr) {
            for (int a = 0; a <= k; a++) {
                int time = (i * a * (a + 1)) / 2;
                if (time > limit) {
                    req += a - 1;
                    break;
                }
            }
        }
        return req >= k;

    }
}