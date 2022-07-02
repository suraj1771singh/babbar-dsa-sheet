
// Good article
// https://www.geeksforgeeks.org/factorial-large-number/

import java.util.ArrayList;

class Solution {
    static ArrayList<Integer> factorial(int N) {
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(1);
        for (int i = 2; i <= N; i++) {
            multiply(ans, i);
        }
        reverse(ans);
        return ans;
    }

    private static void multiply(ArrayList<Integer> ans, int x) {
        int carry = 0;
        for (int i = 0; i < ans.size(); i++) {
            int a = ans.get(i) * x + carry;
            ans.set(i, a % 10);
            carry = a / 10;
        }
        while (carry != 0) {
            ans.add(carry % 10);
            carry /= 10;
        }
    }

    private static void reverse(ArrayList<Integer> a) {
        int l = 0, h = a.size() - 1;
        while (l < h) {
            // swapping
            int temp = a.get(l);
            a.set(l, a.get(h));
            a.set(h, temp);
            l++;
            h--;
        }
    }
}