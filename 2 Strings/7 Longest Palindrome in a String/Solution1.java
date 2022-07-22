//------EFFICIENT APPROACH

//------ALGO
/*
 * 1) expand from center , consider each index as center 
 * 2) 2 cases
 *     case 1: odd length , expand taking as one center
 *     case 2 : even length, expand taking two index as center
 */

class Solution1 {

    static String longestPalin(String s) {
        int n = s.length(), len = 0, end = 0, start = 0;
        for (int i = 0; i < n; i++) {
            len = Math.max(expandFromCenter(i, i, s), expandFromCenter(i, i + 1, s));
            if (len > end - start + 1) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    static int expandFromCenter(int left, int right, String s) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
// Time complexity : O(n^2)
// Space complextiy : O(1)