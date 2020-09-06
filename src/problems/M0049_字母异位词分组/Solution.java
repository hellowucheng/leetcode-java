package problems.M0049_字母异位词分组;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution {

    private String hashKey(String str) {
        int[] key = new int[26];
        for (int i = 0; i < str.length(); i++) {
            key[str.charAt(i) - 'a'] += 1;
        }
        return Arrays.toString(key);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> groups = new HashMap<>();
        for (String str : strs) {
            String key = hashKey(str);
            if (groups.containsKey(key)) {
                groups.get(key).add(str);
            }
            else {
                List<String> group = new ArrayList<>();
                group.add(str);
                groups.put(key, group);
            }
        }
        return new ArrayList<>(groups.values());
    }

    @Test
    public void testGroupAnagrams(){
        System.out.println(groupAnagrams(new String[]{}));
        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat", "bbat"}));
    }
}
