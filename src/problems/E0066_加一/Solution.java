package problems.E0066_加一;

import org.junit.Test;

import java.util.Arrays;

public class Solution {

    public int[] plusOne(int[] digits) {
        int cin = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] += cin;
            cin = digits[i] / 10;
            digits[i] = digits[i] % 10;
        }
        // +1首部要插进位的情况, 无非是999 + 1 = 1000, 直接声明一个新数组(默认值全0), 再首位置1即可, 不需要复制
        if (cin > 0){
            digits = new int[digits.length + 1];
            digits[0] = cin;
        }
        return digits;
    }

    @Test
    public void testPlusOne(){
        System.out.println(Arrays.toString(plusOne(new int[]{0})));
        System.out.println(Arrays.toString(plusOne(new int[]{9, 9})));
        System.out.println(Arrays.toString(plusOne(new int[]{9, 9, 8, 9, 9, 9, 9})));
    }
}
