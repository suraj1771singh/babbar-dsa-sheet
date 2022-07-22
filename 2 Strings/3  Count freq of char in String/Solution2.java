import java.util.HashMap;

//-----------EFFICIENT APPROACH

class Solution2 {
    public void countChar(String s) {
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        // print all char freq
        for (Character c : map.keySet()) {
            System.out.println(c + " : " + map.get(c));
        }
    }
}

// Time complexity : O(n)
// Space complexity : O(k) ,k= [0,26]