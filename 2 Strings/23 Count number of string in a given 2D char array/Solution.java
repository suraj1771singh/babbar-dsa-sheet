
class Solution {
    static boolean visited[][];

    public static int internalSearch(String needle, String[] matrix) {
        int r = matrix.length, c = matrix[0].length();
        visited = new boolean[r][c];
        int ans = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (needle.charAt(0) == matrix[i].charAt(j))
                    ans += search(i, j, 0, needle, matrix);
            }
        }
        return ans;

    }

    public static int search(int i, int j, int ind, String needle, String[] matrix) {

        if (ind == needle.length()) {

            return 1;
        }

        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length()) {

            return 0;
        }

        if (matrix[i].charAt(j) != needle.charAt(ind) || visited[i][j]) {

            return 0;
        }

        // search in all direction
        visited[i][j] = true;
        int left = search(i, j - 1, ind + 1, needle, matrix);
        int up = search(i - 1, j, ind + 1, needle, matrix);
        int right = search(i, j + 1, ind + 1, needle, matrix);
        int down = search(i + 1, j, ind + 1, needle, matrix);
        visited[i][j] = false;
        return left + up + right + down;
    }

    public static void main(String[] args) {
        String needle = "MAGIC";
        String input[] = { "BBABBM", "CBMBBA",
                "IBABBG", "GOZBBI",
                "ABBBBC", "DCIGAD" };
        System.out.println(internalSearch(needle, input));
    }
}