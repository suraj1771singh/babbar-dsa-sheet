import java.util.Arrays;
import java.util.HashMap;

class Solution {
    int getPairsCount(int[] a, int n, int k) {
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : a) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for (int i : a) {
            int num = k - i;
            map.put(i, map.get(i) - 1);
            if (num > 0 && map.containsKey(num) && map.get(num) > 0)
                count += map.get(num);

        }
        return count;
    }
}

// Time complexity : O(n)
// Space complexity :O(n)