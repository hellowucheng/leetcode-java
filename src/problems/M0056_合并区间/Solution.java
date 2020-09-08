package problems.M0056_合并区间;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class Solution {

    public int[][] merge(int[][] intervals) {
        LinkedList<int[]> res = new LinkedList<>();
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        for (int[] interval : intervals) {
            if (res.isEmpty() || res.getLast()[1] < interval[0]) {
                res.addLast(interval);
            }
            else {
                res.getLast()[1] = Math.max(res.getLast()[1], interval[1]);
            }
        }
        return res.toArray(new int[0][0]);
    }

    @Test
    public void testMerge(){
        for (int[] ints : merge(new int[][]{{1, 3}, {2, 4}, {5, 6}})) {
            System.out.println(Arrays.toString(ints));
        }
        for (int[] ints : merge(new int[][]{})) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
