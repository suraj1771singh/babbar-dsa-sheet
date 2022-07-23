import java.util.*;
//-----------EFFICIENT SOLUTION
//--------ALGO
/*
1) find cummlative sum and put it into map. 
2) and on every iteration check if sum is available or not in map
*/

class Solution2 {

    public static long findSubarray(long[] arr, int n) {
        long ans = 0, sum = 0;
        Map<Long, Integer> map = new HashMap<>();
        map.put(0L, 1);
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (map.containsKey(sum))
                ans += map.get(sum);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }
}
// Time complexity : O(n)
// Space compleixty : O(n)