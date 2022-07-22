
//----------RECCURSION
//NOTE : Check string notes

class Solution1 {

    long countPS(String str) {
        return f(0, str.length() - 1, str);
    }

    long f(int i, int j, String s) {
        if (i == j)
            return 1;
        if (i > j)
            return 0;
        if (s.charAt(i) == s.charAt(j))
            return 1 + f(i, j - 1, s) + f(i + 1, j, s);
        else
            return f(i, j - 1, s) + f(i + 1, j, s) - f(i + 1, j - 1, s);

    }

}
// Time complexity : exponential
// Space complexity : (s)