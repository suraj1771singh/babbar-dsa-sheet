import java.util.HashMap;

//---Efficient Approach
// -----Algo
// use Hashmap to store freq
// check if freq>n/k then increase ans++;

public class Solution2 {
    public int countOccurence(int[] arr, int n, int k) {
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : arr)
            map.put(i, map.getOrDefault(i, 0) + 1);

        for (int i : map.keySet()) {
            if (map.get(i) > n / k)
                ans++;
        }
        return ans;
    }
}

// Time complexity : O(n)
// Space complexity : O(n)