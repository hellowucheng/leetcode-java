package problems.M0003_无重复字符的最长子串;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    /* 滑动窗口 */
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> window = new HashMap<>();
        int leftBound = 0, maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (window.containsKey(s.charAt(i)) && window.get(s.charAt(i)) >= leftBound) {
                maxLength = Math.max(maxLength, i - leftBound);
                leftBound = window.get(s.charAt(i)) + 1;
            }
            window.put(s.charAt(i), i);
        }
        // 存在一直到最后一个字符都未发现重复的情况
        return Math.max(maxLength, s.length() - leftBound);
    }

    @Test
    public void testLengthOfLongestSubstring(){
        Assert.assertEquals(3, lengthOfLongestSubstring("abcabca"));
    }
}
