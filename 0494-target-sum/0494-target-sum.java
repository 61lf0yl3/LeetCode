class Solution {
    private int total;
    private int target;
    public int findTargetSumWays(int[] nums, int target) {
        this.target = target;
        int sum = 0;
        for (int num : nums) {
            total+=num;
        }
        return dp(nums, 0, 0, new Integer[nums.length][2*total+1]);
    }
    
    private int dp(int[] nums, int i, int sum, Integer[][] memo) {
        if (i == nums.length) {
            if (sum == target) {
                return 1;
            }
            return 0;
        } 
        if (memo[i][sum+total] == null) {
            memo[i][sum+total] = dp(nums, i+1, sum+nums[i], memo)+dp(nums, i+1, sum-nums[i], memo);
        }
        return memo[i][sum+total];
    }
}