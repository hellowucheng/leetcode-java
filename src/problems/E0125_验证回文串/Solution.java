package problems.E0125_验证回文串;

import org.junit.Assert;
import org.junit.Test;

public class Solution {

    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        int l = 0, r = s.length() - 1;
        s = s.toLowerCase();
        while (l < r) {
            while (l < r && !Character.isLetterOrDigit(s.charAt(l))) l++;
            while (l < r && !Character.isLetterOrDigit(s.charAt(r))) r--;
            if (s.charAt(l++) != s.charAt(r--)) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void testIsPalindrome() {
        Assert.assertEquals(true, isPalindrome("I :am :ma I"));
        Assert.assertEquals(false, isPalindrome("Hello oleH "));
        Assert.assertEquals(true, isPalindrome(",.!@#$%"));
    }

}
