import java.util.*;

//------------NAIVE SOLUTION (Iterative solution)
//--------ALGO
/*
 * 1) we have to go in straight line and can go in 8 directions
 */

class Solution {
    public int[][] searchWord(char[][] grid, String word) {
        ArrayList<int[]> list = new ArrayList<>();
        int n = grid.length, m = grid[0].length;
        int dirs[][] = { { -1, 0 }, { 0, -1 }, { -1, -1 }, { -1, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 }, { 0, 1 } };
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (grid[i][j] == word.charAt(0) && isValid(i, j, dirs, grid, word))
                    list.add(new int[] { i, j });
        // convert list to arr
        int[][] ans = new int[list.size()][2];
        for (int i = 0; i < ans.length; i++) {
            ans[i][0] = list.get(i)[0];
            ans[i][1] = list.get(i)[1];
        }
        return ans;
    }

    private boolean isValid(int i, int j, int[][] dirs, char[][] grid, String word) {
        int n = grid.length, m = grid[0].length;
        for (int[] direction : dirs) {
            int new_i = i;
            int new_j = j;
            int c = 0;
            while (new_i >= 0 && new_j >= 0 && new_j < m && new_i < n && c < word.length()
                    && grid[new_i][new_j] == word.charAt(c)) {
                new_i += direction[0];
                new_j += direction[1];
                c++;
            }
            if (c == word.length())
                return true;
        }
        return false;
    }
}
// Time complexity : O(n*m*k) and k >=8
// Space complexity : O(1)