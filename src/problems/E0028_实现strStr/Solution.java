package problems.E0028_实现strStr;

import org.junit.Test;

public class Solution {

    public int strStr(String haystack, String needle) {
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            if (haystack.substring(i, i + needle.length()).equals(needle)) {
                return i;
            }
        }
        return -1;
    }

    @Test
    public void testStrStr(){
        System.out.println(strStr("hello", ""));
        System.out.println(strStr("hello", "lo"));
        System.out.println(strStr("hello", "h"));
    }
}
