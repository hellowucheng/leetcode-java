package problems.H0076_最小覆盖子串;

import my.utils.Show;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    private class Elem {
        public char c;
        public int index;

        public Elem(char c, int index) {
            this.c = c;
            this.index = index;
        }

        @Override
        public String toString() {
            return "Elem{" +
                    "c=" + c +
                    ", index=" + index +
                    '}';
        }
    }

    public String minWindow(String s, String t) {
        Map<Character, Integer> needs = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            needs.compute(t.charAt(i), (k, oldVal) -> oldVal == null ? 1 : oldVal + 1);
        }

        List<Elem> filtered = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (needs.containsKey(s.charAt(i))) {
                filtered.add(new Elem(s.charAt(i), i));
            }
        }

        Map<Character, Integer> window = new HashMap<>();
        int start = 0, minLen = s.length() + 1, left = 0, matched = 0;
        for (Elem elem : filtered) {
            window.compute(elem.c, (k, oldVal) -> oldVal == null ? 1 : oldVal + 1);
            if (window.get(elem.c).intValue() == needs.get(elem.c).intValue()) {
                matched += 1;
            }
            while (matched == needs.size()) {
                if (elem.index - filtered.get(left).index + 1 < minLen) {
                    start = filtered.get(left).index;
                    minLen = elem.index - filtered.get(left).index + 1;
                }
                window.compute(filtered.get(left).c, (k, oldVal) -> oldVal - 1);
                if (window.get(filtered.get(left).c) < needs.get(filtered.get(left).c)) {
                    matched -= 1;
                }
                left += 1;
            }
        }
        return minLen <= s.length() ? s.substring(start, start + minLen) : "";
    }

    @Test
    public void testMinWindow(){
        Assert.assertEquals("", minWindow("abd", "abc"));
        Assert.assertEquals("", minWindow("", ""));
        Assert.assertEquals("abcd", minWindow("abcabcded", "abd"));
        Assert.assertEquals("abcde", minWindow("abcde", "ae"));
    }
}
