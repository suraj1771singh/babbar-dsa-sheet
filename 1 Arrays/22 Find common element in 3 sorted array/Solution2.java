import java.util.*;

public class Solution2 {
    ArrayList<Integer> commonElements(int A[], int B[], int C[], int n1, int n2, int n3) {
        ArrayList<Integer> ans = new ArrayList<>();
        // three sets for three arrays
        Set<Integer> set1 = getSet(A);
        Set<Integer> set2 = getSet(B);
        Set<Integer> set3 = getSet(C);

        for (Integer i : set1) {
            if (set2.contains(i) && set3.contains(i))
                ans.add(i);
        }
        return ans;
    }

    public Set<Integer> getSet(int[] a) {
        Set<Integer> set = new TreeSet<>();
        for (int i : a)
            set.add(i);
        return set;
    }
}
