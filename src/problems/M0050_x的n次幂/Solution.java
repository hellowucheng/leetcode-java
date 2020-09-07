package problems.M0050_x的n次幂;

import org.junit.Test;

public class Solution {

    public double myPow(double x, int n) {
        if (n == 0){
            return 1;
        }
        if (n == 1){
            return x;
        }
        double d = x;
        double rest = 1.0;
        if (n < 0){
            d = 1 / d;
            n = -1 * n;
            if (n == Integer.MIN_VALUE) {
                rest = d;
                n = Integer.MAX_VALUE;
            }
        }
        double half = myPow(d, n / 2);
        rest = rest * myPow(d, n % 2);
        return half * half * rest;
    }

    @Test
    public void testMyPow(){
        System.out.println(myPow(3, 0));
        System.out.println(myPow(2, 1));
        System.out.println(myPow(2, -1));
        System.out.println(myPow(2,3));
        System.out.println(myPow(2, -3));
        System.out.println(myPow(1, Integer.MIN_VALUE));
    }
}
