package problems.H0084_柱状图中最大的矩形;

import my.ds.Elem;
import my.ds.SegmentTree;
import org.junit.Assert;
import org.junit.Test;

public class Solution2 {

    private int helper(int i, int j, int[] heights, SegmentTree st) {
        if (i > j) {
            return 0;
        }
        else if (i == j) {
            return heights[i];
        }
        else {
            Elem minRect = st.search(i, j);
            return Math.max(minRect.value * (j - i + 1), Math.max(helper(i, minRect.index - 1, heights, st), helper(minRect.index + 1, j, heights, st)));
        }
    }

    public int largestRectangleArea(int[] heights) {
        if(heights == null || heights.length == 0){
            return 0;
        }
        SegmentTree st = new SegmentTree(heights, (a, b) -> a.value <= b.value ? a : b);
        return helper(0, heights.length-1, heights, st);
    }

    @Test
    public void testLargestRectangleArea(){
        Assert.assertEquals(5, largestRectangleArea(new int[]{1,2,1,2,3}));
        Assert.assertEquals(1, largestRectangleArea(new int[]{1}));
        Assert.assertEquals(3, largestRectangleArea(new int[]{1,3}));
    }

}
