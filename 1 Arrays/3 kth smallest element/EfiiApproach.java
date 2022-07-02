import java.util.PriorityQueue;

//use Priority queue 

public class EfiiApproach {
    public static int kthSmallest(int[] arr, int l, int r, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int val : arr) {
            pq.offer(val);

            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }
}

//tc :O(n* log k)
// O(N) best case / O(N^2) worst case running time + O(1) memory
// insertion in priority queue takes O(log n)
