class Compute {

    public void rotate(int a[], int n) {
        int last = a[0];
        a[0] = a[n - 1];
        for (int i = 1; i < n; i++) {
            int new_last = a[i];
            a[i] = last;
            last = new_last;

        }

    }
}

// Time Complexit :O(n)