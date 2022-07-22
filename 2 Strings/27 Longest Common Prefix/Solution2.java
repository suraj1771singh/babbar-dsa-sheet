import java.util.Arrays;

//--------------OPTIMZED SOLUTION
//--------ALGO
/*
 * 1) Sort the array of string
 * 2) find longest common prefix in first and last string
 */

public class Solution2 {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String first = strs[0], last = strs[strs.length - 1];
        int i = 0;
        while (i < first.length() && first.charAt(i) == last.charAt(i))
            i++;
        return i == 0 ? "" : first.substring(0, i);
    }
}
// Time complexity : O(n*logn )
