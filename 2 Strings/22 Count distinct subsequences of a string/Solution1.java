import java.util.HashSet;

//------------RECURSIVE(NAIVE APPROACH)

public class Solution1 {
    static HashSet<String> set;

    int distinctSubsequences(String s) {
        set = new HashSet<>();
        return f(s.length() - 1, s, new StringBuilder());
    }

    int f(int ind, String s, StringBuilder seq) {
        if (ind < 0) {
            if (set.contains(seq.toString())) {
                return 0;
            } else {
                set.add(new String(seq.toString()));
                return 1;
            }
        }
        seq.append(s.charAt(ind));
        int pick = f(ind - 1, s, seq);
        seq.deleteCharAt(seq.length() - 1);
        int not_pick = f(ind - 1, s, seq);
        return pick + not_pick;
    }

}
// Time complexity : O(2^n)
// Space complexity : O(n)+O(n)