class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length+2][2];
        for (int i = prices.length-1; i >=0; i--) {
            for (int j = 1; j >= 0; j--) {
                if (j == 0) {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i+1][1]-prices[i]);
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i+2][0]+prices[i]);
                }
            }
        }
            
        return dp[0][0];
    }
}