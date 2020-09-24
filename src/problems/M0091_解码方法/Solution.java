package problems.M0091_解码方法;

import org.junit.Assert;
import org.junit.Test;

public class Solution {

    // 动态规划
    public int numDecodings(String s) {
        if (s == null || s.isEmpty() || s.charAt(0) == '0') {
            return 0;
        }
        int[] dp = new int[s.length()];
        dp[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            if ((s.charAt(i-1) == '1') || (s.charAt(i-1)=='2' && s.charAt(i) <= '6' && s.charAt(i)>='0')){
                dp[i] = i >= 2 ? dp[i - 1] + dp[i - 2] : dp[i - 1] + 1;
            }
            else if (s.charAt(i) == '0') {
                if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2') {
                    dp[i] = dp[i - 1];
                }
                else {
                    return 0;
                }
            }
            else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[s.length() - 1];
    }

    @Test
    public void testNumDecodings(){
        Assert.assertEquals(0, numDecodings(""));
        Assert.assertEquals(0, numDecodings("000"));
        Assert.assertEquals(1, numDecodings("1"));
        Assert.assertEquals(2, numDecodings("12"));
        Assert.assertEquals(3981312, numDecodings("9371597631128776948387197132267188677349946742344217846154932859125134924241649584251978418763151253"));
    }
}
