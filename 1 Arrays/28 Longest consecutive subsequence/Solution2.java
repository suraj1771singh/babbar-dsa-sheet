import java.util.*;

//------ALGO
// throw all elements to map and we will get unique elements
// traverse through keySet()
// for each element check for smaller and larger numbers in map and increase counter
// keep track for maximum count 

public class Solution2 {
    static int findLongestConseqSubseq(int arr[], int N) {
        Map<Integer, Integer> map = new HashMap<>();
        // pushing all values to map
        for (int i : arr)
            map.put(i, 1);

        int ans = 1;

        // traversin to map keys(arr elements)
        for (int key : map.keySet()) {

            if (map.get(key) == 1) {
                map.put(key, 0);
                int num = key - 1, count = 1;
                // check for smaller numbers
                while (map.containsKey(num) && map.get(num) != 0) {
                    map.put(num, 0);
                    count++;
                    num--;
                }
                // check for larger numbers
                num = key + 1;
                while (map.containsKey(num) && map.get(num) != 0) {
                    map.put(num, 0);
                    count++;
                    num++;
                }
                ans = Math.max(ans, count);
            }
        }
        return ans;

    }
}

// Time complexity : O(n);
// Space complexity : O(n)
