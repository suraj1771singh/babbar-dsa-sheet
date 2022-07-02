
//Algo
//1) find limit for arrays upto when elements are in wronge array
//3) swap elements , put them in correct array
//4) sort both arrays

import java.util.Arrays;

class Solution {

    public void merge(int arr1[], int arr2[], int n, int m) {
        int l = n - 1, r = 0;
        for (; l >= 0 && r < m; l--, r++) {
            if (arr1[l] <= arr2[r])
                break;
        }
        // swap
        l++;
        r--;
        while (l < n && r >= 0) {
            int temp = arr1[l];
            arr1[l] = arr2[r];
            arr2[r] = temp;
            l++;
            r--;
        }
        // sort
        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }
}

// Time complexity :O((n+m)*log(n+m))
// Space complexity :O(1)