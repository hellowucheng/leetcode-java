package problems.E0020_有效的括号;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Solution {

    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        LinkedList<Character> stack = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '['){
                stack.addLast(c);
            }
            else {
                if (stack.isEmpty() || stack.pollLast() != map.get(c)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    @Test
    public void testIsValid(){
        Assert.assertEquals(true, isValid(""));
        Assert.assertEquals(true, isValid("()"));
        Assert.assertEquals(true, isValid("({[]})"));
        Assert.assertEquals(false, isValid("([)]"));
        Assert.assertEquals(false, isValid("["));
        Assert.assertEquals(false, isValid(")"));
    }
}
