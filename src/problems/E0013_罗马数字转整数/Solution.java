package problems.E0013_罗马数字转整数;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        if (s == null || s.isEmpty()){
            return 0;
        }
        int res = map.get(s.charAt(s.length() - 1));
        for (int i = s.length() - 2; i >= 0; i--) {
            if (map.get(s.charAt(i)) >= map.get(s.charAt(i + 1))) {
                res += map.get(s.charAt(i));
            }
            else {
                res -= map.get(s.charAt(i));
            }
        }
        return res;
    }

    @Test
    public void testRomanToInt(){
        Assert.assertEquals(0, romanToInt(""));
        Assert.assertEquals(5, romanToInt("V"));
        Assert.assertEquals(6, romanToInt("VI"));
        Assert.assertEquals(4, romanToInt("IV"));
    }
}
