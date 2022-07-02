import java.util.ArrayList;
import java.util.HashMap;

//---Efficient Approach in terms of space
// Fact : ans would be in range [1,k-1], refer this https://www.geeksforgeeks.org/given-an-array-of-of-size-n-finds-all-the-elements-that-appear-more-than-nk-times/
// -----Algo
// use Hashmap which can store freq of atmost k-1 elements (we say them as candidates) : SC :O(k)
// add elements and increase their freq counter till map.size()<k-1 
// edge case when map.size()==k-1 and new element arrives , in that case decrease freq of all and remove any whose freq count decrease to 0
// finally we have potential candidates , now check is there freq is actually > n/k or not :TC O(n*k)    

public class Solution3 {
    public int countOccurence(int[] arr, int n, int k) {
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            if (map.size() >= k - 1 && !map.containsKey(i)) {
                // decrease freq of all k-1 elements
                ArrayList<Integer> list = new ArrayList<>();
                for (int num : map.keySet()) {
                    int freq = map.get(num);
                    if (freq == 1) {
                        // remove it , because it wil turn down to 0 on decreasing
                        list.add(num);
                    } else
                        map.put(num, freq - 1);
                }
                map.keySet().removeAll(list);

            } else {
                map.put(i, map.getOrDefault(i, 0) + 1);
            }
        }
        // now we have all potential candidates which need to be verified
        for (int num : map.keySet()) {
            int count = 0;
            for (int i : arr) {
                if (num == i)
                    count++;
            }
            if (count > n / k)
                ans++;
        }
        return ans;
    }
}

// Time complexity : O(n*k)
// Space complexity : O(k)
