
//----------EFFICIENT APPROACH

//------ALGO
/*
 * 1) use moore's voting algo
 * 2) vote up when in case of 0 and vote down in case of 1
 * 3) increment ans when vote =0
 * 3) return -1 if vote!=0 after complete traversal of string 
 */

class Solution1 {
    public static int maxSubStr(String str) {
        int n = str.length(), vote = 0, ans = 0;
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == '0')
                vote++;
            else
                vote--;
            if (vote == 0)
                ans++;
        }
        if (vote == 0)
            return ans;
        return -1;
    }
}
// Time complexity : O(n)
// Space complexity : O(1)