
import java.util.*;
import java.lang.*;
import java.io.*;

class Solution1 {
    public static void main(String[] args) throws java.lang.Exception {
        testcase();
    }

    public static void testcase() {
        try {
            BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
            String s[] = r.readLine().split(" ");
            ArrayList<int[]> arr = new ArrayList<>();
            while (s.length != 1) {
                int n = Integer.parseInt(s[0]);
                int temp[] = new int[n];
                for (int i = 0; i < n; i++)
                    temp[i] = Integer.parseInt(s[i + 1]);
                arr.add(temp);
                s = r.readLine().split(" ");
            }
            for (int i = 0; i < arr.size(); i += 2)
                f(arr.get(i), arr.get(i + 1));

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void f(int[] a1, int[] a2) {
        int sum1 = 0, sum2 = 0, n1 = a1.length, n2 = a2.length, ans = 0;
        int i = 0, j = 0;
        while (i < n1 && j < n2) {
            if (a1[i] > a2[j]) {
                sum2 += a2[j];
                j++;
            } else if (a1[i] < a2[j]) {
                sum1 += a1[i];
                i++;
            } else {
                ans += Math.max(sum1, sum2);
                sum1 = sum2 = 0;
                ans += a1[i];
                i++;
                j++;
            }
        }
        while (i < n1)
            sum1 += a1[i++];
        while (j < n2)
            sum2 += a2[j++];
        ans += Math.max(sum1, sum2);
    }
}
// Time complexity:O(n+m)
// Space compleixty : O(1)