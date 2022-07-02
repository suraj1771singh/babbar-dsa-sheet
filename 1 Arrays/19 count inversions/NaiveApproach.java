class Solution {

    static long inversionCount(long arr[], long n) {
        int count = 0;
        for (long i = 0; i < n; i++) {
            for (long j = i + 1; j < n; j++) {
                if (arr[(int) i] > arr[(int) j]) {
                    count++;
                }
            }
        }
        return count;
    }

}