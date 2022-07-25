//--------------------NAIVE SOLUTION

class Solution {
    public long kthElement(int arr1[], int arr2[], int n, int m, int k) {

        int pos = 0;
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (arr1[i] > arr2[j]) {
                pos++;
                if (pos == k)
                    return arr2[j];
                j++;
            } else if (arr1[i] < arr2[j]) {
                pos++;
                if (pos == k)
                    return arr1[i];
                i++;
            } else {
                pos++;
                if (pos == k)
                    return arr1[i];
                pos++;
                if (pos == k)
                    return arr1[i];
                i++;
                j++;
            }
        }
        while (i < n) {
            pos++;
            if (pos == k)
                return arr1[i];
            i++;
        }
        while (j < m) {
            pos++;
            if (pos == k)
                return arr2[j];
            j++;
        }
        return -1;

    }
    // Time complexity : O(K)
    // Space compleixty : O(1)
}