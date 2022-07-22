//-------------------NAIVE APPROACH

class Solution1 {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        String ans = "";

        // find smallest element length
        int min_len = (int) Math.pow(10, 9);
        for (String s : strs)
            min_len = Math.min(min_len, s.length());

        // take first for comparision
        String first = strs[0];
        for (int j = 0; j < min_len; j++) {
            char c = first.charAt(j);
            for (int i = 1; i < n; i++)
                if (strs[i].charAt(j) != c)
                    return ans;
            ans += c;
        }
        return ans;

    }
}
// Time complexity : O(m*n)