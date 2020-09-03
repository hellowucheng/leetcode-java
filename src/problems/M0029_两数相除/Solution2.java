package problems.M0029_两数相除;

import org.junit.Assert;
import org.junit.Test;

public class Solution2 {

    public int divide(int dividend, int divisor) {
        // int整数除法溢出情况只有一种
        if (divisor == -1 && dividend == Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        }
        int res = 0, count = 0;
        boolean negative = (divisor > 0) ^ (dividend > 0);
        long divr = Math.abs((long) divisor), divd = Math.abs((long) dividend);
        while (divr <= divd) {
            count += 1;
            divr <<= 1;
        }
        while (count > 0){
            count -= 1;
            divr >>= 1;
            if (divr <= divd){
                divd -= divr;
                res += (1 << count);
            }
        }
        return negative ? -res : res;
    }

    @Test
    public void testDivide(){
        Assert.assertEquals(3, divide(10, 3));
        Assert.assertEquals(10, divide(10, 1));
        Assert.assertEquals(-1, divide(1, -1));
        Assert.assertEquals(-2, divide(7, -3));
        Assert.assertEquals(0, divide(0, 100));
        Assert.assertEquals(0, divide(0, -100));
        Assert.assertEquals(Integer.MAX_VALUE, divide(Integer.MIN_VALUE, -1));
        System.out.println(divide(Integer.MAX_VALUE, 1));
        System.out.println(divide(Integer.MIN_VALUE, 1));
    }
}
