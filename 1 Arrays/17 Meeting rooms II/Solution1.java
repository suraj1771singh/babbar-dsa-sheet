import java.util.Arrays;
import java.util.List;

class Interval {
    int start, end;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

class Solution1 {
    public int minMeetingRooms(List<Interval> intervals) {
        int count = 0, maxi = 0, n = intervals.size();
        int[] start = new int[n];
        int[] end = new int[n];
        for (int i = 0; i < n; i++) {
            start[i] = intervals.get(i).start;
            end[i] = intervals.get(i).end;
        }
        Arrays.sort(start);
        Arrays.sort(end);

        // using two pointer
        int s = 0, e = 0;
        while (s < n && e < n) {
            if (start[s] < end[e]) {
                count++;
                s++;
            } else {
                count--;
                e++;
            }
            maxi = Math.max(maxi, count);
        }
        return maxi;

    }
}

// Time complexity :O(n * logn)