class Solution {
    
    public int rob(int[] nums) {
        int n = nums.length;
        int[] memo = new int[n+1];
        memo[n-1] = nums[n-1];
        for (int i = nums.length-2; i >= 0; i--) {
            memo[i] = Math.max(memo[i+2]+nums[i], memo[i+1]);
        }
        
        return memo[0];
    }
    
}