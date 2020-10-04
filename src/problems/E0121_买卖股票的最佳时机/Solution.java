package problems.E0121_买卖股票的最佳时机;

import org.junit.Test;

public class Solution {

    public int maxProfit(int[] prices) {
        int maxPro = 0, minPri = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            minPri = Math.min(minPri, prices[i]);
            maxPro = Math.max(maxPro, prices[i] - minPri);
        }
        return maxPro;
    }

    @Test
    public void testMaxProfit() {
        System.out.println(maxProfit(new int[]{1, 1, 2, 3, 5}));
        System.out.println(maxProfit(new int[]{5, 4, 3, 2, 1}));
    }
}
