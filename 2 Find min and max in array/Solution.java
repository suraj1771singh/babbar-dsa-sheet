
class pair {
    long first, second;

    public pair(long first, long second) {
        this.first = first;
        this.second = second;
    }
}

class Compute {
    static pair getMinMax(long a[], long n) {
        long maxi = 0;
        long mini = (long) Math.pow(10, 11);
        for (long i = 0; i < n; i++) {
            maxi = Math.max(maxi, a[(int) i]);
            mini = Math.min(mini, a[(int) i]);
        }
        pair ans = new pair(mini, maxi);
        return ans;
    }
}
