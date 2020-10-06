package problems.M0127_单词接龙;

import my.ds.Elem;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class Solution {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.equals(endWord)) {
            return wordList.contains(endWord) ? 1 : 0;
        }
        // 建立通配符字典
        Map<String, List<String>> nextSteps = new HashMap<>();
        for (String word : wordList) {
            for (int i = 0; i < word.length(); i++) {
                String key = new StringBuilder().append(word, 0, i).append('.').append(word, i+1, word.length()).toString();
                if (nextSteps.containsKey(key)) {
                    nextSteps.get(key).add(word);
                }
                else {
                    List<String> tmp = new ArrayList<>();
                    tmp.add(word);
                    nextSteps.put(key, tmp);
                }
            }
        }

        Set<String> visit = new HashSet<>();
        Queue<Elem<String>> queue = new LinkedList<>();
        queue.add(new Elem<>(beginWord, 1));
        while (!queue.isEmpty()) {
            Elem<String> curElem = queue.poll();
            if (curElem.value.equals(endWord)) {
                return curElem.index;
            }
            String word = curElem.value;
            for (int i = 0; i < word.length(); i++) {
                String key = new StringBuilder().append(word, 0, i).append('.').append(word, i+1, word.length()).toString();
                for (String nextWord : nextSteps.getOrDefault(key, new ArrayList<>())) {
                    if (!visit.contains(nextWord)) {
                        queue.add(new Elem<>(nextWord, curElem.index + 1));
                    }
                    visit.add(nextWord);
                }
            }
        }
        return 0;
    }

    @Test
    public void testLadderLength(){
        Assert.assertEquals(5, ladderLength("hit", "cog", Arrays.asList("hot","dot","dog","lot","log","cog")));
    }
}
