import java.util.HashMap;

//-----ALGO
// using hashmap for searching we can reduce one nested loop 

public class Solution2 {
    public static boolean find3Numbers(int a[], int n, int x) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : a)
            map.put(i, map.getOrDefault(i, 0) + 1);

        for (int i = 0; i < n; i++) {
            int val1 = map.get(a[i]);
            map.put(a[i], 0);
            for (int j = i + 1; j < n; j++) {
                int val2 = map.get(a[j]);
                map.put(a[j], 0);
                if (map.containsKey(x - a[i] - a[j]) && map.get(x - a[i] - a[j]) > 0) {

                    return true;
                }
                map.put(a[j], val2);
            }
            map.put(a[i], val1);
        }
        return false;
    }
}

// Time complexity :O(n^2)
// Space complexity :O(n)
