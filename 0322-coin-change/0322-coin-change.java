class Solution {
    private Integer[] memo;
    private int[] coins;
    public int coinChange(int[] coins, int amount) {
        this.coins = coins;
        memo = new Integer[amount+1];
        return dp(amount);
    }
    
    private int dp(int i) {
        if (i < 0) {
            return -1;
        }
        if (i == 0) {
            return 0;
        }
        if (memo[i] != null) {
            return memo[i];
        }
        int ret = Integer.MAX_VALUE;
        for (int coin : coins) {
            int temp = dp(i-coin);
            if (temp != -1) {
                ret = Math.min(ret, temp+1);
            }
        }
        if (ret == Integer.MAX_VALUE) {
            ret = -1;
        }
        memo[i] = ret;
        return memo[i];
    }
}