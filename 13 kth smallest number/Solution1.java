import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class TestClass {
    public static void main(String args[]) throws Exception {
        // BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String s[] = br.readLine().split(" ");
            int n = Integer.parseInt(s[0]);
            int q = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Long>> ranges = new ArrayList<>();
            while (n-- > 0) {
                s = br.readLine().split(" ");

                ArrayList<Long> temp = new ArrayList<>();
                for (int i = 0; i < s.length; i++)
                    temp.add(Long.parseLong(s[i]));
                ranges.add(temp);
            }
            long[] query = new long[q];

            for (int i = 0; i < q; i++)
                query[i] = Long.parseLong(br.readLine());

            f(ranges, query);
        }
    }

    public static void f(ArrayList<ArrayList<Long>> ranges, long[] query) {
        Collections.sort(ranges, (a, b) -> Long.compare(a.get(0), b.get(0)));
        ArrayList<ArrayList<Long>> res = new ArrayList<>();

        // get non overlapping ranges

        res.add(ranges.get(0));
        ArrayList<Long> last = res.get(0);
        for (int i = 1; i < ranges.size(); i++) {
            ArrayList<Long> curr = ranges.get(i);
            if (last.get(1) >= curr.get(0)) {
                last.set(1, Math.max(last.get(1), curr.get(1)));
            } else {
                res.add(curr);
                last = res.get(res.size() - 1);
            }
        }

        // res has all non overlapping ranges;
        long cum_sum[] = new long[res.size() + 1];
        cum_sum[0] = 0;
        for (int i = 1; i < cum_sum.length; i++) {
            ArrayList<Long> range = res.get(i - 1);
            long lowerLimit = range.get(0);
            long upperLimit = range.get(1);
            cum_sum[i] = cum_sum[i - 1] + upperLimit - lowerLimit + 1;
        }

        for (int i = 0; i < query.length; i++) {
            long k = query[i];
            int ind = binarySearch(k, cum_sum);
            if (ind >= cum_sum.length) {
                System.out.println("-1");
            } else {
                long ans = res.get(ind - 1).get(0) + (k - cum_sum[ind - 1] - 1);
                System.out.println(ans);
            }

        }
    }

    private static int binarySearch(long x, long[] a) {
        int l = 0, h = a.length - 1;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (a[mid] > x)
                h = mid - 1;
            else if (a[mid] < x)
                l = mid + 1;
            else
                return mid;
        }
        return l;
    }

}