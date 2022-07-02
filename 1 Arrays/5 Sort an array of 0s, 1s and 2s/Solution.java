class Solution {
    public static void sort012(int arr[], int n) {
        int a = 0, b = 0, c = 0;
        for (int i : arr) {
            if (i == 0)
                a++;
            else if (i == 1)
                b++;
            else
                c++;
        }
        int i = 0;
        while (a-- > 0) {
            arr[i] = 0;
            i++;
        }
        while (b-- > 0) {
            arr[i] = 1;
            i++;
        }
        while (c-- > 0) {
            arr[i] = 2;
            i++;
        }
    }


}

//Time complexity :O(2n)