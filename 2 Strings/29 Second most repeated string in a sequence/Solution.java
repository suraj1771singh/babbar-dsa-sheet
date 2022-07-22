import java.util.*;

// ----------EFFICIENT APPROACH
class Solution {
    String secFrequent(String arr[], int N) {

        HashMap<String, Integer> map = new HashMap<>();
        for (String s : arr)
            map.put(s, map.getOrDefault(s, 0) + 1);

        String max = arr[0];
        String second_max = "";

        for (String s : map.keySet()) {
            if (map.get(max) < map.get(s)) {
                second_max = max;
                max = s;
            } else if (map.get(max) != map.get(s)) {
                if (second_max == "" || map.get(second_max) < map.get(s))
                    second_max = s;
            }
        }
        return second_max;
    }
}
// Time complexity : O(n)
// Space complexity : O(1)