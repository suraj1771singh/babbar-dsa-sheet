import java.util.Arrays;

//--------------SPACE OPTIMIZED SOLUTION-----------------

public class Solution2 {
    static void sortBySetBitCount(Integer arr[], int n) {
        Arrays.sort(arr, (a, b) -> Integer.bitCount(b) - Integer.bitCount(a));
    }
}
// Time complexity : O(n)
// Spac compleixty : O(1)