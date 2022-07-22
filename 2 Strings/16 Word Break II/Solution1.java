import java.util.*;

//--------------RECURSION

class Solution1 {
    public List<String> ans;

    public List<String> wordBreak(String s, List<String> wordDict) {
        ans = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for (String str : wordDict)
            set.add(str);
        isPresent(0, set, s, new ArrayList<>());
        return ans;
    }

    public void isPresent(int ind, Set<String> set, String A, List<String> ds) {
        if (ind == A.length()) {
            ans.add(getString(ds));
            return;
        }
        for (int i = ind; i < A.length(); i++) {
            if (set.contains(A.substring(ind, i + 1))) {
                ds.add(A.substring(ind, i + 1));
                isPresent(i + 1, set, A, ds);
                ds.remove(ds.size() - 1);
            }
        }

    }

    public String getString(List<String> ds) {
        StringBuilder str = new StringBuilder();
        for (String s : ds)
            str.append(s + " ");
        return str.toString().trim();
    }
}
// Time complexity : O(2^n)
// Space complexity : O(n)