import java.util.ArrayList;

class Solution {
    public static ArrayList<Integer> duplicates(int nums[], int n) {

        ArrayList<Integer> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            nums[nums[i] % n] += n;
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] / n > 1)
                res.add(i);
        }

        if (res.size() != 0)
            return res;
        res.add(-1);
        return res;

    }
}

// Time complexity :O(n)
// Space complexity :O(1)
