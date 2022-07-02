//problem codestudio
// https://www.codingninjas.com/codestudio/problems/move-all-negative-numbers-to-beginning-and-positive-to-end_1112620?leftPanelTab=1

import java.util.*;

class Solution {
    public static ArrayList<Integer> separateNegativeAndPositive(ArrayList<Integer> nums) {
        int j = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) < 0) {
                swap(i, j, nums);
                j++;
            }
        }
        return nums;
    }

    public static void swap(int i, int j, ArrayList<Integer> nums) {
        int temp = nums.get(i);
        nums.set(i, nums.get(j));
        nums.set(j, temp);
    }
}

// Time Complexity :O(n)