
//here we are assuming that we are allowed to change the given array

public class Solution2 {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int elt = Math.abs(nums[i]);
            int index = elt - 1;
            if (nums[index] < 1) {
                return elt;// that element is already occured
            }
            nums[index] = nums[index] * -1;
        }
        return -1;
    }
}

// Time complexity :O(n)
// Space complexity :O(1)