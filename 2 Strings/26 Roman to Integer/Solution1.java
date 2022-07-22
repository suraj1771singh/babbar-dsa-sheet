import java.util.HashMap;

import java.util.*;;

//-----ALGO
/*
 * 1) First map character with corresponding values
 * 2) There are two cases 
 *     case 1: when s[i]<s[i+1]=> sum=sum- map.get(s[i])
 *     case 2: when s[i]>=s[i+1]=> sum=sum+ map.get(s[i]) 
 * 3) case 3 usually occurs , generally roman number are arranged in descending order
 *    of character
 */
class Solution1 {

    public int romanToDecimal(String s) {
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int sum = map.get(s.charAt(n - 1));
        for (int i = n - 2; i >= 0; i--) {
            if (map.get(s.charAt(i)) < map.get(s.charAt(i + 1)))
                sum -= map.get(s.charAt(i));
            else
                sum += map.get(s.charAt(i));
        }
        return sum;
    }
}
// Time complexity : O(n)
// Space complexity : O(1)