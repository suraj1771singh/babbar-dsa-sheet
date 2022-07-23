
//-------------NAIVE SOLUTION

class Solution1 {
    public boolean findPair(int arr[], int size, int n) {
        for (int i = 0; i < size; i++) {
            int a = arr[i] + n;
            for (int j = 0; j < size; j++)
                if (i != j && arr[j] == a)
                    return true;
        }
        return false;
    }
}
// Time complexity : O(n^2)
// Space complexity : O(1)