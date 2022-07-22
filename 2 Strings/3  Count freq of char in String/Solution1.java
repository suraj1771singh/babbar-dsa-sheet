
//-----------NAIVE APPROACH

class Solution1 {
    public void countChar(String s) {
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int count = 1;
            for (int j = i + 1; j < n; j++)
                if (s.charAt(j) == s.charAt(i))
                    count++;
            System.out.println(s.charAt(i) + " : " + count);
        }
    }
}

// Time complexity : O(n^2)
// Space complexity : O(1)