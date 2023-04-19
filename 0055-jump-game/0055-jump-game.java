class Solution {
    public boolean canJump(int[] nums) {
        boolean[] dp = new boolean[nums.length];
        dp[nums.length-1] = true;
        for (int i = nums.length-2; i >= 0; i--) {
            for (int j = 1; j <= nums[i]; j++) {
                if (dp[i+j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[0];
    }
    
//     private boolean dfs(int[] nums, int i, Boolean[] memo) {
//         if (i >= nums.length-1) {
//             return true;
//         }
        
//         if (memo[i] == null) {
//             for (int j = 1; j <= nums[i]; j++) {
//                 if (dfs(nums, i+j, memo)) {
//                     memo[i] = true;
//                     return memo[i];
//                 }
//             }
//             memo[i] = false;
//         }
//         return memo[i];
//     }
}