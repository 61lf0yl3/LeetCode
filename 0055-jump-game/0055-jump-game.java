class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        int reachable = nums[0];
        
        for (int i = 1; i < nums.length-1; i++) {
            if (reachable+i-1 >= i) {
                reachable = Math.max(reachable-1, nums[i]);
            } else {
                return false;
            }
        }
        return reachable > 0;
    }

}