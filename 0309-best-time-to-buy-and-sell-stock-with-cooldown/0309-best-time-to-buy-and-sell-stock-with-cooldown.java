class Solution {
    public int maxProfit(int[] prices) {
        return dfs(prices, new int[prices.length][2], 0, 0);
    }
    
    private int dfs(int[] prices, int[][] dp, int i, int j) {
        if (i >= prices.length) {
            return 0;
        }
        if (dp[i][j] == 0) {
            if (j == 0) {
                dp[i][j] = Math.max(dfs(prices, dp, i+1, j), dfs(prices, dp, i+1, 1)-prices[i]);
            } else {
                dp[i][j] = Math.max(dfs(prices, dp, i+1, j), dfs(prices, dp, i+2, 0)+prices[i]);
            }
        }
        return dp[i][j];
    }
}