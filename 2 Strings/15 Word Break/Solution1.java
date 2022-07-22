import java.util.*;
//--------NAIVE SOLUTION (Recursion)

class Solution1 {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        for (String str : wordDict)
            set.add(str);
        return isPresent(0, set, s);
    }

    public static boolean isPresent(int ind, Set<String> set, String A) {
        if (ind == A.length())
            return true;
        for (int i = ind; i < A.length(); i++) {
            if (set.contains(A.substring(ind, i + 1))) {
                if (isPresent(i + 1, set, A))
                    return true;
            }
        }
        return false;
    }
}
// Time complexity : O(2^n) : n=string.length();
// Space complexity : O(n);