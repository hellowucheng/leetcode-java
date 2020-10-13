package problems.M0134_加油站;

import org.junit.Assert;
import org.junit.Test;

public class Solution {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0, curTank = 0, totalTank = 0;
        for (int i = 0; i < gas.length; i++) {
            totalTank += gas[i] - cost[i];
            curTank += gas[i] - cost[i];
            // curTank小于0表示从i无法到达i+1, 则下一个起点为i+1, 积累邮箱清空
            if (curTank < 0) {
                curTank = 0;
                start = i + 1;
            }
        }
        // 只要totalTank >= 0 一定有解
        return totalTank >= 0 ? start : -1;
    }

    @Test
    public void testCanCompleteCircuit() {
        Assert.assertEquals(3, canCompleteCircuit(new int[]{1,2,3,4,5}, new int[]{3,4,5,1,2}));
        Assert.assertEquals(-1, canCompleteCircuit(new int[]{2,3,4}, new int[]{3,4,3}));
        Assert.assertEquals(2, canCompleteCircuit(new int[]{2,3,5}, new int[]{3,4,3}));
    }
}
