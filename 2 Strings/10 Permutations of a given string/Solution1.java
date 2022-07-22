import java.util.*;
//----NIAVE APPROACH

//--backtraking

class Solution1 {
    List<String> ans;

    public List<String> find_permutation(String s) {
        ans = new ArrayList<>();
        permute(0, new StringBuilder(s));
        return ans;
    }

    public void permute(int l, StringBuilder s) {
        if (l == s.length()) {
            ans.add(new String(s));
            return;
        }
        for (int i = l; i < s.length(); i++) {
            swap(l, i, s);
            permute(l + 1, s);
            swap(l, i, s);
        }
    }

    public void swap(int i, int j, StringBuilder s) {
        char temp = s.charAt(i);
        s.setCharAt(i, s.charAt(j));
        s.setCharAt(j, temp);
    }
}
