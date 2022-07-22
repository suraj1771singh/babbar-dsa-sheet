import java.util.ArrayList;

class Solution1 {
    static ArrayList<String> list;

    public static void printAllSubseq(int ind, StringBuilder s, String str) {
        if (ind == str.length()) {
            list.add(new String(s));
            return;
        }
        // pick
        s.append(str.charAt(ind));
        printAllSubseq(ind + 1, s, str);
        // not pick
        s.deleteCharAt(s.length() - 1);
        printAllSubseq(ind + 1, s, str);
    }

    public static void main(String[] args) {
        list = new ArrayList<>();
        String str = "draco";
        printAllSubseq(0, new StringBuilder(), str);
        for (String s : list)
            System.out.print(s + " ");
    }
}
// Time complexity : O(2^n)
// Space complexity : O(n)