package problems.E0070_爬楼梯;

import org.junit.Assert;
import org.junit.Test;

public class Solution {

    public int climbStairs(int n) {
        if (n <= 2){
            return n;
        }
        int fib1 = 1, fib2 = 2;
        for (int i = 2; i < n; i++) {
            int tmp = fib1;
            fib1 = fib2;
            fib2 = tmp + fib2;
        }
        return fib2;
    }

    @Test
    public void testClimbStairs(){
        Assert.assertEquals(0, climbStairs(0));
        Assert.assertEquals(3, climbStairs(3));
        Assert.assertEquals(5, climbStairs(4));
    }
}
