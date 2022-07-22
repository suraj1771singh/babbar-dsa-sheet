class Solution1 {
    public boolean isRotationString(String s1, String s2) {
        int i = 0, j = 0;
        int n = s1.length(), m = s2.length();

        // get start point
        while (i < n) {
            if (s1.charAt(i) != s2.charAt(j)) {
                i++;
                j++;
            }
        }

    }
}