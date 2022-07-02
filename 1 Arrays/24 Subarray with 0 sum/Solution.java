import java.util.HashSet;

// Ago
// storing all possible sum and checking if sum is possible or not using set
// for analogy convert array into line graph :)
class Solution {

    static boolean findsum(int arr[], int n) {
        HashSet<Integer> set = new HashSet<>();
        int sum = 0;
        set.add(sum);
        for (int i : arr) {
            sum += i;
            if (set.contains(sum))
                return true;
            set.add(sum);
        }
        return false;
    }
}