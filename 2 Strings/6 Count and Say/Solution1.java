class Solution {
    public String countAndSay(int n) {
        if (n == 1)
            return "1";
        String str = countAndSay(n - 1);
        StringBuilder s = new StringBuilder();
        char prev = str.charAt(0);
        int count = 1;
        for (int i = 1; i < str.length(); i++) {
            if (prev != str.charAt(i)) {
                s.append(count);
                s.append(prev);
                prev = str.charAt(i);
                count = 1;
            } else
                count++;
        }
        s.append(count);
        s.append(prev);
        return s.toString();

    }
}

// Time complexity : O(n)
// Auxiallry SC : O(n)