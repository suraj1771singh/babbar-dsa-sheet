import java.util.Arrays;
import java.util.HashMap;

// ----------------------NAIVE SOLUTION
class Solution1 {

    public int minSwaps(int nums[]) {
        int n = nums.length, ans = 0;
        int copy[] = Arrays.copyOf(nums, n);
        HashMap<Integer, Integer> map = new HashMap<>();

        // maping number with its original index
        for (int i = 0; i < n; i++)
            map.put(nums[i], i);

        // sorting copied array;
        Arrays.sort(copy);

        // swaping each element to its correct index using sorted copy array
        for (int i = 0; i < n; i++) {
            if (nums[i] != copy[i]) {
                int ind = map.get(copy[i]);
                map.put(nums[i], ind);
                swap(ind, i, nums);
                ans++;
            }
        }
        return ans;
    }

    private void swap(int i, int j, int[] a) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
// Time complexity : O(n*log n)
// Space complexity : O(n)1