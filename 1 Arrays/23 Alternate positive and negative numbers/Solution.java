import java.security.cert.TrustAnchor;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    void rearrange(int arr[], int n) {
        // make two queue for +ve and -ve numbers
        Queue<Integer> q_pos = new LinkedList<>();
        Queue<Integer> q_neg = new LinkedList<>();

        for (int i : arr) {
            if (i < 0)
                q_neg.add(i);
            else
                q_pos.add(i);
        }
        // update arr with altenate +ve and -ve numbers
        int k = 0;
        while (k < n) {
            if (!q_pos.isEmpty())
                arr[k++] = q_pos.poll();
            if (!q_neg.isEmpty())
                arr[k++] = q_neg.poll();
        }
    }
}