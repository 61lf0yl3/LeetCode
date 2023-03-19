class Solution {
    int[] nums;
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        this.nums = nums;
        int max1 = dfs(new Integer[nums.length], 1, nums.length-1);
        int max2 = dfs(new Integer[nums.length], 0, nums.length-2);
        return Math.max(max1, max2) ;
    }
    
    private int dfs(Integer[] memo, int start, int i) {
        if (i < start) {
            return 0;
        }
        if (memo[i] == null) {
            memo[i] = Math.max(dfs(memo, start, i-2)+nums[i], dfs(memo, start, i-1));
        }
        return memo[i];
    }
}