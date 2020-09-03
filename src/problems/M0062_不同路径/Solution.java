package problems.M0062_不同路径;

import org.junit.Assert;
import org.junit.Test;

public class Solution {

    public int uniquePaths(int m, int n) {
        // dp[i][j] 表示到达(i, j)位置的路径数
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0) {
                    dp[i][j] += dp[i-1][j];
                }
                if (j > 0){
                    dp[i][j] += dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }

    @Test
    public void testUniquePaths(){
        Assert.assertEquals(1, uniquePaths(1, 1));
        Assert.assertEquals(3, uniquePaths(3, 2));
        Assert.assertEquals(28, uniquePaths(7, 3));
    }
}
