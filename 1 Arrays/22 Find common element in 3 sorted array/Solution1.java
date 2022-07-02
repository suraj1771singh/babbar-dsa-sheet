import java.util.*;

class Solution1 {
    ArrayList<Integer> commonElements(int A[], int B[], int C[], int n1, int n2, int n3) {
        ArrayList<Integer> ans = f(A, B);
        int D[] = toArray(ans);
        ans = f(D, C);
        return ans;

    }

    public ArrayList<Integer> f(int a[], int b[]) {
        Set<Integer> set = new TreeSet<>();
        int n1 = a.length, n2 = b.length;
        int i = 0, j = 0;
        while (i < n1 && j < n2) {
            if (a[i] > b[j]) {
                j++;
            } else if (a[i] < b[j]) {
                i++;
            } else {
                set.add(a[i]);
                i++;
                j++;
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        list.addAll(set);
        return list;

    }

    public int[] toArray(ArrayList<Integer> a) {
        int temp[] = new int[a.size()];
        for (int i = 0; i < a.size(); i++) {
            temp[i] = a.get(i);
        }
        return temp;
    }
}

// Time complexity : O(n1 + n2 + n3)