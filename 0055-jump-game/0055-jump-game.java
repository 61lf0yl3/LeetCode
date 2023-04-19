class Solution {
    public boolean canJump(int[] nums) {
        return dfs(nums, 0, new Boolean[nums.length]);
    }
    
    private boolean dfs(int[] nums, int i, Boolean[] memo) {
        if (i >= nums.length-1) {
            return true;
        }
        
        if (memo[i] == null) {
            for (int j = 1; j <= nums[i]; j++) {
                if (dfs(nums, i+j, memo)) {
                    memo[i] = true;
                    return memo[i];
                }
            }
            memo[i] = false;
        }
        return memo[i];
    }
}