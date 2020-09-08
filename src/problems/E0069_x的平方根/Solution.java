package problems.E0069_x的平方根;

import org.junit.Assert;
import org.junit.Test;

public class Solution {

    public int mySqrt(int x) {
        // r初始为x, 很有可能会溢出！sqrt(Integer.MAX_VALUE)=46340
        int r = Math.min(x, 46340);
        while (r * r > x) {
            r = (r + x / r) / 2;
        }
        return r;
    }

    @Test
    public void testMySqrt(){
        Assert.assertEquals(1, mySqrt(1));
        Assert.assertEquals(1, mySqrt(2));
        Assert.assertEquals(2, mySqrt(4));
        Assert.assertEquals(3, mySqrt(9));
        Assert.assertEquals(46340, mySqrt(Integer.MAX_VALUE));
    }
}
