package problems.E0118_杨辉三角;

import my.utils.Show;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0) {
            return result;
        }
        result.add(new ArrayList<>());
        result.get(0).add(1);
        for (int i = 1; i < numRows; i++) {
            result.add(new ArrayList<>());
            result.get(i).add(1);
            for (int j = 1; j < i; j++) {
                result.get(i).add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
            }
            result.get(i).add(1);
        }
        return result;
    }

    @Test
    public void testGenerate() {
        System.out.println(generate(1));
        System.out.println(generate(2));
        System.out.println(generate(3));
        System.out.println(generate(4));
    }

}
