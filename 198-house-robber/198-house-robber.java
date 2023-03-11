class Solution {
    int[] nums;
    Integer[] memo;
    public int rob(int[] nums) {
        this.nums = nums;
        this.memo = new Integer[nums.length];
        return dfs(nums.length-1);
    }
    
    private int dfs(int i) {
        if (i < 0) {
            return 0;
        }
        if (memo[i] == null) {
            memo[i] = Math.max(dfs(i-2)+nums[i], dfs(i-1));
        }
        return memo[i];
    }
}