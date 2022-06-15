class Solution {
    
    public int jump(int[] nums) {
        int res = 0;
        int currentEnd = 0;
        int maxJump = 0;
        for (int i = 0; i < nums.length-1; i++) {
            maxJump = Math.max(maxJump, nums[i]+i);
            if (i == currentEnd) {
                res++;
                currentEnd = maxJump;
            }
        }
        
        return res;
    }

}