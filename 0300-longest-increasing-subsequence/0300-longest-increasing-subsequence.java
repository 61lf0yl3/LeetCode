class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] memo = new int[nums.length];
        Arrays.fill(memo, 1);
        for (int i = 0; i < nums.length; i++) {
            dfs(nums, i, memo);
        }
        
        int res = 0;
        for (int num : memo) {
            res = Math.max(res, num);
        }
        return res;
    }
    
    private int dfs(int[] nums, int i, int[] memo) {
        if (i > nums.length) {
            return 0;
        }
        if (memo[i] != 1) {
            return memo[i];
        }
        for (int j = i; j < nums.length; j++) {
            if (nums[j] > nums[i]) {
                memo[i] = Math.max(memo[i], dfs(nums, j, memo)+1);
            }
        }
        return memo[i];
    }
}