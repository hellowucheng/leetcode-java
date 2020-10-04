package problems.E0122_买卖股票的最佳时机II;

import org.junit.Test;

public class Solution {

    public int maxProfit(int[] prices) {
        int maxPro = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxPro += prices[i] - prices[i - 1];
            }
        }
        return maxPro;
    }

    @Test
    public void testMaxProfit() {
        System.out.println(maxProfit(new int[]{1, 2, 3}));
        System.out.println(maxProfit(new int[]{5, 2, 3, 6}));
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
