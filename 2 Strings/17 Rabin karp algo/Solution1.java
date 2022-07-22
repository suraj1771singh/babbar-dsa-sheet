class Solution1 {
    private static final int MOD = (int) Math.pow(10, 7);
    private static final int d = 26;

    public int strStr(String haystack, String needle) {

        int m = needle.length(), n = haystack.length();
        int needle_hash = getHashCode(needle, m);
        int curr_hash = getHashCode(haystack, m);

        if (curr_hash == needle_hash && needle.equals(haystack.substring(0, m)))
            return 0;

        for (int i = 1; i <= n - m; i++) {
            curr_hash = rollHash(curr_hash, i, i + m - 1, m - 1, haystack);
            if (curr_hash == needle_hash && needle.equals(haystack.substring(i, i + m)))
                return i;
        }
        return -1;
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
        return hash;
    }

}
/*
 * Time complexity
 * ---> Avg : O(m+n)
 * ---> worst : O(m*n)
 * 
 * Space complexity : O(1)
 */