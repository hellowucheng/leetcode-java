package problems.M0005_最长回文子串;

import org.junit.Assert;
import org.junit.Test;

public class Solution {

    // 中心扩展法
    public String longestPalindrome(String s) {
        if (s.isEmpty()){
            return "";
        }
        int len = 0, start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            // 奇数位置扩展
            len = expand(i, i, s);
            if (len > end - start + 1) {
                start = i - len / 2;
                end = i + len / 2;
            }
            // 偶数位置扩展
            len = expand(i, i + 1, s);
            if (len > end - start + 1) {
                start = i + 1 - len / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expand(int l, int r, String s) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l -= 1;
            r += 1;
        }
        return r - l - 1;
    }

    @Test
    public void testLongestPalindrome(){
        Assert.assertEquals("", longestPalindrome(""));
        Assert.assertEquals("a", longestPalindrome("a"));
        Assert.assertEquals("aba", longestPalindrome("aba"));
        Assert.assertEquals("cdc", longestPalindrome("acdcb"));
    }
}
