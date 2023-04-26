class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length+2];
        for (int i = nums.length-1; i >= 0; i--) {
            dp[i] = Math.max(nums[i]+dp[i+2], dp[i+1]);
        }
        return dp[0];
    }
    
    private int dp(int[] nums, int i, Integer[] memo) {
        if (i >= nums.length) {
            return 0;
        }
        if (memo[i] == null) {
            memo[i] = Math.max(nums[i]+dp(nums, i+2, memo), dp(nums, i+1, memo));
        }
        return memo[i];
    }
}