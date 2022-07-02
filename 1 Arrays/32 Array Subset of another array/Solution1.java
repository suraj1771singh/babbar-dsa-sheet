import java.util.HashMap;

public class Solution1 {
    public String isSubset(long a1[], long a2[], long n, long m) {
        HashMap<Long, Integer> map = new HashMap<>();
        for (long i : a1)
            map.put(i, map.getOrDefault(i, 0) + 1);

        for (long i : a2) {
            if (map.containsKey(i) && map.get(i) > 0) {
                map.put(i, map.get(i) - 1);
            } else
                return "NO";
        }
        return "YES";
    }
}
// Time complexity : O(n)
// Space complexity : O(n)
