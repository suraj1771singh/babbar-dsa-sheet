import java.util.*;

class Bit implements Comparable<Bit> {
    int num;
    int count;

    Bit(int a, int b) {
        num = a;
        count = b;
    }

    @Override
    public int compareTo(Bit o) {
        return o.count - this.count;

    }
}

class Solution1 {
    static void sortBySetBitCount(Integer arr[], int n) {
        ArrayList<Bit> list = new ArrayList<>();
        for (int i : arr) {
            int num = i;
            int count = 0;
            while (i > 0) {
                i = i & (i - 1);
                count++;
            }
            list.add(new Bit(num, count));
        }
        Collections.sort(list);
        for (int i = 0; i < n; i++)
            arr[i] = list.get(i).num;
    }
}
// Time complexity : O(n*log n)
// Spac compleixty : O(n)
