import java.util.*;

//--------------EFFICIENT SOLUTION
//---using HashMaps

public class Solution2 {
    public boolean findPair(int arr[], int size, int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : arr)
            map.put(i, map.getOrDefault(i, 0) + 1);
        for (int ele : arr) {
            int a = n + ele;
            if (n == 0 && map.get(a) < 2)
                continue;
            if (map.containsKey(a))
                return true;
        }
        return false;
    }
}
// Time complexity : O(n)
// Space complexity : O(n)
