class Solution {
    static int minJumps(int[] arr) {
        int res = f(arr, 0);
        return res == (int) Math.pow(10, 9) ? -1 : res;
    }

    static int f(int[] arr, int index) {

        if (index >= arr.length - 1) {
            return 0;
        }
        int limit = arr[index];
        int minstep = (int) Math.pow(10, 9);
        for (int i = index + 1; i <= index + limit; i++) {
            int steps = 1 + f(arr, i);
            minstep = Math.min(minstep, steps);
        }
        return minstep;
    }
}