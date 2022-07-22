
public class RabinKarpAlgo {

    private static final int MOD = 107;
    private static final int d = 10;

    public static void RabinKarpAlgo(String pat, String txt) {
        int m = pat.length(), n = txt.length(), count = 0;
        int pat_hash = getHashCode(pat, m);
        int curr_hash = getHashCode(txt, m);
        System.out.println(pat_hash);

        if (curr_hash == pat_hash && pat.equals(txt.substring(0, m))) {
            count++;
            System.out.println("Found at index : " + 0);
        }
        for (int i = 1; i <= n - m; i++) {
            curr_hash = rollHash(curr_hash, i, i + m - 1, m - 1, txt);
            System.out.println(i + ":" + (i + m - 1) + ":" + curr_hash);
            if (curr_hash == pat_hash && pat.equals(txt.substring(i, i + m))) {
                count++;
                System.out.println("Found at index : " + i);
            }
        }
        if (count == 0)
            System.out.println("NOT FOUND !");
    }

    public static int rollHash(int prev_hash, int i, int j, int k, String s) {
        int hash = 0;
        int a = (int) s.charAt(i - 1) - 96;
        int b = (int) s.charAt(j) - 96;
        hash = (((prev_hash - (int) Math.pow(d, k) * a) * d) % MOD + b) % MOD;
        return hash;
    }

    public static int getHashCode(String s, int limit) {
        int hash = 0, n = limit;

        for (int i = n - 1; i >= 0; i--) {
            int a = (int) s.charAt(i) - 96;
            hash += ((int) Math.pow(d, n - 1 - i) * a) % MOD;
        }
        return hash % MOD;
    }

    public static void main(String[] args) {
        RabinKarpAlgo("aabaaac", "aabaaabaaac");
    }
}
/*
 * Time complexity
 * ---> Avg : O(m+n)
 * ---> worst : O(m*n)
 * 
 * Space complexity : O(1)
 */
