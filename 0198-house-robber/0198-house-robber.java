class Solution {
    public int rob(int[] nums) {
        return dp(nums, 0, new Integer[nums.length]);
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