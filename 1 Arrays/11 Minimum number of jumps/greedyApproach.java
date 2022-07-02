
//most optimal approach

public class greedyApproach {
    static int minJumps(int[] arr) {
        int jumps = 0, curEnd = 0, curFarthest = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            curFarthest = Math.max(curFarthest, i + arr[i]);
            if (i == curEnd) {
                jumps++;
                if (i == curFarthest)
                    // when current index is the only farthest position, we can't move
                    return -1;
                curEnd = curFarthest;
            }
        }
        return jumps;
    }
}

// Time complexity :O(n)