class Solution {
    public boolean canJump(int[] nums) {
        int reachable = nums.length-1;
        
        for (int i = nums.length-2; i >= 0; i--) {
            if (reachable-i <= nums[i]) {
                reachable = i;
            }
            
        }
        return reachable == 0;
    }

}